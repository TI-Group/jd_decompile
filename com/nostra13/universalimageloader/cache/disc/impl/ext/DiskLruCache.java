package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public void write(int i) throws IOException {
        }
    };
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new Callable<Void>() {
        public Void call() throws Exception {
            synchronized (DiskLruCache.this) {
                if (DiskLruCache.this.journalWriter == null) {
                } else {
                    DiskLruCache.this.trimToSize();
                    DiskLruCache.this.trimToFileCount();
                    if (DiskLruCache.this.journalRebuildRequired()) {
                        DiskLruCache.this.rebuildJournal();
                        DiskLruCache.this.redundantOpCount = 0;
                    }
                }
            }
            return null;
        }
    };
    private final File directory;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private int fileCount = 0;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75f, true);
    private int maxFileCount;
    private long maxSize;
    private long nextSequenceNumber = 0;
    private int redundantOpCount;
    private long size = 0;
    private final int valueCount;

    /* compiled from: TbsSdkJava */
    public final class Editor {
        private boolean committed;
        private final Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        /* compiled from: TbsSdkJava */
        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    Editor.this.hasErrors = true;
                }
            }
        }

        private Editor(Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[DiskLruCache.this.valueCount];
        }

        public InputStream newInputStream(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (this.entry.readable) {
                    try {
                        InputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(i));
                        return fileInputStream;
                    } catch (FileNotFoundException e) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }

        public String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            return newInputStream != null ? DiskLruCache.inputStreamToString(newInputStream) : null;
        }

        public OutputStream newOutputStream(int i) throws IOException {
            OutputStream access$2100;
            synchronized (DiskLruCache.this) {
                File dirtyFile;
                OutputStream fileOutputStream;
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                dirtyFile = this.entry.getDirtyFile(i);
                try {
                    fileOutputStream = new FileOutputStream(dirtyFile);
                } catch (FileNotFoundException e) {
                    DiskLruCache.this.directory.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException e2) {
                        access$2100 = DiskLruCache.NULL_OUTPUT_STREAM;
                    }
                }
                access$2100 = new FaultHidingOutputStream(fileOutputStream);
            }
            return access$2100;
        }

        public void set(int i, String str) throws IOException {
            Closeable outputStreamWriter;
            Throwable th;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i), Util.UTF_8);
                try {
                    outputStreamWriter.write(str);
                    Util.closeQuietly(outputStreamWriter);
                } catch (Throwable th2) {
                    th = th2;
                    Util.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
                Util.closeQuietly(outputStreamWriter);
                throw th;
            }
        }

        public void commit() throws IOException {
            if (this.hasErrors) {
                DiskLruCache.this.completeEdit(this, false);
                DiskLruCache.this.remove(this.entry.key);
            } else {
                DiskLruCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }

        public void abort() throws IOException {
            DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (!this.committed) {
                try {
                    abort();
                } catch (IOException e) {
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private final class Entry {
        private Editor currentEditor;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
        }

        public String getLengths() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.lengths) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        private void setLengths(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.lengths[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw invalidLengths(strArr);
                }
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File getCleanFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + "" + i);
        }

        public File getDirtyFile(int i) {
            return new File(DiskLruCache.this.directory, this.key + "" + i + ".tmp");
        }
    }

    /* compiled from: TbsSdkJava */
    public final class Snapshot implements Closeable {
        private File[] files;
        private final InputStream[] ins;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Snapshot(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.ins = inputStreamArr;
            this.lengths = jArr;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public File getFile(int i) {
            return this.files[i];
        }

        public InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public String getString(int i) throws IOException {
            return DiskLruCache.inputStreamToString(getInputStream(i));
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public void close() {
            for (Closeable closeQuietly : this.ins) {
                Util.closeQuietly(closeQuietly);
            }
        }
    }

    private DiskLruCache(File file, int i, int i2, long j, int i3) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.maxFileCount = i3;
    }

    public static DiskLruCache open(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j, i3);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.US_ASCII));
                    return diskLruCache;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            diskLruCache = new DiskLruCache(file, i, i2, j, i3);
            diskLruCache.rebuildJournal();
            return diskLruCache;
        }
    }

    private void readJournal() throws IOException {
        Closeable strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        int i;
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (MAGIC.equals(readLine) && "1".equals(readLine2) && Integer.toString(this.appVersion).equals(readLine3) && Integer.toString(this.valueCount).equals(readLine4) && "".equals(readLine5)) {
                i = 0;
                while (true) {
                    readJournalLine(strictLineReader.readLine());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (EOFException e) {
            this.redundantOpCount = i - this.lruEntries.size();
            Util.closeQuietly(strictLineReader);
        } catch (Throwable th) {
            Util.closeQuietly(strictLineReader);
        }
    }

    private void readJournalLine(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == REMOVE.length() && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        Entry entry = (Entry) this.lruEntries.get(str2);
        if (entry == null) {
            entry = new Entry(str2);
            this.lruEntries.put(str2, entry);
        }
        if (indexOf2 != -1 && indexOf == CLEAN.length() && str.startsWith(CLEAN)) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
        } else if (indexOf2 == -1 && indexOf == DIRTY.length() && str.startsWith(DIRTY)) {
            entry.currentEditor = new Editor(entry);
        } else if (indexOf2 != -1 || indexOf != READ.length() || !str.startsWith(READ)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i;
            if (entry.currentEditor == null) {
                for (i = 0; i < this.valueCount; i++) {
                    this.size += entry.lengths[i];
                    this.fileCount++;
                }
            } else {
                entry.currentEditor = null;
                for (i = 0; i < this.valueCount; i++) {
                    deleteIfExists(entry.getCleanFile(i));
                    deleteIfExists(entry.getDirtyFile(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            this.journalWriter.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + entry.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        int i;
        Snapshot snapshot = null;
        synchronized (this) {
            checkNotClosed();
            validateKey(str);
            Entry entry = (Entry) this.lruEntries.get(str);
            if (entry != null) {
                if (entry.readable) {
                    File[] fileArr = new File[this.valueCount];
                    r7 = new InputStream[this.valueCount];
                    int i2 = 0;
                    while (i2 < this.valueCount) {
                        try {
                            File cleanFile = entry.getCleanFile(i2);
                            fileArr[i2] = cleanFile;
                            r7[i2] = new FileInputStream(cleanFile);
                            i2++;
                        } catch (FileNotFoundException e) {
                            i = 0;
                            while (i < this.valueCount && r7[i] != null) {
                                InputStream[] inputStreamArr;
                                Util.closeQuietly(inputStreamArr[i]);
                                i++;
                            }
                        }
                    }
                    this.redundantOpCount++;
                    this.journalWriter.append("READ " + str + '\n');
                    if (journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    snapshot = new Snapshot(str, entry.sequenceNumber, fileArr, inputStreamArr, entry.lengths);
                }
            }
        }
        return snapshot;
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    private synchronized Editor edit(String str, long j) throws IOException {
        Editor editor;
        checkNotClosed();
        validateKey(str);
        Entry entry = (Entry) this.lruEntries.get(str);
        if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
            Entry entry2;
            if (entry == null) {
                entry = new Entry(str);
                this.lruEntries.put(str, entry);
                entry2 = entry;
            } else if (entry.currentEditor != null) {
                editor = null;
            } else {
                entry2 = entry;
            }
            editor = new Editor(entry2);
            entry2.currentEditor = editor;
            this.journalWriter.write("DIRTY " + str + '\n');
            this.journalWriter.flush();
        } else {
            editor = null;
        }
        return editor;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized int getMaxFileCount() {
        return this.maxFileCount;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }

    public synchronized long fileCount() {
        return (long) this.fileCount;
    }

    private synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            Entry access$1500 = editor.entry;
            if (access$1500.currentEditor != editor) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!access$1500.readable) {
                    int i2 = 0;
                    while (i2 < this.valueCount) {
                        if (!editor.written[i2]) {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!access$1500.getDirtyFile(i2).exists()) {
                            editor.abort();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.valueCount) {
                File dirtyFile = access$1500.getDirtyFile(i);
                if (!z) {
                    deleteIfExists(dirtyFile);
                } else if (dirtyFile.exists()) {
                    File cleanFile = access$1500.getCleanFile(i);
                    dirtyFile.renameTo(cleanFile);
                    long j = access$1500.lengths[i];
                    long length = cleanFile.length();
                    access$1500.lengths[i] = length;
                    this.size = (this.size - j) + length;
                    this.fileCount++;
                }
                i++;
            }
            this.redundantOpCount++;
            access$1500.currentEditor = null;
            if ((access$1500.readable | z) != 0) {
                access$1500.readable = true;
                this.journalWriter.write("CLEAN " + access$1500.key + access$1500.getLengths() + '\n');
                if (z) {
                    long j2 = this.nextSequenceNumber;
                    this.nextSequenceNumber = 1 + j2;
                    access$1500.sequenceNumber = j2;
                }
            } else {
                this.lruEntries.remove(access$1500.key);
                this.journalWriter.write("REMOVE " + access$1500.key + '\n');
            }
            this.journalWriter.flush();
            if (this.size > this.maxSize || this.fileCount > this.maxFileCount || journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
        }
    }

    private boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public synchronized boolean remove(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            checkNotClosed();
            validateKey(str);
            Entry entry = (Entry) this.lruEntries.get(str);
            if (entry == null || entry.currentEditor != null) {
                z = false;
            } else {
                while (i < this.valueCount) {
                    File cleanFile = entry.getCleanFile(i);
                    if (!cleanFile.exists() || cleanFile.delete()) {
                        this.size -= entry.lengths[i];
                        this.fileCount--;
                        entry.lengths[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + cleanFile);
                    }
                }
                this.redundantOpCount++;
                this.journalWriter.append("REMOVE " + str + '\n');
                this.lruEntries.remove(str);
                if (journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        trimToFileCount();
        this.journalWriter.flush();
    }

    public synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            trimToFileCount();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    private void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    private void trimToFileCount() throws IOException {
        while (this.fileCount > this.maxFileCount) {
            remove((String) ((java.util.Map.Entry) this.lruEntries.entrySet().iterator().next()).getKey());
        }
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    private static String inputStreamToString(InputStream inputStream) throws IOException {
        return Util.readFully(new InputStreamReader(inputStream, Util.UTF_8));
    }
}
