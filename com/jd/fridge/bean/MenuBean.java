package com.jd.fridge.bean;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class MenuBean implements Serializable {
    private static final long serialVersionUID = -5633344782434235169L;
    private int menu_id;
    private String menu_image;
    private String menu_name;

    public String getMenuImage() {
        return this.menu_image;
    }

    public int getMenuId() {
        return this.menu_id;
    }

    public String getMenuName() {
        return this.menu_name;
    }
}
