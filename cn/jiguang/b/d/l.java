package cn.jiguang.b.d;

import android.content.Context;
import android.webkit.URLUtil;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.e.j;
import cn.jiguang.net.HttpConstants;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class l {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 27;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "il\u0005G7ES4V;N\u0019$Z6UD";
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
            case 0: goto L_0x0147;
            case 1: goto L_0x014b;
            case 2: goto L_0x014f;
            case 3: goto L_0x0153;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 84;
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
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            case 25: goto L_0x0142;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "aV4W;RJ:^ IL.";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "GF.Z&AW%\u001f6AP)\\tAV4W;RJ:^ IL.\u001f2AJ,Z0";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "x\u000e\u0001O$\rh%F";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "AS0S=CB4V;N\f*^'OM";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "bB3V7\u0000";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "GF.Z&AW%\u001f6AP)\\b\u0014\u0003!J HL2V.AW)P:\u0000W/T1N\u0003&^=LF$\u00133IU%\u001f!P\u0003(K P\u00032Z$OQ4";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "GY)O";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0014\u0013q\u00055UW(P&IY!K=OM`Y5IO%[z";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "cL.K1NWmz:CL$V:G";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "cB4\\<\u0000b3L1RW)P:eQ2P&\u0000W/\u001f5VL)[tHW4OtCO/L1\u0000@2^'H\u0003m\u001f";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "a@#Z$T";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "hW4O\u001cEO0Z&";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "RF0P&T\u0003#P:TF.KtIP`Q!LO`P&\u0000F-O Y\u000f'V\"E\u00035OtHW4OtRF0P&T";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "pQ/K;CL,z,CF0K=OMz";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "uw\u0006\u0012l";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "SF.[\u0018OD3\u001f<AP`M1TQ9\u001f6UW`Y5IO%[";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "cL.K1NWms1ND4W";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "e[#Z$TJ/Qt\r\u0003";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "GF.Z&AW%\u001f&ES/M \u0000W/T1N\u0003&^=LF$";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "cK!M'EW";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "a@#Z$T\u000e\u0005Q7OG)Q3";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "SW!K!S\u0003#P0E\u0019";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "tK%\u001f&ES/M \u0000v2StIP`V:VB,V0\f\u0003'V\"E\u00035OtTK)LtHW4O'\u0000Q%O;RW";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "UQ,\u0005";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "tK%\u001f&ES/M \u0000v2StIP`V:VB,V0\f\u0003'V\"E\u00035OtTK)LtHW4OtRF0P&T";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "a@4V;N\u0003m\u001f7HF#T\u0001ro)L\u0002AO)[1";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0147:
        r9 = 32;
        goto L_0x0020;
    L_0x014b:
        r9 = 35;
        goto L_0x0020;
    L_0x014f:
        r9 = 64;
        goto L_0x0020;
    L_0x0153:
        r9 = 63;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.l.<clinit>():void");
    }

    private static int a(Context context, String str, JSONObject jSONObject, boolean z, int i) {
        boolean z2 = true;
        if (i <= 0) {
            d.d(z[12], z[16]);
            return -1;
        }
        HttpRequest httpRequest = new HttpRequest(str);
        httpRequest.setConnectTimeout(CommonUtil.POST_TIMEOUT);
        httpRequest.setReadTimeout(CommonUtil.POST_TIMEOUT);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        try {
            String jSONObject2 = jSONObject != null ? jSONObject.toString() : "";
            if (j.a(jSONObject2)) {
                d.c(z[12], z[13]);
                return -2;
            }
            httpRequest.setRequestProperty(z[11], z[4]);
            httpRequest.setRequestProperty(z[21], z[7]);
            httpRequest.setRequestProperty(z[9], z[7]);
            httpRequest.setRequestProperty(z[3], a.k(context));
            String a = jSONObject2 == null ? o.a() : o.a(jSONObject2, 2);
            if (j.a(a)) {
                d.c(z[12], z[19]);
                z2 = false;
            } else {
                a = o.d(a);
                if (j.a(a)) {
                    d.c(z[12], z[2]);
                    z2 = false;
                } else {
                    httpRequest.setRequestProperty(z[1], new StringBuilder(z[5]).append(a).toString());
                    httpRequest.setRequestProperty(z[20], z[15]);
                }
            }
            if (z2) {
                Object toByteArray;
                if (z) {
                    byte[] bytes = jSONObject2.getBytes(z[15]);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    OutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                    toByteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } else {
                    toByteArray = jSONObject2.getBytes();
                }
                httpRequest.setBody(toByteArray);
                httpRequest.setRequestProperty(z[17], String.valueOf(toByteArray.length));
                httpRequest.setHaveRspData(false);
                int responseCode = HttpUtils.httpPost(context, httpRequest).getResponseCode();
                d.d(z[12], new StringBuilder(z[22]).append(responseCode).toString());
                switch (responseCode) {
                    case 200:
                        return 200;
                    case 401:
                        d.g(z[12], z[8]);
                        return 401;
                    case 404:
                        return 404;
                    case 429:
                        return 429;
                    case HttpConstants.NET_SSL_EXECPTION /*3005*/:
                        return a(context, str, jSONObject, z, i - 1);
                    default:
                        return responseCode / 100 == 5 ? 500 : -5;
                }
            } else {
                d.c(z[12], z[6]);
                return -3;
            }
        } catch (ProtocolException e) {
            d.i(z[12], new StringBuilder(z[14]).append(e.getMessage()).toString());
            return -1;
        } catch (IOException e2) {
            d.i(z[12], new StringBuilder(z[0]).append(e2.getMessage()).toString());
            return -1;
        } catch (AssertionError e3) {
            d.i(z[12], new StringBuilder(z[10]).append(e3.toString()).toString());
            return -1;
        } catch (Exception e4) {
            e4.printStackTrace();
            d.i(z[12], new StringBuilder(z[18]).append(e4.getStackTrace().toString()).toString());
            d.i(z[12], new StringBuilder(z[18]).append(e4.toString()).toString());
            return -1;
        }
    }

    public static int a(Context context, JSONObject jSONObject, boolean z) {
        boolean z2 = false;
        String a = o.a(2);
        d.a(z[12], new StringBuilder(z[24]).append(a).toString());
        d.a(z[12], z[26]);
        if (!j.a(a)) {
            if (o.b(a)) {
                if (URLUtil.isHttpUrl(a)) {
                    z2 = true;
                } else {
                    d.i(z[12], z[25]);
                }
            } else if (URLUtil.isHttpsUrl(a)) {
                z2 = true;
            } else {
                d.i(z[12], z[23]);
            }
        }
        return !z2 ? -1 : a(context, a, jSONObject, true, 2);
    }
}
