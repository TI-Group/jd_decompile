package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class HGHCDataBean implements Serializable {
    private static final long serialVersionUID = 6101658807318363299L;
    private List<HGHCItemDataBean> result;
    private int total;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public List<HGHCItemDataBean> getResult() {
        return this.result;
    }

    public void setResult(List<HGHCItemDataBean> list) {
        this.result = list;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
