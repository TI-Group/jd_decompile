package butterknife;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.UiThread;
import android.util.Log;
import android.util.Property;
import android.view.View;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class ButterKnife {
    static final Map<Class<?>, ViewBinder<Object>> BINDERS = new LinkedHashMap();
    static final ViewBinder<Object> NOP_VIEW_BINDER = new ViewBinder<Object>() {
        public Unbinder bind(Finder finder, Object obj, Object obj2) {
            return Unbinder.EMPTY;
        }
    };
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    /* compiled from: TbsSdkJava */
    public interface Action<T extends View> {
        @UiThread
        void apply(@NonNull T t, int i);
    }

    /* compiled from: TbsSdkJava */
    public interface Setter<T extends View, V> {
        @UiThread
        void set(@NonNull T t, V v, int i);
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Activity activity) {
        return getViewBinder(activity).bind(Finder.ACTIVITY, activity, activity);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull View view) {
        return getViewBinder(view).bind(Finder.VIEW, view, view);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Dialog dialog) {
        return getViewBinder(dialog).bind(Finder.DIALOG, dialog, dialog);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull Activity activity) {
        return getViewBinder(obj).bind(Finder.ACTIVITY, obj, activity);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull View view) {
        return getViewBinder(obj).bind(Finder.VIEW, obj, view);
    }

    @UiThread
    @NonNull
    public static Unbinder bind(@NonNull Object obj, @NonNull Dialog dialog) {
        return getViewBinder(obj).bind(Finder.DIALOG, obj, dialog);
    }

    @UiThread
    @CheckResult
    @NonNull
    static ViewBinder<Object> getViewBinder(@NonNull Object obj) {
        Class cls = obj.getClass();
        if (debug) {
            Log.d(TAG, "Looking up view binder for " + cls.getName());
        }
        return findViewBinderForClass(cls);
    }

    @UiThread
    @CheckResult
    @NonNull
    private static ViewBinder<Object> findViewBinderForClass(Class<?> cls) {
        ViewBinder<Object> viewBinder = (ViewBinder) BINDERS.get(cls);
        if (viewBinder == null) {
            String name = cls.getName();
            if (name.startsWith("android.") || name.startsWith("java.")) {
                if (debug) {
                    Log.d(TAG, "MISS: Reached framework class. Abandoning search.");
                }
                return NOP_VIEW_BINDER;
            }
            try {
                viewBinder = (ViewBinder) Class.forName(name + "_ViewBinder").newInstance();
                if (debug) {
                    Log.d(TAG, "HIT: Loaded view binder class.");
                }
            } catch (ClassNotFoundException e) {
                if (debug) {
                    Log.d(TAG, "Not found. Trying superclass " + cls.getSuperclass().getName());
                }
                viewBinder = findViewBinderForClass(cls.getSuperclass());
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to create view binder for " + name, e2);
            } catch (Throwable e22) {
                throw new RuntimeException("Unable to create view binder for " + name, e22);
            }
            BINDERS.put(cls, viewBinder);
            return viewBinder;
        } else if (!debug) {
            return viewBinder;
        } else {
            Log.d(TAG, "HIT: Cached in view binder map.");
            return viewBinder;
        }
    }

    @UiThread
    @SafeVarargs
    public static <T extends View> void apply(@NonNull List<T> list, @NonNull Action<? super T>... actionArr) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (Action apply : actionArr) {
                apply.apply((View) list.get(i), i);
            }
        }
    }

    @UiThread
    @SafeVarargs
    public static <T extends View> void apply(@NonNull T[] tArr, @NonNull Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            for (Action apply : actionArr) {
                apply.apply(tArr[i], i);
            }
        }
    }

    @UiThread
    public static <T extends View> void apply(@NonNull List<T> list, @NonNull Action<? super T> action) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            action.apply((View) list.get(i), i);
        }
    }

    @UiThread
    public static <T extends View> void apply(@NonNull T[] tArr, @NonNull Action<? super T> action) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            action.apply(tArr[i], i);
        }
    }

    @UiThread
    @SafeVarargs
    public static <T extends View> void apply(@NonNull T t, @NonNull Action<? super T>... actionArr) {
        for (Action apply : actionArr) {
            apply.apply(t, 0);
        }
    }

    @UiThread
    public static <T extends View> void apply(@NonNull T t, @NonNull Action<? super T> action) {
        action.apply(t, 0);
    }

    @UiThread
    public static <T extends View, V> void apply(@NonNull List<T> list, @NonNull Setter<? super T, V> setter, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            setter.set((View) list.get(i), v, i);
        }
    }

    @UiThread
    public static <T extends View, V> void apply(@NonNull T[] tArr, @NonNull Setter<? super T, V> setter, V v) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            setter.set(tArr[i], v, i);
        }
    }

    @UiThread
    public static <T extends View, V> void apply(@NonNull T t, @NonNull Setter<? super T, V> setter, V v) {
        setter.set(t, v, 0);
    }

    @UiThread
    @RequiresApi(14)
    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull List<T> list, @NonNull Property<? super T, V> property, V v) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            property.set(list.get(i), v);
        }
    }

    @UiThread
    @RequiresApi(14)
    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull T[] tArr, @NonNull Property<? super T, V> property, V v) {
        for (Object obj : tArr) {
            property.set(obj, v);
        }
    }

    @UiThread
    @RequiresApi(14)
    @TargetApi(14)
    public static <T extends View, V> void apply(@NonNull T t, @NonNull Property<? super T, V> property, V v) {
        property.set(t, v);
    }

    @CheckResult
    public static <T extends View> T findById(@NonNull View view, @IdRes int i) {
        return view.findViewById(i);
    }

    @CheckResult
    public static <T extends View> T findById(@NonNull Activity activity, @IdRes int i) {
        return activity.findViewById(i);
    }

    @CheckResult
    public static <T extends View> T findById(@NonNull Dialog dialog, @IdRes int i) {
        return dialog.findViewById(i);
    }
}
