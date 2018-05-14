package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.d.e;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class d {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 16;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "+\u0006eA\u001a\"";
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
            case 0: goto L_0x00ce;
            case 1: goto L_0x00d2;
            case 2: goto L_0x00d6;
            case 3: goto L_0x00d9;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "/\u0001ks\u0016";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "+\u0006eA\u00002\u0014vk\u0000";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "2\fr{";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "%\u001alj\u0016>\u0001\"z\u001a\"Ulq\u0007f\u001clw\u0007jUp{\u00073\u0007l";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "jUaq\u0017#O\"";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "4\u0010qk\u001f2";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "'\u0016vw\u001c(Op{\u0003)\u0007v_\u00102\u001cmp!#\u0006wr\u0007fX\"s\u00165\u0006cy\u0016\u000f\u00118>";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\"\u0014v";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\f%wm\u001b\u0014\u0010rq\u00012=gr\u0003#\u0007";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\f%wm\u001bf\u001cq>\u001a(#cr\u001a\"'gy\u001a5\u0001gl\u0016\"";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "f\u0007gn\u001c4\u0001\"}\u001c(\u0001gp\u0007|U";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "2\u0018qy,/\u0011";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "2\u001dkl\u0017\u0019\u0018qy,5\u0001cj\u00065";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "5\u0011iA\u0007?\u0005g";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "'\u0016vw\u001c(Op{\u0003)\u0007vJ\u001b/\u0007fM7\r8qy2%\u0001kq\u001d\u0014\u0010qk\u001f2U/>\u001e#\u0006q\u0014#<f$S";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00ce:
        r9 = 70;
        goto L_0x0020;
    L_0x00d2:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x0020;
    L_0x00d6:
        r9 = 2;
        goto L_0x0020;
    L_0x00d9:
        r9 = 30;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.d.<clinit>():void");
    }

    public static void a(String str, int i, String str2, Context context) {
        if (!JCoreInterface.isValidRegistered()) {
            e.a(z[9], z[10]);
        } else if (context == null) {
            e.c(z[9], z[4]);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(new StringBuilder(z[7]).append(str).append(z[5]).append(i).append("-").append(i.a(i)).toString());
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(new StringBuilder(z[11]).append(str2).toString());
            }
            e.c(z[9], stringBuffer.toString());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(z[0], str);
                jSONObject.put(z[6], i);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(z[8], str2);
                }
                jSONObject.put(z[1], JCoreInterface.getReportTime());
                jSONObject.put(z[3], z[2]);
                JCoreInterface.reportHttpData(context, jSONObject, a.a);
            } catch (JSONException e) {
            }
        }
    }

    public static void a(String str, String str2, byte b, int i, Context context) {
        if (!JCoreInterface.isValidRegistered()) {
            e.a(z[9], z[10]);
        } else if (context == null) {
            e.c(z[9], z[4]);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(new StringBuilder(z[15]).append(str).append(z[5]).append(i).toString());
            e.c(z[9], stringBuffer.toString());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(z[0], str);
                jSONObject.put(z[12], str2);
                jSONObject.put(z[6], i);
                jSONObject.put(z[14], b);
                jSONObject.put(z[1], JCoreInterface.getReportTime());
                jSONObject.put(z[3], z[13]);
                JCoreInterface.reportHttpData(context, jSONObject, a.a);
            } catch (JSONException e) {
            }
        }
    }
}
