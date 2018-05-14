package com.jingdong.jdma.b;

import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.minterface.DomainInterface;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class a {
    public static a a;
    private Map<Integer, DomainInterface> b = new HashMap();

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public a() {
        this.b.put(Integer.valueOf(0), new DomainInterface(CommonUtil.STATISTIC_GET_STRATEGY_DEFAULT_DOMAIN, CommonUtil.STATISTIC_REPORT_DATA_DEFAULT_DOMAIN));
    }

    public DomainInterface a(int i) {
        if (this.b.containsKey(Integer.valueOf(i))) {
            return (DomainInterface) this.b.get(Integer.valueOf(i));
        }
        return null;
    }

    public synchronized void a(int i, DomainInterface domainInterface) {
        if (!("".equals(domainInterface.mReportDomain) || "".equals(domainInterface.mStrategyDomain))) {
            this.b.put(Integer.valueOf(i), domainInterface);
        }
    }

    public static synchronized void b() {
        synchronized (a.class) {
            a.c();
        }
    }

    public void c() {
        this.b.clear();
    }
}
