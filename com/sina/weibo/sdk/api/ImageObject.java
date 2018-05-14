package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TbsSdkJava */
public class ImageObject extends BaseMediaObject {
    public static final Creator<ImageObject> CREATOR = new Creator<ImageObject>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public ImageObject a(Parcel parcel) {
            return new ImageObject(parcel);
        }

        public ImageObject[] a(int i) {
            return new ImageObject[i];
        }
    };
    public byte[] g;
    public String h;

    public ImageObject(Parcel parcel) {
        this.g = parcel.createByteArray();
        this.h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.g);
        parcel.writeString(this.h);
    }

    protected BaseMediaObject a(String str) {
        return this;
    }
}
