package cn.jiguang.android;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cn.jiguang.c.d;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ShareValues implements Parcelable {
    public static final Creator<ShareValues> CREATOR = new d();
    private static final String[] z;
    private ConcurrentHashMap<String, Serializable> a;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 4;
        r5 = new java.lang.String[r0];
        r4 = "mv\n\u001f\u0003n|\u0006S\u0014&}\u001cKPdvSq%J_";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x0071;
    L_0x0013:
        r9 = r1;
    L_0x0014:
        r10 = r4;
        r11 = r9;
        r14 = r8;
        r8 = r4;
        r4 = r14;
    L_0x0019:
        r13 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x0066;
            case 1: goto L_0x0068;
            case 2: goto L_0x006b;
            case 3: goto L_0x006e;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
    L_0x0022:
        r12 = r12 ^ r13;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x002e;
    L_0x002a:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x0019;
    L_0x002e:
        r8 = r4;
        r4 = r10;
    L_0x0030:
        if (r8 > r9) goto L_0x0014;
    L_0x0032:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0050;
            case 2: goto L_0x005a;
            default: goto L_0x003e;
        };
    L_0x003e:
        r6[r5] = r4;
        r0 = "U{\u0012M\u0015Pr\u001fJ\u0015u";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "ucSM\u0015gwSd";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "[3\u0016G\u0013cc\u0007V\u001fh)";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000c;
    L_0x005a:
        r6[r5] = r4;
        z = r7;
        r0 = new cn.jiguang.android.d;
        r0.<init>();
        CREATOR = r0;
        return;
    L_0x0066:
        r12 = 6;
        goto L_0x0022;
    L_0x0068:
        r12 = 19;
        goto L_0x0022;
    L_0x006b:
        r12 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x0022;
    L_0x006e:
        r12 = 63;
        goto L_0x0022;
    L_0x0071:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.android.ShareValues.<clinit>():void");
    }

    public ShareValues() {
        this.a = new ConcurrentHashMap(5);
    }

    protected ShareValues(Parcel parcel) {
        int readInt = parcel.readInt();
        this.a = new ConcurrentHashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            String readString = parcel.readString();
            switch (parcel.readInt()) {
                case 0:
                    this.a.put(readString, e.a(parcel.readInt()));
                    break;
                case 1:
                    this.a.put(readString, parcel.readString());
                    break;
                case 2:
                    this.a.put(readString, Integer.valueOf(parcel.readInt()));
                    break;
                case 3:
                    this.a.put(readString, Boolean.valueOf(parcel.readByte() != (byte) 0));
                    break;
                case 4:
                    this.a.put(readString, Long.valueOf(parcel.readLong()));
                    break;
                case 5:
                    this.a.put(readString, Float.valueOf(parcel.readFloat()));
                    break;
                case 6:
                    String[] strArr = new String[parcel.readInt()];
                    parcel.readStringArray(strArr);
                    this.a.put(readString, new HashSet(Arrays.asList(strArr)));
                    break;
                default:
                    break;
            }
        }
    }

    public ShareValues(ShareValues shareValues) {
        this.a = new ConcurrentHashMap(shareValues.a);
    }

    private static HashSet<String> a(SharedPreferences sharedPreferences, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        try {
            Set<String> stringSet = sharedPreferences.getStringSet(str, null);
            if (stringSet == null) {
                return null;
            }
            if (stringSet instanceof HashSet) {
                return (HashSet) stringSet;
            }
            HashSet<String> hashSet = new HashSet();
            try {
                for (String add : stringSet) {
                    hashSet.add(add);
                }
                return hashSet;
            } catch (ClassCastException e) {
                return hashSet;
            }
        } catch (ClassCastException e2) {
            return null;
        }
    }

    private void a(SharedPreferences sharedPreferences, String str, long j) {
        try {
            this.a.put(str, Integer.valueOf(sharedPreferences.getInt(str, (int) j)));
        } catch (ClassCastException e) {
            d.a(z[1], new StringBuilder(z[2]).append(str).append(z[3]).append(e.getMessage()).toString());
            this.a.put(str, Integer.valueOf((int) sharedPreferences.getLong(str, j)));
        }
    }

    private void a(SharedPreferences sharedPreferences, String str, HashSet hashSet) {
        HashSet a = a(sharedPreferences, str);
        if (a != null) {
            this.a.put(str, a);
        } else if (hashSet != null) {
            this.a.put(str, hashSet);
        } else {
            this.a.put(str, e.g);
        }
    }

    private static void a(String str) {
        if (str == null) {
            d.i(z[1], z[0]);
        }
    }

    private <T extends Serializable> T b(String str) {
        a(str);
        Serializable serializable = (Serializable) this.a.get(str);
        Object obj = (serializable == null || (serializable instanceof e)) ? 1 : null;
        return obj != null ? null : serializable;
    }

    private void b(SharedPreferences sharedPreferences, String str, long j) {
        try {
            this.a.put(str, Long.valueOf(sharedPreferences.getLong(str, j)));
        } catch (ClassCastException e) {
            d.a(z[1], new StringBuilder(z[2]).append(str).append(z[3]).append(e.getMessage()).toString());
            this.a.put(str, Long.valueOf((long) sharedPreferences.getInt(str, (int) j)));
        }
    }

    public final ShareValues a() {
        for (Entry entry : this.a.entrySet()) {
            this.a.put((String) entry.getKey(), e.a((Serializable) entry.getValue()));
        }
        return this;
    }

    public final ShareValues a(SharedPreferences sharedPreferences) {
        for (Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            Serializable serializable = (Serializable) entry.getValue();
            try {
                if (sharedPreferences.contains(str)) {
                    if (serializable instanceof String) {
                        this.a.put(str, sharedPreferences.getString(str, (String) serializable));
                    } else if (serializable instanceof Integer) {
                        a(sharedPreferences, str, ((Long) serializable).longValue());
                    } else if (serializable instanceof Boolean) {
                        this.a.put(str, Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) serializable).booleanValue())));
                    } else if (serializable instanceof Long) {
                        b(sharedPreferences, str, ((Long) serializable).longValue());
                    } else if (serializable instanceof Float) {
                        this.a.put(str, Float.valueOf(sharedPreferences.getFloat(str, ((Float) serializable).floatValue())));
                    } else if (serializable instanceof HashSet) {
                        a(sharedPreferences, str, (HashSet) serializable);
                    } else if (serializable instanceof e) {
                        switch (((e) serializable).a) {
                            case 0:
                                String string = sharedPreferences.getString(str, null);
                                if (string == null) {
                                    a(sharedPreferences, str, null);
                                    break;
                                }
                                this.a.put(str, string);
                                break;
                            case 1:
                                this.a.put(str, sharedPreferences.getString(str, ""));
                                break;
                            case 2:
                                a(sharedPreferences, str, 0);
                                break;
                            case 3:
                                this.a.put(str, Boolean.valueOf(sharedPreferences.getBoolean(str, false)));
                                break;
                            case 4:
                                b(sharedPreferences, str, 0);
                                break;
                            case 5:
                                this.a.put(str, Float.valueOf(sharedPreferences.getFloat(str, 0.0f)));
                                break;
                            case 6:
                                a(sharedPreferences, str, null);
                                break;
                            default:
                                break;
                        }
                    }
                } else if (serializable instanceof String) {
                    this.a.put(str, e.b);
                } else if (serializable instanceof Integer) {
                    this.a.put(str, e.c);
                } else if (serializable instanceof Boolean) {
                    this.a.put(str, e.d);
                } else if (serializable instanceof Long) {
                    this.a.put(str, e.e);
                } else if (serializable instanceof Float) {
                    this.a.put(str, e.f);
                } else if (serializable instanceof HashSet) {
                    this.a.put(str, e.g);
                }
            } catch (Throwable th) {
                d.g(z[1], new StringBuilder(z[2]).append(str).append(z[3]).append(th.getMessage()).toString());
            }
        }
        return this;
    }

    public final ShareValues a(ShareValues shareValues) {
        if (!(shareValues == null || shareValues.a == null)) {
            for (Entry entry : this.a.entrySet()) {
                String str = (String) entry.getKey();
                Serializable serializable = (Serializable) shareValues.a.get(str);
                if (serializable != null) {
                    this.a.put(str, serializable);
                } else {
                    this.a.put(str, e.a((Serializable) entry.getValue()));
                }
            }
        }
        return this;
    }

    public final ShareValues a(ShareValues shareValues, boolean z) {
        if (shareValues != null) {
            for (Entry entry : shareValues.a.entrySet()) {
                String str = (String) entry.getKey();
                Serializable serializable = (Serializable) entry.getValue();
                if (!(serializable instanceof e)) {
                    this.a.put(str, serializable);
                } else if (z) {
                    this.a.remove(str);
                }
            }
        }
        return this;
    }

    public final ShareValues a(String str, int i) {
        a(str);
        this.a.put(str, Integer.valueOf(i));
        return this;
    }

    public final ShareValues a(String str, long j) {
        a(str);
        this.a.put(str, Long.valueOf(j));
        return this;
    }

    public final ShareValues a(String str, String str2) {
        a(str);
        if (str2 != null) {
            this.a.put(str, str2);
        } else {
            this.a.put(str, e.b);
        }
        return this;
    }

    public final <T extends Serializable> T a(String str, T t) {
        T b = b(str);
        return b != null ? b : t;
    }

    public final boolean a(SharedPreferences sharedPreferences, boolean z) {
        if (sharedPreferences == null) {
            return false;
        }
        Editor edit = sharedPreferences.edit();
        for (Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            Serializable serializable = (Serializable) entry.getValue();
            if (serializable instanceof String) {
                edit.putString(str, (String) serializable);
            } else if (serializable instanceof Integer) {
                edit.putInt(str, ((Integer) serializable).intValue());
            } else if (serializable instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) serializable).booleanValue());
            } else if (serializable instanceof Long) {
                edit.putLong(str, ((Long) serializable).longValue());
            } else if (serializable instanceof Float) {
                edit.putFloat(str, ((Float) serializable).floatValue());
            } else if ((serializable instanceof HashSet) && VERSION.SDK_INT >= 11) {
                try {
                    edit.putStringSet(str, (HashSet) serializable);
                } catch (ClassCastException e) {
                }
            } else if (serializable instanceof e) {
                edit.remove(str);
            }
        }
        edit.apply();
        return true;
    }

    public final <T extends Serializable> ShareValues b(String str, T t) {
        a(str);
        if (t != null) {
            this.a.put(str, t);
        } else {
            this.a.put(str, e.h);
        }
        return this;
    }

    public final boolean b() {
        for (Entry value : this.a.entrySet()) {
            if (((Serializable) value.getValue()) instanceof e) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ShareValues) && this.a.equals(((ShareValues) obj).a);
    }

    public String toString() {
        return new StringBuilder(z[1]).append(this.a).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.size());
        for (Entry entry : this.a.entrySet()) {
            parcel.writeString((String) entry.getKey());
            Serializable serializable = (Serializable) entry.getValue();
            if (serializable instanceof String) {
                parcel.writeInt(1);
                parcel.writeString((String) serializable);
            } else if (serializable instanceof Integer) {
                parcel.writeInt(2);
                parcel.writeInt(((Integer) serializable).intValue());
            } else if (serializable instanceof Boolean) {
                boolean booleanValue = ((Boolean) serializable).booleanValue();
                parcel.writeInt(3);
                parcel.writeByte((byte) (booleanValue ? 1 : 0));
            } else if (serializable instanceof Long) {
                parcel.writeInt(4);
                parcel.writeLong(((Long) serializable).longValue());
            } else if (serializable instanceof Float) {
                parcel.writeInt(5);
                parcel.writeFloat(((Float) serializable).floatValue());
            } else if (serializable instanceof HashSet) {
                try {
                    String[] strArr = (String[]) ((HashSet) serializable).toArray();
                    parcel.writeInt(6);
                    parcel.writeInt(strArr.length);
                    parcel.writeStringArray(strArr);
                } catch (ClassCastException e) {
                }
            } else if (serializable instanceof e) {
                parcel.writeInt(0);
                parcel.writeInt(((e) serializable).a);
            }
        }
    }
}
