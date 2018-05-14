package com.jingdong.jdma.h;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class b {
    public static Map<Integer, c> a = new HashMap();

    public static synchronized c a(int i, Context context) {
        c cVar;
        synchronized (b.class) {
            if (!a.containsKey(Integer.valueOf(i)) && i == 0) {
                a.put(Integer.valueOf(i), new c(context, CommonUtil.STATISTIC_STRATEGY_KEY));
            }
            cVar = (c) a.get(Integer.valueOf(i));
        }
        return cVar;
    }

    public static synchronized c a(int i, Context context, String str) {
        c cVar;
        synchronized (b.class) {
            if (!a.containsKey(Integer.valueOf(i)) && i == 0) {
                a.put(Integer.valueOf(i), new c(context, CommonUtil.STATISTIC_STRATEGY_KEY, str));
            }
            cVar = (c) a.get(Integer.valueOf(i));
        }
        return cVar;
    }

    public static synchronized c a(int i) {
        c cVar;
        synchronized (b.class) {
            cVar = (c) a.get(Integer.valueOf(i));
        }
        return cVar;
    }

    public static synchronized void a() {
        synchronized (b.class) {
            a.clear();
        }
    }
}
