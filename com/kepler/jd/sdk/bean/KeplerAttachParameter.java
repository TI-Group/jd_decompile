package com.kepler.jd.sdk.bean;

import cn.jiguang.net.HttpUtils;
import com.kepler.jd.sdk.exception.KeplerAttachException;
import com.kepler.jd.sdk.exception.KeplerBufferOverflowException;
import com.kepler.sdk.aq;
import com.kepler.sdk.ar;
import com.kepler.sdk.p;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class KeplerAttachParameter implements Serializable {
    private HashMap<String, String> mapAttachParameter = new HashMap();

    public KeplerAttachParameter setInJDMopenbp(int i, String str) throws KeplerBufferOverflowException {
        try {
            putKeplerAttachParameter("mopenbp" + i, str);
        } catch (KeplerAttachException e) {
            e.printStackTrace();
        }
        return this;
    }

    public KeplerAttachParameter setCustomerInfo(String str) throws KeplerBufferOverflowException {
        try {
            putKeplerAttachParameter("keplerCustomerInfo", str);
        } catch (KeplerAttachException e) {
            e.printStackTrace();
        }
        return this;
    }

    public KeplerAttachParameter setPositionId(int i) throws KeplerBufferOverflowException {
        try {
            putKeplerAttachParameter("positionId", i + "");
        } catch (KeplerAttachException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String putKeplerAttachParameter(String str, String str2) throws KeplerBufferOverflowException, KeplerAttachException {
        if (aq.a(str)) {
            throw new KeplerAttachException("put key isEmpty");
        } else if (aq.a(str2)) {
            return (String) this.mapAttachParameter.put(str, ar.f("null"));
        } else {
            String f = ar.f(ar.f(str2));
            p.b("suwg", f);
            if (f.length() <= 256) {
                return (String) this.mapAttachParameter.put(str, ar.f(str2));
            }
            throw new KeplerBufferOverflowException("customerInfo string url encode length must <=256 bytes," + f.length());
        }
    }

    public void reset() {
        this.mapAttachParameter.clear();
    }

    public void add2Json(JSONObject jSONObject) throws JSONException {
        for (String str : this.mapAttachParameter.keySet()) {
            jSONObject.put(str, (String) this.mapAttachParameter.get(str));
        }
    }

    public String get(String str) {
        String str2 = (String) this.mapAttachParameter.get(str);
        return !aq.a(str2) ? str2 : "null";
    }

    public void add2Map(Hashtable<String, String> hashtable) {
        if (hashtable != null) {
            for (String str : this.mapAttachParameter.keySet()) {
                hashtable.put(str, (String) this.mapAttachParameter.get(str));
            }
        }
    }

    public String getShowInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.mapAttachParameter.keySet()) {
            stringBuffer.append(str).append(HttpUtils.EQUAL_SIGN).append((String) this.mapAttachParameter.get(str)).append("\n");
        }
        return stringBuffer.toString();
    }
}
