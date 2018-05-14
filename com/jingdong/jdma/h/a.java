package com.jingdong.jdma.h;

import com.jingdong.jdma.common.utils.CommonUtil;

/* compiled from: TbsSdkJava */
public abstract class a implements Runnable {
    private String a = "";
    private String b = "";
    private int c;
    private String d = CommonUtil.STATISTIC_DEFULT_VERSION;

    public abstract void a(String str, int i);

    public a(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    public void run() {
        com.jingdong.jdma.c.a aVar = new com.jingdong.jdma.c.a(CommonUtil.POST_TIMEOUT, 10000, 3, CommonUtil.UTF8, CommonUtil.UTF8, true);
        aVar.b(this.a);
        aVar.a("os", (Object) "a");
        aVar.a("item", (Object) this.b);
        aVar.a("v", (Object) this.d);
        if (aVar.a() == 0) {
            String str;
            String str2 = "";
            try {
                str = new String(aVar.f(), CommonUtil.UTF8);
            } catch (Exception e) {
                e.printStackTrace();
                str = str2;
            }
            a(str, this.c);
        }
    }

    public void a(String str) {
        this.d = str;
    }
}
