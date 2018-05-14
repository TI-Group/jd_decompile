package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.view.PointerIconCompat;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.a.d;
import cn.jpush.android.d.e;
import cn.jpush.android.data.b;
import java.util.Locale;

/* compiled from: TbsSdkJava */
public final class a extends WebViewClient {
    private static final String[] z;
    private final b a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 25;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "V\u0011\u001cbt^\u001bVyuC\u001a\u0016d5R\u0007\fbz\u0019+=HO";
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
            case 0: goto L_0x0131;
            case 1: goto L_0x0135;
            case 2: goto L_0x0139;
            case 3: goto L_0x013d;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 27;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "V\n\u001cyt\u0018U";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "b\r\u0011*;";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "V\u0011\u001cbt^\u001bVyuC\u001a\u0016d5V\u001c\fytYQ+UUs";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "L]\rbw\u0015EZ5h\u0015\u0002";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0019L\u001f`";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "}/\rcs`\u001a\u001aFrR\b;|rR\u0011\f";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "b\r\u00140mV\n\u0014u;^\fX*";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\b\u001b\u0011b~T\u000bEvz[\f\u001d";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "G\u0013\u0019yu\u0018\u000b\u001dho";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "A\u0016\u001cut\u0018U";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "f\n\u001dbbd\u000b\nyuPEX";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "V\u0011\u001cbt^\u001bVyuC\u001a\u0016d5R\u0007\fbz\u0019:5QR{";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0011\u001b\u0011b~T\u000bEvz[\f\u001d";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0019\u0012\b$";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0011\u001c\u0017~oR\u0011\f-";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "Z\u001e\u0011|oX";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "_\u000b\f`";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "~\u0011\u000eqw^\u001bXei[";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "S\u0016\nuxCB";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0019\u0012\b#";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "V\u0011\u001cbt^\u001bVyuC\u001a\u0016d5V\u001c\fytYQ.Y^`";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0019\u001e\b{";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "V\u0011\u001cbt^\u001bVyuC\u001a\u0016d5R\u0007\fbz\u0019,-RQr<,";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "C\u0016\f|~\n";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0131:
        r9 = 55;
        goto L_0x0020;
    L_0x0135:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0020;
    L_0x0139:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x0020;
    L_0x013d:
        r9 = 16;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ui.a.<clinit>():void");
    }

    public a(b bVar) {
        this.a = bVar;
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Context context = webView.getContext();
        e.e(z[6], new StringBuilder(z[7]).append(str).toString());
        try {
            webView.getSettings().setSavePassword(false);
            cn.jpush.android.d.a.a(webView);
            String format = String.format(Locale.ENGLISH, z[4], new Object[]{str});
            if (this.a.E) {
                context.startActivity(new Intent(z[21], Uri.parse(str)));
                d.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                return true;
            } else if (str.endsWith(z[20])) {
                r1 = new Intent(z[21]);
                r1.setDataAndType(Uri.parse(str), z[1]);
                webView.getContext().startActivity(r1);
                return true;
            } else if (str.endsWith(z[14]) || str.endsWith(z[5])) {
                r1 = new Intent(z[21]);
                r1.setDataAndType(Uri.parse(str), z[10]);
                webView.getContext().startActivity(r1);
                return true;
            } else if (str.endsWith(z[22])) {
                webView.getContext().startActivity(new Intent(z[21], Uri.parse(str)));
                return true;
            } else {
                if (str.startsWith(z[17])) {
                    d.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                } else if (str != null && str.startsWith(z[16])) {
                    if (str.lastIndexOf(z[19]) < 0 && !str.startsWith(z[16])) {
                        str = str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) > 0 ? str + z[13] : str + z[8];
                        str.lastIndexOf(z[19]);
                    }
                    int indexOf = str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR);
                    String substring = str.substring(0, indexOf);
                    String substring2 = str.substring(indexOf);
                    e.a(z[6], new StringBuilder(z[2]).append(substring).toString());
                    e.a(z[6], new StringBuilder(z[11]).append(substring2).toString());
                    r1 = null;
                    if (substring.startsWith(z[16])) {
                        String[] split = substring.split(":");
                        if (split != null && split.length == 2) {
                            indexOf = substring2.indexOf(z[24]) + 6;
                            int indexOf2 = substring2.indexOf(z[15]);
                            String substring3 = substring2.substring(indexOf, indexOf2);
                            substring2 = substring2.substring(indexOf2 + 9);
                            String[] strArr = new String[]{split[1]};
                            r1 = new Intent(z[3]);
                            r1.setType(z[9]);
                            r1.putExtra(z[12], strArr);
                            r1.putExtra(z[23], substring3);
                            r1.putExtra(z[0], substring2);
                        }
                    }
                    if (r1 != null) {
                        context.startActivity(r1);
                    }
                    d.a(this.a.c, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, format, cn.jpush.android.a.e);
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            e.i(z[6], z[18]);
            return true;
        }
    }
}
