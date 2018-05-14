package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: TbsSdkJava */
final class BarcodeValue {
    private final Map<Integer, Integer> values = new HashMap();

    BarcodeValue() {
    }

    void setValue(int i) {
        Integer num = (Integer) this.values.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.values.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    int[] getValue() {
        Collection arrayList = new ArrayList();
        int i = -1;
        for (Entry entry : this.values.entrySet()) {
            int i2;
            if (((Integer) entry.getValue()).intValue() > i) {
                i = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
                i2 = i;
            } else {
                if (((Integer) entry.getValue()).intValue() == i) {
                    arrayList.add(entry.getKey());
                }
                i2 = i;
            }
            i = i2;
        }
        return PDF417Common.toIntArray(arrayList);
    }

    public Integer getConfidence(int i) {
        return (Integer) this.values.get(Integer.valueOf(i));
    }
}
