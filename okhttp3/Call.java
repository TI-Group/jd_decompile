package okhttp3;

import java.io.IOException;

/* compiled from: TbsSdkJava */
public interface Call {

    /* compiled from: TbsSdkJava */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
