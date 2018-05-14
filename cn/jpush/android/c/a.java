package cn.jpush.android.c;

import android.app.Activity;
import android.content.Context;
import cn.jpush.android.d.e;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability.OnUpdateListener;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient.Builder;
import com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.push.TokenResp;
import com.huawei.hms.support.api.push.HuaweiPush;
import com.huawei.hms.support.api.push.TokenResult;

/* compiled from: TbsSdkJava */
public final class a implements OnUpdateListener, ConnectionCallbacks, OnConnectionFailedListener {
    private static final String[] z;
    protected HuaweiApiClient a;
    private c b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 14;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "7\u0006E255\u0016U{\u000b\u0011\u0016Se\u000003^s\u0011?\f@$:\u0017[}\u000by\fPx\u0000:\u0017\u0012t\u00040\u000fWvE<Y";
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
            case 1: goto L_0x00bc;
            case 2: goto L_0x00c0;
            case 3: goto L_0x00c4;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
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
        r1 = "\t\u000fGu\f7+Gs\u0012<\nsb\f\u001a\u000f[w\u000b- S~\t\u001b\u0002Qy";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = ">\u0006F2\u00116\bW|E?\u0002[~\u0000=O\u0012Z(\nC[aE=\nAq\n7\rWq\u0011w";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = ">\u0006F27<\u0004{VE?\u0002[~\u0000=CW`\u00176\u0011\b";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "5\fSvE:\f\\|\u0000:\u0017\u0012a\u00118\u0017W2\u00038\n^wEtC\u0012w\u0017+\f@(";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "6\rgb\u00018\u0017WT\u00040\u000fWv_";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "u\u0000]|\u000b<\u0000F{\n71Wa\u00105\u0017\b";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "6\rq}\u000b7\u0006Qf\u0000=Y";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "uCW`\u00176\u0011q}\u0001<Y";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "0\u0010\u0012g\u0016<\u0011\u0012@\u0000*\f^d\u0004;\u000fW2 +\u0011]`EtC";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "6\rq}\u000b7\u0006Qf\f6\rts\f5\u0006V(";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "6\rq}\u000b7\u0006Qf\f6\rts\f5\u0006V2\u0004:\u0017[d\f-\u001a\u0012e\u0004*C\\g\t5";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "+\u0006A}\t/\u0006@W\u0017+\f@2\u00038\n^w\u0001y\u0006@`\n+Y";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "6\rq}\u000b7\u0006Qf\u0000=";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00b8:
        r9 = 89;
        goto L_0x0020;
    L_0x00bc:
        r9 = 99;
        goto L_0x0020;
    L_0x00c0:
        r9 = 50;
        goto L_0x0020;
    L_0x00c4:
        r9 = 18;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.a.<clinit>():void");
    }

    public a(Context context, c cVar) {
        this.b = cVar;
        try {
            this.a = new Builder(context).addApi(HuaweiPush.PUSH_API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        } catch (Throwable th) {
            e.e(z[1], new StringBuilder(z[0]).append(th).toString());
        }
    }

    private Activity b() {
        return this.b != null ? this.b.a : null;
    }

    private boolean c() {
        try {
            if (this.a != null && this.a.isConnected()) {
                return true;
            }
        } catch (Throwable th) {
            e.f(z[1], new StringBuilder(z[4]).append(th).toString());
        }
        return false;
    }

    protected final String a() {
        try {
            if (c()) {
                HuaweiPush.HuaweiPushApi.getToken(this.a).setResultCallback(new ResultCallback<TokenResult>(this) {
                    private static final String[] z;
                    final /* synthetic */ a a;

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                        /*
                        r12 = 3;
                        r2 = 1;
                        r1 = 0;
                        r4 = new java.lang.String[r12];
                        r3 = "dm&\u0012nlc7\\:ei;^g(\u0012qz=@ ";
                        r0 = -1;
                        r5 = r4;
                        r6 = r4;
                        r4 = r1;
                    L_0x000b:
                        r3 = r3.toCharArray();
                        r7 = r3.length;
                        if (r7 > r2) goto L_0x0060;
                    L_0x0012:
                        r8 = r1;
                    L_0x0013:
                        r9 = r3;
                        r10 = r8;
                        r14 = r7;
                        r7 = r3;
                        r3 = r14;
                    L_0x0018:
                        r13 = r7[r8];
                        r11 = r10 % 5;
                        switch(r11) {
                            case 0: goto L_0x0055;
                            case 1: goto L_0x0057;
                            case 2: goto L_0x005a;
                            case 3: goto L_0x005d;
                            default: goto L_0x001f;
                        };
                    L_0x001f:
                        r11 = 26;
                    L_0x0021:
                        r11 = r11 ^ r13;
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
                        r0 = "Sd'Usm@'Smfa\u0013Bs@d;WtwK3^vAi1Y";
                        r3 = r0;
                        r4 = r2;
                        r5 = r6;
                        r0 = r1;
                        goto L_0x000b;
                    L_0x0046:
                        r5[r4] = r3;
                        r3 = 2;
                        r0 = "wg9Wt#z7Aoo|h";
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
                        r11 = r12;
                        goto L_0x0021;
                    L_0x0057:
                        r11 = 8;
                        goto L_0x0021;
                    L_0x005a:
                        r11 = 82;
                        goto L_0x0021;
                    L_0x005d:
                        r11 = 50;
                        goto L_0x0021;
                    L_0x0060:
                        r8 = r1;
                        goto L_0x002f;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.a.1.<clinit>():void");
                    }

                    {
                        this.a = r1;
                    }

                    public final /* synthetic */ void onResult(Object obj) {
                        String str = null;
                        TokenResult tokenResult = (TokenResult) obj;
                        if (tokenResult != null) {
                            try {
                                TokenResp tokenRes = tokenResult.getTokenRes();
                            } catch (Throwable th) {
                                e.g(z[1], new StringBuilder(z[0]).append(th).toString());
                                return;
                            }
                        }
                        tokenRes = null;
                        String str2 = z[1];
                        StringBuilder stringBuilder = new StringBuilder(z[2]);
                        if (tokenRes != null) {
                            str = tokenRes.getToken();
                        }
                        e.e(str2, stringBuilder.append(str).toString());
                    }
                });
            } else {
                e.g(z[1], z[2]);
            }
        } catch (Throwable th) {
            e.f(z[1], new StringBuilder(z[3]).append(th).toString());
        }
        return null;
    }

    public final void onConnected() {
        e.f(z[1], z[13]);
        a();
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        e.f(z[1], new StringBuilder(z[10]).append(b()).append(z[8]).append(connectionResult != null ? Integer.valueOf(connectionResult.getErrorCode()) : null).toString());
        try {
            boolean isUserResolvableError = HuaweiApiAvailability.getInstance().isUserResolvableError(connectionResult.getErrorCode());
            e.f(z[1], new StringBuilder(z[9]).append(isUserResolvableError).toString());
            if (!isUserResolvableError) {
                return;
            }
            if (b() != null) {
                HuaweiApiAvailability.getInstance().resolveError(b(), connectionResult.getErrorCode(), 10001, this);
            } else {
                e.h(z[1], z[11]);
            }
        } catch (Throwable th) {
            e.h(z[1], new StringBuilder(z[12]).append(th).toString());
        }
    }

    public final void onConnectionSuspended(int i) {
        e.f(z[1], new StringBuilder(z[7]).append(i).toString());
    }

    public final void onUpdateFailed(ConnectionResult connectionResult) {
        e.h(z[1], new StringBuilder(z[5]).append(b()).append(z[6]).append(connectionResult != null ? Integer.valueOf(connectionResult.getErrorCode()) : null).toString());
    }
}
