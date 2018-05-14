package cn.jpush.android.api;

import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.e.a.e;

/* compiled from: TbsSdkJava */
public final class c {
    public static e a = null;
    private static int b = 400;
    private static int c = 600;

    public static void a(WindowManager windowManager, WebView webView, ImageButton imageButton) {
        windowManager.removeView(webView);
        windowManager.removeView(imageButton);
    }
}
