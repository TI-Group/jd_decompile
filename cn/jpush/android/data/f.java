package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;

/* compiled from: TbsSdkJava */
public abstract class f extends SQLiteOpenHelper {
    private static final String[] z;
    private volatile int a = 0;
    private volatile int b = 0;
    private volatile SQLiteDatabase c;
    private volatile SQLiteDatabase d;
    private final Object e = new Object();
    private final Object f = new Object();
    private final Context g;
    private final String h;
    private final int i;
    private final CursorFactory j;

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
        r2 = 1;
        r1 = 0;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "\u001d|";
        r0 = -1;
        r5 = r4;
        r6 = r4;
        r4 = r1;
    L_0x000b:
        r3 = r3.toCharArray();
        r7 = r3.length;
        if (r7 > r2) goto L_0x0061;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r3;
        r10 = r8;
        r13 = r7;
        r7 = r3;
        r3 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x0055;
            case 1: goto L_0x0058;
            case 2: goto L_0x005b;
            case 3: goto L_0x005e;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 50;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r3 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r3;
        goto L_0x0018;
    L_0x002d:
        r7 = r3;
        r3 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r3);
        r3 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x0050;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r4] = r3;
        r0 = "\u0007(v_";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r4] = r3;
        r3 = 2;
        r0 = "d=wXF\u0007)i\u0018@F8|_@B=}R]I0`_VF(x\u001dST99\u0019@H19\tWU/p\u0010\\\u0007";
        r4 = r3;
        r5 = r6;
        r3 = r0;
        r0 = r2;
        goto L_0x000b;
    L_0x0050:
        r5[r4] = r3;
        z = r6;
        return;
    L_0x0055:
        r11 = 39;
        goto L_0x0021;
    L_0x0058:
        r11 = 92;
        goto L_0x0021;
    L_0x005b:
        r11 = 25;
        goto L_0x0021;
    L_0x005e:
        r11 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0021;
    L_0x0061:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.f.<clinit>():void");
    }

    public f(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, null, 1);
        this.g = context;
        this.h = str;
        this.i = 1;
        this.j = null;
    }

    public final boolean a(boolean z) {
        if (z) {
            try {
                synchronized (this.e) {
                    getWritableDatabase();
                    this.b++;
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        synchronized (this.f) {
            getReadableDatabase();
            this.a++;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(boolean r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        if (r5 == 0) goto L_0x0032;
    L_0x0004:
        r2 = r4.e;
        monitor-enter(r2);
        r3 = r4.d;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x001b;
    L_0x000b:
        r3 = r4.d;	 Catch:{ all -> 0x002f }
        r3 = r3.isOpen();	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x001b;
    L_0x0013:
        r3 = r4.b;	 Catch:{ all -> 0x002f }
        r3 = r3 + -1;
        r4.b = r3;	 Catch:{ all -> 0x002f }
        if (r3 > 0) goto L_0x001c;
    L_0x001b:
        r0 = r1;
    L_0x001c:
        if (r0 == 0) goto L_0x002d;
    L_0x001e:
        r0 = 0;
        r4.b = r0;	 Catch:{ all -> 0x002f }
        r0 = r4.d;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x002a;
    L_0x0025:
        r0 = r4.d;	 Catch:{ all -> 0x002f }
        r0.close();	 Catch:{ all -> 0x002f }
    L_0x002a:
        r0 = 0;
        r4.d = r0;	 Catch:{ all -> 0x002f }
    L_0x002d:
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
    L_0x002e:
        return;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002f }
        throw r0;
    L_0x0032:
        r2 = r4.f;
        monitor-enter(r2);
        r3 = r4.c;	 Catch:{ all -> 0x005d }
        if (r3 == 0) goto L_0x0049;
    L_0x0039:
        r3 = r4.c;	 Catch:{ all -> 0x005d }
        r3 = r3.isOpen();	 Catch:{ all -> 0x005d }
        if (r3 == 0) goto L_0x0049;
    L_0x0041:
        r3 = r4.a;	 Catch:{ all -> 0x005d }
        r3 = r3 + -1;
        r4.a = r3;	 Catch:{ all -> 0x005d }
        if (r3 > 0) goto L_0x004a;
    L_0x0049:
        r0 = r1;
    L_0x004a:
        if (r0 == 0) goto L_0x005b;
    L_0x004c:
        r0 = 0;
        r4.a = r0;	 Catch:{ all -> 0x005d }
        r0 = r4.c;	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x0058;
    L_0x0053:
        r0 = r4.c;	 Catch:{ all -> 0x005d }
        r0.close();	 Catch:{ all -> 0x005d }
    L_0x0058:
        r0 = 0;
        r4.c = r0;	 Catch:{ all -> 0x005d }
    L_0x005b:
        monitor-exit(r2);	 Catch:{ all -> 0x005d }
        goto L_0x002e;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x005d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.f.b(boolean):void");
    }

    @Deprecated
    public void close() {
    }

    public SQLiteDatabase getReadableDatabase() {
        if (this.c == null || !this.c.isOpen()) {
            synchronized (this.f) {
                if (this.c == null || !this.c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException e) {
                    }
                    String path = this.g.getDatabasePath(this.h).getPath();
                    this.c = SQLiteDatabase.openDatabase(path, this.j, 1);
                    if (this.c.getVersion() != this.i) {
                        throw new SQLiteException(new StringBuilder(z[2]).append(this.c.getVersion()).append(z[1]).append(this.i).append(z[0]).append(path).toString());
                    }
                    this.a = 0;
                    onOpen(this.c);
                }
            }
        }
        return this.c;
    }

    public SQLiteDatabase getWritableDatabase() {
        if (this.d == null || !this.d.isOpen()) {
            synchronized (this.e) {
                if (this.d == null || !this.d.isOpen()) {
                    this.b = 0;
                    this.d = super.getWritableDatabase();
                    if (VERSION.SDK_INT >= 11) {
                        this.d.enableWriteAheadLogging();
                    }
                }
            }
        }
        return this.d;
    }
}
