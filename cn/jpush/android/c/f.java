package cn.jpush.android.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.android.b;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public class f {
    private static volatile f b;
    private static final String[] z;
    private a a;
    private int c = 0;

    /* compiled from: TbsSdkJava */
    private class a {
        private static final String[] z;
        public byte a;
        public String b;
        public long c;
        public byte[] d;
        final /* synthetic */ f e;

        static {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = 1;
            r1 = 0;
            r0 = 3;
            r4 = new java.lang.String[r0];
            r3 = "PF\u0005:\f\u0015\u0002Jx";
            r0 = -1;
            r5 = r4;
            r6 = r4;
            r4 = r1;
        L_0x000b:
            r3 = r3.toCharArray();
            r7 = r3.length;
            if (r7 > r2) goto L_0x0061;
        L_0x0012:
            r8 = r1;
        L_0x0013:
            r9 = r3;
            r10 = r8;
            r13 = r7;
            r7 = r3;
            r3 = r13;
        L_0x0018:
            r12 = r7[r8];
            r11 = r10 % 5;
            switch(r11) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0058;
                case 2: goto L_0x005b;
                case 3: goto L_0x005e;
                default: goto L_0x001f;
            };
        L_0x001f:
            r11 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        L_0x0021:
            r11 = r11 ^ r12;
            r11 = (char) r11;
            r7[r8] = r11;
            r8 = r10 + 1;
            if (r3 != 0) goto L_0x002d;
        L_0x0029:
            r7 = r9;
            r10 = r8;
            r8 = r3;
            goto L_0x0018;
        L_0x002d:
            r7 = r3;
            r3 = r9;
        L_0x002f:
            if (r7 > r8) goto L_0x0013;
        L_0x0031:
            r7 = new java.lang.String;
            r7.<init>(r3);
            r3 = r7.intern();
            switch(r0) {
                case 0: goto L_0x0046;
                case 1: goto L_0x0050;
                default: goto L_0x003d;
            };
        L_0x003d:
            r5[r4] = r3;
            r0 = ",\n\u00028\u0002\u00126\u001b>\u001f\u001a\t\u000529\u0019\u0001>\u001b)\u0019\u0007\u0019$\u001b\u0010\u0013\u00106\u0005,\n\u0016+\r\u0013\u0014\u001a\u000b\u0012\f\u0003J";
            r3 = r0;
            r4 = r2;
            r5 = r6;
            r0 = r1;
            goto L_0x000b;
        L_0x0046:
            r5[r4] = r3;
            r3 = 2;
            r0 = "PF\u00056\u000fA";
            r4 = r3;
            r5 = r6;
            r3 = r0;
            r0 = r2;
            goto L_0x000b;
        L_0x0050:
            r5[r4] = r3;
            z = r6;
            return;
        L_0x0055:
            r11 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
            goto L_0x0021;
        L_0x0058:
            r11 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
            goto L_0x0021;
        L_0x005b:
            r11 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
            goto L_0x0021;
        L_0x005e:
            r11 = 95;
            goto L_0x0021;
        L_0x0061:
            r8 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.f.a.<clinit>():void");
        }

        public a(f fVar, byte b, String str, long j, byte[] bArr) {
            this.e = fVar;
            this.a = b;
            this.b = str;
            this.c = j;
            this.d = bArr;
        }

        public final String toString() {
            return new StringBuilder(z[1]).append(this.a).append(z[0]).append(this.b).append('\'').append(z[2]).append(this.c).append('}').toString();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 14;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = ")2\u001c,$l, 5\"q$\u001f+.W'\u0017\u0010\u0007G'\u00117y";
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
            case 0: goto L_0x00b8;
            case 1: goto L_0x00bb;
            case 2: goto L_0x00bf;
            case 3: goto L_0x00c3;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 67;
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
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "w'\u0001,&v6P*&v1\u00196-%5\u0011*cq+\u001d<,p6";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "j,%)'d6\u0015\u000b*a\u0016\u00194&j7\u0004y1l&J";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "U.\u0005>*k\u0012\u001c87c-\u00024\u0011l&%)'d6\u0015";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = ")'\u0002+,w\u0001\u001f=&?";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "%n\u000056b+\u001e\t/d6\u001661h\u0010\u0015>\nA\u0000\u00158-?";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "j,%)'d6\u0015\u000b*a\u0004\u00110/`&P+*ax";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "v'\u001e=\u0016u&\u0011-&W+\u0014\u0010-c-P+&b+\u0014c";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "p,\u001b7,r,P)/p%\u00197cu.\u0011-%j0\u001dy7|2\u0015";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = ")0\u0019=y";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "v#\u001d<cw'\u00170'%0\u0015(6`1\u0004uca0\u001f)cl6";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "u.\u0005>*kl\u00005\"q$\u001f+.+6\t)&";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "u.\u0005>*kl\u00005\"q$\u001f+.+0\u0015>*ab";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "j,%)'d6\u0015\u000b*a\u0011\u0005: `1\u0003y1l&J";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00b8:
        r9 = 5;
        goto L_0x0020;
    L_0x00bb:
        r9 = 66;
        goto L_0x0020;
    L_0x00bf:
        r9 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        goto L_0x0020;
    L_0x00c3:
        r9 = 89;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.f.<clinit>():void");
    }

    private f() {
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    private synchronized void a(Context context) {
        JCoreInterface.sendRequestData(context, cn.jpush.android.a.a, 10000, this.a.d);
    }

    public final void a(Context context, long j) {
        e.f(z[3], new StringBuilder(z[13]).append(j).append(z[0]).append(this.a).toString());
        if (this.a == null || this.a.c != j) {
            e.c(z[3], z[1]);
        } else {
            b.a(context, this.a.a, this.a.b);
        }
    }

    public final void a(Context context, long j, int i) {
        e.f(z[3], new StringBuilder(z[6]).append(j).append(z[4]).append(i).append(z[5]).append(this.a).toString());
        if (this.a == null || this.a.c != j || this.c >= 3) {
            e.c(z[3], z[1]);
            return;
        }
        this.c++;
        a(context);
    }

    public final synchronized void a(Context context, Bundle bundle) {
        byte byteValue = bundle.getByte(z[11], (byte) 0).byteValue();
        if (byteValue != (byte) 0) {
            String string = bundle.getString(z[12]);
            if (this.a == null || !TextUtils.equals(this.a.b, string)) {
                this.c = 0;
                long nextRid = JCoreInterface.getNextRid();
                e.a(z[3], new StringBuilder(z[7]).append(string).append(z[9]).append(nextRid).toString());
                long uid = JCoreInterface.getUid();
                int sid = JCoreInterface.getSid();
                OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
                outputDataUtil.writeU16(0);
                outputDataUtil.writeU8(0);
                outputDataUtil.writeU8(27);
                outputDataUtil.writeU64(nextRid);
                outputDataUtil.writeU32((long) sid);
                outputDataUtil.writeU64(uid);
                outputDataUtil.writeByteArrayincludeLength(TextUtils.isEmpty(string) ? new byte[0] : string.getBytes());
                outputDataUtil.writeU16At(outputDataUtil.current(), 0);
                this.a = new a(this, byteValue, string, nextRid, outputDataUtil.toByteArray());
                a(context);
            } else {
                e.c(z[3], z[10]);
            }
        } else {
            e.g(z[3], z[8]);
        }
    }

    public final void b(Context context, long j) {
        e.f(z[3], new StringBuilder(z[2]).append(j).append(z[0]).append(this.a).toString());
        if (this.a == null || this.a.c != j || this.c >= 3) {
            e.c(z[3], z[1]);
            return;
        }
        this.c++;
        a(context);
    }
}
