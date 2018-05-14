package org.apache.http.impl.client;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class ClientParamsStack extends AbstractHttpParams {
    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    public ClientParamsStack(HttpParams httpParams, HttpParams httpParams2, HttpParams httpParams3, HttpParams httpParams4) {
        this.applicationParams = httpParams;
        this.clientParams = httpParams2;
        this.requestParams = httpParams3;
        this.overrideParams = httpParams4;
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack) {
        this(clientParamsStack.getApplicationParams(), clientParamsStack.getClientParams(), clientParamsStack.getRequestParams(), clientParamsStack.getOverrideParams());
    }

    public ClientParamsStack(ClientParamsStack clientParamsStack, HttpParams httpParams, HttpParams httpParams2, HttpParams httpParams3, HttpParams httpParams4) {
        if (httpParams == null) {
            httpParams = clientParamsStack.getApplicationParams();
        }
        if (httpParams2 == null) {
            httpParams2 = clientParamsStack.getClientParams();
        }
        if (httpParams3 == null) {
            httpParams3 = clientParamsStack.getRequestParams();
        }
        if (httpParams4 == null) {
            httpParams4 = clientParamsStack.getOverrideParams();
        }
        this(httpParams, httpParams2, httpParams3, httpParams4);
    }

    public final HttpParams getApplicationParams() {
        return this.applicationParams;
    }

    public final HttpParams getClientParams() {
        return this.clientParams;
    }

    public final HttpParams getRequestParams() {
        return this.requestParams;
    }

    public final HttpParams getOverrideParams() {
        return this.overrideParams;
    }

    public Object getParameter(String str) {
        Args.notNull(str, "Parameter name");
        Object obj = null;
        if (this.overrideParams != null) {
            obj = this.overrideParams.getParameter(str);
        }
        if (obj == null && this.requestParams != null) {
            obj = this.requestParams.getParameter(str);
        }
        if (obj == null && this.clientParams != null) {
            obj = this.clientParams.getParameter(str);
        }
        if (obj != null || this.applicationParams == null) {
            return obj;
        }
        return this.applicationParams.getParameter(str);
    }

    public HttpParams setParameter(String str, Object obj) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
    }

    public boolean removeParameter(String str) {
        throw new UnsupportedOperationException("Removing parameters in a stack is not supported.");
    }

    public HttpParams copy() {
        return this;
    }
}
