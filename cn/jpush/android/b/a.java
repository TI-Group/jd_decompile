package cn.jpush.android.b;

import android.os.Build.VERSION;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.d.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: TbsSdkJava */
public final class a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 20;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\\~bP;\fmuP.CqcF~ImbL,";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00fa;
            case 1: goto L_0x00fe;
            case 2: goto L_0x0102;
            case 3: goto L_0x0106;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 94;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "DkdS~OsyF0X?u[;OjdF~ImbL,";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "o~d@6\fLCo\u000eIzbv0ZzbJ8Eztf&Oz`W7Cq<\u00036Xk`\u0003=@vuM*\fzhF=Yku\u0003;^mQ";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "J~|P;";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "ckxF,\fhbL0K?bF-\\p~P;\fldB*Yl0\u000e~";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "dkdS\u0016Is`F,";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "E{uM*Eki";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "M|dJ1B%xW*\\XuW~\u0001?";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "op~M;OkyL0";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0000?eQ2\u0016";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "yqu[.I|dF:\u0016?tL)BsB:I{0A'Xzc\u0003=CqdF0X?|F0Kkx\u00037_? ";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "DkdSpGzuS\u001f@vfF";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "osP;";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "_kqW+_\\G;\u0016";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "~zaV;_k0S?Xw0G1Il0M1X?u[7_k*\u0003j\u001c+0\u000e~";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "_zbU;^?bF-\\p~P;\fyqJ2Ymu\u0003s\f";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "hpgM2C~t\u0003<UkuP~J~yO;H10d1X?rZ*Il0O;B?,\u00036I~tF,\f|M*Iqd\u00032IqwW6\u0002";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "m|sF.X2UM=C{yM9";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "M|dJ1B%xW*\\LyN.@zWF*\f20";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "o~d@6\f^cP;^kyL0imbL,\fk\u0003?ZpyG~DkdS~OsP;\f|bB-D?=\u0003";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00fa:
        r9 = 44;
        goto L_0x0020;
    L_0x00fe:
        r9 = 31;
        goto L_0x0020;
    L_0x0102:
        r9 = 16;
        goto L_0x0020;
    L_0x0106:
        r9 = 35;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.a.<clinit>():void");
    }

    public static HttpResponse a(String str, int i, long j) {
        HttpResponse httpGet;
        int responseCode;
        Throwable th;
        AssertionError assertionError;
        e.c(z[5], new StringBuilder(z[18]).append(str).toString());
        if (j < 200 || j > 60000) {
            j = 2000;
        }
        int i2 = 0;
        HttpResponse httpResponse = null;
        while (true) {
            try {
                HttpRequest httpRequest = new HttpRequest(str);
                httpRequest.setRequestProperty(z[8], z[12]);
                httpRequest.setRequestProperty(z[17], z[6]);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty(z[11], z[3]);
                }
                httpGet = HttpUtils.httpGet(null, httpRequest);
                try {
                    responseCode = httpGet.getResponseCode();
                    e.a(z[5], new StringBuilder(z[13]).append(responseCode).toString());
                    if (responseCode == 200) {
                        break;
                    }
                } catch (Throwable e) {
                    Throwable th2 = e;
                    httpResponse = httpGet;
                    th = th2;
                    e.a(z[5], z[1], th);
                    httpGet = httpResponse;
                    if (i2 >= 5) {
                        return httpGet;
                    }
                    responseCode = i2 + 1;
                    try {
                        Thread.sleep(j);
                        i2 = responseCode;
                        httpResponse = httpGet;
                    } catch (InterruptedException e2) {
                        i2 = responseCode;
                        httpResponse = httpGet;
                    }
                } catch (AssertionError e3) {
                    AssertionError assertionError2 = e3;
                    httpResponse = httpGet;
                    assertionError = assertionError2;
                    e.i(z[5], new StringBuilder(z[19]).append(assertionError.toString()).toString());
                    httpGet = httpResponse;
                    if (i2 >= 5) {
                        return httpGet;
                    }
                    responseCode = i2 + 1;
                    Thread.sleep(j);
                    i2 = responseCode;
                    httpResponse = httpGet;
                }
            } catch (Exception e4) {
                th = e4;
                e.a(z[5], z[1], th);
                httpGet = httpResponse;
                if (i2 >= 5) {
                    return httpGet;
                }
                responseCode = i2 + 1;
                Thread.sleep(j);
                i2 = responseCode;
                httpResponse = httpGet;
            } catch (AssertionError e5) {
                assertionError = e5;
                e.i(z[5], new StringBuilder(z[19]).append(assertionError.toString()).toString());
                httpGet = httpResponse;
                if (i2 >= 5) {
                    return httpGet;
                }
                responseCode = i2 + 1;
                Thread.sleep(j);
                i2 = responseCode;
                httpResponse = httpGet;
            }
            if (i2 >= 5) {
                break;
            }
            responseCode = i2 + 1;
            Thread.sleep(j);
            i2 = responseCode;
            httpResponse = httpGet;
        }
        return httpGet;
    }

    public static byte[] a(String str, int i, long j, int i2) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < 4; i3++) {
            bArr = b(str, 5, 5000);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    private static byte[] b(String str, int i, long j) {
        int responseCode;
        int contentLength;
        InputStream inputStream;
        byte[] readInputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        Throwable th;
        Throwable th2;
        if (i <= 0 || i > 10) {
            i = 1;
        }
        if (j < 200 || j > 60000) {
            j = 2000;
        }
        e.c(z[5], new StringBuilder(z[7]).append(str).toString());
        HttpURLConnection httpURLConnection2 = null;
        InputStream inputStream3 = null;
        int i2 = 0;
        while (true) {
            HttpURLConnection httpURLConnection3;
            int i3;
            try {
                httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection3.setRequestProperty(z[17], z[6]);
                    httpURLConnection3.addRequestProperty(z[8], z[12]);
                    if (Integer.parseInt(VERSION.SDK) < 8) {
                        System.setProperty(z[11], z[3]);
                    }
                    responseCode = httpURLConnection3.getResponseCode();
                    e.a(z[5], new StringBuilder(z[13]).append(responseCode).toString());
                    if (responseCode == 200) {
                        contentLength = httpURLConnection3.getContentLength();
                        inputStream = httpURLConnection3.getInputStream();
                        if (inputStream == null) {
                            break;
                        }
                        try {
                            readInputStream = HttpUtils.readInputStream(inputStream);
                            break;
                        } catch (SSLPeerUnverifiedException e) {
                            httpURLConnection = httpURLConnection3;
                            inputStream2 = inputStream;
                        } catch (Throwable e2) {
                            th = e2;
                            inputStream3 = inputStream;
                            httpURLConnection2 = httpURLConnection3;
                            th2 = th;
                            try {
                                e.a(z[5], z[1], th2);
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                if (i2 >= i) {
                                    return null;
                                }
                                i3 = i2 + 1;
                                try {
                                    Thread.sleep(((long) i3) * j);
                                    i2 = i3;
                                } catch (InterruptedException e4) {
                                    i2 = i3;
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        } catch (Throwable e22) {
                            th = e22;
                            inputStream3 = inputStream;
                            httpURLConnection2 = httpURLConnection3;
                            th2 = th;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (200 != responseCode) {
                            if (contentLength == 0) {
                                try {
                                    e.c(z[5], z[10]);
                                    return null;
                                } catch (Throwable th22) {
                                    e.a(z[5], z[0], th22);
                                    return null;
                                }
                            } else if (readInputStream.length < contentLength) {
                                return readInputStream;
                            } else {
                                e.c(z[5], z[16]);
                                return null;
                            }
                        } else if (400 == responseCode) {
                            e.c(z[5], new StringBuilder(z[15]).append(str).toString());
                            return null;
                        } else if (404 != responseCode) {
                            e.c(z[5], new StringBuilder(z[14]).append(str).toString());
                            return null;
                        } else {
                            e.c(z[5], new StringBuilder(z[4]).append(responseCode).append(z[9]).append(str).toString());
                            return null;
                        }
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                        httpURLConnection2 = httpURLConnection3;
                    } else {
                        httpURLConnection2 = httpURLConnection3;
                    }
                    if (i2 >= i) {
                        return null;
                    }
                    i3 = i2 + 1;
                    Thread.sleep(((long) i3) * j);
                    i2 = i3;
                } catch (SSLPeerUnverifiedException e7) {
                    InputStream inputStream4 = inputStream3;
                    httpURLConnection = httpURLConnection3;
                    inputStream2 = inputStream4;
                    try {
                        e.j(z[5], z[2]);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (httpURLConnection == null) {
                            httpURLConnection.disconnect();
                            httpURLConnection2 = httpURLConnection;
                            inputStream3 = inputStream2;
                        } else {
                            httpURLConnection2 = httpURLConnection;
                            inputStream3 = inputStream2;
                        }
                        if (i2 >= i) {
                            return null;
                        }
                        i3 = i2 + 1;
                        Thread.sleep(((long) i3) * j);
                        i2 = i3;
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection2 = httpURLConnection;
                        inputStream3 = inputStream2;
                        th22 = th;
                    }
                } catch (Throwable th42) {
                    th = th42;
                    httpURLConnection2 = httpURLConnection3;
                    th22 = th;
                    e.a(z[5], z[1], th22);
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (i2 >= i) {
                        return null;
                    }
                    i3 = i2 + 1;
                    Thread.sleep(((long) i3) * j);
                    i2 = i3;
                } catch (Throwable th422) {
                    th = th422;
                    httpURLConnection2 = httpURLConnection3;
                    th22 = th;
                }
            } catch (SSLPeerUnverifiedException e9) {
                inputStream2 = inputStream3;
                httpURLConnection = httpURLConnection2;
                e.j(z[5], z[2]);
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection == null) {
                    httpURLConnection2 = httpURLConnection;
                    inputStream3 = inputStream2;
                } else {
                    httpURLConnection.disconnect();
                    httpURLConnection2 = httpURLConnection;
                    inputStream3 = inputStream2;
                }
                if (i2 >= i) {
                    return null;
                }
                i3 = i2 + 1;
                Thread.sleep(((long) i3) * j);
                i2 = i3;
            } catch (Exception e10) {
                th22 = e10;
                e.a(z[5], z[1], th22);
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (i2 >= i) {
                    return null;
                }
                i3 = i2 + 1;
                Thread.sleep(((long) i3) * j);
                i2 = i3;
            }
        }
        readInputStream = null;
        if (inputStream != null) {
            inputStream.close();
        }
        if (httpURLConnection3 != null) {
            httpURLConnection3.disconnect();
        }
        if (200 != responseCode) {
            if (400 == responseCode) {
                e.c(z[5], new StringBuilder(z[15]).append(str).toString());
                return null;
            } else if (404 != responseCode) {
                e.c(z[5], new StringBuilder(z[4]).append(responseCode).append(z[9]).append(str).toString());
                return null;
            } else {
                e.c(z[5], new StringBuilder(z[14]).append(str).toString());
                return null;
            }
        } else if (contentLength == 0) {
            e.c(z[5], z[10]);
            return null;
        } else if (readInputStream.length < contentLength) {
            return readInputStream;
        } else {
            e.c(z[5], z[16]);
            return null;
        }
        if (inputStream3 != null) {
            try {
                inputStream3.close();
            } catch (IOException e11) {
            }
        }
        if (httpURLConnection2 != null) {
            httpURLConnection2.disconnect();
        }
        throw th22;
        if (httpURLConnection2 != null) {
            httpURLConnection2.disconnect();
        }
        throw th22;
    }
}
