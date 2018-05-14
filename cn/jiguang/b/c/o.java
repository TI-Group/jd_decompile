package cn.jiguang.b.c;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class o {
    private static o d;
    private static final String[] z;
    private String[] a = null;
    private j[] b = null;
    private int c = -1;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 38;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "dPe\\\u001eoC~\\\u001fy";
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
            case 0: goto L_0x01cb;
            case 1: goto L_0x01cf;
            case 2: goto L_0x01d3;
            case 3: goto L_0x01d7;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
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
            case 26: goto L_0x014d;
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            case 29: goto L_0x016e;
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            case 33: goto L_0x019a;
            case 34: goto L_0x01a5;
            case 35: goto L_0x01b0;
            case 36: goto L_0x01bb;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "yDf\u0017\u0003oE&]\u0003y\u001fZ\\\u001ee]~\\\u001fI^f_\u0004mDzX\u0019c^f";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "eAmW";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "yTiK\u000eb]aJ\u0019";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "yTiK\u000eb";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "dUgM\u001e0";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "n^eX\u0004d";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "eA|P\u0002dB";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "dPe\\\u001eoC~\\\u001f";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "eB&W\fgT";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "}XfP\u001diWo\u0017\u0002E";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "%T|ZBxT{V\u0001|\u001fkV\u0003l";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "}XfP\u001diWo\u0019Bk]d\u0019BhP|Z\u0005*";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "`P~XC|Tf]\u0002x";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "cAkV\u0003lXo\u0019Bk]d";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "]Xf]\u0002}B";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "3\t";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "K_lK\u0002cU";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "yH{\u0003BoEk\u0016\u001foBgU\u001b$Rn^";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "3\u0004";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "DT|n\fxT";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "Gt";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "b^{M2dPe\\";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "zCaT\fxHW]\u0003yn{L\u000blXp";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "n_{f\u001eWnP\u0015";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "n_{f\u001eoC~\\\u001fy";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "$FaW\teF{\u0017)Db[\\\u001f|Tz";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "n_{\u0017\u001eoC~\\\u001f";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "n_{\u0017\u001eoPzZ\u0005";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "eCo\u0017\u0015hXdUCN[\u0017\u001ac_lV\u001ay\u001fxX\u001fyT&[\u0018lWmK";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "dT|\u0017\tdB:";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "Tml\u0012EV\u001fT]F#J;DI";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "dT|\u0017\tdB<";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "mT|";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "dT|\u0017\tdB;";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "k_lK\u0002cU&V\u001e$bqJ\u0019o\\XK\u0002zTzM\u0004oB";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "dT|\u0017\tdB9";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "Tj8\u0014Tk\u001cndF\"\u000bS\t@3P%_0 \u0018#\u00036:\u001c1X@ll#\u001d";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        z = r4;
        r0 = new cn.jiguang.b.c.o;
        r0.<init>();
        r1 = cn.jiguang.b.c.o.class;
        monitor-enter(r1);
        d = r0;	 Catch:{ all -> 0x01db }
        monitor-exit(r1);	 Catch:{ all -> 0x01db }
        return;
    L_0x01cb:
        r9 = 10;
        goto L_0x0020;
    L_0x01cf:
        r9 = 49;
        goto L_0x0020;
    L_0x01d3:
        r9 = 8;
        goto L_0x0020;
    L_0x01d7:
        r9 = 57;
        goto L_0x0020;
    L_0x01db:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01db }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.o.<clinit>():void");
    }

    public o() {
        if (!c() && !d()) {
            if (this.a == null || this.b == null) {
                String property = System.getProperty(z[9]);
                String property2 = System.getProperty(z[13]);
                if (property.indexOf(z[15]) != -1) {
                    if (property.indexOf(z[19]) == -1 && property.indexOf(z[16]) == -1 && property.indexOf(z[21]) == -1) {
                        try {
                            Process exec = Runtime.getRuntime().exec(z[14]);
                            a(exec.getInputStream());
                            exec.destroy();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    property = z[10];
                    try {
                        Runtime.getRuntime().exec(new StringBuilder(z[12]).append(property).toString()).waitFor();
                        a(new FileInputStream(new File(property)));
                        new File(property).delete();
                    } catch (Exception e2) {
                    }
                } else if (property.indexOf(z[20]) != -1) {
                    b(z[18]);
                } else if (property2.indexOf(z[17]) != -1) {
                    e();
                } else {
                    b(z[11]);
                }
            }
        }
    }

    private static int a(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(6));
            if (parseInt >= 0) {
                return parseInt;
            }
        } catch (NumberFormatException e) {
        }
        return -1;
    }

    private void a(InputStream inputStream) {
        int intValue = Integer.getInteger(z[29], 8192).intValue();
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, intValue);
        bufferedInputStream.mark(intValue);
        a(bufferedInputStream, null);
        if (this.a == null) {
            try {
                bufferedInputStream.reset();
                a(bufferedInputStream, new Locale("", ""));
            } catch (IOException e) {
            }
        }
    }

    private void a(InputStream inputStream, Locale locale) {
        String str = o.class.getPackage().getName() + z[26];
        ResourceBundle bundle = locale != null ? ResourceBundle.getBundle(str, locale) : ResourceBundle.getBundle(str);
        String string = bundle.getString(z[22]);
        String string2 = bundle.getString(z[23]);
        String string3 = bundle.getString(z[24]);
        String string4 = bundle.getString(z[25]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Object obj = null;
        Object obj2 = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    Object obj3;
                    String nextToken = stringTokenizer.nextToken();
                    if (readLine.indexOf(":") != -1) {
                        obj2 = null;
                        obj = null;
                    } else {
                        obj3 = obj2;
                        obj2 = obj;
                        obj = obj3;
                    }
                    if (readLine.indexOf(string) != -1) {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        try {
                        } catch (s e) {
                            obj3 = obj;
                            obj = obj2;
                            obj2 = obj3;
                        }
                        try {
                            if (j.a(nextToken, null).b() != 1) {
                                b(nextToken, arrayList2);
                                obj3 = obj;
                                obj = obj2;
                                obj2 = obj3;
                            }
                        } catch (IOException e2) {
                            return;
                        }
                    } else if (readLine.indexOf(string2) != -1) {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        if (!nextToken.equals(":")) {
                            b(nextToken, arrayList2);
                            obj = obj2;
                            obj2 = 1;
                        }
                    } else if (obj == null && readLine.indexOf(string3) == -1) {
                        if (!(obj2 == null && readLine.indexOf(string4) == -1)) {
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken = stringTokenizer.nextToken();
                            }
                            if (!nextToken.equals(":")) {
                                a(nextToken, arrayList);
                                obj2 = 1;
                            }
                        }
                        obj3 = obj;
                        obj = obj2;
                        obj2 = obj3;
                    } else {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        if (!nextToken.equals(":")) {
                            b(nextToken, arrayList2);
                            obj = obj2;
                            obj2 = 1;
                        }
                    }
                    obj3 = obj;
                    obj = obj2;
                    obj2 = obj3;
                } else {
                    obj = null;
                    obj2 = null;
                }
            } else {
                a(arrayList, arrayList2);
                return;
            }
        }
    }

    private static void a(String str, List list) {
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    private void a(List list, List list2) {
        if (this.a == null && list.size() > 0) {
            this.a = (String[]) list.toArray(new String[0]);
        }
        if (this.b == null && list2.size() > 0) {
            this.b = (j[]) list2.toArray(new j[0]);
        }
    }

    public static synchronized o b() {
        o oVar;
        synchronized (o.class) {
            oVar = d;
        }
        return oVar;
    }

    private void b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            List arrayList = new ArrayList(0);
            List arrayList2 = new ArrayList(0);
            int i = -1;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.startsWith(z[8])) {
                    r5 = new StringTokenizer(readLine);
                    r5.nextToken();
                    a(r5.nextToken(), arrayList);
                } else {
                    try {
                        if (readLine.startsWith(z[6])) {
                            r5 = new StringTokenizer(readLine);
                            r5.nextToken();
                            if (r5.hasMoreTokens() && arrayList2.isEmpty()) {
                                b(r5.nextToken(), arrayList2);
                            }
                        } else if (readLine.startsWith(z[4])) {
                            if (!arrayList2.isEmpty()) {
                                arrayList2.clear();
                            }
                            r5 = new StringTokenizer(readLine);
                            r5.nextToken();
                            while (r5.hasMoreTokens()) {
                                b(r5.nextToken(), arrayList2);
                            }
                        } else if (readLine.startsWith(z[7])) {
                            r5 = new StringTokenizer(readLine);
                            r5.nextToken();
                            while (r5.hasMoreTokens()) {
                                readLine = r5.nextToken();
                                if (readLine.startsWith(z[5])) {
                                    i = a(readLine);
                                }
                            }
                        }
                    } catch (IOException e) {
                    }
                }
            }
            bufferedReader.close();
            a(arrayList, arrayList2);
            if (this.c < 0 && i > 0) {
                this.c = i;
            }
        } catch (FileNotFoundException e2) {
        }
    }

    private static void b(String str, List list) {
        try {
            j a = j.a(str, j.a);
            if (!list.contains(a)) {
                list.add(a);
            }
        } catch (s e) {
        }
    }

    private boolean c() {
        StringTokenizer stringTokenizer;
        List arrayList = new ArrayList(0);
        List arrayList2 = new ArrayList(0);
        String property = System.getProperty(z[27]);
        if (property != null) {
            stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        property = System.getProperty(z[28]);
        if (property != null) {
            stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                b(stringTokenizer.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.a == null || this.b == null) ? false : true;
    }

    private boolean d() {
        List arrayList = new ArrayList(0);
        List arrayList2 = new ArrayList(0);
        try {
            Class[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class cls = Class.forName(z[1]);
            Object invoke = cls.getDeclaredMethod(z[2], clsArr).invoke(null, objArr);
            List<String> list = (List) cls.getMethod(z[0], clsArr).invoke(invoke, objArr);
            List<String> list2 = (List) cls.getMethod(z[3], clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                for (String a : list) {
                    a(a, arrayList);
                }
            }
            if (list2.size() > 0) {
                for (String a2 : list2) {
                    b(a2, arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void e() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName(z[35]).getMethod(z[33], new Class[]{String.class});
            String[] strArr = new String[]{z[36], z[30], z[34], z[32]};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, new Object[]{strArr[i]});
                if (str != null && ((str.matches(z[31]) || str.matches(z[37])) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
        }
        a(arrayList, arrayList2);
    }

    public final String[] a() {
        return this.a;
    }
}
