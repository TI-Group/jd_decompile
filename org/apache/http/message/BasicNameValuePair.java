package org.apache.http.message;

import cn.jiguang.net.HttpUtils;
import java.io.Serializable;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicNameValuePair implements Serializable, Cloneable, NameValuePair {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder stringBuilder = new StringBuilder((this.name.length() + 1) + this.value.length());
        stringBuilder.append(this.name);
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        if (this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
