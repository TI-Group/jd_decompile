package com.kepler.jd.Listener;

/* compiled from: TbsSdkJava */
public interface LoginListener<T> {
    void authFailed(int i);

    void authSuccess(T t);
}
