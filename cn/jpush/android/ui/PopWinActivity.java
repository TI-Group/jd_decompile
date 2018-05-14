package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.a.d;
import cn.jpush.android.d.a;
import cn.jpush.android.d.e;
import cn.jpush.android.d.i;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import cn.jpush.android.e.a.f;
import java.io.File;

/* compiled from: TbsSdkJava */
public class PopWinActivity extends Activity {
    public static f a = null;
    private static final String[] z;
    private String b;
    private WebView c;
    private b d = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 20;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "{w\u0015#KBqｫ#W@zG G_e\u0006*G\fs\t9KXoFma@y\u0014(\u0002|c\u0014%cOb\u000e;KXoF";
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
            case 0: goto L_0x00fd;
            case 1: goto L_0x0101;
            case 2: goto L_0x0105;
            case 3: goto L_0x0109;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 34;
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
        r1 = "J\u000b(\u0018\u00039";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "in\u0013?C\fr\u00069C\f\u0014mLCbG>G^\u0006!KVw\u0005!G\r";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "ow\tmLCbG*GX6\u0010(@z\u0002:\u0002ExG!CUy\u00129\u0002J\u000b(\u0003";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "@w\u001e\"WX";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "|c\u0014%cOb\u000e;KXo";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "Ff\u0012>Jsf\b=UEx8!CUy\u00129";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "mx\u0003?MErG>FG6\u0011(P_\b#\u0002Kd\u0002,VIdG9JMxG\"P\fs\u00168C@6\u0013\"\u0002\u001d!KmhM`\u0006⁙h_6\u000e#VId\u0006.V\ft\u001emCBx\b9CX\b#\u0003";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Ee)\"VEp\u000e.CX\b#";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "|z\u0002,QI6\u0012>G\fr\u0002+CYz\u0013mACr\u0002mKB6\r=W_~8=M\\a\u000e#}@w\u001e\"WX8\u001f N\r";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "fF\u0012>J{s\u0005";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "|c\u0014%cOb\u000e;KXoG*GX6)\u0018n`6\u000e#VIx\u0013l";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "Ny\u00034";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "Er";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "[`7\"R[\t";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "_~\b:w^zGp\u0002";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "|z\u0002,QI6\u0006)F\fz\u00064MYbG?G_y\u0012?AI6\r=W_~8=M\\a\u000e#}@w\u001e\"WX8\u001f N\fb\bmPIeH!CUy\u00129\u0002\r";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "Mr\u0003\u0007CZw\u0014.PEf\u0013\u0004LXs\u0015+COsG+CEz\u0002)\u0018";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "Mr\u0003\u0007CZw\u0014.PEf\u0013\u0004LXs\u0015+COs";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "Jd\b }[w\u001e";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        a = r0;
        return;
    L_0x00fd:
        r9 = 44;
        goto L_0x0020;
    L_0x0101:
        r9 = 22;
        goto L_0x0020;
    L_0x0105:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
    L_0x0109:
        r9 = 77;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ui.PopWinActivity.<clinit>():void");
    }

    private void a() {
        r0 = new Object[2];
        Class[] clsArr = new Class[]{a, z[10]};
        clsArr[0] = Object.class;
        clsArr[1] = String.class;
        try {
            i.a(this.c, z[18], clsArr, r0);
        } catch (Exception e) {
            e.printStackTrace();
            e.i(z[5], new StringBuilder(z[17]).append(e.toString()).toString());
        }
    }

    public final void a(String str) {
        if (this.d != null && this.c != null && (this.d instanceof g)) {
            if (!TextUtils.isEmpty(str)) {
                ((g) this.d).a = str;
                Intent intent = new Intent(this, PushActivity.class);
                intent.putExtra(z[12], this.d);
                intent.putExtra(z[19], true);
                intent.setFlags(335544320);
                startActivity(intent);
            }
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        d.a(this.b, PointerIconCompat.TYPE_CELL, null, this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            try {
                if (getIntent().getBooleanExtra(z[8], false)) {
                    cn.jpush.android.service.b.a();
                    cn.jpush.android.service.b.a(getApplicationContext(), getIntent());
                    finish();
                    return;
                }
                this.d = (b) getIntent().getSerializableExtra(z[12]);
                if (this.d != null) {
                    this.b = this.d.c;
                    int identifier = getResources().getIdentifier(z[6], z[4], getPackageName());
                    if (identifier == 0) {
                        e.j(z[5], z[16]);
                        finish();
                    } else {
                        setContentView(identifier);
                        identifier = getResources().getIdentifier(z[14], z[13], getPackageName());
                        if (identifier == 0) {
                            e.j(z[5], z[9]);
                            finish();
                        } else {
                            this.c = (WebView) findViewById(identifier);
                            if (this.c == null) {
                                e.j(z[5], z[3]);
                                finish();
                            } else {
                                this.c.setScrollbarFadingEnabled(true);
                                this.c.setScrollBarStyle(33554432);
                                WebSettings settings = this.c.getSettings();
                                settings.setDomStorageEnabled(true);
                                a.a(settings);
                                a.a(this.c);
                                settings.setSavePassword(false);
                                this.c.setBackgroundColor(0);
                                a = new f(this, this.d);
                                if (VERSION.SDK_INT >= 17) {
                                    e.d(z[5], z[7]);
                                    a();
                                }
                                this.c.setWebChromeClient(new cn.jpush.android.e.a.a(z[10], cn.jpush.android.e.a.b.class, null, null));
                                this.c.setWebViewClient(new a(this.d));
                                cn.jpush.android.e.a.b.setWebViewHelper(a);
                            }
                        }
                    }
                    g gVar = (g) this.d;
                    String str = gVar.P;
                    String str2 = gVar.a;
                    e.c(z[5], new StringBuilder(z[15]).append(str2).toString());
                    if (TextUtils.isEmpty(str) || !new File(str.replace(z[1], "")).exists()) {
                        this.c.loadUrl(str2);
                    } else {
                        this.c.loadUrl(str);
                    }
                    d.a(this.b, 1000, null, this);
                    return;
                }
                e.h(z[5], z[0]);
                finish();
                return;
            } catch (Exception e) {
                e.j(z[5], z[2]);
                e.printStackTrace();
                finish();
                return;
            }
        }
        e.h(z[5], z[11]);
        finish();
    }

    protected void onDestroy() {
        if (this.c != null) {
            this.c.removeAllViews();
            this.c.destroy();
            this.c = null;
        }
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.c != null && VERSION.SDK_INT >= 11) {
            this.c.onPause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.c != null) {
            if (VERSION.SDK_INT >= 11) {
                this.c.onResume();
            }
            cn.jpush.android.e.a.b.setWebViewHelper(a);
        }
    }
}
