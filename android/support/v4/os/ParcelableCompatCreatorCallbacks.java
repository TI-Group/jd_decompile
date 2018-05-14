package android.support.v4.os;

import android.os.Parcel;

/* compiled from: TbsSdkJava */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i);
}
