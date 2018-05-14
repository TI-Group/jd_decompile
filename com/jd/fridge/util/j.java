package com.jd.fridge.util;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: TbsSdkJava */
public class j {
    public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String b = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/fridgeJD/");
    public static final String c = (b + "fridgeJD.log");
    private static String[] e = new String[8];
    private FileWriter d;

    static {
        e[0] = "";
        e[1] = "";
        e[2] = "verbose";
        e[3] = "debug";
        e[4] = "info";
        e[5] = "warn";
        e[6] = "error";
        e[7] = "ASSERT";
    }

    public j() throws RuntimeException, IOException {
        File file = new File(a);
        File file2 = new File(c);
        if (file.exists()) {
            file = new File(b);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file2.exists()) {
                if ((file2.length() >>> 20) > 2) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        r.b("LogHelper", e.getMessage());
                    }
                }
            } else if (!file2.createNewFile()) {
                r.b("LogHelper", "Create new file failed.");
            }
            this.d = new FileWriter(file2, true);
            return;
        }
        throw new RuntimeException("SD card not exists!");
    }

    public void a(int i, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyy:MM:dd kk:mm:ss.SSS").format(new Date()));
        stringBuffer.append(' ');
        stringBuffer.append(e[i]);
        stringBuffer.append(' ');
        stringBuffer.append(str);
        stringBuffer.append(' ');
        stringBuffer.append(str2);
        stringBuffer.append('\n');
        try {
            this.d.write(stringBuffer.toString());
            this.d.flush();
        } catch (Throwable e) {
            r.a("FileLog", "", e);
        }
    }
}
