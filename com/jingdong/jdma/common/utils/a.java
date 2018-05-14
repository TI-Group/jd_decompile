package com.jingdong.jdma.common.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import cn.jiguang.net.HttpUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public class a {
    public static String a = "JDMtaUtils";

    public static String a(Context context, String str) {
        Exception exception;
        Throwable th;
        String str2 = "";
        if (context == null || e.a(context) == null) {
            return str2;
        }
        String absolutePath = e.a(context).getAbsolutePath();
        String packageName = context.getPackageName();
        File file = new File(absolutePath + HttpUtils.PATHS_SEPARATOR + packageName + HttpUtils.PATHS_SEPARATOR + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(absolutePath + HttpUtils.PATHS_SEPARATOR + packageName + HttpUtils.PATHS_SEPARATOR + a + HttpUtils.PATHS_SEPARATOR + str);
        if (!file2.exists()) {
            return "";
        }
        absolutePath = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file2));
            absolutePath = str2;
            while (true) {
                try {
                    str2 = bufferedReader.readLine();
                    if (str2 == null) {
                        break;
                    }
                    absolutePath = absolutePath + str2 + CommonUtil.huanhangSymbol;
                } catch (Exception e) {
                    Exception exception2 = e;
                    str2 = absolutePath;
                    exception = exception2;
                }
            }
            int lastIndexOf = absolutePath.lastIndexOf(CommonUtil.huanhangSymbol);
            if (absolutePath == null || absolutePath.length() < lastIndexOf) {
                str2 = absolutePath;
            } else {
                str2 = absolutePath.substring(0, lastIndexOf);
            }
            try {
                bufferedReader.close();
                if (bufferedReader == null) {
                    return str2;
                }
                try {
                    bufferedReader.close();
                    return str2;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return str2;
                }
            } catch (Exception e3) {
                exception = e3;
                try {
                    exception.printStackTrace();
                    if (bufferedReader != null) {
                        return str2;
                    }
                    try {
                        bufferedReader.close();
                        return str2;
                    } catch (IOException e22) {
                        e22.printStackTrace();
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            exception = e4;
            bufferedReader = null;
            exception.printStackTrace();
            if (bufferedReader != null) {
                return str2;
            }
            bufferedReader.close();
            return str2;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static String b(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, "");
    }

    public static void a(Context context, String str, String str2) {
        String absolutePath = e.a(context).getAbsolutePath();
        String packageName = context.getPackageName();
        File file = new File(absolutePath + HttpUtils.PATHS_SEPARATOR + packageName + HttpUtils.PATHS_SEPARATOR + a);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(absolutePath + HttpUtils.PATHS_SEPARATOR + packageName + HttpUtils.PATHS_SEPARATOR + a + HttpUtils.PATHS_SEPARATOR + str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str2);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Context context, String str, String str2) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
