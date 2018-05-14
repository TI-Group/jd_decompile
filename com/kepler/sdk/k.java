package com.kepler.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import com.kepler.jd.sdk.bean.KeplerGlobalParameter;
import com.tencent.open.SocialConstants;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
import uk.co.chrisjenx.calligraphy.BuildConfig;

@SuppressLint({"DefaultLocale"})
/* compiled from: TbsSdkJava */
public class k {
    private List<String> A;
    private String[] B;
    private String[] C;
    private String[] D;
    private ArrayList<s> E;
    public int a;
    public boolean b;
    public boolean c;
    boolean d;
    HashSet<String> e;
    String[] f;
    HashSet<String> g;
    public String h;
    public String i;
    public String j;
    private LinkedHashMap<String, ArrayList<String>> k;
    private LinkedHashMap<String, ArrayList<String>> l;
    private LinkedHashMap<String, String> m;
    private String n;
    private String[] o;
    private String[] p;
    private String[] q;
    private Map<String, String[]> r;
    private long s;
    private ArrayList<String> t;
    private LinkedHashMap<String[], String> u;
    private LinkedHashMap<String, b> v;
    private LinkedHashMap<String, HashMap<String, String>> w;
    private LinkedHashMap<String, String[]> x;
    private HashMap<String, String> y;
    private HashMap<String, String> z;

    /* compiled from: TbsSdkJava */
    static class a {
        private static final k a = new k();
    }

    /* compiled from: TbsSdkJava */
    public static class b {
        public String a;
        public String b;
        public boolean c;

        public b(String str, boolean z, String str2) {
            this.a = str;
            this.c = z;
            this.b = str2;
        }
    }

