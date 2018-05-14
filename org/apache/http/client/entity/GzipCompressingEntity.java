package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public class GzipCompressingEntity extends HttpEntityWrapper {
    private static final String GZIP_CODEC = "gzip";

    public GzipCompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public Header getContentEncoding() {
        return new BasicHeader("Content-Encoding", GZIP_CODEC);
    }

    public long getContentLength() {
        return -1;
    }

    public boolean isChunked() {
        return true;
    }

    public InputStream getContent() throws IOException {
        throw new UnsupportedOperationException();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        OutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        this.wrappedEntity.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
