package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicResponseHandler implements ResponseHandler<String> {
    public String handleResponse(HttpResponse httpResponse) throws HttpResponseException, IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        HttpEntity entity = httpResponse.getEntity();
        if (statusLine.getStatusCode() < 300) {
            return entity == null ? null : EntityUtils.toString(entity);
        } else {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
    }
}
