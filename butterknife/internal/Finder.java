package butterknife.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;

/* compiled from: TbsSdkJava */
public enum Finder {
    VIEW {
        public View findOptionalView(Object obj, @IdRes int i) {
            return ((View) obj).findViewById(i);
        }

        public Context getContext(Object obj) {
            return ((View) obj).getContext();
        }

        protected String getResourceEntryName(Object obj, @IdRes int i) {
            if (((View) obj).isInEditMode()) {
                return "<unavailable while editing>";
            }
            return super.getResourceEntryName(obj, i);
        }
    },
    ACTIVITY {
        public View findOptionalView(Object obj, @IdRes int i) {
            return ((Activity) obj).findViewById(i);
        }

        public Context getContext(Object obj) {
            return (Activity) obj;
        }
    },
    DIALOG {
        public View findOptionalView(Object obj, @IdRes int i) {
            return ((Dialog) obj).findViewById(i);
        }

        public Context getContext(Object obj) {
            return ((Dialog) obj).getContext();
        }
    };

    public abstract View findOptionalView(Object obj, @IdRes int i);

    public abstract Context getContext(Object obj);

    public final <T> T findOptionalViewAsType(Object obj, @IdRes int i, String str, Class<T> cls) {
        return castView(findOptionalView(obj, i), i, str, cls);
    }

    public final View findRequiredView(Object obj, @IdRes int i, String str) {
        View findOptionalView = findOptionalView(obj, i);
        if (findOptionalView != null) {
            return findOptionalView;
        }
        throw new IllegalStateException("Required view '" + getResourceEntryName(obj, i) + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public final <T> T findRequiredViewAsType(Object obj, @IdRes int i, String str, Class<T> cls) {
        return castView(findRequiredView(obj, i, str), i, str, cls);
    }

    public final <T> T castView(View view, @IdRes int i, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (Throwable e) {
            throw new IllegalStateException("View '" + getResourceEntryName(view, i) + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }

    public final <T> T castParam(Object obj, String str, int i, String str2, int i2) {
        return obj;
    }

    protected String getResourceEntryName(Object obj, @IdRes int i) {
        return getContext(obj).getResources().getResourceEntryName(i);
    }
}
