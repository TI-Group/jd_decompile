package com.jd.fridge.util;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import org.apache.commons.lang.StringUtils;

/* compiled from: TbsSdkJava */
public class t implements Callback {
    private Handler a = null;
    private Context b;

    public t(Context context) {
        this.b = context;
        a();
    }

    private void a() {
        this.a = new Handler(this);
    }

    public void a(String str) {
        if (StringUtils.isNotBlank(str)) {
            k.a("CUSTOM_MSG=----=" + str);
            this.a.obtainMessage(10, str).sendToTarget();
        }
    }

    public void a(int i) {
        this.a.sendEmptyMessage(i);
    }

    public boolean handleMessage(Message message) {
        String str;
        switch (message.what) {
            case 1:
                str = "服务器开小差啦，请稍等一下";
                break;
            case 2:
                str = "网络断了哦，请检查网络设置";
                break;
            case 10:
                str = (String) message.obj;
                break;
            default:
                str = "服务器开小差啦，请稍等一下";
                break;
        }
        if (this.a != null) {
            this.a.post(new Runnable(this) {
                final /* synthetic */ t b;

                public void run() {
                    x.a(this.b.b, str);
                }
            });
        }
        return false;
    }
}
