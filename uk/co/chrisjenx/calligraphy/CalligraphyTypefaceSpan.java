package uk.co.chrisjenx.calligraphy;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: TbsSdkJava */
public class CalligraphyTypefaceSpan extends MetricAffectingSpan {
    private final Typeface typeface;

    public CalligraphyTypefaceSpan(Typeface typeface) {
        if (typeface == null) {
            throw new IllegalArgumentException("typeface is null");
        }
        this.typeface = typeface;
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    private void apply(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (this.typeface.getStyle() ^ -1);
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
    }
}
