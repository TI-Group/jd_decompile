package com.jingdong.crash.inner;

class s implements al {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void a(int i, String str) {
        if (ah.b) {
            ah.a("CrashController", " -->> onEnd() code:" + i);
        }
        q.e = true;
        if (q.d != null && q.d.exists()) {
            q.d.delete();
        }
        if (this.a.a != null) {
            this.a.a.a(true);
        }
    }

    public void b(int i, String str) {
        if (ah.b) {
            ah.a("CrashController", " -->> onError() error:" + str);
        }
        q.e = true;
        if (this.a.a != null) {
            this.a.a.a(false);
        }
    }
}
