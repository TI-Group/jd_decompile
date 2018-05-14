package jd.wjlogin_sdk.util;

import android.content.Context;
import android.os.Process;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class ACache {
    private static final int MAX_COUNT = 100000;
    private static final int MAX_SIZE = 30000000;
    private static Map<String, ACache> instanceMap = new HashMap();
    private ACacheManager mCache;

    /* compiled from: TbsSdkJava */
    public class ACacheManager {
        private final AtomicInteger cacheCount;
        protected File cacheDir;
        private final AtomicLong cacheSize;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates;
        private final int sizeLimit;

        private ACacheManager(File file, int i, int i2) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = i;
            this.countLimit = i2;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        private void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() {
                public void run() {
                    int i = 0;
                    File[] listFiles = ACacheManager.this.cacheDir.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i < length) {
                            File file = listFiles[i];
                            i3 = (int) (((long) i3) + ACacheManager.this.calculateSize(file));
                            i2++;
                            ACacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                            i++;
                        }
                        ACacheManager.this.cacheSize.set((long) i3);
                        ACacheManager.this.cacheCount.set(i2);
                    }
                }
            }).start();
        }

        private void put(File file) {
            int i = this.cacheCount.get();
            while (i + 1 > this.countLimit) {
                this.cacheSize.addAndGet(-removeNext());
                i = this.cacheCount.addAndGet(-1);
            }
            this.cacheCount.addAndGet(1);
            long calculateSize = calculateSize(file);
            long j = this.cacheSize.get();
            while (j + calculateSize > ((long) this.sizeLimit)) {
                j = this.cacheSize.addAndGet(-removeNext());
            }
            this.cacheSize.addAndGet(calculateSize);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(file, valueOf);
        }

        private File get(String str) {
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(newFile, valueOf);
            return newFile;
        }

        private File newFile(String str) {
            return new File(this.cacheDir, new StringBuilder(String.valueOf(str.hashCode())).toString());
        }

        private boolean remove(String str) {
            return get(str).delete();
        }

        private void clear() {
            this.lastUsageDates.clear();
            this.cacheSize.set(0);
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        private long removeNext() {
            if (this.lastUsageDates.isEmpty()) {
                return 0;
            }
            File file;
            Set<Entry> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                file = null;
                Long l = null;
                for (Entry entry : entrySet) {
                    if (file == null) {
                        file = (File) entry.getKey();
                        l = (Long) entry.getValue();
                    } else {
                        Long l2 = (Long) entry.getValue();
                        if (l2.longValue() < l.longValue()) {
                            file = (File) entry.getKey();
                            l = l2;
                        }
                    }
                }
            }
            long calculateSize = calculateSize(file);
            if (!file.delete()) {
                return calculateSize;
            }
            this.lastUsageDates.remove(file);
            return calculateSize;
        }

        private long calculateSize(File file) {
            return file.length();
        }
    }

    /* compiled from: TbsSdkJava */
    private static class Utils {
        private static final char mSeparator = ' ';

        private Utils() {
        }

        private static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        private static boolean isDue(byte[] bArr) {
            String[] dateInfoFromDate = getDateInfoFromDate(bArr);
            if (dateInfoFromDate != null && dateInfoFromDate.length == 2) {
                if (System.currentTimeMillis() > (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000) + Long.valueOf(dateInfoFromDate[0]).longValue()) {
                    return true;
                }
            }
            return false;
        }

        private static String newStringWithDateInfo(int i, String str) {
            return createDateInfo(i) + str;
        }

        private static byte[] newByteArrayWithDateInfo(int i, byte[] bArr) {
            Object bytes = createDateInfo(i).getBytes();
            Object obj = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, obj, 0, bytes.length);
            System.arraycopy(bArr, 0, obj, bytes.length, bArr.length);
            return obj;
        }

        private static String clearDateInfo(String str) {
            if (str == null || !hasDateInfo(str.getBytes())) {
                return str;
            }
            return str.substring(str.indexOf(32) + 1, str.length());
        }

        private static byte[] clearDateInfo(byte[] bArr) {
            if (hasDateInfo(bArr)) {
                return copyOfRange(bArr, indexOf(bArr, mSeparator), bArr.length);
            }
            return bArr;
        }

        private static boolean hasDateInfo(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == (byte) 45 && indexOf(bArr, mSeparator) > 14;
        }

        private static String[] getDateInfoFromDate(byte[] bArr) {
            if (!hasDateInfo(bArr)) {
                return null;
            }
            String str = new String(copyOfRange(bArr, 0, 13));
            String str2 = new String(copyOfRange(bArr, 14, indexOf(bArr, mSeparator)));
            return new String[]{str, str2};
        }

        private static int indexOf(byte[] bArr, char c) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(i)).append(" > ").append(i2).toString());
            }
            Object obj = new byte[i3];
            System.arraycopy(bArr, i, obj, 0, Math.min(bArr.length - i, i3));
            return obj;
        }

        private static String createDateInfo(int i) {
            return System.currentTimeMillis() + "-" + i + mSeparator;
        }
    }

    public static ACache get(Context context) {
        return get(new File(context.getCacheDir(), Config.LOCAL_FILENAME), (int) MAX_SIZE, (int) MAX_COUNT);
    }

    public static ACache get(File file) {
        return get(file, (int) MAX_SIZE, (int) MAX_COUNT);
    }

    public static ACache get(Context context, int i, int i2) {
        return get(new File(context.getCacheDir(), Config.LOCAL_FILENAME), i, i2);
    }

    public static ACache get(File file, int i, int i2) {
        ACache aCache = (ACache) instanceMap.get(file.getAbsoluteFile() + getPid());
        if (aCache != null) {
            return aCache;
        }
        aCache = new ACache(file, i, i2);
        instanceMap.put(file.getAbsolutePath() + getPid(), aCache);
        return aCache;
    }

    private static String getPid() {
        return "_" + Process.myPid();
    }

    private ACache(File file, int i, int i2) {
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mCache = new ACacheManager(file, i, i2);
    }

    public void put(String str, String str2) {
        IOException e;
        Throwable th;
        File access$5 = this.mCache.newFile(str);
        BufferedWriter bufferedWriter = null;
        BufferedWriter bufferedWriter2;
        try {
            bufferedWriter2 = new BufferedWriter(new FileWriter(access$5), 1024);
            try {
                bufferedWriter2.write(str2);
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.flush();
                        bufferedWriter2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                this.mCache.put(access$5);
            } catch (IOException e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.flush();
                            bufferedWriter2.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    this.mCache.put(access$5);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    this.mCache.put(access$5);
                    throw th;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            bufferedWriter2 = null;
            e22.printStackTrace();
            if (bufferedWriter2 != null) {
                bufferedWriter2.flush();
                bufferedWriter2.close();
            }
            this.mCache.put(access$5);
        } catch (Throwable th3) {
            th = th3;
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            this.mCache.put(access$5);
            throw th;
        }
    }

    public void put(String str, String str2, int i) {
        put(str, Utils.newStringWithDateInfo(i, str2));
    }

    public String getAsString(String str) {
        BufferedReader bufferedReader;
        IOException e;
        Throwable th;
        String str2 = null;
        File access$7 = this.mCache.get(str);
        if (access$7.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(access$7));
                try {
                    String str3 = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str3 = new StringBuilder(String.valueOf(str3)).append(readLine).toString();
                    }
                    if (Utils.isDue(str3)) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        remove(str);
                    } else {
                        str2 = Utils.clearDateInfo(str3);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    }
                } catch (IOException e3) {
                    e22 = e3;
                }
            } catch (IOException e4) {
                e22 = e4;
                bufferedReader = null;
                try {
                    e22.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return str2;
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i) {
        put(str, jSONObject.toString(), i);
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(String str, byte[] bArr) {
        Exception e;
        Throwable th;
        File access$5 = this.mCache.newFile(str);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(access$5);
            try {
                fileOutputStream.write(bArr);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                this.mCache.put(access$5);
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    this.mCache.put(access$5);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    this.mCache.put(access$5);
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            this.mCache.put(access$5);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            this.mCache.put(access$5);
            throw th;
        }
    }

    public void put(byte[] bArr, String str, int i) {
        put(str, Utils.newByteArrayWithDateInfo(i, bArr));
    }

    public byte[] getAsBinary(String str) {
        RandomAccessFile randomAccessFile;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            File access$7 = this.mCache.get(str);
            if (access$7.exists()) {
                randomAccessFile = new RandomAccessFile(access$7, "r");
                try {
                    byte[] bArr2 = new byte[((int) randomAccessFile.length())];
                    randomAccessFile.read(bArr2);
                    if (Utils.isDue(bArr2)) {
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        remove(str);
                    } else {
                        bArr = Utils.clearDateInfo(bArr2);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } else if (null != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e22222) {
                    e22222.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            e.printStackTrace();
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return bArr;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        return bArr;
    }

    public void put(String str, Serializable serializable) {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        Exception e;
        FileOutputStream fileOutputStream2;
        Throwable th;
        ObjectOutputStream objectOutputStream2 = null;
        File access$5 = this.mCache.newFile(str);
        if (access$5.exists()) {
            access$5.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(access$5);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(serializable);
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        objectOutputStream2 = objectOutputStream;
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e7) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream2 = objectOutputStream;
                    objectOutputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                objectOutputStream = null;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                objectOutputStream.close();
                fileOutputStream2.close();
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream2.close();
                fileOutputStream.close();
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            objectOutputStream = null;
            e.printStackTrace();
            objectOutputStream.close();
            fileOutputStream2.close();
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            objectOutputStream2.close();
            fileOutputStream.close();
            throw th;
        }
    }

    public Object getAsObject(String str) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Exception e;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2 = null;
        File access$7 = this.mCache.get(str);
        if (access$7.exists()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(access$7);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        readObject = objectInputStream.readObject();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e222) {
                                    e222.printStackTrace();
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e2222) {
                                    e2222.printStackTrace();
                                }
                            }
                            return readObject;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e22222) {
                                    e22222.printStackTrace();
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e222222) {
                                    e222222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = inputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    return readObject;
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                objectInputStream = inputStream2;
                fileInputStream = inputStream2;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return readObject;
            } catch (Throwable th32) {
                objectInputStream = inputStream2;
                fileInputStream = inputStream2;
                th = th32;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        }
        return readObject;
    }

    public File file(String str) {
        File access$5 = this.mCache.newFile(str);
        return access$5.exists() ? access$5 : null;
    }

    public boolean remove(String str) {
        return this.mCache.remove(str);
    }

    public void clear() {
        this.mCache.clear();
    }
}
