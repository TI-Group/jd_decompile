package cn.jiguang.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import cn.jiguang.c.d;
import cn.jiguang.e.g;
import cn.jiguang.e.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;

public class HttpUtils {
    public static final String ENCODING_UTF_8;
    public static final String EQUAL_SIGN = "=";
    public static final String HTTP_DEFUALT_PROXY;
    public static final String PARAMETERS_SEPARATOR = "&";
    public static final String PATHS_SEPARATOR = "/";
    public static final String URL_AND_PARA_SEPARATOR = "?";
    public static boolean a = true;
    private static SSLContext b = null;
    private static TrustManager c = null;
    private static boolean d;
    private static final SimpleDateFormat e = new SimpleDateFormat(z[31], Locale.ENGLISH);
    private static final String[] z;

    public abstract class HttpListener {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 32;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "].\u00054B\\0\u001a3^";
        r0 = 31;
        r4 = r3;
    L_0x000a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x003c;
    L_0x0013:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0018:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x01a5;
            case 1: goto L_0x01a9;
            case 2: goto L_0x01ad;
            case 3: goto L_0x01b1;
            default: goto L_0x001f;
        };
    L_0x001f:
        r9 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
    L_0x0021:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x003a;
    L_0x0029:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0018;
    L_0x002d:
        HTTP_DEFUALT_PROXY = r1;
        r1 = "9Jm)T";
        r0 = 32;
        goto L_0x000a;
    L_0x0034:
        ENCODING_UTF_8 = r1;
        r1 = "\rpOv\u0003\u0005z\u0005t\t\u001esBw\u001f\u0005qE*-/]nW?3PnP;#L`[?8_A";
        r0 = -1;
        goto L_0x000a;
    L_0x003a:
        r5 = r1;
        r1 = r7;
    L_0x003c:
        if (r5 > r6) goto L_0x0013;
    L_0x003e:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0052;
            case 1: goto L_0x005a;
            case 2: goto L_0x0062;
            case 3: goto L_0x006a;
            case 4: goto L_0x0072;
            case 5: goto L_0x007a;
            case 6: goto L_0x0082;
            case 7: goto L_0x008b;
            case 8: goto L_0x0096;
            case 9: goto L_0x00a1;
            case 10: goto L_0x00ac;
            case 11: goto L_0x00b7;
            case 12: goto L_0x00c2;
            case 13: goto L_0x00cd;
            case 14: goto L_0x00d8;
            case 15: goto L_0x00e3;
            case 16: goto L_0x00ee;
            case 17: goto L_0x00f9;
            case 18: goto L_0x0104;
            case 19: goto L_0x010f;
            case 20: goto L_0x011a;
            case 21: goto L_0x0125;
            case 22: goto L_0x0130;
            case 23: goto L_0x013b;
            case 24: goto L_0x0146;
            case 25: goto L_0x0151;
            case 26: goto L_0x015c;
            case 27: goto L_0x0167;
            case 28: goto L_0x0172;
            case 29: goto L_0x017d;
            case 30: goto L_0x0188;
            case 31: goto L_0x002d;
            case 32: goto L_0x0034;
            default: goto L_0x004a;
        };
    L_0x004a:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0019pBs\r\u001c";
        r0 = 0;
        r3 = r4;
        goto L_0x000a;
    L_0x0052:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u000fqEj\t\u000fjBr\u0005\u0018g";
        r0 = 1;
        r3 = r4;
        goto L_0x000a;
    L_0x005a:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u000fs\\e\u001c";
        r0 = 2;
        r3 = r4;
        goto L_0x000a;
    L_0x0062:
        r3[r2] = r1;
        r2 = 4;
        r1 = "_y\\e\u001c";
        r0 = 3;
        r3 = r4;
        goto L_0x000a;
    L_0x006a:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0004j_t\u001fV1\u0004";
        r0 = 4;
        r3 = r4;
        goto L_0x000a;
    L_0x0072:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0004j_tL\u001cqXpL%Qn|\u000f\tn_m\u0003\u0002>Nv\u001e\u0003l\u0011";
        r0 = 5;
        r3 = r4;
        goto L_0x000a;
    L_0x007a:
        r3[r2] = r1;
        r2 = 7;
        r1 = "缽绂锲诫";
        r0 = 6;
        r3 = r4;
        goto L_0x000a;
    L_0x0082:
        r3[r2] = r1;
        r2 = 8;
        r1 = "垳吓旋敌";
        r0 = 7;
        r3 = r4;
        goto L_0x000a;
    L_0x008b:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0004j_tL\u001cqXpLL{Yv\u0003\u001e$";
        r0 = 8;
        r3 = r4;
        goto L_0x000a;
    L_0x0096:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0004j_tL\u001cqXpL)fHa\u001c\u0018wDjL\tlYk\u001eV";
        r0 = 9;
        r3 = r4;
        goto L_0x000a;
    L_0x00a1:
        r3[r2] = r1;
        r2 = 11;
        r1 = "$j_t9\u0018wGw";
        r0 = 10;
        r3 = r4;
        goto L_0x000a;
    L_0x00ac:
        r3[r2] = r1;
        r2 = 12;
        r1 = "?jJg\u0007#hNv\n\u0000q\\A\u001e\u001eqY";
        r0 = 11;
        r3 = r4;
        goto L_0x000a;
    L_0x00b7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "讛汜趮旲";
        r0 = 12;
        r3 = r4;
        goto L_0x000a;
    L_0x00c2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "!Gb\u0003\u001esN`9>Rn|\u000f\tn_m\u0003\u0002";
        r0 = 13;
        r3 = r4;
        goto L_0x000a;
    L_0x00cd:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\b{Me\u0019\u0000j\u000bw\u001f\u0000>Me\u0005\u0000{O(\u001b\u0005rG$\u0019\u001f{\u000bl\u0018\u0018n\u000bt\u0003\u001fj\u000bk\u0002\u000f{";
        r0 = 14;
        r3 = r4;
        goto L_0x000a;
    L_0x00d8:
        r3[r2] = r1;
        r2 = 16;
        r1 = "9P`j\u0003\u001b>N|\t\u000fn_m\u0003\u0002";
        r0 = 15;
        r3 = r4;
        goto L_0x000a;
    L_0x00e3:
        r3[r2] = r1;
        r2 = 17;
        r1 = "?Mg夵赉";
        r0 = 16;
        r3 = r4;
        goto L_0x000a;
    L_0x00ee:
        r3[r2] = r1;
        r2 = 18;
        r1 = "<QxP";
        r0 = 17;
        r3 = r4;
        goto L_0x000a;
    L_0x00f9:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u000fHl\tA}Dj\u0018\u001eqG";
        r0 = 18;
        r3 = r4;
        goto L_0x000a;
    L_0x0104:
        r3[r2] = r1;
        r2 = 20;
        r1 = "/Hl\tA]Dj\u0018\u001eqG";
        r0 = 19;
        r3 = r4;
        goto L_0x000a;
    L_0x010f:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\tf[m\u001e\tm";
        r0 = 20;
        r3 = r4;
        goto L_0x000a;
    L_0x011a:
        r3[r2] = r1;
        r2 = 22;
        r1 = ")f[m\u001e\tm";
        r0 = 21;
        r3 = r4;
        goto L_0x000a;
    L_0x0125:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\b{Me\u0019\u0000j\u000bw\u001f\u0000>Me\u0005\u0000{O(\u001b\u0005rG$\u0019\u001f{\u000bl\u0018\u0018n\u000bc\t\u0018>Dj\u000f\t";
        r0 = 22;
        r3 = r4;
        goto L_0x000a;
    L_0x0130:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u0004j_t\u001f";
        r0 = 23;
        r3 = r4;
        goto L_0x000a;
    L_0x013b:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\u0004j_t";
        r0 = 24;
        r3 = r4;
        goto L_0x000a;
    L_0x0146:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\nwMh\t\u001eV_p\u001c\u001fJDL\u0018\u0018n\u000ba\u001e\u001eqY>";
        r0 = 25;
        r3 = r4;
        goto L_0x000a;
    L_0x0151:
        r3[r2] = r1;
        r2 = 27;
        r1 = "'{RI\r\u0002La\u0001\tp_A\u0014\u000f{[p\u0005\u0003p\u000ba\u001e\u001eqY>";
        r0 = 26;
        r3 = r4;
        goto L_0x000a;
    L_0x015c:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\u000flNe\u0018\tMxH/\u0003pEa\u000f\u0018wDjL\tlYk\u001eV";
        r0 = 27;
        r3 = r4;
        goto L_0x000a;
    L_0x0167:
        r3[r2] = r1;
        r2 = 29;
        r1 = "9p`j\u0003\u001b[Sg\t\u001cjBk\u0002L{Yv\u0003\u001e$";
        r0 = 28;
        r3 = r4;
        goto L_0x000a;
    L_0x0172:
        r3[r2] = r1;
        r2 = 30;
        r1 = "8Rx";
        r0 = 29;
        r3 = r4;
        goto L_0x000a;
    L_0x017d:
        r3[r2] = r1;
        r2 = 31;
        r1 = ")[n(L\b>fI!LgR}\u0015LVc>\u0001\u0001$XwL\u0016";
        r0 = 30;
        r3 = r4;
        goto L_0x000a;
    L_0x0188:
        r3[r2] = r1;
        z = r4;
        r0 = 1;
        a = r0;
        r0 = 0;
        b = r0;
        r0 = 0;
        c = r0;
        r0 = new java.text.SimpleDateFormat;
        r1 = z;
        r2 = 31;
        r1 = r1[r2];
        r2 = java.util.Locale.ENGLISH;
        r0.<init>(r1, r2);
        e = r0;
        return;
    L_0x01a5:
        r9 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        goto L_0x0021;
    L_0x01a9:
        r9 = 30;
        goto L_0x0021;
    L_0x01ad:
        r9 = 43;
        goto L_0x0021;
    L_0x01b1:
        r9 = 4;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpUtils.<clinit>():void");
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.startsWith(z[24])) {
                    str = new StringBuilder(z[25]).append(str.substring(5)).toString();
                }
            } catch (Exception e) {
                d.d(z[11], new StringBuilder(z[26]).append(e.getMessage()).toString());
            }
        }
        return str;
    }

    private static void a(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        if (httpRequest != null && httpURLConnection != null) {
            setURLConnection(httpRequest.getRequestProperties(), httpURLConnection);
            if (httpRequest.getConnectTimeout() >= 0) {
                httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout());
            }
            if (httpRequest.getReadTimeout() >= 0) {
                httpURLConnection.setReadTimeout(httpRequest.getReadTimeout());
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, HttpResponse httpResponse) {
        if (httpURLConnection != null) {
            httpResponse.setResponseCode(httpURLConnection.getResponseCode());
            httpResponse.setResponseHeader(z[21], httpURLConnection.getHeaderField(z[22]));
            httpResponse.setResponseHeader(z[19], httpURLConnection.getHeaderField(z[20]));
        }
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (j.a(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        if (str.contains(URL_AND_PARA_SEPARATOR)) {
            stringBuilder.append(PARAMETERS_SEPARATOR);
        } else {
            stringBuilder.append(URL_AND_PARA_SEPARATOR);
        }
        return stringBuilder.append(str2).append(EQUAL_SIGN).append(str3).toString();
    }

    public static void createSSLConnection() {
        try {
            if (d) {
                SSLContext instance = SSLContext.getInstance(z[30]);
                b = instance;
                instance.init(null, null, new SecureRandom());
                return;
            }
            TrustManager[] trustManagerArr = new TrustManager[1];
            c = new g();
            trustManagerArr[0] = c;
            SSLContext instance2 = SSLContext.getInstance(z[30]);
            b = instance2;
            instance2.init(null, trustManagerArr, null);
        } catch (NoSuchAlgorithmException e) {
            d.g(z[11], new StringBuilder(z[28]).append(e.getMessage()).toString());
        } catch (KeyManagementException e2) {
            d.g(z[11], new StringBuilder(z[27]).append(e2.getMessage()).toString());
        } catch (Exception e3) {
            d.g(z[11], new StringBuilder(z[29]).append(e3.getMessage()).toString());
        }
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(Context context, String str) {
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission(z[0], context.getPackageName()) == 0) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(z[2])).getActiveNetworkInfo();
                    if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo != null && (extraInfo.equals(z[3]) || extraInfo.equals(z[4]) || extraInfo.equals(z[1]))) {
                            return (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(HTTP_DEFUALT_PROXY, 80)));
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (j.a(str)) {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        String joinParas = joinParas(map);
        if (!j.a(joinParas)) {
            stringBuilder.append(URL_AND_PARA_SEPARATOR).append(joinParas);
        }
        return stringBuilder.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (j.a(str)) {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        String joinParasWithEncodedValue = joinParasWithEncodedValue(map);
        if (!j.a(joinParasWithEncodedValue)) {
            stringBuilder.append(URL_AND_PARA_SEPARATOR).append(joinParasWithEncodedValue);
        }
        return stringBuilder.toString();
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        MalformedURLException e;
        IOException e2;
        Exception e3;
        Throwable th;
        if (httpRequest == null) {
            return null;
        }
        HttpURLConnection url = httpRequest.getUrl();
        HttpResponse httpResponse = new HttpResponse(url);
        try {
            url = getHttpURLConnectionWithProxy(context, httpRequest.getUrl());
            try {
                if (url instanceof HttpsURLConnection) {
                    createSSLConnection();
                    if (b != null) {
                        ((HttpsURLConnection) url).setSSLSocketFactory(b.getSocketFactory());
                    }
                    if (c != null) {
                        ((HttpsURLConnection) url).setHostnameVerifier((HostnameVerifier) c);
                    }
                }
                a(httpRequest, url);
                if (httpRequest.isHaveRspData()) {
                    byte[] readInputStream = readInputStream(url.getInputStream());
                    if (readInputStream != null) {
                        httpResponse.setResponseBody(new String(readInputStream, ENCODING_UTF_8));
                    }
                }
                a(url, httpResponse);
                if (url != null) {
                    url.disconnect();
                }
            } catch (MalformedURLException e4) {
                e = e4;
                d.g(z[11], new StringBuilder(z[9]).append(e.getMessage()).toString());
                httpResponse.setResponseCode(HttpConstants.NET_MALTFORMED_ERROR);
                httpResponse.setResponseBody(z[14]);
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            } catch (IOException e5) {
                e2 = e5;
                httpResponse.setResponseCode(HttpConstants.NET_ERROR_CODE);
                httpResponse.setResponseBody(z[7]);
                if (e2 instanceof SocketTimeoutException) {
                    httpResponse.setResponseCode(HttpConstants.NET_TIMEOUT_CODE);
                    httpResponse.setResponseBody(z[13]);
                } else if (e2 instanceof UnknownHostException) {
                    httpResponse.setResponseCode(HttpConstants.NET_UNKNOW_HOST);
                    httpResponse.setResponseBody(z[8]);
                } else if (e2 instanceof SSLHandshakeException) {
                    httpResponse.setResponseCode(HttpConstants.NET_SSL_EXECPTION);
                    httpResponse.setResponseBody(z[17]);
                    if (!d) {
                    }
                    d = true;
                }
                d.g(z[11], new StringBuilder(z[6]).append(e2.getMessage()).toString());
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            } catch (Exception e6) {
                e3 = e6;
                d.g(z[11], new StringBuilder(z[10]).append(e3.getMessage()).toString());
                httpResponse.setResponseCode(HttpConstants.UNKNOW_EXECPTION);
                httpResponse.setResponseBody(new StringBuilder(z[16]).append(e3.getMessage()).toString());
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            } catch (StackOverflowError e7) {
                d.g(z[11], z[12]);
                httpResponse.setResponseCode(HttpConstants.STACK_OVER_EXECPTION);
                httpResponse.setResponseBody(z[12]);
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            }
        } catch (MalformedURLException e8) {
            MalformedURLException malformedURLException = e8;
            url = null;
            e = malformedURLException;
            d.g(z[11], new StringBuilder(z[9]).append(e.getMessage()).toString());
            httpResponse.setResponseCode(HttpConstants.NET_MALTFORMED_ERROR);
            httpResponse.setResponseBody(z[14]);
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (IOException e9) {
            IOException iOException = e9;
            url = null;
            e2 = iOException;
            httpResponse.setResponseCode(HttpConstants.NET_ERROR_CODE);
            httpResponse.setResponseBody(z[7]);
            if (e2 instanceof SocketTimeoutException) {
                httpResponse.setResponseCode(HttpConstants.NET_TIMEOUT_CODE);
                httpResponse.setResponseBody(z[13]);
            } else if (e2 instanceof UnknownHostException) {
                httpResponse.setResponseCode(HttpConstants.NET_UNKNOW_HOST);
                httpResponse.setResponseBody(z[8]);
            } else if (e2 instanceof SSLHandshakeException) {
                httpResponse.setResponseCode(HttpConstants.NET_SSL_EXECPTION);
                httpResponse.setResponseBody(z[17]);
                if (!d && a && httpRequest.getUrl().startsWith(z[5])) {
                    d.d(z[11], z[23]);
                    httpRequest.setUrl(a(httpRequest.getUrl()));
                    HttpResponse httpGet = httpGet(context, httpRequest);
                    if (url == null) {
                        return httpGet;
                    }
                    url.disconnect();
                    return httpGet;
                }
                d = true;
            }
            d.g(z[11], new StringBuilder(z[6]).append(e2.getMessage()).toString());
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (Exception e10) {
            Exception exception = e10;
            url = null;
            e3 = exception;
            d.g(z[11], new StringBuilder(z[10]).append(e3.getMessage()).toString());
            httpResponse.setResponseCode(HttpConstants.UNKNOW_EXECPTION);
            httpResponse.setResponseBody(new StringBuilder(z[16]).append(e3.getMessage()).toString());
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (StackOverflowError e11) {
            url = null;
            d.g(z[11], z[12]);
            httpResponse.setResponseCode(HttpConstants.STACK_OVER_EXECPTION);
            httpResponse.setResponseBody(z[12]);
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (Throwable th2) {
            th = th2;
            if (url != null) {
                url.disconnect();
            }
            throw th;
        }
        return httpResponse;
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(new HttpRequest[]{httpRequest});
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(new String[]{str});
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        return httpGet == null ? null : httpGet.getResponseBody();
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        return httpGet == null ? null : httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        MalformedURLException e;
        IOException e2;
        Exception e3;
        Throwable th;
        if (httpRequest == null) {
            return null;
        }
        HttpURLConnection url = httpRequest.getUrl();
        HttpResponse httpResponse = new HttpResponse(url);
        try {
            url = getHttpURLConnectionWithProxy(context, httpRequest.getUrl());
            try {
                if (url instanceof HttpsURLConnection) {
                    createSSLConnection();
                    if (b != null) {
                        ((HttpsURLConnection) url).setSSLSocketFactory(b.getSocketFactory());
                    }
                    if (c != null) {
                        ((HttpsURLConnection) url).setHostnameVerifier((HostnameVerifier) c);
                    }
                }
                a(httpRequest, url);
                url.setRequestMethod(z[18]);
                url.setDoOutput(true);
                url.setDoInput(true);
                byte[] paras = httpRequest.getParas();
                if (paras != null) {
                    url.getOutputStream().write(paras);
                }
                if (httpRequest.isHaveRspData()) {
                    paras = readInputStream(url.getInputStream());
                    if (paras != null) {
                        httpResponse.setResponseBody(new String(paras, ENCODING_UTF_8));
                    }
                }
                a(url, httpResponse);
                if (url != null) {
                    url.disconnect();
                }
            } catch (MalformedURLException e4) {
                e = e4;
                d.g(z[11], new StringBuilder(z[9]).append(e.getMessage()).toString());
                httpResponse.setResponseCode(HttpConstants.NET_MALTFORMED_ERROR);
                httpResponse.setResponseBody(z[14]);
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            } catch (IOException e5) {
                e2 = e5;
                httpResponse.setResponseCode(HttpConstants.NET_ERROR_CODE);
                httpResponse.setResponseBody(z[7]);
                if (e2 instanceof SocketTimeoutException) {
                    httpResponse.setResponseCode(HttpConstants.NET_TIMEOUT_CODE);
                    httpResponse.setResponseBody(z[13]);
                } else if (e2 instanceof UnknownHostException) {
                    httpResponse.setResponseCode(HttpConstants.NET_UNKNOW_HOST);
                    httpResponse.setResponseBody(z[8]);
                } else if (e2 instanceof SSLHandshakeException) {
                    httpResponse.setResponseCode(HttpConstants.NET_SSL_EXECPTION);
                    httpResponse.setResponseBody(z[17]);
                    if (!d) {
                    }
                    d = true;
                }
                d.g(z[11], new StringBuilder(z[6]).append(e2.getMessage()).toString());
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            } catch (Exception e6) {
                e3 = e6;
                d.g(z[11], new StringBuilder(z[10]).append(e3.getMessage()).toString());
                httpResponse.setResponseCode(HttpConstants.UNKNOW_EXECPTION);
                httpResponse.setResponseBody(new StringBuilder(z[16]).append(e3.getMessage()).toString());
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            } catch (StackOverflowError e7) {
                d.g(z[11], z[12]);
                httpResponse.setResponseCode(HttpConstants.STACK_OVER_EXECPTION);
                httpResponse.setResponseBody(z[12]);
                if (url != null) {
                    url.disconnect();
                }
                return httpResponse;
            }
        } catch (MalformedURLException e8) {
            MalformedURLException malformedURLException = e8;
            url = null;
            e = malformedURLException;
            d.g(z[11], new StringBuilder(z[9]).append(e.getMessage()).toString());
            httpResponse.setResponseCode(HttpConstants.NET_MALTFORMED_ERROR);
            httpResponse.setResponseBody(z[14]);
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (IOException e9) {
            IOException iOException = e9;
            url = null;
            e2 = iOException;
            httpResponse.setResponseCode(HttpConstants.NET_ERROR_CODE);
            httpResponse.setResponseBody(z[7]);
            if (e2 instanceof SocketTimeoutException) {
                httpResponse.setResponseCode(HttpConstants.NET_TIMEOUT_CODE);
                httpResponse.setResponseBody(z[13]);
            } else if (e2 instanceof UnknownHostException) {
                httpResponse.setResponseCode(HttpConstants.NET_UNKNOW_HOST);
                httpResponse.setResponseBody(z[8]);
            } else if (e2 instanceof SSLHandshakeException) {
                httpResponse.setResponseCode(HttpConstants.NET_SSL_EXECPTION);
                httpResponse.setResponseBody(z[17]);
                if (!d && a && httpRequest.getUrl().startsWith(z[5])) {
                    d.d(z[11], z[15]);
                    httpRequest.setUrl(a(httpRequest.getUrl()));
                    HttpResponse httpPost = httpPost(context, httpRequest);
                    if (url == null) {
                        return httpPost;
                    }
                    url.disconnect();
                    return httpPost;
                }
                d = true;
            }
            d.g(z[11], new StringBuilder(z[6]).append(e2.getMessage()).toString());
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (Exception e10) {
            Exception exception = e10;
            url = null;
            e3 = exception;
            d.g(z[11], new StringBuilder(z[10]).append(e3.getMessage()).toString());
            httpResponse.setResponseCode(HttpConstants.UNKNOW_EXECPTION);
            httpResponse.setResponseBody(new StringBuilder(z[16]).append(e3.getMessage()).toString());
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (StackOverflowError e11) {
            url = null;
            d.g(z[11], z[12]);
            httpResponse.setResponseCode(HttpConstants.STACK_OVER_EXECPTION);
            httpResponse.setResponseBody(z[12]);
            if (url != null) {
                url.disconnect();
            }
            return httpResponse;
        } catch (Throwable th2) {
            th = th2;
            if (url != null) {
                url.disconnect();
            }
            throw th;
        }
        return httpResponse;
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        return httpPost == null ? null : httpPost.getResponseBody();
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        return httpPost == null ? null : httpPost.getResponseBody();
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(EQUAL_SIGN).append((String) entry.getValue());
            if (it.hasNext()) {
                stringBuilder.append(PARAMETERS_SEPARATOR);
            }
        }
        return stringBuilder.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Entry entry = (Entry) it.next();
                    stringBuilder.append((String) entry.getKey()).append(EQUAL_SIGN).append(URLEncoder.encode((String) entry.getValue(), ENCODING_UTF_8));
                    if (it.hasNext()) {
                        stringBuilder.append(PARAMETERS_SEPARATOR);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return e.parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null && map.size() != 0 && httpURLConnection != null) {
            for (Entry entry : map.entrySet()) {
                if (!j.a((String) entry.getKey())) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
    }
}
