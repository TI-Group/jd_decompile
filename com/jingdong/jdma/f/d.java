package com.jingdong.jdma.f;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.minterface.MaInitCommonInfo;

/* compiled from: TbsSdkJava */
public class d extends c {
    public static String l = d.class.getName();

    public d(Context context, MaInitCommonInfo maInitCommonInfo, String str, b bVar) {
        super(context, maInitCommonInfo, str, bVar);
    }

    public void run() {
        CommonUtil.commonUtilLog(l, "run,[stopThreadFlag" + this.c + "]");
        while (!this.c) {
            a(true);
        }
    }

    public void c() {
        this.e = CommonUtil.STATISTIC_TABLE_NAME;
        this.f = 0;
        this.g = CommonUtil.STATISTIC_REPORT_DATA_ADDRESS_SUFFIX;
    }
}
