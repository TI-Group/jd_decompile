package cn.jpush.android.e.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.api.c;

/* compiled from: TbsSdkJava */
public final class e {
    private static final String[] z;
    private Context a;
    private WindowManager b;
    private WebView c;
    private ImageButton d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u00141wU0\u0019l;\n|TozB=";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
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
            case 0: goto L_0x0070;
            case 1: goto L_0x0073;
            case 2: goto L_0x0076;
            case 3: goto L_0x0079;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 29;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            case 5: goto L_0x006b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "Zrt\u0012mLo2V|Wx(\u0017t]2\u001b;IpJ\u0013,DfL\u001b*\\t";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "mt?X|Zh3\u000etMez\u0016|Tyz\u0011n\u0019u4\u000e|Uu>T=~u,\u001d=LltV";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "je)\fxT]6\u001doMK?\u001aKPy-;|Up8\u0019~R";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "X.\u0011rW<wU0\u00196\u0017n\\";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "mt?X|Zh3\u000etMez\u0016|Tyz\u0011n\u0019r/\u0014q\u0019s(XxTl.\u00011\u0019[3\u000ex\u0019i*V3";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "X.\u0011rW<wU0\u0019o.\u0019oM]9\ftOu.\u0001_@R;\u0015x\u00141wU0\u00141w\u0019~Mu,\u0011i@R;\u0015x\u0019&z";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 57;
        goto L_0x001f;
    L_0x0073:
        r9 = 28;
        goto L_0x001f;
    L_0x0076:
        r9 = 90;
        goto L_0x001f;
    L_0x0079:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.e.a.e.<clinit>():void");
    }

    public final void a(String str, String str2) {
        cn.jpush.android.d.e.c(z[3], new StringBuilder(z[6]).append(str).append(z[0]).append(str2).toString());
        if (TextUtils.isEmpty(str)) {
            cn.jpush.android.d.e.j(z[3], z[5]);
        }
        if (this.a != null) {
            try {
                Class cls = Class.forName(str);
                if (cls != null) {
                    Intent intent = new Intent(this.a, cls);
                    intent.putExtra(z[1], str2);
                    intent.setFlags(268435456);
                    this.a.startActivity(intent);
                    cn.jpush.android.d.e.c(z[3], z[4]);
                    c.a(this.b, this.c, this.d);
                }
            } catch (Exception e) {
                cn.jpush.android.d.e.j(z[3], z[2]);
            }
        }
    }
}
