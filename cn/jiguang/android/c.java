package cn.jiguang.android;

import android.os.IBinder;
import android.os.Parcel;

final class c implements a {
    private static final String z;
    private IBinder a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "\u0001zzsz\u0005a5wtLu:}a\r}07Z&u x@\nu&|";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x0027;
    L_0x000b:
        r3 = r0;
        r4 = r2;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0010:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0038;
            case 2: goto L_0x003b;
            case 3: goto L_0x003e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r5 = 19;
    L_0x0019:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0010;
    L_0x0025:
        r1 = r0;
        r0 = r3;
    L_0x0027:
        if (r1 > r2) goto L_0x000b;
    L_0x0029:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        z = r0;
        return;
    L_0x0035:
        r5 = 98;
        goto L_0x0019;
    L_0x0038:
        r5 = 20;
        goto L_0x0019;
    L_0x003b:
        r5 = 84;
        goto L_0x0019;
    L_0x003e:
        r5 = 25;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.android.c.<clinit>():void");
    }

    c(IBinder iBinder) {
        this.a = iBinder;
    }

    public final IBinder a(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(z);
            obtain.writeString(str);
            obtain.writeString(str2);
            this.a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            IBinder readStrongBinder = obtain2.readStrongBinder();
            return readStrongBinder;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final ShareValues a(String str, ShareValues shareValues, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(z);
            obtain.writeString(str);
            if (shareValues != null) {
                obtain.writeInt(1);
                shareValues.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(i);
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            ShareValues shareValues2 = obtain2.readInt() != 0 ? (ShareValues) ShareValues.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return shareValues2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean a() {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(z);
            this.a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean a(String str, ShareValues shareValues, boolean z, int i) {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(z);
            obtain.writeString(str);
            if (shareValues != null) {
                obtain.writeInt(1);
                shareValues.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeInt(z ? 1 : 0);
            obtain.writeInt(i);
            this.a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
