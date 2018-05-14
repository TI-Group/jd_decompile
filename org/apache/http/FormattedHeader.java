package org.apache.http;

import org.apache.http.util.CharArrayBuffer;

/* compiled from: TbsSdkJava */
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
