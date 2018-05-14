package org.apache.http;

/* compiled from: TbsSdkJava */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
