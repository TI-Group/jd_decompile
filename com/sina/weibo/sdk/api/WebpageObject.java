package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class WebpageObject extends BaseMediaObject {
    public static final Creator<WebpageObject> CREATOR = new Creator<WebpageObject>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public WebpageObject a(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        public WebpageObject[] a(int i) {
            return new WebpageObject[i];
        }
    };
    public String g;

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected BaseMediaObject a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.g = new JSONObject(str).optString("extra_key_defaulttext");
            } catch (JSONException e) {
            }
        }
        return this;
    }
}
