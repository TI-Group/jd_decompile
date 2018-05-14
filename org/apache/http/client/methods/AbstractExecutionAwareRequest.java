package org.apache.http.client.methods;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.HttpRequest;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.HttpParams;

/* compiled from: TbsSdkJava */
public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements Cloneable, HttpRequest, AbortableHttpRequest, HttpExecutionAware {
    private final AtomicBoolean aborted = new AtomicBoolean(false);
    private final AtomicReference<Cancellable> cancellableRef = new AtomicReference(null);

    protected AbstractExecutionAwareRequest() {
    }

    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest clientConnectionRequest) {
        setCancellable(new Cancellable() {
            public boolean cancel() {
                clientConnectionRequest.abortRequest();
                return true;
            }
        });
    }

    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger connectionReleaseTrigger) {
        setCancellable(new Cancellable() {
            public boolean cancel() {
                try {
                    connectionReleaseTrigger.abortConnection();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }
        });
    }

    public void abort() {
        if (this.aborted.compareAndSet(false, true)) {
            Cancellable cancellable = (Cancellable) this.cancellableRef.getAndSet(null);
            if (cancellable != null) {
                cancellable.cancel();
            }
        }
    }

    public boolean isAborted() {
        return this.aborted.get();
    }

    public void setCancellable(Cancellable cancellable) {
        if (!this.aborted.get()) {
            this.cancellableRef.set(cancellable);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractExecutionAwareRequest abstractExecutionAwareRequest = (AbstractExecutionAwareRequest) super.clone();
        abstractExecutionAwareRequest.headergroup = (HeaderGroup) CloneUtils.cloneObject(this.headergroup);
        abstractExecutionAwareRequest.params = (HttpParams) CloneUtils.cloneObject(this.params);
        return abstractExecutionAwareRequest;
    }

    public void completed() {
        this.cancellableRef.set(null);
    }

    public void reset() {
        Cancellable cancellable = (Cancellable) this.cancellableRef.getAndSet(null);
        if (cancellable != null) {
            cancellable.cancel();
        }
        this.aborted.set(false);
    }
}
