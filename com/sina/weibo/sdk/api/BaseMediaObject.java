package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: TbsSdkJava */
public abstract class BaseMediaObject implements Parcelable {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public byte[] f;

    protected abstract BaseMediaObject a(String str);

    public BaseMediaObject(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.createByteArray();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByteArray(this.f);
    }
}
