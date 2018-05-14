package com.kepler.sdk;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import uk.co.chrisjenx.calligraphy.BuildConfig;

/* compiled from: TbsSdkJava */
public class ah {
    public CookieManager a;
    public ai b;
    public Context c;

    public ah(Context context) {
        try {
            this.a = CookieManager.getInstance();
            this.b = new ai();
            this.c = context;
        } catch (Throwable e) {
            l.a(e, "20160321344498");
        }
    }

    private HashMap<String, String> a(HashMap<String, String> hashMap, String str, String str2) {
        try {
            if (!hashMap.containsKey(str2)) {
                hashMap.put(str2, str);
            } else if (str.equals((String) hashMap.get(str2))) {
                hashMap.remove(str2);
            } else {
                hashMap.remove(str2);
                hashMap.put(str2, str);
            }
        } catch (Throwable e) {
            l.a(e, "20160321323498");
        }
        return hashMap;
    }

    private ArrayList<String> a(HashMap<String, String> hashMap, String str, String str2, String str3) {
        if (str != null) {
            try {
                hashMap = a(hashMap, str, "kepler_token");
            } catch (Throwable e) {
                Throwable th = e;
                HashMap<String, String> hashMap2 = hashMap;
                l.a(th, "2016032134343498");
            }
        }
        if (str2 != null) {
            hashMap = a(hashMap, str2, "kepler_appkey");
        }
        if (str3 != null) {
            hashMap = a(hashMap, str3, "kepler_keysecret");
        }
        HashMap a = a(a(a(a(a(a(a(a(hashMap, ar.f(ai.j(al.a()) + "_" + ai.k(al.a())), "kepler_devicemodel"), ar.f("android"), "kepler_os"), ar.f(ai.i(al.a())), "kepler_osversion"), ar.f(ai.g(al.a()) + "_" + ai.h(al.a())), "kepler_appversion"), ar.f(BuildConfig.VERSION_NAME), "kepler_version"), ar.f(this.b.b(al.a())), "kepler_imei"), ar.f(this.b.a(al.a())), "kepler_mac"), "keplerm", "keplerm");
        return a(a);
    }

