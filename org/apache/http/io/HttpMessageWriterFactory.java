package org.apache.http.io;

import org.apache.http.HttpMessage;

/* compiled from: TbsSdkJava */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
