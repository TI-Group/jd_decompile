package com.jingdong.crash.inner;

final class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    t(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void run() {
        new h().a(this.a, this.b);
    }
}
