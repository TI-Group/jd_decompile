package com.jd.fridge.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NotMoveGoodsBean implements Serializable {
    private int count;
    private int goods_id;
    private List<NotMoveGoodsPositionsBean> positions;

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int i) {
        this.goods_id = i;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public List<NotMoveGoodsPositionsBean> getPositions() {
        return this.positions;
    }

    public void setPositions(List<NotMoveGoodsPositionsBean> list) {
        this.positions = list;
    }
}
