package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    public EntityTemplate(ContentProducer contentProducer) {
        this.contentproducer = (ContentProducer) Args.notNull(contentProducer, "Content producer");
    }

    public long getContentLength() {
        return -1;
    }

    public InputStream getContent() throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public boolean isRepeatable() {
        return true;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        this.contentproducer.writeTo(outputStream);
    }

    public boolean isStreaming() {
        return false;
    }
}
