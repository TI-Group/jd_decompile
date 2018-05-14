package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache {
    private final Map<Bitmap, Integer> usingCounts = Collections.synchronizedMap(new HashMap());

    public UsingFreqLimitedMemoryCache(int i) {
        super(i);
    }

    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.usingCounts.put(bitmap, Integer.valueOf(0));
        return true;
    }

    public Bitmap get(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            Integer num = (Integer) this.usingCounts.get(bitmap);
            if (num != null) {
                this.usingCounts.put(bitmap, Integer.valueOf(num.intValue() + 1));
            }
        }
        return bitmap;
    }

    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.usingCounts.remove(bitmap);
        }
        return super.remove(str);
    }

    public void clear() {
        this.usingCounts.clear();
        super.clear();
    }

    protected int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    protected Bitmap removeNext() {
        Bitmap bitmap = null;
        Set<Entry> entrySet = this.usingCounts.entrySet();
        synchronized (this.usingCounts) {
            Integer num = null;
            for (Entry entry : entrySet) {
                Bitmap bitmap2;
                Integer num2;
                if (bitmap == null) {
                    bitmap2 = (Bitmap) entry.getKey();
                    num2 = (Integer) entry.getValue();
                } else {
                    Integer num3 = (Integer) entry.getValue();
                    if (num3.intValue() < num.intValue()) {
                        Bitmap bitmap3 = (Bitmap) entry.getKey();
                        num2 = num3;
                        bitmap2 = bitmap3;
                    } else {
                        bitmap2 = bitmap;
                        num2 = num;
                    }
                }
                bitmap = bitmap2;
                num = num2;
            }
        }
        this.usingCounts.remove(bitmap);
        return bitmap;
    }

    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
