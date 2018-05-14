package cn.jiguang.api;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.nio.ByteBuffer;

public interface JAction {
    long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer);

    void dispatchTimeOutMessage(Context context, long j, long j2, int i);

    IBinder getBinderByType(String str);

    String getSdkVersion();

    void handleMessage(Context context, long j, Object obj);

    boolean isSupportedCMD(int i);

    void onActionRun(Context context, long j, Bundle bundle, Object obj);

    void onEvent(Context context, long j, int i);
}
