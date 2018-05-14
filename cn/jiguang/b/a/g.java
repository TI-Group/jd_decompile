package cn.jiguang.b.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jiguang.c.d;

public final class g extends e {
    private static final String[] a;
    private static volatile g b;
    private static final Object c = new Object();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 28;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "`R\u000e`\u0019gG=";
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
            case 0: goto L_0x0165;
            case 1: goto L_0x0169;
            case 2: goto L_0x016d;
            case 3: goto L_0x0171;
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
            case 27: goto L_0x0175;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "yV$g\u001eLU%u\u0002zU%}\u0015`";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "`R\u000er\u0017zJ4p";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "`R\u000ez\u0013g";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "`R\u000eg\u0019aR\u000e\u0013j";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "`R\u000ew\u0019fH%KG#";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "`R\u000ew\u0019fH%KEL\u0017a";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "`R\u000eg\u0019fT2q";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "`R\u000ew\u0019fH%KG";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "`R\u000ew\u0019fH%KGL\u0015";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "`R\u000ew\u0019}H\u000e}\u0006";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "`R\u000ex\u0019pG=K\u0012}U";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "@R0`\u001f`R8w\u0005Wd";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "gG3x\u00133L!a\u0005{y\"`\u0017gO\"`\u001fpUq}\u00053G=f\u0013rB(";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "Pt\u0014U\"V\u0006\u0005U4_cq~\u0006fU9K\u0005gG%}\u0005gO2gV;y8pVZh\u0005Q1VtqD$Zk\u0010F/3m\u0014MVRs\u0005[?]e\u0003Q;Vh\u00054Z`R\u000eg\u0019aR\u000e\u0013j\u0006%q\u000eg\u0006?{\u00023H$x\u001a?U%K\u0018vRq`\u0013kRqz\u0019g\u0006?a\u001a\n\"`)pI?z)zVq`\u0013kRqz\u0019g\u0006?a\u001a\n\"`)I2u\u001aLB?gVgC)`Z`R\u000eg\u0019fT2qVzH%q\u0011vTqz\u0019g\u0006?a\u001a\n\"`)uG8x\u0013w\u00068z\u0002vA4fV}I%4\u0018fJ=8\u0005gy%{\u0002rJq}\u0018gC6q\u00043H>`V}S=xZ`R\u000ew\u0019fH%KG3O?`\u0013tC#8\u0005gy2{\u0003}R\u000e%) \u00068z\u0002vA4fZ`R\u000ew\u0019fH%KEL\u0017a4\u001f}R4s\u0013a\n\"`)pI$z\u0002L\u0017a4\u001f}R4s\u0013a\u000fj";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "yV$g\u001eLU%u\u0002zU%}\u0015`\b5v";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "Wt\u001eDVGg\u0013X33o\u001743Ko\u0002@%3L!a\u0005{y\"`\u0017gO\"`\u001fpU";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "`R\u000eg\u0019aR\u000e\u0013j\u001bv";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "wG%u\u0014rU44\u0019cC?4\u0010rO=q\u0012";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "`C=q\u0015g\u0006{4\u0010aI<4\u001ccS\"|)`R0`\u001f`R8w\u00053Q9q\u0004v\u0006\"`)gI%u\u001a3\u0018q$VrH54\u0005gy7u\u001fC54K3\u0016q4\u0019aB4fVq_qg\u0002LR>`\u0017\u00065q\u0005p\u0006=}\u001bzRq'";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "tC%G\u0003pE4q\u0012GI!'2rR04\u0013kE4d\u0002zI?.";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "`C=q\u0015g\u0006{4\u0010aI<4\u001ccS\"|)`R0`\u001f`R8w\u00053Q9q\u0004v\u0006\"`)uG8x\u0013w\u0006o4F3\u0006>f\u0012vTqv\u000f3U%K\u0010rO=q\u00123B4g\u00153J8y\u001fg\u0006b";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "tC%R\u0017zJ4p\"|VbP\u0017gGqq\u000epC!`\u001f|Hk";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "`C=q\u0015g\u0006\u0002A;;";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "tC%W\u0019fH%@\u0019gG=[\u0004UG8x\u0013w\u00064l\u0015vV%}\u0019}\u001c";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = ":\u00067f\u0019~\u0006;d\u0003`N\u000eg\u0002rR8g\u0002zE\"";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "tC%G\u0002rR8g\u0002zE\"P\u0017gGqq\u000epC!`\u001f|Hk";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "pS#g\u0019a\u00068gV}S=x";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        z = r4;
        r0 = 12;
        r3 = new java.lang.String[r0];
        r0 = 0;
        r1 = z;
        r2 = 4;
        r1 = r1[r2];
        r3[r0] = r1;
        r2 = 1;
        r1 = "LO5";
        r0 = 27;
        r4 = r3;
        goto L_0x0009;
    L_0x0165:
        r9 = 19;
        goto L_0x0020;
    L_0x0169:
        r9 = 38;
        goto L_0x0020;
    L_0x016d:
        r9 = 81;
        goto L_0x0020;
    L_0x0171:
        r9 = 20;
        goto L_0x0020;
    L_0x0175:
        r3[r2] = r1;
        r0 = 2;
        r1 = z;
        r2 = 3;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 3;
        r1 = z;
        r2 = 10;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 4;
        r1 = z;
        r2 = 11;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 5;
        r1 = z;
        r2 = 7;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 6;
        r1 = z;
        r2 = 2;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 7;
        r1 = z;
        r2 = 0;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 8;
        r1 = z;
        r2 = 8;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 9;
        r1 = z;
        r2 = 9;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 10;
        r1 = z;
        r2 = 6;
        r1 = r1[r2];
        r4[r0] = r1;
        r0 = 11;
        r1 = z;
        r2 = 5;
        r1 = r1[r2];
        r4[r0] = r1;
        a = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.a.g.<clinit>():void");
    }

    private g(Context context) {
        super(context, z[15], null, 1);
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new g(context);
                }
            }
        }
        return b;
    }

    public static h a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            d.c(z[12], z[27]);
            return null;
        }
        try {
            h hVar = new h();
            hVar.a(cursor.getString(1));
            hVar.b(cursor.getString(2));
            hVar.c(cursor.getString(3));
            hVar.d(cursor.getString(4));
            hVar.e(cursor.getString(5));
            hVar.a(cursor.getInt(6));
            hVar.b(cursor.getInt(7));
            hVar.c(cursor.getInt(8));
            hVar.d(cursor.getInt(9));
            hVar.e(cursor.getInt(10));
            hVar.f(cursor.getInt(11));
            d.e(z[12], hVar.toString());
            return hVar;
        } catch (Exception e) {
            e.printStackTrace();
            d.i(z[12], new StringBuilder(z[26]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final long a(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5, int i6) {
        long j = 0;
        if (a(true)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(z[4], str);
            contentValues.put(z[3], str2);
            contentValues.put(z[10], str3);
            contentValues.put(z[11], str4);
            contentValues.put(z[7], str5);
            contentValues.put(z[2], Integer.valueOf(i));
            contentValues.put(z[0], Integer.valueOf(1));
            contentValues.put(z[8], Integer.valueOf(i3));
            contentValues.put(z[9], Integer.valueOf(i4));
            contentValues.put(z[6], Integer.valueOf(i5));
            contentValues.put(z[5], Integer.valueOf(0));
            try {
                j = getWritableDatabase().insert(z[1], null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                b(true);
            }
        }
        return j;
    }

    public final Cursor a() {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(z[21], null);
            if (rawQuery == null) {
                return rawQuery;
            }
            rawQuery.moveToFirst();
            return rawQuery;
        } catch (Exception e) {
            d.g(z[12], new StringBuilder(z[22]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final h a(String str) {
        Cursor query;
        Throwable th;
        if (a(false)) {
            try {
                query = getReadableDatabase().query(true, z[1], a, new StringBuilder(z[17]).append(str).append("'").toString(), null, null, null, null, null);
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
                h a = a(query);
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
        throw new Exception(z[18]);
    }

    public final long b(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5, int i6) {
        long j = 0;
        if (!a(true)) {
            return j;
        }
        String stringBuilder = new StringBuilder(z[17]).append(str).append("'").toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put(z[4], str);
        contentValues.put(z[3], str2);
        contentValues.put(z[10], str3);
        contentValues.put(z[11], str4);
        contentValues.put(z[7], str5);
        contentValues.put(z[2], Integer.valueOf(i));
        contentValues.put(z[0], Integer.valueOf(i2));
        contentValues.put(z[8], Integer.valueOf(i3));
        contentValues.put(z[9], Integer.valueOf(i4));
        contentValues.put(z[6], Integer.valueOf(i5));
        contentValues.put(z[5], Integer.valueOf(i6));
        try {
            j = (long) getWritableDatabase().update(z[1], contentValues, stringBuilder, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b(true);
        }
        return j;
    }

    public final Cursor b() {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery(z[19], null);
            if (rawQuery == null) {
                return rawQuery;
            }
            rawQuery.moveToFirst();
            return rawQuery;
        } catch (Exception e) {
            d.g(z[12], new StringBuilder(z[20]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final int c(boolean z) {
        Cursor cursor = null;
        try {
            cursor = getReadableDatabase().rawQuery(new StringBuilder(z[23]).append(z ? z[0] : z[2]).append(z[25]).toString(), null);
            if (cursor != null) {
                cursor.moveToFirst();
                int i = cursor.getInt(0);
                if (cursor == null) {
                    return i;
                }
                cursor.close();
                return i;
            }
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Exception e) {
            d.g(z[12], new StringBuilder(z[24]).append(e.getMessage()).toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(z[14]);
        } catch (Exception e) {
            d.a(z[12], z[13]);
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(z[16]);
        onCreate(sQLiteDatabase);
    }
}
