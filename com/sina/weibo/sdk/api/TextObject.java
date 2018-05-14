package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TbsSdkJava */
public class TextObject extends BaseMediaObject {
    public static final Creator<TextObject> CREATOR = new Creator<TextObject>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public TextObject a(Parcel parcel) {
            return new TextObject(parcel);
        }

        public TextObject[] a(int i) {
            return new TextObject[i];
        }
    };
    public String g;

    public TextObject(Parcel parcel) {
        this.g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
    }

    protected BaseMediaObject a(String str) {
        return this;
    }
}
