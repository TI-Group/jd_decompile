package com.jd.fridge.bean.requestBody;

import com.jd.fridge.bean.BaseJsonBean;
import com.jd.fridge.bean.SearchGoodsListBean;
import java.util.List;

/* compiled from: TbsSdkJava */
public class SearchFoodsListBeanResult extends BaseJsonBean {
    private List<SearchGoodsListBean> result;

    public List<SearchGoodsListBean> getResult() {
        return this.result;
    }
}
