package cn.jiguang.a.a.b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    private static final String[] z;
    private WifiManager a;
    private Context b = null;
    private JSONArray c;
    private f d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 20;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "Sw\r^MAl\u0019X\u001f";
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
            case 1: goto L_0x00fd;
            case 2: goto L_0x0101;
            case 3: goto L_0x0105;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
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
        r1 = "Sw\r^$jx\u0004z\fj\fR\u001f";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "sw\r^M`k\u0006G";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "gk\u0019E\bjj<^\u000bm$";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "p\f";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "ep\u000fE\u0002mzEG\bvs\u0002D\u001emq\u0005\u0019,G].d>[]$v?W[4{\"G_?~\"J";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "sw\r^W";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "wj\u0019X\u0003c{\u0018C";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "gk\u0019E\bjj<~+M>\u0002DMjk\u0007[";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "pv\u0002DMsw\r^$jx\u0004\u0017\u001ees\u000e\u0017\u001amj\u0003\u0017\u000ekp\u0005R\u000ep>\u001c^\u000bmW\u0005Q\u0002";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "gq\u0005Y\bgj";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "sw\r^";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "sw\r^Mgq\u001eY\u0019>";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "qp\u000eO\u001da}\u001fR\t%";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "V{\u001aB\u0004v{KC\u0005a>\u001bR\u001fiw\u0018D\u0004kp\nY\tvq\u0002SCt{\u0019Z\u0004wm\u0002X\u0003*_(t(WM4`$BW4d9EJ.";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "v{\u001bX\u001fp>\u001c^\u000bm>\u0002Y\u000bk$";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "sw\r^Ms\u0018\u0017\tmm\nU\u0001az";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "ep\u000fE\u0002mzEG\bvs\u0002D\u001emq\u0005\u0019,G].d>[I\"q$[M?v9A";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "ep\u000fE\u0002mzEG\bvs\u0002D\u001emq\u0005\u0019,G].d>[X\"y([R$t,PW$y";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "ep\u000fE\u0002mzEG\bvs\u0002D\u001emq\u0005\u0019.L_%p([I\"q$[M?v9A";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00fa:
        r9 = 4;
        goto L_0x0020;
    L_0x00fd:
        r9 = 30;
        goto L_0x0020;
    L_0x0101:
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0020;
    L_0x0105:
        r9 = 55;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.h.<clinit>():void");
    }

    public h(Context context, f fVar) {
        this.a = (WifiManager) context.getSystemService(z[11]);
        this.b = context;
        this.d = fVar;
    }

    private List<i> a(JSONArray jSONArray) {
        d.a(z[1], z[2]);
        if (!d()) {
            return null;
        }
        i iVar;
        WifiInfo connectionInfo = this.a.getConnectionInfo();
        if (connectionInfo != null) {
            i iVar2 = new i(this, connectionInfo.getBSSID(), connectionInfo.getRssi(), connectionInfo.getSSID());
            d.a(z[1], new StringBuilder(z[3]).append(iVar2.toString()).toString());
            iVar = iVar2;
        } else {
            iVar = null;
        }
        ArrayList arrayList = new ArrayList();
        if (iVar != null) {
            JSONObject a = iVar.a();
            a.put(z[4], z[10]);
            jSONArray.put(a);
        }
        List list = null;
        if (VERSION.SDK_INT < 23) {
            list = this.a.getScanResults();
        } else if (this.b != null && a.b(this.b, z[5])) {
            list = this.a.getScanResults();
        }
        if (r0 != null && r0.size() > 0) {
            int i = -200;
            i iVar3 = null;
            for (ScanResult iVar4 : r0) {
                i iVar5 = new i(this, iVar4);
                d.a(z[1], new StringBuilder(z[6]).append(iVar5.toString()).toString());
                if (iVar == null) {
                    d.a(z[1], z[8]);
                } else if (iVar.equals(iVar5)) {
                    d.a(z[1], z[9]);
                } else {
                    int i2;
                    arrayList.add(iVar5);
                    if (iVar5.c.equals(iVar.c) || iVar5.b <= i) {
                        iVar2 = iVar3;
                        i2 = i;
                    } else {
                        i iVar6 = iVar5;
                        i2 = iVar5.b;
                        iVar2 = iVar6;
                    }
                    iVar3 = iVar2;
                    i = i2;
                }
            }
            Collections.sort(arrayList);
            int i3 = 10;
            if (iVar3 != null) {
                a = iVar3.a();
                a.put(z[4], z[7]);
                jSONArray.put(a);
                arrayList.remove(iVar3);
                i3 = 9;
            }
            if (iVar != null) {
                arrayList.remove(iVar);
                i3--;
            }
            if (arrayList.size() > i3) {
                Collection subList = arrayList.subList(0, i3);
                list = new ArrayList();
                list.addAll(subList);
                return list;
            }
        }
        return arrayList;
    }

    private boolean d() {
        boolean z = false;
        try {
            z = this.a.isWifiEnabled();
        } catch (Throwable e) {
            d.e(z[1], z[z], e);
        }
        return z;
    }

    public final void a() {
        this.c = null;
    }

    public final void b() {
        int i = 0;
        if (a.b(this.b, z[17])) {
            Context context = this.b;
            int i2 = (a.b(context, z[5]) && a.b(context, z[17]) && a.b(context, z[19]) && a.b(context, z[18])) ? 1 : 0;
            if (i2 == 0 && !a.n(this.b)) {
                return;
            }
            if (this.a.isWifiEnabled()) {
                JSONArray jSONArray = new JSONArray();
                try {
                    List<i> a = a(jSONArray);
                    if (a != null) {
                        i = a.size();
                    }
                    d.a(z[1], new StringBuilder(z[12]).append(i).toString());
                    if (a != null) {
                        for (i a2 : a) {
                            jSONArray.put(a2.a());
                        }
                    }
                } catch (Throwable th) {
                    d.i(z[1], new StringBuilder(z[13]).append(th.getMessage()).toString());
                }
                d.a(z[1], new StringBuilder(z[15]).append(jSONArray.toString()).toString());
                this.c = jSONArray;
                return;
            }
            d.a(z[1], z[16]);
            return;
        }
        d.g(z[1], z[14]);
    }

    public final JSONArray c() {
        return this.c;
    }
}
