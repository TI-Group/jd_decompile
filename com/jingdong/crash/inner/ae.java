package com.jingdong.crash.inner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ae {
    private static DateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static synchronized String a(Date date) {
        String format;
        synchronized (ae.class) {
            format = a.format(date);
        }
        return format;
    }
}
