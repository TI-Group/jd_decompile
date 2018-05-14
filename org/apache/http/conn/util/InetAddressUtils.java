package org.apache.http.conn.util;

import java.util.regex.Pattern;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class InetAddressUtils {
    private static final char COLON_CHAR = ':';
    private static final String IPV4_BASIC_PATTERN_STRING = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    private static final Pattern IPV4_MAPPED_IPV6_PATTERN = Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
    private static final int MAX_COLON_COUNT = 7;

    private InetAddressUtils() {
    }

    public static boolean isIPv4Address(String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv4MappedIPv64Address(String str) {
        return IPV4_MAPPED_IPV6_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6StdAddress(String str) {
        return IPV6_STD_PATTERN.matcher(str).matches();
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == COLON_CHAR) {
                i++;
            }
        }
        if (i > 7 || !IPV6_HEX_COMPRESSED_PATTERN.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static boolean isIPv6Address(String str) {
        return isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str);
    }
}
