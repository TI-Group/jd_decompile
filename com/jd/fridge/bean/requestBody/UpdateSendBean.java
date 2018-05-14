package com.jd.fridge.bean.requestBody;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class UpdateSendBean implements Serializable {
    private static final long serialVersionUID = -2415464713985942746L;
    private String app_name = "mApp";
    private String app_type = "app";
    private String os = "android";
    private String product_uuid = "Z7VNBJ";
    private String version;

    public UpdateSendBean(String str) {
        this.version = str;
    }
}
