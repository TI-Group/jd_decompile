package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 9;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\n\r[PT\u001d\u0005L";
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
            case 0: goto L_0x0082;
            case 1: goto L_0x0085;
            case 2: goto L_0x0088;
            case 3: goto L_0x008b;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 58;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\f\u0003N";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\n\r[PY\u0013\fL";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0015\u0006Z{[\u0010\u0004v{C\f\r";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0012\tDj";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001b\r]/[\f\u0018\tfT\u001a\u0007\tjH\u000e\u0007[5";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "5\u0006Z{[\u0010\u0004Lk{\f\u0018EfY\u001d\u001c@`T\u000f";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001b\r]FT\u000f\u001cHcV\u0019\fynY\u0017\tNjI\\!Gk_\u0004'\\{u\u001a*FzT\u0018\u001blwY\u0019\u0018]fU\u0012HL}H\u0012\u0007";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u001b\r]FT\u000f\u001cHcV\u0019\fynY\u0017\tNjI\\\r[}T\u0013";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0082:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        goto L_0x0020;
    L_0x0085:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        goto L_0x0020;
    L_0x0088:
        r9 = 41;
        goto L_0x0020;
    L_0x008b:
        r9 = 15;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.d.<clinit>():void");
    }

    public static ArrayList<g> a(Context context, boolean z) {
        ArrayList<g> arrayList = new ArrayList();
        try {
            List installedPackages = context.getPackageManager().getInstalledPackages(0);
            for (int i = 0; i < installedPackages.size(); i++) {
                try {
                    PackageInfo packageInfo = (PackageInfo) installedPackages.get(i);
                    g gVar = new g();
                    gVar.a = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                    gVar.b = packageInfo.packageName;
                    gVar.c = packageInfo.versionName;
                    gVar.d = packageInfo.versionCode;
                    gVar.e = cn.jiguang.e.d.a(packageInfo.applicationInfo);
                    arrayList.add(gVar);
                } catch (IndexOutOfBoundsException e) {
                    cn.jiguang.c.d.c(z[6], z[7]);
                } catch (Throwable th) {
                    cn.jiguang.c.d.c(z[6], new StringBuilder(z[5]).append(th.getMessage()).toString());
                }
            }
        } catch (IndexOutOfBoundsException e2) {
            cn.jiguang.c.d.c(z[6], z[7]);
        } catch (Throwable th2) {
            cn.jiguang.c.d.c(z[6], z[8]);
        }
        return arrayList;
    }

    public static String[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (Throwable th) {
            cn.jiguang.c.d.e(z[6], "", th);
            return null;
        }
    }

    public static JSONArray b(Context context) {
        ArrayList a = a(context, true);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(z[4], gVar.a);
                jSONObject.put(z[1], gVar.b);
                jSONObject.put(z[0], gVar.c);
                jSONObject.put(z[2], gVar.d);
                jSONObject.put(z[3], gVar.e);
                jSONArray.put(jSONObject);
            }
        } catch (Throwable th) {
        }
        return jSONArray;
    }
}
