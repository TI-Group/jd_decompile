package com.jd.fridge.widget.cropavatar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.http.cookie.ClientCookie;

/* compiled from: TbsSdkJava */
public class ClipImageActivity extends Activity implements OnClickListener {
    private ClipImageLayout a = null;

    public static void a(Activity activity, String str, int i) {
        Intent intent = new Intent(activity, ClipImageActivity.class);
        intent.putExtra(ClientCookie.PATH_ATTR, str);
        activity.startActivityForResult(intent, i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.crop_image_layout);
        this.a = (ClipImageLayout) findViewById(R.id.clipImageLayout);
        String stringExtra = getIntent().getStringExtra(ClientCookie.PATH_ATTR);
        int b = b(stringExtra);
        Bitmap a = a(stringExtra);
        if (a == null) {
            finish();
        } else if (b == 0) {
            this.a.setImageBitmap(a);
        } else {
            this.a.setImageBitmap(a(b, a));
        }
        findViewById(R.id.okBtn).setOnClickListener(this);
        findViewById(R.id.cancleBtn).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.okBtn) {
            Bitmap a = this.a.a();
            String str = GlobalVariable.B().s().getPath() + "/temp_avatar" + System.currentTimeMillis() + ".jpg";
            a(a, str);
            Intent intent = new Intent();
            intent.putExtra("crop_image", str);
            setResult(-1, intent);
        }
        finish();
    }

    private void a(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        IOException e;
        Throwable th;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            fileOutputStream = null;
            e22.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
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

    private Bitmap a(String str) {
        FileInputStream fileInputStream;
        IOException e;
        Throwable th;
        Bitmap bitmap = null;
        if (str != null) {
            Options options = new Options();
            options.inSampleSize = 4;
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inDither = false;
            options.inPurgeable = true;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, options);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        e2.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e222 = e4;
                fileInputStream = bitmap;
                e222.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return bitmap;
            } catch (Throwable th3) {
                fileInputStream = bitmap;
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return bitmap;
    }

    private int b(String str) {
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

    private Bitmap a(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }
}
