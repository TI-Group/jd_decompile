package com.android.volley.toolbox;

import cn.jiguang.net.HttpUtils;
import com.android.volley.Cache.Entry;
import com.android.volley.NetworkResponse;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* compiled from: TbsSdkJava */
public class HttpHeaderParser {
    public static Entry parseCacheHeaders(NetworkResponse networkResponse) {
        long parseDateAsEpoch;
        long j;
        long parseDateAsEpoch2;
        Object obj = null;
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = networkResponse.headers;
        String str = (String) map.get("Date");
        if (str != null) {
            parseDateAsEpoch = parseDateAsEpoch(str);
        } else {
            parseDateAsEpoch = 0;
        }
        str = (String) map.get(HttpHeaders.CACHE_CONTROL);
        if (str != null) {
            String[] split = str.split(",");
            long j3 = 0;
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j3 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    j3 = 0;
                }
            }
            j = j3;
            obj = 1;
        } else {
            j = 0;
        }
        str = (String) map.get(HttpHeaders.EXPIRES);
        if (str != null) {
            parseDateAsEpoch2 = parseDateAsEpoch(str);
        } else {
            parseDateAsEpoch2 = 0;
        }
        str = (String) map.get(HttpHeaders.ETAG);
        if (obj != null) {
            j2 = (1000 * j) + currentTimeMillis;
        } else if (parseDateAsEpoch > 0 && parseDateAsEpoch2 >= parseDateAsEpoch) {
            j2 = (parseDateAsEpoch2 - parseDateAsEpoch) + currentTimeMillis;
        }
        Entry entry = new Entry();
        entry.data = networkResponse.data;
        entry.etag = str;
        entry.softTtl = j2;
        entry.ttl = entry.softTtl;
        entry.serverDate = parseDateAsEpoch;
        entry.responseHeaders = map;
        return entry;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static String parseCharset(Map<String, String> map) {
        String str = (String) map.get("Content-Type");
        if (str != null) {
            String[] split = str.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(HttpUtils.EQUAL_SIGN);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return "ISO-8859-1";
    }
}
