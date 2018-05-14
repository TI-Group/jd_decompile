package org.apache.http.message;

import cn.jiguang.net.HttpUtils;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicHeaderElement implements Cloneable, HeaderElement {
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
        if (nameValuePairArr != null) {
            this.parameters = nameValuePairArr;
        } else {
            this.parameters = new NameValuePair[0];
        }
    }

    public BasicHeaderElement(String str, String str2) {
        this(str, str2, null);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    public int getParameterCount() {
        return this.parameters.length;
    }

    public NameValuePair getParameter(int i) {
        return this.parameters[i];
    }

    public NameValuePair getParameterByName(String str) {
        Args.notNull(str, "Name");
        for (NameValuePair nameValuePair : this.parameters) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair;
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderElement)) {
            return false;
        }
        BasicHeaderElement basicHeaderElement = (BasicHeaderElement) obj;
        if (this.name.equals(basicHeaderElement.name) && LangUtils.equals(this.value, basicHeaderElement.value) && LangUtils.equals(this.parameters, basicHeaderElement.parameters)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
        for (Object hashCode2 : this.parameters) {
            hashCode = LangUtils.hashCode(hashCode, hashCode2);
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        if (this.value != null) {
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(this.value);
        }
        for (Object obj : this.parameters) {
            stringBuilder.append("; ");
            stringBuilder.append(obj);
        }
        return stringBuilder.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
