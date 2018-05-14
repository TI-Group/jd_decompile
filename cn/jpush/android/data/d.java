package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.d.e;
import com.jingdong.jdma.common.utils.CommonUtil;

/* compiled from: TbsSdkJava */
public final class d extends f {
    private static final String[] a;
    private static volatile d b;
    private static final Object c = new Object();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 25;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "衁嶅绠嬌圗";
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
            case 0: goto L_0x013c;
            case 1: goto L_0x0140;
            case 2: goto L_0x0144;
            case 3: goto L_0x0148;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 63;
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
            case 24: goto L_0x014c;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "e\u0018L5Sg\u0018[=Y@\u0014N VF\u0019k6";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "j%j\u0015klW{\u0015}e2\u000f `E\u0018L5SG\u0018[=Y@\u0014N VF\u0019\u000f|`@\u0013\u000f\u001dq}2h\u0011m\t'}\u001drh%vttl.\u000f\u0015j}8f\u001a|{2b\u0011q}W\u00038Qv\u001eKtSF\u0019HtQF\u0003\u000f:JE\u001b\u00038Qv\u0014@!Q]WF:KL\u0010J&\u001fG\u0018[tQ\\\u001bCxSG(]1RF\u0001JtVG\u0003J3Z[WA;K\t\u0019Z8S\u0005\u001bA\u000bKP\u0007JtVG\u0003J3Z[WA;K\t\u0019Z8S\u0005\u001bA\u000bZQ\u0003]5\u001f]\u0012W \u001f\u0005\u001bA\u000bK[\u001eH3Z[([=RLWC;QNW\u00038Qv\u0016K0`]\u001eB1\u001fE\u0018A3\u001f\u0000L";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "E\u0019p=[\u0014";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "](C;\\H\u001bA;K@\u0011F7^]\u001e@:";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0014G";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\t\u0016A0\u001fE\u0019p FY\u0012";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "F\u0007J:\u001fM\u0016[5]H\u0004JtYH\u001eC1[";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "@\u0019F sF\u0014N8qF\u0003F2VJ\u0016[=PG3m\u0010^]\u0016\u000f1GJ\u0012_ VF\u0019\u0015";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "J\u0002]'P[WF'\u001fG\u0002C8";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "E\u0019p1G]\u0005N";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "E\u0019p FY\u0012";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "E\u0019p7P\\\u0019[";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "E\u0019p&ZD\u0018Y1";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "E\u0019p M@\u0010H1Mv\u0003F9Z";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "E\u0019p=[";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "E\u0019p5[M([=RL";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\t\u0016A0\u001fE\u0019p M@\u0010H1Mv\u0003F9Z";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "N\u0012[\u0006KJ3N ^ZWJ,\\L\u0007[=PGM";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "E\u0019p7P\\\u0019[j\u000f\t\u0016A0\u001fE\u0019p M@\u0010H1Mv\u0003F9Z\u0015";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "C\u0007Z'Wv\u001b@7^E(A;K@\u0011F7^]\u001e@:\u0011M\u0015";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "M\u0012C1KLWI&PDW[\u000bSF\u0014N8QF\u0003F2VJ\u0016[=PG";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "m%`\u0004\u001f}6m\u0018z\t>itzq>|\u0000l\t\u0003p8PJ\u0016C:P]\u001eI=\\H\u0003F;Q";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "E\u0019p7P\\\u0019[i";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "N\u0012[\u001bJ]3N ^ZWJ,\\L\u0007[=PGM";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        z = r4;
        r0 = 8;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "v\u001eK";
        r0 = 24;
        r4 = r3;
        goto L_0x0009;
    L_0x013c:
        r9 = 41;
        goto L_0x0020;
    L_0x0140:
        r9 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x0020;
    L_0x0144:
        r9 = 47;
        goto L_0x0020;
    L_0x0148:
        r9 = 84;
        goto L_0x0020;
    L_0x014c:
        r3[r2] = r1;
        r0 = 1;
        r1 = z;
        r2 = 15;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 2;
        r1 = z;
        r2 = 12;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 3;
        r1 = z;
        r2 = 13;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 4;
        r1 = z;
        r2 = 11;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 5;
        r1 = z;
        r2 = 10;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 6;
        r1 = z;
        r2 = 14;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 7;
        r1 = z;
        r2 = 16;
        r1 = r1[r2];
        r4[r0] = r1;
        a = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.d.<clinit>():void");
    }

    private d(Context context) {
        super(context, z[20], null, 1);
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new d(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public static e a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            e.c(z[1], z[9]);
            return null;
        }
        try {
            e eVar = new e();
            eVar.a(cursor.getLong(1));
            eVar.a(cursor.getInt(2));
            eVar.b(cursor.getInt(3));
            eVar.c(cursor.getInt(4));
            eVar.a(cursor.getString(5));
            eVar.c(cursor.getLong(6));
            eVar.b(cursor.getLong(7));
            e.e(z[1], eVar.toString());
            return eVar;
        } catch (Exception e) {
            e.getStackTrace();
            e.g(z[1], new StringBuilder(z[8]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final int a(long j) {
        if (a(true)) {
            int delete;
            try {
                delete = getWritableDatabase().delete(z[4], new StringBuilder(z[3]).append(j).toString(), null);
                return delete;
            } catch (Exception e) {
                delete = e;
                delete.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public final long a(long j, int i, int i2, int i3, String str, long j2, long j3) {
        long j4 = 0;
        if (a(true)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(z[15], Long.valueOf(j));
                contentValues.put(z[12], Integer.valueOf(1));
                contentValues.put(z[13], Integer.valueOf(0));
                contentValues.put(z[11], Integer.valueOf(0));
                contentValues.put(z[10], str);
                contentValues.put(z[14], Long.valueOf(j2));
                contentValues.put(z[16], Long.valueOf(j3));
                j4 = getWritableDatabase().insert(z[4], null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                b(true);
            }
        }
        return j4;
    }

    public final Cursor a(int i, long j) {
        try {
            return getReadableDatabase().query(true, z[4], a, new StringBuilder(z[23]).append(1).append(z[17]).append("<").append(j).toString(), null, null, null, null, null);
        } catch (Exception e) {
            e.g(z[1], new StringBuilder(z[24]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final Cursor a(long j, long j2) {
        try {
            return getReadableDatabase().query(true, z[4], a, new StringBuilder(z[19]).append(CommonUtil.REPORT_ERROR_SLEEP_TIME + j).append(z[17]).append(">").append(j).toString(), null, null, null, null, null);
        } catch (Exception e) {
            e.g(z[1], new StringBuilder(z[18]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final e a(long j, int i) throws Exception {
        Throwable th;
        if (a(false)) {
            Cursor query;
            try {
                query = getReadableDatabase().query(true, z[4], a, new StringBuilder(z[3]).append(j).append(z[6]).append(z[5]).toString(), null, null, null, null, null);
                if (query != null) {
                    try {
                        query.moveToFirst();
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        b(false);
                        throw th;
                    }
                }
                e a = a(query);
                if (query != null) {
                    query.close();
                }
                b(false);
                return a;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                b(false);
                throw th;
            }
        }
        throw new Exception(z[7]);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] a() {
        /*
        r13 = this;
        r10 = 0;
        r12 = 1;
        r11 = 0;
        r4 = "1";
        r0 = r13.a(r11);
        if (r0 == 0) goto L_0x00b7;
    L_0x000b:
        r0 = 1;
        r3 = new java.lang.String[r0];	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r0 = 0;
        r1 = z;	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r2 = 15;
        r1 = r1[r2];	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r3[r0] = r1;	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r0 = r13.getReadableDatabase();	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r1 = 1;
        r2 = z;	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r5 = 4;
        r2 = r2[r5];	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x006f, all -> 0x0084 }
        if (r2 == 0) goto L_0x00b5;
    L_0x002c:
        r0 = r2.getCount();	 Catch:{ Exception -> 0x009f, all -> 0x0095 }
        if (r0 <= 0) goto L_0x00b5;
    L_0x0032:
        r0 = r2.getCount();	 Catch:{ Exception -> 0x009f, all -> 0x0095 }
        r10 = new int[r0];	 Catch:{ Exception -> 0x009f, all -> 0x0095 }
        r2.moveToFirst();	 Catch:{ Exception -> 0x00a5, all -> 0x0095 }
        r0 = r11;
    L_0x003c:
        r1 = 0;
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x00a5, all -> 0x0095 }
        r10[r0] = r1;	 Catch:{ Exception -> 0x00a5, all -> 0x0095 }
        r0 = r0 + 1;
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x00a5, all -> 0x0095 }
        if (r1 != 0) goto L_0x003c;
    L_0x004b:
        r0 = r10;
    L_0x004c:
        r1 = 1;
        r1 = r13.a(r1);	 Catch:{ Exception -> 0x00ab, all -> 0x0095 }
        if (r1 == 0) goto L_0x00b3;
    L_0x0053:
        r1 = z;	 Catch:{ Exception -> 0x00af, all -> 0x0098 }
        r3 = 21;
        r1 = r1[r3];	 Catch:{ Exception -> 0x00af, all -> 0x0098 }
        r3 = r13.getWritableDatabase();	 Catch:{ Exception -> 0x00af, all -> 0x0098 }
        r3.execSQL(r1);	 Catch:{ Exception -> 0x00af, all -> 0x0098 }
        r1 = r12;
    L_0x0061:
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r2.close();
    L_0x0066:
        r13.b(r11);
        if (r1 == 0) goto L_0x006e;
    L_0x006b:
        r13.b(r12);
    L_0x006e:
        return r0;
    L_0x006f:
        r0 = move-exception;
        r1 = r0;
        r2 = r11;
        r0 = r10;
    L_0x0073:
        r1.printStackTrace();	 Catch:{ all -> 0x009b }
        if (r10 == 0) goto L_0x007b;
    L_0x0078:
        r10.close();
    L_0x007b:
        r13.b(r11);
        if (r2 == 0) goto L_0x006e;
    L_0x0080:
        r13.b(r12);
        goto L_0x006e;
    L_0x0084:
        r0 = move-exception;
        r2 = r10;
        r1 = r11;
    L_0x0087:
        if (r2 == 0) goto L_0x008c;
    L_0x0089:
        r2.close();
    L_0x008c:
        r13.b(r11);
        if (r1 == 0) goto L_0x0094;
    L_0x0091:
        r13.b(r12);
    L_0x0094:
        throw r0;
    L_0x0095:
        r0 = move-exception;
        r1 = r11;
        goto L_0x0087;
    L_0x0098:
        r0 = move-exception;
        r1 = r12;
        goto L_0x0087;
    L_0x009b:
        r0 = move-exception;
        r1 = r2;
        r2 = r10;
        goto L_0x0087;
    L_0x009f:
        r0 = move-exception;
        r1 = r0;
        r0 = r10;
        r10 = r2;
        r2 = r11;
        goto L_0x0073;
    L_0x00a5:
        r0 = move-exception;
        r1 = r0;
        r0 = r10;
        r10 = r2;
        r2 = r11;
        goto L_0x0073;
    L_0x00ab:
        r1 = move-exception;
        r10 = r2;
        r2 = r11;
        goto L_0x0073;
    L_0x00af:
        r1 = move-exception;
        r10 = r2;
        r2 = r12;
        goto L_0x0073;
    L_0x00b3:
        r1 = r11;
        goto L_0x0061;
    L_0x00b5:
        r0 = r10;
        goto L_0x004c;
    L_0x00b7:
        r0 = r10;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.d.a():int[]");
    }

    public final long b(long j, int i, int i2, int i3, String str, long j2, long j3) {
        long j4 = 0;
        if (!a(true)) {
            return j4;
        }
        try {
            String stringBuilder = new StringBuilder(z[3]).append(j).toString();
            ContentValues contentValues = new ContentValues();
            contentValues.put(z[15], Long.valueOf(j));
            contentValues.put(z[12], Integer.valueOf(i));
            contentValues.put(z[13], Integer.valueOf(i2));
            contentValues.put(z[11], Integer.valueOf(0));
            contentValues.put(z[10], str);
            contentValues.put(z[14], Long.valueOf(j2));
            contentValues.put(z[16], Long.valueOf(j3));
            j4 = (long) getWritableDatabase().update(z[4], contentValues, stringBuilder, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b(true);
        }
        return j4;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(z[2]);
        } catch (Exception e) {
            e.a(z[1], z[0]);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(z[22]);
        onCreate(sQLiteDatabase);
    }
}
