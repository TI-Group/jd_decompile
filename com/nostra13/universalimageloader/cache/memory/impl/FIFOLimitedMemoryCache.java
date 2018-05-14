package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FIFOLimitedMemoryCache extends LimitedMemoryCache {
    private final List<Bitmap> queue = Collections.synchronizedList(new LinkedList());

    public FIFOLimitedMemoryCache(int i) {
        super(i);
    }

    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.queue.add(bitmap);
        return true;
    }

    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.queue.remove(bitmap);
        }
        return super.remove(str);
    }

    public void clear() {
        this.queue.clear();
        super.clear();
    }

    protected int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    protected Bitmap removeNext() {
        return (Bitmap) this.queue.remove(0);
    }

    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
