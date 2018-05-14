package cn.jiguang.a.a.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenu;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import cn.jiguang.c.d;
import cn.jiguang.e.l;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final String[] z;
    private int a = -1;
    private int b = -1;
    private String c = "";
    private String d = "";
    private String e = "";
    private TelephonyManager f = null;
    private Context g = null;
    private int h = 0;
    private b i;
    private f j;
    private JSONArray k = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 33;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "4\u001cb$?+\u0001~ z5";
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
            case 0: goto L_0x0189;
            case 1: goto L_0x018d;
            case 2: goto L_0x0191;
            case 3: goto L_0x0195;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 31;
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
        r1 = "\u0004\ra8V)\u000eb\u0019~)\tj1m";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "2\u0006h,|\"\u0018y1{gE-=q.\u001cN1s+$d'k\"\u001a-1%";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\n\u0011A;|&\u001cd;q\n\tc5x\"\u001a-=q4\u001cl:|\"Hz5lg\u0006x8s";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0006\u000by=p)H tq(\u001cd2f\u0004\u0007a8z$\u001cN1s+,b:z\u0006\u000by=p)";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0013\u0000hto\"\u001a`=l4\u0001b:?(\u000e-\u0015\\\u0004-^\u0007@\u0004'L\u0006L\u00027A\u001b\\\u0006<D\u001bQg\u0001~t{\"\u0006d1{f";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "7\u0000b:z";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "4\u0001j:~+7~ m\"\u0006j w";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "*\u0007o=s\"7c1k0\u0007?@$\u0007i1";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "$\ra8@.\f";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "5\ti=p\u0018\u001ct$z";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "+\u0007n5k.\u0007c\u000b~5\rl\u000b|(\fh";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = " \rc1m&\u001cd;q";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = ".\u001cd9z";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = " \ry\u0017z+\u0004D:y(<d9zg\u000bh8s.\u0006k;?3\u0001`1%";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "$\t&v\"\u001a";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "*\u0007o=s\"7n;j)\u001c-@$\u0007i1";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "2\u0006h,o\"\u000by1{f";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = ".\u0006k;S.\u001by'%";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "kHn5m5\u0001h&%";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0013\ra1p)\u0011@5q&\u000fh&J3\u0001a'";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u0012\u0006h,o\"\u000by1{fHn1s+$b7~3\u0001b:?.\u001b-:j+\u0004!tx.\u001ehtj7H1o(\u001ayt|\"\u0004ayv)\u000eb";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "$\ra8v)\u000ebth&\u001b-:j+\u0004!t~1\u0007d0?.\u001c";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = " \u001b`";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "$\f`5";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "+\u001ch";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "d\u001dc1g$\r} z#H tx\"\u001c-5s+Hn1s+\u0001c2pg\r&p5R";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = " \ry\u0006~#\u0001b\u0000f7\r-y?)\ry#p5\u0003Y-o\"R";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\u0012\u0006h,o\"\u000by1{f";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "kHj1q\"\u001al v(\u00067";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "5\ti=p\u0013\u0011}1%";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = " \ry\u0006~#\u0001b\u0000f7\r-y?5\ti=p\u0013\u0011}1%";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "$\ra8S(\u000bl v(\u0006@5q&\u000fh&?0\t~tq2\u0004ay?4\u0003d$?3\u0000d'?&\u000by=p)";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0189:
        r9 = 71;
        goto L_0x0020;
    L_0x018d:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        goto L_0x0020;
    L_0x0191:
        r9 = 13;
        goto L_0x0020;
    L_0x0195:
        r9 = 84;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.a.<clinit>():void");
    }

    public a(Context context, f fVar) {
        this.g = context;
        try {
            this.f = (TelephonyManager) context.getSystemService(z[6]);
            this.j = fVar;
        } catch (Throwable e) {
            d.c(z[1], z[5], e);
        }
    }

    private static int a(String str) {
        int i = -1;
        try {
            if (str.length() <= 6) {
                i = Integer.parseInt(str.substring(3, str.length()));
            }
        } catch (Throwable e) {
            d.e(z[1], z[17], e);
        }
        return i;
    }

    private JSONObject a(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[8], this.b);
            jSONObject.put(z[9], i2);
            jSONObject.put(z[10], this.c);
            jSONObject.put(z[7], i);
            jSONObject.put(z[16], this.a);
            jSONObject.put(z[15], this.e);
            jSONObject.put(z[11], i3);
            jSONObject.put(z[12], this.d);
            String str = z[13];
            long q = cn.jiguang.b.a.a.q();
            d.c(z[1], new StringBuilder(z[14]).append(q).toString());
            jSONObject.put(str, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject a(int i, int i2, int i3, int i4) {
        return (i2 >= 268435455 || !(i4 == 0 || i4 == 3)) ? (i2 >= SupportMenu.USER_MASK || !(i4 == 1 || i4 == 2)) ? null : a(i, i2, i3) : a(i, i2, i3);
    }

    static /* synthetic */ void a(a aVar, JSONArray jSONArray) {
        CellLocation cellLocation;
        try {
            cellLocation = aVar.f.getCellLocation();
        } catch (Exception e) {
            e.printStackTrace();
            cellLocation = null;
        }
        if (cellLocation != null) {
            try {
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    jSONArray.put(aVar.a(aVar.h, gsmCellLocation.getCid(), gsmCellLocation.getLac()));
                } else if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    jSONArray.put(aVar.a(aVar.h, cdmaCellLocation.getBaseStationId(), cdmaCellLocation.getNetworkId()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            List<NeighboringCellInfo> neighboringCellInfo = aVar.f.getNeighboringCellInfo();
            if (neighboringCellInfo != null) {
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int rssi = (neighboringCellInfo2.getRssi() * 2) - 113;
                    int cid = neighboringCellInfo2.getCid();
                    int lac = neighboringCellInfo2.getLac();
                    if (cid < SupportMenu.USER_MASK) {
                        jSONArray.put(aVar.a(rssi, cid, lac));
                    }
                }
            }
            aVar.a(jSONArray);
            aVar.e();
        }
    }

    private void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!jSONArray2.toString().contains(jSONObject.toString())) {
                        jSONArray2.put(jSONObject);
                    }
                    i++;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            this.k = jSONArray2;
        }
    }

    private void e() {
        d.c(z[1], z[4]);
        if (this.j != null) {
            this.j.a();
        } else {
            d.g(z[1], z[3]);
        }
    }

    private void f() {
        try {
            this.i = new b(this);
            this.f.listen(this.i, 256);
        } catch (Exception e) {
            d.g(z[1], new StringBuilder(z[2]).append(e.getMessage()).toString());
            e();
        }
    }

    public final void a() {
        if (this.j == null) {
            d.g(z[1], z[32]);
            e();
            return;
        }
        CellLocation cellLocation;
        try {
            cellLocation = this.f.getCellLocation();
        } catch (Throwable e) {
            d.e(z[1], z[28], e);
            cellLocation = null;
        }
        if (cellLocation == null) {
            d.g(z[1], z[21]);
            e();
            return;
        }
        this.a = -1;
        this.b = -1;
        this.c = "";
        this.d = "";
        this.e = "";
        this.e = this.f.getNetworkOperatorName();
        int networkType = this.f.getNetworkType();
        d.a(z[20], new StringBuilder(z[27]).append(networkType).toString());
        String str = (networkType == 4 || networkType == 7 || networkType == 5 || networkType == 6 || networkType == 12 || networkType == 14) ? z[24] : networkType == 13 ? z[25] : z[23];
        d.a(z[20], new StringBuilder(z[31]).append(str).toString());
        this.c = str;
        this.d = l.a(this.g, this.f.getNetworkType());
        d.a(z[1], new StringBuilder(z[30]).append(this.c).append(z[19]).append(this.e).append(z[29]).append(this.d).toString());
        try {
            str = this.f.getNetworkOperator();
            if (str.length() > 3) {
                this.a = Integer.parseInt(str.substring(0, 3));
                this.b = a(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        List list = null;
        if (VERSION.SDK_INT > 17) {
            try {
                list = this.f.getAllCellInfo();
            } catch (Exception e3) {
                d.i(z[1], new StringBuilder(z[26]).append(e3).toString());
            }
            d.a(z[1], new StringBuilder(z[18]).append(r0 != null ? r0.size() : 0).toString());
            if (r0 == null || r0.size() == 0) {
                f();
                return;
            }
            for (CellInfo cellInfo : r0) {
                if (cellInfo == null) {
                    d.g(z[1], z[22]);
                }
                JSONObject a;
                if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    if (VERSION.SDK_INT > 17) {
                        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                        a = a(cellSignalStrength.getDbm(), cellIdentity.getCi(), cellIdentity.getTac(), 0);
                        if (a != null) {
                            jSONArray.put(a);
                        }
                    }
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    if (VERSION.SDK_INT > 17) {
                        CellSignalStrengthGsm cellSignalStrength2 = cellInfoGsm.getCellSignalStrength();
                        CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                        a = a(cellSignalStrength2.getDbm(), cellIdentity2.getCid(), cellIdentity2.getLac(), 1);
                        if (a != null) {
                            jSONArray.put(a);
                        }
                    }
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    if (VERSION.SDK_INT > 17) {
                        CellSignalStrengthCdma cellSignalStrength3 = cellInfoCdma.getCellSignalStrength();
                        CellIdentityCdma cellIdentity3 = cellInfoCdma.getCellIdentity();
                        a = a(cellSignalStrength3.getDbm(), cellIdentity3.getBasestationId(), cellIdentity3.getNetworkId(), 2);
                        if (a != null) {
                            jSONArray.put(a);
                        }
                    }
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    if (VERSION.SDK_INT > 17) {
                        CellSignalStrengthWcdma cellSignalStrength4 = cellInfoWcdma.getCellSignalStrength();
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        a = a(cellSignalStrength4.getDbm(), cellIdentity4.getCid(), cellIdentity4.getLac(), 3);
                        if (a != null) {
                            jSONArray.put(a);
                        }
                    }
                }
            }
            a(jSONArray);
            e();
            return;
        }
        f();
    }

    public final JSONArray b() {
        return this.k;
    }

    public final void c() {
        this.k = null;
    }

    public final void d() {
        d.c(z[1], z[0]);
        try {
            if (this.f != null && this.i != null) {
                this.f.listen(this.i, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
