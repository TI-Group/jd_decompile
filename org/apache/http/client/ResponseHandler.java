package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* compiled from: TbsSdkJava */
public interface ResponseHandler<T> {
    T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException;
}
