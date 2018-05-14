package com.kepler.sdk;

import android.content.Context;
import android.os.Environment;
import com.kepler.jd.login.KeplerApiManager;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* compiled from: TbsSdkJava */
public class aj {
    public static String a(File file) {
        FileInputStream fileInputStream;
        String format;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                BigInteger bigInteger = new BigInteger(1, instance.digest());
                format = String.format("%032x", new Object[]{bigInteger});
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                try {
                    format = "";
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return format;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Error e4) {
                format = "";
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e322) {
                        e322.printStackTrace();
                    }
                }
                return format;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            format = "";
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return format;
        } catch (Error e6) {
            fileInputStream = null;
            format = "";
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return format;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return format;
    }

    public static File a() {
        try {
            Context applicatonContext;
            if (Environment.getExternalStorageState().equals("mounted") || (Environment.getExternalStorageDirectory().exists() && Environment.getExternalStorageDirectory().canWrite())) {
                applicatonContext = KeplerApiManager.getWebViewService().getApplicatonContext();
                if (applicatonContext != null) {
                    return applicatonContext.getExternalCacheDir();
                }
                return Environment.getExternalStorageDirectory();
            }
            applicatonContext = KeplerApiManager.getWebViewService().getApplicatonContext();
            if (applicatonContext != null) {
                return applicatonContext.getCacheDir();
            }
            return Environment.getDataDirectory();
        } catch (Exception e) {
            return null;
        }
    }

    public static File b() {
        try {
            File file = new File(a(), "com.jd.jdsdk");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".nomedia");
            if (file2.exists()) {
                return file;
            }
            file2.createNewFile();
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static File c() {
        try {
            File file = new File(b(), "module");
            if (file.exists()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception e) {
            return null;
        }
    }

    public static void b(File file) {
        if (file != null && file != null) {
            try {
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            } catch (Exception e) {
            }
        }
    }
}
