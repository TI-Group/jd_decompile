package uk.co.chrisjenx.calligraphy;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    public static Typeface load(AssetManager assetManager, String str) {
        synchronized (sCachedFonts) {
            try {
                Typeface typeface;
                if (sCachedFonts.containsKey(str)) {
                    typeface = (Typeface) sCachedFonts.get(str);
                    return typeface;
                }
                typeface = Typeface.createFromAsset(assetManager, str);
                sCachedFonts.put(str, typeface);
                return typeface;
            } catch (Throwable e) {
                Log.w("Calligraphy", "Can't create asset from " + str + ". Make sure you have passed in the correct path and file name.", e);
                sCachedFonts.put(str, null);
                return null;
            }
        }
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        synchronized (sCachedSpans) {
            if (sCachedSpans.containsKey(typeface)) {
                CalligraphyTypefaceSpan calligraphyTypefaceSpan = (CalligraphyTypefaceSpan) sCachedSpans.get(typeface);
                return calligraphyTypefaceSpan;
            }
            calligraphyTypefaceSpan = new CalligraphyTypefaceSpan(typeface);
            sCachedSpans.put(typeface, calligraphyTypefaceSpan);
            return calligraphyTypefaceSpan;
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue(typeface);
    }

    private TypefaceUtils() {
    }
}
