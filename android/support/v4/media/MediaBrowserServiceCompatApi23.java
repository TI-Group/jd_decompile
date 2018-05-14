package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.service.media.MediaBrowserService.Result;

/* compiled from: TbsSdkJava */
class MediaBrowserServiceCompatApi23 {

    /* compiled from: TbsSdkJava */
    public interface ServiceCompatProxy extends android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String str, ResultWrapper<Parcel> resultWrapper);
    }

    /* compiled from: TbsSdkJava */
    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadItem(String str, Result<MediaItem> result) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadItem(str, new ResultWrapper(result));
        }
    }

    MediaBrowserServiceCompatApi23() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }
}
