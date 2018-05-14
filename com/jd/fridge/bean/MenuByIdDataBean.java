package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class MenuByIdDataBean implements Serializable {
    private static final long serialVersionUID = 7192428799059367346L;
    private List<MenuByIdItemDataBean> main_materials;
    private String menu_cariello;
    private String menu_description;
    private String menu_id;
    private String menu_image;
    private String[] menu_materials;
    private String menu_name;
    private String menu_steps;
    private String menu_taste;
    private String menu_times;
    private List<MenuByIdItemDataBean> other_materials;

    public String getMenu_id() {
        return this.menu_id;
    }

    public void setMenu_id(String str) {
        this.menu_id = str;
    }

    public String getMenu_name() {
        return this.menu_name;
    }

    public void setMenu_name(String str) {
        this.menu_name = str;
    }

    public String getMenu_image() {
        return this.menu_image;
    }

    public void setMenu_image(String str) {
        this.menu_image = str;
    }

    public String getMenu_steps() {
        return this.menu_steps;
    }

    public void setMenu_steps(String str) {
        this.menu_steps = str;
    }

    public String getMenu_times() {
        return this.menu_times;
    }

    public void setMenu_times(String str) {
        this.menu_times = str;
    }

    public String getMenu_cariello() {
        return this.menu_cariello;
    }

    public void setMenu_cariello(String str) {
        this.menu_cariello = str;
    }

    public String getMenu_taste() {
        return this.menu_taste;
    }

    public void setMenu_taste(String str) {
        this.menu_taste = str;
    }

    public String[] getMenu_materials() {
        return this.menu_materials;
    }

    public void setMenu_materials(String[] strArr) {
        this.menu_materials = strArr;
    }

    public String getMenu_description() {
        return this.menu_description;
    }

    public void setMenu_description(String str) {
        this.menu_description = str;
    }

    public List<MenuByIdItemDataBean> getMain_materials() {
        return this.main_materials;
    }

    public void setMain_materials(List<MenuByIdItemDataBean> list) {
        this.main_materials = list;
    }

    public List<MenuByIdItemDataBean> getOther_materials() {
        return this.other_materials;
    }

    public void setOther_materials(List<MenuByIdItemDataBean> list) {
        this.other_materials = list;
    }
}
