package cn.jiguang.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import cn.jiguang.android.ShareValues;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.e.j;

public final class a extends BasePreferenceManager {
    public static String a = "";
    public static int b = -1;
    public static boolean c = false;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 53;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "~Sb\f&u]~\u001c&q]\u0016&b]c\f";
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
            case 0: goto L_0x026f;
            case 1: goto L_0x0273;
            case 2: goto L_0x0277;
            case 3: goto L_0x027b;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
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
            case 40: goto L_0x01e7;
            case 41: goto L_0x01f2;
            case 42: goto L_0x01fd;
            case 43: goto L_0x0208;
            case 44: goto L_0x0213;
            case 45: goto L_0x021e;
            case 46: goto L_0x0229;
            case 47: goto L_0x0234;
            case 48: goto L_0x023f;
            case 49: goto L_0x024a;
            case 50: goto L_0x0255;
            case 51: goto L_0x0260;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "zWp\n\rpWp\f&{\\e\u001d\u000bdS}";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "vWg\u0011\u001awm|\u0019\u0010|mp\u0016\u001d`]x\u001c&{V";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "vWg\u0011\u001awm|\u0019\u0010|m|\u0019\u001a";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "vWg\u0011\u001awm|\u0019\u0010|mx\u0015\u001c{";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "vWw\u0019\f~FN\u001b\u0016|\\N\u0011\t";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "pSr\u0013\fbmd\u000b\u001c`mp\u001c\u001d`";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "aVz'\u000fw@b\u0011\u0016|";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "~Sb\f&`Wa\u0017\u000bfmx\u0016\u001dwJ";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "~]v\u0011\u0017MAt\n\u000fw@N\f\u0010W";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "~]v\u0011\u0017M^~\u001b\u0018~me\u0011\u0014w";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "vWg\u0011\u001awmr\u0010\u0018|\\t\u0014";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "{_t\u0011";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "~Sb\f&a[b'\u000bwCd\u001d\nfme\u0011\u0014w";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "{_N\u0014\u0016u['\u001a}G\f";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "bGb\u0010&gVx\u001c";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "~Sb\f&u]~\u001c&q]\u0016&{B";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "~Sb\f&u]~\u001c&a[b";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "vWw\u0019\f~FN\u001b\u0016|\\N\b\u0016`F";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "vWg\u0011\u001awmc\u001d\u001e{Ae\u001d\u000bwVN\u0019\tbYt\u0001";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "~Sb\f&q]\u0016\u001cqFx\u0017\u0017MFh\b\u001c";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "aWe\f\u0010|UN\u000b\u0010~W\u001b\u001cMBd\u000b\u0011MFx\u0015\u001c";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "bGb\u0010\r{_t";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "~]v\u0011\u0017M@t\b\u0016`FN\f\u0010W";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "`Wv\u0011\nfWc'\u001dwDx\u001b\u001cM[|\u001d\u0010";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "`Wv\u0011\nfWc'\u001dwDx\u001b\u001cM_p\u001b";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "~Qe\u0011\u0014w";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "vWg'\u0010|T~'\u000bwBN\f\u0010W";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "vWg\u0011\u001awm|\u0019\u0010|mx\u001c\n";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "aWe\f\u0010|UN\b\faZN\f\u0010W";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "`Wv\u0011\nfWc'\u001dwDx\u001b\u001cMS\u001c\u000b}[u'\u0010v";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "`Wv\u0011\nf@p\f\u0010}\\N\u0011\u001d";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "xBd\u000b\u0011MAx\u000b&|We\f\u0000bW";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "|]e\u0011\u001f{Qp\f\u0010}\\N\u0016\f";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "aWc\u000e\u0010qWN\u001b\u0016|\\t\u001b\u001cf";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "b~\n\r";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "a[}\u001d\u0017qWA\r\nzfx\u0015\u001c";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "xBd\u000b\u0011MQ~\u0016\u0017M_x\b";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "aWc\u000e\u0010qWN\u000b\r}Bt\u001c";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "~Sb\f&`Wa\u0017\u000bfmu\u001d\u000f{Qt'\u0010|T~";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "q\\?\u0012\tgAyV\nw@g\u001d\u000bq]\u001e\u0010u";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "`Wv\u0011\nfWc'\u001dwDx\u001b\u001cM[\u001e\u0016";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "xBd\u000b\u0011MAx\u000b&`Wr\u001d\u0010dWc'\nf@x\u0016\u001e";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "~Sb\f&`Wa\u0017\u000bfm}\u0017\u001asFx\u0017\u0017";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "|]e\u0011\u001fsQe\u0011\u0016|m\r\u0014";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "q\\?\u0012\tgAyV\u0018|Vc\u0017\u0010v\u001cP()YwH";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "xBd\u000b\u0011MQ~\u0016\u0017M_a\u0017\u000bf";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "Xbd\u000b\u0011Mvt\u000e\u0010qWX\u001c";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "zFe\b&`Wa\u0017\u000bfmb\u0011\nMGc\u0014";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "{A";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "{AN\u0011\u0014M^~\u001f\u001ewVN\u0011\u0017";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "xBd\u000b\u0011M@t\u001f\u0010aFt\n&q]u\u001d";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "t]~HI#";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        z = r4;
        r0 = "";
        a = r0;
        r0 = -1;
        b = r0;
        r0 = 0;
        c = r0;
        return;
    L_0x026f:
        r9 = 18;
        goto L_0x0020;
    L_0x0273:
        r9 = 50;
        goto L_0x0020;
    L_0x0277:
        r9 = 17;
        goto L_0x0020;
    L_0x027b:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.a.a.<clinit>():void");
    }

    public static long a(long j) {
        return (r() + j) / 1000;
    }

    public static String a(Context context) {
        return BasePreferenceManager.getString(context, z[15], "");
    }

    public static void a(Context context, int i) {
        d.a(context, z[51], Integer.valueOf(i));
    }

    public static void a(Context context, String str) {
        BasePreferenceManager.commitString(context, z[15], str);
    }

    public static void a(Context context, String str, String str2) {
        d.a(context, str, BasePreferenceManager.getEncryptedString(str2));
    }

    public static void a(String str, int i) {
        BasePreferenceManager.applyBuffer(new ShareValues().a(z[16], str).a(z[0], i));
    }

    public static void a(String str, long j) {
        BasePreferenceManager.commitLong(str, j);
    }

    public static void a(String str, String str2, String str3) {
        BasePreferenceManager.applyBuffer(new ShareValues().b(z[4], str).b(z[2], str2).b(z[3], str3));
    }

    public static synchronized boolean a() {
        boolean z;
        synchronized (a.class) {
            long j = BasePreferenceManager.getLong(z[8], 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j > 86400000) {
                BasePreferenceManager.commitLong(z[8], currentTimeMillis);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static boolean a(String str) {
        if (str == null) {
            return true;
        }
        if (str.equalsIgnoreCase(BasePreferenceManager.getString(z[20], null))) {
            return false;
        }
        BasePreferenceManager.commitString(z[20], str);
        return true;
    }

    public static long b() {
        return BasePreferenceManager.getLong(z[8], 0);
    }

    public static String b(Context context) {
        return BasePreferenceManager.getString(context, z[12], "");
    }

    public static String b(Context context, String str, String str2) {
        String str3 = (String) d.b(context, str, "");
        return j.a(str3) ? str2 : BasePreferenceManager.getDecryptString(str3, str2);
    }

    public static void b(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        b.a(j, currentTimeMillis);
        BasePreferenceManager.applyBuffer(new ShareValues().a(z[9], j).a(z[10], currentTimeMillis));
    }

    public static void b(Context context, String str) {
        BasePreferenceManager.commitString(context, z[12], str);
    }

    public static void b(String str) {
        BasePreferenceManager.commitString(z[6], str);
    }

    public static void b(String str, int i) {
        BasePreferenceManager.applyBuffer(new ShareValues().a(z[5], str).a(z[18], i));
    }

    public static String c() {
        return BasePreferenceManager.getString(z[16], null);
    }

    public static void c(Context context) {
        BasePreferenceManager.init(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(z[40], 0);
        BasePreferenceManager.applyBuffer(context, new ShareValues().a(z[28], sharedPreferences.getString(z[41], "")).a(z[4], sharedPreferences.getString(z[24], "")).a(z[2], sharedPreferences.getString(z[30], "")).a(z[3], sharedPreferences.getString(z[25], "")).a(z[20], sharedPreferences.getString(z[32], "")).a(z[17], sharedPreferences.getString(z[42], "")).a(z[5], sharedPreferences.getString(z[49], "")).a(z[16], sharedPreferences.getString(z[37], "")).a(z[15], sharedPreferences.getString(z[15], "")).a(z[12], sharedPreferences.getString(z[12], "")).a(z[18], sharedPreferences.getInt(z[35], 0)).a(z[0], sharedPreferences.getInt(z[46], 0)).a(z[10], sharedPreferences.getLong(z[26], 0)).a(z[9], sharedPreferences.getLong(z[9], 0)));
        d.a(context, new ShareValues().a(z[39], sharedPreferences.getLong(z[27], 0)).a(z[43], sharedPreferences.getLong(z[23], 0)).a(z[21], sharedPreferences.getString(z[36], "")).a(z[29], sharedPreferences.getString(z[22], "")).a(z[33], sharedPreferences.getInt(z[44], 5)).a(z[38], sharedPreferences.getInt(z[38], 0)));
        d.a(context, sharedPreferences.getString(z[31], ""), sharedPreferences.getString(z[47], ""), sharedPreferences.getString(z[45], ""), sharedPreferences.getString(z[48], ""), sharedPreferences.getInt(z[34], 0) == 1 ? cn.jiguang.b.b.a.a.name() : cn.jiguang.b.b.a.b.name());
    }

    public static void c(String str) {
        BasePreferenceManager.commitString(z[17], str);
    }

    public static int d() {
        return BasePreferenceManager.getInt(z[0], 0);
    }

    public static String d(String str) {
        return BasePreferenceManager.getString(z[11], str);
    }

    public static void e(String str) {
        BasePreferenceManager.commitString(z[11], str);
    }

    public static boolean e() {
        return System.currentTimeMillis() - BasePreferenceManager.getLong(z[13], 0) > 180000;
    }

    public static void f() {
        BasePreferenceManager.commitLong(z[13], System.currentTimeMillis());
    }

    public static void f(String str) {
        BasePreferenceManager.commitString(z[7], str);
    }

    public static synchronized long g() {
        long a;
        synchronized (a.class) {
            a = f.a();
        }
        return a;
    }

    public static void g(String str) {
        if (str != null) {
            BasePreferenceManager.commitString(z[19], str);
        } else {
            BasePreferenceManager.removeKey(z[19]);
        }
    }

    public static int h() {
        return BasePreferenceManager.getInt(z[1], 290);
    }

    public static long h(String str) {
        return BasePreferenceManager.getLong(str, 0);
    }

    public static void i() {
        BasePreferenceManager.commitInt(z[1], 290);
    }

    public static void j() {
        BasePreferenceManager.commitInt(z[1], 86400);
    }

    public static boolean k() {
        return h() == 86400;
    }

    public static String l() {
        return BasePreferenceManager.getString(z[5], "");
    }

    public static int m() {
        return BasePreferenceManager.getInt(z[18], 7000);
    }

    public static String n() {
        return BasePreferenceManager.getString(z[17], null);
    }

    public static String o() {
        return BasePreferenceManager.getString(z[52], null);
    }

    public static String p() {
        return BasePreferenceManager.getString(z[7], "");
    }

    public static long q() {
        return a(System.currentTimeMillis());
    }

    public static long r() {
        if (b.a()) {
            return b.b();
        }
        long j = BasePreferenceManager.getLong(z[10], 0);
        long j2 = BasePreferenceManager.getLong(z[9], 0);
        b.a(j2, j);
        return j2 - j;
    }

    public static String s() {
        return BasePreferenceManager.getString(z[19], null);
    }

    public static c t() {
        return new c(BasePreferenceManager.getString(z[4], ""), BasePreferenceManager.getString(z[2], ""), BasePreferenceManager.getString(z[3], ""));
    }

    public static boolean u() {
        return ((Boolean) d.b(null, z[50], Boolean.valueOf(false))).booleanValue();
    }

    public static int v() {
        return ((Integer) d.b(null, z[14], Integer.valueOf(-1))).intValue();
    }
}
