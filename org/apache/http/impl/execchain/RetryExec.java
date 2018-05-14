package org.apache.http.impl.execchain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class RetryExec implements ClientExecChain {
    private final Log log = LogFactory.getLog(getClass());
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientExecChain, HttpRequestRetryHandler httpRequestRetryHandler) {
        Args.notNull(clientExecChain, "HTTP request executor");
        Args.notNull(httpRequestRetryHandler, "HTTP request retry handler");
        this.requestExecutor = clientExecChain;
        this.retryHandler = httpRequestRetryHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.http.client.methods.CloseableHttpResponse execute(org.apache.http.conn.routing.HttpRoute r7, org.apache.http.client.methods.HttpRequestWrapper r8, org.apache.http.client.protocol.HttpClientContext r9, org.apache.http.client.methods.HttpExecutionAware r10) throws java.io.IOException, org.apache.http.HttpException {
        /*
        r6 = this;
        r0 = "HTTP route";
        org.apache.http.util.Args.notNull(r7, r0);
        r0 = "HTTP request";
        org.apache.http.util.Args.notNull(r8, r0);
        r0 = "HTTP context";
        org.apache.http.util.Args.notNull(r9, r0);
        r2 = r8.getAllHeaders();
        r0 = 1;
        r1 = r0;
    L_0x0015:
        r0 = r6.requestExecutor;	 Catch:{ IOException -> 0x001c }
        r0 = r0.execute(r7, r8, r9, r10);	 Catch:{ IOException -> 0x001c }
        return r0;
    L_0x001c:
        r0 = move-exception;
        if (r10 == 0) goto L_0x002d;
    L_0x001f:
        r3 = r10.isAborted();
        if (r3 == 0) goto L_0x002d;
    L_0x0025:
        r1 = r6.log;
        r2 = "Request has been aborted";
        r1.debug(r2);
        throw r0;
    L_0x002d:
        r3 = r6.retryHandler;
        r3 = r3.retryRequest(r0, r1, r9);
        if (r3 == 0) goto L_0x00c3;
    L_0x0035:
        r3 = r6.log;
        r3 = r3.isInfoEnabled();
        if (r3 == 0) goto L_0x0075;
    L_0x003d:
        r3 = r6.log;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "I/O exception (";
        r4 = r4.append(r5);
        r5 = r0.getClass();
        r5 = r5.getName();
        r4 = r4.append(r5);
        r5 = ") caught when processing request to ";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r5 = ": ";
        r4 = r4.append(r5);
        r5 = r0.getMessage();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.info(r4);
    L_0x0075:
        r3 = r6.log;
        r3 = r3.isDebugEnabled();
        if (r3 == 0) goto L_0x0086;
    L_0x007d:
        r3 = r6.log;
        r4 = r0.getMessage();
        r3.debug(r4, r0);
    L_0x0086:
        r3 = org.apache.http.impl.execchain.RequestEntityProxy.isRepeatable(r8);
        if (r3 != 0) goto L_0x009b;
    L_0x008c:
        r1 = r6.log;
        r2 = "Cannot retry non-repeatable request";
        r1.debug(r2);
        r1 = new org.apache.http.client.NonRepeatableRequestException;
        r2 = "Cannot retry request with a non-repeatable request entity";
        r1.<init>(r2, r0);
        throw r1;
    L_0x009b:
        r8.setHeaders(r2);
        r0 = r6.log;
        r0 = r0.isInfoEnabled();
        if (r0 == 0) goto L_0x00be;
    L_0x00a6:
        r0 = r6.log;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Retrying request to ";
        r3 = r3.append(r4);
        r3 = r3.append(r7);
        r3 = r3.toString();
        r0.info(r3);
    L_0x00be:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0015;
    L_0x00c3:
        r1 = r0 instanceof org.apache.http.NoHttpResponseException;
        if (r1 == 0) goto L_0x00ef;
    L_0x00c7:
        r1 = new org.apache.http.NoHttpResponseException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r7.getTargetHost();
        r3 = r3.toHostString();
        r2 = r2.append(r3);
        r3 = " failed to respond";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getStackTrace();
        r1.setStackTrace(r0);
        throw r1;
    L_0x00ef:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.execchain.RetryExec.execute(org.apache.http.conn.routing.HttpRoute, org.apache.http.client.methods.HttpRequestWrapper, org.apache.http.client.protocol.HttpClientContext, org.apache.http.client.methods.HttpExecutionAware):org.apache.http.client.methods.CloseableHttpResponse");
    }
}
