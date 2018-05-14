package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MusicObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.d.c;
import com.sina.weibo.sdk.d.e;
import com.sina.weibo.sdk.d.j;
import com.sina.weibo.sdk.net.f;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class g extends e {
    private b e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private com.sina.weibo.sdk.api.share.b k;
    private String l;
    private byte[] m;

    /* compiled from: TbsSdkJava */
    public static class a {
        private int a = -2;
        private String b;

        private a() {
        }

        public int a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.a = jSONObject.optInt("code", -2);
                aVar.b = jSONObject.optString("data", "");
                return aVar;
            } catch (JSONException e) {
                return aVar;
            }
        }
    }

    public g(Context context) {
        super(context);
        this.c = c.SHARE;
    }

    protected void a(Bundle bundle) {
        this.i = bundle.getString(SocialConstants.PARAM_SOURCE);
        this.g = bundle.getString("packagename");
        this.j = bundle.getString("key_hash");
        this.h = bundle.getString(Constants.PARAM_ACCESS_TOKEN);
        this.f = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.f)) {
            this.e = i.a(this.a).a(this.f);
        }
        d(bundle);
        this.b = c("");
    }

    private void d(Bundle bundle) {
        com.sina.weibo.sdk.api.a aVar = new com.sina.weibo.sdk.api.a();
        aVar.a(bundle);
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.a instanceof TextObject) {
            stringBuilder.append(aVar.a.g);
        }
        if (aVar.b instanceof ImageObject) {
            ImageObject imageObject = aVar.b;
            a(imageObject.h, imageObject.g);
        }
        if (aVar.c instanceof TextObject) {
            stringBuilder.append(((TextObject) aVar.c).g);
        }
        if (aVar.c instanceof ImageObject) {
            imageObject = (ImageObject) aVar.c;
            a(imageObject.h, imageObject.g);
        }
        if (aVar.c instanceof WebpageObject) {
            stringBuilder.append(" ").append(((WebpageObject) aVar.c).a);
        }
        if (aVar.c instanceof MusicObject) {
            stringBuilder.append(" ").append(((MusicObject) aVar.c).a);
        }
        if (aVar.c instanceof VideoObject) {
            stringBuilder.append(" ").append(((VideoObject) aVar.c).a);
        }
        if (aVar.c instanceof VoiceObject) {
            stringBuilder.append(" ").append(((VoiceObject) aVar.c).a);
        }
        this.l = stringBuilder.toString();
    }

    private void a(String str, byte[] bArr) {
        Throwable th;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[((int) file.length())];
                    FileInputStream fileInputStream = null;
                    FileInputStream fileInputStream2;
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        try {
                            fileInputStream2.read(bArr2);
                            this.m = c.b(bArr2);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            return;
                        } catch (IOException e2) {
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            if (bArr != null) {
                            }
                            return;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileInputStream = fileInputStream2;
                            th = th3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (bArr != null) {
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (SecurityException e6) {
        }
        if (bArr != null && bArr.length > 0) {
            this.m = c.b(bArr);
        }
    }

    public void b(Bundle bundle) {
        if (this.k != null) {
            this.k.a(bundle);
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.j = e.a(j.a(this.a, this.g));
        }
        bundle.putString(Constants.PARAM_ACCESS_TOKEN, this.h);
        bundle.putString(SocialConstants.PARAM_SOURCE, this.i);
        bundle.putString("packagename", this.g);
        bundle.putString("key_hash", this.j);
        bundle.putString("_weibo_appPackage", this.g);
        bundle.putString("_weibo_appKey", this.i);
        bundle.putInt("_weibo_flag", 538116905);
        bundle.putString("_weibo_sign", this.j);
        if (this.e != null) {
            i a = i.a(this.a);
            this.f = a.a();
            a.a(this.f, this.e);
            bundle.putString("key_listener", this.f);
        }
    }

    public void a(Activity activity, int i) {
        if (i == 3) {
            a(activity);
            WeiboSdkBrowser.a(activity, this.f, null);
        }
    }

    public boolean a() {
        if (this.m == null || this.m.length <= 0) {
            return false;
        }
        return true;
    }

    public f a(f fVar) {
        if (a()) {
            fVar.a(SocialConstants.PARAM_IMG_URL, new String(this.m));
        }
        return fVar;
    }

    public String c(String str) {
        Builder buildUpon = Uri.parse("http://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.l);
        buildUpon.appendQueryParameter("version", "0031205000");
        if (!TextUtils.isEmpty(this.i)) {
            buildUpon.appendQueryParameter(SocialConstants.PARAM_SOURCE, this.i);
        }
        if (!TextUtils.isEmpty(this.h)) {
            buildUpon.appendQueryParameter(Constants.PARAM_ACCESS_TOKEN, this.h);
        }
        Object b = j.b(this.a, this.i);
        if (!TextUtils.isEmpty(b)) {
            buildUpon.appendQueryParameter(DeviceInfo.TAG_ANDROID_ID, b);
        }
        if (!TextUtils.isEmpty(this.g)) {
            buildUpon.appendQueryParameter("packagename", this.g);
        }
        if (!TextUtils.isEmpty(this.j)) {
            buildUpon.appendQueryParameter("key_hash", this.j);
        }
        if (!TextUtils.isEmpty(str)) {
            buildUpon.appendQueryParameter("picinfo", str);
        }
        return buildUpon.build().toString();
    }

    private void a(Activity activity, int i, String str) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
            intent.setFlags(131072);
            intent.setPackage(extras.getString("_weibo_appPackage"));
            intent.putExtras(extras);
            intent.putExtra("_weibo_appPackage", activity.getPackageName());
            intent.putExtra("_weibo_resp_errcode", i);
            intent.putExtra("_weibo_resp_errstr", str);
            try {
                activity.startActivityForResult(intent, 765);
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    public void a(Activity activity) {
        a(activity, 1, "send cancel!!!");
    }

    public void b(Activity activity) {
        a(activity, 0, "send ok!!!");
    }

    public void a(Activity activity, String str) {
        a(activity, 2, str);
    }

    public String b() {
        return this.i;
    }

    public b c() {
        return this.e;
    }

    public String h() {
        return this.f;
    }
}
