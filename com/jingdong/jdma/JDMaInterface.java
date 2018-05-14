package com.jingdong.jdma;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.common.utils.c;
import com.jingdong.jdma.common.utils.d;
import com.jingdong.jdma.d.f;
import com.jingdong.jdma.e.a;
import com.jingdong.jdma.minterface.ClickInterfaceParam;
import com.jingdong.jdma.minterface.CustomInterfaceParam;
import com.jingdong.jdma.minterface.MaInitCommonInfo;
import com.jingdong.jdma.minterface.OrderInterfaceParam;
import com.jingdong.jdma.minterface.PropertyInterfaceParam;
import com.jingdong.jdma.minterface.PvInterfaceParam;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class JDMaInterface {
    private static String CURREN_APP = "";
    public static final double PV_UPPERLIMIT = Math.pow(10.0d, 11.0d);
    public static final int RECORD_TYPE_STATIS = 0;
    public static final String SERVER_TYPE_CUSTOM = "ce";
    public static final String SERVER_TYPE_ORDER = "od";
    public static final String SERVER_TYPE_PROPERTY = "pf";
    public static final String UNION_TYPE_CLICK = "cl";
    public static final String UNION_TYPE_PV = "pv";
    public static final String UNION_TYPE_SERVER = "sr";
    private static long bigdata_open_count;
    private static long bigdata_seq;
    private static long first_session_time;
    public static boolean mAcceptProtocol = false;
    private static a mCore;
    private static c maNativeH5Util;
    private static long open_count;
    private static long previous_session_time;
    private static String refPage = "";
    private static long seq;
    private static MaInitCommonInfo smaInitCommonInfo = null;
    private static long visit_create_time;

    public static long getOpen_count() {
        return open_count;
    }

    public static long getSeq() {
        return seq;
    }

    public static long getBigdata_open_count() {
        return bigdata_open_count;
    }

    public static long getBigdata_seq() {
        return bigdata_seq;
    }

    public static synchronized void setMtaContent4OpenApp(Context context, String str) {
        synchronized (JDMaInterface.class) {
            if (context != null) {
                if (maNativeH5Util == null) {
                    maNativeH5Util = c.a(context);
                }
                maNativeH5Util.a(context, str);
            }
        }
    }

    public static synchronized void setMtaContent4Inside(String str) {
        synchronized (JDMaInterface.class) {
            if (maNativeH5Util != null) {
                maNativeH5Util.a(str);
            }
        }
    }

    public static String getSessionInfo(Context context) {
        if (maNativeH5Util == null || smaInitCommonInfo == null || context == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (smaInitCommonInfo == null) {
                return "";
            }
            jSONObject.put("psn", smaInitCommonInfo.getGuid() + "|" + bigdata_open_count);
            jSONObject.put("psq", bigdata_seq);
            jSONObject.put("uid", smaInitCommonInfo.getGuid());
            jSONObject.put("adk", maNativeH5Util.r);
            jSONObject.put("ads", maNativeH5Util.s);
            if (!TextUtils.isEmpty(maNativeH5Util.n)) {
                jSONObject.put("usc", maNativeH5Util.n);
            }
            if (!TextUtils.isEmpty(maNativeH5Util.o)) {
                jSONObject.put("ucp", maNativeH5Util.o);
            }
            if (!TextUtils.isEmpty(maNativeH5Util.p)) {
                jSONObject.put("umd", maNativeH5Util.p);
            }
            if (!TextUtils.isEmpty(maNativeH5Util.q)) {
                jSONObject.put("utr", maNativeH5Util.q);
            }
            jSONObject.put("jdv", maNativeH5Util.h);
            jSONObject.put("unpl", maNativeH5Util.g);
            jSONObject.put("pap", CURREN_APP);
            jSONObject.put("osp", "android");
            jSONObject.put("apv", smaInitCommonInfo.appv);
            jSONObject.put("osv", VERSION.RELEASE);
            jSONObject.put(UNION_TYPE_PV, open_count + "." + seq);
            jSONObject.put("network", d.b(context));
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void incSeq() {
        synchronized (JDMaInterface.class) {
            if (((double) seq) < PV_UPPERLIMIT) {
                seq++;
            } else {
                seq = 1;
            }
            if (((double) bigdata_seq) < PV_UPPERLIMIT) {
                bigdata_seq++;
            } else {
                bigdata_seq = 1;
            }
        }
    }

    public static void setSourceData(String str, String str2, Context context) {
        if (maNativeH5Util != null || context != null) {
            if (maNativeH5Util == null) {
                maNativeH5Util = c.a(context);
            }
            maNativeH5Util.a(str, str2);
        }
    }

    public static synchronized void clearMtaSource() {
        synchronized (JDMaInterface.class) {
            if (maNativeH5Util != null) {
                maNativeH5Util.b = "";
                maNativeH5Util.c = "";
                maNativeH5Util.d = "";
            }
        }
    }

    public static void setSessionInfo(Context context, String str) {
        long j = 0;
        if (!TextUtils.isEmpty(str)) {
            long parseLong;
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("pv_sid")) {
                String optString = jSONObject.optString("pv_sid");
                if (!TextUtils.isEmpty(optString) && isNumeric(optString)) {
                    try {
                        parseLong = Long.parseLong(optString);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            parseLong = 0;
            try {
                if (jSONObject.has("pv_seq")) {
                    String optString2 = jSONObject.optString("pv_seq");
                    if (isNumeric(optString2)) {
                        try {
                            j = Long.parseLong(optString2);
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                if (open_count < parseLong || (open_count == parseLong && seq < j)) {
                    if (open_count < parseLong) {
                        open_count = parseLong;
                        f.a(context).a("open_count", "" + open_count);
                    }
                    seq = j;
                }
                if (jSONObject.has("ref")) {
                    refPage = jSONObject.optString("ref");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    private static synchronized a getCore(Context context, MaInitCommonInfo maInitCommonInfo) throws Throwable {
        a aVar;
        synchronized (JDMaInterface.class) {
            if (context == null) {
                throw new Exception("context is null");
            }
            if (mCore == null) {
                init(context, maInitCommonInfo);
            }
            if (mCore == null) {
                throw new Exception("find some exception when get core..");
            }
            aVar = mCore;
        }
        return aVar;
    }

    public static void init(Context context, MaInitCommonInfo maInitCommonInfo) {
        if (mAcceptProtocol && context != null && mCore == null) {
            try {
                CURREN_APP = maInitCommonInfo.site_id + "|" + maInitCommonInfo.appv + "|" + maInitCommonInfo.app_device + " " + VERSION.RELEASE;
                mCore = a.a(0, context, maInitCommonInfo);
                mCore.a();
                smaInitCommonInfo = maInitCommonInfo;
                initCurrSessionInfo(context);
                maNativeH5Util = c.a(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void initCurrSessionInfo(Context context) {
        if (context != null) {
            seq = 0;
            bigdata_seq = 0;
            f a = f.a(context);
            String a2 = a.a("open_count");
            String a3 = a.a("bigdata_open_count");
            String a4 = a.a("first_session_time");
            String a5 = a.a("previous_session_time");
            String a6 = a.a("visit_create_time");
            if ("".equals(a2) || "".equals(a3) || "".equals(a4) || "".equals(a5) || "".equals(a6)) {
                resetSessionInfo(context);
                return;
            }
            Long parseLongPositive = CommonUtil.parseLongPositive(a2);
            if (((double) parseLongPositive.longValue()) < PV_UPPERLIMIT) {
                open_count = parseLongPositive.longValue() + 1;
            } else {
                open_count = 1;
            }
            parseLongPositive = CommonUtil.parseLongPositive(a3);
            if (((double) parseLongPositive.longValue()) < PV_UPPERLIMIT) {
                bigdata_open_count = parseLongPositive.longValue() + 1;
            } else {
                bigdata_open_count = 1;
            }
            first_session_time = CommonUtil.parseLongPositive(a4).longValue();
            if (0 == first_session_time) {
                first_session_time = System.currentTimeMillis();
            }
            previous_session_time = CommonUtil.parseLongPositive(a6).longValue();
            if (0 == previous_session_time) {
                previous_session_time = System.currentTimeMillis();
            }
            visit_create_time = System.currentTimeMillis();
            Map hashMap = new HashMap();
            hashMap.put("open_count", "" + open_count);
            hashMap.put("bigdata_open_count", "" + bigdata_open_count);
            hashMap.put("first_session_time", "" + first_session_time);
            hashMap.put("previous_session_time", "" + previous_session_time);
            hashMap.put("visit_create_time", "" + visit_create_time);
            a.a(hashMap);
        }
    }

    private static void incBigDataSession(Context context) {
        if (context != null) {
            bigdata_seq = 0;
            f a = f.a(context);
            String a2 = a.a("open_count");
            String a3 = a.a("bigdata_open_count");
            String a4 = a.a("first_session_time");
            String a5 = a.a("previous_session_time");
            String a6 = a.a("visit_create_time");
            if ("".equals(a2) || "".equals(a3) || "".equals(a4) || "".equals(a5) || "".equals(a6)) {
                resetSessionInfo(context);
                return;
            }
            open_count = CommonUtil.parseLongPositive(a2).longValue();
            if (open_count == 0) {
                open_count = 1;
            }
            Long parseLongPositive = CommonUtil.parseLongPositive(a3);
            if (((double) parseLongPositive.longValue()) < PV_UPPERLIMIT) {
                bigdata_open_count = parseLongPositive.longValue() + 1;
            } else {
                bigdata_open_count = 1;
            }
            first_session_time = CommonUtil.parseLongPositive(a4).longValue();
            if (0 == first_session_time) {
                first_session_time = System.currentTimeMillis();
            }
            previous_session_time = CommonUtil.parseLongPositive(a6).longValue();
            if (0 == previous_session_time) {
                previous_session_time = System.currentTimeMillis();
            }
            visit_create_time = System.currentTimeMillis();
            Map hashMap = new HashMap();
            hashMap.put("open_count", "" + open_count);
            hashMap.put("bigdata_open_count", "" + bigdata_open_count);
            hashMap.put("first_session_time", "" + first_session_time);
            hashMap.put("previous_session_time", "" + previous_session_time);
            hashMap.put("visit_create_time", "" + visit_create_time);
            try {
                if (CommonUtil.isMainProcess(context)) {
                    a.a(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void resetSessionInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        open_count = 1;
        bigdata_open_count = 1;
        first_session_time = System.currentTimeMillis();
        previous_session_time = System.currentTimeMillis();
        visit_create_time = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("open_count", "" + open_count);
        hashMap.put("bigdata_open_count", "" + bigdata_open_count);
        hashMap.put("first_session_time", "" + first_session_time);
        hashMap.put("previous_session_time", "" + previous_session_time);
        hashMap.put("visit_create_time", "" + visit_create_time);
        f.a(context).a(hashMap);
    }

    public static boolean sendPvData(Context context, MaInitCommonInfo maInitCommonInfo, PvInterfaceParam pvInterfaceParam) {
        incSeq();
        return sendPvDataNotIncSeq(context, maInitCommonInfo, pvInterfaceParam);
    }

    public static boolean sendPvDataNotIncSeq(Context context, MaInitCommonInfo maInitCommonInfo, PvInterfaceParam pvInterfaceParam) {
        if (context == null || pvInterfaceParam == null) {
            return false;
        }
        if (mCore == null && maInitCommonInfo == null) {
            return false;
        }
        if (mCore == null) {
            try {
                getCore(context, maInitCommonInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mCore == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ref", refPage);
        hashMap.put("rpr", pvInterfaceParam.lastPage_param);
        hashMap.put("ldt", pvInterfaceParam.loadTime);
        hashMap.put("ims", CommonUtil.getIMS(context));
        hashMap.put("imsi", CommonUtil.getIMSI(context));
        hashMap.put("typ", UNION_TYPE_PV);
        hashMap.put("nty", d.b(context));
        hashMap.put("seq", "" + bigdata_seq);
        hashMap.put("vts", "" + bigdata_open_count);
        hashMap.put("pin", com.jingdong.jdma.d.c.a(pvInterfaceParam.pin));
        if (pvInterfaceParam.lat != null) {
            hashMap.put("lat", pvInterfaceParam.lat);
        }
        if (pvInterfaceParam.lon != null) {
            hashMap.put("lon", pvInterfaceParam.lon);
        }
        hashMap.put("fst", "" + first_session_time);
        hashMap.put("pst", "" + previous_session_time);
        hashMap.put("vct", "" + visit_create_time);
        hashMap.put("pv_seq", seq + "");
        hashMap.put("pv_sid", open_count + "");
        hashMap.put("ctm", System.currentTimeMillis() + "");
        hashMap.put("uct", pvInterfaceParam.uct);
        hashMap.put("ctp", pvInterfaceParam.page_name);
        hashMap.put("par", pvInterfaceParam.page_param);
        hashMap.put("page_id", pvInterfaceParam.page_id);
        hashMap.put("sku_tag", pvInterfaceParam.sku_tag);
        hashMap.put("click_url", pvInterfaceParam.click_url);
        hashMap.put("sku", pvInterfaceParam.sku);
        hashMap.put("ord", pvInterfaceParam.ord);
        hashMap.put("shp", pvInterfaceParam.shp);
        hashMap.put("apc", maInitCommonInfo.appc);
        hashMap.put("apv", maInitCommonInfo.appv);
        hashMap.put("bld", maInitCommonInfo.build);
        hashMap.put("jda", maNativeH5Util.i);
        if (maNativeH5Util != null) {
            hashMap.put("jdv", maNativeH5Util.h);
            hashMap.put("unpl", maNativeH5Util.g);
            if (PvInterfaceParam.openAppIsNew || PvInterfaceParam.innerAppisNew || PvInterfaceParam.firstPv) {
                hashMap.put("mba_muid", maNativeH5Util.b);
                hashMap.put("mba_sid", maNativeH5Util.c);
                hashMap.put("jda_ts", maNativeH5Util.j);
                if ((PvInterfaceParam.openAppIsNew || PvInterfaceParam.innerAppisNew) && !"".equals(maNativeH5Util.m)) {
                    hashMap.put("ref", maNativeH5Util.m);
                }
                PvInterfaceParam.openAppIsNew = false;
                PvInterfaceParam.innerAppisNew = false;
                PvInterfaceParam.firstPv = false;
            } else if (PvInterfaceParam.sourceTagIsNew) {
                hashMap.put("sourcetype", maNativeH5Util.e);
                hashMap.put("sourcevalue", maNativeH5Util.f);
                PvInterfaceParam.sourceTagIsNew = false;
            }
            hashMap.put("m_source", maNativeH5Util.d);
            hashMap.put("psn", maNativeH5Util.k);
            hashMap.put("psq", maNativeH5Util.l);
            hashMap.put("usc", maNativeH5Util.n);
            hashMap.put("ucp", maNativeH5Util.o);
            hashMap.put("umd", maNativeH5Util.p);
            hashMap.put("utr", maNativeH5Util.q);
            hashMap.put("adk", maNativeH5Util.r);
            hashMap.put("ads", maNativeH5Util.s);
            hashMap.put("ext", maNativeH5Util.t);
        }
        if (pvInterfaceParam.map != null) {
            for (Entry entry : pvInterfaceParam.map.entrySet()) {
                try {
                    hashMap.put(entry.getKey() + "", entry.getValue() + "");
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        mCore.a(hashMap, 0);
        refPage = pvInterfaceParam.page_name;
        return true;
    }

    public static boolean sendPropertyData(Context context, MaInitCommonInfo maInitCommonInfo, PropertyInterfaceParam propertyInterfaceParam) {
        if (context == null || propertyInterfaceParam == null) {
            return false;
        }
        if (mCore == null && maInitCommonInfo == null) {
            return false;
        }
        if (mCore == null) {
            try {
                getCore(context, maInitCommonInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mCore == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lts", "pf");
        hashMap.put("ims", CommonUtil.getIMS(context));
        hashMap.put("imsi", CommonUtil.getIMSI(context));
        hashMap.put("typ", UNION_TYPE_SERVER);
        hashMap.put("nty", d.b(context));
        hashMap.put("seq", "" + seq);
        hashMap.put("vts", "" + open_count);
        hashMap.put("pin", com.jingdong.jdma.d.c.a(propertyInterfaceParam.pin));
        if (propertyInterfaceParam.lon != null) {
            hashMap.put("lon", propertyInterfaceParam.lon);
        }
        if (propertyInterfaceParam.lat != null) {
            hashMap.put("lat", propertyInterfaceParam.lat);
        }
        hashMap.put("ctm", propertyInterfaceParam.page_ts);
        hashMap.put("ctp", propertyInterfaceParam.page_name);
        hashMap.put("par", propertyInterfaceParam.page_param);
        hashMap.put("end_ts", propertyInterfaceParam.end_ts);
        hashMap.put("pic_ts", propertyInterfaceParam.pic_ts);
        hashMap.put("pic_url", propertyInterfaceParam.pic_url);
        hashMap.put("pic_endts", propertyInterfaceParam.pic_endts);
        hashMap.put("pic_size", propertyInterfaceParam.pic_size);
        hashMap.put("cdn_ip", propertyInterfaceParam.cdn_ip);
        hashMap.put("ldns_ip", propertyInterfaceParam.ldns_ip);
        hashMap.put("mload_ts", propertyInterfaceParam.mload_ts);
        hashMap.put("mload_endts", propertyInterfaceParam.mload_endts);
        hashMap.put("mload_status", propertyInterfaceParam.mload_status);
        hashMap.put("mload_type", propertyInterfaceParam.mload_type);
        hashMap.put("mload_url", propertyInterfaceParam.mload_url);
        hashMap.put("apc", maInitCommonInfo.appc);
        hashMap.put("apv", maInitCommonInfo.appv);
        hashMap.put("bld", maInitCommonInfo.build);
        if (propertyInterfaceParam.map != null) {
            for (Entry entry : propertyInterfaceParam.map.entrySet()) {
                try {
                    hashMap.put(entry.getKey() + "", entry.getValue() + "");
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        mCore.a(hashMap, 0);
        return true;
    }

    public static boolean sendClickData(Context context, MaInitCommonInfo maInitCommonInfo, ClickInterfaceParam clickInterfaceParam) {
        if (context == null || clickInterfaceParam == null) {
            return false;
        }
        if (mCore == null && maInitCommonInfo == null) {
            return false;
        }
        if (mCore == null) {
            try {
                getCore(context, maInitCommonInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mCore == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ims", CommonUtil.getIMS(context));
        hashMap.put("imsi", CommonUtil.getIMSI(context));
        hashMap.put("typ", UNION_TYPE_CLICK);
        hashMap.put("nty", d.b(context));
        hashMap.put("seq", "" + bigdata_seq);
        hashMap.put("vts", "" + bigdata_open_count);
        hashMap.put("pin", com.jingdong.jdma.d.c.a(clickInterfaceParam.pin));
        if (clickInterfaceParam.lat != null) {
            hashMap.put("lat", clickInterfaceParam.lat);
        }
        if (clickInterfaceParam.lon != null) {
            hashMap.put("lon", clickInterfaceParam.lon);
        }
        hashMap.put("cls", clickInterfaceParam.event_id);
        hashMap.put("clp", clickInterfaceParam.event_param);
        hashMap.put("tar", clickInterfaceParam.next_page_name);
        hashMap.put("pv_seq", "" + seq);
        hashMap.put("pv_sid", "" + open_count);
        hashMap.put("ctm", System.currentTimeMillis() + "");
        hashMap.put("ctp", clickInterfaceParam.page_name);
        hashMap.put("par", clickInterfaceParam.page_param);
        hashMap.put("page_id", clickInterfaceParam.page_id);
        hashMap.put("sku_tag", clickInterfaceParam.sku_tag);
        hashMap.put("sku", clickInterfaceParam.sku);
        hashMap.put("ord", clickInterfaceParam.ord);
        hashMap.put("shp", clickInterfaceParam.shop);
        hashMap.put("event_func", clickInterfaceParam.event_func);
        hashMap.put("apc", maInitCommonInfo.appc);
        hashMap.put("apv", maInitCommonInfo.appv);
        hashMap.put("bld", maInitCommonInfo.build);
        if (maNativeH5Util != null) {
            hashMap.put("jdv", maNativeH5Util.h);
            hashMap.put("unpl", maNativeH5Util.g);
            if (ClickInterfaceParam.firstClick || ClickInterfaceParam.openAppIsNew || ClickInterfaceParam.innerAppisNew) {
                hashMap.put("mba_muid", maNativeH5Util.b);
                hashMap.put("mba_sid", maNativeH5Util.c);
                hashMap.put("m_source", maNativeH5Util.d);
                hashMap.put("jda", maNativeH5Util.i);
                hashMap.put("jda_ts", maNativeH5Util.j);
                ClickInterfaceParam.firstClick = false;
                ClickInterfaceParam.openAppIsNew = false;
                ClickInterfaceParam.innerAppisNew = false;
            } else if (ClickInterfaceParam.sourceTagIsNew) {
                hashMap.put("sourcetype", maNativeH5Util.e);
                hashMap.put("sourcevalue", maNativeH5Util.f);
                ClickInterfaceParam.sourceTagIsNew = false;
            }
        }
        if (clickInterfaceParam.map != null) {
            for (Entry entry : clickInterfaceParam.map.entrySet()) {
                try {
                    hashMap.put(entry.getKey() + "", entry.getValue() + "");
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        mCore.a(hashMap, 0);
        return true;
    }

    public static boolean sendOrderData(Context context, MaInitCommonInfo maInitCommonInfo, OrderInterfaceParam orderInterfaceParam) {
        if (context == null || orderInterfaceParam == null) {
            return false;
        }
        if (mCore == null && maInitCommonInfo == null) {
            return false;
        }
        if (mCore == null) {
            try {
                getCore(context, maInitCommonInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mCore == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lts", SERVER_TYPE_ORDER);
        hashMap.put("ims", CommonUtil.getIMS(context));
        hashMap.put("imsi", CommonUtil.getIMSI(context));
        hashMap.put("nty", d.b(context));
        hashMap.put("typ", UNION_TYPE_SERVER);
        hashMap.put("pin", com.jingdong.jdma.d.c.a(orderInterfaceParam.pin));
        hashMap.put("lat", orderInterfaceParam.lat);
        hashMap.put("lon", orderInterfaceParam.lon);
        hashMap.put("order_ts", orderInterfaceParam.order_ts);
        hashMap.put("cart_ts", orderInterfaceParam.cart_ts);
        hashMap.put("cart_sid", orderInterfaceParam.cart_sid);
        hashMap.put("cart_seq", orderInterfaceParam.cart_seq);
        hashMap.put("cart_jdv", orderInterfaceParam.cart_jdv);
        hashMap.put("lv0_source_id", orderInterfaceParam.lv0_source_id);
        hashMap.put("lv1_event_id", orderInterfaceParam.lv1_event_id);
        hashMap.put("lv1_event_param", orderInterfaceParam.lv1_event_param);
        hashMap.put("lv1_page_name", orderInterfaceParam.lv1_page_name);
        hashMap.put("lv1_page_param", orderInterfaceParam.lv1_page_param);
        hashMap.put("lv2_event_id", orderInterfaceParam.lv2_event_id);
        hashMap.put("lv2_event_param", orderInterfaceParam.lv2_event_param);
        hashMap.put("lv2_page_name", orderInterfaceParam.lv2_page_name);
        hashMap.put("lv2_page_param", orderInterfaceParam.lv2_page_param);
        hashMap.put("lv3_event_id", orderInterfaceParam.lv3_event_id);
        hashMap.put("lv3_event_param", orderInterfaceParam.lv3_event_param);
        hashMap.put("lv3_page_name", orderInterfaceParam.lv3_page_name);
        hashMap.put("lv3_page_param", orderInterfaceParam.lv3_page_param);
        hashMap.put("lv4_event_id", orderInterfaceParam.lv4_event_id);
        hashMap.put("lv4_event_param", orderInterfaceParam.lv4_event_param);
        hashMap.put("lv4_page_name", orderInterfaceParam.lv4_page_name);
        hashMap.put("lv4_page_param", orderInterfaceParam.lv4_page_param);
        hashMap.put("lv5_event_id", orderInterfaceParam.lv5_event_id);
        hashMap.put("lv5_event_param", orderInterfaceParam.lv5_event_param);
        hashMap.put("lv5_page_name", orderInterfaceParam.lv5_page_name);
        hashMap.put("lv5_page_param", orderInterfaceParam.lv5_page_param);
        hashMap.put("sale_ord_id", orderInterfaceParam.sale_ord_id);
        hashMap.put("prod_id", orderInterfaceParam.prod_id);
        hashMap.put("quantity", orderInterfaceParam.quantity);
        hashMap.put("order_total_fee", orderInterfaceParam.order_total_fee);
        hashMap.put("pv_sid", orderInterfaceParam.pv_sid);
        hashMap.put("pv_seq", orderInterfaceParam.pv_seq);
        hashMap.put("vts", "" + bigdata_open_count);
        hashMap.put("seq", "" + bigdata_seq);
        hashMap.put("sku_tag", orderInterfaceParam.sku_tag);
        hashMap.put("ord_type", orderInterfaceParam.ord_type);
        hashMap.put("apc", maInitCommonInfo.appc);
        hashMap.put("apv", maInitCommonInfo.appv);
        hashMap.put("bld", maInitCommonInfo.build);
        hashMap.put("sourcevalue", maNativeH5Util.f);
        hashMap.put("sourcetype", maNativeH5Util.e);
        hashMap.put("mba_muid", maNativeH5Util.b);
        hashMap.put("mba_sid", maNativeH5Util.c);
        hashMap.put("m_source", maNativeH5Util.d);
        hashMap.put("jda", maNativeH5Util.i);
        hashMap.put("jdv", maNativeH5Util.h);
        hashMap.put("unpl", maNativeH5Util.g);
        hashMap.put("jda_ts", maNativeH5Util.j);
        if (orderInterfaceParam.map != null) {
            for (Entry entry : orderInterfaceParam.map.entrySet()) {
                try {
                    hashMap.put(entry.getKey() + "", entry.getValue() + "");
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        mCore.a(hashMap, 0);
        return true;
    }

    public static boolean sendCustomData(Context context, MaInitCommonInfo maInitCommonInfo, CustomInterfaceParam customInterfaceParam) {
        if (context == null || customInterfaceParam == null) {
            return false;
        }
        if (mCore == null && maInitCommonInfo == null) {
            return false;
        }
        if (mCore == null) {
            try {
                getCore(context, maInitCommonInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lts", SERVER_TYPE_CUSTOM);
        hashMap.put("eid", customInterfaceParam.eid);
        hashMap.put("ela", customInterfaceParam.ela);
        hashMap.put("eli", customInterfaceParam.eli);
        hashMap.put("ims", CommonUtil.getIMS(context));
        hashMap.put("imsi", CommonUtil.getIMSI(context));
        hashMap.put("lon", customInterfaceParam.lon);
        hashMap.put("lat", customInterfaceParam.lat);
        hashMap.put("nty", d.b(context));
        hashMap.put("seq", bigdata_seq + "");
        hashMap.put("vts", bigdata_open_count + "");
        hashMap.put("pin", com.jingdong.jdma.d.c.a(customInterfaceParam.pin));
        hashMap.put("typ", UNION_TYPE_SERVER);
        hashMap.put("ctp", customInterfaceParam.ctp);
        hashMap.put("par", customInterfaceParam.par);
        hashMap.put("ctm", System.currentTimeMillis() + "");
        hashMap.put("shp", customInterfaceParam.shp);
        hashMap.put("sku", customInterfaceParam.sku);
        hashMap.put("ord", customInterfaceParam.ord);
        hashMap.put("apc", maInitCommonInfo.appc);
        hashMap.put("apv", maInitCommonInfo.appv);
        hashMap.put("bld", maInitCommonInfo.build);
        if (customInterfaceParam.map != null) {
            for (Entry entry : customInterfaceParam.map.entrySet()) {
                try {
                    hashMap.put(entry.getKey() + "", entry.getValue() + "");
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        mCore.a(hashMap, 0);
        return true;
    }

    public static boolean sendData(Context context, MaInitCommonInfo maInitCommonInfo, HashMap<String, String> hashMap, int i) {
        if (context == null || maInitCommonInfo == null || hashMap == null) {
            return false;
        }
        if (mCore == null) {
            try {
                getCore(context, maInitCommonInfo);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mCore == null) {
            return false;
        }
        if (i == 0) {
            hashMap.put("vts", "" + open_count);
            hashMap.put("mba_muid", maNativeH5Util.b);
            hashMap.put("mba_sid", maNativeH5Util.c);
            if (!"".equals(maNativeH5Util.i)) {
                hashMap.put("jda", maNativeH5Util.i);
            }
            if (!"".equals(maNativeH5Util.h)) {
                hashMap.put("jdv", maNativeH5Util.h);
            }
            if (!"".equals(maNativeH5Util.g)) {
                hashMap.put("unpl", maNativeH5Util.g);
            }
            hashMap.put("sourcetype", maNativeH5Util.e);
            hashMap.put("sourcevalue", maNativeH5Util.f);
            hashMap.put("m_source", maNativeH5Util.d);
            hashMap.put("psn", maNativeH5Util.k);
            hashMap.put("psq", maNativeH5Util.l);
            hashMap.put("ref", maNativeH5Util.m);
            hashMap.put("usc", maNativeH5Util.n);
            hashMap.put("ucp", maNativeH5Util.o);
            hashMap.put("umd", maNativeH5Util.p);
            hashMap.put("utr", maNativeH5Util.q);
            hashMap.put("adk", maNativeH5Util.r);
            hashMap.put("ads", maNativeH5Util.s);
            hashMap.put("ext", maNativeH5Util.t);
        }
        mCore.a(hashMap, i);
        return true;
    }

    public static void destroy() {
        try {
            if (mCore != null) {
                mCore.b();
                mCore = null;
            }
            a.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isNumeric(String str) {
        int length = str.length();
        char charAt;
        do {
            length--;
            if (length >= 0) {
                charAt = str.charAt(length);
                if (charAt < '0') {
                    break;
                }
            } else {
                return true;
            }
        } while (charAt <= '9');
        return false;
    }

    public static void setShowLog(boolean z) {
        CommonUtil.LOGSWITCH = z;
    }

    public static long queryCount(Context context, int i, MaInitCommonInfo maInitCommonInfo) {
        if (mCore == null) {
            if (maInitCommonInfo == null || context == null) {
                return 0;
            }
            init(context, maInitCommonInfo);
        }
        if (mCore != null) {
            return mCore.e(i);
        }
        return 0;
    }

    public static void onResume(Context context) {
        if (mCore != null && mCore.d() && context != null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            incBigDataSession(context);
        }
    }

    public static void onPause() {
        if (mCore != null) {
            mCore.c();
        }
    }

    public static void setDebugMode(boolean z) {
        CommonUtil.LOGSWITCH = z;
    }

    public static String getSourceType() {
        if (maNativeH5Util == null || TextUtils.isEmpty(maNativeH5Util.e)) {
            return "";
        }
        return maNativeH5Util.e;
    }

    public static String getSourceValue() {
        if (maNativeH5Util == null || TextUtils.isEmpty(maNativeH5Util.f)) {
            return "";
        }
        return maNativeH5Util.f;
    }

    @Deprecated
    public static String getEncryptLoginUserName(String str) {
        return com.jingdong.jdma.d.c.a(str);
    }

    public static String getRefPage() {
        return refPage;
    }

    public static String getJdv() {
        if (maNativeH5Util != null) {
            return maNativeH5Util.h;
        }
        c cVar = maNativeH5Util;
        return c.a;
    }

    public static void acceptProtocal(boolean z) {
        mAcceptProtocol = z;
    }
}
