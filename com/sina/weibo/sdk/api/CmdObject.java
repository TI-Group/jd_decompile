package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TbsSdkJava */
public class CmdObject extends BaseMediaObject {
    public static final Creator<CmdObject> CREATOR = new Creator<CmdObject>() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public CmdObject a(Parcel parcel) {
            return new CmdObject(parcel);
        }

        public CmdObject[] a(int i) {
            return new CmdObject[i];
        }
    };
    public String g;

    public CmdObject(Parcel parcel) {
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
