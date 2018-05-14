package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FoodsListDataBaseBean implements Serializable {
    private static final long serialVersionUID = -8870671021794285733L;
    private String code;
    private List<FoodsListDataBean> list;
    private String msg;
    private boolean success;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public List<FoodsListDataBean> getList() {
        return this.list;
    }

    public void setList(List<FoodsListDataBean> list) {
        this.list = list;
    }
}
