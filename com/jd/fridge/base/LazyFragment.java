package com.jd.fridge.base;

import android.text.TextUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.util.c.a;
import com.jingdong.jdma.JDMaInterface;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.minterface.ClickInterfaceParam;
import com.jingdong.jdma.minterface.PvInterfaceParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: TbsSdkJava */
public abstract class LazyFragment extends BaseFragment {
    protected boolean d;

    protected abstract void c();

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            this.d = true;
            a();
            return;
        }
        this.d = false;
        d();
    }

    protected void a() {
        c();
    }

    protected void d() {
    }

    public void a(String str) {
        PvInterfaceParam pvInterfaceParam = new PvInterfaceParam();
        pvInterfaceParam.page_name = str;
        String str2 = null;
        try {
            str2 = URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        pvInterfaceParam.pin = str2;
        pvInterfaceParam.page_param = "";
        pvInterfaceParam.lat = "1.0";
        pvInterfaceParam.lon = "1.0";
        JDMaInterface.sendPvData(getContext(), GlobalVariable.B().c(), pvInterfaceParam);
    }

    public void a(String str, String str2) {
        ClickInterfaceParam clickInterfaceParam = new ClickInterfaceParam();
        clickInterfaceParam.page_name = str;
        String str3 = null;
        try {
            str3 = URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        clickInterfaceParam.pin = str3;
        clickInterfaceParam.next_page_name = "";
        clickInterfaceParam.event_id = str2;
        clickInterfaceParam.event_param = "";
        JDMaInterface.sendClickData(getContext(), GlobalVariable.B().c(), clickInterfaceParam);
    }
}
