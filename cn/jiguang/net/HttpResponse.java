package cn.jiguang.net;

import cn.jiguang.e.j;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private static final String[] z;
    private String a;
    private String b;
    private Map<String, Object> c;
    private int d;
    private long e;
    private boolean f;
    private boolean g;
    private int h;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "1H:I`\u001cP:I{\u0003\u0000\u0017\u001d`\u0015r:\u001ad\nN,\f4\u0006A1\u0007{\u0011\u0000=\f4\u0016M>\u0005x\u0000R\u001d|\u0004NY:";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0068;
            case 1: goto L_0x006b;
            case 2: goto L_0x006e;
            case 3: goto L_0x0071;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 20;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0000X/\u0000f\u0000S";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\bA'Du\u0002Eb";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0006A<\u0001qHC0\u0007`\u0017O3";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "-T+\u0019F\u0000S/\u0006z\u0016E$\u001bq\u0016P0\u0007g\u0000b0\rmX\u0007";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "I\u0000-\fg\u0015O1\u001aq&O;\f)";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0068:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x001f;
    L_0x006b:
        r9 = 32;
        goto L_0x001f;
    L_0x006e:
        r9 = 95;
        goto L_0x001f;
    L_0x0071:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpResponse.<clinit>():void");
    }

    public HttpResponse() {
        this.h = -1;
        this.c = new HashMap();
    }

    public HttpResponse(String str) {
        this.h = -1;
        this.a = str;
        this.d = 0;
        this.f = false;
        this.g = false;
        this.c = new HashMap();
    }

    private int a() {
        try {
            String str = (String) this.c.get(z[3]);
            if (!j.a(str)) {
                int indexOf = str.indexOf(z[2]);
                if (indexOf != -1) {
                    int indexOf2 = str.indexOf(",", indexOf);
                    return Integer.parseInt(indexOf2 != -1 ? str.substring(indexOf + 8, indexOf2) : str.substring(indexOf + 8));
                }
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long getExpiredTime() {
        if (this.g) {
            return this.e;
        }
        this.g = true;
        int a = a();
        long currentTimeMillis = a != -1 ? ((long) (a * 1000)) + System.currentTimeMillis() : !j.a(getExpiresHeader()) ? HttpUtils.parseGmtTime(getExpiresHeader()) : -1;
        this.e = currentTimeMillis;
        return currentTimeMillis;
    }

    public String getExpiresHeader() {
        try {
            return this.c == null ? null : (String) this.c.get(z[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getResponseBody() {
        return this.b;
    }

    public int getResponseCode() {
        return this.h;
    }

    public int getType() {
        return this.d;
    }

    public String getUrl() {
        return this.a;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.e;
    }

    public boolean isInCache() {
        return this.f;
    }

    public void setExpiredTime(long j) {
        this.g = true;
        this.e = j;
    }

    public HttpResponse setInCache(boolean z) {
        this.f = z;
        return this;
    }

    public void setResponseBody(String str) {
        this.b = str;
    }

    public void setResponseCode(int i) {
        this.h = i;
    }

    public void setResponseHeader(String str, String str2) {
        if (this.c != null) {
            this.c.put(str, str2);
        }
    }

    public void setResponseHeaders(Map<String, Object> map) {
        this.c = map;
    }

    public void setType(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(z[0]);
        }
        this.d = i;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public String toString() {
        return new StringBuilder(z[4]).append(this.b).append('\'').append(z[5]).append(this.h).append('}').toString();
    }
}
