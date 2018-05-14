package cn.jiguang.a.a.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import cn.jiguang.b.a.a;
import cn.jiguang.c.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class c {
    private static final SimpleDateFormat e = new SimpleDateFormat(z[40], Locale.ENGLISH);
    private static final String[] z;
    private LocationManager a;
    private e b;
    private String c = "";
    private f d;
    private final LocationListener f = new d(this);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 41;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u001c\u0006VD\u0017\u0019\u0006[";
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
            case 0: goto L_0x01f0;
            case 1: goto L_0x01f4;
            case 2: goto L_0x01f8;
            case 3: goto L_0x01fc;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 99;
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
            case 34: goto L_0x01a5;
            case 35: goto L_0x01b0;
            case 36: goto L_0x01bb;
            case 37: goto L_0x01c6;
            case 38: goto L_0x01d1;
            case 39: goto L_0x01dc;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0005\u0019QD\u0017\u0015IP]\u0000\u0015\u0019AL\f\u001e";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "7\u0019Fl\r\u0016\u0006xD\r\u0011\u000ePW";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "YI\\VC\u0019\u0007CD\u000f\u0019\r";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0005\u0019QD\u0017\u0015IYJ\u0000\u0011\u001d\\J\rP\u0000F\u0005\r\u0005\u0005Y";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001c\bAL\u0017\u0005\rP\r";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0005\u0019QD\u0017\u0015IYJ\u0000\u0011\u001d\\J\rP\u000fGJ\u000eP";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "P\bA\u0005\u000f\u001f\nTI7\u0019\u0004P\u0018";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0005\u0019QD\u0017\u0015>\\Q\u000b>\fBi\f\u0013\bAL\f\u001eIP]\u0000\u0015\u0019A@\u0007J";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "YIZWC\u001c\u0006[B\n\u0004\u001cQ@K";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\\\u001aPW\u0015\u0015\u001baL\u000e\u0015T";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "X\u0000Fi\u0002\u0003\u001d~K\f\u0007@";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0007\u0001PKC\u001c\u0006VD\u0017\u0019\u0006[\u0005\u0017\u0019\u0004P\u0005\f\u0005\u001d\u0015";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0017\fA\u0005\u0004\u0000\u001a\u0015Q\n\u001d\f\u0015J\u0016\u0004I";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0017\fA\u0005";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "P\u001d\\H\u0006P\u0006@QC";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "P\u0005ZF\u0002\u0004\u0000ZK";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u0017\u0019F";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u001e\fAR\f\u0002\u0002";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = ">\u0006\u0015V\u0016\u0019\u001dTG\u000f\u0015IE@\u0011\u001d\u0000FV\n\u001f\u0007\u0015R\u000b\u0015\u0007\u0015B\u0006\u0004IYD\u0010\u0004I^K\f\u0007\u0007\u0015I\f\u0013\bAL\f\u001eH";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0002\fDP\u0006\u0003\u001d\u0015";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "$\u0001P\u0005\u0013\u0002\u0006CL\u0007\u0015\u001b\u0015L\u0010P\u0000YI\u0006\u0017\bY\u0005\u0002\u0002\u000e@H\u0006\u001e\u001d\u0014";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "$\u0001P\u0005*<\u0006VD\u0017\u0019\u0006[h\u0002\u001e\bR@\u0011P\u0000F\u0005\r\u0005\u0005Y\u0004";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u0000\bFV\n\u0006\f";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "$\u0001P\u0005\u0013\u0002\u0006CL\u0007\u0015\u001b\u0015~\u0004\u0000\u001ah\u0005\n\u0003I\\I\u000f\u0015\u000eTIC\u0011\u001bRP\u000e\u0015\u0007A\u0004";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = ">\u0006\u0015V\u0016\u0019\u001dTG\u000f\u0015IE@\u0011\u001d\u0000FV\n\u001f\u0007\u0015L\u0010P\u0019G@\u0010\u0015\u0007A\u0005\u0014\u0018\f[\u0005\u0004\u0015\u001d\u0015b3#6ew,& q`1Q";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\u0002\fXJ\u0015\u0015IYJ\u0000\u0011\u001d\\J\rP\u0005\\V\u0017\u0015\u0007PWC\u0016\b\\I\u0006\u0014I\u0015@Y";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "<\u0006VD\u0017\u0019\u0006[\u0005\u000f\u0019\u001aA@\r\u0015\u001b\u0015L\u0010P\u0007@I\u000fPE\u0015A\fP\u0007ZQ\u000b\u0019\u0007R\u0004";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\u001c\u0006VD\u0017\u0019\u0006[h\u0002\u001e\bR@\u0011P\u0000F\u0005\r\u0005\u0005Y\u0005OP\rZ\u0005\r\u001f\u001d]L\r\u0017H";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\u0003\u001dZU";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u0013\fYI/\u001f\nTQ\n\u001f\u0007xD\r\u0011\u000ePWC\u0019\u001a\u0015K\u0016\u001c\u0005\u0019U\u000f\u0015\bF@C\u0013\u0001PF\bP\u0000A";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "\u001e\fAi\f\u0013\bAL\f\u001eS";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u001e\u0006\u0015U\u0006\u0002\u0004\\V\u0010\u0019\u0006[";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "\u001e\u0006\u0015@\r\u0011\u000bY@\u0007P\u0019GJ\u0015\u0019\rPW";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "\u0011\u0007QW\f\u0019\r\u001bU\u0006\u0002\u0004\\V\u0010\u0019\u0006[\u000b\"3*pv0//|k&/%zf\"$ zk";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\u0000\bFV/\u001f\nTQ\n\u001f\u0007\u000f";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "\"\fDP\n\u0002\f\u0015Q\u000b\u0015IE@\u0011\u001d\u0000FV\n\u001f\u0007TK\u0007\u0002\u0006\\AM\u0000\fGH\n\u0003\u001a\\J\r^(vf&#:jc*>,ji,3(al,>";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "\u001e\fPAC\u001e\u0006A\u0005\u0011\u0015\u001aAD\u0011\u0004IRU\u0010\u001c\u0006VD\u0017\u0019\u0006[\t\u0017\u0018\f\u0015Q\n\u001d\f\u0015R\n\u0004\u0001\u0015I\u0002\u0003\u001d\u000f";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "\u001c\u0006VD\u0017\u0019\u0006[h\u0002\u001e\bR@\u0011P\u0000F\u0005\r\u0005\u0005Y";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "\u0017\u0019Fi\f\u0013\bAL\f\u001eS";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "\t\u0010L\\N=$\u0018A\u0007P!}\u001f\u000e\u001dSFV";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        z = r4;
        r0 = new java.text.SimpleDateFormat;
        r1 = z;
        r2 = 40;
        r1 = r1[r2];
        r2 = java.util.Locale.ENGLISH;
        r0.<init>(r1, r2);
        e = r0;
        return;
    L_0x01f0:
        r9 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        goto L_0x0020;
    L_0x01f4:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x0020;
    L_0x01f8:
        r9 = 53;
        goto L_0x0020;
    L_0x01fc:
        r9 = 37;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.c.<clinit>():void");
    }

    public c(Context context, f fVar) {
        this.a = (LocationManager) context.getSystemService(z[0]);
        this.d = fVar;
    }

    private void a(Location location, String str, boolean z) {
        if (location != null) {
            try {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                if (e.a(latitude, longitude)) {
                    long a = a.a(location.getTime());
                    d.c(z[2], new StringBuilder(z[6]).append(str).append(z ? z[11] : "").append(z[7]).append(b(location.getTime())).append(z[10]).append(b(1000 * a)).toString());
                    this.b = new e(latitude, longitude, location.getAltitude(), location.getBearing(), location.getAccuracy(), str, a, z);
                    return;
                }
                a(new StringBuilder(z[5]).append(latitude).append(z[9]).append(longitude).append(z[3]).toString());
                return;
            } catch (Exception e) {
                d.i(z[2], new StringBuilder(z[8]).append(e.getMessage()).toString());
                a(new StringBuilder(z[1]).append(e.getMessage()).toString());
                return;
            }
        }
        a(z[4]);
    }

    private void a(String str) {
        this.b = new e(str);
    }

    private static String b(long j) {
        return e.format(new Date(j));
    }

    private boolean c() {
        try {
            return this.a != null ? this.a.isProviderEnabled(z[17]) || this.a.isProviderEnabled(z[18]) || this.a.isProviderEnabled(z[23]) : false;
        } catch (SecurityException e) {
            d.g(z[2], z[25]);
            return false;
        } catch (IllegalArgumentException e2) {
            d.g(z[2], z[24]);
            return false;
        } catch (Exception e3) {
            d.g(z[2], z[22]);
            return false;
        }
    }

    private void d() {
        d.a(z[2], z[29]);
        e();
        if (this.d != null) {
            this.d.b();
        } else {
            d.h(z[2], z[30]);
        }
    }

    private void e() {
        try {
            if (this.f == null) {
                d.g(z[2], z[27]);
            } else if (this.a != null) {
                this.a.removeUpdates(this.f);
            } else {
                d.g(z[2], z[28]);
            }
        } catch (Throwable th) {
            d.g(z[2], new StringBuilder(z[26]).append(th.getMessage()).toString());
        }
    }

    protected final e a() {
        return this.b;
    }

    protected final void a(Context context) {
        long j = 0;
        if (!cn.jiguang.e.a.b(context, z[34])) {
            d.g(z[2], z[36]);
            a(z[32]);
            this.d.b();
        } else if (c()) {
            try {
                if (this.a != null) {
                    Location lastKnownLocation = this.a.getLastKnownLocation(z[17]);
                    Location lastKnownLocation2 = this.a.getLastKnownLocation(z[18]);
                    Location lastKnownLocation3 = this.a.getLastKnownLocation(z[23]);
                    d.a(z[2], new StringBuilder(z[39]).append(lastKnownLocation).toString());
                    d.a(z[2], new StringBuilder(z[31]).append(lastKnownLocation2).toString());
                    d.a(z[2], new StringBuilder(z[35]).append(lastKnownLocation3).toString());
                    long time = lastKnownLocation == null ? 0 : lastKnownLocation.getTime();
                    long time2 = lastKnownLocation2 == null ? 0 : lastKnownLocation2.getTime();
                    long time3 = lastKnownLocation3 == null ? 0 : lastKnownLocation3.getTime();
                    if (time > time2) {
                        if (time > time3) {
                            lastKnownLocation3 = lastKnownLocation;
                        }
                    } else if (time2 > time3) {
                        lastKnownLocation3 = lastKnownLocation2;
                    }
                    a(lastKnownLocation3, lastKnownLocation3 != null ? lastKnownLocation3.getProvider() : "", true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (lastKnownLocation3 != null) {
                        j = lastKnownLocation3.getTime();
                    }
                    if (currentTimeMillis - j < 30000) {
                        d.c(z[2], new StringBuilder(z[37]).append(System.currentTimeMillis() - lastKnownLocation3.getTime()).toString());
                        d();
                        return;
                    }
                    if (this.a.isProviderEnabled(z[17])) {
                        this.c = z[17];
                    } else {
                        this.a.isProviderEnabled(z[18]);
                        this.c = z[18];
                    }
                    this.d.a.sendEmptyMessage(PointerIconCompat.TYPE_HAND);
                    return;
                }
                d.g(z[2], z[38]);
                d();
            } catch (SecurityException e) {
                d.g(z[2], z[19]);
                d();
            } catch (Exception e2) {
                d.g(z[2], z[21]);
                d();
            }
        } else {
            a(z[33]);
            this.d.b();
        }
    }

    protected final void a(Message message) {
        switch (message.what) {
            case 1001:
                try {
                    if (this.c == null || !this.c.equals(z[17])) {
                        d.g(z[2], new StringBuilder(z[14]).append(this.c).append(z[15]).toString());
                        d();
                        return;
                    }
                    d.g(z[2], z[13]);
                    this.c = z[18];
                    e();
                    this.a.requestLocationUpdates(this.c, 2000, 0.0f, this.f);
                    d.c(z[2], new StringBuilder(z[20]).append(this.c).append(z[16]).toString());
                    this.d.a.sendEmptyMessageDelayed(1001, 15000);
                    return;
                } catch (Throwable th) {
                    d.g(z[2], new StringBuilder(z[12]).append(th.getMessage()).toString());
                    d();
                    return;
                }
            case PointerIconCompat.TYPE_HAND /*1002*/:
                try {
                    this.a.requestLocationUpdates(this.c, 2000, 0.0f, this.f);
                    d.c(z[2], new StringBuilder(z[20]).append(this.c).append(z[16]).toString());
                    this.d.a.sendEmptyMessageDelayed(1001, 30000);
                    return;
                } catch (SecurityException e) {
                    d.g(z[2], z[19]);
                    d();
                    return;
                } catch (Throwable th2) {
                    d.g(z[2], z[21]);
                    d();
                    return;
                }
            default:
                return;
        }
    }

    public final void b() {
        this.b = null;
    }
}
