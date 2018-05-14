package com.jd.fridge.util;

import android.graphics.Typeface;
import com.jd.fridge.GlobalVariable;

/* compiled from: TbsSdkJava */
public class l {
    private static l c = null;
    Typeface a;
    Typeface b;

    /* compiled from: TbsSdkJava */
    public enum a {
        LED_REGULAR,
        FZLTH_GBK
    }

    public static l a() {
        if (c == null) {
            c = new l();
        }
        return c;
    }

    public Typeface a(a aVar) {
        switch (aVar) {
            case LED_REGULAR:
                if (this.a == null) {
                    this.a = Typeface.createFromAsset(GlobalVariable.B().getApplicationContext().getAssets(), "fonts/yejing_number.ttf");
                }
                return this.a;
            case FZLTH_GBK:
                if (this.b == null) {
                    this.b = Typeface.createFromAsset(GlobalVariable.B().getApplicationContext().getAssets(), "fonts/FZLTH_GBK.ttf");
                }
                return this.b;
            default:
                return null;
        }
    }
}
