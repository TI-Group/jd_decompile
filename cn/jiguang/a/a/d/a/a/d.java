package cn.jiguang.a.a.d.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.app.Instrumentation.ActivityResult;
import android.app.UiAutomation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import cn.jiguang.a.a;
import cn.jiguang.a.a.d.b;

public class d extends Instrumentation {
    private static final String[] z;
    protected Instrumentation a;
    private boolean b = true;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "\u0005Df$g\u001eKF5";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000b:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x0057;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r2;
        r10 = r8;
        r13 = r7;
        r7 = r2;
        r2 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x004b;
            case 1: goto L_0x004e;
            case 2: goto L_0x0051;
            case 3: goto L_0x0054;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 20;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x0018;
    L_0x002d:
        r7 = r2;
        r2 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r3] = r2;
        r0 = "\u0005Dw3q\u000b^Q";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r3] = r2;
        z = r6;
        return;
    L_0x004b:
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        goto L_0x0021;
    L_0x004e:
        r11 = 42;
        goto L_0x0021;
    L_0x0051:
        r11 = 52;
        goto L_0x0021;
    L_0x0054:
        r11 = 65;
        goto L_0x0021;
    L_0x0057:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.a.a.d.<clinit>():void");
    }

    public d(Instrumentation instrumentation) {
        this.a = instrumentation;
    }

    public final void a(boolean z) {
        this.b = true;
    }

    public ActivityMonitor addMonitor(IntentFilter intentFilter, ActivityResult activityResult, boolean z) {
        return this.a != null ? this.a.addMonitor(intentFilter, activityResult, z) : super.addMonitor(intentFilter, activityResult, z);
    }

    public ActivityMonitor addMonitor(String str, ActivityResult activityResult, boolean z) {
        return this.a != null ? this.a.addMonitor(str, activityResult, z) : super.addMonitor(str, activityResult, z);
    }

    public void addMonitor(ActivityMonitor activityMonitor) {
        if (this.a != null) {
            this.a.addMonitor(activityMonitor);
        } else {
            super.addMonitor(activityMonitor);
        }
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        if (this.b && a.a != null) {
            a.a.dispatchStatus(activity, z[1]);
        }
        if (this.a != null) {
            this.a.callActivityOnCreate(activity, bundle);
        } else {
            super.callActivityOnCreate(activity, bundle);
        }
    }

    @TargetApi(21)
    public void callActivityOnCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        if (this.a != null) {
            this.a.callActivityOnCreate(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnCreate(activity, bundle, persistableBundle);
        }
    }

    public void callActivityOnDestroy(Activity activity) {
        if (this.a != null) {
            this.a.callActivityOnDestroy(activity);
        } else {
            super.callActivityOnDestroy(activity);
        }
    }

    public void callActivityOnNewIntent(Activity activity, Intent intent) {
        if (this.a != null) {
            this.a.callActivityOnNewIntent(activity, intent);
        } else {
            super.callActivityOnNewIntent(activity, intent);
        }
    }

    public void callActivityOnPause(Activity activity) {
        if (this.b) {
            if (a.a != null) {
                a.a.dispatchPause(activity);
            }
            if (!c.a) {
                b.a().b(activity);
            }
        }
        if (this.a != null) {
            this.a.callActivityOnPause(activity);
        } else {
            super.callActivityOnPause(activity);
        }
    }

    public void callActivityOnPostCreate(Activity activity, Bundle bundle) {
        if (this.a != null) {
            this.a.callActivityOnPostCreate(activity, bundle);
        } else {
            super.callActivityOnPostCreate(activity, bundle);
        }
    }

    @TargetApi(21)
    public void callActivityOnPostCreate(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        if (this.a != null) {
            this.a.callActivityOnPostCreate(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnPostCreate(activity, bundle, persistableBundle);
        }
    }

    public void callActivityOnRestart(Activity activity) {
        if (this.b && a.a != null) {
            a.a.dispatchStatus(activity, z[0]);
        }
        if (this.a != null) {
            this.a.callActivityOnRestart(activity);
        } else {
            super.callActivityOnRestart(activity);
        }
    }

    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle) {
        if (this.a != null) {
            this.a.callActivityOnRestoreInstanceState(activity, bundle);
        } else {
            super.callActivityOnRestoreInstanceState(activity, bundle);
        }
    }

    @TargetApi(21)
    public void callActivityOnRestoreInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        if (this.a != null) {
            this.a.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnRestoreInstanceState(activity, bundle, persistableBundle);
        }
    }

    public void callActivityOnResume(Activity activity) {
        if (this.b) {
            if (a.a != null) {
                a.a.dispatchResume(activity);
            }
            if (!c.a) {
                b.a().a((Context) activity);
            }
        }
        if (this.a != null) {
            this.a.callActivityOnResume(activity);
        } else {
            super.callActivityOnResume(activity);
        }
    }

    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle) {
        if (this.a != null) {
            this.a.callActivityOnSaveInstanceState(activity, bundle);
        } else {
            super.callActivityOnSaveInstanceState(activity, bundle);
        }
    }

    @TargetApi(21)
    public void callActivityOnSaveInstanceState(Activity activity, Bundle bundle, PersistableBundle persistableBundle) {
        if (this.a != null) {
            this.a.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
        } else {
            super.callActivityOnSaveInstanceState(activity, bundle, persistableBundle);
        }
    }

    public void callActivityOnStart(Activity activity) {
        if (this.a != null) {
            this.a.callActivityOnStart(activity);
        } else {
            super.callActivityOnStart(activity);
        }
    }

    public void callActivityOnStop(Activity activity) {
        if (this.a != null) {
            this.a.callActivityOnStop(activity);
        } else {
            super.callActivityOnStop(activity);
        }
    }

    public void callActivityOnUserLeaving(Activity activity) {
        if (this.a != null) {
            this.a.callActivityOnUserLeaving(activity);
        } else {
            super.callActivityOnUserLeaving(activity);
        }
    }

    public void callApplicationOnCreate(Application application) {
        if (this.a != null) {
            this.a.callApplicationOnCreate(application);
        } else {
            super.callApplicationOnCreate(application);
        }
    }

    public boolean checkMonitorHit(ActivityMonitor activityMonitor, int i) {
        return this.a != null ? this.a.checkMonitorHit(activityMonitor, i) : super.checkMonitorHit(activityMonitor, i);
    }

    public void endPerformanceSnapshot() {
        if (this.a != null) {
            this.a.endPerformanceSnapshot();
        } else {
            super.endPerformanceSnapshot();
        }
    }

    public void finish(int i, Bundle bundle) {
        if (this.a != null) {
            this.a.finish(i, bundle);
        } else {
            super.finish(i, bundle);
        }
    }

    public Bundle getAllocCounts() {
        return this.a != null ? this.a.getAllocCounts() : super.getAllocCounts();
    }

    public Bundle getBinderCounts() {
        return this.a != null ? this.a.getBinderCounts() : super.getBinderCounts();
    }

    public ComponentName getComponentName() {
        return this.a != null ? this.a.getComponentName() : super.getComponentName();
    }

    public Context getContext() {
        return this.a != null ? this.a.getContext() : super.getContext();
    }

    public Context getTargetContext() {
        return this.a != null ? this.a.getTargetContext() : super.getTargetContext();
    }

    @TargetApi(18)
    public UiAutomation getUiAutomation() {
        return this.a != null ? this.a.getUiAutomation() : super.getUiAutomation();
    }

    public boolean invokeContextMenuAction(Activity activity, int i, int i2) {
        return this.a != null ? this.a.invokeContextMenuAction(activity, i, i2) : super.invokeContextMenuAction(activity, i, i2);
    }

    public boolean invokeMenuActionSync(Activity activity, int i, int i2) {
        return this.a != null ? this.a.invokeMenuActionSync(activity, i, i2) : super.invokeMenuActionSync(activity, i, i2);
    }

    public boolean isProfiling() {
        return this.a != null ? this.a.isProfiling() : super.isProfiling();
    }

    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) {
        return this.a != null ? this.a.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj) : super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) {
        return this.a != null ? this.a.newActivity(classLoader, str, intent) : super.newActivity(classLoader, str, intent);
    }

    public Application newApplication(ClassLoader classLoader, String str, Context context) {
        return this.a != null ? this.a.newApplication(classLoader, str, context) : super.newApplication(classLoader, str, context);
    }

    public void onCreate(Bundle bundle) {
        if (this.a != null) {
            this.a.onCreate(bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    public void onDestroy() {
        if (this.a != null) {
            this.a.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    public boolean onException(Object obj, Throwable th) {
        return this.a != null ? this.a.onException(obj, th) : super.onException(obj, th);
    }

    public void onStart() {
        if (this.a != null) {
            this.a.onStart();
        } else {
            super.onStart();
        }
    }

    public void removeMonitor(ActivityMonitor activityMonitor) {
        if (this.a != null) {
            this.a.removeMonitor(activityMonitor);
        } else {
            super.removeMonitor(activityMonitor);
        }
    }

    public void runOnMainSync(Runnable runnable) {
        if (this.a != null) {
            this.a.runOnMainSync(runnable);
        } else {
            super.runOnMainSync(runnable);
        }
    }

    public void sendCharacterSync(int i) {
        if (this.a != null) {
            this.a.sendCharacterSync(i);
        } else {
            super.sendCharacterSync(i);
        }
    }

    public void sendKeyDownUpSync(int i) {
        if (this.a != null) {
            this.a.sendKeyDownUpSync(i);
        } else {
            super.sendKeyDownUpSync(i);
        }
    }

    public void sendKeySync(KeyEvent keyEvent) {
        if (this.a != null) {
            this.a.sendKeySync(keyEvent);
        } else {
            super.sendKeySync(keyEvent);
        }
    }

    public void sendPointerSync(MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.sendPointerSync(motionEvent);
        } else {
            super.sendPointerSync(motionEvent);
        }
    }

    public void sendStatus(int i, Bundle bundle) {
        if (this.a != null) {
            this.a.sendStatus(i, bundle);
        } else {
            super.sendStatus(i, bundle);
        }
    }

    public void sendStringSync(String str) {
        if (this.a != null) {
            this.a.sendStringSync(str);
        } else {
            super.sendStringSync(str);
        }
    }

    public void sendTrackballEventSync(MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.sendTrackballEventSync(motionEvent);
        } else {
            super.sendTrackballEventSync(motionEvent);
        }
    }

    public void setAutomaticPerformanceSnapshots() {
        if (this.a != null) {
            this.a.setAutomaticPerformanceSnapshots();
        } else {
            super.setAutomaticPerformanceSnapshots();
        }
    }

    public void setInTouchMode(boolean z) {
        if (this.a != null) {
            this.a.setInTouchMode(z);
        } else {
            super.setInTouchMode(z);
        }
    }

    public void start() {
        if (this.a != null) {
            this.a.start();
        } else {
            super.start();
        }
    }

    public Activity startActivitySync(Intent intent) {
        return this.a != null ? this.a.startActivitySync(intent) : super.startActivitySync(intent);
    }

    public void startAllocCounting() {
        if (this.a != null) {
            this.a.startAllocCounting();
        } else {
            super.startAllocCounting();
        }
    }

    public void startPerformanceSnapshot() {
        if (this.a != null) {
            this.a.startPerformanceSnapshot();
        } else {
            super.startPerformanceSnapshot();
        }
    }

    public void startProfiling() {
        if (this.a != null) {
            this.a.startProfiling();
        } else {
            super.startProfiling();
        }
    }

    public void stopAllocCounting() {
        if (this.a != null) {
            this.a.stopAllocCounting();
        } else {
            super.stopAllocCounting();
        }
    }

    public void stopProfiling() {
        if (this.a != null) {
            this.a.stopProfiling();
        } else {
            super.stopProfiling();
        }
    }

    public void waitForIdle(Runnable runnable) {
        if (this.a != null) {
            this.a.waitForIdle(runnable);
        } else {
            super.waitForIdle(runnable);
        }
    }

    public void waitForIdleSync() {
        if (this.a != null) {
            this.a.waitForIdleSync();
        } else {
            super.waitForIdleSync();
        }
    }

    public Activity waitForMonitor(ActivityMonitor activityMonitor) {
        return this.a != null ? this.a.waitForMonitor(activityMonitor) : super.waitForMonitor(activityMonitor);
    }

    public Activity waitForMonitorWithTimeout(ActivityMonitor activityMonitor, long j) {
        return this.a != null ? this.a.waitForMonitorWithTimeout(activityMonitor, j) : super.waitForMonitorWithTimeout(activityMonitor, j);
    }
}
