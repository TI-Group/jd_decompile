package cn.jiguang.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator<ShareValues> {
    d() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ShareValues(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ShareValues[i];
    }
}
