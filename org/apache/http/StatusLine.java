package org.apache.http;

/* compiled from: TbsSdkJava */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
