package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class SystemWebChromeClient extends WebChromeClient {
    private WebView a;
    private WebChromeClient b;

    private static class a implements ConsoleMessage {
        private MessageLevel a;
        private String b;
        private String c;
        private int d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            this.a = MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.b = consoleMessage.message();
            this.c = consoleMessage.sourceId();
            this.d = consoleMessage.lineNumber();
        }

        a(String str, String str2, int i) {
            this.a = MessageLevel.LOG;
            this.b = str;
            this.c = str2;
            this.d = i;
        }

        public int lineNumber() {
            return this.d;
        }

        public String message() {
            return this.b;
        }

        public MessageLevel messageLevel() {
            return this.a;
        }

        public String sourceId() {
            return this.c;
        }
    }

    class b implements CustomViewCallback {
        WebChromeClient.CustomViewCallback a;
        final /* synthetic */ SystemWebChromeClient b;

        b(SystemWebChromeClient systemWebChromeClient, WebChromeClient.CustomViewCallback customViewCallback) {
            this.b = systemWebChromeClient;
            this.a = customViewCallback;
        }

        public void onCustomViewHidden() {
            this.a.onCustomViewHidden();
        }
    }

    class c implements GeolocationPermissionsCallback {
        Callback a;
        final /* synthetic */ SystemWebChromeClient b;

        c(SystemWebChromeClient systemWebChromeClient, Callback callback) {
            this.b = systemWebChromeClient;
            this.a = callback;
        }

        public void invoke(String str, boolean z, boolean z2) {
            this.a.invoke(str, z, z2);
        }
    }

    private class d implements JsPromptResult {
        android.webkit.JsPromptResult a;
        final /* synthetic */ SystemWebChromeClient b;

        d(SystemWebChromeClient systemWebChromeClient, android.webkit.JsPromptResult jsPromptResult) {
            this.b = systemWebChromeClient;
            this.a = jsPromptResult;
        }

        public void cancel() {
            this.a.cancel();
        }

        public void confirm() {
            this.a.confirm();
        }

        public void confirm(String str) {
            this.a.confirm(str);
        }
    }

    private class e implements JsResult {
        android.webkit.JsResult a;
        final /* synthetic */ SystemWebChromeClient b;

        e(SystemWebChromeClient systemWebChromeClient, android.webkit.JsResult jsResult) {
            this.b = systemWebChromeClient;
            this.a = jsResult;
        }

        public void cancel() {
            this.a.cancel();
        }

        public void confirm() {
            this.a.confirm();
        }
    }

    class f implements QuotaUpdater {
        WebStorage.QuotaUpdater a;
        final /* synthetic */ SystemWebChromeClient b;

        f(SystemWebChromeClient systemWebChromeClient, WebStorage.QuotaUpdater quotaUpdater) {
            this.b = systemWebChromeClient;
            this.a = quotaUpdater;
        }

        public void updateQuota(long j) {
            this.a.updateQuota(j);
        }
    }

    SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.a = webView;
        this.b = webChromeClient;
    }

    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        return this.b.getDefaultVideoPoster();
    }

    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.b.getVideoLoadingProgressView();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.b.getVisitedHistory(new z(this, valueCallback));
    }

    public void onCloseWindow(WebView webView) {
        this.a.a(webView);
        this.b.onCloseWindow(this.a);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        this.b.onConsoleMessage(new a(str, str2, i));
    }

    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(new a(consoleMessage));
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = this.a;
        webView2.getClass();
        WebViewTransport webViewTransport = new WebViewTransport(webView2);
        Message obtain = Message.obtain(message.getTarget(), new aa(this, webViewTransport, message));
        obtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.a, z, z2, obtain);
    }

    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new f(this, quotaUpdater));
    }

    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        this.b.onGeolocationPermissionsShowPrompt(str, new c(this, callback));
    }

    @TargetApi(7)
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    public boolean onJsAlert(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.a.a(webView);
        return this.b.onJsAlert(this.a, str, str2, new e(this, jsResult));
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.a.a(webView);
        return this.b.onJsBeforeUnload(this.a, str, str2, new e(this, jsResult));
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.a.a(webView);
        return this.b.onJsConfirm(this.a, str, str2, new e(this, jsResult));
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.a.a(webView);
        return this.b.onJsPrompt(this.a, str, str2, str3, new d(this, jsPromptResult));
    }

    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    public void onProgressChanged(WebView webView, int i) {
        this.a.a(webView);
        this.b.onProgressChanged(this.a, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new f(this, quotaUpdater));
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.a.a(webView);
        this.b.onReceivedIcon(this.a, bitmap);
    }

    public void onReceivedTitle(WebView webView, String str) {
        this.a.a(webView);
        this.b.onReceivedTitle(this.a, str);
    }

    @TargetApi(7)
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        this.a.a(webView);
        this.b.onReceivedTouchIconUrl(this.a, str, z);
    }

    public void onRequestFocus(WebView webView) {
        this.a.a(webView);
        this.b.onRequestFocus(this.a);
    }

    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, new b(this, customViewCallback));
    }

    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, new b(this, customViewCallback));
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        ValueCallback acVar = new ac(this, valueCallback);
        WebChromeClient.FileChooserParams adVar = new ad(this, fileChooserParams);
        this.a.a(webView);
        return this.b.onShowFileChooser(this.a, acVar, adVar);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.b.openFileChooser(new ab(this, valueCallback), str, str2);
    }

    public void setupAutoFill(Message message) {
    }
}
