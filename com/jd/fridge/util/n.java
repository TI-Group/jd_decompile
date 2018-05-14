package com.jd.fridge.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.jd.fridge.GlobalVariable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: TbsSdkJava */
public class n {
    public static File a(Context context, String str) {
        Bitmap a;
        Throwable e;
        File file = new File(str);
        long length = file.length();
        if (length < 204800) {
            return file;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i = options.outHeight;
        int i2 = options.outWidth;
        double sqrt = Math.sqrt((double) (((float) length) / 204800.0f));
        options.outHeight = (int) (((double) i) / sqrt);
        options.outWidth = (int) (((double) i2) / sqrt);
        options.inSampleSize = (int) (sqrt + 0.5d);
        options.inJustDecodeBounds = false;
        try {
            a = a(BitmapFactory.decodeFile(str, options), a(str));
            try {
                String path = GlobalVariable.B().s().getPath();
                File file2 = new File(path);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                file = new File(path + "/compress_temp_avatar" + System.currentTimeMillis() + ".jpg");
                OutputStream fileOutputStream = new FileOutputStream(file);
                a.compress(CompressFormat.JPEG, 50, fileOutputStream);
                fileOutputStream.close();
                if (a == null || a.isRecycled()) {
                    return file;
                }
                a.recycle();
                return file;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (a != null || a.isRecycled()) {
                        return null;
                    }
                    a.recycle();
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (!(a == null || a.isRecycled())) {
                        a.recycle();
                    }
                    throw e;
                }
            } catch (OutOfMemoryError e3) {
                e = e3;
                e.printStackTrace();
                if (a != null) {
                }
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            a = null;
            e.printStackTrace();
            if (a != null) {
            }
            return null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            a = null;
            e.printStackTrace();
            if (a != null) {
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            a.recycle();
            throw e;
        }
    }

    public static int a(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
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

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0) {
            return bitmap;
        }
        Bitmap createBitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        try {
            createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap == null || bitmap.isRecycled()) {
                createBitmap = null;
            } else {
                bitmap.recycle();
                createBitmap = null;
            }
        } catch (Throwable th) {
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        return createBitmap;
    }
}
