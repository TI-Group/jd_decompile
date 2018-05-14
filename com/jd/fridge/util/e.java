package com.jd.fridge.util;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* compiled from: TbsSdkJava */
public final class e {
    private static final String a = (e.class.getName() + ".");

    /* compiled from: TbsSdkJava */
    public enum a {
        CACHE_MODEL_SHORT,
        CACHE_MODEL_MEDIUM,
        CACHE_MODEL_ML,
        CACHE_MODEL_LONG,
        CACHE_MODEL_MAX
    }

    private e() {
    }

    public static boolean a(String str, Context context, Object obj) {
        Exception e;
        OutputStream outputStream;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        ObjectOutputStream objectOutputStream;
        try {
            OutputStream openFileOutput = context.openFileOutput(str, 0);
            try {
                objectOutputStream = new ObjectOutputStream(openFileOutput);
                try {
                    objectOutputStream.writeObject(obj);
                    z = true;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            k.a("cacheFile.serializable=e===" + e2.toString());
                        }
                    }
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            k.a("cacheFile.serializable=eeeeee===" + e22.toString());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    outputStream = openFileOutput;
                    try {
                        e.printStackTrace();
                        k.a("cacheFile.serializable=ex===" + e.toString());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                                k.a("cacheFile.serializable=e===" + e222.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                                k.a("cacheFile.serializable=eeeeee===" + e2222.toString());
                            }
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                                k.a("cacheFile.serializable=e===" + e22222.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e222222) {
                                e222222.printStackTrace();
                                k.a("cacheFile.serializable=eeeeee===" + e222222.toString());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = openFileOutput;
                    if (objectOutputStream != null) {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                objectOutputStream = null;
                outputStream = openFileOutput;
                e.printStackTrace();
                k.a("cacheFile.serializable=ex===" + e.toString());
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return z;
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = null;
                outputStream = openFileOutput;
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            objectOutputStream = null;
            e.printStackTrace();
            k.a("cacheFile.serializable=ex===" + e.toString());
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th5) {
            th = th5;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    public static Object a(String str, Context context, a aVar) {
        ObjectInputStream objectInputStream;
        Exception e;
        InputStream inputStream;
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(y.c(context).getPath() + File.separator + str);
        k.a("cacheFile=----=");
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        k.a("cacheFile.path=====" + file.getPath());
        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
        r.a(a, file.getAbsolutePath() + " expiredTime:" + (currentTimeMillis / 60000) + "min");
        k.a("cacheFile.expiredTime=====" + currentTimeMillis);
        if (currentTimeMillis < 0) {
            return null;
        }
        if (aVar == a.CACHE_MODEL_SHORT) {
            if (currentTimeMillis > CommonUtil.REPORT_ERROR_SLEEP_TIME) {
                k.a("cacheFile.CACHE_MODEL_SHORT=====" + currentTimeMillis + "==shortime==" + CommonUtil.REPORT_ERROR_SLEEP_TIME);
                return null;
            }
        } else if (aVar == a.CACHE_MODEL_MEDIUM) {
            if (currentTimeMillis > 7200000) {
                k.a("cacheFile.CACHE_MEDIUM_TIMEOUT=====" + currentTimeMillis + "==CACHE_MEDIUM_TIMEOUT==" + 7200000);
                return null;
            }
        } else if (aVar == a.CACHE_MODEL_ML) {
            if (currentTimeMillis > 86400000) {
                k.a("cacheFile.CACHE_ML_TIMEOUT=====" + currentTimeMillis + "==CACHE_ML_TIMEOUT==" + 86400000);
                return null;
            }
        } else if (aVar == a.CACHE_MODEL_LONG) {
            if (currentTimeMillis > 604800000) {
                k.a("cacheFile.CACHE_LONG_TIMEOUT=====" + currentTimeMillis + "==CACHE_LONG_TIMEOUT==" + 604800000);
                return null;
            }
        } else if (aVar != a.CACHE_MODEL_MAX) {
            k.a("cacheFile.else====");
            return null;
        } else if (currentTimeMillis > Long.MAX_VALUE) {
            k.a("cacheFile.CACHE_MAX_TIMEOUT=====" + currentTimeMillis + "==CACHE_MAX_TIMEOUT==" + Long.MAX_VALUE);
            return null;
        }
        Object obj = null;
        try {
            InputStream openFileInput = context.openFileInput(str);
            try {
                objectInputStream = new ObjectInputStream(openFileInput);
                try {
                    obj = objectInputStream.readObject();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            k.a("cacheFile.e====" + e2.toString());
                        }
                    }
                    if (openFileInput == null) {
                        return obj;
                    }
                    try {
                        openFileInput.close();
                        return obj;
                    } catch (IOException e22) {
                        e22.printStackTrace();
                        k.a("cacheFile.eee====" + e22.toString());
                        return obj;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = openFileInput;
                    try {
                        e.printStackTrace();
                        k.a("cacheFile.ex====" + e.toString());
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                                k.a("cacheFile.e====" + e222.toString());
                            }
                        }
                        if (fileInputStream != null) {
                            return obj;
                        }
                        try {
                            fileInputStream.close();
                            return obj;
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                            k.a("cacheFile.eee====" + e2222.toString());
                            return obj;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                                k.a("cacheFile.e====" + e22222.toString());
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e222222) {
                                e222222.printStackTrace();
                                k.a("cacheFile.eee====" + e222222.toString());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = openFileInput;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                objectInputStream = null;
                inputStream = openFileInput;
                e.printStackTrace();
                k.a("cacheFile.ex====" + e.toString());
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    return obj;
                }
                fileInputStream.close();
                return obj;
            } catch (Throwable th4) {
                th = th4;
                objectInputStream = null;
                inputStream = openFileInput;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            objectInputStream = null;
            e.printStackTrace();
            k.a("cacheFile.ex====" + e.toString());
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (fileInputStream != null) {
                return obj;
            }
            fileInputStream.close();
            return obj;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
