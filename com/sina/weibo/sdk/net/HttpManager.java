package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.webkit.URLUtil;
import cn.jiguang.net.HttpUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.d.d;
import com.sina.weibo.sdk.d.f;
import com.sina.weibo.sdk.d.j;
import com.tencent.connect.common.Constants;
import com.tencent.stat.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class HttpManager {
    private static final String a = b();
    private static final String b = ("--" + a);
    private static final String c = ("--" + a + "--");
    private static SSLSocketFactory d;

    private static native String calcOauthSignNative(Context context, String str, String str2);

    static {
        System.loadLibrary("weibosdkcore");
    }

    public static String a(Context context, String str, String str2, f fVar) throws b {
        String a = a(c(context, str, str2, fVar));
        d.a("HttpManager", "Response : " + a);
        return a;
    }

    private static HttpResponse c(Context context, String str, String str2, f fVar) {
        HttpClient a;
        OutputStream outputStream;
        Throwable e;
        HttpClient httpClient;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            a = a();
            try {
                HttpUriRequest httpGet;
                a.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, NetStateManager.a());
                a(context, fVar);
                if (str2.equals("GET")) {
                    String stringBuilder = new StringBuilder(String.valueOf(str)).append(HttpUtils.URL_AND_PARA_SEPARATOR).append(fVar.c()).toString();
                    httpGet = new HttpGet(stringBuilder);
                    d.a("HttpManager", "requestHttpExecute GET Url : " + stringBuilder);
                } else if (str2.equals("POST")) {
                    d.a("HttpManager", "requestHttpExecute POST Url : " + str);
                    HttpPost httpPost = new HttpPost(str);
                    OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        Object a2;
                        if (fVar.d()) {
                            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + a);
                            a(byteArrayOutputStream2, fVar);
                        } else {
                            a2 = fVar.a("content-type");
                            if (a2 == null || !(a2 instanceof String)) {
                                httpPost.setHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                            } else {
                                fVar.b("content-type");
                                httpPost.setHeader("Content-Type", (String) a2);
                            }
                            String c = fVar.c();
                            d.a("HttpManager", "requestHttpExecute POST postParam : " + c);
                            byteArrayOutputStream2.write(c.getBytes(HTTP.UTF_8));
                        }
                        httpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream2.toByteArray()));
                        a2 = httpPost;
                        outputStream = byteArrayOutputStream2;
                    } catch (IOException e2) {
                        e = e2;
                        outputStream = byteArrayOutputStream2;
                        httpClient = a;
                        try {
                            e.printStackTrace();
                            throw new b(e);
                        } catch (Throwable th) {
                            e = th;
                            a = httpClient;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            a(a);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        outputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        a(a);
                        throw e;
                    }
                } else if (str2.equals(HttpDelete.METHOD_NAME)) {
                    httpGet = new HttpDelete(str);
                } else {
                    httpGet = null;
                }
                HttpResponse execute = a.execute(httpGet);
                int statusCode = execute.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    throw new c(a(execute), statusCode);
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                a(a);
                return execute;
            } catch (IOException e5) {
                e = e5;
                httpClient = a;
                e.printStackTrace();
                throw new b(e);
            } catch (Throwable th3) {
                e = th3;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                a(a);
                throw e;
            }
        } catch (IOException e6) {
            e = e6;
            Object obj = null;
            e.printStackTrace();
            throw new b(e);
        } catch (Throwable th4) {
            e = th4;
            a = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            a(a);
            throw e;
        }
    }

    private static void a(Context context, f fVar) {
        String str = "";
        if (!TextUtils.isEmpty(fVar.a())) {
            str = j.b(context, fVar.a());
            if (!TextUtils.isEmpty(str)) {
                fVar.a(DeviceInfo.TAG_ANDROID_ID, str);
            }
        }
        String str2 = str;
        String d = d();
        fVar.a("oauth_timestamp", d);
        String str3 = "";
        Object a = fVar.a(Constants.PARAM_ACCESS_TOKEN);
        Object a2 = fVar.a("refresh_token");
        Object a3 = fVar.a("phone");
        str = (a == null || !(a instanceof String)) ? (a2 == null || !(a2 instanceof String)) ? (a3 == null || !(a3 instanceof String)) ? str3 : (String) a3 : (String) a2 : (String) a;
        fVar.a("oauth_sign", a(context, str2, str, fVar.a(), d));
    }

    public static void a(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().closeExpiredConnections();
            } catch (Exception e) {
            }
        }
    }

    public static String b(Context context, String str, String str2, f fVar) {
        Throwable th;
        Throwable th2;
        HttpClient httpClient = null;
        try {
            Object anonymousClass1 = new b() {
                public boolean a(String str) {
                    return true;
                }

                public void a() {
                }
            };
            HttpClient httpClient2 = (DefaultHttpClient) a();
            try {
                HttpUriRequest httpGet;
                httpClient2.setRedirectHandler(anonymousClass1);
                a(context, fVar);
                httpClient2.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, NetStateManager.a());
                if (str2.equals("GET")) {
                    httpGet = new HttpGet(new StringBuilder(String.valueOf(str)).append(HttpUtils.URL_AND_PARA_SEPARATOR).append(fVar.c()).toString());
                } else if (str2.equals("POST")) {
                    httpGet = new HttpPost(str);
                }
                httpGet.setHeader("User-Agent", f.e(context));
                httpClient2.execute(httpGet);
                String b = anonymousClass1.b();
                a(httpClient2);
                return b;
            } catch (Throwable e) {
                th = e;
                httpClient = httpClient2;
                th2 = th;
                try {
                    throw new b(th2);
                } catch (Throwable th3) {
                    th2 = th3;
                    a(httpClient);
                    throw th2;
                }
            } catch (Throwable e2) {
                th = e2;
                httpClient = httpClient2;
                th2 = th;
                a(httpClient);
                throw th2;
            }
        } catch (IOException e3) {
            th2 = e3;
            throw new b(th2);
        }
    }

    public static synchronized String a(Context context, String str, String str2, String str3) throws b {
        String path;
        synchronized (HttpManager.class) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (file2.exists()) {
                path = file2.getPath();
            } else if (URLUtil.isValidUrl(str)) {
                r8 = a();
                long j = 0;
                File file3 = new File(str2, new StringBuilder(String.valueOf(str3)).append("_temp").toString());
                try {
                    long parseLong;
                    long j2;
                    InputStream content;
                    if (file3.exists()) {
                        j = file3.length();
                    } else {
                        file3.createNewFile();
                    }
                    HttpUriRequest httpGet = new HttpGet(str);
                    httpGet.setHeader("RANGE", "bytes=" + j + "-");
                    HttpResponse execute = r8.execute(httpGet);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    if (statusCode == 206) {
                        Header[] headers = execute.getHeaders(HttpHeaders.CONTENT_RANGE);
                        if (!(headers == null || headers.length == 0)) {
                            String value = headers[0].getValue();
                            parseLong = Long.parseLong(value.substring(value.indexOf(47) + 1));
                            j2 = j;
                        }
                        parseLong = 0;
                        j2 = j;
                    } else if (statusCode == 200) {
                        j = 0;
                        Header firstHeader = execute.getFirstHeader("Content-Length");
                        if (firstHeader != null) {
                            parseLong = (long) Integer.valueOf(firstHeader.getValue()).intValue();
                            j2 = 0;
                        }
                        parseLong = 0;
                        j2 = j;
                    } else {
                        throw new c(a(execute), statusCode);
                    }
                    HttpEntity entity = execute.getEntity();
                    Header firstHeader2 = execute.getFirstHeader("Content-Encoding");
                    if (firstHeader2 == null || firstHeader2.getValue().toLowerCase().indexOf("gzip") <= -1) {
                        content = entity.getContent();
                    } else {
                        content = new GZIPInputStream(entity.getContent());
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(j2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    content.close();
                    if (parseLong == 0 || file3.length() < parseLong) {
                        file3.delete();
                        if (r8 != null) {
                            r8.getConnectionManager().closeExpiredConnections();
                            r8.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                        }
                        path = "";
                    } else {
                        file3.renameTo(file2);
                        path = file2.getPath();
                        if (r8 != null) {
                            r8.getConnectionManager().closeExpiredConnections();
                            r8.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    file3.delete();
                    if (r8 != null) {
                        r8.getConnectionManager().closeExpiredConnections();
                        r8.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                    }
                } catch (Throwable th) {
                    HttpClient a;
                    if (a != null) {
                        a.getConnectionManager().closeExpiredConnections();
                        a.getConnectionManager().closeIdleConnections(300, TimeUnit.SECONDS);
                    }
                }
            } else {
                path = "";
            }
        }
        return path;
    }

    public static HttpClient a() {
        try {
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, HTTP.UTF_8);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", c(), 443));
            ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 25000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            return new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public static void a(OutputStream outputStream, f fVar) throws b {
        try {
            StringBuilder stringBuilder;
            Set<String> b = fVar.b();
            for (String str : b) {
                if (fVar.a(str) instanceof String) {
                    stringBuilder = new StringBuilder(100);
                    stringBuilder.setLength(0);
                    stringBuilder.append(b).append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"").append(str).append("\"\r\n\r\n");
                    stringBuilder.append(fVar.a(str)).append("\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                }
            }
            for (String str2 : b) {
                Object a = fVar.a(str2);
                if (a instanceof Bitmap) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(b).append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    Bitmap bitmap = (Bitmap) a;
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (a instanceof ByteArrayOutputStream) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(b).append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"").append(str2).append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) a;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write(("\r\n" + c).getBytes());
        } catch (Throwable e) {
            throw new b(e);
        }
    }

    public static String a(HttpResponse httpResponse) throws b {
        Throwable e;
        Throwable th;
        String str = null;
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream content;
            try {
                content = entity.getContent();
                try {
                    Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
                    if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf("gzip") > -1) {
                        content = new GZIPInputStream(content);
                    }
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), HTTP.UTF_8);
                    d.a("HttpManager", "readRsponse result : " + str);
                    if (content != null) {
                        try {
                            content.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable e4) {
                th = e4;
                content = null;
                e = th;
                try {
                    throw new b(e);
                } catch (Throwable th2) {
                    e = th2;
                    if (content != null) {
                        try {
                            content.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (Throwable e42) {
                th = e42;
                content = null;
                e = th;
                if (content != null) {
                    content.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw e;
            }
        }
        return str;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            if (currentTimeMillis % 3 == 0) {
                stringBuffer.append(((char) ((int) currentTimeMillis)) % 9);
            } else if (currentTimeMillis % 3 == 1) {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 65)));
            } else {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 97)));
            }
        }
        return stringBuffer.toString();
    }

    private static SSLSocketFactory c() {
        if (d == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                Certificate a = a("cacert_cn.cer");
                Certificate a2 = a("cacert_com.cer");
                instance.setCertificateEntry("cnca", a);
                instance.setCertificateEntry("comca", a2);
                d = new e(instance);
                d.a("HttpManager", "getSSLSocketFactory noraml !!!!!");
            } catch (Exception e) {
                e.printStackTrace();
                d = SSLSocketFactory.getSocketFactory();
                d.a("HttpManager", "getSSLSocketFactory error default !!!!!");
            }
        }
        return d;
    }

    private static Certificate a(String str) throws CertificateException, IOException {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        InputStream resourceAsStream = HttpManager.class.getResourceAsStream(str);
        try {
            Certificate generateCertificate = instance.generateCertificate(resourceAsStream);
            return generateCertificate;
        } finally {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        }
    }

    private static String d() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    private static String a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(str3);
        }
        return calcOauthSignNative(context, stringBuilder.toString(), str4);
    }
}
