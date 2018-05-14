package com.ogaclejapan.smarttablayout.utils.v4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/* compiled from: TbsSdkJava */
public class a extends com.ogaclejapan.smarttablayout.utils.a {
    private final String a;
    private final Bundle b;

    protected a(CharSequence charSequence, float f, String str, Bundle bundle) {
        super(charSequence, f);
        this.a = str;
        this.b = bundle;
    }

    public static a a(CharSequence charSequence, Class<? extends Fragment> cls) {
        return a(charSequence, 1.0f, cls);
    }

    public static a a(CharSequence charSequence, float f, Class<? extends Fragment> cls) {
        return a(charSequence, f, cls, new Bundle());
    }

    public static a a(CharSequence charSequence, float f, Class<? extends Fragment> cls, Bundle bundle) {
        return new a(charSequence, f, cls.getName(), bundle);
    }

    static void a(Bundle bundle, int i) {
        bundle.putInt("FragmentPagerItem:Position", i);
    }

    public Fragment a(Context context, int i) {
        a(this.b, i);
        return Fragment.instantiate(context, this.a, this.b);
    }
}
