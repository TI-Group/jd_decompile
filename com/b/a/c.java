package com.b.a;

import android.content.Context;
import c.a.aq;

/* compiled from: TbsSdkJava */
public class c {

    /* compiled from: TbsSdkJava */
    public static class h {
        public boolean a(boolean z) {
            return true;
        }

        public boolean a() {
            return true;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class a extends h {
        private final long a = 15000;
        private c.a.c b;

        public a(c.a.c cVar) {
            this.b = cVar;
        }

        public boolean a(boolean z) {
            if (System.currentTimeMillis() - this.b.c >= 15000) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class b extends h {
        private c.a.j a;
        private c.a.c b;

        public b(c.a.c cVar, c.a.j jVar) {
            this.b = cVar;
            this.a = jVar;
        }

        public boolean a(boolean z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b.c >= this.a.a()) {
                return true;
            }
            return false;
        }

        public boolean a() {
            return this.a.b();
        }
    }

    /* compiled from: TbsSdkJava */
    public static class c extends h {
        private long a;
        private long b = 0;

        public c(int i) {
            this.a = (long) i;
            this.b = System.currentTimeMillis();
        }

        public boolean a(boolean z) {
            if (System.currentTimeMillis() - this.b >= this.a) {
                return true;
            }
            return false;
        }

        public boolean a() {
            return System.currentTimeMillis() - this.b < this.a;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class d extends h {
        public boolean a(boolean z) {
            return z;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class e extends h {
        private static long a = 90000;
        private static long b = 86400000;
        private long c;
        private c.a.c d;

        public e(c.a.c cVar, long j) {
            this.d = cVar;
            a(j);
        }

        public boolean a(boolean z) {
            if (System.currentTimeMillis() - this.d.c >= this.c) {
                return true;
            }
            return false;
        }

        public void a(long j) {
            if (j < a || j > b) {
                this.c = a;
            } else {
                this.c = j;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    public static class f extends h {
        private long a = 86400000;
        private c.a.c b;

        public f(c.a.c cVar) {
            this.b = cVar;
        }

        public boolean a(boolean z) {
            if (System.currentTimeMillis() - this.b.c >= this.a) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class g extends h {
        public boolean a(boolean z) {
            return true;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class i extends h {
        private Context a = null;

        public i(Context context) {
            this.a = context;
        }

        public boolean a(boolean z) {
            return aq.f(this.a);
        }
    }

    /* compiled from: TbsSdkJava */
    public static class j extends h {
        private final long a = 10800000;
        private c.a.c b;

        public j(c.a.c cVar) {
            this.b = cVar;
        }

        public boolean a(boolean z) {
            if (System.currentTimeMillis() - this.b.c >= 10800000) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            default:
                return false;
        }
    }
}
