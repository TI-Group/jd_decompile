package com.jd.fridge.util;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.jd.fridge.GlobalVariable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: TbsSdkJava */
public class c {
    public static final float[] a = new float[]{1.7f, 0.1f, 0.1f, 0.0f, -73.1f, 0.0f, 1.7f, 0.1f, 0.0f, -73.1f, 0.0f, 0.1f, 1.6f, 0.0f, -73.1f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] b = new float[]{0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.8f, 1.6f, 0.2f, 0.0f, -163.9f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] c = new float[]{0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.2f, 0.5f, 0.1f, 0.0f, 40.8f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] d = new float[]{1.9f, -0.3f, -0.2f, 0.0f, -87.0f, -0.2f, 1.7f, -0.1f, 0.0f, -87.0f, -0.1f, -0.6f, 2.0f, 0.0f, -87.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] e = new float[]{0.6f, 0.3f, 0.1f, 0.0f, 73.3f, 0.2f, 0.7f, 0.1f, 0.0f, 73.3f, 0.2f, 0.3f, 0.4f, 0.0f, 73.3f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] f = new float[]{1.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] g = new float[]{0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.9f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] h = new float[]{0.9f, 0.0f, 0.0f, 0.0f, 63.0f, 0.0f, 0.9f, 0.0f, 0.0f, 63.0f, 0.0f, 0.0f, 0.9f, 0.0f, 63.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] i = new float[]{0.9f, 0.0f, 0.0f, 0.0f, 64.9f, 0.0f, 0.9f, 0.0f, 0.0f, 64.9f, 0.0f, 0.0f, 0.9f, 0.0f, 64.9f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] j = new float[]{2.1f, -1.4f, 0.6f, 0.0f, -31.0f, -0.3f, 2.0f, -0.3f, 0.0f, -31.0f, -1.1f, -0.2f, 2.6f, 0.0f, -31.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] k = new float[]{0.8f, 0.3f, 0.1f, 0.0f, 46.5f, 0.1f, 0.9f, 0.0f, 0.0f, 46.5f, 0.1f, 0.3f, 0.7f, 0.0f, 46.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] l = new float[]{1.0f, 0.0f, 0.0f, 0.0f, -66.6f, 0.0f, 1.1f, 0.0f, 0.0f, -66.6f, 0.0f, 0.0f, 1.0f, 0.0f, -66.6f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[][] m = new float[][]{a, b, c, f, e, g, l};

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static byte[] a(Context context, String str) {
        if (!a(str)) {
            return y.d(str);
        }
        Bitmap a = a(context, str, 1136.0d);
        if (a == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
        if (!(a == null || a.isRecycled())) {
            a.recycle();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String a(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri.getPath();
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme)) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex > -1) {
                str = query.getString(columnIndex);
            }
        }
        query.close();
        return str;
    }

    private static boolean a(String str) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (((double) options.outWidth) > 1136.0d) {
            return true;
        }
        return false;
    }

    private static int b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            if (exifInterface == null) {
                return 0;
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", -1);
            if (attributeInt == -1) {
                return 0;
            }
            switch (attributeInt) {
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap a(String str, Bitmap bitmap) {
        int i = 90;
        int b = b(str);
        if (b <= 0) {
            return bitmap;
        }
        if (b == 270) {
            i = -90;
        } else if (b == 180) {
            i = -180;
        } else if (b != 90) {
            i = 0;
        }
        if (i != 0) {
            return a(i, bitmap);
        }
        return bitmap;
    }

    public static Bitmap a(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap == null || bitmap.isRecycled()) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap a(Context context, String str, double d) {
        Bitmap a;
        Exception exception;
        Bitmap bitmap = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            double d2 = (double) options.outWidth;
            double d3 = (double) options.outHeight;
            if (1136.0d != d) {
                if (d2 != d) {
                    d2 = (d3 * d) / d2;
                    options.inDensity = context.getResources().getDisplayMetrics().densityDpi;
                    options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                    options.inSampleSize = a(options, -1, (int) ((d2 * d) * 2.0d));
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                }
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Config.RGB_565;
                a = a(str, BitmapFactory.decodeFile(str, options));
                try {
                    int height = a.getHeight();
                    int width = a.getWidth();
                    if (((double) width) != d) {
                        a = a(a, (int) d, (int) ((((double) height) * d) / ((double) width)));
                    }
                } catch (Exception e) {
                    Exception exception2 = e;
                    bitmap = a;
                    exception = exception2;
                    exception.printStackTrace();
                    k.a(exception.getStackTrace().toString());
                    a = bitmap;
                    if (a == null) {
                        new t(context).a("图片过大无法载入");
                    }
                    return a;
                }
            }
            if (d2 > d3) {
                if (d2 > d) {
                    d2 = (d3 * d) / d2;
                    options.inDensity = context.getResources().getDisplayMetrics().densityDpi;
                    options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                    options.inSampleSize = a(options, -1, (int) ((d2 * d) * 2.0d));
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                }
            } else if (d3 > d) {
                d2 = (d2 * d) / d3;
                options.inDensity = context.getResources().getDisplayMetrics().densityDpi;
                options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                options.inSampleSize = a(options, -1, (int) ((d2 * d) * 2.0d));
                options.inPurgeable = true;
                options.inInputShareable = true;
            }
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Config.RGB_565;
            a = a(str, BitmapFactory.decodeFile(str, options));
        } catch (Exception e2) {
            exception = e2;
            exception.printStackTrace();
            k.a(exception.getStackTrace().toString());
            a = bitmap;
            if (a == null) {
                new t(context).a("图片过大无法载入");
            }
            return a;
        }
        if (a == null) {
            new t(context).a("图片过大无法载入");
        }
        return a;
    }

    private static int a(Options options, int i, int i2) {
        int b = b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    private static int b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i != -1) {
            return min;
        }
        return ceil;
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            throw new IllegalArgumentException("the param bitmap can not be null");
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.RGB_565);
        Matrix matrix = new Matrix();
        matrix.setScale(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
        return createBitmap;
    }

    public static boolean a(Context context, Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        boolean z;
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        File file = new File(GlobalVariable.e, "QrImage");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, str);
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        z = true;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        z = true;
                    }
                } else {
                    z = true;
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            z = false;
                        } catch (IOException e32) {
                            e32.printStackTrace();
                            z = false;
                        }
                        Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
                        return z;
                    }
                    z = false;
                    Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e32 = e6;
                e32.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        z = false;
                    } catch (IOException e322) {
                        e322.printStackTrace();
                        z = false;
                    }
                    Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
                    return z;
                }
                z = false;
                Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
                return z;
            }
        } catch (FileNotFoundException e7) {
            e2 = e7;
            fileOutputStream = null;
            e2.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
                z = false;
                Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
                return z;
            }
            z = false;
            Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
            return z;
        } catch (IOException e8) {
            e322 = e8;
            fileOutputStream = null;
            e322.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
                z = false;
                Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
                return z;
            }
            z = false;
            Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
        try {
            Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, null);
        } catch (FileNotFoundException e22) {
            e22.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getPath())));
        return z;
    }
}
