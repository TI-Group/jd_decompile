package org.greenrobot.eventbus;

/* compiled from: TbsSdkJava */
class a implements Runnable {
    private final i a = new i();
    private final c b;

    a(c cVar) {
        this.b = cVar;
    }

    public void a(n nVar, Object obj) {
        this.a.a(h.a(nVar, obj));
        this.b.b().execute(this);
    }

    public void run() {
        h a = this.a.a();
        if (a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.b.a(a);
    }
}
