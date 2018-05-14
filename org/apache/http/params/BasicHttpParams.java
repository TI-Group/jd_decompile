package org.apache.http.params;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    private static final long serialVersionUID = -7086398485908701455L;
    private final Map<String, Object> parameters = new ConcurrentHashMap();

    public Object getParameter(String str) {
        return this.parameters.get(str);
    }

    public HttpParams setParameter(String str, Object obj) {
        if (str != null) {
            if (obj != null) {
                this.parameters.put(str, obj);
            } else {
                this.parameters.remove(str);
            }
        }
        return this;
    }

    public boolean removeParameter(String str) {
        if (!this.parameters.containsKey(str)) {
            return false;
        }
        this.parameters.remove(str);
        return true;
    }

    public void setParameters(String[] strArr, Object obj) {
        for (String parameter : strArr) {
            setParameter(parameter, obj);
        }
    }

    public boolean isParameterSet(String str) {
        return getParameter(str) != null;
    }

    public boolean isParameterSetLocally(String str) {
        return this.parameters.get(str) != null;
    }

    public void clear() {
        this.parameters.clear();
    }

    public HttpParams copy() {
        try {
            return (HttpParams) clone();
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException("Cloning not supported");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpParams basicHttpParams = (BasicHttpParams) super.clone();
        copyParams(basicHttpParams);
        return basicHttpParams;
    }

    public void copyParams(HttpParams httpParams) {
        for (Entry entry : this.parameters.entrySet()) {
            httpParams.setParameter((String) entry.getKey(), entry.getValue());
        }
    }

    public Set<String> getNames() {
        return new HashSet(this.parameters.keySet());
    }
}
