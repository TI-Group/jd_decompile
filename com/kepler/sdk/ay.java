package com.kepler.sdk;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class ay {
    public String a;
    public Map<String, String> b;
    public int c;
    public double d;
    public int e;
    public int f;
    public int g;
    public String h;
    public String i;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_k", this.a);
            jSONObject.put("_c", this.c);
            jSONObject.put("_ct", this.e);
            jSONObject.put("_h", this.f);
            jSONObject.put("_d", this.g);
            jSONObject.put("_nt", this.h);
            if (this.b != null) {
                jSONObject.put("_se", new JSONObject(this.b));
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put("_sa", this.i);
            }
            jSONObject.put("_s", this.d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ay)) {
            return false;
        }
        ay ayVar = (ay) obj;
        if (this.a == null) {
            if (ayVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(ayVar.a)) {
            return false;
        }
        if (this.e != ayVar.e || this.f != ayVar.f || this.g != ayVar.g) {
            return false;
        }
        if (this.b == null) {
            if (ayVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(ayVar.b)) {
            return false;
        }
        if (this.h == null) {
            if (ayVar.h != null) {
                return false;
            }
        } else if (!this.h.equals(ayVar.h)) {
            return false;
        }
        if (this.i == null) {
            if (ayVar.i != null) {
                return false;
            }
        } else if (!this.i.equals(ayVar.i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i = 1;
        if (this.a != null) {
            hashCode = this.a.hashCode();
        } else {
            hashCode = 1;
        }
        if (this.b != null) {
            hashCode2 = this.b.hashCode();
        } else {
            hashCode2 = 1;
        }
        hashCode ^= hashCode2;
        if (this.e != 0) {
            i = this.e;
        }
        return hashCode ^ i;
    }
}
