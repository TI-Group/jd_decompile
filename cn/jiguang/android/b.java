package cn.jiguang.android;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements a {
    private static final String z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "E1\u0014m-A*[i#\b>Tc6I6^)\rb>Nf\u0017N>Hb";
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
        r5 = 68;
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
        r5 = 38;
        goto L_0x0019;
    L_0x0038:
        r5 = 95;
        goto L_0x0019;
    L_0x003b:
        r5 = 58;
        goto L_0x0019;
    L_0x003e:
        r5 = 7;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.android.b.<clinit>():void");
    }

    public b() {
        attachInterface(this, z);
    }

    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(z);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        ShareValues shareValues = null;
        int i3 = 0;
        boolean a;
        switch (i) {
            case 1:
                parcel.enforceInterface(z);
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    shareValues = (ShareValues) ShareValues.CREATOR.createFromParcel(parcel);
                }
                shareValues = a(readString, shareValues, parcel.readInt());
                parcel2.writeNoException();
                if (shareValues != null) {
                    parcel2.writeInt(1);
                    shareValues.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 2:
                parcel.enforceInterface(z);
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    shareValues = (ShareValues) ShareValues.CREATOR.createFromParcel(parcel);
                }
                a = a(readString2, shareValues, parcel.readInt() != 0, parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface(z);
                a = a();
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface(z);
                IBinder a2 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a2);
                return true;
            case 1598968902:
                parcel2.writeString(z);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
