package cn.jiguang.api;

import android.content.Context;

public abstract class JActionExtra {
    public Object beforLogin(Context context, int i, String str) {
        return null;
    }

    public Object beforRegister(Context context, int i, String str) {
        return null;
    }

    public boolean checkAction(int i) {
        return true;
    }
}
