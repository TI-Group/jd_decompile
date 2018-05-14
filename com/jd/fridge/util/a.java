package com.jd.fridge.util;

import android.support.v7.app.AppCompatActivity;
import java.util.Iterator;
import java.util.Stack;

/* compiled from: TbsSdkJava */
public class a {
    private static a b;
    private Stack<AppCompatActivity> a;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void a(AppCompatActivity appCompatActivity) {
        if (this.a == null) {
            this.a = new Stack();
        }
        this.a.add(appCompatActivity);
    }

    public void b(AppCompatActivity appCompatActivity) {
        if (appCompatActivity != null) {
            this.a.remove(appCompatActivity);
            appCompatActivity.finish();
        }
    }

    public void b() {
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) it.next();
                if (appCompatActivity != null) {
                    appCompatActivity.finish();
                }
            }
        }
    }
}
