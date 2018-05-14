package com.jingdong.crash.inner;

class i implements al {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void a(int i, String str) {
        if (i == 0) {
            ah.a("NetWorkHelper", "data is " + str.toString());
            this.a.a(str);
        }
    }

    public void b(int i, String str) {
        ah.a("NetWorkHelper", "crash sdk get serverconfig fail " + str);
    }
}
