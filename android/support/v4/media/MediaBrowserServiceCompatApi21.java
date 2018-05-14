package android.support.v4.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService.Result;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
class MediaBrowserServiceCompatApi21 {

    /* compiled from: TbsSdkJava */
    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String str, int i, Bundle bundle);

        void onLoadChildren(String str, ResultWrapper<List<Parcel>> resultWrapper);
    }

    /* compiled from: TbsSdkJava */
    static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        BrowserRoot(String str, Bundle bundle) {
            this.mRootId = str;
            this.mExtras = bundle;
        }
    }

    /* compiled from: TbsSdkJava */
    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.mServiceProxy = serviceCompatProxy;
        }

        public android.service.media.MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            BrowserRoot onGetRoot = this.mServiceProxy.onGetRoot(str, i, bundle);
            return onGetRoot == null ? null : new android.service.media.MediaBrowserService.BrowserRoot(onGetRoot.mRootId, onGetRoot.mExtras);
        }

        public void onLoadChildren(String str, Result<List<MediaItem>> result) {
            this.mServiceProxy.onLoadChildren(str, new ResultWrapper(result));
        }
    }

    /* compiled from: TbsSdkJava */
    static class ResultWrapper<T> {
        Result mResultObj;

        ResultWrapper(Result result) {
            this.mResultObj = result;
        }

        public void sendResult(T t) {
            if (t instanceof List) {
                this.mResultObj.sendResult(parcelListToItemList((List) t));
            } else if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                this.mResultObj.sendResult(MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.mResultObj.sendResult(null);
            }
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List<MediaItem> parcelListToItemList(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            List<MediaItem> arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }

    MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void onCreate(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static IBinder onBind(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void setSessionToken(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((Token) obj2);
    }

    public static void notifyChildrenChanged(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }
}
