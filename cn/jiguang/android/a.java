package cn.jiguang.android;

import android.os.IBinder;
import android.os.IInterface;

public interface a extends IInterface {
    IBinder a(String str, String str2);

    ShareValues a(String str, ShareValues shareValues, int i);

    boolean a();

    boolean a(String str, ShareValues shareValues, boolean z, int i);
}
