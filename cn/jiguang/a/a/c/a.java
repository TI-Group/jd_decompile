package cn.jiguang.a.a.c;

import android.content.Context;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.h;
import cn.jiguang.e.j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends Thread {
    private static final Object c = new Object();
    private static final Object d = new Object();
    private static final String[] z;
    private String a;
    private Context b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 27;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "'2";
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
            case 0: goto L_0x0155;
            case 1: goto L_0x0158;
            case 2: goto L_0x015c;
            case 3: goto L_0x0160;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
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
        r1 = "@daC=u}}";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "B{F\rs`#x\tr|BU\u001c!ua@\u0004hge\u0010\u001f`g1^\u001dmx=\u0010\u001ad`dB\u0006";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "T@W\u001dP";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "`da`\tbpW\rOu|U\u001b";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "rugUHm{v\u0010\u0001o4fB\u0001uqYY\u001bu{cI$ns";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "b{D\ry`1T\u0001e4_\u001c!}Y\u001c-4cU\u001ctf";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "G}}U\u0018``y\u0010\rsf~BHnr1k\tqdAQ\u000bjuvU&`ytC5!81W\u0001wq1E\u0018!gpF\r!.";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "bu\u0017\u001c!ccY\u001cd4p@\u0018Qur[\tfq_Q\u0005dg1\u001cHf}gUHtd1C\twq1\n";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "rugUHm{v\u0010\u0001o4fB\u0001uqYY\u001bu{cI$ns+:";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "bu\u0017\u001c!qS\u0007e}WH`da`\tbpW\rOu|U\u001b!81W\u0001wq1E\u0018!gpF\r!.";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "`da\\\u0001r`1Y\u001b!zd\\\u0004";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "bu\u0017\u001c!{aU\u0006!ua@8`wzQ\u000fdZp]\rr4~E\u001cqaec\u001csqp]D!sxF\r!aa\u0010\u001b`bt\u0010R";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "mubD7b|tS\u0003^abU\u001a`dao\u001buueE\u001b";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "`weY\u0007o4rX\rb1_\u0004e4p@\u0018!dpS\u0003`st\u0010\u0004hge\n";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "b|tS\u0003TgtB)qdb\u0010\ryqr@\u001ch{\n";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u000b4x^\u001buu}\\\re4p@\u0018Qur[\tfq_Q\u0005d.";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "Sqa_\u001auAbU\u001aTduQ\u001cdUa@\u001b!{}T)qd}Y\u001bu:bY\u0012d<8\n";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "nxu\u0010\tqd}Y\u001bu4xCHoa}\\D!ftD\u001dsz";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "tzx^\u001buu}\\\re4p@\u0018Qur[\tfq_Q\u0005d.";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "`da`\tbpW\rOu|U\u001b!}b\u0010\u0006tx}\u001cHsqeE\u001ao4E\u0004m";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "bu\u0017\u001c!{aU\u0006!ua@8`wzQ\u000fdZp]\rr4x^\u0018t`BD\u001adu|\u001cHf}gUHtd1B\r`p1\u0010R";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "bu\u0017\u001c!qS\u0007e}WH`da`\tbpW\rOu|U\u001b-4vY\u001ed4d@HsqpTH;";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "bu\u0017\u001c!ftQ\f!ua@8`wzQ\u000fdZp]\rr81W\u0001wq1E\u0018!ftQ\f!.";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "`daCHm}bDHhg1^\u001dmx=\u0010\u001ad`dB\u0006";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "r`~B\r!ua@Hqur[\tfq1\\\u0001r`1C\u001dbwtC\u001b";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "r`~B\r!ua@8`wzQ\u000fdZp]\rr.";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        c = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        d = r0;
        return;
    L_0x0155:
        r9 = 1;
        goto L_0x0020;
    L_0x0158:
        r9 = 20;
        goto L_0x0020;
    L_0x015c:
        r9 = 17;
        goto L_0x0020;
    L_0x0160:
        r9 = 48;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.a.<clinit>():void");
    }

    public a(Context context, String str) {
        this.b = context;
        this.a = str;
    }

    private static String a(Context context) {
        Closeable openFileInput;
        FileNotFoundException e;
        Throwable th;
        IOException e2;
        if (context == null) {
            d.g(z[1], z[6]);
            return null;
        }
        try {
            openFileInput = context.openFileInput(z[4]);
            try {
                byte[] bArr = new byte[(openFileInput.available() + 1)];
                openFileInput.read(bArr);
                o.a(openFileInput);
                try {
                    String str = new String(bArr, z[3]);
                    if (!j.a(str)) {
                        return str;
                    }
                    d.c(z[1], z[20]);
                    return null;
                } catch (UnsupportedEncodingException e3) {
                    d.c(z[1], new StringBuilder(z[22]).append(e3.getMessage()).toString());
                    return null;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                try {
                    d.c(z[1], new StringBuilder(z[21]).append(e.getMessage()).toString());
                    o.a(openFileInput);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    o.a(openFileInput);
                    throw th;
                }
            } catch (IOException e5) {
                e2 = e5;
                d.c(z[1], new StringBuilder(z[23]).append(e2.getMessage()).toString());
                o.a(openFileInput);
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            openFileInput = null;
            d.c(z[1], new StringBuilder(z[21]).append(e.getMessage()).toString());
            o.a(openFileInput);
            return null;
        } catch (IOException e7) {
            e2 = e7;
            openFileInput = null;
            d.c(z[1], new StringBuilder(z[23]).append(e2.getMessage()).toString());
            o.a(openFileInput);
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            o.a(openFileInput);
            throw th;
        }
    }

    private static HashSet<String> a(String str) {
        int i = 0;
        if (str == null) {
            d.a(z[1], z[2]);
            return null;
        }
        String[] split = str.replace("\u0000", "").split(z[0]);
        HashSet<String> hashSet = new HashSet();
        int length = split.length;
        while (i < length) {
            hashSet.add(split[i]);
            i++;
        }
        return hashSet;
    }

    private void a(ArrayList<g> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            d.a(z[1], z[24]);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(((g) arrayList.get(i)).b);
            if (i != arrayList.size() - 1) {
                stringBuilder.append(z[0]);
            }
        }
        d.c(z[1], new StringBuilder(z[26]).append(stringBuilder.toString()).toString());
        if (a(this.b, stringBuilder.toString())) {
            d.c(z[1], z[25]);
        }
    }

    private void a(HashSet<String> hashSet) {
        if (this.b == null) {
            d.g(z[1], z[6]);
        } else if (hashSet == null || hashSet.isEmpty()) {
            d.g(z[1], z[18]);
        } else {
            g gVar;
            JSONObject a;
            d.c(z[1], new StringBuilder(z[17]).append(hashSet.size()).toString());
            JSONArray jSONArray = new JSONArray();
            ArrayList a2 = d.a(this.b, true);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a2);
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                gVar = (g) it.next();
                if (hashSet.remove(gVar.b)) {
                    arrayList.remove(gVar);
                }
                if (!j.a(this.a) && gVar.b.equals(this.a)) {
                    arrayList.remove(gVar);
                }
            }
            if (!j.a(this.a)) {
                hashSet.remove(this.a);
            }
            d.c(z[1], new StringBuilder(z[19]).append(hashSet.toString()).append(z[16]).append(arrayList.toString()).toString());
            it = hashSet.iterator();
            while (it.hasNext()) {
                a = h.a((String) it.next());
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                gVar = (g) it2.next();
                a = h.a(gVar.b, gVar.e);
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            if (jSONArray.length() > 0) {
                o.a(this.b, jSONArray);
            }
            if (jSONArray.length() > 0 || !j.a(this.a)) {
                a(a2);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r8, java.lang.String r9) {
        /*
        r0 = 0;
        r1 = 1;
        if (r8 != 0) goto L_0x0011;
    L_0x0004:
        r2 = z;
        r1 = r2[r1];
        r2 = z;
        r3 = 6;
        r2 = r2[r3];
        cn.jiguang.c.d.g(r1, r2);
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = d;
        monitor-enter(r3);
        if (r9 == 0) goto L_0x0060;
    L_0x0016:
        r2 = z;	 Catch:{ Exception -> 0x004e }
        r4 = 1;
        r2 = r2[r4];	 Catch:{ Exception -> 0x004e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e }
        r5 = z;	 Catch:{ Exception -> 0x004e }
        r6 = 9;
        r5 = r5[r6];	 Catch:{ Exception -> 0x004e }
        r4.<init>(r5);	 Catch:{ Exception -> 0x004e }
        r4 = r4.append(r9);	 Catch:{ Exception -> 0x004e }
        r4 = r4.toString();	 Catch:{ Exception -> 0x004e }
        cn.jiguang.c.d.a(r2, r4);	 Catch:{ Exception -> 0x004e }
    L_0x0031:
        r2 = 0;
        r4 = z;	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        r5 = 4;
        r4 = r4[r5];	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        r5 = 0;
        r2 = r8.openFileOutput(r4, r5);	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        r4 = z;	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        r5 = 3;
        r4 = r4[r5];	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        r4 = r9.getBytes(r4);	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        r2.write(r4);	 Catch:{ FileNotFoundException -> 0x0070, UnsupportedEncodingException -> 0x0096, IOException -> 0x00bc, NullPointerException -> 0x00e2 }
        cn.jiguang.b.d.o.a(r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        r0 = r1;
        goto L_0x0010;
    L_0x004e:
        r2 = move-exception;
        r4 = z;	 Catch:{ all -> 0x005d }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ all -> 0x005d }
        r5 = z;	 Catch:{ all -> 0x005d }
        r6 = 5;
        r5 = r5[r6];	 Catch:{ all -> 0x005d }
        cn.jiguang.c.d.c(r4, r5, r2);	 Catch:{ all -> 0x005d }
        goto L_0x0031;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        throw r0;
    L_0x0060:
        r1 = z;	 Catch:{ all -> 0x005d }
        r2 = 1;
        r1 = r1[r2];	 Catch:{ all -> 0x005d }
        r2 = z;	 Catch:{ all -> 0x005d }
        r4 = 11;
        r2 = r2[r4];	 Catch:{ all -> 0x005d }
        cn.jiguang.c.d.c(r1, r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        goto L_0x0010;
    L_0x0070:
        r1 = move-exception;
        r4 = z;	 Catch:{ all -> 0x0107 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ all -> 0x0107 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r6 = z;	 Catch:{ all -> 0x0107 }
        r7 = 12;
        r6 = r6[r7];	 Catch:{ all -> 0x0107 }
        r5.<init>(r6);	 Catch:{ all -> 0x0107 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0107 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r1.toString();	 Catch:{ all -> 0x0107 }
        cn.jiguang.c.d.c(r4, r1);	 Catch:{ all -> 0x0107 }
        cn.jiguang.b.d.o.a(r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        goto L_0x0010;
    L_0x0096:
        r1 = move-exception;
        r4 = z;	 Catch:{ all -> 0x0107 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ all -> 0x0107 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r6 = z;	 Catch:{ all -> 0x0107 }
        r7 = 10;
        r6 = r6[r7];	 Catch:{ all -> 0x0107 }
        r5.<init>(r6);	 Catch:{ all -> 0x0107 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0107 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r1.toString();	 Catch:{ all -> 0x0107 }
        cn.jiguang.c.d.c(r4, r1);	 Catch:{ all -> 0x0107 }
        cn.jiguang.b.d.o.a(r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        goto L_0x0010;
    L_0x00bc:
        r1 = move-exception;
        r4 = z;	 Catch:{ all -> 0x0107 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ all -> 0x0107 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r6 = z;	 Catch:{ all -> 0x0107 }
        r7 = 8;
        r6 = r6[r7];	 Catch:{ all -> 0x0107 }
        r5.<init>(r6);	 Catch:{ all -> 0x0107 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0107 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r1.toString();	 Catch:{ all -> 0x0107 }
        cn.jiguang.c.d.c(r4, r1);	 Catch:{ all -> 0x0107 }
        cn.jiguang.b.d.o.a(r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        goto L_0x0010;
    L_0x00e2:
        r1 = move-exception;
        r4 = z;	 Catch:{ all -> 0x0107 }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ all -> 0x0107 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0107 }
        r6 = z;	 Catch:{ all -> 0x0107 }
        r7 = 7;
        r6 = r6[r7];	 Catch:{ all -> 0x0107 }
        r5.<init>(r6);	 Catch:{ all -> 0x0107 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0107 }
        r1 = r5.append(r1);	 Catch:{ all -> 0x0107 }
        r1 = r1.toString();	 Catch:{ all -> 0x0107 }
        cn.jiguang.c.d.c(r4, r1);	 Catch:{ all -> 0x0107 }
        cn.jiguang.b.d.o.a(r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r3);	 Catch:{ all -> 0x005d }
        goto L_0x0010;
    L_0x0107:
        r0 = move-exception;
        cn.jiguang.b.d.o.a(r2);	 Catch:{ all -> 0x005d }
        throw r0;	 Catch:{ all -> 0x005d }
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.a.a(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r7 = this;
        r6 = 1;
        r1 = c;	 Catch:{ Exception -> 0x0049 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0049 }
        r0 = r7.b;	 Catch:{ all -> 0x0046 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = z;	 Catch:{ all -> 0x0046 }
        r2 = 1;
        r0 = r0[r2];	 Catch:{ all -> 0x0046 }
        r2 = z;	 Catch:{ all -> 0x0046 }
        r3 = 6;
        r2 = r2[r3];	 Catch:{ all -> 0x0046 }
        cn.jiguang.c.d.g(r0, r2);	 Catch:{ all -> 0x0046 }
        monitor-exit(r1);	 Catch:{ all -> 0x0046 }
    L_0x0016:
        return;
    L_0x0017:
        r0 = r7.b;	 Catch:{ all -> 0x0046 }
        r0 = a(r0);	 Catch:{ all -> 0x0046 }
        r2 = z;	 Catch:{ all -> 0x0046 }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ all -> 0x0046 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0046 }
        r4 = z;	 Catch:{ all -> 0x0046 }
        r5 = 14;
        r4 = r4[r5];	 Catch:{ all -> 0x0046 }
        r3.<init>(r4);	 Catch:{ all -> 0x0046 }
        r3 = r3.append(r0);	 Catch:{ all -> 0x0046 }
        r3 = r3.toString();	 Catch:{ all -> 0x0046 }
        cn.jiguang.c.d.c(r2, r3);	 Catch:{ all -> 0x0046 }
        if (r0 != 0) goto L_0x006c;
    L_0x003a:
        r0 = r7.b;	 Catch:{ all -> 0x0046 }
        r2 = 1;
        r0 = cn.jiguang.a.a.c.d.a(r0, r2);	 Catch:{ all -> 0x0046 }
        r7.a(r0);	 Catch:{ all -> 0x0046 }
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0046 }
        goto L_0x0016;
    L_0x0046:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0046 }
        throw r0;	 Catch:{ Exception -> 0x0049 }
    L_0x0049:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = z;
        r1 = r1[r6];
        r2 = new java.lang.StringBuilder;
        r3 = z;
        r4 = 15;
        r3 = r3[r4];
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        cn.jiguang.c.d.c(r1, r0);
        goto L_0x0016;
    L_0x006c:
        r2 = r7.b;	 Catch:{ all -> 0x0046 }
        r2 = cn.jiguang.b.a.d.f(r2);	 Catch:{ all -> 0x0046 }
        if (r2 != 0) goto L_0x0076;
    L_0x0074:
        monitor-exit(r1);	 Catch:{ all -> 0x0046 }
        goto L_0x0016;
    L_0x0076:
        r2 = r7.b;	 Catch:{ all -> 0x0046 }
        r3 = z;	 Catch:{ all -> 0x0046 }
        r4 = 13;
        r3 = r3[r4];	 Catch:{ all -> 0x0046 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0046 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0046 }
        cn.jiguang.b.a.d.a(r2, r3, r4);	 Catch:{ all -> 0x0046 }
        r0 = a(r0);	 Catch:{ all -> 0x0046 }
        r7.a(r0);	 Catch:{ all -> 0x0046 }
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.a.run():void");
    }
}
