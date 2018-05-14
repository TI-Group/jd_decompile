package org.apache.http.concurrent;

/* compiled from: TbsSdkJava */
public interface FutureCallback<T> {
    void cancelled();

    void completed(T t);

    void failed(Exception exception);
}
