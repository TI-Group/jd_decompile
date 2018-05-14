package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.d.a;
import cn.jpush.android.d.e;
import cn.jpush.android.d.i;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import cn.jpush.android.e.a.f;

/* compiled from: TbsSdkJava */
public class FullScreenView extends LinearLayout {
    private static final String TAG;
    public static f webViewHelper = null;
    private static final String[] z;
    private OnClickListener btnBackClickListener = new OnClickListener(this) {
        final /* synthetic */ FullScreenView a;

        {
            this.a = r1;
        }

        public final void onClick(View view) {
            if (this.a.mContext != null) {
                ((Activity) this.a.mContext).onBackPressed();
            }
        }
    };
    private ImageButton imgBtnBack;
    private final Context mContext;
    private WebView mWebView;
    private ProgressBar pushPrograssBar;
    private RelativeLayout rlTitleBar;
    private TextView tvTitle;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 13;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\nFR'\u0005/A[.8\u001aZ[<";
        r0 = 12;
        r4 = r3;
    L_0x000a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x0035;
    L_0x0013:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0018:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00b8;
            case 1: goto L_0x00bc;
            case 2: goto L_0x00c0;
            case 3: goto L_0x00c4;
            default: goto L_0x001f;
        };
    L_0x001f:
        r9 = 86;
    L_0x0021:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x0033;
    L_0x0029:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0018;
    L_0x002d:
        TAG = r1;
        r1 = "=FW?\u00109_R\u00185>V[%v)AL%9";
        r0 = -1;
        goto L_0x000a;
    L_0x0033:
        r5 = r1;
        r1 = r7;
    L_0x0035:
        if (r5 > r6) goto L_0x0013;
    L_0x0037:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x004b;
            case 1: goto L_0x0053;
            case 2: goto L_0x005b;
            case 3: goto L_0x0063;
            case 4: goto L_0x006b;
            case 5: goto L_0x0073;
            case 6: goto L_0x007b;
            case 7: goto L_0x0084;
            case 8: goto L_0x008f;
            case 9: goto L_0x009a;
            case 10: goto L_0x00a5;
            case 11: goto L_0x00b0;
            case 12: goto L_0x002d;
            default: goto L_0x0043;
        };
    L_0x0043:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0006cK8>\u001bV\\";
        r0 = 0;
        r3 = r4;
        goto L_0x000a;
    L_0x004b:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u001c_[*%)\u0013K83lW[-79_Jk5#W[k?\"\u0013T;#?[a<3.EW.!\u0013__299G\u00103; \u0012";
        r0 = 1;
        r3 = r4;
        goto L_0x000a;
    L_0x0053:
        r3[r2] = r1;
        r2 = 3;
        r1 = "8El\"5$CK8>\u0018ZJ'3";
        r0 = 2;
        r3 = r4;
        goto L_0x000a;
    L_0x005b:
        r3[r2] = r1;
        r2 = 4;
        r1 = "<FM#\u0006>\\Y97?@|*$";
        r0 = 3;
        r3 = r4;
        goto L_0x000a;
    L_0x0063:
        r3[r2] = r1;
        r2 = 5;
        r1 = ">_l\"5$CK8>\u0018ZJ'3\u000eRL";
        r0 = 4;
        r3 = r4;
        goto L_0x000a;
    L_0x006b:
        r3[r2] = r1;
        r2 = 6;
        r1 = "*FR'\u0001)Qh\"3;";
        r0 = 5;
        r3 = r4;
        goto L_0x000a;
    L_0x0073:
        r3[r2] = r1;
        r2 = 7;
        r1 = "%W";
        r0 = 6;
        r3 = r4;
        goto L_0x000a;
    L_0x007b:
        r3[r2] = r1;
        r2 = 8;
        r1 = "%^Y\u0019?/[N>%$qJ%\u0014-PU";
        r0 = 7;
        r3 = r4;
        goto L_0x000a;
    L_0x0084:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\r]Z99%W\u001e82'\u0013H.$?ZQ%v+A[*\")A\u001e?>-]\u001e$$lVO>7 \u0013J$v}\u0004\u0012k\u001c-E_ \u001c?\u0013W%\")A_(\"lQGk7\"]Q?78ZQ%w";
        r0 = 8;
        r3 = r4;
        goto L_0x000a;
    L_0x008f:
        r3[r2] = r1;
        r2 = 10;
        r1 = " \\_/\u0003>_\u0004";
        r0 = 9;
        r3 = r4;
        goto L_0x000a;
    L_0x009a:
        r3[r2] = r1;
        r2 = 11;
        r1 = "-WZ\u00017:RM($%CJ\u000288VL-7/V";
        r0 = 10;
        r3 = r4;
        goto L_0x000a;
    L_0x00a5:
        r3[r2] = r1;
        r2 = 12;
        r1 = "-WZ\u00017:RM($%CJ\u000288VL-7/V\u001e-7%_[/l";
        r0 = 11;
        r3 = r4;
        goto L_0x000a;
    L_0x00b0:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        webViewHelper = r0;
        return;
    L_0x00b8:
        r9 = 76;
        goto L_0x0021;
    L_0x00bc:
        r9 = 51;
        goto L_0x0021;
    L_0x00c0:
        r9 = 62;
        goto L_0x0021;
    L_0x00c4:
        r9 = 75;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ui.FullScreenView.<clinit>():void");
    }

    public FullScreenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    private void quitFullScreen() {
        try {
            LayoutParams attributes = ((Activity) this.mContext).getWindow().getAttributes();
            attributes.flags &= -1025;
            ((Activity) this.mContext).getWindow().setAttributes(attributes);
            ((Activity) this.mContext).getWindow().clearFlags(512);
        } catch (Exception e) {
            e.g(TAG, z[0]);
        }
    }

    private void reflectAddJsInterface() {
        r0 = new Object[2];
        Class[] clsArr = new Class[]{webViewHelper, z[1]};
        clsArr[0] = Object.class;
        clsArr[1] = String.class;
        try {
            i.a(this.mWebView, z[11], clsArr, r0);
        } catch (Exception e) {
            e.printStackTrace();
            e.i(TAG, new StringBuilder(z[12]).append(e.toString()).toString());
        }
    }

    public void destory() {
        removeAllViews();
        if (this.mWebView != null) {
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    public void initModule(Context context, b bVar) {
        g gVar = (g) bVar;
        CharSequence charSequence = gVar.I;
        setFocusable(true);
        this.mWebView = (WebView) findViewById(getResources().getIdentifier(z[6], z[7], context.getPackageName()));
        this.rlTitleBar = (RelativeLayout) findViewById(getResources().getIdentifier(z[5], z[7], context.getPackageName()));
        this.tvTitle = (TextView) findViewById(getResources().getIdentifier(z[3], z[7], context.getPackageName()));
        this.imgBtnBack = (ImageButton) findViewById(getResources().getIdentifier(z[8], z[7], context.getPackageName()));
        this.pushPrograssBar = (ProgressBar) findViewById(getResources().getIdentifier(z[4], z[7], context.getPackageName()));
        if (this.mWebView == null || this.rlTitleBar == null || this.tvTitle == null || this.imgBtnBack == null) {
            e.j(TAG, z[2]);
            ((Activity) this.mContext).finish();
        }
        if (1 == gVar.K) {
            this.rlTitleBar.setVisibility(8);
            ((Activity) context).getWindow().setFlags(1024, 1024);
        } else {
            this.tvTitle.setText(charSequence);
            this.imgBtnBack.setOnClickListener(this.btnBackClickListener);
        }
        this.mWebView.setScrollbarFadingEnabled(true);
        this.mWebView.setScrollBarStyle(33554432);
        WebSettings settings = this.mWebView.getSettings();
        a.a(settings);
        a.a(this.mWebView);
        settings.setSavePassword(false);
        webViewHelper = new f(context, bVar);
        if (VERSION.SDK_INT >= 17) {
            e.d(TAG, z[9]);
            reflectAddJsInterface();
        }
        this.mWebView.setWebChromeClient(new cn.jpush.android.e.a.a(z[1], cn.jpush.android.e.a.b.class, this.pushPrograssBar, this.tvTitle));
        this.mWebView.setWebViewClient(new a(bVar));
        cn.jpush.android.e.a.b.setWebViewHelper(webViewHelper);
    }

    public void loadUrl(String str) {
        if (this.mWebView != null) {
            e.c(TAG, new StringBuilder(z[10]).append(str).toString());
            this.mWebView.loadUrl(str);
        }
    }

    public void pause() {
        if (this.mWebView != null && VERSION.SDK_INT >= 11) {
            this.mWebView.onPause();
        }
    }

    public void resume() {
        if (this.mWebView != null) {
            if (VERSION.SDK_INT >= 11) {
                this.mWebView.onResume();
            }
            cn.jpush.android.e.a.b.setWebViewHelper(webViewHelper);
        }
    }

    public void showTitleBar() {
        if (this.rlTitleBar != null && this.rlTitleBar.getVisibility() == 8) {
            this.rlTitleBar.setVisibility(0);
            quitFullScreen();
            this.imgBtnBack.setOnClickListener(this.btnBackClickListener);
            if (this.mWebView != null) {
                this.mWebView.postDelayed(new Runnable(this) {
                    final /* synthetic */ FullScreenView a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        if (this.a.mWebView != null) {
                            this.a.mWebView.clearHistory();
                        }
                    }
                }, 1000);
            }
        }
    }

    public boolean webviewCanGoBack() {
        return this.mWebView != null ? this.mWebView.canGoBack() : false;
    }

    public void webviewGoBack() {
        if (this.mWebView != null) {
            this.mWebView.goBack();
        }
    }
}
