package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache.Entry;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

/* compiled from: TbsSdkJava */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.NetworkResponse performRequest(com.android.volley.Request<?> r13) throws com.android.volley.VolleyError {
        /*
        r12 = this;
        r10 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r2 = 0;
        r5 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00b1 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00b1 }
        r3 = r13.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00b1 }
        r12.addCacheHeaders(r0, r3);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00b1 }
        r3 = r12.mHttpStack;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00b1 }
        r8 = r3.performRequest(r13, r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x00b1 }
        r6 = r8.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0101 }
        r9 = r6.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0101 }
        r0 = r8.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0101 }
        r7 = convertHeaders(r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0101 }
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r9 != r0) goto L_0x0048;
    L_0x0031:
        r0 = new com.android.volley.NetworkResponse;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r1 = r13.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        if (r1 != 0) goto L_0x0041;
    L_0x003b:
        r1 = 0;
    L_0x003c:
        r3 = 1;
        r0.<init>(r2, r1, r7, r3);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
    L_0x0040:
        return r0;
    L_0x0041:
        r1 = r13.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r1 = r1.data;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        goto L_0x003c;
    L_0x0048:
        r0 = r8.getEntity();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        if (r0 == 0) goto L_0x007b;
    L_0x004e:
        r0 = r8.getEntity();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r5 = r12.entityToBytes(r0);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
    L_0x0056:
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r2 = r0 - r10;
        r1 = r12;
        r4 = r13;
        r1.logSlowRequests(r2, r4, r5, r6);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r0) goto L_0x0069;
    L_0x0065:
        r0 = 299; // 0x12b float:4.19E-43 double:1.477E-321;
        if (r9 <= r0) goto L_0x007f;
    L_0x0069:
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
    L_0x006f:
        r0 = move-exception;
        r0 = "socket";
        r1 = new com.android.volley.TimeoutError;
        r1.<init>();
        attemptRetryOnException(r0, r13, r1);
        goto L_0x0004;
    L_0x007b:
        r0 = 0;
        r5 = new byte[r0];	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        goto L_0x0056;
    L_0x007f:
        r0 = new com.android.volley.NetworkResponse;	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        r1 = 0;
        r0.<init>(r9, r5, r7, r1);	 Catch:{ SocketTimeoutException -> 0x006f, ConnectTimeoutException -> 0x0086, MalformedURLException -> 0x0093, IOException -> 0x0104 }
        goto L_0x0040;
    L_0x0086:
        r0 = move-exception;
        r0 = "connection";
        r1 = new com.android.volley.TimeoutError;
        r1.<init>();
        attemptRetryOnException(r0, r13, r1);
        goto L_0x0004;
    L_0x0093:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Bad URL ";
        r2 = r2.append(r3);
        r3 = r13.getUrl();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00b1:
        r0 = move-exception;
    L_0x00b2:
        r3 = 0;
        if (r2 == 0) goto L_0x00ef;
    L_0x00b5:
        r0 = r2.getStatusLine();
        r0 = r0.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r0);
        r4[r6] = r7;
        r6 = 1;
        r7 = r13.getUrl();
        r4[r6] = r7;
        com.android.volley.VolleyLog.e(r2, r4);
        if (r5 == 0) goto L_0x00fb;
    L_0x00d5:
        r2 = new com.android.volley.NetworkResponse;
        r3 = 0;
        r2.<init>(r0, r5, r1, r3);
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r1) goto L_0x00e3;
    L_0x00df:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r1) goto L_0x00f5;
    L_0x00e3:
        r0 = "auth";
        r1 = new com.android.volley.AuthFailureError;
        r1.<init>(r2);
        attemptRetryOnException(r0, r13, r1);
        goto L_0x0004;
    L_0x00ef:
        r1 = new com.android.volley.NoConnectionError;
        r1.<init>(r0);
        throw r1;
    L_0x00f5:
        r0 = new com.android.volley.ServerError;
        r0.<init>(r2);
        throw r0;
    L_0x00fb:
        r0 = new com.android.volley.NetworkError;
        r0.<init>(r3);
        throw r0;
    L_0x0101:
        r0 = move-exception;
        r2 = r8;
        goto L_0x00b2;
    L_0x0104:
        r0 = move-exception;
        r1 = r7;
        r2 = r8;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.performRequest(com.android.volley.Request):com.android.volley.NetworkResponse");
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) SLOW_REQUEST_THRESHOLD_MS)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d(str, objArr);
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
            throw e;
        }
    }

    private void addCacheHeaders(Map<String, String> map, Entry entry) {
        if (entry != null) {
            if (entry.etag != null) {
                map.put(HttpHeaders.IF_NONE_MATCH, entry.etag);
            }
            if (entry.serverDate > 0) {
                map.put(HttpHeaders.IF_MODIFIED_SINCE, DateUtils.formatDate(new Date(entry.serverDate)));
            }
        }
    }

    protected void logError(String str, String str2, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(elapsedRealtime - j), str2);
    }

    private byte[] entityToBytes(HttpEntity httpEntity) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new ServerError();
            }
            bArr = this.mPool.getBuf(1024);
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = poolingByteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(bArr);
            poolingByteArrayOutputStream.close();
        }
    }

    private static Map<String, String> convertHeaders(Header[] headerArr) {
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
