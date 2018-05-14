package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import cn.jiguang.net.HttpUtils;
import com.android.volley.RequestQueue;
import java.io.File;

/* compiled from: TbsSdkJava */
public class Volley {
    private static final String DEFAULT_CACHE_DIR = "volley";

    public static RequestQueue newRequestQueue(Context context, HttpStack httpStack) {
        File file = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + HttpUtils.PATHS_SEPARATOR + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (httpStack == null) {
            if (VERSION.SDK_INT >= 9) {
                httpStack = new HurlStack();
            } else {
                httpStack = new HttpClientStack(AndroidHttpClient.newInstance(str));
            }
        }
        RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file), new BasicNetwork(httpStack));
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
}
