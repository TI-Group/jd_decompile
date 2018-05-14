package org.apache.http.protocol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public final class BasicHttpProcessor implements Cloneable, HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList {
    protected final List<HttpRequestInterceptor> requestInterceptors = new ArrayList();
    protected final List<HttpResponseInterceptor> responseInterceptors = new ArrayList();

    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            this.requestInterceptors.add(httpRequestInterceptor);
        }
    }

    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i) {
        if (httpRequestInterceptor != null) {
            this.requestInterceptors.add(i, httpRequestInterceptor);
        }
    }

    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i) {
        if (httpResponseInterceptor != null) {
            this.responseInterceptors.add(i, httpResponseInterceptor);
        }
    }

    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls) {
        Iterator it = this.requestInterceptors.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                it.remove();
            }
        }
    }

    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls) {
        Iterator it = this.responseInterceptors.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                it.remove();
            }
        }
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        addRequestInterceptor(httpRequestInterceptor);
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i) {
        addRequestInterceptor(httpRequestInterceptor, i);
    }

    public int getRequestInterceptorCount() {
        return this.requestInterceptors.size();
    }

    public HttpRequestInterceptor getRequestInterceptor(int i) {
        if (i < 0 || i >= this.requestInterceptors.size()) {
            return null;
        }
        return (HttpRequestInterceptor) this.requestInterceptors.get(i);
    }

    public void clearRequestInterceptors() {
        this.requestInterceptors.clear();
    }

    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            this.responseInterceptors.add(httpResponseInterceptor);
        }
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        addResponseInterceptor(httpResponseInterceptor);
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i) {
        addResponseInterceptor(httpResponseInterceptor, i);
    }

    public int getResponseInterceptorCount() {
        return this.responseInterceptors.size();
    }

    public HttpResponseInterceptor getResponseInterceptor(int i) {
        if (i < 0 || i >= this.responseInterceptors.size()) {
            return null;
        }
        return (HttpResponseInterceptor) this.responseInterceptors.get(i);
    }

    public void clearResponseInterceptors() {
        this.responseInterceptors.clear();
    }

    public void setInterceptors(List<?> list) {
        Args.notNull(list, "Inteceptor list");
        this.requestInterceptors.clear();
        this.responseInterceptors.clear();
        for (Object next : list) {
            if (next instanceof HttpRequestInterceptor) {
                addInterceptor((HttpRequestInterceptor) next);
            }
            if (next instanceof HttpResponseInterceptor) {
                addInterceptor((HttpResponseInterceptor) next);
            }
        }
    }

    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws IOException, HttpException {
        for (HttpRequestInterceptor process : this.requestInterceptors) {
            process.process(httpRequest, httpContext);
        }
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws IOException, HttpException {
        for (HttpResponseInterceptor process : this.responseInterceptors) {
            process.process(httpResponse, httpContext);
        }
    }

    protected void copyInterceptors(BasicHttpProcessor basicHttpProcessor) {
        basicHttpProcessor.requestInterceptors.clear();
        basicHttpProcessor.requestInterceptors.addAll(this.requestInterceptors);
        basicHttpProcessor.responseInterceptors.clear();
        basicHttpProcessor.responseInterceptors.addAll(this.responseInterceptors);
    }

    public BasicHttpProcessor copy() {
        BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        copyInterceptors(basicHttpProcessor);
        return basicHttpProcessor;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor basicHttpProcessor = (BasicHttpProcessor) super.clone();
        copyInterceptors(basicHttpProcessor);
        return basicHttpProcessor;
    }
}
