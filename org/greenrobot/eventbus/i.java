package org.greenrobot.eventbus;

/* compiled from: TbsSdkJava */
final class i {
    private h a;
    private h b;

    i() {
    }

    synchronized void a(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.b != null) {
            this.b.c = hVar;
            this.b = hVar;
        } else if (this.a == null) {
            this.b = hVar;
            this.a = hVar;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    synchronized h a() {
        h hVar;
        hVar = this.a;
        if (this.a != null) {
            this.a = this.a.c;
            if (this.a == null) {
                this.b = null;
            }
        }
        return hVar;
    }

    synchronized h a(int i) throws InterruptedException {
        if (this.a == null) {
            wait((long) i);
        }
        return a();
    }
}
