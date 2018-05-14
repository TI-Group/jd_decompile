package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

/* compiled from: TbsSdkJava */
public final class PopupMenuCompat {
    static final PopupMenuImpl IMPL;

    /* compiled from: TbsSdkJava */
    interface PopupMenuImpl {
        OnTouchListener getDragToOpenListener(Object obj);
    }

    /* compiled from: TbsSdkJava */
    static class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
        }

        public OnTouchListener getDragToOpenListener(Object obj) {
            return null;
        }
    }

    /* compiled from: TbsSdkJava */
    static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
        }

        public OnTouchListener getDragToOpenListener(Object obj) {
            return PopupMenuCompatKitKat.getDragToOpenListener(obj);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            IMPL = new KitKatPopupMenuImpl();
        } else {
            IMPL = new BasePopupMenuImpl();
        }
    }

    private PopupMenuCompat() {
    }

    public static OnTouchListener getDragToOpenListener(Object obj) {
        return IMPL.getDragToOpenListener(obj);
    }
}
