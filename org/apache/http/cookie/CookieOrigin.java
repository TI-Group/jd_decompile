package org.apache.http.cookie;

import cn.jiguang.net.HttpUtils;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public final class CookieOrigin {
    private final String host;
    private final String path;
    private final int port;
    private final boolean secure;

    public CookieOrigin(String str, int i, String str2, boolean z) {
        Args.notBlank(str, "Host");
        Args.notNegative(i, "Port");
        Args.notNull(str2, "Path");
        this.host = str.toLowerCase(Locale.ENGLISH);
        this.port = i;
        if (str2.trim().length() != 0) {
            this.path = str2;
        } else {
            this.path = HttpUtils.PATHS_SEPARATOR;
        }
        this.secure = z;
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        if (this.secure) {
            stringBuilder.append("(secure)");
        }
        stringBuilder.append(this.host);
        stringBuilder.append(':');
        stringBuilder.append(Integer.toString(this.port));
        stringBuilder.append(this.path);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
