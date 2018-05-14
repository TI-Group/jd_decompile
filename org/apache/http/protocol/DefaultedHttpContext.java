package org.apache.http.protocol;

import org.apache.http.util.Args;

@Deprecated
/* compiled from: TbsSdkJava */
public final class DefaultedHttpContext implements HttpContext {
    private final HttpContext defaults;
    private final HttpContext local;

    public DefaultedHttpContext(HttpContext httpContext, HttpContext httpContext2) {
        this.local = (HttpContext) Args.notNull(httpContext, "HTTP context");
        this.defaults = httpContext2;
    }

    public Object getAttribute(String str) {
        Object attribute = this.local.getAttribute(str);
        if (attribute == null) {
            return this.defaults.getAttribute(str);
        }
        return attribute;
    }

    public Object removeAttribute(String str) {
        return this.local.removeAttribute(str);
    }

    public void setAttribute(String str, Object obj) {
        this.local.setAttribute(str, obj);
    }

    public HttpContext getDefaults() {
        return this.defaults;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[local: ").append(this.local);
        stringBuilder.append("defaults: ").append(this.defaults);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
