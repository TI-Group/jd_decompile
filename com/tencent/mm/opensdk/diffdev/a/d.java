package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

public final class d extends AsyncTask<Void, Void, a> {
    private static final boolean ad;
    private static final String ae = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png");
    private static String af;
    private String ag;
    private String ah;
    private OAuthListener ai;
    private f aj;
    private String appId;
    private String scope;
    private String signature;

    static class a {
        public OAuthErrCode ak;
        public String al;
        public String am;
        public String an;
        public int ao;
        public String ap;
        public byte[] aq;

        private a() {
        }

        private static boolean a(String str, byte[] bArr) {
            FileOutputStream fileOutputStream;
            Exception e;
            Throwable th;
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "fout.close() exception:" + e2.getMessage());
                    }
                    Log.d("MicroMsg.SDK.GetQRCodeResult", "writeToFile ok!");
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.w("MicroMsg.SDK.GetQRCodeResult", "write to file error, exception:" + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "fout.close() exception:" + e22.getMessage());
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "fout.close() exception:" + e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
                Log.w("MicroMsg.SDK.GetQRCodeResult", "write to file error, exception:" + e.getMessage());
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }

        public static a c(byte[] bArr) {
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                aVar.ak = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, CommonUtil.UTF8));
                        int i = jSONObject.getInt("errcode");
                        if (i != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                            aVar.ak = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.ao = i;
                            aVar.ap = jSONObject.optString("errmsg");
                        } else {
                            String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                            if (string == null || string.length() == 0) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                                aVar.ak = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            } else {
                                byte[] decode = Base64.decode(string, 0);
                                if (decode == null || decode.length == 0) {
                                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                    aVar.ak = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                                } else if (d.ad) {
                                    File file = new File(d.ae);
                                    file.mkdirs();
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                    if (a(d.ae, decode)) {
                                        aVar.ak = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.an = d.ae;
                                        aVar.al = jSONObject.getString("uuid");
                                        aVar.am = jSONObject.getString("appname");
                                        Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in external storage, uuid = %s, appname = %s, imgPath = %s", new Object[]{aVar.al, aVar.am, aVar.an}));
                                    } else {
                                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("writeToFile fail, qrcodeBuf length = %d", new Object[]{Integer.valueOf(decode.length)}));
                                        aVar.ak = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    }
                                } else {
                                    aVar.ak = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.aq = decode;
                                    aVar.al = jSONObject.getString("uuid");
                                    aVar.am = jSONObject.getString("appname");
                                    Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{aVar.al, aVar.am, Integer.valueOf(aVar.aq.length)}));
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                        aVar.ak = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                    aVar.ak = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            }
            return aVar;
        }
    }

    static {
        boolean z = Environment.getExternalStorageState().equals("mounted") && new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        ad = z;
        af = null;
        af = "http://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.ag = str3;
        this.ah = str4;
        this.signature = str5;
        this.ai = oAuthListener;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "external storage available = " + ad);
        String format = String.format(af, new Object[]{this.appId, this.ag, this.ah, this.scope, this.signature});
        long currentTimeMillis = System.currentTimeMillis();
        byte[] b = e.b(format, -1);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", new Object[]{format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        return a.c(b);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        if (aVar.ak == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
            this.ai.onAuthGotQrcode(aVar.an, aVar.aq);
            this.aj = new f(aVar.al, this.ai);
            f fVar = this.aj;
            if (VERSION.SDK_INT >= 11) {
                fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else {
                fVar.execute(new Void[0]);
                return;
            }
        }
        Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", new Object[]{aVar.ak}));
        this.ai.onAuthFinish(aVar.ak, null);
    }

    public final boolean q() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        return this.aj == null ? cancel(true) : this.aj.cancel(true);
    }
}
