package com.jd.fridge.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.HomeActivity;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.ControlCommand;
import com.jd.fridge.bean.requestBody.FridgeControlSendBean;
import com.jd.fridge.bean.requestBody.FridgeStatus;
import com.jd.fridge.bean.requestBody.StreamsAndH5Info;
import com.jd.fridge.util.b.c;
import com.jd.fridge.util.b.d;
import com.jd.fridge.util.b.d.a;
import com.jd.fridge.util.p;
import com.jd.fridge.util.socket.LongSocketService;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class NewControlH5Fragment extends BaseFragment implements a {
    private static String f = ControlH5Fragment.class.getSimpleName();
    private static String g = "jd-socket";
    private static String h = "https://__bridge_loaded__/";
    BroadcastReceiver d = new BroadcastReceiver(this) {
        final /* synthetic */ NewControlH5Fragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("get_snap_shot")) {
                String stringExtra = intent.getStringExtra("data");
                p.a(NewControlH5Fragment.f, "广播收到数据：" + stringExtra);
                if (stringExtra != null) {
                    this.a.k.a(stringExtra);
                }
            }
        }
    };
    private Context e;
    private X5WebView i;
    private EmptyLayout j;
    private d k;
    private String l = "";
    private String m = HttpUtils.PATHS_SEPARATOR;
    private boolean n = false;
    private WebViewClient o = new WebViewClient(this) {
        final /* synthetic */ NewControlH5Fragment b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            p.a(NewControlH5Fragment.f, "shouldOverrideUrlLoading : " + str);
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            p.a(NewControlH5Fragment.f, "onPageFinished : " + str);
            this.b.e();
            if (y.d(this.b.e)) {
                this.b.a(webView);
                this.b.n = true;
                if (!TextUtils.isEmpty(LongSocketService.e())) {
                    p.a(NewControlH5Fragment.f, "first: " + LongSocketService.e());
                    this.b.k.a(LongSocketService.e());
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            p.b(NewControlH5Fragment.f, "onReceiverdError: " + str + " failingUrl:" + str2 + " errorCode:" + i);
            this.b.i.loadData("", "text/html", HTTP.UTF_8);
            this.b.a(1);
        }
    };

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.new_fragment_control_h5, viewGroup, false);
        b(inflate);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.e = getActivity();
        d();
    }

    public void onResume() {
        super.onResume();
        p.a(f, "ControlH5Fragment onResume...");
        if ("0".equals(GlobalVariable.C())) {
            a(9);
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            p.a(f, "isVisibleToUser");
            if ("0".equals(GlobalVariable.C())) {
                a(9);
            }
            if (TextUtils.isEmpty(this.l)) {
                c();
            }
            if (this.n) {
                b("");
            }
        }
    }

    public void onPause() {
        super.onPause();
        p.a(f, "ControlH5Fragment onPause...");
    }

    private void c() {
        if ("0".equals(GlobalVariable.C())) {
            a(9);
            return;
        }
        a(2);
        String str = null;
        try {
            str = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        com.jd.fridge.a.a().a(this.a, new StreamsAndH5Info(str, Long.parseLong(GlobalVariable.C())));
    }

    private void a(View view) {
        this.i = (X5WebView) view.findViewById(R.id.control_webview);
        this.i.setWebViewClient(this.o);
        this.k = new d(getActivity(), this.i, this);
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.i.addJavascriptInterface(this.k, "_WebViewJavascriptBridge");
        this.i.setWebChromeClient(new WebChromeClient());
    }

    private void b(View view) {
        a(view);
        ((TextView) view.findViewById(R.id.app_title_textview)).setText(getResources().getString(R.string.tab_control));
        this.j = (EmptyLayout) view.findViewById(R.id.empty_layout);
        this.j.setRefresh(new OnClickListener(this) {
            final /* synthetic */ NewControlH5Fragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (y.c() || !y.d(this.a.getActivity())) {
                    return;
                }
                if (TextUtils.isEmpty(this.a.l)) {
                    this.a.c();
                } else {
                    this.a.i.loadUrl(this.a.l);
                }
            }
        });
    }

    public boolean handleMessage(Message message) {
        Bundle data;
        String string;
        switch (message.what) {
            case 7006:
                this.l = message.obj.toString();
                this.i.a(this.e, this.l);
                this.i.loadUrl(this.l);
                p.a(f, "network url: " + this.l);
                break;
            case 7007:
                e();
                p.b(f, "MESSAGE_CODE_RESULT_FAILED_SET_FOODS");
                a(1);
                break;
            case 10006:
                a(1);
                break;
            case 10007:
                data = message.getData();
                string = data.getString("result");
                String string2 = data.getString("responesId");
                if (TextUtils.isEmpty(string2)) {
                    this.k.a(string);
                } else {
                    this.k.a(string2, string);
                }
                p.a(g, "response-快照");
                p.a(f, "snap shot result (" + string2 + "): " + string);
                break;
            case 10008:
                data = message.getData();
                string = data.getString("result");
                this.k.a(data.getString("responesId"), string);
                p.a(g, "response-控制");
                p.a(f, "control result: " + string);
                break;
        }
        return super.handleMessage(message);
    }

    private void a(WebView webView) {
        c.a(webView, "jswebviewjavascriptbridge.js");
    }

    private void d() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("get_snap_shot");
            getActivity().registerReceiver(this.d, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, String str) {
        if (y.d(this.e)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            List arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                arrayList.add(new ControlCommand(optJSONObject.optString("stream_id"), optJSONObject.optString("current_value")));
            }
            com.jd.fridge.a.a().a(this.a, new FridgeControlSendBean(Long.parseLong(GlobalVariable.C()), arrayList), str);
            return;
        }
        this.a.sendEmptyMessage(10006);
    }

    public void b(String str) {
        if (!GlobalVariable.C().equals("0") && y.d(this.e)) {
            com.jd.fridge.a.a().a(this.a, new FridgeStatus(Long.parseLong(GlobalVariable.C()), GlobalVariable.L()), str);
        }
    }

    public void c(String str) {
        if (((HomeActivity) this.e).e() == 2) {
            Toast.makeText(this.e, str, 0).show();
        }
    }

    private void a(int i) {
        if (this.j != null) {
            this.j.setVisibility(0);
            this.j.setErrorType(i);
        }
    }

    private void e() {
        this.j.setVisibility(8);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            p.a(f, "onDestroy...");
            this.i.loadUrl("about:blank");
            this.i.stopLoading();
            this.i.setWebChromeClient(null);
            this.i.setWebViewClient(null);
            this.i.removeAllViews();
            this.i.clearHistory();
            this.i.destroy();
            this.i = null;
            if (this.d != null) {
                getActivity().unregisterReceiver(this.d);
            }
        }
    }
}
