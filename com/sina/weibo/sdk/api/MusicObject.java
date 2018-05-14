package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class MusicObject extends BaseMediaObject {
    public static final Creator<MusicObject> CREATOR = new Creator<MusicObject>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public MusicObject a(Parcel parcel) {
            return new MusicObject(parcel);
        }

        public MusicObject[] a(int i) {
            return new MusicObject[i];
        }
    };
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;

    public MusicObject(Parcel parcel) {
        super(parcel);
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
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
