package org.apache.http;

/* compiled from: TbsSdkJava */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
