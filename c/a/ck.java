package c.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
public class ck extends a {
    private static final Pattern a = Pattern.compile("UTDID\">([^<]+)");
    private Context b;

    public ck(Context context) {
        super("utdid");
        this.b = context;
    }

    public String f() {
        return g();
    }

    private String g() {
        File h = h();
        if (h == null || !h.exists()) {
            return null;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(h);
            String b = b(ar.a(fileInputStream));
            ar.c(fileInputStream);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            ar.c(fileInputStream);
        }
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private File h() {
        if (!aq.a(this.b, "android.permission.WRITE_EXTERNAL_STORAGE") || !Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        } catch (Exception e) {
            return null;
        }
    }
}
