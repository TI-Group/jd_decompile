package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class StreamsH5Product implements Serializable {
    private int cid;
    private int config_type;
    private boolean is_show_resetjoinnet;
    private String lancon;
    private String p_description;
    private String p_img_url;
    private int pro_type;
    private long product_id;
    private String product_name;
    private String product_uuid;
    private String protocol_version;
    private String secret_key;
    private int share_flag;
    private String template_type;
    private String type_desc;
    private String type_name;

    public boolean is_show_resetjoinnet() {
        return this.is_show_resetjoinnet;
    }

    public void setIs_show_resetjoinnet(boolean z) {
        this.is_show_resetjoinnet = z;
    }

    public String getP_description() {
        return this.p_description;
    }

    public void setP_description(String str) {
        this.p_description = str;
    }

    public String getLancon() {
        return this.lancon;
    }

    public void setLancon(String str) {
        this.lancon = str;
    }

    public long getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(long j) {
        this.product_id = j;
    }

    public int getConfig_type() {
        return this.config_type;
    }

    public void setConfig_type(int i) {
        this.config_type = i;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String str) {
        this.product_name = str;
    }

    public int getPro_type() {
        return this.pro_type;
    }

    public void setPro_type(int i) {
        this.pro_type = i;
    }

    public int getShare_flag() {
        return this.share_flag;
    }

    public void setShare_flag(int i) {
        this.share_flag = i;
    }

    public String getTemplate_type() {
        return this.template_type;
    }

    public void setTemplate_type(String str) {
        this.template_type = str;
    }

    public int getCid() {
        return this.cid;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public String getProtocol_version() {
        return this.protocol_version;
    }

    public void setProtocol_version(String str) {
        this.protocol_version = str;
    }

    public String getProduct_uuid() {
        return this.product_uuid;
    }

    public void setProduct_uuid(String str) {
        this.product_uuid = str;
    }

    public String getType_desc() {
        return this.type_desc;
    }

    public void setType_desc(String str) {
        this.type_desc = str;
    }

    public String getP_img_url() {
        return this.p_img_url;
    }

    public void setP_img_url(String str) {
        this.p_img_url = str;
    }

    public String getType_name() {
        return this.type_name;
    }

    public void setType_name(String str) {
        this.type_name = str;
    }

    public String getSecret_key() {
        return this.secret_key;
    }

    public void setSecret_key(String str) {
        this.secret_key = str;
    }
}
