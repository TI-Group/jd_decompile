package org.apache.http.client.protocol;

import java.io.IOException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        int i = 1;
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && entity.getContentLength() != 0) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                HeaderElement[] elements = contentEncoding.getElements();
                if (0 < elements.length) {
                    HeaderElement headerElement = elements[0];
                    String toLowerCase = headerElement.getName().toLowerCase(Locale.ENGLISH);
                    if ("gzip".equals(toLowerCase) || "x-gzip".equals(toLowerCase)) {
                        httpResponse.setEntity(new GzipDecompressingEntity(httpResponse.getEntity()));
                    } else if ("deflate".equals(toLowerCase)) {
                        httpResponse.setEntity(new DeflateDecompressingEntity(httpResponse.getEntity()));
                    } else if (!HTTP.IDENTITY_CODING.equals(toLowerCase)) {
                        throw new HttpException("Unsupported Content-Coding: " + headerElement.getName());
                    } else {
                        return;
                    }
                }
                i = 0;
                if (i != 0) {
                    httpResponse.removeHeaders("Content-Length");
                    httpResponse.removeHeaders("Content-Encoding");
                    httpResponse.removeHeaders(HttpHeaders.CONTENT_MD5);
                }
            }
        }
    }
}
