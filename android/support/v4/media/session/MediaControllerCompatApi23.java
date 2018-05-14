package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

/* compiled from: TbsSdkJava */
class MediaControllerCompatApi23 {

    /* compiled from: TbsSdkJava */
    public static class TransportControls extends android.support.v4.media.session.MediaControllerCompatApi21.TransportControls {
        public static void playFromUri(Object obj, Uri uri, Bundle bundle) {
            ((android.media.session.MediaController.TransportControls) obj).playFromUri(uri, bundle);
        }
    }

    MediaControllerCompatApi23() {
    }
}
