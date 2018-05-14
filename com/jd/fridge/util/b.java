package com.jd.fridge.util;

import android.content.Context;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* compiled from: TbsSdkJava */
public class b extends BaseImageDownloader {
    final HostnameVerifier a = new HostnameVerifier(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    private SSLSocketFactory b = a().getSocketFactory();

    /* compiled from: TbsSdkJava */
    class a implements TrustManager, X509TrustManager {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    }

    public b(Context context) {
        super(context);
    }

    protected InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            url = null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.b);
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.a);
        }
        return new BufferedInputStream(httpURLConnection.getInputStream(), 32768);
    }

    public SSLContext a() {
        NoSuchAlgorithmException e;
        KeyManagementException e2;
        TrustManager[] trustManagerArr = new TrustManager[1];
        SSLContext aVar = new a(this);
        trustManagerArr[0] = aVar;
        try {
            aVar = SSLContext.getInstance("SSL");
            try {
                aVar.init(null, trustManagerArr, null);
                return aVar;
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
            } catch (KeyManagementException e4) {
                e2 = e4;
                e2.printStackTrace();
                return aVar;
            }
        } catch (NoSuchAlgorithmException e5) {
            NoSuchAlgorithmException noSuchAlgorithmException = e5;
            aVar = null;
            e = noSuchAlgorithmException;
            e.printStackTrace();
            return aVar;
        } catch (KeyManagementException e6) {
            KeyManagementException keyManagementException = e6;
            aVar = null;
            e2 = keyManagementException;
            e2.printStackTrace();
            return aVar;
        } catch (Throwable th) {
            return aVar;
        }
    }
}
