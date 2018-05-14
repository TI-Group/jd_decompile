package com.jingdong.crash.inner;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.jingdong.crash.a.b;
import java.lang.Thread.UncaughtExceptionHandler;

public class ag implements UncaughtExceptionHandler {
    private Context a;
    private b b;
    private UncaughtExceptionHandler c;
    private UncaughtExceptionHandler d;

    public ag(Context context) {
        this.a = context;
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            String name = getClass().getName();
            String name2 = defaultUncaughtExceptionHandler.getClass().getName();
            if (!name.equals(name2)) {
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(name2)) {
                    this.c = defaultUncaughtExceptionHandler;
                } else {
                    this.d = defaultUncaughtExceptionHandler;
                }
            }
        }
        if (d.b(context)) {
            JdLocalCrashReceiver.a().a("android.net.conn.CONNECTIVITY_CHANGE");
            JdLocalCrashReceiver.a().a(this.a);
        }
    }

    private void a() {
        try {
            ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
            String a = d.a(Process.myPid());
            for (RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)) {
                if (runningServiceInfo.process != null && runningServiceInfo.process.equals(a)) {
                    Intent intent = new Intent();
                    intent.setComponent(runningServiceInfo.service);
                    this.a.stopService(intent);
                }
            }
        } catch (Exception e) {
        }
    }

    private boolean a(Thread thread, Throwable th) {
        try {
            if (this.b == null) {
                this.b = new ac();
            }
            f a = e.a(th);
            String stringBuffer = a.a.toString();
            String str = a.b;
            if (ah.b) {
                ah.a("CaughtHandler", "crashStack : " + stringBuffer);
            }
            boolean a2 = (b.b == null || b.b.length <= 0) ? true : e.a(stringBuffer);
            if (ah.b) {
                ah.b("CaughtHandler", "shouldReportFlag : " + a2);
            }
            if (!a2) {
                return false;
            }
            q.a(this.a);
            v vVar = new v();
            if (d.a(this.a)) {
                vVar.d.put("submit", String.valueOf(0));
            } else {
                vVar.d.put("submit", String.valueOf(1));
            }
            vVar.a = stringBuffer;
            vVar.b = str;
            this.b.a(this.a, vVar);
            a();
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uncaughtException(java.lang.Thread r5, java.lang.Throwable r6) {
        /*
        r4 = this;
        r3 = 0;
        r0 = com.jingdong.crash.inner.ah.b;
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = "CaughtHandler";
        r1 = "uncaughtException..........";
        com.jingdong.crash.inner.ah.a(r0, r1);
    L_0x000c:
        if (r6 == 0) goto L_0x0061;
    L_0x000e:
        r6.printStackTrace();	 Catch:{ Throwable -> 0x009d }
        r0 = r6.toString();	 Catch:{ Throwable -> 0x009d }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x009d }
        if (r1 != 0) goto L_0x0061;
    L_0x001b:
        r0 = r0.getBytes();	 Catch:{ Throwable -> 0x009d }
        r0 = r0.length;	 Catch:{ Throwable -> 0x009d }
        r1 = com.jingdong.crash.inner.g.b();	 Catch:{ Throwable -> 0x009d }
        if (r0 <= r1) goto L_0x0061;
    L_0x0026:
        r0 = "CaughtHandler";
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d }
        r1.<init>();	 Catch:{ Throwable -> 0x009d }
        r2 = "Exception is too large, max is ";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x009d }
        r2 = com.jingdong.crash.inner.g.b();	 Catch:{ Throwable -> 0x009d }
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x009d }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x009d }
        com.jingdong.crash.inner.ah.a(r0, r1);	 Catch:{ Throwable -> 0x009d }
        r0 = r4.c;
        if (r0 == 0) goto L_0x004c;
    L_0x0046:
        r0 = r4.c;
        r0.uncaughtException(r5, r6);
    L_0x004b:
        return;
    L_0x004c:
        r0 = r4.d;
        if (r0 == 0) goto L_0x0056;
    L_0x0050:
        r0 = r4.d;
        r0.uncaughtException(r5, r6);
        goto L_0x004b;
    L_0x0056:
        r0 = android.os.Process.myTid();
        android.os.Process.killProcess(r0);
        java.lang.System.exit(r3);
        goto L_0x004b;
    L_0x0061:
        r0 = r4.a;	 Catch:{ Throwable -> 0x009d }
        com.jingdong.crash.inner.ab.a(r0);	 Catch:{ Throwable -> 0x009d }
        r0 = com.jingdong.crash.inner.q.b;	 Catch:{ Throwable -> 0x009d }
        if (r0 == 0) goto L_0x007b;
    L_0x006a:
        r1 = com.jingdong.crash.inner.ah.b;	 Catch:{ Throwable -> 0x009d }
        if (r1 == 0) goto L_0x0075;
    L_0x006e:
        r1 = "CaughtHandler";
        r2 = "myActivity!= null 将其finish掉了";
        com.jingdong.crash.inner.ah.a(r1, r2);	 Catch:{ Throwable -> 0x009d }
    L_0x0075:
        r0.finish();	 Catch:{ Throwable -> 0x009d }
        r0 = 0;
        com.jingdong.crash.inner.q.b = r0;	 Catch:{ Throwable -> 0x009d }
    L_0x007b:
        r4.a(r5, r6);	 Catch:{ Throwable -> 0x009d }
        r0 = r4.c;
        if (r0 == 0) goto L_0x0088;
    L_0x0082:
        r0 = r4.c;
        r0.uncaughtException(r5, r6);
        goto L_0x004b;
    L_0x0088:
        r0 = r4.d;
        if (r0 == 0) goto L_0x0092;
    L_0x008c:
        r0 = r4.d;
        r0.uncaughtException(r5, r6);
        goto L_0x004b;
    L_0x0092:
        r0 = android.os.Process.myTid();
        android.os.Process.killProcess(r0);
        java.lang.System.exit(r3);
        goto L_0x004b;
    L_0x009d:
        r0 = move-exception;
        r1 = com.jingdong.crash.inner.ah.b;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x00a5;
    L_0x00a2:
        r0.printStackTrace();	 Catch:{ all -> 0x00c4 }
    L_0x00a5:
        r0 = r4.c;
        if (r0 == 0) goto L_0x00af;
    L_0x00a9:
        r0 = r4.c;
        r0.uncaughtException(r5, r6);
        goto L_0x004b;
    L_0x00af:
        r0 = r4.d;
        if (r0 == 0) goto L_0x00b9;
    L_0x00b3:
        r0 = r4.d;
        r0.uncaughtException(r5, r6);
        goto L_0x004b;
    L_0x00b9:
        r0 = android.os.Process.myTid();
        android.os.Process.killProcess(r0);
        java.lang.System.exit(r3);
        goto L_0x004b;
    L_0x00c4:
        r0 = move-exception;
        r1 = r4.c;
        if (r1 == 0) goto L_0x00cf;
    L_0x00c9:
        r1 = r4.c;
        r1.uncaughtException(r5, r6);
    L_0x00ce:
        throw r0;
    L_0x00cf:
        r1 = r4.d;
        if (r1 == 0) goto L_0x00d9;
    L_0x00d3:
        r1 = r4.d;
        r1.uncaughtException(r5, r6);
        goto L_0x00ce;
    L_0x00d9:
        r1 = android.os.Process.myTid();
        android.os.Process.killProcess(r1);
        java.lang.System.exit(r3);
        goto L_0x00ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jingdong.crash.inner.ag.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
