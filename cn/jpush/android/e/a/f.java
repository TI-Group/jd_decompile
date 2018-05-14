package cn.jpush.android.e.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a.d;
import cn.jpush.android.d.a;
import cn.jpush.android.d.e;
import cn.jpush.android.data.b;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import java.lang.ref.WeakReference;

/* compiled from: TbsSdkJava */
public final class f {
    private static final String[] z;
    private final WeakReference<Activity> a;
    private final b b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 30;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u001f(~6:Fdi\u001d4]kh2\u001b\\|d8<Piy7:]2";
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
            case 0: goto L_0x0168;
            case 1: goto L_0x016c;
            case 2: goto L_0x0170;
            case 3: goto L_0x0174;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 85;
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
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            case 25: goto L_0x0142;
            case 26: goto L_0x014d;
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u001f(~6:Fdi\u001d9\\{hd";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "dmo~6Rda<4Pc7=9Zkf~x\u0013in*<\\fD:o";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "dmo\b<VE;9Cm";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "zf{?9Zl-?6Gab0\u001cW(k,:^(Z;7\u0013%-";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "ffe?;Wdh~<]|h0!\u00132-=;\u001db}+&[&l01Agd:{Zfy;;G&L\u001d\u0001zGC\u0001\u0014p\\D\b\u001cgQR\u0011\u0005vFI\u001b\u0011";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "dmo~6Rda<4Pc7-=\\Y14@|-su";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "dmo~6Rda<4Pc7::Dfa14W( ~";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Rfi,:Zl#7;Gmc*{Rky7:]&[\u0017\u0010d";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "Rfi,:Zl#7;Gmc*{Vpy,4\u001d{e1'Gkx*{}I@\u001b";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "rfi,:ZlX*<_";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "ffh&%Vky;1\t(d0#Rdd:uFza~x\u0013";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "Rfi,:Zl#7;Gmc*{Vpy,4\u001d{e1'Gkx*{zKB\u0010\naM^\u0011\u0000aKH";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u001f(x,9\t";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "Rfi,:Zl#7;Gmc*{Vpy,4\u001d{e1'Gkx*{zFY\u001b\u001bg";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "dmo~6Rda<4Pc7='Viy;\u0006[g*6F|-su]i`;o";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "Zkb0\u001cW(~6:Fdi~7V(d0!\u0013%-";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "W}}2<Piy;";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "Pzh?!V[e1'GKx*uVz1'\t";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "Pg`p4]l1<W&a? ]ke;'\u001din*<\\f#\u0017\u001b`\\L\u0012\u0019l[E\u0011\u0007gKX\n";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "dmo~6Rda<4Pc7;-Vkx*0~{j\u00130@{l90\u0013%-";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "dmo~6Rda<4Pc7=9\\{h";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "Pf#4%F{ep4]l1<W&d0!Vfyp\u0014p\\D\u0011\u001blZD\u001d\u001dc]^\u0016\npIA\u0012\u0017rKF";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "Pf#4%F{ep4]l1<W&H\u0006\u0001aI";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "^{j\n,Cm-8'\\e-)0Q2-";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "Rky7#Z|t\u00104^m-cu";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "g`h~4P|d(<Gq-04^m-7&\u0013fx29\u0013g~0^xy'y\u0013Od(0\u0013}}p{";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "Pf#4%F{ep4]l1<W&L\u001d\u0001z^D\n\flXL\f\u0014~";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "g`h~4P|d(<Gq-04^m-7&\u0013ac(4_airuta{;uFx#p";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "ffe?;Wdh~<]|h0!\u00132-";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0168:
        r9 = 51;
        goto L_0x0020;
    L_0x016c:
        r9 = 8;
        goto L_0x0020;
    L_0x0170:
        r9 = 13;
        goto L_0x0020;
    L_0x0174:
        r9 = 94;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.e.a.f.<clinit>():void");
    }

    public f(Context context, b bVar) {
        this.a = new WeakReference((Activity) context);
        this.b = bVar;
    }

    @JavascriptInterface
    private void userClick(String str) {
        int parseInt;
        int i = 1100;
        try {
            parseInt = Integer.parseInt(str);
        } catch (Exception e) {
            e.i(z[3], new StringBuilder(z[4]).append(str).toString());
            parseInt = i;
        }
        d.a(this.b.c, parseInt, null, (Context) this.a.get());
    }

    @JavascriptInterface
    public final void click(String str, String str2, String str3) {
        boolean z;
        if (this.a.get() != null) {
            boolean parseBoolean;
            e.c(z[3], new StringBuilder(z[2]).append(str).append(z[1]).append(str2).append(z[0]).append(str3).toString());
            userClick(str);
            try {
                parseBoolean = Boolean.parseBoolean(str2);
                try {
                    z = parseBoolean;
                    parseBoolean = Boolean.parseBoolean(str3);
                } catch (Exception e) {
                    z = parseBoolean;
                    parseBoolean = false;
                    if (parseBoolean) {
                        cn.jpush.android.api.b.a((Context) this.a.get(), this.b, 0);
                    }
                    if (!z) {
                        ((Activity) this.a.get()).finish();
                    }
                }
            } catch (Exception e2) {
                parseBoolean = false;
                z = parseBoolean;
                parseBoolean = false;
                if (parseBoolean) {
                    cn.jpush.android.api.b.a((Context) this.a.get(), this.b, 0);
                }
                if (!z) {
                    ((Activity) this.a.get()).finish();
                }
            }
            if (parseBoolean) {
                cn.jpush.android.api.b.a((Context) this.a.get(), this.b, 0);
            }
            if (!z) {
                ((Activity) this.a.get()).finish();
            }
        }
    }

    @JavascriptInterface
    public final void close() {
        if (this.a.get() != null) {
            e.c(z[3], z[21]);
            ((Activity) this.a.get()).finish();
        }
    }

    @JavascriptInterface
    public final void createShortcut(String str, String str2, String str3) {
        int parseInt;
        int i = 0;
        try {
            parseInt = Integer.parseInt(str3);
        } catch (Exception e) {
            e.c(z[3], new StringBuilder(z[16]).append(str3).toString());
            parseInt = i;
        }
        if (this.a.get() != null) {
            e.c(z[3], new StringBuilder(z[15]).append(str).append(z[13]).append(str2).toString());
            Context context = (Context) this.a.get();
            parseInt = cn.jpush.android.api.b.a(parseInt);
            Uri parse = Uri.parse(str2);
            if (parse == null) {
                e.c(z[10], new StringBuilder(z[11]).append(str2).toString());
                return;
            }
            Parcelable intent = new Intent(z[8], parse);
            intent.setFlags(335544320);
            try {
                Parcelable fromContext = ShortcutIconResource.fromContext(context, parseInt);
                Intent intent2 = new Intent(z[19]);
                intent2.putExtra(z[17], false);
                intent2.putExtra(z[9], str);
                intent2.putExtra(z[14], intent);
                intent2.putExtra(z[12], fromContext);
                context.sendBroadcast(intent2);
            } catch (Throwable th) {
                e.h(z[10], new StringBuilder(z[18]).append(th.getMessage()).toString());
            }
        }
    }

    @JavascriptInterface
    public final void download(String str) {
        if (this.a.get() != null) {
            e.c(z[3], new StringBuilder(z[7]).append(str).toString());
        }
    }

    @JavascriptInterface
    public final void download(String str, String str2) {
        if (this.a.get() != null) {
            userClick(str);
            download(str2);
            cn.jpush.android.api.b.a((Context) this.a.get(), this.b, 0);
            ((Activity) this.a.get()).finish();
        }
    }

    @JavascriptInterface
    public final void download(String str, String str2, String str3) {
        e.a(z[3], new StringBuilder(z[24]).append(str3).toString());
        download(str, str2);
    }

    @JavascriptInterface
    public final void executeMsgMessage(String str) {
        if (JCoreInterface.getDebugMode()) {
            e.c(z[3], new StringBuilder(z[20]).append(str).toString());
            if (this.a.get() != null) {
                cn.jpush.android.a.f.a((Context) this.a.get(), str);
            }
        }
    }

    @JavascriptInterface
    public final void showTitleBar() {
        if (this.a.get() != null && (this.a.get() instanceof PushActivity)) {
            ((PushActivity) this.a.get()).a();
        }
    }

    @JavascriptInterface
    public final void showToast(String str) {
        if (this.a.get() != null) {
            e.c(z[3], new StringBuilder(z[6]).append(str).toString());
            Toast.makeText((Context) this.a.get(), str, 0).show();
        }
    }

    @JavascriptInterface
    public final void startActivityByIntent(String str, String str2) {
        Context context = (Context) this.a.get();
        if (context != null) {
            try {
                Intent intent = new Intent(str);
                intent.addCategory(context.getPackageName());
                intent.putExtra(z[23], str2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e) {
                e.j(z[3], new StringBuilder(z[29]).append(str).toString());
            }
        }
    }

    @JavascriptInterface
    public final void startActivityByName(String str, String str2) {
        e.c(z[3], new StringBuilder(z[25]).append(str).toString());
        if (TextUtils.isEmpty(str)) {
            e.j(z[3], z[26]);
        }
        Context context = (Context) this.a.get();
        if (context != null) {
            try {
                Class cls = Class.forName(str);
                if (cls != null) {
                    Intent intent = new Intent(context, cls);
                    intent.putExtra(z[27], str2);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                }
            } catch (Exception e) {
                e.j(z[3], z[28]);
            }
        }
    }

    @JavascriptInterface
    public final void startMainActivity(String str) {
        Context context = (Context) this.a.get();
        if (context != null) {
            try {
                ((Activity) context).finish();
                a.b(context);
            } catch (Exception e) {
                e.j(z[3], z[5]);
            }
        }
    }

    @JavascriptInterface
    public final void startPushActivity(String str) {
        if (this.a.get() != null && (this.a.get() instanceof PopWinActivity)) {
            ((PopWinActivity) this.a.get()).a(str);
        }
    }

    @JavascriptInterface
    public final void triggerNativeAction(String str) {
        Context context = (Context) this.a.get();
        if (context != null) {
            String str2 = z[22];
            String str3 = z[23];
            Bundle bundle = new Bundle();
            if (str3 != null) {
                bundle.putString(str3, str);
            }
            a.a(context, str2, bundle);
        }
    }
}
