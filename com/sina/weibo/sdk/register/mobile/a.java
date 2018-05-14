package com.sina.weibo.sdk.register.mobile;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class a implements Serializable, Comparable<a> {
    public static final String CHINA_CODE = "0086";
    private static final long serialVersionUID = 0;
    private String code;
    private String[] mccs;
    private String name;
    private String pinyin;

    public a(String str, String str2) {
        this.name = str;
        this.code = str2;
    }

    public String getName() {
        return this.name;
    }

    public String[] getMccs() {
        return this.mccs;
    }

    public void setMccs(String[] strArr) {
        this.mccs = strArr;
    }

    public String getPinyin() {
        return c.a().a(this.name).toLowerCase();
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public String getCode() {
        return this.code;
    }

    public int compareTo(a aVar) {
        if (TextUtils.isEmpty(this.pinyin)) {
            return -1;
        }
        if (aVar == null || TextUtils.isEmpty(aVar.pinyin)) {
            return 1;
        }
        return this.pinyin.compareTo(aVar.pinyin);
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
