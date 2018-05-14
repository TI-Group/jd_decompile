package com.tencent.smtt.sdk;

import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

class bb implements IUserStateChangedListener {
    final /* synthetic */ ba a;

    bb(ba baVar) {
        this.a = baVar;
    }

    public void onUserStateChanged() {
        this.a.a.c();
    }
}
