package com.jd.fridge.util;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: TbsSdkJava */
public class g {
    public static long a() {
        return ((System.currentTimeMillis() / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
    }

    public static Date a(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return (a(str).getTime() - a()) / 86400000;
    }
}
