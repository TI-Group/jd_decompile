package okhttp3.internal.io;

import b.m;
import b.r;
import b.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        public s source(File file) throws FileNotFoundException {
            return m.a(file);
        }

        public r sink(File file) throws FileNotFoundException {
            try {
                return m.b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return m.b(file);
            }
        }

        public r appendingSink(File file) throws FileNotFoundException {
            try {
                return m.c(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return m.c(file);
            }
        }

        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long size(File file) {
            return file.length();
        }

        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    r appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    r sink(File file) throws FileNotFoundException;

    long size(File file);

    s source(File file) throws FileNotFoundException;
}
