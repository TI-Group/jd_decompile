package com.ogaclejapan.smarttablayout.utils.v4;

import android.content.Context;
import android.support.v4.app.Fragment;

/* compiled from: TbsSdkJava */
public class b extends com.ogaclejapan.smarttablayout.utils.b<a> {

    /* compiled from: TbsSdkJava */
    public static class a {
        private final b a;

        public a(Context context) {
            this.a = new b(context);
        }

        public a a(CharSequence charSequence, Class<? extends Fragment> cls) {
            return a(a.a(charSequence, (Class) cls));
        }

        public a a(a aVar) {
            this.a.add(aVar);
            return this;
        }

        public b a() {
            return this.a;
        }
    }

    public b(Context context) {
        super(context);
    }

    public static a with(Context context) {
        return new a(context);
    }
}
