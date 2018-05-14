package com.jingdong.jdma.f;

import android.content.Context;
import com.jingdong.jdma.a.a;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.common.utils.d;
import com.jingdong.jdma.d.e;
import com.jingdong.jdma.h.b;
import com.jingdong.jdma.minterface.DomainInterface;
import com.jingdong.jdma.minterface.MaInitCommonInfo;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public abstract class c implements Runnable {
    private static boolean l = false;
    private static boolean n = false;
    protected final String a = c.class.getSimpleName();
    protected final a b;
    protected volatile boolean c = false;
    protected com.jingdong.jdma.d.c d;
    protected String e = "";
    protected int f;
    protected String g = "";
    protected int h = 10000;
    protected Context i;
    protected com.jingdong.jdma.h.c j;
    protected String k = "";
    private boolean m = false;
    private String o = "";
    private long p = 0;
    private long q = 0;
    private b r = null;

    public abstract void c();

    public c(Context context, MaInitCommonInfo maInitCommonInfo, String str, b bVar) {
        c();
        this.i = context.getApplicationContext();
        if (this.i == null) {
            this.i = context;
        }
        this.b = a.a(context);
        this.d = com.jingdong.jdma.d.c.a(context, maInitCommonInfo);
        this.r = bVar;
        this.j = b.a(this.f, context, str);
        this.k = maInitCommonInfo.site_id;
    }

    public void a() {
        this.c = true;
    }

    public void a(boolean z) {
        switch (b(z)) {
            case -3:
                if (this.r != null) {
                    this.r.a(this.f, this.o, this.p);
                    break;
                }
                break;
            case -1:
                if (this.r != null) {
                    this.r.a(this.f, "", -1);
                    break;
                }
                break;
            case 0:
                if (this.r != null) {
                    this.r.a(this.f, this.p);
                    break;
                }
                break;
        }
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected int b(boolean z) {
        if (this.j == null || !this.j.a()) {
            return -2;
        }
        Long valueOf = Long.valueOf(this.j.b(d.b(this.i)));
        CommonUtil.commonUtilLog(this.a, "reportDemonMain[count" + valueOf + "]");
        if (0 == valueOf.longValue()) {
            return -2;
        }
        if (d.d(this.i) || !l) {
            String str = "";
            if (this.f == 0) {
                str = CommonUtil.STATISTIC_REPORT_METHOD;
            } else {
                str = "";
            }
            JSONObject a = this.d.a(this.i, this.f);
            DomainInterface a2 = com.jingdong.jdma.b.a.a().a(this.f);
            if ((a2 == null || "".equals(a2.mReportDomain)) && "".equals(this.j.f())) {
                this.o = "illegal domain";
                return -1;
            }
            ArrayList arrayList;
            int i;
            String str2 = "";
            if (!this.j.a && !"".equals(this.j.f())) {
                str2 = CommonUtil.URL_HEADER + this.j.f() + this.g;
            } else if ("".equals(a2.mReportDomain)) {
                str2 = CommonUtil.URL_HEADER + this.j.f() + this.g;
            } else {
                str2 = CommonUtil.URL_HEADER + a2.mReportDomain + this.g;
            }
            ArrayList arrayList2 = new ArrayList();
            long longValue = valueOf.longValue() - ((long) arrayList2.size());
            ArrayList arrayList3 = new ArrayList();
            if (longValue > 0) {
                Collection a3 = this.b.a(this.e, Long.valueOf(longValue));
                arrayList2.addAll(a3);
                arrayList = a3;
            } else {
                arrayList = arrayList3;
            }
            if (arrayList2.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                longValue = -1;
                long j = -1;
                int i2 = 0;
                while (i2 < arrayList2.size()) {
                    try {
                        long parseLong;
                        long parseLong2;
                        e eVar = (e) arrayList2.get(i2);
                        JSONObject jSONObject = new JSONObject(eVar.a());
                        if (i2 == 0) {
                            parseLong = Long.parseLong(eVar.b());
                        } else {
                            parseLong = j;
                        }
                        if (i2 == arrayList2.size() - 1) {
                            parseLong2 = Long.parseLong(eVar.b());
                        } else {
                            parseLong2 = longValue;
                        }
                        jSONArray.put(jSONObject);
                        i2++;
                        longValue = parseLong2;
                        j = parseLong;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        this.o = e.getMessage();
                        return -1;
                    } catch (OutOfMemoryError e2) {
                        str = "";
                        this.o = "outofMemoryErr";
                        return -1;
                    }
                }
                a.put("data", jSONArray);
                String jSONObject2 = a.toString();
                com.jingdong.jdma.c.a aVar = new com.jingdong.jdma.c.a(CommonUtil.POST_TIMEOUT, 10000, 3, CommonUtil.UTF8, CommonUtil.UTF8, true);
                aVar.a(CommonUtil.REQUEST_HEADER, this.k);
                aVar.b(str2);
                CommonUtil.commonUtilLog(CommonUtil.TAG, "reportFromDB:" + jSONObject2);
                if (n) {
                    try {
                        aVar.a(com.jingdong.jdma.common.a.c.a(com.jingdong.jdma.common.a.c.b(jSONObject2.getBytes())));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } else {
                    aVar.a(jSONObject2);
                }
                int a4 = aVar.a();
                CommonUtil.commonUtilLog(CommonUtil.TAG, "http report result:" + a4);
                if (a4 == 0) {
                    try {
                        if (new JSONObject(new String(aVar.f(), CommonUtil.UTF8)).optString("c", "").equals("0")) {
                            this.p = (long) this.b.a(this.e, arrayList, j, longValue);
                            i = 0;
                        } else {
                            this.o = "";
                            return -1;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        this.o = e4.getMessage();
                        i = -1;
                    }
                } else {
                    str = "";
                    if (!(!z || a4 == -1 || a4 == 1 || a4 == 502)) {
                        str = "http post fail,sendRet:" + a4;
                    }
                    if (a4 == 1) {
                        this.p = (long) this.b.a(this.e, arrayList, j, longValue);
                    }
                    this.o = str;
                    i = -3;
                }
            } else {
                i = -2;
            }
            if (((long) arrayList.size()) < valueOf.longValue() && this.r != null) {
                this.r.a(this.f);
            }
            return i;
        }
        this.o = "";
        return -1;
    }

    public static void b() {
        n = true;
    }
}
