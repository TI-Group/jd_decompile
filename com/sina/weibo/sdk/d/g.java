package com.sina.weibo.sdk.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import cn.jiguang.net.HttpUtils;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EncodingUtils;

/* compiled from: TbsSdkJava */
public class g {
    private static final String a = g.class.getName();
    private static final String[] b = new String[]{"drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable"};

    public static String a(Context context, String str, String str2, String str3) {
        Locale a = a();
        if (Locale.SIMPLIFIED_CHINESE.equals(a)) {
            return str2;
        }
        if (Locale.TRADITIONAL_CHINESE.equals(a)) {
            return str3;
        }
        return str;
    }

    public static Drawable a(Context context, String str) {
        return a(context, d(context, str), false);
    }

    public static Drawable b(Context context, String str) {
        return a(context, d(context, str), true);
    }

    public static Locale a() {
        Locale locale = Locale.getDefault();
        return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) ? locale : Locale.ENGLISH;
    }

    private static String d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            d.c(a, "id is NOT correct!");
            return null;
        }
        String a = a(context);
        d.a(a, "find Appropriate path...");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (i < b.length) {
            if (b[i].equals(a)) {
                i2 = i;
            }
            String stringBuilder = new StringBuilder(String.valueOf(b[i])).append(HttpUtils.PATHS_SEPARATOR).append(str).toString();
            if (e(context, stringBuilder)) {
                if (i2 != i) {
                    if (i2 >= 0) {
                        break;
                    }
                    i3 = i;
                } else {
                    return stringBuilder;
                }
            }
            i++;
        }
        i = -1;
        if (i3 <= 0 || i <= 0) {
            if (i3 <= 0 || i >= 0) {
                if (i3 >= 0 || i <= 0) {
                    d.c(a, "Not find the appropriate path for drawable");
                    i3 = -1;
                } else {
                    i3 = i;
                }
            }
        } else if (Math.abs(i2 - i) <= Math.abs(i2 - i3)) {
            i3 = i;
        }
        if (i3 >= 0) {
            return new StringBuilder(String.valueOf(b[i3])).append(HttpUtils.PATHS_SEPARATOR).append(str).toString();
        }
        d.c(a, "Not find the appropriate path for drawable");
        return null;
    }

    private static Drawable a(Context context, String str, boolean z) {
        InputStream open;
        IOException e;
        InputStream inputStream;
        Throwable th;
        try {
            Drawable ninePatchDrawable;
            open = context.getAssets().open(str);
            if (open != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(open);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (z) {
                        ninePatchDrawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                    } else {
                        decodeStream.setDensity(displayMetrics.densityDpi);
                        ninePatchDrawable = new BitmapDrawable(context.getResources(), decodeStream);
                    }
                } catch (IOException e2) {
                    e = e2;
                    inputStream = open;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            return null;
                        }
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (open != null) {
                        open.close();
                    }
                    throw th;
                }
            }
            ninePatchDrawable = null;
            if (open == null) {
                return ninePatchDrawable;
            }
            try {
                open.close();
                return ninePatchDrawable;
            } catch (IOException e42) {
                e42.printStackTrace();
                return ninePatchDrawable;
            }
        } catch (IOException e5) {
            e3 = e5;
            inputStream = null;
            e3.printStackTrace();
            if (inputStream != null) {
                return null;
            }
            inputStream.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }

    private static boolean e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            d.a(a, "file [" + str + "] existed");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        } catch (IOException e2) {
            d.a(a, "file [" + str + "] NOT existed");
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        }
    }

    private static String a(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
            return "drawable-ldpi";
        }
        if (i > ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR && i <= 160) {
            return "drawable-mdpi";
        }
        if (i > 160 && i <= 240) {
            return "drawable-hdpi";
        }
        if (i <= 240 || i > 320) {
            return "drawable-xxhdpi";
        }
        return "drawable-xhdpi";
    }

    public static int a(Context context, int i) {
        return (int) (((double) (context.getResources().getDisplayMetrics().density * ((float) i))) + 0.5d);
    }

    public static ColorStateList a(int i, int i2) {
        int[] iArr = new int[]{i2, i2, i2, i};
        int[][] iArr2 = new int[4][];
        iArr2[0] = new int[]{16842919};
        iArr2[1] = new int[]{16842913};
        iArr2[2] = new int[]{16842908};
        iArr2[3] = StateSet.WILD_CARD;
        return new ColorStateList(iArr2, iArr);
    }

    public static StateListDrawable a(Context context, String str, String str2) {
        Drawable b;
        Drawable b2;
        if (str.indexOf(".9") > -1) {
            b = b(context, str);
        } else {
            b = a(context, str);
        }
        if (str2.indexOf(".9") > -1) {
            b2 = b(context, str2);
        } else {
            b2 = a(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, b2);
        stateListDrawable.addState(new int[]{16842913}, b2);
        stateListDrawable.addState(new int[]{16842908}, b2);
        stateListDrawable.addState(StateSet.WILD_CARD, b);
        return stateListDrawable;
    }

    public static StateListDrawable b(Context context, String str, String str2, String str3) {
        Drawable b;
        Drawable b2;
        Drawable b3;
        if (str.indexOf(".9") > -1) {
            b = b(context, str);
        } else {
            b = a(context, str);
        }
        if (str3.indexOf(".9") > -1) {
            b2 = b(context, str3);
        } else {
            b2 = a(context, str3);
        }
        if (str2.indexOf(".9") > -1) {
            b3 = b(context, str2);
        } else {
            b3 = a(context, str2);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, b3);
        stateListDrawable.addState(new int[]{16842913}, b3);
        stateListDrawable.addState(new int[]{16842908}, b3);
        stateListDrawable.addState(new int[]{16842766}, b2);
        stateListDrawable.addState(StateSet.WILD_CARD, b);
        return stateListDrawable;
    }

    public static String c(Context context, String str) {
        String str2 = "";
        try {
            InputStream open = context.getAssets().open(str);
            if (open == null) {
                return str2;
            }
            DataInputStream dataInputStream = new DataInputStream(open);
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, HTTP.UTF_8);
            open.close();
            return str2;
        } catch (IOException e) {
            e.printStackTrace();
            return str2;
        }
    }
}
