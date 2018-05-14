package com.jd.fridge.bean;

import java.io.Serializable;
import org.apache.http.HttpHost;

/* compiled from: TbsSdkJava */
public class FoodsListDataBean implements Serializable {
    private static final long serialVersionUID = 4934332878820878402L;
    private String imgUrl = "";
    private String label = "";
    private double price;
    private double salesPrice;
    private long sku;
    private String title = "";

    public long getSku() {
        return this.sku;
    }

    public void setSku(long j) {
        this.sku = j;
    }

    public String getImgUrl() {
        return this.imgUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME) ? this.imgUrl : "https:" + this.imgUrl;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public double getSalesPrice() {
        return this.salesPrice;
    }

    public void setSalesPrice(double d) {
        this.salesPrice = d;
    }
}
