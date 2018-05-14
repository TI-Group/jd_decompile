package com.jingdong.jdma.c;

import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

/* compiled from: TbsSdkJava */
public abstract class b {
    protected static final String a = b.class.getName();
    protected URL b;
    protected int c;
    protected int d;
    protected int e;
    protected int f = 2;
    protected String g;
    protected String h;
    protected HashMap<String, Object> i;
    protected HashMap<String, String> j = new HashMap();
    protected HashMap<String, String> k = new HashMap();
    protected boolean l = false;
    protected byte[] m;
    protected String n = CommonUtil.UTF8;
    protected String o = CommonUtil.UTF8;
    protected boolean p = true;
    protected long q = 0;
    protected long r = 0;
    private final String s = "(\\S+.jd.com)|(jd.com)";

    public String b() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public b() {
        i();
    }

    public b(int i, int i2, int i3, String str, String str2, boolean z) {
        a(i, i2, i3, str, str2, z);
        i();
    }

    public void a(int i, int i2, int i3, String str, String str2, boolean z) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.n = str;
        this.o = str2;
        this.p = z;
    }

    public HashMap<String, String> c() {
        return this.k;
    }

    public void a(String str, String str2) {
        this.j.put(str, str2);
    }

    public HashMap<String, String> d() {
        return this.j;
    }

    public void b(String str) {
        this.g = str;
    }

    public void a(String str, Object obj) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.put(str, obj);
    }

    public HashMap<String, Object> e() {
        return this.i;
    }

    public byte[] f() {
        return this.m;
    }

    public HttpURLConnection g() throws Exception {
        if ("".equals(this.g)) {
            throw new IOException(a + "|getConnect|mStrUrl is empty");
        }
        this.b = new URL(this.g);
        if (this.b == null) {
            throw new IOException(a + "|getConnect|mUrl is empty");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.b.openConnection();
        if (httpURLConnection != null) {
            return httpURLConnection;
        }
        throw new IOException(a + "|getConnect|mConn is empty");
    }

    private void i() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public boolean verify(String str, SSLSession sSLSession) {
                    if (str.matches("(\\S+.jd.com)|(jd.com)")) {
                        return true;
                    }
                    return false;
                }
            });
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new X509TrustManager[]{new X509TrustManager(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String h() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        HashMap e = e();
        if (e == null) {
            return "";
        }
        String str = "";
        for (Entry entry : e.entrySet()) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            String valueOf = value == null ? "" : String.valueOf(value);
            stringBuffer.append(str);
            stringBuffer.append(URLEncoder.encode(str2, this.n));
            stringBuffer.append(HttpUtils.EQUAL_SIGN);
            stringBuffer.append(URLEncoder.encode(valueOf, this.n));
            str = HttpUtils.PARAMETERS_SEPARATOR;
        }
        return stringBuffer.toString();
    }

    protected void a(HttpURLConnection httpURLConnection, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        a(httpURLConnection);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        if (toByteArray == null || toByteArray.length == 0) {
            this.m = null;
            return;
        }
        byte[] bArr;
        HashMap c = c();
        if (c != null) {
            String str = (String) c.get("content-encoding");
            if (str != null && str.contains("gzip")) {
                InputStream byteArrayInputStream = new ByteArrayInputStream(toByteArray);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                }
                gZIPInputStream.close();
                bArr = byteArrayOutputStream2.toByteArray();
                this.m = bArr;
            }
        }
        bArr = toByteArray;
        this.m = bArr;
    }

    protected void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.getLastModified();
        Map headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (Entry entry : headerFields.entrySet()) {
                int i = 0;
                String str = "";
                for (String str2 : (List) entry.getValue()) {
                    if (i > 0) {
                        str = str + "<--->";
                    }
                    str = str + str2;
                    i++;
                }
                this.k.put(String.valueOf(entry.getKey()).toLowerCase(Locale.getDefault()), str);
            }
        }
    }

    public int a() {
        return -1;
    }
}
