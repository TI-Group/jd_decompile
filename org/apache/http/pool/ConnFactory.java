package org.apache.http.pool;

import java.io.IOException;

/* compiled from: TbsSdkJava */
public interface ConnFactory<T, C> {
    C create(T t) throws IOException;
}
