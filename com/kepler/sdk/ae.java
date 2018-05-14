package com.kepler.sdk;

import android.text.TextUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHeaders;
import org.apache.http.cookie.SM;

/* compiled from: TbsSdkJava */
public class ae {
    private HttpURLConnection a;

    /* compiled from: TbsSdkJava */
    static class a implements HostnameVerifier {
        a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* compiled from: TbsSdkJava */
    static class b implements X509TrustManager {
        b() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public ac a(ab abVar) throws IOException, KeyManagementException, NoSuchAlgorithmException, IllegalAccessException {
        this.a = a(abVar.a(), 0);
        if (!(abVar == null || abVar.d() == null)) {
            this.a.setRequestProperty(SM.COOKIE, abVar.d());
        }
        if (abVar.e() != null) {
            for (Entry entry : abVar.e().entrySet()) {
                this.a.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if ("post".equals(abVar.b())) {
            a(this.a, abVar.c());
        }
        return a(this.a);
    }

    public void a() throws IOException {
        if (this.a != null) {
            this.a.disconnect();
            this.a.getInputStream().close();
            this.a.getOutputStream().close();
        }
    }

    public static File a(String str, File file, String str2, int i) {
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream = null;
        InputStream inputStream3 = null;
        FileOutputStream fileOutputStream2;
        try {
            HttpURLConnection a = a(str, 0);
            a.setConnectTimeout(3000);
            a.setReadTimeout(5000);
            File a2;
            if (a.getResponseCode() == 302 && i >= 0) {
                int i2 = i - 1;
                a2 = a((String) a(a).a(HttpHeaders.LOCATION).get(0), file, str2, i);
                if (null != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                        return a2;
                    }
                }
                if (null == null) {
                    return a2;
                }
                inputStream3.close();
                return a2;
            } else if (a.getResponseCode() != 200) {
                p.b("suwg", "load file back not 200" + a.getResponseCode());
                if (null != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                }
                if (null != null) {
                    inputStream3.close();
                }
                return null;
            } else {
                inputStream = a.getInputStream();
                try {
                    a2 = new File(file, str2);
                    aj.b(a2);
                    fileOutputStream2 = new FileOutputStream(a2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = null;
                    inputStream2 = inputStream;
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (fileOutputStream2 != null) {
                        inputStream2.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.flush();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e3) {
                            return a2;
                        }
                    }
                    if (fileOutputStream2 == null) {
                        return a2;
                    }
                    inputStream.close();
                    return a2;
                } catch (Throwable th3) {
                    th = th3;
                    p.a(th);
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (fileOutputStream2 != null) {
                        inputStream.close();
                    }
                    return null;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            if (fileOutputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    private static HttpURLConnection a(String str, int i) throws KeyManagementException, NoSuchAlgorithmException, IOException, IllegalAccessException {
        if (aq.a(str)) {
            throw new IllegalAccessException("url is request");
        }
        URL url = new URL(str);
        if (TextUtils.isEmpty(str) || !str.startsWith(CommonUtil.URL_HEADER)) {
            return b(url, i);
        }
        return a(url, i);
    }

    private static HttpsURLConnection a(URL url, int i) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{new b()}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new a());
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        if (i > 0) {
            httpsURLConnection.setConnectTimeout(i);
            httpsURLConnection.setReadTimeout(i);
        }
        return httpsURLConnection;
    }

    private static HttpURLConnection b(URL url, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
        }
        return httpURLConnection;
    }

    private static HttpURLConnection a(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        if (bArr != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        }
        return httpURLConnection;
    }

    private static ac a(HttpURLConnection httpURLConnection) throws IOException {
        String str = "";
        int responseCode = httpURLConnection.getResponseCode();
        str = httpURLConnection.getContentEncoding();
        if (aq.a(str)) {
            str = CommonUtil.UTF8;
        }
        return new ac(aq.a(a(httpURLConnection.getInputStream()), str), httpURLConnection.getHeaderFields(), responseCode);
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
