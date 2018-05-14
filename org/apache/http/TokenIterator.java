package org.apache.http;

import java.util.Iterator;

/* compiled from: TbsSdkJava */
public interface TokenIterator extends Iterator<Object> {
    boolean hasNext();

    String nextToken();
}
