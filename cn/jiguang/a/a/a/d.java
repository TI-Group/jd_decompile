package cn.jiguang.a.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

final class d {
    private static final String[] z;
    HandlerThread a = null;
    Handler b = null;
    private int c;
    private String d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 5;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u001f\u0011\u0007\u0002$\u001b\u0011\u0004\u0000v";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002c;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x005f;
            case 1: goto L_0x0062;
            case 2: goto L_0x0065;
            case 3: goto L_0x0068;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 4;
    L_0x001e:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002a;
    L_0x0026:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002a:
        r5 = r1;
        r1 = r7;
    L_0x002c:
        if (r5 > r6) goto L_0x0011;
    L_0x002e:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0042;
            case 1: goto L_0x004a;
            case 2: goto L_0x0052;
            case 3: goto L_0x005a;
            default: goto L_0x003a;
        };
    L_0x003a:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u001f\u0011\u0007\u0002$B\u001bIT$B\u000fIT$";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0042:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u001b\u0010\u0000\u0016$\u0006\bI\u0000u\u001a\u0019\u0005Es\u0006\f\u0001Ev\u0000\r\u001d\u0000(O\u001b\u0006\u000bp\u0006\u0016\u001c\u0000*";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004a:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0006\b";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0052:
        r3[r2] = r1;
        r2 = 4;
        r1 = ".\n\u00190p\u0006\u0014";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005a:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x005f:
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        goto L_0x001e;
    L_0x0062:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x001e;
    L_0x0065:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x001e;
    L_0x0068:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.d.<clinit>():void");
    }

    public d(String str, int i) {
        this.c = i;
        this.d = str;
        this.a = new HandlerThread(z[0]);
        this.a.start();
        this.b = new Handler(this.a.getLooper(), new e(this));
    }

    private void b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[]{bArr[0], bArr[1], bArr[2], (byte) 0};
        Thread currentThread = Thread.currentThread();
        Process process = null;
        while (i < i2) {
            bArr2[3] = (byte) i;
            if (bArr2[3] != bArr[3]) {
                try {
                    String a = c.a(bArr2);
                    if (a.equalsIgnoreCase(this.d)) {
                        cn.jiguang.c.d.c(z[4], z[2]);
                        if (process != null) {
                            try {
                                process.exitValue();
                            } catch (Exception e) {
                                try {
                                    process.destroy();
                                } catch (Exception e2) {
                                }
                            }
                        }
                    } else {
                        this.b.removeCallbacksAndMessages(null);
                        Message obtainMessage = this.b.obtainMessage(1);
                        obtainMessage.obj = currentThread;
                        Bundle bundle = new Bundle();
                        bundle.putString(z[3], a);
                        obtainMessage.setData(bundle);
                        this.b.sendMessageDelayed(obtainMessage, (long) this.c);
                        process = c.b(new StringBuilder(z[1]).append(a).toString());
                        if (process != null) {
                            try {
                                process.exitValue();
                            } catch (Exception e3) {
                                try {
                                    process.destroy();
                                } catch (Exception e4) {
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (process != null) {
                        try {
                            process.exitValue();
                        } catch (Exception e5) {
                            try {
                                process.destroy();
                            } catch (Exception e6) {
                            }
                        }
                    }
                }
            }
            i++;
        }
    }

    public final void a(byte[] bArr, int i, int i2) {
        b(bArr, 0, 255);
        this.a.quit();
    }
}
