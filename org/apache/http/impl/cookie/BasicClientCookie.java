package org.apache.http.impl.cookie;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicClientCookie implements Serializable, Cloneable, ClientCookie, SetCookie {
    private static final long serialVersionUID = -3869795591041535538L;
    private Map<String, String> attribs = new HashMap();
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private boolean isSecure;
    private final String name;
    private String value;

    public BasicClientCookie(String str, String str2) {
        Args.notNull(str, "Name");
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getComment() {
        return this.cookieComment;
    }

    public void setComment(String str) {
        this.cookieComment = str;
    }

    public String getCommentURL() {
        return null;
    }

    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    public void setExpiryDate(Date date) {
        this.cookieExpiryDate = date;
    }

    public boolean isPersistent() {
        return this.cookieExpiryDate != null;
    }

    public String getDomain() {
        return this.cookieDomain;
    }

    public void setDomain(String str) {
        if (str != null) {
            this.cookieDomain = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.cookieDomain = null;
        }
    }

    public String getPath() {
        return this.cookiePath;
    }

    public void setPath(String str) {
        this.cookiePath = str;
    }

    public boolean isSecure() {
        return this.isSecure;
    }

    public void setSecure(boolean z) {
        this.isSecure = z;
    }

    public int[] getPorts() {
        return null;
    }

    public int getVersion() {
        return this.cookieVersion;
    }

    public void setVersion(int i) {
        this.cookieVersion = i;
    }

    public boolean isExpired(Date date) {
        Args.notNull(date, "Date");
        return this.cookieExpiryDate != null && this.cookieExpiryDate.getTime() <= date.getTime();
    }

    public void setAttribute(String str, String str2) {
        this.attribs.put(str, str2);
    }

    public String getAttribute(String str) {
        return (String) this.attribs.get(str);
    }

    public boolean containsAttribute(String str) {
        return this.attribs.get(str) != null;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie basicClientCookie = (BasicClientCookie) super.clone();
        basicClientCookie.attribs = new HashMap(this.attribs);
        return basicClientCookie;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[version: ");
        stringBuilder.append(Integer.toString(this.cookieVersion));
        stringBuilder.append("]");
        stringBuilder.append("[name: ");
        stringBuilder.append(this.name);
        stringBuilder.append("]");
        stringBuilder.append("[value: ");
        stringBuilder.append(this.value);
        stringBuilder.append("]");
        stringBuilder.append("[domain: ");
        stringBuilder.append(this.cookieDomain);
        stringBuilder.append("]");
        stringBuilder.append("[path: ");
        stringBuilder.append(this.cookiePath);
        stringBuilder.append("]");
        stringBuilder.append("[expiry: ");
        stringBuilder.append(this.cookieExpiryDate);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
