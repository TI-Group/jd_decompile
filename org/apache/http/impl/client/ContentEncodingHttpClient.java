package org.apache.http.impl.client;

import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public class ContentEncodingHttpClient extends DefaultHttpClient {
    public ContentEncodingHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    public ContentEncodingHttpClient(HttpParams httpParams) {
        this(null, httpParams);
    }

    public ContentEncodingHttpClient() {
        this(null);
    }

    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
        createHttpProcessor.addRequestInterceptor(new RequestAcceptEncoding());
        createHttpProcessor.addResponseInterceptor(new ResponseContentEncoding());
        return createHttpProcessor;
    }
}
