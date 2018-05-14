package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import com.sina.weibo.sdk.d.d;
import java.net.URI;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

/* compiled from: TbsSdkJava */
public abstract class b implements RedirectHandler {
    private static final String c = b.class.getCanonicalName();
    int a;
    String b;
    private String d;

    public abstract void a();

    public abstract boolean a(String str);

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        d.a(c, "CustomRedirectHandler getLocationURI getRedirectUrl : " + this.d);
        if (TextUtils.isEmpty(this.d)) {
            return null;
        }
        return URI.create(this.d);
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == 302) {
            this.d = httpResponse.getFirstHeader(HttpHeaders.LOCATION).getValue();
            if (!TextUtils.isEmpty(this.d) && this.a < 15 && a(this.d)) {
                this.a++;
                return true;
            }
        } else if (statusCode == 200) {
            this.b = this.d;
        } else {
            a();
        }
        return false;
    }

    public String b() {
        return this.b;
    }
}
