package c.a;

import android.content.Context;
import android.text.TextUtils;
import com.b.a.c;
import com.b.a.e;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: TbsSdkJava */
public class cg {
    private static final byte[] a = "pbl0".getBytes();
    private static cg e;
    private cw b;
    private a c = new a();
    private z d = null;
    private Context f;

    /* compiled from: TbsSdkJava */
    public static class a {
        private int a = -1;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private int e = -1;
        private String f = null;
        private int g = -1;
        private String h = null;
        private int i = -1;
        private int j = -1;

        a() {
        }

        public void a(z zVar) {
            if (zVar != null) {
                this.a = a(zVar, "defcon");
                this.b = a(zVar, "latent");
                this.c = a(zVar, "codex");
                this.d = a(zVar, "report_policy");
                this.e = a(zVar, "report_interval");
                this.f = b(zVar, "client_test");
                this.g = a(zVar, "test_report_interval");
                this.h = b(zVar, "umid");
                this.i = a(zVar, "integrated_test");
                this.j = a(zVar, "latent_hours");
            }
        }

        public int a(int i) {
            return (this.a != -1 && this.a <= 3 && this.a >= 0) ? this.a : i;
        }

        public int b(int i) {
            return (this.b != -1 && this.b >= 0 && this.b <= 1800) ? this.b * 1000 : i;
        }

        public int c(int i) {
            if (this.c == 0 || this.c == 1 || this.c == -1) {
                return this.c;
            }
            return i;
        }

        public int[] a(int i, int i2) {
            if (this.d == -1 || !c.a(this.d)) {
                return new int[]{i, i2};
            }
            if (this.e == -1 || this.e < 90 || this.e > 86400) {
                this.e = 90;
            }
            return new int[]{this.d, this.e * 1000};
        }

        public String a(String str) {
            return (this.f == null || !i.a(this.f)) ? str : this.f;
        }

        public int d(int i) {
            return (this.g == -1 || this.g < 90 || this.g > 86400) ? i : this.g * 1000;
        }

        public boolean a() {
            return this.g != -1;
        }

        public String b(String str) {
            return this.h;
        }

        public boolean b() {
            return this.i == 1;
        }

        public long a(long j) {
            return (this.j != -1 && this.j >= 48) ? 3600000 * ((long) this.j) : j;
        }

        private int a(z zVar, String str) {
            if (zVar == null || !zVar.f()) {
                return -1;
            }
            aa aaVar = (aa) zVar.d().get(str);
            if (aaVar == null || TextUtils.isEmpty(aaVar.c())) {
                return -1;
            }
            try {
                return Integer.parseInt(aaVar.c().trim());
            } catch (Exception e) {
                return -1;
            }
        }

        private String b(z zVar, String str) {
            if (zVar == null || !zVar.f()) {
                return null;
            }
            aa aaVar = (aa) zVar.d().get(str);
            if (aaVar == null || TextUtils.isEmpty(aaVar.c())) {
                return null;
            }
            return aaVar.c();
        }
    }

    cg(Context context) {
        this.f = context;
    }

    public static synchronized cg a(Context context) {
        cg cgVar;
        synchronized (cg.class) {
            if (e == null) {
                e = new cg(context);
                e.c();
            }
            cgVar = e;
        }
        return cgVar;
    }

    public void a(cw cwVar) {
        this.b = cwVar;
    }

    public String a(z zVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : new TreeMap(zVar.d()).entrySet()) {
            stringBuilder.append((String) entry.getKey());
            if (((aa) entry.getValue()).e()) {
                stringBuilder.append(((aa) entry.getValue()).c());
            }
            stringBuilder.append(((aa) entry.getValue()).f());
            stringBuilder.append(((aa) entry.getValue()).j());
        }
        stringBuilder.append(zVar.b);
        return ar.a(stringBuilder.toString()).toLowerCase(Locale.US);
    }

    private boolean c(z zVar) {
        if (!zVar.k().equals(a(zVar))) {
            return false;
        }
        for (aa aaVar : zVar.d().values()) {
            byte[] a = e.a(aaVar.j());
            byte[] a2 = a(aaVar);
            for (int i = 0; i < 4; i++) {
                if (a[i] != a2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public byte[] a(aa aaVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(aaVar.f());
        byte[] array = allocate.array();
        byte[] bArr = a;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public void b(z zVar) {
        String str = null;
        if (zVar != null && c(zVar)) {
            Object obj = null;
            synchronized (this) {
                z d;
                z zVar2 = this.d;
                String k = zVar2 == null ? null : zVar2.k();
                if (zVar2 == null) {
                    d = d(zVar);
                } else {
                    d = a(zVar2, zVar);
                }
                this.d = d;
                if (d != null) {
                    str = d.k();
                }
                if (!a(k, str)) {
                    obj = 1;
                }
            }
            if (this.d != null && r0 != null) {
                this.c.a(this.d);
                if (this.b != null) {
                    this.b.a(this.c);
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 != null) {
            return false;
        }
        return true;
    }

    private z a(z zVar, z zVar2) {
        if (zVar2 != null) {
            Map d = zVar.d();
            for (Entry entry : zVar2.d().entrySet()) {
                if (((aa) entry.getValue()).e()) {
                    d.put(entry.getKey(), entry.getValue());
                } else {
                    d.remove(entry.getKey());
                }
            }
            zVar.a(zVar2.h());
            zVar.a(a(zVar));
        }
        return zVar;
    }

    private z d(z zVar) {
        Map d = zVar.d();
        List<String> arrayList = new ArrayList(d.size() / 2);
        for (Entry entry : d.entrySet()) {
            if (!((aa) entry.getValue()).e()) {
                arrayList.add(entry.getKey());
            }
        }
        for (String remove : arrayList) {
            d.remove(remove);
        }
        return zVar;
    }

    public synchronized z a() {
        return this.d;
    }

    public a b() {
        return this.c;
    }

    public void c() {
        InputStream openFileInput;
        byte[] b;
        Exception e;
        z zVar;
        Throwable th;
        InputStream inputStream = null;
        if (new File(this.f.getFilesDir(), ".imprint").exists()) {
            try {
                openFileInput = this.f.openFileInput(".imprint");
                try {
                    b = ar.b(openFileInput);
                    ar.c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        ar.c(openFileInput);
                        if (b == null) {
                            try {
                                zVar = new z();
                                new ay().a(zVar, b);
                                this.d = zVar;
                                this.c.a(zVar);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openFileInput;
                        ar.c(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e3 = e4;
                openFileInput = inputStream;
                e3.printStackTrace();
                ar.c(openFileInput);
                if (b == null) {
                    zVar = new z();
                    new ay().a(zVar, b);
                    this.d = zVar;
                    this.c.a(zVar);
                }
            } catch (Throwable th3) {
                th = th3;
                ar.c(inputStream);
                throw th;
            }
            if (b == null) {
                zVar = new z();
                new ay().a(zVar, b);
                this.d = zVar;
                this.c.a(zVar);
            }
        }
    }

    public void d() {
        if (this.d != null) {
            try {
                ar.a(new File(this.f.getFilesDir(), ".imprint"), new bb().a(this.d));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
