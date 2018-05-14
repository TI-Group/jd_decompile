package com.kepler.sdk;

import java.util.HashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class am {
    public static String A = ".jd.com;sid=\"\",.jd.hk;sid=\"\",.360buy.com;sid=\"\",.yiyaojd.com;sid=\"\"";
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = false;
    public static String d = "kepler exception";
    public static final Map<String, String> e = new HashMap();
    public static String f = "https://router.jd.com/api";
    public static String g = "https://joauth.jd.com/oauth/authorize?";
    public static String h = "https://kploauth.jd.com/oauth/passport_access_confirm";
    public static String i = "http://kepler.jd.com/oauth/code.do";
    public static String j = "https://kploauth.jd.com/oauth/token?";
    public static String k = "http://plogin.m.jd.com/user/login.action?qbautologin=false";
    public static String[] l = new String[]{"https://plogin.m.jd.com/user/login", "https://plogin.m.jd.com/cgi-bin/m/mlogin", "https://kepler.jd.com/oauth/sdk/do"};
    public static String m = "https://passport.m.jd.com/user/logout.action";
    public static String n = "https://p.m.jd.com/cart/cart.action";
    @Deprecated
    public static String o = "http://kepler.jd.com/category_q/jump?";
    public static String p = "https://home.m.jd.com/newAllOrders/newAllOrders.action";
    public static String q = "https://kepler.jd.com/category_q/n?areaid=";
    public static String r = "https://so.m.jd.com/ware/search.action?keyword=";
    public static String s = "https://so.m.jd.com/category/all.html";
    public static String t = "https://item.m.jd.com/product/SKUID.html";
    public static String u = "https://item.m.jd.com/product";
    @Deprecated
    public static String v = "http://kepler.jd.com/freelogin/view";
    public static String w = "https://mapi.m.jd.com/js/ksdk/getUnpl.js";
    @Deprecated
    public static String x = "https://mapi.m.jd.com/js/ksdk/jdkeplerjsbridge.js";
    public static String y = "https://mapi.m.jd.com/js/ksdk/m.keepalive.js";
    public static String z = "https://mapi.m.jd.com/ksdk/mid-page.html";

    static {
        if (!a) {
            o.a(a);
        }
        e.put("热门分类", "1098");
        e.put("手机", "9987");
        e.put("家用电器", "737");
        e.put("电脑办公", "670");
        e.put("摄影数码", "652");
        e.put("女装服饰", "819");
        e.put("男装服饰", "821");
        e.put("时尚鞋靴", "11729");
        e.put("内衣配件", "980");
        e.put("运动户外", "1318");
        e.put("珠宝饰品", "6144");
        e.put("钟表", "5025");
        e.put("母婴用品", "1319");
        e.put("童装童鞋", "1014");
        e.put("玩具乐器", "6233");
        e.put("护肤美妆", "826");
        e.put("清洁洗护", "1146");
        e.put("皮具箱包", "1017");
        e.put("家居家纺", "1620");
        e.put("生活用品", "1018");
        e.put("食品生鲜", "1019");
        e.put("酒水饮料", "1020");
        e.put("奢品礼品", "977");
        e.put("家具建材", "6855");
        e.put("热卖品牌", "1058");
        e.put("营养保健", "91912");
        e.put("汽车用品", "6728");
        e.put("宠物专区", "6994");
        e.put("图书音像", "833");
        e.put("情趣用品", "1016");
    }
}
