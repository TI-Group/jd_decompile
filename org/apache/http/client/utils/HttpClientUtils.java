package org.apache.http.client.utils;

import java.io.Closeable;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

/* compiled from: TbsSdkJava */
public class HttpClientUtils {
    private HttpClientUtils() {
    }

    public static void closeQuietly(HttpResponse httpResponse) {
        if (httpResponse != null) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                try {
                    EntityUtils.consume(entity);
                } catch (IOException e) {
                }
            }
        }
    }

    public static void closeQuietly(CloseableHttpResponse closeableHttpResponse) {
        if (closeableHttpResponse != null) {
            try {
                EntityUtils.consume(closeableHttpResponse.getEntity());
                closeableHttpResponse.close();
            } catch (IOException e) {
            } catch (Throwable th) {
                closeableHttpResponse.close();
            }
        }
    }

    public static void closeQuietly(HttpClient httpClient) {
        if (httpClient != null && (httpClient instanceof Closeable)) {
            try {
                ((Closeable) httpClient).close();
            } catch (IOException e) {
            }
        }
    }
}
