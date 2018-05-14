package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BufferedHttpEntity extends HttpEntityWrapper {
    private final byte[] buffer;

    public BufferedHttpEntity(HttpEntity httpEntity) throws IOException {
        super(httpEntity);
        if (!httpEntity.isRepeatable() || httpEntity.getContentLength() < 0) {
            this.buffer = EntityUtils.toByteArray(httpEntity);
        } else {
            this.buffer = null;
        }
    }

    public long getContentLength() {
        if (this.buffer != null) {
            return (long) this.buffer.length;
        }
        return super.getContentLength();
    }

    public InputStream getContent() throws IOException {
        if (this.buffer != null) {
            return new ByteArrayInputStream(this.buffer);
        }
        return super.getContent();
    }

    public boolean isChunked() {
        return this.buffer == null && super.isChunked();
    }

    public boolean isRepeatable() {
        return true;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        if (this.buffer != null) {
            outputStream.write(this.buffer);
        } else {
            super.writeTo(outputStream);
        }
    }

    public boolean isStreaming() {
        return this.buffer == null && super.isStreaming();
    }
}
