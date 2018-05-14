package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.b.a.a;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import jd.wjlogin_sdk.util.ReplyCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class h extends Thread {
    private static final Object i = new Object();
    private static final String[] z;
    private int a;
    private Context b;
    private WifiManager c;
    private String d;
    private String e;
    private String f;
    private int g;
    private boolean[] h;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 33;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "|\u0015\"\u0016Z{\br\u0013]s\u0002r\u0016G=\u0002?\u000f@dKr\u0018]k\u0002r\nD=\u00173\rGxI";
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
            case 0: goto L_0x0190;
            case 1: goto L_0x0194;
            case 2: goto L_0x0198;
            case 3: goto L_0x019c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 52;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\\\u0015\"*@t\u000b";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "y\b\u0002\u0016ZzGh";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "z\u0002&>Fm.<\u0019[=]";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "-IbQ\u00043W";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "|\u0015\"_]s\u0001=_]nG7\u0012Di\u001e~_St\u00117_AmG \u001aDr\u0015&Q";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "Y\u000f1\u000f}s\u0001=_]nGh";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "m\u000e<\u0018";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Y\u000f1\u000f}s\u0001=_]nG<\nXq";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "z\u0002&>Fm.<\u0019[=";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "~\u0006&_\u001bm\u0015=\u001c\u001bs\u0002&PUo\u0017";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "-\u001f`";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "-WhO\u0004'WbE\u0004-]bO\u000e-W";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "z\u0002&>Fm.<\u0019[=G1\u0013[n\u0002r\u0016Zm\u0012&\f@o\u00023\u0012";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "z\u0002&>Fm.<\u0019[=\u00173\rGx& \u000f\u0014'";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "|\u0015\"6Z{\bh";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "{\u000e<\u0016GuG\u00026zZ";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "M.\u001c8\u001a3I|Q\u001a3I|Q\u001a3";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "y\t!";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "y\u0006&\u001e";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "i\u001e\"\u001a";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "q\b1\u001eXB\u000e\"";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0014!\u0016P";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "t\u0013;\u0012Q";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "n\u0014;\u001b";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "y\u000f1\u000f";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "p\u00061";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "p\u00061 Xt\u0014&";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "{\b \u0012Ui57\u000f[o\u0013\u0016\u001e@|Gh";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "q\b1\u001eXB\n3\u001c";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "z\u0006&\u001aC|\u001e";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "t\u0017";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "s\u0002&\u0012Un\f";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        i = r0;
        return;
    L_0x0190:
        r9 = 29;
        goto L_0x0020;
    L_0x0194:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
    L_0x0198:
        r9 = 82;
        goto L_0x0020;
    L_0x019c:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.h.<clinit>():void");
    }

    private h(WifiManager wifiManager, String str, String str2, String str3, Context context, int i, int i2) {
        this.g = 2;
        this.c = wifiManager;
        this.a = i;
        this.b = context;
        this.g = i2;
        this.d = str2;
        this.e = str3;
        this.f = str;
        if (i2 == 2) {
            this.h = new boolean[3];
        }
    }

    private ArrayList<b> a(String str) {
        Process a;
        BufferedReader bufferedReader;
        IOException iOException;
        ArrayList<b> arrayList;
        IOException iOException2;
        Throwable th;
        try {
            a = c.b(z[10]);
            if (a == null) {
                if (a != null) {
                    a.destroy();
                }
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(a.getInputStream()));
            } catch (IOException e) {
                bufferedReader = null;
                iOException = e;
                arrayList = null;
                iOException2 = iOException;
                try {
                    d.i(z[1], new StringBuilder(z[9]).append(iOException2.toString()).toString());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException iOException22) {
                            d.i(z[1], new StringBuilder(z[13]).append(iOException22.toString()).toString());
                        }
                    }
                    if (a != null) {
                        return arrayList;
                    }
                    a.destroy();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException iOException222) {
                            d.i(z[1], new StringBuilder(z[13]).append(iOException222.toString()).toString());
                        }
                    }
                    if (a != null) {
                        a.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (a != null) {
                    a.destroy();
                }
                throw th;
            }
            try {
                bufferedReader.readLine();
                arrayList = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        try {
                            b b = b(readLine);
                            if (!(b == null || !b.b().equals(z[11]) || str.equals(b.a()) || b.c().equals(z[12]))) {
                                d.e(z[1], new StringBuilder(z[15]).append(b.toString()).toString());
                                arrayList.add(b);
                            }
                        } catch (Exception e2) {
                            try {
                                d.i(z[1], new StringBuilder(z[14]).append(e2.toString()).toString());
                            } catch (IOException e3) {
                                iOException222 = e3;
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException iOException2222) {
                            d.i(z[1], new StringBuilder(z[13]).append(iOException2222.toString()).toString());
                        }
                    }
                }
                bufferedReader.close();
                if (a == null) {
                    return arrayList;
                }
                a.destroy();
                return arrayList;
            } catch (IOException e4) {
                iOException = e4;
                arrayList = null;
                iOException2222 = iOException;
                d.i(z[1], new StringBuilder(z[9]).append(iOException2222.toString()).toString());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (a != null) {
                    return arrayList;
                }
                a.destroy();
                return arrayList;
            }
        } catch (IOException e42) {
            a = null;
            bufferedReader = null;
            iOException = e42;
            arrayList = null;
            iOException2222 = iOException;
            d.i(z[1], new StringBuilder(z[9]).append(iOException2222.toString()).toString());
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (a != null) {
                return arrayList;
            }
            a.destroy();
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            a = null;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (a != null) {
                a.destroy();
            }
            throw th;
        }
    }

    private static JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList<b> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[23], a.q());
            jSONObject.put(z[20], z[27]);
            jSONObject.put(z[24], str);
            jSONObject.put(z[22], str2);
            jSONObject.put(z[21], str3);
            jSONObject.put(z[29], str4);
            jSONObject.put(z[32], str5);
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str6)) {
                jSONArray.put(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONArray.put(str7);
            }
            jSONObject.put(z[18], jSONArray);
            jSONObject.put(z[30], str8);
            jSONObject.put(z[25], str9);
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(z[31], bVar.a());
                jSONObject2.put(z[26], bVar.c());
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put(z[19], jSONArray2);
        } catch (JSONException e) {
            d.i(z[1], new StringBuilder(z[28]).append(e.toString()).toString());
        }
        return jSONObject;
    }

    private void a(String str, byte[] bArr) {
        d.e(z[1], z[17]);
        if (this.g == 2) {
            for (int i = 0; i < 3; i++) {
                this.h[i] = false;
                int i2 = (i * 85) + 0;
                byte[] bArr2 = bArr;
                new Thread(new f(new d(str, this.a), bArr2, i2, i2 + 85, new j(this, new m(), i))).start();
            }
            synchronized (i) {
                while (b()) {
                    try {
                        i.wait();
                    } catch (InterruptedException e) {
                        d.i(z[1], new StringBuilder(z[2]).append(e.toString()).toString());
                    }
                }
            }
        } else {
            new d(str, this.a).a(bArr, 0, 255);
        }
        d.e(z[1], z[16]);
    }

    private static b b(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            d.e(z[1], z[0]);
            return null;
        }
        byte[] bytes = str.getBytes();
        if (bytes == null) {
            return null;
        }
        b bVar = new b();
        int i2 = 0;
        int i3 = 0;
        while (i3 < bytes.length - 1) {
            i3++;
            if (bytes[i3] == ReplyCode.reply0x20) {
                if (i3 - i2 > 1) {
                    String str2 = new String(bytes, i2, i3 - i2);
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    bVar.d(str2);
                                    break;
                                }
                            }
                            bVar.c(str2);
                        } else {
                            bVar.b(str2);
                        }
                    } else {
                        bVar.a(str2);
                    }
                    i++;
                }
                i2 = i3 + 1;
            }
        }
        return bVar;
    }

    private boolean b() {
        for (boolean z : this.h) {
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public final void run() {
        DhcpInfo dhcpInfo = this.c.getDhcpInfo();
        if (dhcpInfo == null) {
            d.c(z[1], z[8]);
            return;
        }
        d.e(z[1], new StringBuilder(z[6]).append(dhcpInfo.toString()).toString());
        byte[] a = new byte[]{(byte) ((int) (255 & ((long) dhcpInfo.ipAddress))), (byte) ((int) ((((long) dhcpInfo.ipAddress) >> 8) & 255)), (byte) ((int) ((((long) dhcpInfo.ipAddress) >> 16) & 255)), (byte) ((int) ((((long) dhcpInfo.ipAddress) >> 24) & 255))};
        String a2 = c.a(dhcpInfo.ipAddress);
        if (TextUtils.equals(a2, z[4])) {
            a2 = "";
        }
        String c = cn.jiguang.e.a.c(this.b, "");
        String a3 = c.a(dhcpInfo.netmask);
        if (TextUtils.equals(a3, z[4])) {
            a3 = "";
        }
        String a4 = c.a(dhcpInfo.dns1);
        if (TextUtils.equals(a4, z[4])) {
            a4 = "";
        }
        String a5 = c.a(dhcpInfo.dns2);
        if (TextUtils.equals(a5, z[4])) {
            a5 = "";
        }
        String a6 = c.a(dhcpInfo.gateway);
        if (TextUtils.equals(a6, z[4])) {
            a6 = "";
        }
        String a7 = c.a(dhcpInfo.serverAddress);
        if (TextUtils.equals(a7, z[4])) {
            a7 = "";
        }
        m mVar = new m();
        try {
            a(a7, a);
        } catch (Exception e) {
            d.i(z[1], new StringBuilder(z[2]).append(e.toString()).toString());
        }
        mVar.a(z[1], z[7]);
        ArrayList arrayList = null;
        try {
            arrayList = a(a7);
        } catch (Exception e2) {
            d.i(z[1], new StringBuilder(z[3]).append(e2.toString()).toString());
        }
        if (arrayList == null || arrayList.isEmpty()) {
            d.c(z[1], z[5]);
        } else {
            JSONObject a8 = a(this.e, this.d, a2, c, a3, a4, a5, a6, a7, arrayList);
            d.c(z[1], a8.toString());
            o.a(this.b, new JSONArray().put(a8), new i(this));
        }
        c.c(2);
    }
}
