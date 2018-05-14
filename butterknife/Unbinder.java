package butterknife;

import android.support.annotation.UiThread;

/* compiled from: TbsSdkJava */
public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() {
        public void unbind() {
        }
    };

    @UiThread
    void unbind();
}
