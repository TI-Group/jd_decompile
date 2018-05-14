package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.b.a.e;
import com.tencent.open.GameAppOperation;
import java.io.File;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class aw {
    private final byte[] a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private final int b = 1;
    private final int c = 0;
    private String d = "1.0";
    private String e = null;
    private byte[] f = null;
    private byte[] g = null;
    private byte[] h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private byte[] l = null;
    private byte[] m = null;
    private boolean n = false;

    private aw(byte[] bArr, String str, byte[] bArr2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.e = str;
        this.k = bArr.length;
        this.l = ap.a(bArr);
        this.j = (int) (System.currentTimeMillis() / 1000);
        this.m = bArr2;
    }

    public static String a(Context context) {
        SharedPreferences a = cx.a(context);
        if (a == null) {
            return null;
        }
        return a.getString(GameAppOperation.GAME_SIGNATURE, null);
    }

    public void a(String str) {
        this.f = e.a(str);
    }

    public String a() {
        return e.a(this.f);
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public static aw a(Context context, String str, byte[] bArr) {
        try {
            String k = aq.k(context);
            String c = aq.c(context);
            SharedPreferences a = cx.a(context);
            String string = a.getString(GameAppOperation.GAME_SIGNATURE, null);
            int i = a.getInt("serial", 1);
            aw awVar = new aw(bArr, str, (c + k).getBytes());
            awVar.a(string);
            awVar.a(i);
            awVar.b();
            a.edit().putInt("serial", i + 1).putString(GameAppOperation.GAME_SIGNATURE, awVar.a()).commit();
            awVar.b(context);
            return awVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static aw b(Context context, String str, byte[] bArr) {
        try {
            String k = aq.k(context);
            String c = aq.c(context);
            SharedPreferences a = cx.a(context);
            String string = a.getString(GameAppOperation.GAME_SIGNATURE, null);
            int i = a.getInt("serial", 1);
            aw awVar = new aw(bArr, str, (c + k).getBytes());
            awVar.a(true);
            awVar.a(string);
            awVar.a(i);
            awVar.b();
            a.edit().putInt("serial", i + 1).putString(GameAppOperation.GAME_SIGNATURE, awVar.a()).commit();
            awVar.b(context);
            return awVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b() {
        if (this.f == null) {
            this.f = d();
        }
        if (this.n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f, 1, bArr, 0, 16);
                this.l = e.a(this.l, bArr);
            } catch (Exception e) {
            }
        }
        this.g = a(this.f, this.j);
        this.h = e();
    }

    private byte[] a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        byte[] b = e.b(this.m);
        byte[] b2 = e.b(this.l);
        int length = b.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (i2 = 0; i2 < length; i2++) {
            bArr2[i2 * 2] = b2[i2];
            bArr2[(i2 * 2) + 1] = b[i2];
        }
        for (i2 = 0; i2 < 2; i2++) {
            bArr2[i2] = bArr[i2];
            bArr2[(bArr2.length - i2) - 1] = bArr[(bArr.length - i2) - 1];
        }
        byte[] bArr3 = new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        while (i3 < bArr2.length) {
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr3[i3 % 4]);
            i3++;
        }
        return bArr2;
    }

    private byte[] d() {
        return a(this.a, (int) (System.currentTimeMillis() / 1000));
    }

    private byte[] e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.a(this.f));
        stringBuilder.append(this.i);
        stringBuilder.append(this.j);
        stringBuilder.append(this.k);
        stringBuilder.append(e.a(this.g));
        return e.b(stringBuilder.toString().getBytes());
    }

    public byte[] c() {
        av anVar = new an();
        anVar.a(this.d);
        anVar.b(this.e);
        anVar.c(e.a(this.f));
        anVar.a(this.i);
        anVar.c(this.j);
        anVar.d(this.k);
        anVar.a(this.l);
        anVar.e(this.n ? 1 : 0);
        anVar.d(e.a(this.g));
        anVar.e(e.a(this.h));
        try {
            return new bb().a(anVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(Context context) {
        String str = this.e;
        String b = cg.a(context).b().b(null);
        String a = e.a(this.f);
        Object obj = new byte[16];
        System.arraycopy(this.f, 2, obj, 0, 16);
        String a2 = e.a(e.b(obj));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (b != null) {
                jSONObject.put("umid", b);
            }
            jSONObject.put(GameAppOperation.GAME_SIGNATURE, a);
            jSONObject.put("checksum", a2);
            str = jSONObject.toString();
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            ar.a(new File(file, "exchangeIdentity.json"), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        int i = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("version : %s\n", new Object[]{this.d}));
        stringBuilder.append(String.format("address : %s\n", new Object[]{this.e}));
        stringBuilder.append(String.format("signature : %s\n", new Object[]{e.a(this.f)}));
        stringBuilder.append(String.format("serial : %s\n", new Object[]{Integer.valueOf(this.i)}));
        stringBuilder.append(String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.j)}));
        stringBuilder.append(String.format("length : %d\n", new Object[]{Integer.valueOf(this.k)}));
        stringBuilder.append(String.format("guid : %s\n", new Object[]{e.a(this.g)}));
        stringBuilder.append(String.format("checksum : %s ", new Object[]{e.a(this.h)}));
        String str = "codex : %d";
        Object[] objArr = new Object[1];
        if (!this.n) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
