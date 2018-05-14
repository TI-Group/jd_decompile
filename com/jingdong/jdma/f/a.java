package com.jingdong.jdma.f;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.h.b;
import com.jingdong.jdma.h.c;
import com.jingdong.jdma.minterface.MaInitCommonInfo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: TbsSdkJava */
public class a {
    private static a a;
    private Context b;
    private ThreadPoolExecutor c;
    private c d;
    private MaInitCommonInfo e;
    private boolean f = false;

    private a(Context context) {
        this.b = context;
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                    a.b();
                }
            }
        }
        return a;
    }

    private void b() {
        this.c = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(20));
        this.d = b.a(0, this.b, c.a(CommonUtil.STATISTIC_DEFULT_WIFI_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_WIFI_REPORT_SIZE.longValue(), CommonUtil.STATISTIC_DEFULT_4G_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_4G_SIZE.longValue(), CommonUtil.STATISTIC_DEFULT_3G_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_3G_SIZE.longValue(), CommonUtil.STATISTIC_DEFULT_2G_INTER.longValue(), CommonUtil.STATISTIC_DEFULT_2G_SIZE.longValue(), 1, 30, CommonUtil.STATISTIC_DEFULT_VERSION, CommonUtil.STATISTIC_DEFULT_CYC.longValue(), CommonUtil.STATISTIC_DEFULT_LOOPBTW.longValue(), CommonUtil.STATISTIC_REPORT_DATA_DEFAULT_DOMAIN));
    }

    public void a(MaInitCommonInfo maInitCommonInfo) {
        this.e = maInitCommonInfo;
    }

    public void a() {
        this.f = true;
    }
}
