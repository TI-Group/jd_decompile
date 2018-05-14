package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class AbstractHttpEntity implements HttpEntity {
    protected static final int OUTPUT_BUFFER_SIZE = 4096;
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    protected AbstractHttpEntity() {
    }

    public Header getContentType() {
        return this.contentType;
    }

    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public void setContentType(Header header) {
        this.contentType = header;
    }

    public void setContentType(String str) {
        Header header = null;
        if (str != null) {
            header = new BasicHeader("Content-Type", str);
        }
        setContentType(header);
    }

    public void setContentEncoding(Header header) {
        this.contentEncoding = header;
    }

    public void setContentEncoding(String str) {
        Header header = null;
        if (str != null) {
            header = new BasicHeader("Content-Encoding", str);
        }
        setContentEncoding(header);
    }

    public void setChunked(boolean z) {
        this.chunked = z;
    }

    @Deprecated
    public void consumeContent() throws IOException {
    }
}
