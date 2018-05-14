package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import cn.jiguang.b.a.a;
import cn.jiguang.b.a.d;
import cn.jiguang.b.d.o;
import cn.jiguang.e.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements UncaughtExceptionHandler {
    private static e b = new e();
    private static final String[] z;
    public boolean a;
    private UncaughtExceptionHandler c;
    private Context d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 26;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "o_\u0006A@in\u000f^W=M\u0017]\u0012sO\u001aB\u001e=H\u0013ZGoT";
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
            case 0: goto L_0x0143;
            case 1: goto L_0x0147;
            case 2: goto L_0x014b;
            case 3: goto L_0x014f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 50;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "Wj\u0003]Z^H\u0017]ZU[\u0018J^xH";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "hT>O\\yV\u0013\u000e@xJ\u0019\\F=N\u000f^W<";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\\Y\u0002G]s\u001a[\u000e@xJ\u0019\\F^H\u0017]ZQU\u0011\u000eQrT\u0002KJi\u001a\u001f]\u0012sO\u001aB";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "~H\u0017]ZBV\u0019I";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "=_\u000eZ@|s\u0018H]'";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\\Y\u0002G]s\u001a[\u000eZ|T\u0012BWTT\u0010A`xJ\u0019\\F=H\u0013^]oN\"WBx\u0000";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "wJ\u0003]ZBO\u0018MSh]\u001eZWeY\u0013^FtU\u0018qTtV\u0013";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "k_\u0004][rT\u0018O_x";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "~H\u0017]ZiS\u001bK";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "~U\u0003@F";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "k_\u0004][rT\u0015AVx";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "p_\u0005]Sz_";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "nN\u0017MYiH\u0017MW";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "s_\u0002Y]oQ\u0002WBx";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "sO\u001aB";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "iC\u0006K";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "tN\u001fCW";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "y_\u0000GQxe\u001f@Tr";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "~H\u0017]ZqU\u0011]";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "s_\u0002Y]oQ)ZKm_";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\\Y\u0002G]s\u001a[\u000eVxV\u0013ZW^H\u0017]ZQU\u0011\u000eQrT\u0002KJi\u001a\u001f]\u0012sO\u001aB";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "xT\u0017L^x\u001a\u0015\\SnRV\\WmU\u0004Z";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "yS\u0005OPq_VM@|I\u001e\u000e@xJ\u0019\\F";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "XH\u0004A@";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "XB\u0015KBiS\u0019@";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        z = r4;
        r0 = new cn.jiguang.a.a.c.e;
        r0.<init>();
        b = r0;
        return;
    L_0x0143:
        r9 = 29;
        goto L_0x0020;
    L_0x0147:
        r9 = 58;
        goto L_0x0020;
    L_0x014b:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x0020;
    L_0x014f:
        r9 = 46;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.e.<clinit>():void");
    }

    private e() {
        this.c = null;
        this.a = true;
        this.a = d.b();
    }

    public static e a() {
        return b;
    }

    private static String a(Throwable th, String str) {
        String str2 = str + th.toString();
        try {
            String[] split = str2.split(":");
            if (split.length <= 1) {
                return str2;
            }
            int length = split.length - 1;
            while (length >= 0) {
                if (split[length].endsWith(z[25]) || split[length].endsWith(z[24])) {
                    return split[length];
                }
                length--;
            }
            return str2;
        } catch (NullPointerException e) {
            return str2;
        } catch (PatternSyntaxException e2) {
            return str2;
        }
    }

    private JSONArray a(Context context, JSONArray jSONArray, Throwable th, String str) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        Object obj = null;
        try {
            long r = a.r();
            int i = 0;
            while (i < jSONArray.length()) {
                obj = jSONArray.optJSONObject(i);
                if (obj != null && stringWriter2.equals(obj.getString(z[13]))) {
                    obj.put(z[10], obj.getInt(z[10]) + 1);
                    obj.put(z[9], System.currentTimeMillis() + r);
                    break;
                }
                obj = null;
                i++;
            }
            i = 0;
            if (obj != null) {
                jSONArray = a(jSONArray, i);
                jSONArray.put(obj);
                return jSONArray;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z[9], r + System.currentTimeMillis());
            jSONObject.put(z[13], stringWriter2);
            jSONObject.put(z[12], a(th, str));
            jSONObject.put(z[10], 1);
            if (!(this.d == null && context == null)) {
                jSONObject.put(z[14], cn.jiguang.e.a.c(context));
            }
            if (this.d != null) {
                PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 1);
                if (packageInfo != null) {
                    obj = packageInfo.versionName == null ? z[15] : packageInfo.versionName;
                    String str2 = packageInfo.versionCode;
                    jSONObject.put(z[8], obj);
                    jSONObject.put(z[11], str2);
                }
            }
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (JSONException e) {
            return jSONArray;
        } catch (Throwable th2) {
            return jSONArray;
        }
    }

    private static JSONArray a(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (i2 != i) {
                try {
                    jSONArray2.put(jSONArray.get(i2));
                } catch (JSONException e) {
                }
            }
        }
        return jSONArray2;
    }

    public static void a(Context context, String str, String str2) {
        cn.jiguang.c.d.a(z[1], new StringBuilder(z[6]).append(str).append(z[5]).append(str2).toString());
        if (j.a(str)) {
            cn.jiguang.c.d.a(z[1], z[0]);
        } else if (str.equals(z[4])) {
            e eVar = b;
            if (context == null) {
                cn.jiguang.c.d.g(z[1], z[3]);
            } else if (d.f(context)) {
                JSONObject e = e(context);
                if (e != null) {
                    o.a(context, e);
                    d(context);
                }
            }
        } else {
            cn.jiguang.c.d.g(z[1], z[2]);
        }
    }

    private static void a(Context context, JSONArray jSONArray) {
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2 != null && jSONArray2.length() > 0 && context != null) {
            try {
                FileOutputStream openFileOutput = context.openFileOutput(z[7], 0);
                openFileOutput.write(jSONArray2.getBytes());
                openFileOutput.flush();
                openFileOutput.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
    }

    public static void d(Context context) {
        if (context == null) {
            cn.jiguang.c.d.g(z[1], z[21]);
            return;
        }
        File file = new File(context.getFilesDir(), z[7]);
        if (file.exists()) {
            file.delete();
        }
    }

    public static JSONObject e(Context context) {
        JSONArray f = f(context);
        if (f == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[19], f);
            jSONObject.put(z[17], a.q());
            jSONObject.put(z[16], z[4]);
            jSONObject.put(z[20], cn.jiguang.e.a.c(context));
            JSONObject a = b.a(context);
            if (a == null || a.length() <= 0) {
                return jSONObject;
            }
            jSONObject.put(z[18], a);
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        } catch (Exception e2) {
            return jSONObject;
        }
    }

    private static JSONArray f(Context context) {
        Exception e;
        Throwable th;
        JSONArray jSONArray = null;
        if (new File(context.getFilesDir(), z[7]).exists()) {
            FileInputStream openFileInput;
            try {
                openFileInput = context.openFileInput(z[7]);
                try {
                    byte[] bArr = new byte[1024];
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int read = openFileInput.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        stringBuffer.append(new String(bArr, 0, read));
                    }
                    if (stringBuffer.toString().length() > 0) {
                        jSONArray = new JSONArray(stringBuffer.toString());
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return jSONArray;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openFileInput != null) {
                            try {
                                openFileInput.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                openFileInput = null;
                e.printStackTrace();
                if (openFileInput != null) {
                    openFileInput.close();
                }
                return jSONArray;
            } catch (Throwable th3) {
                openFileInput = null;
                th = th3;
                if (openFileInput != null) {
                    openFileInput.close();
                }
                throw th;
            }
        }
        return jSONArray;
    }

    public final void a(Context context) {
        this.d = context;
        if (this.c == null) {
            this.c = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public final void b(Context context) {
        this.d = context;
        if (!this.a) {
            this.a = true;
            d.a(context, true);
        }
    }

    public final void c(Context context) {
        this.d = context;
        if (this.a) {
            this.a = false;
            d.a(context, false);
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (this.a) {
            cn.jiguang.c.d.a(z[1], z[22]);
            Context context = this.d;
            JSONArray a = a(context, f(context), th, "");
            d(this.d);
            a(this.d, a);
            f fVar = new f(this);
            fVar.start();
            try {
                fVar.join(2000);
            } catch (InterruptedException e) {
            }
        } else {
            cn.jiguang.c.d.a(z[1], z[23]);
        }
        if (this.c != this) {
            this.c.uncaughtException(thread, th);
        }
        throw new RuntimeException(th);
    }
}
