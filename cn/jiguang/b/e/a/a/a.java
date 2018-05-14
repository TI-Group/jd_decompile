package cn.jiguang.b.e.a.a;

import android.content.Context;
import cn.jiguang.api.JResponse;
import cn.jiguang.b.e.a.b;
import cn.jiguang.b.e.a.c;
import cn.jiguang.b.e.a.e;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import java.nio.ByteBuffer;

public final class a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 12;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "dM \u000e\u0001O`+\u0010";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00a2;
            case 1: goto L_0x00a6;
            case 2: goto L_0x00aa;
            case 3: goto L_0x00ae;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "^o=\u0010\t|k<\u0013\u0003@}**\u0002La:\r\b\u000e#o\u000b\tOju";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "{`$\r\u0003Y`o\u0000\u0003Cc.\r\b\u000eh \u0011L^o=\u0010\u0005@io\n\u0002La:\r\b\u0000";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "k|=\f\u001e\u0014.=\u0006\u000fKg9\u0006\b\u000el \u0007\u0015\u0003b*\r\u000bZfo\u0010\u0004A|;C\u0018Fo!C\u000fAc\"\f\u0002\u000ef*\u0002\b\u0003b*\r\u000bZfa";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Za;\u0002\u0000\u000el6\u0017\t].bC";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "^o=\u0010\t|k<\u0013\u0003@}**\u0002La:\r\b\u000e#o\u0016\u0002Kv,\u0006\u001cZk+C\t\u0014";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "k|=\f\u001e\u0014.;\f\u0018Ob\r\u001a\u0018K}o\u000f\t@i;\u000bLK|=\f\u001e\u000ey&\u0017\u0004\u000e` C\t@m=\u001a\u001cZk+M";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "k|=\f\u001e\u0014.;\f\u0018Ob\r\u001a\u0018K}o\u000f\t@i;\u000bLK|=\f\u001e\u000ey&\u0017\u0004\u000ek!\u0000\u001eW~;\u0006\b\u0000";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "G}\n\r\u000f\\w?\u0017";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "^o=\u0010\tJ.'\u0006\rJ.bC";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "om;\n\u0003@.bC\u001eKm*\n\u001aKj\f\f\u0001Co!\u0007L\u0003.,\u000e\b\u0014";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "k|=\f\u001e\u0014.;\f\u0018Ob\r\u001a\u0018K}o\u000f\t@i;\u000bLK|=\f\u001e\u000ey&\u0017\u0004\u000ek!\u0000\u001eW~;\u0006\b\u0002.=\u0006\u0018[|!C\u0002[b#";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00a2:
        r9 = 46;
        goto L_0x0020;
    L_0x00a6:
        r9 = 14;
        goto L_0x0020;
    L_0x00aa:
        r9 = 79;
        goto L_0x0020;
    L_0x00ae:
        r9 = 99;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.e.a.a.a.<clinit>():void");
    }

    public static JResponse a(c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            d.i(z[0], "");
            return null;
        }
        d.a(z[0], new StringBuilder(z[1]).append(cVar.toString()).toString());
        switch (cVar.c) {
            case 0:
                return new cn.jiguang.b.e.a.d(cVar, byteBuffer);
            case 1:
                return new c(cVar, byteBuffer);
            case 19:
                return new cn.jiguang.b.e.a.a(cVar, byteBuffer);
            case 25:
                return new b(cVar, byteBuffer);
            case 26:
                return new e(cVar, byteBuffer);
            default:
                d.g(z[0], z[2]);
                return null;
        }
    }

    public static JResponse a(byte[] bArr) {
        c cVar;
        ByteBuffer wrap;
        d.c(z[0], new StringBuilder(z[4]).append(j.a(bArr)).toString());
        Object obj = new byte[20];
        System.arraycopy(bArr, 0, obj, 0, 20);
        if ((obj[0] & 128) > 0) {
            try {
                String a = cn.jiguang.b.f.a.a.a();
                cVar = new c(false, obj);
                int i = cVar.a - 20;
                if (i < 0) {
                    d.h(z[0], z[11]);
                    return null;
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 20, bArr2, 0, i);
                wrap = ByteBuffer.wrap(cn.jiguang.b.f.a.a.a(a, bArr2));
            } catch (Exception e) {
                d.i(z[0], new StringBuilder(z[5]).append(e.getMessage()).toString());
                return null;
            }
        }
        cVar = new c(false, obj);
        Object obj2 = new byte[108];
        System.arraycopy(bArr, 20, obj2, 0, 108);
        wrap = ByteBuffer.wrap(obj2);
        d.c(z[0], new StringBuilder(z[9]).append(cVar.toString()).toString());
        d.d(z[0], new StringBuilder(z[10]).append(cVar.c).toString());
        return a(cVar, wrap);
    }

    public static boolean a(Context context, byte[] bArr) {
        d.c(z[0], new StringBuilder(z[4]).append(j.a(bArr)).toString());
        if (bArr.length < 20) {
            d.h(z[0], z[3]);
            return false;
        }
        Object obj = new byte[20];
        System.arraycopy(bArr, 0, obj, 0, 20);
        int i = obj[0] & 128;
        d.c(z[0], new StringBuilder(z[8]).append(i).toString());
        int i2;
        if (i > 0) {
            try {
                String a = cn.jiguang.b.f.a.a.a();
                c cVar = new c(false, obj);
                i2 = cVar.a - 20;
                if (i2 < 0 || bArr.length < 20) {
                    d.h(z[0], z[7]);
                    return false;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 20, bArr2, 0, i2);
                ByteBuffer wrap = ByteBuffer.wrap(cn.jiguang.b.f.a.a.a(a, bArr2));
                cn.jiguang.b.d.b.a();
                cn.jiguang.b.d.b.a(context, cVar, wrap);
            } catch (Exception e) {
                d.g(z[0], new StringBuilder(z[5]).append(e.getMessage()).toString());
                return false;
            }
        }
        c cVar2 = new c(false, obj);
        i2 = bArr.length - 20;
        if (i2 < 0 || bArr.length < 20) {
            d.h(z[0], z[6]);
            return false;
        }
        Object obj2 = new byte[i2];
        System.arraycopy(bArr, 20, obj2, 0, i2);
        ByteBuffer wrap2 = ByteBuffer.wrap(obj2);
        cn.jiguang.b.d.b.a();
        cn.jiguang.b.d.b.a(context, cVar2, wrap2);
        return true;
    }
}
