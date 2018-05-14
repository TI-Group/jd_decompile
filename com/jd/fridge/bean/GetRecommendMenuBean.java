package com.jd.fridge.bean;

import java.util.ArrayList;

/* compiled from: TbsSdkJava */
public class GetRecommendMenuBean extends BaseJsonBean {
    private static final long serialVersionUID = -7541402409429461011L;
    public ArrayList<MenuBean> result = new ArrayList();

    public ArrayList<MenuBean> getResult() {
        return this.result;
    }
}
