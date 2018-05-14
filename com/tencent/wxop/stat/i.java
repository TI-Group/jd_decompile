package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.a.a.a.a.g;
import com.tencent.a.a.a.a.h;
import com.tencent.stat.DeviceInfo;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.f;
import com.tencent.wxop.stat.common.l;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class i {
    private static StatLogger d = l.b();
    private static i e = null;
    private static Context f = null;
    DefaultHttpClient a = null;
    e b = null;
    StringBuilder c = new StringBuilder(4096);
    private long g = 0;

    private i(Context context) {
        try {
            f = context.getApplicationContext();
            this.g = System.currentTimeMillis() / 1000;
            this.b = new e();
            if (StatConfig.isDebugEnable()) {
                try {
                    Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                    Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                    System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                    System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                    System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                    System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
                } catch (Throwable th) {
                }
            }
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.a = new DefaultHttpClient(basicHttpParams);
            this.a.setKeepAliveStrategy(new j(this));
        } catch (Throwable th2) {
            d.e(th2);
        }
    }

    static Context a() {
        return f;
    }

    static void a(Context context) {
        f = context.getApplicationContext();
    }

    private void a(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(DeviceInfo.TAG_MID);
            if (h.c(optString)) {
                if (StatConfig.isDebugEnable()) {
                    d.i("update mid:" + optString);
                }
                g.C(f).a(optString);
            }
            if (!jSONObject.isNull("cfg")) {
                StatConfig.a(f, jSONObject.getJSONObject("cfg"));
            }
            if (!jSONObject.isNull("ncts")) {
                int i = jSONObject.getInt("ncts");
                int currentTimeMillis = (int) (((long) i) - (System.currentTimeMillis() / 1000));
                if (StatConfig.isDebugEnable()) {
                    d.i("server time:" + i + ", diff time:" + currentTimeMillis);
                }
                l.x(f);
                l.a(f, currentTimeMillis);
            }
        } catch (Throwable th) {
            d.w(th);
        }
    }

    static i b(Context context) {
        if (e == null) {
            synchronized (i.class) {
                if (e == null) {
                    e = new i(context);
                }
            }
        }
        return e;
    }

    void a(com.tencent.wxop.stat.event.e eVar, h hVar) {
        b(Arrays.asList(new String[]{eVar.g()}), hVar);
    }

    void a(List<?> list, h hVar) {
        int i = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            list.get(0);
            Throwable th;
            try {
                String str;
                this.c.delete(0, this.c.length());
                this.c.append("[");
                String str2 = "rc4";
                for (int i2 = 0; i2 < size; i2++) {
                    this.c.append(list.get(i2).toString());
                    if (i2 != size - 1) {
                        this.c.append(",");
                    }
                }
                this.c.append("]");
                String stringBuilder = this.c.toString();
                size = stringBuilder.length();
                String str3 = StatConfig.getStatReportUrl() + "/?index=" + this.g;
                this.g++;
                if (StatConfig.isDebugEnable()) {
                    d.i("[" + str3 + "]Send request(" + size + "bytes), content:" + stringBuilder);
                }
                HttpPost httpPost = new HttpPost(str3);
                httpPost.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
                httpPost.setHeader("Connection", HTTP.CONN_KEEP_ALIVE);
                httpPost.removeHeaders(HttpHeaders.CACHE_CONTROL);
                HttpHost a = a.a(f).a();
                httpPost.addHeader("Content-Encoding", str2);
                if (a == null) {
                    this.a.getParams().removeParameter(ConnRoutePNames.DEFAULT_PROXY);
                } else {
                    if (StatConfig.isDebugEnable()) {
                        d.d("proxy:" + a.toHostString());
                    }
                    httpPost.addHeader("X-Content-Encoding", str2);
                    this.a.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, a);
                    httpPost.addHeader("X-Online-Host", StatConfig.k);
                    httpPost.addHeader(HttpHeaders.ACCEPT, "*/*");
                    httpPost.addHeader("Content-Type", "json");
                }
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                byte[] bytes = stringBuilder.getBytes(HTTP.UTF_8);
                int length = bytes.length;
                if (size > StatConfig.o) {
                    i = 1;
                }
                if (i != 0) {
                    httpPost.removeHeaders("Content-Encoding");
                    str = str2 + ",gzip";
                    httpPost.addHeader("Content-Encoding", str);
                    if (a != null) {
                        httpPost.removeHeaders("X-Content-Encoding");
                        httpPost.addHeader("X-Content-Encoding", str);
                    }
                    byteArrayOutputStream.write(new byte[4]);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                    if (StatConfig.isDebugEnable()) {
                        d.d("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
                    }
                }
                httpPost.setEntity(new ByteArrayEntity(f.a(bytes)));
                HttpResponse execute = this.a.execute((HttpUriRequest) httpPost);
                HttpEntity entity = execute.getEntity();
                size = execute.getStatusLine().getStatusCode();
                long contentLength = entity.getContentLength();
                if (StatConfig.isDebugEnable()) {
                    d.i("http recv response status code:" + size + ", content length:" + contentLength);
                }
                if (contentLength <= 0) {
                    d.e((Object) "Server response no data.");
                    if (hVar != null) {
                        hVar.b();
                    }
                    EntityUtils.toString(entity);
                    return;
                }
                if (contentLength > 0) {
                    InputStream content = entity.getContent();
                    DataInputStream dataInputStream = new DataInputStream(content);
                    bytes = new byte[((int) entity.getContentLength())];
                    dataInputStream.readFully(bytes);
                    content.close();
                    dataInputStream.close();
                    Header firstHeader = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null) {
                        if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                            bytes = f.b(l.a(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                            bytes = l.a(f.b(bytes));
                        } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                            bytes = l.a(bytes);
                        } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                            bytes = f.b(bytes);
                        }
                    }
                    str = new String(bytes, HTTP.UTF_8);
                    if (StatConfig.isDebugEnable()) {
                        d.i("http get response data:" + str);
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (size == 200) {
                        a(jSONObject);
                        if (hVar != null) {
                            if (jSONObject.optInt("ret") == 0) {
                                hVar.a();
                            } else {
                                d.error((Object) "response error data.");
                                hVar.b();
                            }
                        }
                    } else {
                        d.error("Server response error code:" + size + ", error:" + new String(bytes, HTTP.UTF_8));
                        if (hVar != null) {
                            hVar.b();
                        }
                    }
                    content.close();
                } else {
                    EntityUtils.toString(entity);
                }
                byteArrayOutputStream.close();
                th = null;
                if (th != null) {
                    d.error(th);
                    if (hVar != null) {
                        try {
                            hVar.b();
                        } catch (Throwable th2) {
                            d.e(th2);
                        }
                    }
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        this.c = null;
                        this.c = new StringBuilder(2048);
                    }
                    a.a(f).d();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    void b(List<?> list, h hVar) {
        if (this.b != null) {
            this.b.a(new k(this, list, hVar));
        }
    }
}
