package org.apache.http.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MIME;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public class FileBody extends AbstractContentBody {
    private final File file;
    private final String filename;

    @Deprecated
    public FileBody(File file, String str, String str2, String str3) {
        this(file, ContentType.create(str2, str3), str);
    }

    @Deprecated
    public FileBody(File file, String str, String str2) {
        this(file, null, str, str2);
    }

    @Deprecated
    public FileBody(File file, String str) {
        this(file, ContentType.create(str), null);
    }

    public FileBody(File file) {
        this(file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    public FileBody(File file, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(file, "File");
        this.file = file;
        this.filename = str;
    }

    public FileBody(File file, ContentType contentType) {
        this(file, contentType, null);
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
        } finally {
            fileInputStream.close();
        }
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public String getFilename() {
        return this.filename;
    }

    public File getFile() {
        return this.file;
    }
}
