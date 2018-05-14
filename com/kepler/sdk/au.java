package com.kepler.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class au implements Runnable {
    private String a = "";
    private final String b;

    au(String str, String str2, Context context) {
        this.b = str;
        this.a = str2;
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    URLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "text/xml;charset=GBK");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str.length()));
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(str.getBytes());
        outputStream.flush();
        outputStream.close();
        return httpURLConnection;
    }

    public void run() {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Throwable th;
        URLConnection uRLConnection;
        Throwable th2;
        if (aw.d() != null) {
            String str = this.a + "&_dId=" + aw.d();
            try {
                URLConnection a = a(str);
                try {
                    a.connect();
                    bufferedInputStream = new BufferedInputStream(a.getInputStream());
                } catch (Throwable th3) {
                    bufferedInputStream = null;
                    th = th3;
                    uRLConnection = a;
                    th2 = th;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    ((HttpURLConnection) uRLConnection).disconnect();
                    throw th2;
                }
                try {
                    int read;
                    Object obj;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                    while (true) {
                        read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    }
                    if (a instanceof HttpURLConnection) {
                        read = ((HttpURLConnection) a).getResponseCode();
                        obj = (read < 200 || read >= 300) ? null : 1;
                    } else {
                        read = 1;
                    }
                    if (obj != null) {
                        byteArrayOutputStream.toString(HTTP.UTF_8);
                        if (str.contains("&events=")) {
                            aw.a("kepler_eday");
                        } else if (str.contains("&start=")) {
                            aw.b();
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (a != null && (a instanceof HttpURLConnection)) {
                        ((HttpURLConnection) a).disconnect();
                    }
                } catch (Throwable th32) {
                    th = th32;
                    uRLConnection = a;
                    th2 = th;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable th322) {
                th2 = th322;
                bufferedInputStream = null;
                uRLConnection = null;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                ((HttpURLConnection) uRLConnection).disconnect();
                throw th2;
            }
        }
    }
}
