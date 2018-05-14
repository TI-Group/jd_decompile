package org.apache.http.entity.mime.content;

/* compiled from: TbsSdkJava */
public interface ContentDescriptor {
    String getCharset();

    long getContentLength();

    String getMediaType();

    String getMimeType();

    String getSubType();

    String getTransferEncoding();
}
