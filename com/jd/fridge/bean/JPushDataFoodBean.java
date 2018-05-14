package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class JPushDataFoodBean extends JPushDataBaseBean {
    private static final long serialVersionUID = 4886674563067662368L;
    private FoodBean data;

    /* compiled from: TbsSdkJava */
    class FoodBean {
        private String expired_date = "";
        private String goods_id = "";
        private String goods_name = "";

        FoodBean() {
        }

        public String getGoods_id() {
            return this.goods_id;
        }

        public void setGoods_id(String str) {
            this.goods_id = str;
        }

        public String getGoods_name() {
            return this.goods_name;
        }

        public void setGoods_name(String str) {
            this.goods_name = str;
        }

        public String getExpired_date() {
            return this.expired_date;
        }

        public void setExpired_date(String str) {
            this.expired_date = str;
        }
    }

    public FoodBean getData() {
        return this.data;
    }

    public void setData(FoodBean foodBean) {
        this.data = foodBean;
    }
}
