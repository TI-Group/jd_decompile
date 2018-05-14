package org.apache.http;

import java.util.Iterator;

/* compiled from: TbsSdkJava */
public interface HeaderIterator extends Iterator<Object> {
    boolean hasNext();

    Header nextHeader();
}
