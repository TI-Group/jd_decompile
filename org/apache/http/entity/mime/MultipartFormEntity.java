package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: TbsSdkJava */
class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final Header contentType;
    private final AbstractMultipartForm multipart;

    MultipartFormEntity(AbstractMultipartForm abstractMultipartForm, String str, long j) {
        this.multipart = abstractMultipartForm;
        this.contentType = new BasicHeader("Content-Type", str);
        this.contentLength = j;
    }

    AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    public boolean isRepeatable() {
        return this.contentLength != -1;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public Header getContentEncoding() {
        return null;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.multipart.writeTo(outputStream);
    }
}
