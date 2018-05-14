package org.apache.http.client.methods;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.protocol.HTTP;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    public HttpEntity getEntity() {
        return this.entity;
    }

    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(firstHeader.getValue());
    }

    public Object clone() throws CloneNotSupportedException {
        HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = (HttpEntityEnclosingRequestBase) super.clone();
        if (this.entity != null) {
            httpEntityEnclosingRequestBase.entity = (HttpEntity) CloneUtils.cloneObject(this.entity);
        }
        return httpEntityEnclosingRequestBase;
    }
}
