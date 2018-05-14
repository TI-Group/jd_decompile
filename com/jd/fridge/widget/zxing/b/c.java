package com.jd.fridge.widget.zxing.b;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class c {
    static final Set<BarcodeFormat> a = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});
    static final Set<BarcodeFormat> b = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
    static final Set<BarcodeFormat> c = EnumSet.copyOf(a);
    static final Set<BarcodeFormat> d = EnumSet.of(BarcodeFormat.QR_CODE);
    static final Collection<BarcodeFormat> e = EnumSet.of(BarcodeFormat.DATA_MATRIX);

    static {
        c.addAll(b);
    }

    public static Collection<BarcodeFormat> a() {
        return d;
    }

    public static Collection<BarcodeFormat> b() {
        return c;
    }
}
