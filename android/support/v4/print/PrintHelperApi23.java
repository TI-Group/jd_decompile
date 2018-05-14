package android.support.v4.print;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;

/* compiled from: TbsSdkJava */
class PrintHelperApi23 extends PrintHelperApi20 {
    protected Builder copyAttributes(PrintAttributes printAttributes) {
        Builder copyAttributes = super.copyAttributes(printAttributes);
        if (printAttributes.getDuplexMode() != 0) {
            copyAttributes.setDuplexMode(printAttributes.getDuplexMode());
        }
        return copyAttributes;
    }

    PrintHelperApi23(Context context) {
        super(context);
        this.mIsMinMarginsHandlingCorrect = false;
    }
}
