package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;
import org.apache.http.util.Args;

@Deprecated
/* compiled from: TbsSdkJava */
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams httpParams, HttpParams httpParams2) {
        this.local = (HttpParams) Args.notNull(httpParams, "Local HTTP parameters");
        this.defaults = httpParams2;
    }

    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Object getParameter(String str) {
        Object parameter = this.local.getParameter(str);
        if (parameter != null || this.defaults == null) {
            return parameter;
        }
        return this.defaults.getParameter(str);
    }

    public boolean removeParameter(String str) {
        return this.local.removeParameter(str);
    }

    public HttpParams setParameter(String str, Object obj) {
        return this.local.setParameter(str, obj);
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getNames() {
        Set<String> hashSet = new HashSet(getNames(this.defaults));
        hashSet.addAll(getNames(this.local));
        return hashSet;
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    private Set<String> getNames(HttpParams httpParams) {
        if (httpParams instanceof HttpParamsNames) {
            return ((HttpParamsNames) httpParams).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
