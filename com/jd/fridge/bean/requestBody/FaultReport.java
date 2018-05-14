package com.jd.fridge.bean.requestBody;

/* compiled from: TbsSdkJava */
public class FaultReport {
    private String address;
    private String area_num;
    private String contact;
    private String contact_phone;
    private String device_id;
    private String fault_desc;
    private String fault_type;
    private String region;

    public FaultReport(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.device_id = str;
        this.fault_type = str2;
        this.fault_desc = str3;
        this.contact = str4;
        this.contact_phone = str5;
        this.region = str6;
        this.address = str7;
        this.area_num = str8;
    }
}
