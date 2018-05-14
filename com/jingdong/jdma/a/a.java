package com.jingdong.jdma.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.d.e;
import java.util.ArrayList;

/* compiled from: TbsSdkJava */
public class a extends SQLiteOpenHelper {
    private static a d;
    private int a = 0;
    private boolean b = false;
    private boolean c = false;

    protected a(Context context) {
        super(context, "jd_reportStatExp.db", null, 1);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a(context);
            }
            aVar = d;
        }
        return aVar;
    }

    public static synchronized void a() {
        synchronized (a.class) {
            if (d != null) {
                d.close();
            }
        }
    }

    public synchronized void a(String str, e eVar, long j) {
        try {
            if (!a(str, j)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("data", eVar.a());
                contentValues.put("reserve", "");
                getWritableDatabase().insert(str, null, contentValues);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized long a(String str) {
        long j;
        Exception e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                Cursor query = getReadableDatabase().query(str, new String[]{"count(*)"}, null, null, null, null, null);
                if (query != null) {
                    try {
                        query.moveToFirst();
                        j = (long) query.getInt(0);
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                        try {
                            e.printStackTrace();
                            if (cursor != null) {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                    j = 0;
                                    return j;
                                }
                            }
                            j = 0;
                            return j;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (!(cursor2 == null || cursor2.isClosed())) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = query;
                        cursor2.close();
                        throw th;
                    }
                }
                j = 0;
                if (query != null) {
                    if (!query.isClosed()) {
                        query.close();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                e.printStackTrace();
                if (cursor != null) {
                    if (cursor.isClosed()) {
                        cursor.close();
                        j = 0;
                        return j;
                    }
                }
                j = 0;
                return j;
            } catch (Throwable th4) {
                th = th4;
                cursor2.close();
                throw th;
            }
        }
        return j;
    }

    private boolean a(String str, long j) {
        if (!CommonUtil.STATISTIC_TABLE_NAME.equals(str) || 10000 <= j) {
            return true;
        }
        return false;
    }

    public synchronized int a(String str, ArrayList<e> arrayList, long j, long j2) {
        int delete;
        String string;
        Exception e;
        int delete2;
        Throwable th;
        if (arrayList != null) {
            if (arrayList.size() != 0) {
                try {
                    String str2 = "id>=? and id<=?";
                    String[] strArr = new String[2];
                    if (j <= j2) {
                        strArr[0] = "" + j;
                        strArr[1] = "" + j2;
                        delete = getWritableDatabase().delete(str, str2, strArr) + 0;
                    } else {
                        Cursor cursor = null;
                        Cursor query;
                        try {
                            query = getReadableDatabase().query(str, new String[]{"max(id)"}, null, null, null, null, null);
                            if (query != null) {
                                try {
                                    query.moveToFirst();
                                    string = query.getString(0);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        e.printStackTrace();
                                        if (query != null) {
                                            if (!query.isClosed()) {
                                                query.close();
                                                string = null;
                                                strArr[0] = "" + j;
                                                strArr[1] = string;
                                                delete2 = 0 + getWritableDatabase().delete(str, str2, strArr);
                                                strArr[0] = "0";
                                                strArr[1] = "" + j2;
                                                delete = getWritableDatabase().delete(str, str2, strArr) + delete2;
                                                return delete;
                                            }
                                        }
                                        string = null;
                                        strArr[0] = "" + j;
                                        strArr[1] = string;
                                        delete2 = 0 + getWritableDatabase().delete(str, str2, strArr);
                                        strArr[0] = "0";
                                        strArr[1] = "" + j2;
                                        delete = getWritableDatabase().delete(str, str2, strArr) + delete2;
                                        return delete;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = query;
                                        if (!(cursor == null || cursor.isClosed())) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            string = null;
                            if (query != null) {
                                if (!query.isClosed()) {
                                    query.close();
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            query = null;
                            e.printStackTrace();
                            if (query != null) {
                                if (query.isClosed()) {
                                    query.close();
                                    string = null;
                                    strArr[0] = "" + j;
                                    strArr[1] = string;
                                    delete2 = 0 + getWritableDatabase().delete(str, str2, strArr);
                                    strArr[0] = "0";
                                    strArr[1] = "" + j2;
                                    delete = getWritableDatabase().delete(str, str2, strArr) + delete2;
                                    return delete;
                                }
                            }
                            string = null;
                            strArr[0] = "" + j;
                            strArr[1] = string;
                            delete2 = 0 + getWritableDatabase().delete(str, str2, strArr);
                            strArr[0] = "0";
                            strArr[1] = "" + j2;
                            delete = getWritableDatabase().delete(str, str2, strArr) + delete2;
                            return delete;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor.close();
                            throw th;
                        }
                        strArr[0] = "" + j;
                        strArr[1] = string;
                        delete2 = 0 + getWritableDatabase().delete(str, str2, strArr);
                        strArr[0] = "0";
                        strArr[1] = "" + j2;
                        delete = getWritableDatabase().delete(str, str2, strArr) + delete2;
                    }
                } catch (Exception e4) {
                    Exception exception = e4;
                    delete = 0;
                    exception.printStackTrace();
                }
            }
        }
        delete = 0;
        return delete;
    }

    public synchronized ArrayList<e> a(String str, Long l) {
        ArrayList<e> arrayList;
        StackOverflowError e;
        Throwable th;
        Exception e2;
        Cursor cursor = null;
        synchronized (this) {
            ArrayList<e> arrayList2 = new ArrayList();
            if (l.longValue() == 0) {
                arrayList = arrayList2;
            } else {
                Cursor query;
                try {
                    String[] strArr = new String[]{"id", "time", "data", "reserve"};
                    if (l.longValue() > 0) {
                        String str2 = "" + l;
                        query = getReadableDatabase().query(str, strArr, null, null, null, null, "time asc", str2);
                    } else {
                        query = getReadableDatabase().query(str, strArr, null, null, null, null, "time asc");
                    }
                    if (query != null) {
                        try {
                            query.moveToFirst();
                            while (!query.isAfterLast()) {
                                e eVar = new e();
                                eVar.b(query.getString(0));
                                eVar.a(query.getString(2));
                                arrayList2.add(eVar);
                                query.moveToNext();
                            }
                        } catch (StackOverflowError e3) {
                            e = e3;
                            try {
                                e.printStackTrace();
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                arrayList = arrayList2;
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = query;
                                if (!(cursor == null || cursor.isClosed())) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            cursor = query;
                            try {
                                e2.printStackTrace();
                                if (cursor != null) {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                                arrayList = arrayList2;
                                return arrayList;
                            } catch (Throwable th3) {
                                th = th3;
                                cursor.close();
                                throw th;
                            }
                        }
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                } catch (StackOverflowError e5) {
                    e = e5;
                    query = null;
                    e.printStackTrace();
                    if (query != null) {
                        if (query.isClosed()) {
                            query.close();
                        }
                    }
                    arrayList = arrayList2;
                    return arrayList;
                } catch (Exception e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    if (cursor != null) {
                        if (cursor.isClosed()) {
                            cursor.close();
                        }
                    }
                    arrayList = arrayList2;
                    return arrayList;
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS statistic (id INTEGER PRIMARY KEY, time TEXT, data TEXT, reserve TEXT);");
        sQLiteDatabase.execSQL("create index if not exists timeindex on statistic(time)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS statistic");
        onCreate(sQLiteDatabase);
    }
}
