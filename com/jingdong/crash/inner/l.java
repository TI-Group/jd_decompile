package com.jingdong.crash.inner;

final class l implements m {
    l() {
    }

    public void a(String str) {
        synchronized (this) {
            k.e = str;
            k.f = true;
            notifyAll();
        }
    }
}
