package cn.jpush.android.d;

import android.content.Context;
import cn.jpush.android.data.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: TbsSdkJava */
public final class f {
    public static Queue<c> a = null;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 14;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "0 MZU\u00174ISXT8NQ\u0012T\u0012T@YT M\u0016L\u0006:^SO\u0007<SQ\u001cYu";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00bb;
            case 1: goto L_0x00bf;
            case 2: goto L_0x00c3;
            case 3: goto L_0x00c7;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 60;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "9&ZgI\u0011 XcH\u001d9N";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0019&Z\u0016O\u0015#X\u0016U\u001auNF\u001c\u00124TZY\u0010o";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "W SSD\u00170MBY\u0010u\u0010\u0016Y\u001a!TBE?0D\u0016K\u0015&\u001dXI\u00189";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0019&ZiM\u00010HS";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001d;TB\u001c\u00184NBq\u00072lCY\u00010\u001dP]\u001d9XR\u0006";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "W SSD\u00170MBY\u0010u\u0010\u0016_\u001b;ISD\u0000uJWOT;HZP";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "56I_S\u001au\u0010\u0016O\u0015#Xy^\u001e0^BO";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0001;XN_\u0011%ISXTy\u001dUS\u001a!XNHT<N\u0016R\u00019Q";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u00074KS\u001c;7WS_\u0000&\u001ds1-^SL\u0000<RX\u001c\u0011'OYNN";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0019\u001a_\\Y\u0017!q_O\u0000uTE\u001c\u001a QZ";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u00074KS\u001c;7WS_\u0000&\u001dpU\u00180sYH2:HXX1-^SL\u0000<RX\u001c\u0011'OYNN";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "=;MCH'!OS]\u0019u^ZS\u00070\u001dP]\u001d9XR\u0006";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0018:\\R\u001c\u001b7WS_\u0000&\u001dSN\u0006:O\f";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        a = r0;
        return;
    L_0x00bb:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
    L_0x00bf:
        r9 = 85;
        goto L_0x0020;
    L_0x00c3:
        r9 = 61;
        goto L_0x0020;
    L_0x00c7:
        r9 = 54;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.f.<clinit>():void");
    }

    private static synchronized void a(Context context, String str) {
        synchronized (f.class) {
            if (context == null) {
                e.g(z[1], z[8]);
            } else {
                File file = new File(context.getFilesDir(), str);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private static synchronized <T> void a(Context context, String str, ArrayList<T> arrayList) {
        synchronized (f.class) {
            e.a(z[1], z[7]);
            if (context == null) {
                e.g(z[1], z[8]);
            } else if (arrayList == null) {
                e.g(z[1], z[10]);
            } else {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
                    objectOutputStream.writeObject(arrayList);
                    objectOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.h(z[1], new StringBuilder(z[11]).append(e.getMessage()).toString());
                } catch (IOException e2) {
                    e.h(z[1], new StringBuilder(z[9]).append(e2.getMessage()).toString());
                }
            }
        }
    }

    public static boolean a(Context context, c cVar) {
        ArrayList b;
        if (a == null) {
            a = new ConcurrentLinkedQueue();
            try {
                b = b(context, z[4]);
                if (!(b == null || b.isEmpty())) {
                    Iterator it = b.iterator();
                    while (it.hasNext()) {
                        a.offer((c) it.next());
                    }
                }
            } catch (Exception e) {
                e.h(z[1], new StringBuilder(z[5]).append(e.getMessage()).toString());
            }
        }
        if (context == null) {
            e.h(z[1], z[6]);
            return false;
        }
        if (cVar == null) {
            e.h(z[1], z[3]);
        }
        if (a.contains(cVar)) {
            e.i(z[1], new StringBuilder(z[0]).append(cVar).toString());
            return true;
        }
        if (a.size() >= 200) {
            a.poll();
        }
        a.offer(cVar);
        try {
            b = b(context, z[4]);
            if (b == null) {
                b = new ArrayList();
            }
            if (b.size() >= 50) {
                b.remove(0);
            }
            b.add(cVar);
            a(context, z[4], b);
        } catch (Exception e2) {
            e.h(z[1], new StringBuilder(z[2]).append(e2.getMessage()).toString());
        }
        return false;
    }

    private static synchronized <T> ArrayList<T> b(Context context, String str) {
        Exception e;
        Throwable th;
        ArrayList<T> arrayList = null;
        synchronized (f.class) {
            if (context == null) {
                e.g(z[1], z[8]);
            } else {
                ArrayList<T> arrayList2 = new ArrayList();
                ObjectInputStream objectInputStream;
                try {
                    objectInputStream = new ObjectInputStream(context.openFileInput(str));
                    try {
                        arrayList = (ArrayList) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            e.g(z[1], new StringBuilder(z[12]).append(e2.getMessage()).toString());
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            e.g(z[1], new StringBuilder(z[13]).append(e.getMessage()).toString());
                            a(context, str);
                            if (objectInputStream == null) {
                                try {
                                    objectInputStream.close();
                                    arrayList = arrayList2;
                                } catch (IOException e4) {
                                    e.g(z[1], new StringBuilder(z[12]).append(e4.getMessage()).toString());
                                    arrayList = arrayList2;
                                }
                            } else {
                                arrayList = arrayList2;
                            }
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e22) {
                                    e.g(z[1], new StringBuilder(z[12]).append(e22.getMessage()).toString());
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    Exception exception = e5;
                    objectInputStream = null;
                    e = exception;
                    e.g(z[1], new StringBuilder(z[13]).append(e.getMessage()).toString());
                    a(context, str);
                    if (objectInputStream == null) {
                        arrayList = arrayList2;
                    } else {
                        objectInputStream.close();
                        arrayList = arrayList2;
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    objectInputStream = null;
                    th = th3;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }
}
