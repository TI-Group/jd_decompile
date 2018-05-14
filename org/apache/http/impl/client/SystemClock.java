package org.apache.http.impl.client;

/* compiled from: TbsSdkJava */
class SystemClock implements Clock {
    SystemClock() {
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
