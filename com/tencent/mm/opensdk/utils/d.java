package com.tencent.mm.opensdk.utils;

public final class d {
    public static boolean h(String str) {
        return str == null || str.length() <= 0;
    }

    public static int i(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                }
            } catch (Exception e) {
            }
        }
        return i;
    }
}
