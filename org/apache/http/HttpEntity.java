package org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TbsSdkJava */
public interface HttpEntity {
    @Deprecated
    void consumeContent() throws IOException;

    InputStream getContent() throws IOException, IllegalStateException;

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream) throws IOException;
}
