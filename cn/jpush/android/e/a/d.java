package cn.jpush.android.e.a;

import android.text.TextUtils;
import android.webkit.WebView;
import cn.jpush.android.d.e;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class d {
    private static final String[] z;
    private HashMap<String, Method> a;
    private String b;
    private String c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 35;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "`*\tK\u0010a0\u0013\u000fVc \t\u0003\u0019jm";
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
            case 0: goto L_0x019f;
            case 1: goto L_0x01a3;
            case 2: goto L_0x01a7;
            case 3: goto L_0x01ab;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
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
            case 29: goto L_0x016e;
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            case 33: goto L_0x019a;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "`0\u0010\t\u0013|";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Q\u0015";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "o7\u001a\u0018";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "'e\n\u0002\u0002fe\u000b\n\u001ag!]\u001b\u0017|$\u0010\u000e\u0002k7\u000e";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "z<\r\u000e\u0005";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "c \t\u0003\u0019j";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "l*\u0012\u0007\u0013o+";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Q\n";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "Q\u000b";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "}1\u000f\u0002\u0018i";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "Q\u0007";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "c \t\u0003\u0019je\u0018\u0013\u0013m0\t\u000eVk7\u000f\u0004\u00044";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "Q\u0016";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "m$\u0011\u0007Vj$\t\nVk(\r\u001f\u000f";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "a'\u0017\u000e\u0015z";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = ".7\u0018\u0018\u0003b1G";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "ug\u001e\u0004\u0012kgGKSji]I\u0004k6\b\u0007\u0002,]N\u0005s";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "`0\u0011\u0007";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "D6>\n\u001ab\u000f\u001c\u001d\u0017";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "Rg";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = ".&\u001c\u0007\u001a./\u000e\u0004\u00184e";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "c \t\u0003\u0019jm";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "'e\u0010\u001e\u0005ze\b\u0018\u0013.2\u0018\t\u0000g \nK\u0002ae\u001f\u000eVh,\u000f\u0018\u0002.5\u001c\u0019\u0017c \t\u000e\u0004\"e\n\u0002\u001abe\u001f\u000eV~$\u000e\u0018";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "g+\u0014\u001fVd6]\u000e\u0004|*\u000fQ";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = ".,\u0013\u0002\u0002g$\u0011\u0002\fo1\u0014\u0004\u0018. \u0013\u000fT'8TC\u0001g+\u0019\u0004\u0001'~";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = ".&\u001c\u0007\u001a. \u000f\u0019\u0019|i]\u0006\u0013}6\u001c\f\u00134(\u0014\u0018\u0005.(\u0018\u001f\u001ea!]\u0005\u0017c _\u0016\u0000o7]\u000eKU\u0018F\r\u0019|m\u000b\n\u0004.-@ZMfy\u001bE\u001ak+\u001a\u001f\u001e5-V@_u3\u001c\u0019Vmx\u001b0\u001eS~\u000b\n\u0004./@\u001f\u000f~ \u0012\rVm~\u00180\u0013 )\u0018\u0005\u0011z- V\u001c5,\u001bC\u001c3x_\r\u0003`&\t\u0002\u0019`gT\u0010\u0000o7]\u000fKok\f\u001e\u0013{ S\u0007\u0013`\"\t\u0003Mok\f\u001e\u0013{ &\u000f+3&F\r-f\u0018@\u000f\u000bs3\u001c\u0019Vix789@k\r\n\u0004} U\u001b\u0004a(\r\u001f^D\u00162%X}1\u000f\u0002\u0018i,\u001b\u0012^u(\u0018\u001f\u001ea!G\rX}-\u0014\r\u0002&lQ\u001f\u000f~ \u000eQ\u0013\"$\u000f\f\u00054#\u0000B_'~\u0014\r^ik\u001e\u0004\u0012kd@YF>l\u0006\u001f\u001e|*\nI";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "okX\u0018K";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = ".&\u001c\u0007\u001a. \u000f\u0019\u0019|i]\b\u0019j GI]ik\u001e\u0004\u0012kn_GVc \u000e\u0018\u0017i GI]ik\u000f\u000e\u0005{)\t\u0016\u0004k1\b\u0019\u0018.\"S\u0019\u0013}0\u0011\u001f\u000b5\n\u001f\u0001\u0013m1S\f\u0013z\n\n\u0005&|*\r\u000e\u0004z<3\n\u001bk6U\n_ #\u0012\u00193o&\u0015C\u0010{+\u001e\u001f\u001fa+U\u000f_u3\u001c\u0019Vmx\u001c0\u0012S~\u0014\r^z<\r\u000e\u0019he\u001eVK3g\u001b\u001e\u0018m1\u0014\u0004\u0018,c[\u000fW3x_\b\u0017b)\u001f\n\u0015egT\u0010\u0017U! V\u0010{+\u001e\u001f\u001fa+UB\r| \t\u001e\u0004`e\u001eE\u0017~5\u0011\u0012^oi&\u000f+ &\u0012\u0005\u0015o1U*\u0004|$\u0004E\u0006|*\t\u0004\u0002w5\u0018E\u0005b,\u001e\u000eXm$\u0011\u0007^o7\u001a\u001e\u001bk+\t\u0018Z>lTB\u000bs8TP\u0014 ";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "h0\u0013\b\u0002g*\u0013C_u3\u001c\u0019Vhx<\u0019\u0004o<S\u001b\u0004a1\u0012\u001f\u000f~ S\u0018\u001ag&\u0018E\u0015o)\u0011C\u0017|\"\b\u0006\u0013`1\u000eGF'~\u0014\r^hk\u0011\u000e\u0018i1\u0015WG'>\t\u0003\u0004a2_";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "3$F\b\u0019`6\u0012\u0007\u0013 )\u0012\f^,";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "#hPF[#hPF[";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "g+\u0017\u000e\u0015z \u0019K\u0018o(\u0018K\u0015o+]\u0005\u0019ze\u001f\u000eV`0\u0011\u0007";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "d$\u000b\n\u0005m7\u0014\u001b\u00024m\u001b\u001e\u0018m1\u0014\u0004\u0018&'T\u0010\u0015a+\u000e\u0004\u001akk\u0011\u0004\u0011&g";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = ".,\u0013\u0002\u0002g$\u0011\u0002\fo1\u0014\u0004\u0018.'\u0018\f\u001f`gTP\u0000o7]\nKu4\b\u000e\u0003k&6Zm$\u0011\u0007\u0014o&\u0016Q\u0010{+\u001e\u001f\u001fa+UB\rx$\u000fK\u00123\u0004\u000f\u0019\u0017wk\r\u0019\u0019z*\t\u0012\u0006kk\u000e\u0007\u001fm S\b\u0017b)U\n\u0004i0\u0010\u000e\u0018z6Q[_53\u001c\u0019Vmx\u0019E\u0005f,\u001b\u001f^'~\u000b\n\u0004. @\u000fX}-\u0014\r\u0002&lF\u001f\u001eg6S\u001a\u0003k0\u00180\u0015Sk\u001c\u001b\u0006b<U\u001f\u001eg6Q\u000f_5,\u001bCWkl\u0006\u000f\u0013b \t\u000eVz-\u0014\u0018X0\u0018\u001e\u0013U& \u0016\u000bs~";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x019f:
        r9 = 14;
        goto L_0x0020;
    L_0x01a3:
        r9 = 69;
        goto L_0x0020;
    L_0x01a7:
        r9 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        goto L_0x0020;
    L_0x01ab:
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.e.a.d.<clinit>():void");
    }

    public d(String str, Class cls) {
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception(z[32]);
            }
            this.b = str;
            this.a = new HashMap();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder stringBuilder = new StringBuilder(z[33]);
            stringBuilder.append(this.b);
            stringBuilder.append(z[34]);
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9) {
                    String a = a(method);
                    if (a != null) {
                        this.a.put(a, method);
                        stringBuilder.append(String.format(Locale.ENGLISH, z[27], new Object[]{method.getName()}));
                    }
                }
            }
            stringBuilder.append(z[29]);
            stringBuilder.append(this.b);
            stringBuilder.append(z[26]);
            stringBuilder.append(this.b);
            stringBuilder.append(z[28]);
            stringBuilder.append(this.b);
            stringBuilder.append(z[30]);
            stringBuilder.append(this.b);
            stringBuilder.append(z[25]);
            this.c = stringBuilder.toString();
            e.c(z[19], new StringBuilder(z[31]).append(stringBuilder.toString()).toString());
        } catch (Exception e) {
            e.i(z[19], new StringBuilder(z[24]).append(e.getMessage()).toString());
        }
    }

    private String a(String str, int i, Object obj) {
        String str2 = "";
        if (obj == null) {
            str2 = z[18];
        } else if (obj instanceof String) {
            str2 = "\"" + ((String) obj).replace("\"", z[20]) + "\"";
        } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) {
            str2 = String.valueOf(obj);
        }
        str2 = String.format(Locale.ENGLISH, z[17], new Object[]{Integer.valueOf(i), str2});
        e.c(z[19], this.b + z[21] + str + z[16] + str2);
        return str2;
    }

    private static String a(Method method) {
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length <= 0 || parameterTypes[0] != WebView.class) {
            e.g(z[19], new StringBuilder(z[22]).append(name).append(z[23]).toString());
            return null;
        }
        String str = name;
        for (int i = 1; i < length; i++) {
            Class cls = parameterTypes[i];
            str = cls == String.class ? str + z[13] : (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) ? str + z[9] : cls == Boolean.TYPE ? str + z[11] : cls == JSONObject.class ? str + z[8] : str + z[2];
        }
        return str;
    }

    public final String a() {
        return this.c;
    }

    public final String a(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return a(str, 500, z[14]);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(z[6]);
            JSONArray jSONArray = jSONObject.getJSONArray(z[5]);
            JSONArray jSONArray2 = jSONObject.getJSONArray(z[3]);
            int length = jSONArray.length();
            Object[] objArr = new Object[(length + 1)];
            int i = 0;
            objArr[0] = webView;
            int i2 = 0;
            while (i2 < length) {
                String str2;
                int i3;
                String optString = jSONArray.optString(i2);
                int i4;
                if (z[10].equals(optString)) {
                    optString = string + z[13];
                    objArr[i2 + 1] = jSONArray2.isNull(i2) ? null : jSONArray2.getString(i2);
                    i4 = i;
                    str2 = optString;
                    i3 = i4;
                } else if (z[1].equals(optString)) {
                    string = string + z[9];
                    i3 = ((i * 10) + i2) + 1;
                    str2 = string;
                } else if (z[7].equals(optString)) {
                    optString = string + z[11];
                    objArr[i2 + 1] = Boolean.valueOf(jSONArray2.getBoolean(i2));
                    i4 = i;
                    str2 = optString;
                    i3 = i4;
                } else if (z[15].equals(optString)) {
                    optString = string + z[8];
                    objArr[i2 + 1] = jSONArray2.isNull(i2) ? null : jSONArray2.getJSONObject(i2);
                    i4 = i;
                    str2 = optString;
                    i3 = i4;
                } else {
                    i4 = i;
                    str2 = string + z[2];
                    i3 = i4;
                }
                i2++;
                string = str2;
                i = i3;
            }
            Method method = (Method) this.a.get(string);
            if (method == null) {
                return a(str, 500, new StringBuilder(z[0]).append(string).append(z[4]).toString());
            }
            if (i > 0) {
                Class[] parameterTypes = method.getParameterTypes();
                while (i > 0) {
                    i2 = i - ((i / 10) * 10);
                    Class cls = parameterTypes[i2];
                    if (cls == Integer.TYPE) {
                        objArr[i2] = Integer.valueOf(jSONArray2.getInt(i2 - 1));
                    } else if (cls == Long.TYPE) {
                        objArr[i2] = Long.valueOf(Long.parseLong(jSONArray2.getString(i2 - 1)));
                    } else {
                        objArr[i2] = Double.valueOf(jSONArray2.getDouble(i2 - 1));
                    }
                    i /= 10;
                }
            }
            return a(str, 200, method.invoke(null, objArr));
        } catch (Exception e) {
            return e.getCause() != null ? a(str, 500, new StringBuilder(z[12]).append(e.getCause().getMessage()).toString()) : a(str, 500, new StringBuilder(z[12]).append(e.getMessage()).toString());
        }
    }
}
