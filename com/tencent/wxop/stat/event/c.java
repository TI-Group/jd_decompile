package com.tencent.wxop.stat.event;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    public String a;
    public JSONArray b;
    public JSONObject c = null;

    public c(String str, String[] strArr, Properties properties) {
        this.a = str;
        if (properties != null) {
            this.c = new JSONObject(properties);
        } else if (strArr != null) {
            this.b = new JSONArray();
            for (Object put : strArr) {
                this.b.put(put);
            }
        } else {
            this.c = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return toString().equals(((c) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.a).append(",");
        if (this.b != null) {
            stringBuilder.append(this.b.toString());
        }
        if (this.c != null) {
            stringBuilder.append(this.c.toString());
        }
        return stringBuilder.toString();
    }
}
