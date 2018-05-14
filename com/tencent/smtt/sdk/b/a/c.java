package com.tencent.smtt.sdk.b.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;

class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof View)) {
            View view2 = (View) parent;
            if (view2.getTag() == this.a.f) {
                this.a.onClick(view2);
            }
        }
    }
}
