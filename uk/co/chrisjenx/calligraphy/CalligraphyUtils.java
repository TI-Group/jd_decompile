package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import android.widget.TextView.BufferType;

/* compiled from: TbsSdkJava */
public final class CalligraphyUtils {
    public static final int[] ANDROID_ATTR_TEXT_APPEARANCE = new int[]{16842804};
    private static Boolean sAppCompatViewCheck = null;
    private static Boolean sToolbarCheck = null;

    public static CharSequence applyTypefaceSpan(CharSequence charSequence, Typeface typeface) {
        if (charSequence == null || charSequence.length() <= 0) {
            return charSequence;
        }
        CharSequence charSequence2;
        if (charSequence instanceof Spannable) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = new SpannableString(charSequence);
        }
        ((Spannable) charSequence2).setSpan(TypefaceUtils.getSpan(typeface), 0, charSequence2.length(), 33);
        return charSequence2;
    }

    public static boolean applyFontToTextView(TextView textView, Typeface typeface) {
        return applyFontToTextView(textView, typeface, false);
    }

    public static boolean applyFontToTextView(TextView textView, final Typeface typeface, boolean z) {
        if (textView == null || typeface == null) {
            return false;
        }
        textView.setPaintFlags((textView.getPaintFlags() | 128) | 1);
        textView.setTypeface(typeface);
        if (z) {
            textView.setText(applyTypefaceSpan(textView.getText(), typeface), BufferType.SPANNABLE);
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    CalligraphyUtils.applyTypefaceSpan(editable, typeface);
                }
            });
        }
        return true;
    }

    public static boolean applyFontToTextView(Context context, TextView textView, String str) {
        return applyFontToTextView(context, textView, str, false);
    }

    static boolean applyFontToTextView(Context context, TextView textView, String str, boolean z) {
        if (textView == null || context == null) {
            return false;
        }
        return applyFontToTextView(textView, TypefaceUtils.load(context.getAssets(), str), z);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig) {
        applyFontToTextView(context, textView, calligraphyConfig, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, boolean z) {
        if (context != null && textView != null && calligraphyConfig != null && calligraphyConfig.isFontSet()) {
            applyFontToTextView(context, textView, calligraphyConfig.getFontPath(), z);
        }
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String str) {
        applyFontToTextView(context, textView, calligraphyConfig, str, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig calligraphyConfig, String str, boolean z) {
        if (context != null && textView != null && calligraphyConfig != null) {
            if (TextUtils.isEmpty(str) || !applyFontToTextView(context, textView, str, z)) {
                applyFontToTextView(context, textView, calligraphyConfig, z);
            }
        }
    }

    static String pullFontPathFromView(Context context, AttributeSet attributeSet, int[] iArr) {
        if (iArr == null || attributeSet == null) {
            return null;
        }
        try {
            String resourceEntryName = context.getResources().getResourceEntryName(iArr[0]);
            int attributeResourceValue = attributeSet.getAttributeResourceValue(null, resourceEntryName, -1);
            if (attributeResourceValue > 0) {
                return context.getString(attributeResourceValue);
            }
            return attributeSet.getAttributeValue(null, resourceEntryName);
        } catch (NotFoundException e) {
            return null;
        }
    }

    static String pullFontPathFromStyle(Context context, AttributeSet attributeSet, int[] iArr) {
        if (iArr == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (obtainStyledAttributes != null) {
            String string;
            try {
                string = obtainStyledAttributes.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                obtainStyledAttributes.recycle();
            } catch (Exception e) {
                string = e;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return null;
    }

    static String pullFontPathFromTextAppearance(Context context, AttributeSet attributeSet, int[] iArr) {
        int i = -1;
        if (iArr == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_ATTR_TEXT_APPEARANCE);
        if (obtainStyledAttributes != null) {
            try {
                i = obtainStyledAttributes.getResourceId(0, -1);
            } catch (Exception e) {
                i = e;
                return null;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        obtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        if (obtainStyledAttributes == null) {
            return null;
        }
        String string;
        try {
            string = obtainStyledAttributes.getString(0);
            return string;
        } catch (Exception e2) {
            string = e2;
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static String pullFontPathFromTheme(Context context, int i, int[] iArr) {
        String str = null;
        if (!(i == -1 || iArr == null)) {
            Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(typedValue.resourceId, iArr);
            try {
                str = obtainStyledAttributes.getString(0);
            } catch (Exception e) {
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return str;
    }

    static String pullFontPathFromTheme(Context context, int i, int i2, int[] iArr) {
        String str = null;
        if (!(i == -1 || iArr == null)) {
            Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(i, typedValue, true);
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(typedValue.resourceId, new int[]{i2});
            int i3 = 0;
            try {
                i3 = obtainStyledAttributes.getResourceId(i3, -1);
                if (i3 != -1) {
                    obtainStyledAttributes = context.obtainStyledAttributes(i3, iArr);
                    if (obtainStyledAttributes != null) {
                        try {
                            str = obtainStyledAttributes.getString(0);
                        } catch (Exception e) {
                        } finally {
                            obtainStyledAttributes.recycle();
                        }
                    }
                }
            } catch (Exception e2) {
                i3 = e2;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return str;
    }

    static boolean canCheckForV7Toolbar() {
        if (sToolbarCheck == null) {
            try {
                Class.forName("android.support.v7.widget.Toolbar");
                sToolbarCheck = Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                sToolbarCheck = Boolean.FALSE;
            }
        }
        return sToolbarCheck.booleanValue();
    }

    static boolean canAddV7AppCompatViews() {
        if (sAppCompatViewCheck == null) {
            try {
                Class.forName("android.support.v7.widget.AppCompatTextView");
                sAppCompatViewCheck = Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                sAppCompatViewCheck = Boolean.FALSE;
            }
        }
        return sAppCompatViewCheck.booleanValue();
    }

    private CalligraphyUtils() {
    }
}
