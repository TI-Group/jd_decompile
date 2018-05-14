package com.ogaclejapan.smarttablayout.utils;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: TbsSdkJava */
public abstract class b<T extends a> extends ArrayList<T> {
    private final Context context;

    protected b(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }
}
