package cn.jpush.android.data;

import android.text.TextUtils;
import cn.jpush.android.d.e;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class JPushLocalNotification implements Serializable {
    private static final long serialVersionUID = 1472982106750878137L;
    private static final String[] z;
    private int a = 1;
    private String b = "";
    private String c = z[14];
    private String d = z[14];
    private long e = 0;
    private String f;
    private String g;
    private String h;
    private long i;
    private long j = 1;
    private int k = 1;
    private String l = "";
    private String m = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 15;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "b\u001a:\u001f\u0014X\u0012+\u001f\u0006P\u0016\"\u001e@a\u0013+^\u0013T_-W\u0005R\u0014nF\u000fD\rn^\u0012V\fo";
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
            case 0: goto L_0x00c3;
            case 1: goto L_0x00c7;
            case 2: goto L_0x00cb;
            case 3: goto L_0x00cf;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 96;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "{/;L\b}\u0010-^\f\u0010:V\u0006X\u001c/K\t^\u0011";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\\\f)`\tU";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "_ +G\u0014C\u001e=";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\\ -P\u000eE\u001a K";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "R\u0010 K\u0005_\u000b\u0011K\u0019A\u001a";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "B\u0017!H?E\u0006>Z";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "^\t+M\u0012X\u001b+`\rB\u0018\u0011V\u0004";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "_ -P\u000eE\u001a K";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "_\u0010:V\u0006X\u001c/V\u000f_ :F\u0010T";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "_ :V\u0014]\u001a";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "_ !Q\fH";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "P\u001b\u0011K";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "_ ,J\t]\u001b+M?X\u001b";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0001O";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00c3:
        r9 = 49;
        goto L_0x0020;
    L_0x00c7:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0020;
    L_0x00cb:
        r9 = 78;
        goto L_0x0020;
    L_0x00cf:
        r9 = 63;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.JPushLocalNotification.<clinit>():void");
    }

    private static void a(String str, String str2, JSONObject jSONObject) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.j == ((JPushLocalNotification) obj).j;
    }

    public long getBroadcastTime() {
        return this.e;
    }

    public long getBuilderId() {
        return this.i;
    }

    public String getContent() {
        return this.f;
    }

    public String getExtras() {
        return this.h;
    }

    public long getNotificationId() {
        return this.j;
    }

    public String getTitle() {
        return this.g;
    }

    public int hashCode() {
        return (int) (this.j ^ (this.j >>> 32));
    }

    public void setBroadcastTime(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < 0 || i2 <= 0 || i2 > 12 || i3 <= 0 || i3 > 31 || i4 < 0 || i4 > 23 || i5 < 0 || i5 > 59 || i6 < 0 || i6 > 59) {
            e.j(z[1], z[0]);
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2 - 1, i3, i4, i5, i6);
        Date time = instance.getTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (time.getTime() < currentTimeMillis) {
            this.e = currentTimeMillis;
        } else {
            this.e = time.getTime();
        }
    }

    public void setBroadcastTime(long j) {
        this.e = j;
    }

    public void setBroadcastTime(Date date) {
        this.e = date.getTime();
    }

    public void setBuilderId(long j) {
        this.i = j;
    }

    public void setContent(String str) {
        this.f = str;
    }

    public void setExtras(String str) {
        this.h = str;
    }

    public void setNotificationId(long j) {
        this.j = j;
    }

    public void setTitle(String str) {
        this.g = str;
    }

    public String toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject2.put(z[3], new JSONObject(this.h));
            }
            a(z[8], this.f, jSONObject2);
            a(z[10], this.g, jSONObject2);
            a(z[8], this.f, jSONObject2);
            jSONObject2.put(z[12], 0);
            jSONObject.put(z[4], jSONObject2);
            a(z[2], this.j, jSONObject);
            a(z[5], this.m, jSONObject);
            a(z[7], this.l, jSONObject);
            jSONObject.put(z[11], this.k);
            jSONObject.put(z[13], this.i);
            jSONObject.put(z[6], 3);
            jSONObject.put(z[9], 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
