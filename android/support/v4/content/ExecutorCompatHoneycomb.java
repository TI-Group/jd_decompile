package android.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* compiled from: TbsSdkJava */
class ExecutorCompatHoneycomb {
    ExecutorCompatHoneycomb() {
    }

    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
