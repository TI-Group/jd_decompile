package org.apache.http;

import java.util.Iterator;

/* compiled from: TbsSdkJava */
public interface HeaderElementIterator extends Iterator<Object> {
    boolean hasNext();

    HeaderElement nextElement();
}
