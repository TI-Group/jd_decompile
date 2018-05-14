package com.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import c.a.aq;
import c.a.ar;
import c.a.as;
import c.a.cx;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: TbsSdkJava */
public final class k {
    private static k a = null;
    private static Context b;
    private static String c;
    private static long e = 1209600000;
    private static long f = 2097152;
    private a d;

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    /* compiled from: TbsSdkJava */
    public static class a {
        private final int a;
        private File b;
        private FilenameFilter c;

        public a(Context context) {
            this(context, ".um");
        }

        public a(Context context, String str) {
            this.a = 10;
            this.c = new FilenameFilter(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public boolean accept(File file, String str) {
                    return str.startsWith("um");
                }
            };
            this.b = new File(context.getFilesDir(), str);
            if (!this.b.exists() || !this.b.isDirectory()) {
                this.b.mkdir();
            }
        }

        public boolean a() {
            File[] listFiles = this.b.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return false;
            }
            return true;
        }

        public void a(b bVar) {
            File[] listFiles = this.b.listFiles(this.c);
            if (listFiles != null && listFiles.length > 0) {
                bVar.a(this.b);
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    try {
                        if (bVar.b(listFiles[i])) {
                            listFiles[i].delete();
                        }
                    } catch (Throwable th) {
                        listFiles[i].delete();
                    }
                }
                bVar.c(this.b);
            }
        }

        public void a(byte[] bArr) {
            int i = 0;
            if (bArr != null && bArr.length != 0) {
                try {
                    ar.a(new File(this.b, String.format(Locale.US, "um_cache_%d.env", new Object[]{Long.valueOf(System.currentTimeMillis())})), bArr);
                } catch (Exception e) {
                }
                File[] listFiles = this.b.listFiles(this.c);
                if (listFiles != null && listFiles.length >= 10) {
                    Arrays.sort(listFiles);
                    int length = listFiles.length - 10;
                    while (i < length) {
                        listFiles[i].delete();
                        i++;
                    }
                }
            }
        }
    }

    public k(Context context) {
        this.d = new a(context);
        b = context.getApplicationContext();
        c = context.getPackageName();
    }

    public static synchronized k a(Context context) {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k(context);
            }
            kVar = a;
        }
        return kVar;
    }

    private static boolean a(File file) {
        long length = file.length();
        if (!file.exists() || length <= f) {
            return false;
        }
        return true;
    }

    public String[] a() {
        SharedPreferences g = g();
        String string = g.getString("au_p", null);
        String string2 = g.getString("au_u", null);
        if (string == null || string2 == null) {
            return null;
        }
        return new String[]{string, string2};
    }

    public String b() {
        SharedPreferences a = cx.a(b);
        if (a != null) {
            return a.getString("appkey", null);
        }
        return null;
    }

    public byte[] c() {
        InputStream openFileInput;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        String i = i();
        File file = new File(b.getFilesDir(), i);
        if (a(file)) {
            file.delete();
        } else if (file.exists()) {
            try {
                openFileInput = b.openFileInput(i);
                try {
                    bArr = ar.b(openFileInput);
                    ar.c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        ar.c(openFileInput);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        ar.c(openFileInput);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                openFileInput = bArr;
                e.printStackTrace();
                ar.c(openFileInput);
                return bArr;
            } catch (Throwable th3) {
                openFileInput = bArr;
                th = th3;
                ar.c(openFileInput);
                throw th;
            }
        }
        return bArr;
    }

    public void a(byte[] bArr) {
        try {
            ar.a(new File(b.getFilesDir(), i()), bArr);
        } catch (Throwable e) {
            as.a(e);
        }
    }

    public void d() {
        b.deleteFile(h());
        b.deleteFile(i());
    }

    public void b(byte[] bArr) {
        this.d.a(bArr);
    }

    public boolean e() {
        return this.d.a();
    }

    public a f() {
        return this.d;
    }

    private SharedPreferences g() {
        return b.getSharedPreferences("mobclick_agent_user_" + c, 0);
    }

    private String h() {
        return "mobclick_agent_header_" + c;
    }

    private String i() {
        return "mobclick_agent_cached_" + c + aq.a(b);
    }
}
