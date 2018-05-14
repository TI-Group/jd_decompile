package cn.jiguang.api;

import android.content.Context;

public interface JAnalyticsAction {
    void dispatchPause(Context context);

    void dispatchResume(Context context);

    void dispatchStatus(Context context, String str);
}