    public void a(Context context, String str) {
        q qVar = new q("判断维度：cookie操作" + str);
        String c = ar.c(str);
        String o = k.b().o(c);
        if (!aq.b(o)) {
            try {
                ArrayList arrayList;
                Object obj;
                String stringBuffer;
                String stringBuffer2;
                String cookie = this.a.getCookie(c);
                HashMap b = b(cookie);
                if (aq.a(cookie) || !cookie.contains("kepler=kepler")) {
                    arrayList = null;
                    obj = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    String[] split = c.split("\\.");
                    StringBuffer stringBuffer3 = new StringBuffer();
                    int length = split.length;
                    if (length >= 2) {
                        stringBuffer3.append(".").append(split[length - 1]);
                    }
                    for (length -= 2; length >= 0; length--) {
                        stringBuffer = stringBuffer3.insert(0, split[length]).toString();
                        stringBuffer2 = stringBuffer3.insert(0, ".").toString();
                        boolean a = a(stringBuffer);
                        boolean a2 = a(stringBuffer2);
                        p.b("suwg", a + " " + stringBuffer);
                        p.b("suwg", a2 + " " + stringBuffer2);
                        if (a) {
                            arrayList2.add(stringBuffer);
                        }
                        if (a2) {
                            arrayList2.add(stringBuffer2);
                        }
                    }
                    arrayList = arrayList2;
                    obj = 1;
                }
                String str2 = (String) b.get("kepler_token");
                stringBuffer = m.a().b(this.c, "kepler_token");
                stringBuffer2 = ar.f(BuildConfig.VERSION_NAME);
                String str3 = (String) b.get("kepler_version");
                String f = ar.f(ai.g(al.a()) + "_" + ai.h(al.a()));
                c = (String) b.get("kepler_appversion");
                if (stringBuffer.equals(str2) && stringBuffer2.equals(str3) && f.equals(c) && b.containsKey("keplerm")) {
                    qVar.a("已经设置token version kepler");
                    return;
                }
                Object obj2;
                ArrayList a3 = a(new HashMap(), stringBuffer, h.a().f(), h.a().g());
                if (a3 == null || a3.size() <= 0) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 == null && obj == null) {
                    qVar.a("不要设置");
                    return;
                }
                CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
                createInstance.startSync();
                createInstance.sync();
                this.a.setAcceptCookie(true);
                if (obj2 != null) {
                    for (int i = 0; i < a3.size(); i++) {
                        this.a.setCookie(o, (String) a3.get(i));
                    }
                }
                if (obj != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        str3 = (String) it.next();
                        for (String str22 : m.a) {
                            p.b("suwg", "del 00000000" + str3 + " " + str22);
                            this.a.setCookie(str3, str22);
                        }
                    }
                }
                createInstance.sync();
                createInstance.stopSync();
                qVar.a("设置");
            } catch (Throwable e) {
                e.printStackTrace();
                l.a(e, "201603213498224323");
            }
        }
    }

    private boolean a(String str) {
        if (this.a.getCookie(str).contains("kepler=kepler")) {
            return true;
        }
        return false;
    }

    private HashMap<String, String> b(String str) {
        int i = 0;
        HashMap<String, String> hashMap = new HashMap();
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    String[] split = str.split(";");
                    if (split != null) {
                        while (i < split.length) {
                            if (split[i] != null && split[i].indexOf(HttpUtils.EQUAL_SIGN) >= 0) {
                                String substring = split[i].substring(0, split[i].indexOf(HttpUtils.EQUAL_SIGN));
                                String substring2 = split[i].substring(split[i].indexOf(HttpUtils.EQUAL_SIGN) + 1);
                                if (substring != null) {
                                    hashMap.put(substring.trim(), substring2);
                                }
                            }
                            i++;
                        }
                    }
                }
            } catch (Throwable e) {
                l.a(e, "201603213495558");
            }
        }
        return hashMap;
    }

    @Deprecated
    private HashMap<String, String> a(HashMap<String, String> hashMap, String str, String str2, boolean z) {
        try {
            if (hashMap.containsKey(str2)) {
                Object obj = (String) hashMap.get(str2);
                if (!str.equals(obj)) {
                    if (hashMap.containsKey(str2)) {
                        hashMap.remove(str2);
                    }
                    if (!z) {
                        String str3 = str;
                    }
                    hashMap.put(str2, obj);
                }
            } else {
                hashMap.put(str2, str);
            }
        } catch (Throwable e) {
            l.a(e, "20160321433498");
        }
        return hashMap;
    }

    private ArrayList<String> a(HashMap<String, String> hashMap) {
        ArrayList<String> arrayList = new ArrayList();
        try {
            for (Entry entry : hashMap.entrySet()) {
                String obj;
                StringBuilder stringBuilder = new StringBuilder();
                String obj2 = entry.getKey().toString();
                String str = "";
                if (entry.getValue() != null) {
                    obj = entry.getValue().toString();
                } else {
                    obj = str;
                }
                stringBuilder.append(obj2);
                stringBuilder.append(HttpUtils.EQUAL_SIGN);
                stringBuilder.append(obj);
                arrayList.add(stringBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Deprecated
    private ArrayList<String> a(String str, String str2, String str3, String str4) {
        HashMap hashMap;
        HashMap b = b(str);
        if (str2 != null) {
            try {
                b = a(b, str2, "kepler_token", false);
            } catch (Throwable e) {
                Throwable th = e;
                hashMap = b;
                l.a(th, "201603213498");
            }
        }
        if (str3 != null) {
            b = a(b, str3, "kepler_appkey", false);
        }
        if (str4 != null) {
            b = a(b, str4, "kepler_keysecret", false);
        }
        hashMap = a(a(a(a(a(a(a(b, ar.f(ai.j(al.a()) + "_" + ai.k(al.a())), "kepler_devicemodel", false), ar.f("android"), "kepler_os", false), ar.f(ai.i(al.a())), "kepler_osversion", false), ar.f(ai.g(al.a()) + "_" + ai.h(al.a())), "kepler_appversion", false), ar.f(BuildConfig.VERSION_NAME), "kepler_version", false), ar.f(this.b.b(al.a())), "kepler_imei", false), ar.f(this.b.a(al.a())), "kepler_mac", false);
        return a(hashMap);
    }

    public String a() {
        ArrayList a = a(null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    public List<String> a(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            p.a("suwg", "cookie list is null");
            return null;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
        createInstance.startSync();
        createInstance.sync();
        this.a.setAcceptCookie(true);
        List<String> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String trim = ((String) list.get(i)).trim();
            String[] split = trim.split(";");
            if (split.length >= 2) {
                String str = split[0];
                String str2 = "";
                for (String trim2 : split) {
                    String trim22 = trim22.trim();
                    if (trim22.startsWith("DOMAIN=") || trim22.startsWith("domian=")) {
                        str2 = trim22.replace("DOMAIN=", "").replace("domian=", "");
                        arrayList.add(str2 + ";" + str.split(HttpUtils.EQUAL_SIGN)[0] + "=\"\"");
                        p.a("suwg", "setcookie:" + trim);
                        this.a.setCookie(str2, str);
                        break;
                    }
                }
            }
        }
        createInstance.sync();
        createInstance.stopSync();
        return arrayList;
    }

    public void a(Context context, boolean z) {
        List a = ap.a(context, "Kepler_sdk_delete_cookies");
        if (a == null) {
            a = new ArrayList();
        }
        String[] i = k.b().i();
        if (i != null) {
            for (Object add : i) {
                r0.add(add);
            }
        }
        if (r0.size() != 0) {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            createInstance.startSync();
            createInstance.sync();
            this.a.setAcceptCookie(true);
            for (String split : r0) {
                String[] split2 = split.split(";");
                if (split2.length == 2) {
                    this.a.setCookie(split2[0], split2[1]);
                }
            }
            if (!z) {
                this.a.removeSessionCookie();
            }
            createInstance.sync();
            createInstance.stopSync();
        }
    }
}
