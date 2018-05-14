package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a.d;
import cn.jpush.android.a.f;
import cn.jpush.android.d.a;
import cn.jpush.android.d.e;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import java.io.File;

/* compiled from: TbsSdkJava */
public class PushActivity extends Activity {
    private static final String[] z;
    private int a = 0;
    private boolean b = false;
    private String c;
    private FullScreenView d = null;
    private Handler e = new Handler(this) {
        final /* synthetic */ PushActivity a;

        {
            this.a = r1;
        }

        public final void handleMessage(Message message) {
            b bVar = (b) message.obj;
            switch (message.what) {
                case 1:
                    this.a.setRequestedOrientation(1);
                    PushActivity.a(this.a, bVar);
                    return;
                case 2:
                    this.a.b();
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 20;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "(+\u0017f\u001a\u001b*\rx2\f'Di>\f~*[\u00174~\r`/\u001d0\u0010/";
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
            case 0: goto L_0x00fa;
            case 1: goto L_0x00fe;
            case 2: goto L_0x0102;
            case 3: goto L_0x0106;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 91;
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
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u001e,\u000bc\u0004\u000f?\u001d";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "(+\u0017f\u001a\u001b*\rx2\f'";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "=&\u0010|:X:\u0005z:X7\u0017.5\u0017*D}>\n7\u0005b2\u0002?\u0006b>Y";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "/?\u0016`2\u00169ｨ`.\u00142Dc>\u000b-\u0005i>X;\nz2\f'E.\u0018\u00141\u0017k{(+\u0017f\u001a\u001b*\rx2\f'E";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001a1\u0000w";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "6+\bb{\u0015;\u0017}:\u001f;Dk5\f7\u0010wzX\u001d\ba(\u001d~4{(\u0010\u001f\u0007z2\u000e7\u0010wz";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "10\u0012o7\u0011:Dc(\u001f~\u0010w+\u001d~\u0010a{\u000b6\u000by{U~";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0014?\u001da.\f";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "(2\u0001o(\u001d~\u0005j?X2\u0005w4\r*D|>\u000b1\u0011|8\u001d~\u000e~.\u000b6;y>\u001a(\rk,'2\u0005w4\r*Jv6\u0014~\u0010a{\n;\u0017!7\u0019'\u000b{/X";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u001e7\bkaWq";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0019=\u0010g4\u0016<\u0005|\u0017\u0019'\u000b{/1:";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0012.\u0011}3')\u0001l-\u0011;\u0013Q7\u0019'\u000b{/";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "(2\u0001o(\u001d~\u0011}>X:\u0001h:\r2\u0010.8\u0017:\u0001.2\u0016~\u000e~.\u000b6;y>\u001a(\rk,'2\u0005w4\r*Jv6\u0014";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "9=\u0010g4\u0016dD~)\u0017=\u0001}(+6\u000by";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0011:";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0019=\u0010g-\u0011*\u001d";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\f1\u0014O8\f7\u0012g/\u0001~D3{";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "?;\u0010.)\r0\ng5\u001f~\u0010o(\u0013-Dh:\u00112\u0001ju";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u001a?\u0017k\u001a\u001b*\rx2\f'D.fX";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00fa:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x0020;
    L_0x00fe:
        r9 = 94;
        goto L_0x0020;
    L_0x0102:
        r9 = 100;
        goto L_0x0020;
    L_0x0106:
        r9 = 14;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ui.PushActivity.<clinit>():void");
    }

    private void a(b bVar) {
        if (bVar != null) {
            switch (bVar.p) {
                case 0:
                    Message message = new Message();
                    message.what = 1;
                    message.obj = bVar;
                    this.e.sendMessageDelayed(message, 500);
                    return;
                default:
                    e.g(z[2], new StringBuilder(z[7]).append(bVar.p).toString());
                    cn.jpush.android.api.b.a((Context) this, bVar, 0);
                    finish();
                    return;
            }
        }
        e.h(z[2], z[6]);
        finish();
    }

    static /* synthetic */ void a(PushActivity pushActivity, b bVar) {
        e.e(z[2], z[14]);
        if (bVar == null) {
            e.h(z[2], z[6]);
            pushActivity.finish();
            return;
        }
        g gVar = (g) bVar;
        if (gVar.L == 0) {
            pushActivity.a = gVar.J;
            int identifier = pushActivity.getResources().getIdentifier(z[12], z[8], pushActivity.getPackageName());
            if (identifier == 0) {
                e.j(z[2], z[9]);
                pushActivity.finish();
                return;
            }
            pushActivity.setContentView(identifier);
            String str = gVar.a;
            if (f.a(str)) {
                String str2 = gVar.P;
                if (gVar.q) {
                    int identifier2 = pushActivity.getResources().getIdentifier(z[11], z[15], pushActivity.getPackageName());
                    if (identifier2 == 0) {
                        e.j(z[2], z[13]);
                        pushActivity.finish();
                        return;
                    }
                    pushActivity.d = (FullScreenView) pushActivity.findViewById(identifier2);
                    pushActivity.d.initModule(pushActivity, bVar);
                    if (TextUtils.isEmpty(str2) || !new File(str2.replace(z[10], "")).exists() || pushActivity.b) {
                        pushActivity.d.loadUrl(str);
                    } else {
                        pushActivity.d.loadUrl(str2);
                    }
                }
                if (!pushActivity.b) {
                    d.a(pushActivity.c, 1000, null, pushActivity);
                    return;
                }
                return;
            }
            cn.jpush.android.api.b.a((Context) pushActivity, bVar, 0);
            pushActivity.finish();
        }
    }

    public final void a() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ PushActivity a;

            {
                this.a = r1;
            }

            public final void run() {
                if (this.a.d != null) {
                    this.a.d.showTitleBar();
                }
            }
        });
    }

    public final void b() {
        finish();
        if (1 == this.a) {
            try {
                ActivityManager activityManager = (ActivityManager) getSystemService(z[16]);
                ComponentName componentName = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).baseActivity;
                ComponentName componentName2 = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity;
                e.c(z[2], new StringBuilder(z[19]).append(componentName.toString()).toString());
                e.c(z[2], new StringBuilder(z[17]).append(componentName2.toString()).toString());
                if (componentName != null && componentName2 != null && componentName2.toString().equals(componentName.toString())) {
                    a.b(this);
                }
            } catch (Exception e) {
                e.h(z[2], z[18]);
                a.b(this);
            }
        }
    }

    public void onBackPressed() {
        if (this.d == null || !this.d.webviewCanGoBack()) {
            d.a(this.c, PointerIconCompat.TYPE_CELL, null, this);
            b();
            return;
        }
        this.d.webviewGoBack();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            try {
                this.b = getIntent().getBooleanExtra(z[1], false);
                b bVar = (b) getIntent().getSerializableExtra(z[5]);
                if (bVar != null) {
                    this.c = bVar.c;
                    a(bVar);
                    return;
                }
                e.h(z[2], z[4]);
                finish();
                return;
            } catch (Exception e) {
                e.j(z[2], z[3]);
                e.printStackTrace();
                finish();
                return;
            }
        }
        e.h(z[2], z[0]);
        finish();
    }

    protected void onDestroy() {
        if (this.d != null) {
            this.d.destory();
        }
        if (this.e.hasMessages(2)) {
            this.e.removeMessages(2);
        }
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            try {
                this.b = intent.getBooleanExtra(z[1], false);
                b bVar = (b) intent.getSerializableExtra(z[5]);
                if (bVar != null) {
                    this.c = bVar.c;
                    a(bVar);
                    return;
                }
                e.h(z[2], z[4]);
                finish();
                return;
            } catch (Exception e) {
                e.j(z[2], z[3]);
                e.printStackTrace();
                finish();
                return;
            }
        }
        e.h(z[2], z[0]);
        finish();
    }

    protected void onPause() {
        super.onPause();
        if (this.d != null) {
            this.d.pause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.d != null) {
            this.d.resume();
        }
    }
}
