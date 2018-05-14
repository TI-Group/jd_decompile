package com.jd.fridge.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/* compiled from: TbsSdkJava */
public class w {
    public static void a(TextView textView, String str, int i, int i2, int i3) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 34);
        textView.setText(spannableStringBuilder);
    }

    public static void b(TextView textView, String str, int i, int i2, int i3) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i3), i, i2, 34);
        textView.setText(spannableStringBuilder);
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }
}
