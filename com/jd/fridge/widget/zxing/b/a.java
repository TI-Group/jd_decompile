package com.jd.fridge.widget.zxing.b;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

/* compiled from: TbsSdkJava */
public class a {
    MultiFormatReader a = new MultiFormatReader();

    public a(Context context) {
        Map hashtable = new Hashtable(2);
        Object vector = new Vector();
        if (vector == null || vector.isEmpty()) {
            vector = new Vector();
            vector.addAll(c.c);
            vector.addAll(c.d);
            vector.addAll(c.e);
        }
        hashtable.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF8");
        this.a.setHints(hashtable);
    }

    public Result a(Bitmap bitmap) {
        Result result = null;
        if (bitmap != null) {
            try {
                result = this.a.decodeWithState(new BinaryBitmap(new HybridBinarizer(new b(bitmap))));
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
