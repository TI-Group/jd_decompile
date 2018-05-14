package cn.jpush.android.d;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: TbsSdkJava */
public final class c {
    public static final String a;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "::W|\u0014\n<W`\"\n:Ij";
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
        r9 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "96Q9\u0013\u001b%@u\u0018\u000e6W9\u0007\u00170Ql\u0005\u001bsW|\u0004\u0011&Wz\u0012^5Dp\u001b\u001b7\u000b";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "0<\u0005J3=2W}W\u0018<Pw\u0013P";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "=2K>\u0003^5Lw\u0013^7@o\u0012\u0012<U|\u0005^#Lz\u0003\u000b!@9\u0005\u001b Jl\u0005\u001d6\u0005p\u0019^\u0000aZ\u0016\f7\u000b";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Q\u0012K}\u0005\u0011:A6\u0013\u001f'D6";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "RsFv\u0019\n6KmM";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "0\u0006iUW\u001d<Km\u0012\u0006'";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "+\u0007c4O";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u001f0Qp\u0018\u0010iFk\u0012\u001f'@Q\u0003\u0013?cp\u001b\u001bs\b9\u0011\u0017?@I\u0016\n;\u001f";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = ":6I|\u0003\u001bsAp\u0005^6Wk\u0018\f";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = java.io.File.separator;
        r6 = r0.append(r1);
        r0 = "\f:Fq";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x00d9;
    L_0x00a1:
        r3 = r0;
        r4 = r2;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x00a6:
        r7 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x00cb;
            case 1: goto L_0x00ce;
            case 2: goto L_0x00d1;
            case 3: goto L_0x00d4;
            default: goto L_0x00ad;
        };
    L_0x00ad:
        r5 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
    L_0x00af:
        r5 = r5 ^ r7;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x00d7;
    L_0x00b7:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x00a6;
    L_0x00bb:
        r9 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x0020;
    L_0x00bf:
        r9 = 83;
        goto L_0x0020;
    L_0x00c3:
        r9 = 37;
        goto L_0x0020;
    L_0x00c7:
        r9 = 25;
        goto L_0x0020;
    L_0x00cb:
        r5 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x00af;
    L_0x00ce:
        r5 = 83;
        goto L_0x00af;
    L_0x00d1:
        r5 = 37;
        goto L_0x00af;
    L_0x00d4:
        r5 = 25;
        goto L_0x00af;
    L_0x00d7:
        r1 = r0;
        r0 = r3;
    L_0x00d9:
        if (r1 > r2) goto L_0x00a1;
    L_0x00db:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        r0 = r6.append(r0);
        r1 = java.io.File.separator;
        r0 = r0.append(r1);
        r0 = r0.toString();
        a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.c.<clinit>():void");
    }

    public static String a(Context context, String str) {
        String str2 = context.getFilesDir() + HttpUtils.PATHS_SEPARATOR + str;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2 + HttpUtils.PATHS_SEPARATOR;
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.substring(str.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1, str.length());
    }

    private static boolean a(File file) {
        boolean z = false;
        try {
            if (!file.exists()) {
                return z;
            }
            if (file.isFile()) {
                return file.delete();
            }
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                for (int i = z; i < length; i++) {
                    File file2 = new File(file, list[i]);
                    if (file2.isDirectory()) {
                        a(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            return file.delete();
        } catch (Exception e) {
            e.i(z[z], z[9]);
            return z;
        }
    }

    public static boolean a(String str, String str2, Context context) {
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException(z[6]);
        }
        e.a(z[0], new StringBuilder(z[8]).append(str).append(z[5]).append(str2).toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str2.getBytes(z[7]));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            e.a(z[0], "", th4);
            return false;
        }
    }

    public static boolean a(String str, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (TextUtils.isEmpty(str) || bArr.length <= 0) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static String b(Context context, String str) {
        try {
            File file;
            if (a.a()) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + z[4] + context.getPackageName() + File.separator + str + File.separator;
                file = new File(str2);
                if (file.exists()) {
                    return str2;
                }
                file.mkdirs();
                return str2;
            }
            file = new File(context.getFilesDir() + a);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 10) {
                    Arrays.sort(listFiles, new Comparator<File>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            File file = (File) obj;
                            File file2 = (File) obj2;
                            return file.lastModified() > file2.lastModified() ? -1 : file.lastModified() < file2.lastModified() ? 1 : 0;
                        }
                    });
                    a(listFiles[listFiles.length - 1]);
                }
            }
            return d(context, str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String c(Context context, String str) {
        try {
            if (a.a()) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + z[4] + context.getPackageName() + File.separator + str;
                if (new File(str2).exists()) {
                    return str2;
                }
                e.h(z[0], z[3]);
                return "";
            }
            e.h(z[0], z[2]);
            return "";
        } catch (Exception e) {
            e.h(z[0], z[1]);
            e.printStackTrace();
            return "";
        }
    }

    private static String d(Context context, String str) {
        String str2 = context.getFilesDir() + a + str;
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2 + HttpUtils.PATHS_SEPARATOR;
    }
}
