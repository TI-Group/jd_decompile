package cn.jpush.android.e.a;

import android.text.TextUtils.TruncateAt;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: TbsSdkJava */
public final class a extends c {
    private ProgressBar a;
    private TextView b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.a = progressBar;
        this.b = textView;
        if (this.a != null) {
            this.a.setMax(100);
        }
        if (this.b != null) {
            this.b.setSingleLine(true);
            this.b.setEllipsize(TruncateAt.END);
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (this.a != null) {
            if (100 == i) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
                this.a.setProgress(i);
            }
        }
        if (this.b != null && webView.getTitle() != null && !webView.getTitle().equals(this.b.getText())) {
            this.b.setText(webView.getTitle());
        }
    }
}
