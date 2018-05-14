package com.jingdong.jdma.c;

/* compiled from: TbsSdkJava */
public class a extends b {
    public a(int i, int i2, int i3, String str, String str2, boolean z) {
        super(i, i2, i3, str, str2, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a() {
        /*
        r12 = this;
        r7 = -1;
        r4 = 0;
        r2 = 0;
        r3 = 1;
        r5 = 0;
        r8 = 0;
        r6 = r12.g();	 Catch:{ ConnectException -> 0x0264, SocketTimeoutException -> 0x0256, SocketException -> 0x0238, Exception -> 0x01bc, all -> 0x01e8 }
        r0 = r12.e;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r6.setConnectTimeout(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = 1;
        r6.setDoOutput(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r12.p;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r0 == 0) goto L_0x001b;
    L_0x0017:
        r0 = 1;
        r6.setDoInput(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
    L_0x001b:
        r0 = 0;
        r6.setUseCaches(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = "POST";
        r6.setRequestMethod(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = 1;
        r6.setInstanceFollowRedirects(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r12.c;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r6.setReadTimeout(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r12.d();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r0 == 0) goto L_0x0075;
    L_0x0033:
        r1 = r0.entrySet();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r1 == 0) goto L_0x0075;
    L_0x0039:
        r0 = r0.entrySet();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r9 = r0.iterator();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
    L_0x0041:
        r0 = r9.hasNext();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r0 == 0) goto L_0x0075;
    L_0x0047:
        r0 = r9.next();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1 = r0.getKey();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1 = (java.lang.String) r1;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r0.getValue();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = (java.lang.String) r0;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r6.setRequestProperty(r1, r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        goto L_0x0041;
    L_0x005d:
        r0 = move-exception;
        r1 = r0;
        r2 = r4;
        r3 = r6;
        r0 = r7;
    L_0x0062:
        r1.printStackTrace();	 Catch:{ all -> 0x0219 }
        if (r2 == 0) goto L_0x006a;
    L_0x0067:
        r2.close();	 Catch:{ Exception -> 0x0181 }
    L_0x006a:
        if (r4 == 0) goto L_0x006f;
    L_0x006c:
        r4.close();	 Catch:{ Exception -> 0x0187 }
    L_0x006f:
        if (r3 == 0) goto L_0x0074;
    L_0x0071:
        r3.disconnect();	 Catch:{ Exception -> 0x020a, AssertionError -> 0x018d }
    L_0x0074:
        return r0;
    L_0x0075:
        r0 = new java.util.Date;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0.<init>();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r0.getTime();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r12.q = r0;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r6.connect();	 Catch:{ IOException -> 0x00ce, AssertionError -> 0x00e9 }
    L_0x0083:
        r1 = new java.io.DataOutputStream;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r6.getOutputStream();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1.<init>(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r12.b();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r0 != 0) goto L_0x0096;
    L_0x0092:
        r0 = r12.h();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
    L_0x0096:
        r0 = r0.getBytes();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r9 = r0.length;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r9 == 0) goto L_0x00a0;
    L_0x009d:
        r1.write(r0);	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
    L_0x00a0:
        r1.flush();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1.close();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r0 = r6.getResponseCode();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r0 != r1) goto L_0x0119;
    L_0x00ae:
        r6.disconnect();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1 = new java.util.Date;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r1.<init>();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r10 = r1.getTime();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        r12.r = r10;	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        if (r4 == 0) goto L_0x00c1;
    L_0x00be:
        r8.close();	 Catch:{ Exception -> 0x0109 }
    L_0x00c1:
        if (r4 == 0) goto L_0x00c6;
    L_0x00c3:
        r5.close();	 Catch:{ Exception -> 0x010e }
    L_0x00c6:
        if (r6 == 0) goto L_0x0074;
    L_0x00c8:
        r6.disconnect();	 Catch:{ Exception -> 0x00cc, AssertionError -> 0x0113 }
        goto L_0x0074;
    L_0x00cc:
        r1 = move-exception;
        goto L_0x0074;
    L_0x00ce:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        goto L_0x0083;
    L_0x00d3:
        r0 = move-exception;
        r5 = r4;
    L_0x00d5:
        r0.printStackTrace();	 Catch:{ all -> 0x021e }
        if (r4 == 0) goto L_0x00dd;
    L_0x00da:
        r4.close();	 Catch:{ Exception -> 0x0193 }
    L_0x00dd:
        if (r5 == 0) goto L_0x00e2;
    L_0x00df:
        r5.close();	 Catch:{ Exception -> 0x0199 }
    L_0x00e2:
        if (r6 == 0) goto L_0x00e7;
    L_0x00e4:
        r6.disconnect();	 Catch:{ Exception -> 0x019f, AssertionError -> 0x01a3 }
    L_0x00e7:
        r0 = r3;
        goto L_0x0074;
    L_0x00e9:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ ConnectException -> 0x005d, SocketTimeoutException -> 0x00d3, SocketException -> 0x00ee, Exception -> 0x0220, all -> 0x020f }
        goto L_0x0083;
    L_0x00ee:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r0 = r7;
    L_0x00f2:
        r1.printStackTrace();	 Catch:{ all -> 0x021e }
        if (r4 == 0) goto L_0x00fa;
    L_0x00f7:
        r4.close();	 Catch:{ Exception -> 0x01aa }
    L_0x00fa:
        if (r5 == 0) goto L_0x00ff;
    L_0x00fc:
        r5.close();	 Catch:{ Exception -> 0x01b0 }
    L_0x00ff:
        if (r6 == 0) goto L_0x0074;
    L_0x0101:
        r6.disconnect();	 Catch:{ Exception -> 0x0106, AssertionError -> 0x01b6 }
        goto L_0x0074;
    L_0x0106:
        r1 = move-exception;
        goto L_0x0074;
    L_0x0109:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c1;
    L_0x010e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c6;
    L_0x0113:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0074;
    L_0x0119:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r1) goto L_0x012a;
    L_0x011d:
        r1 = new java.net.SocketException;	 Catch:{ ConnectException -> 0x0125, SocketTimeoutException -> 0x00d3, SocketException -> 0x023f, Exception -> 0x0225, all -> 0x020f }
        r2 = "http status is not 200 or 304";
        r1.<init>(r2);	 Catch:{ ConnectException -> 0x0125, SocketTimeoutException -> 0x00d3, SocketException -> 0x023f, Exception -> 0x0225, all -> 0x020f }
        throw r1;	 Catch:{ ConnectException -> 0x0125, SocketTimeoutException -> 0x00d3, SocketException -> 0x023f, Exception -> 0x0225, all -> 0x020f }
    L_0x0125:
        r1 = move-exception;
        r2 = r4;
        r3 = r6;
        goto L_0x0062;
    L_0x012a:
        r1 = r6.getInputStream();	 Catch:{ ConnectException -> 0x026b, SocketTimeoutException -> 0x00d3, SocketException -> 0x0243, Exception -> 0x0228, all -> 0x020f }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ ConnectException -> 0x0272, SocketTimeoutException -> 0x025b, SocketException -> 0x0249, Exception -> 0x022d, all -> 0x0212 }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ ConnectException -> 0x0272, SocketTimeoutException -> 0x025b, SocketException -> 0x0249, Exception -> 0x022d, all -> 0x0212 }
        r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5.<init>(r8);	 Catch:{ ConnectException -> 0x0272, SocketTimeoutException -> 0x025b, SocketException -> 0x0249, Exception -> 0x022d, all -> 0x0212 }
    L_0x0139:
        r4 = r1.read(r0);	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        if (r4 == r7) goto L_0x014c;
    L_0x013f:
        r8 = 0;
        r5.write(r0, r8, r4);	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        goto L_0x0139;
    L_0x0144:
        r0 = move-exception;
        r2 = r1;
        r4 = r5;
        r1 = r0;
        r0 = r3;
        r3 = r6;
        goto L_0x0062;
    L_0x014c:
        r0 = new java.util.Date;	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        r0.<init>();	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        r8 = r0.getTime();	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        r12.r = r8;	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        r12.a(r6, r5);	 Catch:{ ConnectException -> 0x0144, SocketTimeoutException -> 0x0260, SocketException -> 0x0250, Exception -> 0x0233, all -> 0x0216 }
        if (r1 == 0) goto L_0x015f;
    L_0x015c:
        r1.close();	 Catch:{ Exception -> 0x016c }
    L_0x015f:
        if (r5 == 0) goto L_0x0164;
    L_0x0161:
        r5.close();	 Catch:{ Exception -> 0x0171 }
    L_0x0164:
        if (r6 == 0) goto L_0x0169;
    L_0x0166:
        r6.disconnect();	 Catch:{ Exception -> 0x0176, AssertionError -> 0x017a }
    L_0x0169:
        r0 = r2;
        goto L_0x0074;
    L_0x016c:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x015f;
    L_0x0171:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0164;
    L_0x0176:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0074;
    L_0x017a:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r2;
        goto L_0x0074;
    L_0x0181:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x006a;
    L_0x0187:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x006f;
    L_0x018d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0074;
    L_0x0193:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00dd;
    L_0x0199:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00e2;
    L_0x019f:
        r0 = move-exception;
        r0 = r3;
        goto L_0x0074;
    L_0x01a3:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r3;
        goto L_0x0074;
    L_0x01aa:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00fa;
    L_0x01b0:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00ff;
    L_0x01b6:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0074;
    L_0x01bc:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r6 = r4;
        r0 = r7;
    L_0x01c1:
        r1.printStackTrace();	 Catch:{ all -> 0x021e }
        if (r4 == 0) goto L_0x01c9;
    L_0x01c6:
        r4.close();	 Catch:{ Exception -> 0x01d8 }
    L_0x01c9:
        if (r5 == 0) goto L_0x01ce;
    L_0x01cb:
        r5.close();	 Catch:{ Exception -> 0x01dd }
    L_0x01ce:
        if (r6 == 0) goto L_0x0074;
    L_0x01d0:
        r6.disconnect();	 Catch:{ Exception -> 0x01d5, AssertionError -> 0x01e2 }
        goto L_0x0074;
    L_0x01d5:
        r1 = move-exception;
        goto L_0x0074;
    L_0x01d8:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01c9;
    L_0x01dd:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01ce;
    L_0x01e2:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0074;
    L_0x01e8:
        r0 = move-exception;
        r5 = r4;
        r6 = r4;
    L_0x01eb:
        if (r4 == 0) goto L_0x01f0;
    L_0x01ed:
        r4.close();	 Catch:{ Exception -> 0x01fb }
    L_0x01f0:
        if (r5 == 0) goto L_0x01f5;
    L_0x01f2:
        r5.close();	 Catch:{ Exception -> 0x0200 }
    L_0x01f5:
        if (r6 == 0) goto L_0x01fa;
    L_0x01f7:
        r6.disconnect();	 Catch:{ Exception -> 0x020d, AssertionError -> 0x0205 }
    L_0x01fa:
        throw r0;
    L_0x01fb:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01f0;
    L_0x0200:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01f5;
    L_0x0205:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01fa;
    L_0x020a:
        r1 = move-exception;
        goto L_0x0074;
    L_0x020d:
        r1 = move-exception;
        goto L_0x01fa;
    L_0x020f:
        r0 = move-exception;
        r5 = r4;
        goto L_0x01eb;
    L_0x0212:
        r0 = move-exception;
        r5 = r4;
        r4 = r1;
        goto L_0x01eb;
    L_0x0216:
        r0 = move-exception;
        r4 = r1;
        goto L_0x01eb;
    L_0x0219:
        r0 = move-exception;
        r5 = r4;
        r6 = r3;
        r4 = r2;
        goto L_0x01eb;
    L_0x021e:
        r0 = move-exception;
        goto L_0x01eb;
    L_0x0220:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r0 = r7;
        goto L_0x01c1;
    L_0x0225:
        r1 = move-exception;
        r5 = r4;
        goto L_0x01c1;
    L_0x0228:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r0 = r3;
        goto L_0x01c1;
    L_0x022d:
        r0 = move-exception;
        r5 = r4;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x01c1;
    L_0x0233:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x01c1;
    L_0x0238:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r6 = r4;
        r0 = r7;
        goto L_0x00f2;
    L_0x023f:
        r1 = move-exception;
        r5 = r4;
        goto L_0x00f2;
    L_0x0243:
        r0 = move-exception;
        r1 = r0;
        r5 = r4;
        r0 = r3;
        goto L_0x00f2;
    L_0x0249:
        r0 = move-exception;
        r5 = r4;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x00f2;
    L_0x0250:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x00f2;
    L_0x0256:
        r0 = move-exception;
        r5 = r4;
        r6 = r4;
        goto L_0x00d5;
    L_0x025b:
        r0 = move-exception;
        r5 = r4;
        r4 = r1;
        goto L_0x00d5;
    L_0x0260:
        r0 = move-exception;
        r4 = r1;
        goto L_0x00d5;
    L_0x0264:
        r0 = move-exception;
        r1 = r0;
        r2 = r4;
        r3 = r4;
        r0 = r7;
        goto L_0x0062;
    L_0x026b:
        r0 = move-exception;
        r1 = r0;
        r2 = r4;
        r0 = r3;
        r3 = r6;
        goto L_0x0062;
    L_0x0272:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r3;
        r3 = r6;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jingdong.jdma.c.a.a():int");
    }
}