    public boolean a(String str) {
        try {
            if (aq.a(str)) {
                return true;
            }
            boolean z;
            if (this.p.length == 0) {
                z = true;
            } else {
                for (String b : this.p) {
                    if (b(str, b)) {
                        z = true;
                        break;
                    }
                }
                z = false;
            }
            if (!z) {
                return true;
            }
            for (String b2 : this.q) {
                if (b(str, b2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            p.a(e);
            l.a(e.getMessage(), "201710191615");
            return true;
        }
    }

    public String a() {
        return am.i;
    }

    private k() {
        this.k = new LinkedHashMap();
        this.l = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = "";
        this.o = new String[0];
        this.p = new String[0];
        this.q = new String[0];
        this.r = new HashMap();
        this.s = 10;
        this.t = new ArrayList();
        this.u = new LinkedHashMap();
        this.v = new LinkedHashMap();
        this.w = new LinkedHashMap();
        this.x = new LinkedHashMap();
        this.y = new HashMap();
        this.z = new HashMap();
        this.A = new ArrayList();
        this.B = new String[0];
        this.C = new String[0];
        this.D = new String[0];
        this.E = new ArrayList();
        this.e = new HashSet();
        this.g = new HashSet();
    }

    public static final k b() {
        return a.a;
    }

    public void a(final FaceCommonCallBack<Boolean> faceCommonCallBack) {
        final Context applicatonContext = KeplerApiManager.getWebViewService().getApplicatonContext();
        if (applicatonContext != null) {
            if (!(this.d || !a(applicatonContext) || faceCommonCallBack == null)) {
                faceCommonCallBack.callBack(Boolean.valueOf(true));
            }
            if (!this.d || System.currentTimeMillis() - m.a().a(applicatonContext, "time") >= this.s * 1000) {
                Map hashtable = new Hashtable();
                ai aiVar = new ai();
                hashtable.put("kepler_token", m.a().b(al.a(), "kepler_token"));
                hashtable.put("kepler_devicemodel", ar.f(ai.j(al.a()) + "_" + ai.k(al.a())));
                hashtable.put("kepler_os", ar.f("android"));
                hashtable.put("kepler_osversion", ar.f(ai.i(al.a())));
                hashtable.put("kepler_appversion", ar.f(ai.g(al.a()) + "_" + ai.h(al.a())));
                hashtable.put("kepler_version", ar.f(BuildConfig.VERSION_NAME));
                hashtable.put("kepler_imei", ar.f(aiVar.b(al.a())));
                hashtable.put("kepler_mac", ar.f(aiVar.a(al.a())));
                hashtable.put("kepler_appkey", h.a().f());
                hashtable.put("configid", "android_new");
                new aa(new ab("https://kepler.jd.com/console/admin/getConfigNew", hashtable, "get"), "getconfig", 19, new ad(this) {
                    final /* synthetic */ k c;

                    public void a(ac acVar) {
                        try {
                            this.c.a(new JSONObject(acVar.b()));
                            m.a().a(applicatonContext, "time", System.currentTimeMillis());
                            m.a().a(applicatonContext, "configm", acVar.b());
                            if (faceCommonCallBack != null) {
                                faceCommonCallBack.callBack(Boolean.valueOf(true));
                            }
                        } catch (Throwable th) {
                            l.a(th, "2016611348");
                            this.c.a(applicatonContext);
                            if (faceCommonCallBack != null) {
                                faceCommonCallBack.callBack(Boolean.valueOf(false));
                            }
                        }
                    }

                    public void a(int i, String str) {
                        if (faceCommonCallBack != null) {
                            faceCommonCallBack.callBack(Boolean.valueOf(false));
                        }
                    }
                }).c();
            } else if (faceCommonCallBack != null) {
                faceCommonCallBack.callBack(Boolean.valueOf(true));
            }
        } else if (faceCommonCallBack != null) {
            faceCommonCallBack.callBack(Boolean.valueOf(false));
        }
    }

    public boolean a(Context context) {
        try {
            Object b = m.a().b(context, "configm");
            if (!TextUtils.isEmpty(b)) {
                return a(new JSONObject(b));
            }
        } catch (Throwable e) {
            l.a(e, "201606211148");
        }
        return false;
    }

    public String c() {
        return am.p;
    }

    public boolean b(String str) {
        boolean z = false;
        try {
            if (!(this.n == null || "".equals(this.n))) {
                z = str.startsWith(this.n);
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return z;
    }

    public void c(String str) {
        try {
            if (a(this.k, str)) {
                a(b(this.k, str), str);
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
    }

    public boolean d(String str) {
        if (a(this.l, str)) {
            return true;
        }
        return false;
    }

    private void a(ArrayList<String> arrayList, String str) {
        try {
            if (str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) >= 0) {
                String[] split = str.substring(str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) + 1).split(HttpUtils.PARAMETERS_SEPARATOR);
                for (int i = 0; i < split.length; i++) {
                    String substring = split[i].substring(0, split[i].indexOf(HttpUtils.EQUAL_SIGN));
                    Object substring2 = split[i].substring(split[i].indexOf(HttpUtils.EQUAL_SIGN) + 1);
                    if (arrayList.contains(substring)) {
                        if (substring2 == null) {
                            substring2 = "";
                        }
                        this.m.put(substring, substring2);
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
    }

    public String e(String str) {
        int i = 0;
        String str2 = "";
        String str3 = "";
        try {
            Hashtable hashtable = new Hashtable();
            str2 = "";
            ArrayList b = b(this.l, str);
            if (str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) >= 0) {
                String substring = str.substring(0, str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR));
                String[] split = str.substring(str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) + 1).split(HttpUtils.PARAMETERS_SEPARATOR);
                for (int i2 = 0; i2 < split.length; i2++) {
                    String substring2 = split[i2].substring(0, split[i2].indexOf(HttpUtils.EQUAL_SIGN));
                    Object substring3 = split[i2].substring(split[i2].indexOf(HttpUtils.EQUAL_SIGN) + 1);
                    if (b.contains(substring2)) {
                        substring3 = "";
                        if (this.m.containsKey(substring2)) {
                            substring3 = (String) this.m.get(substring2);
                        }
                        b.remove(substring2);
                        if (substring3 == null) {
                            substring3 = "";
                        }
                        hashtable.put(substring2, substring3);
                    } else {
                        if (this.m.containsKey(substring2)) {
                            substring3 = (String) this.m.get(substring2);
                        }
                        if (substring3 == null) {
                            substring3 = "";
                        }
                        hashtable.put(substring2, substring3);
                    }
                }
                str = substring;
            }
            while (i < b.size()) {
                str2 = (String) b.get(i);
                Object obj = "";
                if (this.m.containsKey(str2)) {
                    obj = (String) this.m.get(str2);
                }
                if (obj == null) {
                    obj = "";
                }
                hashtable.put(str2, obj);
                i++;
            }
            return a(str, hashtable);
        } catch (Throwable e) {
            l.a(e, "20165301348");
            return str3;
        }
    }

    public int a(String str, String str2) {
        int i = 0;
        for (String str3 : this.x.keySet()) {
            int length;
            String[] strArr = (String[]) this.x.get(str3);
            if (str.startsWith(str3)) {
                if (strArr == null) {
                    return 1;
                }
                length = strArr.length;
                while (i < length) {
                    if (b(str2, strArr[i])) {
                        return 2;
                    }
                    i++;
                }
                return 1;
            }
        }
        Object[] goBackIgnoredUrl = KeplerGlobalParameter.getSingleton().getGoBackIgnoredUrl();
        if (!aq.a(goBackIgnoredUrl)) {
            for (String startsWith : goBackIgnoredUrl) {
                if (str.startsWith(startsWith)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    private String a(String str, Hashtable<String, String> hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = 1;
        try {
            if (str.contains(HttpUtils.URL_AND_PARA_SEPARATOR)) {
                obj = null;
            }
            stringBuffer.append(str);
            if (hashtable != null) {
                Set<String> keySet = hashtable.keySet();
                if (keySet != null) {
                    Object obj2 = obj;
                    for (String str2 : keySet) {
                        if (obj2 != null) {
                            stringBuffer.append(HttpUtils.URL_AND_PARA_SEPARATOR);
                        } else {
                            stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
                        }
                        stringBuffer.append(str2);
                        stringBuffer.append(HttpUtils.EQUAL_SIGN);
                        stringBuffer.append((String) hashtable.get(str2));
                        obj2 = null;
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return stringBuffer.toString();
    }

    private boolean a(LinkedHashMap<String, ArrayList<String>> linkedHashMap, String str) {
        try {
            Set<String> keySet = linkedHashMap.keySet();
            if (keySet != null) {
                for (String str2 : keySet) {
                    if (!TextUtils.isEmpty(str2)) {
                        ArrayList arrayList = (ArrayList) linkedHashMap.get(str2);
                        if (str.startsWith(str2)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return false;
    }

    private ArrayList<String> b(LinkedHashMap<String, ArrayList<String>> linkedHashMap, String str) {
        try {
            ArrayList<String> arrayList = new ArrayList();
            Set<String> keySet = linkedHashMap.keySet();
            if (keySet != null) {
                for (String str2 : keySet) {
                    if (str.startsWith(str2)) {
                        arrayList.addAll((Collection) linkedHashMap.get(str2));
                        return arrayList;
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return new ArrayList();
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i;
                JSONObject jSONObject2;
                String optString;
                String optString2;
                String[] split;
                ArrayList arrayList;
                int i2;
                int i3;
                JSONObject jSONObject3;
                Object obj;
                String optString3;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                JSONArray optJSONArray = jSONObject.optJSONArray("from");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (i = 0; i < optJSONArray.length(); i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            optString = jSONObject2.optString("url", "");
                            optString2 = jSONObject2.optString("key", "");
                            if (!(optString2 == null || optString == null || "".equals(optString) || "".equals(optString2))) {
                                split = optString2.split(",");
                                if (split != null && split.length > 0) {
                                    arrayList = new ArrayList();
                                    for (Object add : split) {
                                        arrayList.add(add);
                                    }
                                    linkedHashMap.put(optString, arrayList);
                                }
                            }
                        }
                    }
                }
                optJSONArray = jSONObject.optJSONArray("to");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (i = 0; i < optJSONArray.length(); i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            optString = jSONObject2.optString("url", "");
                            optString2 = jSONObject2.optString("key", "");
                            if (!(optString2 == null || optString == null || "".equals(optString) || "".equals(optString2))) {
                                split = optString2.split(",");
                                if (split != null && split.length > 0) {
                                    arrayList = new ArrayList();
                                    for (Object add2 : split) {
                                        arrayList.add(add2);
                                    }
                                    linkedHashMap2.put(optString, arrayList);
                                }
                            }
                        }
                    }
                }
                this.n = jSONObject.optString("payurl", "");
                this.s = jSONObject.optLong("timeout", this.s);
                am.j = jSONObject.optString("tokenurl", am.j);
                am.g = jSONObject.optString("hoauth", am.g);
                am.z = jSONObject.optString("starturl", "");
                am.m = jSONObject.optString("logout_200", am.m);
                JSONArray optJSONArray2 = jSONObject.optJSONArray("loginAuthArray_200");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    am.l = new String[optJSONArray2.length()];
                    for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        am.l[i2] = optJSONArray2.getString(i2);
                    }
                }
                am.t = jSONObject.optString("productItemURL", am.t);
                am.p = jSONObject.optString("orderurl", am.p);
                am.b = jSONObject.optString("isUseStatic_114", "1").equals("1");
                am.c = "1".equals(jSONObject.optString("isUseCatchAbleSendBack_200", "1"));
                if (!o.a.booleanValue()) {
                    o.a = Boolean.valueOf("1".equals(jSONObject.optString("isLog_136", "1")));
                }
                am.i = jSONObject.optString("oauthCodeDoURL", "");
                am.f = jSONObject.optString("url_add2Cart_130", am.f);
                am.o = jSONObject.optString("url_add2CartOpen_130", am.o);
                am.r = jSONObject.optString("url_searchByKey_130", am.r);
                am.q = jSONObject.optString("url_searchCategory_130", am.q);
                am.n = jSONObject.optString("url_cartViewURL_132", am.n);
                am.s = jSONObject.optString("categoryURL", am.s);
                am.v = jSONObject.optString("url_feeLogin_134", am.v);
                am.h = jSONObject.optString("accessConfirmURL", "");
                am.w = jSONObject.optString("UNPLjsURL_134", am.w);
                am.y = jSONObject.optString("SessionjsURL_134", am.y);
                am.x = jSONObject.optString("UNPLjdkeplerjsbridgejs", am.y);
                this.b = true;
                optString2 = jSONObject.optString("isUNPLjs_134", "1");
                if (!aq.a(optString2)) {
                    this.b = "1".equals(optString2);
                }
                this.c = true;
                if (!aq.a(jSONObject.optString("isAppOpen_201", "1"))) {
                    this.c = "1".equals(optString2);
                }
                this.a = jSONObject.optInt("UNPLjsLastTime_134", 10);
                this.h = jSONObject.optString("menu_search_url", "");
                this.i = jSONObject.optString("menu_recent_url", "");
                this.j = jSONObject.optString("menu_message_url", "");
                optString2 = jSONObject.optString("blackUrl_130", "");
                if (!(optString2 == null || "".equals(optString2))) {
                    this.o = optString2.split(",");
                }
                optString2 = jSONObject.optString("openJDAppWhiteList_200", "");
                if (!(optString2 == null || "".equals(optString2))) {
                    this.p = optString2.split(",");
                }
                optString2 = jSONObject.optString("openJDAppBlackList_200", "");
                if (!(optString2 == null || "".equals(optString2))) {
                    this.q = optString2.split(",");
                }
                optString2 = jSONObject.optString("select_more_keys_134", "");
                if (!aq.b(optString2)) {
                    this.f = optString2.split(",");
                }
                optString2 = jSONObject.optString("black_key_exs", "");
                if (!aq.b(optString2)) {
                    String[] split2 = optString2.split(",");
                    if (split2 != null && split2.length > 0) {
                        this.e.clear();
                        for (Object add3 : split2) {
                            this.e.add(add3);
                        }
                    }
                }
                optString2 = jSONObject.optString("loginout_clear_url_cookie", "");
                if (!aq.b(optString2)) {
                    this.C = optString2.split(",");
                }
                String optString4 = jSONObject.optString("cookies_domain", "jd.com,yiyaojd.com,360buy.com,jd.hk");
                if (!aq.b(optString2)) {
                    this.D = optString4.split(",");
                }
                this.r.clear();
                optJSONArray2 = jSONObject.getJSONArray("addparmer_132");
                if (optJSONArray2 != null) {
                    for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        jSONObject3 = optJSONArray2.getJSONObject(i2);
                        optString = jSONObject3.optString("key", "");
                        String optString5 = jSONObject3.optString("urls", "");
                        if (!(aq.b(optString) || aq.b(optString5))) {
                            this.r.put(optString, optString5.split(","));
                        }
                    }
                }
                optString2 = jSONObject.optString("androidNoCheckUrls", "");
                if (!aq.b(optString2)) {
                    this.B = optString2.split(",");
                }
                optJSONArray2 = jSONObject.getJSONArray("getskuurl");
                if (optJSONArray2 != null) {
                    for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        jSONObject3 = optJSONArray2.getJSONObject(i2);
                        this.y.put(jSONObject3.optString("url", ""), jSONObject3.optString("param", ""));
                        this.z.put(jSONObject3.optString("url", ""), jSONObject3.optString(SocialConstants.PARAM_TYPE, ""));
                    }
                }
                optJSONArray2 = jSONObject.getJSONArray("get_url_name");
                if (optJSONArray2 != null) {
                    this.E.clear();
                    for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        jSONObject3 = optJSONArray2.getJSONObject(i2);
                        this.E.add(new s(jSONObject3.optString("show_name", ""), jSONObject3.optInt(SocialConstants.PARAM_TYPE, 0), jSONObject3.optString("url", "")));
                    }
                }
                JSONArray jSONArray = jSONObject.getJSONArray("jump_114");
                if (jSONArray != null) {
                    this.v.clear();
                    this.w.clear();
                    for (i3 = 0; i3 < jSONArray.length(); i3++) {
                        jSONObject2 = jSONArray.getJSONObject(i3);
                        CharSequence optString6 = jSONObject2.optString("fromRule_132", "");
                        this.v.put(optString6, new b(jSONObject2.optString("to", ""), "1".equals(jSONObject2.optString("isNeedParam", "")), jSONObject2.optString("encode", null)));
                        JSONArray optJSONArray3 = jSONObject2.optJSONArray("replaceList");
                        obj = null;
                        if (optJSONArray3 != null) {
                            obj = new HashMap();
                            for (i = 0; i < optJSONArray3.length(); i++) {
                                obj.put(optJSONArray3.getJSONObject(i).optString("replace"), optJSONArray3.getJSONObject(i).optString("to"));
                            }
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            this.w.put(optString6, obj);
                        }
                    }
                }
                optJSONArray = jSONObject.getJSONArray("jumpurl");
                if (optJSONArray != null) {
                    this.x.clear();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                        optString3 = jSONObject4.optString("current_nobacks_132");
                        obj = null;
                        if (!aq.b(optString3)) {
                            obj = optString3.split(",");
                        }
                        this.x.put(jSONObject4.optString("url"), obj);
                    }
                }
                optJSONArray = jSONObject.getJSONArray("insertjs");
                if (optJSONArray != null) {
                    this.u.clear();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        jSONObject2 = optJSONArray.getJSONObject(i);
                        optString = jSONObject2.optString("url", "");
                        optString3 = jSONObject2.optString("js", "");
                        obj = new String[0];
                        if (!(optString == null || "".equals(optString))) {
                            obj = optString.split(",");
                        }
                        this.u.put(obj, optString3);
                    }
                }
                optJSONArray2 = jSONObject.getJSONArray("hideCloseBtn_114");
                this.A.clear();
                if (!(optJSONArray2 == null || this.A == null)) {
                    for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.A.add(optJSONArray2.getJSONObject(i2).optString("url"));
                    }
                }
                this.A.add(this.n);
                this.k = linkedHashMap;
                this.l = linkedHashMap2;
                this.d = true;
            } catch (Throwable th) {
                p.a(th, "kepler config load ");
                l.a("kepler config load" + th.getMessage(), "201710191610");
                return false;
            }
        }
        return true;
    }

    public String f(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : this.r.keySet()) {
                String[] strArr = (String[]) this.r.get(str2);
                if (strArr != null && strArr.length > 0) {
                    String str3 = str;
                    for (String b : strArr) {
                        if (b(str3, b)) {
                            if (str3.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) > 0) {
                                Object obj = HttpUtils.PARAMETERS_SEPARATOR + str2;
                                if (!str3.contains(obj)) {
                                    str3 = str3 + obj;
                                }
                            } else {
                                str3 = str3 + HttpUtils.URL_AND_PARA_SEPARATOR + str2;
                            }
                        }
                    }
                    str = str3;
                }
            }
        }
        return str;
    }

    public ArrayList<String> g(String str) {
        ArrayList<String> arrayList = new ArrayList();
        try {
            Set<String[]> keySet = this.u.keySet();
            if (keySet != null) {
                for (String[] strArr : keySet) {
                    if (strArr != null && strArr.length > 0) {
                        int i = 0;
                        while (i < strArr.length) {
                            if (!TextUtils.isEmpty(str) && b(str, strArr[i])) {
                                arrayList.add(this.u.get(strArr));
                            }
                            i++;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return arrayList;
    }

    public String h(String str) {
        try {
            Set<String> keySet = this.v.keySet();
            if (keySet != null) {
                for (String str2 : keySet) {
                    String str22;
                    if (!TextUtils.isEmpty(str22) && b(str, str22)) {
                        b bVar = (b) this.v.get(str22);
                        HashMap hashMap = (HashMap) this.w.get(str22);
                        if (hashMap != null && hashMap.size() != 0) {
                            str22 = a(hashMap, str);
                            if (TextUtils.isEmpty(bVar.b)) {
                                return bVar.a + str22;
                            }
                            return bVar.a + URLEncoder.encode(str22, bVar.b);
                        } else if (!bVar.c || str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) < 0) {
                            return bVar.a;
                        } else {
                            return bVar.a + HttpUtils.URL_AND_PARA_SEPARATOR + str.substring(str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) + 1);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return str;
    }

    public String a(HashMap<String, String> hashMap, String str) {
        String str2;
        Throwable e;
        try {
            Set<String> keySet = hashMap.keySet();
            if (keySet == null) {
                return str;
            }
            str2 = str;
            for (String str3 : keySet) {
                try {
                    String str32;
                    if (TextUtils.isEmpty(str32)) {
                        str32 = str2;
                    } else {
                        str32 = str2.replace(str32, (String) hashMap.get(str32));
                    }
                    str2 = str32;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return str2;
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            l.a(e, "20165301348");
            return str2;
        }
    }

    public boolean i(String str) {
        try {
            if (this.o != null && this.o.length > 0) {
                int i = 0;
                while (i < this.o.length) {
                    if (!TextUtils.isEmpty(str) && b(str, this.o[i])) {
                        return false;
                    }
                    i++;
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return true;
    }

    public boolean b(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public int j(String str) {
        try {
            Set<String> keySet = this.y.keySet();
            if (keySet != null) {
                for (String str2 : keySet) {
                    String str22;
                    if (!TextUtils.isEmpty(str22) && str.startsWith(str22)) {
                        str22 = (String) this.z.get(str22);
                        if (TextUtils.isEmpty(str22) || !"1".equals(str22)) {
                            return 2;
                        }
                        return 1;
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return 0;
    }

    public String k(String str) {
        String str2;
        Object obj = "";
        Set<String> keySet = this.y.keySet();
        if (keySet != null) {
            for (String str22 : keySet) {
                if (!TextUtils.isEmpty(str22) && str.startsWith(str22)) {
                    obj = (String) this.y.get(str22);
                    break;
                }
            }
        }
        try {
            str22 = "";
            Map a = ar.a(URLDecoder.decode(str, CommonUtil.UTF8));
            if (str.startsWith("openapp.jdmobile") && a.containsKey(obj)) {
                str22 = ar.b((String) a.get(obj));
            }
            if ((str22 == null || "".equals(str22)) && a.containsKey(obj)) {
                str22 = (String) a.get(obj);
            }
            if (str22 != null && !"".equals(str22)) {
                return str22;
            }
            String substring;
            if (str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) >= 0) {
                substring = str.substring(0, str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR));
            } else {
                substring = str;
            }
            if (substring.indexOf(HttpUtils.PATHS_SEPARATOR) < 0) {
                return str22;
            }
            substring = str.substring(substring.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1);
            if (substring.indexOf(".") < 0) {
                return str22;
            }
            str22 = substring.substring(0, substring.indexOf("."));
            if (b(str22, "[0-9]*")) {
                return str22;
            }
            return "";
        } catch (Throwable e) {
            l.a(e, "20165301348");
            return "";
        }
    }

    public boolean l(String str) {
        try {
            if (this.B == null || this.B.length <= 0) {
                return false;
            }
            int i = 0;
            while (i < this.B.length) {
                if (!TextUtils.isEmpty(str) && b(str, this.B[i])) {
                    return true;
                }
                i++;
            }
            return false;
        } catch (Throwable e) {
            l.a(e, "2016530134845");
            return false;
        }
    }

    public String m(String str) {
        try {
            if (str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) > 0) {
                return str.substring(str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) + 1);
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return "";
    }

    public boolean n(String str) {
        if (str == null || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            return false;
        }
        if (this.A != null) {
            for (String str2 : this.A) {
                if (str2 != null && str.startsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public long d() {
        return this.s;
    }

    public String e() {
        return am.n;
    }

    public String f() {
        return am.s;
    }

    public String[] g() {
        return this.f;
    }

    public String h() {
        return am.v;
    }

    public String[] i() {
        return this.C;
    }

    public String o(String str) {
        if (aq.b(str) || aq.a(this.D)) {
            return null;
        }
        for (String str2 : this.D) {
            if (str.endsWith(str2)) {
                return "." + str2;
            }
        }
        return null;
    }
}
