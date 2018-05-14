package jd.wjlogin_sdk.util;

/* compiled from: TbsSdkJava */
public class ConvertUtil {
    public static String ConvertLimitTimeString(int i) {
        if (i == 0) {
            return "";
        }
        if (i < 60) {
            return String.format(Config.LimitTime_String, new Object[]{Integer.valueOf(i), "秒"});
        } else if (i < 3600) {
            r0 = i / 60;
            return String.format(Config.LimitTime_String, new Object[]{Integer.valueOf(r0), "分钟"});
        } else {
            r0 = i / 3600;
            return String.format(Config.LimitTime_String, new Object[]{Integer.valueOf(r0), "小时"});
        }
    }

    public static String version_to_string(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if (((i >>> 24) & 255) > 0) {
            stringBuilder.append((i >>> 24) & 255);
            stringBuilder.append(".");
        }
        return stringBuilder.append((i >>> 16) & 255).append(".").append((i >>> 8) & 255).append(".").append((i >>> 0) & 255).toString();
    }

    public static int string_to_version(String str) {
        String[] split = str.split("\\.");
        int length = split.length > 4 ? 3 : split.length - 1;
        int i = 0;
        int i2 = 0;
        while (length >= 0) {
            try {
                String str2 = "";
                int i3 = 0;
                while (i3 < split[length].length() && Character.isDigit(split[length].charAt(i3))) {
                    str2 = new StringBuilder(String.valueOf(str2)).append(split[length].charAt(i3)).toString();
                    i3++;
                }
                int parseInt = i2 | ((Integer.parseInt(str2) & 255) << i);
                length--;
                i += 8;
                i2 = parseInt;
            } catch (Exception e) {
                return 0;
            }
        }
        return i2;
    }
}
