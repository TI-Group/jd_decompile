package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private static final String[] z;
    private String a;
    private int b;
    private int c;
    private Map<String, String> d;
    private Map<String, String> e;
    private Object f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j = true;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "\u0016/\u0000N\u001b\u00172MH\u0015\ff\u0003D\u0000B$\b\u000b\u001a\u0007!\f_\u001d\u0014#";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000b:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x0057;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r2;
        r10 = r8;
        r13 = r7;
        r7 = r2;
        r2 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x004b;
            case 1: goto L_0x004e;
            case 2: goto L_0x0051;
            case 3: goto L_0x0054;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x0018;
    L_0x002d:
        r7 = r2;
        r2 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r3] = r2;
        r0 = "75\bYY#!\bE\u0000";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r3] = r2;
        z = r6;
        return;
    L_0x004b:
        r11 = 98;
        goto L_0x0021;
    L_0x004e:
        r11 = 70;
        goto L_0x0021;
    L_0x0051:
        r11 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        goto L_0x0021;
    L_0x0054:
        r11 = 43;
        goto L_0x0021;
    L_0x0057:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpRequest.<clinit>():void");
    }

    public HttpRequest(String str) {
        this.a = str;
        this.b = -1;
        this.c = -1;
        this.e = new HashMap();
    }

    public HttpRequest(String str, Map<String, String> map) {
        this.a = str;
        this.d = map;
        this.b = -1;
        this.c = -1;
        this.e = new HashMap();
    }

    public Object getBody() {
        return this.f;
    }

    public int getConnectTimeout() {
        return this.b;
    }

    public byte[] getParas() {
        if (this.f != null) {
            if (this.f instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) this.f)) {
                    return ((String) this.f).getBytes();
                }
            } else if (this.f instanceof byte[]) {
                return (byte[]) this.f;
            }
        }
        Object joinParasWithEncodedValue = HttpUtils.joinParasWithEncodedValue(this.d);
        return !TextUtils.isEmpty(joinParasWithEncodedValue) ? joinParasWithEncodedValue.getBytes() : null;
    }

    public Map<String, String> getParasMap() {
        return this.d;
    }

    public int getReadTimeout() {
        return this.c;
    }

    public Map<String, String> getRequestProperties() {
        return this.e;
    }

    public String getRequestProperty(String str) {
        return (String) this.e.get(str);
    }

    public String getUrl() {
        return this.a;
    }

    public boolean isDoInPut() {
        return this.h;
    }

    public boolean isDoOutPut() {
        return this.g;
    }

    public boolean isHaveRspData() {
        return this.j;
    }

    public boolean isUseCaches() {
        return this.i;
    }

    public void setBody(Object obj) {
        this.f = obj;
    }

    public void setConnectTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(z[0]);
        }
        this.b = i;
    }

    public void setDoInPut(boolean z) {
        this.h = z;
    }

    public void setDoOutPut(boolean z) {
        this.g = z;
    }

    public void setHaveRspData(boolean z) {
        this.j = z;
    }

    public void setParasMap(Map<String, String> map) {
        this.d = map;
    }

    public void setReadTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(z[0]);
        }
        this.c = i;
    }

    public void setRequestProperties(Map<String, String> map) {
        this.e = map;
    }

    public void setRequestProperty(String str, String str2) {
        this.e.put(str, str2);
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public void setUseCaches(boolean z) {
        this.i = z;
    }

    public void setUserAgent(String str) {
        this.e.put(z[1], str);
    }
}
