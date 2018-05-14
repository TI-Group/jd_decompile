package android.support.v4.widget;

import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

/* compiled from: TbsSdkJava */
class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
    }

    public static OnTouchListener getDragToOpenListener(Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}
