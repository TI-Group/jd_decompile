package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

/* compiled from: TbsSdkJava */
class MediaSessionCompatApi23 {

    /* compiled from: TbsSdkJava */
    public interface Callback extends Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    /* compiled from: TbsSdkJava */
    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
