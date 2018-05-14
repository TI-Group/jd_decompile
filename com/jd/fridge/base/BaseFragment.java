package com.jd.fridge.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.bean.Event;
import com.jd.fridge.util.r;
import com.jingdong.jdma.JDMaInterface;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.minterface.ClickInterfaceParam;
import com.jingdong.jdma.minterface.PvInterfaceParam;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.j;

/* compiled from: TbsSdkJava */
public abstract class BaseFragment extends Fragment implements Callback {
    protected Handler a;
    protected a b;
    protected Activity c;

    /* compiled from: TbsSdkJava */
    private static class a<T extends BaseFragment> extends Handler {
        private WeakReference<? extends BaseFragment> a;

        public a(T t) {
            this.a = new WeakReference(t);
        }

        public void handleMessage(Message message) {
            BaseFragment baseFragment = this.a == null ? null : (BaseFragment) this.a.get();
            if (baseFragment == null || baseFragment.getActivity() == null || baseFragment.getActivity().isFinishing()) {
                r.b("===========", "handler return ===============");
            } else {
                baseFragment.handleMessage(message);
            }
        }
    }

    protected Activity b() {
        return this.c;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.c = (Activity) context;
        if (context instanceof a) {
            this.b = (a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnBaseFragmentInteractionListener");
    }

    public void onDetach() {
        super.onDetach();
        this.b = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this);
        c.a().a((Object) this);
    }

    public void a(String str) {
        PvInterfaceParam pvInterfaceParam = new PvInterfaceParam();
        pvInterfaceParam.page_name = str;
        String str2 = null;
        try {
            str2 = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
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
            str3 = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
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

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public boolean handleMessage(Message message) {
        return false;
    }

    public void onDestroy() {
        c.a().b(this);
        this.a.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @j(a = ThreadMode.MAIN)
    public void onEventMainThread(Event event) {
        if (event != null) {
        }
    }
}
