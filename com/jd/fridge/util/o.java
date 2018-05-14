package com.jd.fridge.util;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* compiled from: TbsSdkJava */
public class o {
    public static void a(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
    }

    public static void b(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public static void c(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void d(EditText editText) {
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 2);
    }
}
