package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class au {
    private static StatLogger h = l.b();
    private static Context i = null;
    private static au j = null;
    volatile int a = 0;
    a b = null;
    private bc c = null;
    private bc d = null;
    private e e = null;
    private String f = "";
    private String g = "";
    private int k = 0;
    private ConcurrentHashMap<com.tencent.wxop.stat.event.e, String> l = null;
    private boolean m = false;
    private HashMap<String, String> n = new HashMap();

    private au(Context context) {
        try {
            this.e = new e();
            i = context.getApplicationContext();
            this.l = new ConcurrentHashMap();
            this.f = l.p(context);
            this.g = "pri_" + l.p(context);
            this.c = new bc(i, this.f);
            this.d = new bc(i, this.g);
            a(true);
            a(false);
            f();
            b(i);
            d();
            j();
        } catch (Throwable th) {
            h.e(th);
        }
    }

    public static au a(Context context) {
        if (j == null) {
            synchronized (au.class) {
                if (j == null) {
                    j = new au(context);
                }
            }
        }
        return j;
    }

    private String a(List<bd> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (bd bdVar : list) {
            stringBuilder.append(bdVar.a);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private synchronized void a(int i, boolean z) {
        try {
            if (this.a > 0 && i > 0 && !StatServiceImpl.a()) {
                if (StatConfig.isDebugEnable()) {
                    h.i("Load " + this.a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (StatConfig.isDebugEnable()) {
                        h.i("Peek " + arrayList.size() + " unsent events.");
                    }
                    a(arrayList, 2, z);
                    i.b(i).b(arrayList, new ba(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            h.e(th);
        }
    }

    private void a(com.tencent.wxop.stat.event.e eVar, h hVar, boolean z) {
        long insert;
        long j;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c(z);
            sQLiteDatabase.beginTransaction();
            if (!z && this.a > StatConfig.getMaxStoreEventCount()) {
                h.warn("Too many events stored in db.");
                this.a -= this.c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String g = eVar.g();
            if (StatConfig.isDebugEnable()) {
                h.i("insert 1 event, content:" + g);
            }
            contentValues.put("content", r.b(g));
            contentValues.put("send_count", "0");
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(eVar.c()));
            insert = sQLiteDatabase.insert("events", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                    j = insert;
                } catch (Throwable th) {
                    h.e(th);
                    j = insert;
                }
                if (j <= 0) {
                    this.a++;
                    if (StatConfig.isDebugEnable()) {
                        h.d("directStoreEvent insert event to db, event:" + eVar.g());
                    }
                    if (hVar != null) {
                        hVar.a();
                    }
                }
                h.error("Failed to store event:" + eVar.g());
                return;
            }
        } catch (Throwable th2) {
            h.e(th2);
            j = -1;
        }
        j = insert;
        if (j <= 0) {
            h.error("Failed to store event:" + eVar.g());
            return;
        }
        this.a++;
        if (StatConfig.isDebugEnable()) {
            h.d("directStoreEvent insert event to db, event:" + eVar.g());
        }
        if (hVar != null) {
            hVar.a();
        }
    }

    private synchronized void a(List<bd> list, int i, boolean z) {
        SQLiteDatabase c;
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int b = b(z);
                try {
                    String str2;
                    c = c(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + a((List) list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                h.e(th);
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th3) {
                                        h.e(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th5) {
                                        h.e(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    str2 = "update events set status=" + i + " where " + a((List) list);
                    if (this.k % 3 == 0) {
                        str = "delete from events where send_count>" + b;
                    }
                    this.k++;
                    if (StatConfig.isDebugEnable()) {
                        h.i("update sql:" + str2);
                    }
                    c.beginTransaction();
                    c.execSQL(str2);
                    if (str != null) {
                        h.i("update for delete sql:" + str);
                        c.execSQL(str);
                        f();
                    }
                    c.setTransactionSuccessful();
                    if (c != null) {
                        try {
                            c.endTransaction();
                        } catch (Throwable th32) {
                            h.e(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    c = null;
                    if (c != null) {
                        c.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    private synchronized void a(java.util.List<com.tencent.wxop.stat.bd> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.au.a(java.util.List, boolean):void. bs: [B:26:0x00c1, B:49:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = h;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.i(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.tencent.wxop.stat.bd) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.a;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.c(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = h;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.i(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.a;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.a = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.f();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = h;	 Catch:{ all -> 0x00ce }
        r1.e(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = h;	 Catch:{ all -> 0x00e6 }
        r2.e(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = h;	 Catch:{ all -> 0x00ce }
        r1.e(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = h;	 Catch:{ all -> 0x00ce }
        r2.e(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.a(java.util.List, boolean):void");
    }

    private void a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (StatConfig.isDebugEnable()) {
                h.i("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    h.e(th);
                }
            }
        } catch (Throwable th2) {
            h.e(th2);
        }
    }

    private int b(boolean z) {
        return !z ? StatConfig.getMaxSendRetryCount() : StatConfig.getMaxImportantDataSendRetryCount();
    }

    public static au b() {
        return j;
    }

    private void b(int i, boolean z) {
        int g = i == -1 ? !z ? g() : h() : i;
        if (g > 0) {
            int sendPeriodMinutes = (StatConfig.getSendPeriodMinutes() * 60) * StatConfig.getNumEventsCommitPerSec();
            if (g > sendPeriodMinutes && sendPeriodMinutes > 0) {
                g = sendPeriodMinutes;
            }
            int a = StatConfig.a();
            int i2 = g / a;
            int i3 = g % a;
            if (StatConfig.isDebugEnable()) {
                h.i("sentStoreEventsByDb sendNumbers=" + g + ",important=" + z + ",maxSendNumPerFor1Period=" + sendPeriodMinutes + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (g = 0; g < i2; g++) {
                a(a, z);
            }
            if (i3 > 0) {
                a(i3, z);
            }
        }
    }

    private synchronized void b(com.tencent.wxop.stat.event.e eVar, h hVar, boolean z, boolean z2) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (StatConfig.m <= 0 || z || z2) {
                a(eVar, hVar, z);
            } else if (StatConfig.m > 0) {
                if (StatConfig.isDebugEnable()) {
                    h.i("cacheEventsInMemory.size():" + this.l.size() + ",numEventsCachedInMemory:" + StatConfig.m + ",numStoredEvents:" + this.a);
                    h.i("cache event:" + eVar.g());
                }
                this.l.put(eVar, "");
                if (this.l.size() >= StatConfig.m) {
                    i();
                }
                if (hVar != null) {
                    if (this.l.size() > 0) {
                        i();
                    }
                    hVar.a();
                }
            }
        }
    }

    private synchronized void b(f fVar) {
        Throwable th;
        Cursor query;
        try {
            Object obj;
            long update;
            String a = fVar.a();
            String a2 = l.a(a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", fVar.b.toString());
            contentValues.put("md5sum", a2);
            fVar.c = a2;
            contentValues.put("version", Integer.valueOf(fVar.d));
            query = this.c.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != fVar.a);
            obj = 1;
            this.c.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.c.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(fVar.a)});
            } else {
                contentValues.put(SocialConstants.PARAM_TYPE, Integer.valueOf(fVar.a));
                update = this.c.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                h.e("Failed to store cfg:" + a);
            } else {
                h.d("Sucessed to store cfg:" + a);
            }
            this.c.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.c.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.c.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    private void b(List<bd> list, int i, boolean z) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            query = d(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(0);
                    String string = query.getString(1);
                    if (!StatConfig.g) {
                        string = r.a(string);
                    }
                    int i2 = query.getInt(2);
                    int i3 = query.getInt(3);
                    bd bdVar = new bd(j, string, i2, i3);
                    if (StatConfig.isDebugEnable()) {
                        h.i("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + query.getLong(4));
                    }
                    list.add(bdVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private SQLiteDatabase c(boolean z) {
        return !z ? this.c.getWritableDatabase() : this.d.getWritableDatabase();
    }

    private SQLiteDatabase d(boolean z) {
        return !z ? this.c.getReadableDatabase() : this.d.getReadableDatabase();
    }

    private void f() {
        this.a = g() + h();
    }

    private int g() {
        return (int) DatabaseUtils.queryNumEntries(this.c.getReadableDatabase(), "events");
    }

    private int h() {
        return (int) DatabaseUtils.queryNumEntries(this.d.getReadableDatabase(), "events");
    }

    private void i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.au.i():void. bs: [B:42:0x011b, B:53:0x0133]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.l;
        monitor-enter(r2);
        r0 = r9.l;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = h;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.l;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.StatConfig.m;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.i(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.c;	 Catch:{ Throwable -> 0x00ca }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ca }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r9.l;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00ca }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00ca }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00ca }
        if (r0 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x00ca }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00ca }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00ca }
        r0 = (com.tencent.wxop.stat.event.e) r0;	 Catch:{ Throwable -> 0x00ca }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ca }
        r4.<init>();	 Catch:{ Throwable -> 0x00ca }
        r5 = r0.g();	 Catch:{ Throwable -> 0x00ca }
        r6 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00ca }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00ca }
    L_0x0085:
        r6 = h;	 Catch:{ Throwable -> 0x00ca }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ca }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00ca }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ca }
        r6.i(r7);	 Catch:{ Throwable -> 0x00ca }
    L_0x0099:
        r5 = com.tencent.wxop.stat.common.r.b(r5);	 Catch:{ Throwable -> 0x00ca }
        r6 = "content";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00ca }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00ca }
        r6 = "0";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "status";	 Catch:{ Throwable -> 0x00ca }
        r6 = 1;	 Catch:{ Throwable -> 0x00ca }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00ca }
        r6 = r0.c();	 Catch:{ Throwable -> 0x00ca }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00ca }
        r0 = "events";	 Catch:{ Throwable -> 0x00ca }
        r5 = 0;	 Catch:{ Throwable -> 0x00ca }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00ca }
        r3.remove();	 Catch:{ Throwable -> 0x00ca }
        goto L_0x0064;
    L_0x00ca:
        r0 = move-exception;
        r3 = h;	 Catch:{ all -> 0x0130 }
        r3.e(r0);	 Catch:{ all -> 0x0130 }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0129 }
        r9.f();	 Catch:{ Throwable -> 0x0129 }
    L_0x00d8:
        r0 = 0;
        r9.m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ all -> 0x0013 }
    L_0x00e1:
        r0 = h;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.l;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.StatConfig.m;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.i(r1);	 Catch:{ all -> 0x0013 }
    L_0x0113:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0116:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ca }
        if (r1 == 0) goto L_0x00d8;
    L_0x011b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0122 }
        r9.f();	 Catch:{ Throwable -> 0x0122 }
        goto L_0x00d8;
    L_0x0122:
        r0 = move-exception;
        r1 = h;	 Catch:{ all -> 0x0013 }
        r1.e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;	 Catch:{ all -> 0x0013 }
    L_0x0129:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = h;	 Catch:{ all -> 0x0013 }
        r1.e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;
    L_0x0130:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0139;
    L_0x0133:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013a }
        r9.f();	 Catch:{ Throwable -> 0x013a }
    L_0x0139:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013a:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = h;	 Catch:{ all -> 0x0013 }
        r3.e(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.i():void");
    }

    private void j() {
        Cursor query;
        Throwable th;
        try {
            query = this.c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.n.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public int a() {
        return this.a;
    }

    void a(int i) {
        this.e.a(new bb(this, i));
    }

    void a(com.tencent.wxop.stat.event.e eVar, h hVar, boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(new ay(this, eVar, hVar, z, z2));
        }
    }

    void a(f fVar) {
        if (fVar != null) {
            this.e.a(new az(this, fVar));
        }
    }

    void a(List<bd> list, int i, boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(new av(this, list, i, z, z2));
        }
    }

    void a(List<bd> list, boolean z, boolean z2) {
        if (this.e != null) {
            this.e.a(new aw(this, list, z, z2));
        }
    }

    public synchronized a b(Context context) {
        a aVar;
        Cursor query;
        Throwable th;
        Cursor cursor;
        if (this.b != null) {
            aVar = this.b;
        } else {
            try {
                this.c.getWritableDatabase().beginTransaction();
                if (StatConfig.isDebugEnable()) {
                    h.i("try to load user info from db.");
                }
                query = this.c.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String b;
                    if (query.moveToNext()) {
                        String a = r.a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || l.a(query.getLong(3) * 1000).equals(l.a(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(l.l(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            b = l.b(context);
                            obj = 1;
                            a = b;
                        } else {
                            b = split[0];
                            if (b == null || b.length() < 11) {
                                string = r.a(context);
                                if (string == null || string.length() <= 10) {
                                    string = b;
                                } else {
                                    obj = 1;
                                }
                                b = a;
                                a = string;
                            } else {
                                String str = b;
                                b = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = l.c(context);
                            if (string != null && string.length() > 0) {
                                b = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            b = a + "," + string;
                        }
                        this.b = new a(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", r.b(b));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", l.l(context));
                        contentValues.put(DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.c.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r10});
                        }
                        if (i3 != i) {
                            this.c.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = l.b(context);
                        b = l.c(context);
                        String str2 = (b == null || b.length() <= 0) ? string : string + "," + b;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String l = l.l(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", r.b(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", l);
                        contentValues2.put(DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis2));
                        this.c.getWritableDatabase().insert("user", null, contentValues2);
                        this.b = new a(string, b, 0);
                    }
                    this.c.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            h.e(th2);
                        }
                    }
                    this.c.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.c.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.c.getWritableDatabase().endTransaction();
                throw th2;
            }
            aVar = this.b;
        }
        return aVar;
    }

    void c() {
        if (StatConfig.isEnableStatService()) {
            try {
                this.e.a(new ax(this));
            } catch (Throwable th) {
                h.e(th);
            }
        }
    }

    void d() {
        Throwable th;
        Cursor query;
        try {
            query = this.c.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    f fVar = new f(i);
                    fVar.a = i;
                    fVar.b = new JSONObject(string);
                    fVar.c = string2;
                    fVar.d = i2;
                    StatConfig.a(i, fVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
