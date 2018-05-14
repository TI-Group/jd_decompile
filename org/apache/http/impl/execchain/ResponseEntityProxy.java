package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.EofSensorInputStream;
import org.apache.http.conn.EofSensorWatcher;
import org.apache.http.entity.HttpEntityWrapper;

@NotThreadSafe
/* compiled from: TbsSdkJava */
class ResponseEntityProxy extends HttpEntityWrapper implements EofSensorWatcher {
    private final ConnectionHolder connHolder;

    public static void enchance(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && entity.isStreaming() && connectionHolder != null) {
            httpResponse.setEntity(new ResponseEntityProxy(entity, connectionHolder));
        }
    }

    ResponseEntityProxy(HttpEntity httpEntity, ConnectionHolder connectionHolder) {
        super(httpEntity);
        this.connHolder = connectionHolder;
    }

    private void cleanup() {
        if (this.connHolder != null) {
            this.connHolder.abortConnection();
        }
    }

    public void releaseConnection() throws IOException {
        if (this.connHolder != null) {
            try {
                if (this.connHolder.isReusable()) {
                    this.connHolder.releaseConnection();
                }
                cleanup();
            } catch (Throwable th) {
                cleanup();
            }
        }
    }

    public boolean isRepeatable() {
        return false;
    }

    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    @Deprecated
    public void consumeContent() throws IOException {
        releaseConnection();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            this.wrappedEntity.writeTo(outputStream);
            releaseConnection();
        } finally {
            cleanup();
        }
    }

    public boolean eofDetected(InputStream inputStream) throws IOException {
        try {
            inputStream.close();
            releaseConnection();
            return false;
        } finally {
            cleanup();
        }
    }

    public boolean streamClosed(InputStream inputStream) throws IOException {
        boolean z;
        try {
            z = (this.connHolder == null || this.connHolder.isReleased()) ? false : true;
            inputStream.close();
            releaseConnection();
        } catch (SocketException e) {
            if (z) {
                throw e;
            }
        } catch (Throwable th) {
            cleanup();
        }
        cleanup();
        return false;
    }

    public boolean streamAbort(InputStream inputStream) throws IOException {
        cleanup();
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ResponseEntityProxy{");
        stringBuilder.append(this.wrappedEntity);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
