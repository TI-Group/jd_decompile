package org.apache.http.client.methods;

import org.apache.http.concurrent.Cancellable;

/* compiled from: TbsSdkJava */
public interface HttpExecutionAware {
    boolean isAborted();

    void setCancellable(Cancellable cancellable);
}
