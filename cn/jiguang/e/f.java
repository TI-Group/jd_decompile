package cn.jiguang.e;

import cn.jiguang.c.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class f {
    private static final String[] z;

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
        r4 = "[\b\fDc.";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x006b;
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
            case 0: goto L_0x005f;
            case 1: goto L_0x0062;
            case 2: goto L_0x0065;
            case 3: goto L_0x0068;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 82;
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
        r0 = "$r\u000bN\r-";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "I\u001exZj";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "Z#R\u0012\u0007h#R";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000c;
    L_0x005a:
        r6[r5] = r4;
        z = r7;
        return;
    L_0x005f:
        r12 = 28;
        goto L_0x0022;
    L_0x0062:
        r12 = 74;
        goto L_0x0022;
    L_0x0065:
        r12 = 62;
        goto L_0x0022;
    L_0x0068:
        r12 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x0022;
    L_0x006b:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.f.<clinit>():void");
    }

    public static ArrayList<String> a(InputStream inputStream) {
        Exception e;
        Throwable th;
        ArrayList<String> arrayList = new ArrayList();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream, z[2]);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 2048);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    readLine = readLine.trim();
                    if (!"".equals(readLine)) {
                        arrayList.add(readLine);
                    }
                }
                bufferedReader.close();
                try {
                    inputStreamReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    d.i(z[3], e.getMessage());
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader = null;
            d.i(z[3], e.getMessage());
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        return arrayList;
    }

    private static void a(File file, ZipOutputStream zipOutputStream, String str) {
        String str2 = new String((str + (str.trim().length() == 0 ? "" : File.separator) + file.getName()).getBytes(z[1]), z[0]);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    a(a, zipOutputStream, str2);
                }
                return;
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File a : collection) {
            a(a, zipOutputStream, "");
        }
        zipOutputStream.close();
    }
}
