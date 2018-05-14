package com.jd.fridge.comments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.ShareDataBean;
import com.jd.fridge.util.c;
import com.jd.fridge.util.h;
import com.jd.fridge.util.k;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.t;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.jd.fridge.widget.b;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MyFridgeCommentsActivity extends BaseActivity implements com.jd.fridge.widget.b.a {
    private static final String j = MyFridgeCommentsActivity.class.getSimpleName();
    private t A;
    private ProgressDialog B;
    private IWXAPI C = null;
    ImageView a;
    ImageView b;
    TextView c;
    RelativeLayout d;
    ShareDataBean i = new ShareDataBean();
    private Context k;
    private X5WebView l;
    private EmptyLayout m;
    private View n;
    private String o = "";
    private String p = "";
    private String q = "/friends/";
    private String r;
    private String s;
    private LinearLayout t;
    private PopupWindow u;
    private DisplayMetrics v;
    private b w;
    private OnClickListener x = new OnClickListener(this) {
        final /* synthetic */ MyFridgeCommentsActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            if (!y.c()) {
                String str = "";
                switch (view.getId()) {
                    case R.id.filter_all:
                        str = this.a.o;
                        this.a.c.setText(R.string.activity_my_fridge_comments_title_text);
                        break;
                    case R.id.filter_friends:
                        str = this.a.p + "?type=1&msgGroupId=" + this.a.r;
                        this.a.c.setText(R.string.activity_my_fridge_comments_from_friends_title_text);
                        break;
                    case R.id.filter_wechat:
                        str = this.a.p + "?type=2&msgGroupId=" + this.a.r;
                        this.a.c.setText(R.string.activity_my_fridge_comments_from_wechat_title_text);
                        break;
                }
                this.a.l.loadUrl(str);
                this.a.u.dismiss();
            }
        }
    };
    private final WebViewClient y = new WebViewClient(this) {
        final /* synthetic */ MyFridgeCommentsActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            r.b("infos", "url===" + str);
            if (str.startsWith("fridgenative://")) {
                if (str.contains("ToFridgeScreeningFirst") || str.contains("ToFridgeScreening")) {
                    this.b.r = this.b.e(str);
                } else if (str.contains("ToFridgeShare")) {
                    this.b.d(str);
                    this.b.a(this.b.i);
                }
            }
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.b.l.loadData(this.b.z, "text/html", HTTP.UTF_8);
            this.b.s = str2;
            this.b.n.setVisibility(0);
            this.b.m.setErrorType(1);
        }
    };
    private String z = "";

    /* compiled from: TbsSdkJava */
    private class a extends AsyncTask<String, Integer, Boolean> {
        final /* synthetic */ MyFridgeCommentsActivity a;
        private final int b;
        private final ShareDataBean c;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((Boolean) obj);
        }

        public a(MyFridgeCommentsActivity myFridgeCommentsActivity, int i, ShareDataBean shareDataBean) {
            this.a = myFridgeCommentsActivity;
            this.b = i;
            this.c = shareDataBean;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.a.B = ProgressDialog.show(this.a, "", this.a.getString(R.string.wx_share_loading), true, false);
        }

        protected Boolean a(String... strArr) {
            this.a.C = WXAPIFactory.createWXAPI(this.a, GlobalVariable.i);
            this.a.C.registerApp(GlobalVariable.i);
            if (!this.a.C.isWXAppInstalled()) {
                this.a.A.a(this.a.getString(R.string.wx_share_no_wx));
                return Boolean.valueOf(false);
            } else if (this.b != 1 || this.a.C.getWXAppSupportAPI() >= Build.TIMELINE_SUPPORTED_SDK_INT) {
                Bitmap decodeStream;
                IMediaObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = this.c.getShareUrl();
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                wXMediaMessage.title = this.c.getShareTitle();
                wXMediaMessage.description = this.c.getShareText();
                try {
                    decodeStream = BitmapFactory.decodeStream(new URL(this.c.getSharePicUrl()).openStream());
                } catch (Exception e) {
                    decodeStream = null;
                }
                if (decodeStream != null) {
                    try {
                        if (decodeStream.getWidth() * decodeStream.getHeight() > 40000) {
                            decodeStream = c.b(decodeStream, 200, 200);
                        }
                        wXMediaMessage.setThumbImage(decodeStream);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return Boolean.valueOf(false);
                    }
                }
                wXMediaMessage.setThumbImage(BitmapFactory.decodeResource(this.a.getResources(), R.mipmap.ic_launcher));
                BaseReq req = new Req();
                req.transaction = this.a.f("webpage");
                req.message = wXMediaMessage;
                req.scene = this.b;
                this.a.C.sendReq(req);
                return Boolean.valueOf(true);
            } else {
                this.a.A.a(this.a.getString(R.string.wx_share_error_tip));
                return Boolean.valueOf(false);
            }
        }

        protected void a(Boolean bool) {
            super.onPostExecute(bool);
            if (!bool.booleanValue()) {
                this.a.A.a(this.a.getString(R.string.wx_share_failed));
            }
            if (this.a.B != null && this.a.B.isShowing()) {
                this.a.B.dismiss();
            }
        }
    }

    protected int a() {
        return R.layout.activity_favor_menu;
    }

    private void f() {
        this.d = (RelativeLayout) findViewById(R.id.app_title);
        this.c = (TextView) findViewById(R.id.app_title_textview);
        this.c.setText(R.string.activity_my_fridge_comments_title_text);
        this.b = (ImageView) findViewById(R.id.left_appbar_btn);
        this.b.setImageResource(R.drawable.appbar_back_selector);
        this.b.setVisibility(0);
        this.b.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MyFridgeCommentsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.finish();
            }
        });
        this.a = (ImageView) findViewById(R.id.right_appbar_btn);
        this.a.setImageResource(R.drawable.appbar_filter_selector);
        this.a.setVisibility(0);
        this.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MyFridgeCommentsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.h();
            }
        });
    }

    private void g() {
        this.t = (LinearLayout) getLayoutInflater().inflate(R.layout.comments_filter_popup_layout, null);
        this.t.findViewById(R.id.filter_all).setOnClickListener(this.x);
        this.t.findViewById(R.id.filter_friends).setOnClickListener(this.x);
        this.t.findViewById(R.id.filter_wechat).setOnClickListener(this.x);
        this.u = new PopupWindow(this.t, (int) getResources().getDimension(R.dimen.filter_popup_width), -2);
        this.u.setFocusable(true);
        this.u.setOutsideTouchable(true);
        this.u.setTouchable(true);
        this.u.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_window_bg_drawable));
    }

    private void h() {
        this.u.showAsDropDown(this.d, this.v.widthPixels - ((int) (((float) (h.a(getBaseContext(), getResources().getDimension(R.dimen.filter_popup_x_offset)) + h.a(getBaseContext(), getResources().getDimension(R.dimen.filter_popup_width)))) / this.v.density)), 0);
        this.u.update();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    protected void b() {
        this.k = this;
        this.A = new t(this);
        this.w = new b(this);
        k();
        this.o = GlobalVariable.B().f() + this.q + "viewMsg";
        this.p = GlobalVariable.B().f() + this.q + "viewMsgByType";
        this.v = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(this.v);
        f();
        g();
        this.n = findViewById(R.id.empty_layout_root);
        this.m = (EmptyLayout) findViewById(R.id.empty_layout);
        this.m.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MyFridgeCommentsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.l.loadUrl(this.a.s);
                    p.a(MyFridgeCommentsActivity.j, "11: " + this.a.s);
                    this.a.n.setVisibility(8);
                    this.a.m.setErrorType(4);
                }
            }
        });
        this.l = (X5WebView) findViewById(R.id.favor_menu_webview);
        this.l.setWebViewClient(this.y);
        this.l.setWebChromeClient(new WebChromeClient());
        this.l.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MyFridgeCommentsActivity a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.l.a(this.k, this.o);
        this.l.loadUrl(this.o);
        p.a(j, "22: " + this.o);
    }

    protected void c() {
    }

    protected void d() {
    }

    private void d(String str) {
        try {
            str = URLDecoder.decode(str, CommonUtil.UTF8);
            r.b("infos", "url=utf8==" + str);
            str = str.substring(str.indexOf("ToFridgeShare/?url=") + 19);
            int indexOf = str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) + 1;
            String substring = str.substring(0, indexOf);
            str = str.substring(indexOf);
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            String str8 = "";
            int indexOf2 = str.indexOf(HttpUtils.EQUAL_SIGN);
            while (indexOf2 > 0) {
                int indexOf3 = str.indexOf(HttpUtils.PARAMETERS_SEPARATOR);
                String substring2 = str.substring(0, indexOf2);
                String substring3 = indexOf3 > 0 ? str.substring(indexOf2 + 1, indexOf3) : str.substring(indexOf2 + 1);
                if (substring2.equals("ffId")) {
                    str2 = substring3;
                } else if (substring2.equals("msgGroupId")) {
                    str3 = substring3;
                } else if (substring2.equals("userPin")) {
                    str4 = substring3;
                } else if (substring2.equals("r")) {
                    str5 = substring3;
                } else if (substring2.equals("shareTitle")) {
                    str6 = substring3;
                } else if (substring2.equals("shareImg")) {
                    str7 = substring3;
                } else if (substring2.equals("shareDes")) {
                    str8 = substring3;
                }
                if (-1 == indexOf3) {
                    break;
                }
                str = str.substring(indexOf3 + 1);
                indexOf2 = str.indexOf(HttpUtils.EQUAL_SIGN);
            }
            this.i.setShareUrl(substring + "ffId=" + str2 + "&msgGroupId=" + str3 + "&userPin=" + str4 + "&r=" + str5);
            this.i.setShareText(str8);
            this.i.setSharePicUrl(str7);
            this.i.setShareTitle(str6);
            r.b("infos", "shareImg==" + str7);
        } catch (Exception e) {
            k.a("message---" + e.getMessage() + " " + str);
        }
    }

    private String e(String str) {
        return str.substring(str.indexOf("?msgGroupId=") + 12);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        finish();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.l.removeAllViews();
        this.l.destroy();
    }

    public void a(ShareDataBean shareDataBean) {
        if (this.w != null && shareDataBean != null) {
            this.w.a(shareDataBean.getShareUrl(), shareDataBean.getSharePicUrl(), shareDataBean.getShareText(), shareDataBean.getShareTitle());
            this.w.show();
        }
    }

    public void b(ShareDataBean shareDataBean) {
        new a(this, 0, shareDataBean).execute(new String[0]);
    }

    public void c(ShareDataBean shareDataBean) {
        new a(this, 1, shareDataBean).execute(new String[0]);
    }

    private String f(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }
}
