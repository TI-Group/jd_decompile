package org.apache.http.entity;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: TbsSdkJava */
public interface ContentProducer {
    void writeTo(OutputStream outputStream) throws IOException;
}
