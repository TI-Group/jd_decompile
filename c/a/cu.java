package c.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.b.a.a;
import com.b.a.d;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class cu {
    private String a;
    private String b = "10.0.0.172";
    private int c = 80;
    private Context d;
    private cs e;

    public cu(Context context) {
        this.d = context;
        this.a = a(context);
    }

    public void a(cs csVar) {
        this.e = csVar;
    }

    public byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        for (String a : d.b) {
            bArr2 = a(bArr, a);
            if (bArr2 != null) {
                if (this.e != null) {
                    this.e.m();
                }
                return bArr2;
            }
            if (this.e != null) {
                this.e.n();
            }
        }
        return bArr2;
    }

    private boolean a() {
        if (this.d.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.d.getPackageName()) != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.d.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private byte[] a(byte[] bArr, String str) {
        Throwable e;
        HttpURLConnection httpURLConnection;
        try {
            if (this.e != null) {
                this.e.k();
            }
            if (a()) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(this.b, this.c)));
            } else {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            }
            InputStream inputStream;
            try {
                httpURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpURLConnection.setRequestProperty("X-Umeng-Sdk", this.a);
                httpURLConnection.setRequestProperty("Msg-Type", "envelope");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(CommonUtil.POST_TIMEOUT);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setChunkedStreamingMode(0);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                if (this.e != null) {
                    this.e.l();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    Object headerField = httpURLConnection.getHeaderField("Content-Type");
                    if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                        headerField = null;
                    } else {
                        headerField = 1;
                    }
                    as.a("status code: " + responseCode);
                    if (headerField != null) {
                        as.b("Send message to " + str);
                        inputStream = httpURLConnection.getInputStream();
                        byte[] b = ar.b(inputStream);
                        ar.c(inputStream);
                        if (httpURLConnection == null) {
                            return b;
                        }
                        httpURLConnection.disconnect();
                        return b;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                as.d("status code: " + responseCode);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    as.b("IOException,Failed to send message.", e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                ar.c(inputStream);
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            as.b("IOException,Failed to send message.", e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw e;
        }
    }

    private String a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android");
        stringBuffer.append(HttpUtils.PATHS_SEPARATOR);
        stringBuffer.append("5.6.7");
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(aq.q(context));
            stringBuffer2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuffer2.append(aq.b(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(ar.a(a.a(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), HTTP.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
