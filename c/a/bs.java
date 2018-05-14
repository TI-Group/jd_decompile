package c.a;

/* compiled from: TbsSdkJava */
public class bs {
    private static int a = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(bo boVar, byte b) throws az {
        a(boVar, b, a);
    }

    public static void a(bo boVar, byte b, int i) throws az {
        int i2 = 0;
        if (i <= 0) {
            throw new az("Maximum skip depth exceeded");
        }
        switch (b) {
            case (byte) 2:
                boVar.p();
                return;
            case (byte) 3:
                boVar.q();
                return;
            case (byte) 4:
                boVar.u();
                return;
            case (byte) 6:
                boVar.r();
                return;
            case (byte) 8:
                boVar.s();
                return;
            case (byte) 10:
                boVar.t();
                return;
            case (byte) 11:
                boVar.w();
                return;
            case (byte) 12:
                boVar.f();
                while (true) {
                    bl h = boVar.h();
                    if (h.b == (byte) 0) {
                        boVar.g();
                        return;
                    } else {
                        a(boVar, h.b, i - 1);
                        boVar.i();
                    }
                }
            case (byte) 13:
                bn j = boVar.j();
                while (i2 < j.c) {
                    a(boVar, j.a, i - 1);
                    a(boVar, j.b, i - 1);
                    i2++;
                }
                boVar.k();
                return;
            case (byte) 14:
                bt n = boVar.n();
                while (i2 < n.b) {
                    a(boVar, n.a, i - 1);
                    i2++;
                }
                boVar.o();
                return;
            case (byte) 15:
                bm l = boVar.l();
                while (i2 < l.b) {
                    a(boVar, l.a, i - 1);
                    i2++;
                }
                boVar.m();
                return;
            default:
                return;
        }
    }
}
