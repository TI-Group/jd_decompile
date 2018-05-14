package com.kepler.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: TbsSdkJava */
public class b {
    private static Class<AssetManager> a = AssetManager.class;
    private static Method b;

    /* compiled from: TbsSdkJava */
    public static class a {
        public static final String[] a = new String[]{"AndroidManifest.xml"};
        public static final String[] b = new String[]{"AndroidManifest.xml", "classes.dex"};
        private static final Object c = new Object();
        private static WeakReference<byte[]> d;

        /* compiled from: TbsSdkJava */
        static class a implements Enumeration<JarEntry> {
            private final JarFile a;
            private final String[] b;
            private int c = 0;

            public /* synthetic */ Object nextElement() {
                return a();
            }

            public a(JarFile jarFile, String... strArr) {
                this.a = jarFile;
                this.b = strArr;
            }

            public boolean hasMoreElements() {
                return this.c < this.b.length;
            }

            public JarEntry a() {
                JarFile jarFile = this.a;
                String[] strArr = this.b;
                int i = this.c;
                this.c = i + 1;
                return jarFile.getJarEntry(strArr[i]);
            }
        }

        public static Signature[] a(String str) {
            return a(str, false);
        }

        public static Signature[] a(String str, boolean z) {
            return a(str, z ? b : null);
        }

        public static Signature[] a(String str, String... strArr) {
            if (!b(str)) {
                return null;
            }
            byte[] bArr;
            WeakReference weakReference;
            synchronized (c) {
                byte[] bArr2;
                WeakReference weakReference2 = d;
                if (weakReference2 != null) {
                    d = null;
                    bArr2 = (byte[]) weakReference2.get();
                } else {
                    bArr2 = null;
                }
                if (bArr2 == null) {
                    Object obj = new byte[8192];
                    bArr = obj;
                    weakReference = new WeakReference(obj);
                } else {
                    bArr = bArr2;
                    weakReference = weakReference2;
                }
            }
            try {
                int i;
                JarFile jarFile = new JarFile(str);
                Enumeration a = a(jarFile, strArr);
                Certificate[] certificateArr = null;
                while (a.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) a.nextElement();
                    if (!(jarEntry == null || jarEntry.isDirectory() || jarEntry.getName().startsWith("META-INF/"))) {
                        Certificate[] a2 = a(jarFile, jarEntry, bArr);
                        if (a2 == null) {
                            Log.e("Certificates", "File " + str + " has no certificates at entry " + jarEntry.getName() + "; ignoring!");
                            jarFile.close();
                            return null;
                        }
                        Certificate[] certificateArr2;
                        if (certificateArr == null) {
                            certificateArr2 = a2;
                        } else {
                            int i2 = 0;
                            while (i2 < certificateArr.length) {
                                Object obj2;
                                i = 0;
                                while (i < a2.length) {
                                    if (certificateArr[i2] != null && certificateArr[i2].equals(a2[i])) {
                                        obj2 = 1;
                                        break;
                                    }
                                    i++;
                                }
                                obj2 = null;
                                if (obj2 == null || certificateArr.length != a2.length) {
                                    Log.e("Certificates", "File " + str + " has mismatched certificates at entry " + jarEntry.getName() + "; ignoring!");
                                    jarFile.close();
                                    return null;
                                }
                                i2++;
                            }
                            certificateArr2 = certificateArr;
                        }
                        certificateArr = certificateArr2;
                    }
                }
                jarFile.close();
                synchronized (c) {
                    d = weakReference;
                }
                if (certificateArr != null) {
                    if (certificateArr.length > 0) {
                        i = certificateArr.length;
                        Signature[] signatureArr = new Signature[certificateArr.length];
                        for (int i3 = 0; i3 < i; i3++) {
                            signatureArr[i3] = new Signature(certificateArr[i3].getEncoded());
                        }
                        return signatureArr;
                    }
                }
                Log.e("Certificates", "File " + str + " has no certificates; ignoring!");
                return null;
            } catch (Throwable e) {
                Log.w("Certificates", "Exception reading " + str, e);
                return null;
            } catch (Throwable e2) {
                Log.w("Certificates", "Exception reading " + str, e2);
                return null;
            } catch (Throwable e22) {
                Log.w("Certificates", "Exception reading " + str, e22);
                return null;
            }
        }

        private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
            InputStream bufferedInputStream;
            Throwable e;
            Throwable th;
            Certificate[] certificateArr = null;
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                do {
                    try {
                    } catch (IOException e2) {
                        e = e2;
                    } catch (RuntimeException e3) {
                        e = e3;
                    }
                } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
                if (jarEntry != null) {
                    certificateArr = jarEntry.getCertificates();
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable e4) {
                        Log.w("Certificates", "Close IS Exception" + jarEntry.getName() + " in " + jarFile.getName(), e4);
                    }
                }
            } catch (IOException e5) {
                e4 = e5;
                bufferedInputStream = null;
                try {
                    Log.w("Certificates", "Exception reading " + jarEntry.getName() + " in " + jarFile.getName(), e4);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable e42) {
                            Log.w("Certificates", "Close IS Exception" + jarEntry.getName() + " in " + jarFile.getName(), e42);
                        }
                    }
                    return certificateArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable e422) {
                            Log.w("Certificates", "Close IS Exception" + jarEntry.getName() + " in " + jarFile.getName(), e422);
                        }
                    }
                    throw th;
                }
            } catch (RuntimeException e6) {
                e422 = e6;
                bufferedInputStream = null;
                Log.w("Certificates", "Exception reading " + jarEntry.getName() + " in " + jarFile.getName(), e422);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable e4222) {
                        Log.w("Certificates", "Close IS Exception" + jarEntry.getName() + " in " + jarFile.getName(), e4222);
                    }
                }
                return certificateArr;
            } catch (Throwable e42222) {
                bufferedInputStream = null;
                th = e42222;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
            return certificateArr;
        }

        private static boolean b(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return true;
            }
            return false;
        }

        private static Enumeration<JarEntry> a(JarFile jarFile, String... strArr) {
            if (strArr == null || strArr.length == 0) {
                return jarFile.entries();
            }
            return new a(jarFile, strArr);
        }
    }

    static {
        try {
            b = a.getDeclaredMethod("addAssetPath", new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Resources a(Context context, String str) {
        Resources resources = null;
        if (!a(str)) {
            return resources;
        }
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        ApplicationInfo applicationInfo = packageArchiveInfo == null ? resources : packageArchiveInfo.applicationInfo;
        if (applicationInfo != null) {
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                resources = context.getPackageManager().getResourcesForApplication(applicationInfo);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (resources == null) {
            return c(context, str);
        }
        return resources;
    }

    private static Resources c(Context context, String str) {
        if (a == null || b == null || !a(str)) {
            return null;
        }
        Resources resources;
        try {
            AssetManager assetManager = (AssetManager) a.newInstance();
            b.invoke(assetManager, new Object[]{str});
            resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            resources = null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            resources = null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            resources = null;
        } catch (Throwable th) {
            th.printStackTrace();
            resources = null;
        }
        return resources;
    }

    public static PackageInfo b(Context context, String str) {
        return a(context, str, 0);
    }

    public static PackageInfo a(Context context, String str, int i) {
        if (!a(str)) {
            return null;
        }
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, i);
        if (packageArchiveInfo == null) {
            return null;
        }
        if ((i & 64) != 0 && packageArchiveInfo.signatures == null) {
            packageArchiveInfo.signatures = a.a(str);
        }
        return packageArchiveInfo;
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }
}
