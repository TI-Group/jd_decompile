package com.jd.fridge.bean;

/* compiled from: TbsSdkJava */
public class FridgePicture {
    private int pic_pixel_h;
    private int pic_pixel_w;
    private String pic_url;
    private int position_type;

    public FridgePicture(int i, String str) {
        this.position_type = i;
        this.pic_url = str;
    }

    public int getPositionType() {
        return this.position_type;
    }

    public String getPicUrl() {
        return this.pic_url;
    }

    public int getPicPixelW() {
        return this.pic_pixel_w;
    }

    public int getPicPixelH() {
        return this.pic_pixel_h;
    }
}
