package cn.jiguang.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.jiguang.android.ShareValues;
import cn.jiguang.b.a.f;
import cn.jiguang.b.f.a.a;
import cn.jiguang.c.d;

public abstract class BasePreferenceManager {
    private static final String AES_ENCRYPTION_SEED;
    public static final String JPUSH_PREF;
    private static SharedPreferences mSharedPreferences = null;
    private static final String[] z;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = 2;
        r1 = 1;
        r3 = 0;
        r4 = new java.lang.String[r2];
        r0 = "/ \fn\u000e)W}\u0014\r*%\t\u0012\b^";
        r5 = r3;
        r6 = r4;
        r7 = r4;
        r4 = r0;
        r0 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r1) goto L_0x0068;
    L_0x0013:
        r9 = r3;
    L_0x0014:
        r10 = r4;
        r11 = r9;
        r14 = r8;
        r8 = r4;
        r4 = r14;
    L_0x0019:
        r13 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x005c;
            case 1: goto L_0x005f;
            case 2: goto L_0x0062;
            case 3: goto L_0x0065;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 58;
    L_0x0022:
        r12 = r12 ^ r13;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x003b;
    L_0x002a:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x0019;
    L_0x002e:
        AES_ENCRYPTION_SEED = r4;
        r0 = "\b\bc<J\u001e\u0015%xJ\u0019\u0003+3H\u000e\b.3IE\u0010";
        r4 = r0;
        r0 = r2;
        goto L_0x000c;
    L_0x0035:
        JPUSH_PREF = r4;
        r4 = ">\b(.J\u000e\u000593^KKm0[\u0002\n(2\u001a\u001f\tm\u00178F(8Y\u0019\u001f=\"\u0014";
        r0 = -1;
        goto L_0x000c;
    L_0x003b:
        r8 = r4;
        r4 = r10;
    L_0x003d:
        if (r8 > r9) goto L_0x0014;
    L_0x003f:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0054;
            case 1: goto L_0x002e;
            case 2: goto L_0x0035;
            default: goto L_0x004b;
        };
    L_0x004b:
        r6[r5] = r4;
        r0 = ">\b(.J\u000e\u000593^KKm0[\u0002\n(2\u001a\u001f\tm\u00178F)3Y\u0019\u001f=\"\u0014";
        r4 = r0;
        r5 = r1;
        r6 = r7;
        r0 = r3;
        goto L_0x000c;
    L_0x0054:
        r6[r5] = r4;
        z = r7;
        r0 = 0;
        mSharedPreferences = r0;
        return;
    L_0x005c:
        r12 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0022;
    L_0x005f:
        r12 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        goto L_0x0022;
    L_0x0062:
        r12 = 77;
        goto L_0x0022;
    L_0x0065:
        r12 = 86;
        goto L_0x0022;
    L_0x0068:
        r9 = r3;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.BasePreferenceManager.<clinit>():void");
    }

    protected static void applyBuffer(Context context, ShareValues shareValues) {
        init(context);
        shareValues.a(mSharedPreferences, true);
    }

    protected static void applyBuffer(ShareValues shareValues) {
        if (mSharedPreferences != null) {
            shareValues.a(mSharedPreferences, true);
        }
    }

    protected static void commitBoolean(Context context, String str, boolean z) {
        init(context);
        Editor edit = mSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    protected static void commitBoolean(String str, boolean z) {
        if (mSharedPreferences != null) {
            Editor edit = mSharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    protected static void commitInt(Context context, String str, int i) {
        init(context);
        Editor edit = mSharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    protected static void commitInt(String str, int i) {
        if (mSharedPreferences != null) {
            Editor edit = mSharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    protected static void commitLong(Context context, String str, long j) {
        init(context);
        Editor edit = mSharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    protected static void commitLong(String str, long j) {
        if (mSharedPreferences != null) {
            Editor edit = mSharedPreferences.edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }

    protected static void commitString(Context context, String str, String str2) {
        init(context);
        Editor edit = mSharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    protected static void commitString(String str, String str2) {
        if (mSharedPreferences != null) {
            Editor edit = mSharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    protected static void commitStringWithEncryption(String str, String str2) {
        Editor edit = mSharedPreferences.edit();
        edit.putString(str, getEncryptedString(str2));
        edit.apply();
    }

    protected static Boolean getBoolean(Context context, String str, boolean z) {
        init(context);
        return Boolean.valueOf(mSharedPreferences.getBoolean(str, z));
    }

    protected static Boolean getBoolean(String str, boolean z) {
        return mSharedPreferences != null ? Boolean.valueOf(mSharedPreferences.getBoolean(str, z)) : Boolean.valueOf(z);
    }

    public static String getDecryptString(String str, String str2) {
        try {
            str2 = a.b(str, AES_ENCRYPTION_SEED);
        } catch (Exception e) {
            d.g("", z[1]);
        }
        return str2;
    }

    public static String getEncryptedString(String str) {
        String str2 = "";
        try {
            str2 = a.a(str, AES_ENCRYPTION_SEED);
        } catch (Exception e) {
            d.g("", z[0]);
        }
        return str2;
    }

    protected static int getInt(Context context, String str, int i) {
        init(context);
        return mSharedPreferences.getInt(str, i);
    }

    protected static int getInt(String str, int i) {
        return mSharedPreferences != null ? mSharedPreferences.getInt(str, i) : i;
    }

    protected static long getLong(Context context, String str, long j) {
        init(context);
        return mSharedPreferences.getLong(str, j);
    }

    protected static long getLong(String str, long j) {
        return mSharedPreferences != null ? mSharedPreferences.getLong(str, j) : j;
    }

    protected static String getString(Context context, String str, String str2) {
        init(context);
        return mSharedPreferences.getString(str, str2);
    }

    protected static String getString(String str, String str2) {
        return mSharedPreferences != null ? mSharedPreferences.getString(str, str2) : str2;
    }

    protected static String getStringUnencrypted(String str, String str2) {
        return getDecryptString(mSharedPreferences.getString(str, str2), str2);
    }

    public static void init(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = context.getSharedPreferences(JPUSH_PREF, 0);
        }
        f.a(context);
    }

    public static void removeAll() {
        Editor edit = mSharedPreferences.edit();
        edit.clear();
        edit.commit();
    }

    public static void removeKey(String str) {
        Editor edit = mSharedPreferences.edit();
        edit.remove(str);
        edit.commit();
    }
}
