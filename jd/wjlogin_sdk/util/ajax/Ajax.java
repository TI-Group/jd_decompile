package jd.wjlogin_sdk.util.ajax;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TbsSdkJava */
public class Ajax {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private int ajaxMethodType;
    private Context context;
    private IHttpRequest httpRequest;
    private OnErrorListener mOnErrorListener;
    private OnSuccessListener mOnSuccessListener;
    private AjaxTask mTask;
    private String params;
    private int retryTimes = 1;
    private boolean retryWithHttp = false;
    private String url;
    private boolean useHttp = false;

    public Ajax(int i, String str, Context context) {
        this.ajaxMethodType = i;
        this.url = str;
        this.context = context;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public void setRetryTimes(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.retryTimes = i;
    }

    public boolean isRetryWithHttp() {
        return this.retryWithHttp;
    }

    public void setRetryWithHttp(boolean z) {
        this.retryWithHttp = z;
    }

    public boolean isUseHttp() {
        return this.useHttp;
    }

    public void setUseHttp(boolean z) {
        this.useHttp = z;
    }

    public void setOnSuccessListener(OnSuccessListener onSuccessListener) {
        this.mOnSuccessListener = onSuccessListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void performOnError(String str) {
        if (this.mOnErrorListener != null) {
            this.mOnErrorListener.onError(str);
        }
    }

    public void performOnSuccess(String str) {
        if (this.mOnSuccessListener != null) {
            this.mOnSuccessListener.onSuccess(str);
        }
    }

    public void send() {
        this.mTask = new AjaxTask(this);
        if (this.ajaxMethodType == 1) {
            this.httpRequest = new HttpPostExecut(this.context, this.retryTimes, this.retryWithHttp, this.useHttp);
            this.httpRequest.initRequest(this.url, this.params);
            if (VERSION.SDK_INT >= 11) {
                new Object() {
                    public void executeOnExecutor() {
                        Ajax.this.mTask.executeOnExecutor(Ajax.executorService, new IHttpRequest[]{Ajax.this.httpRequest});
                    }
                }.executeOnExecutor();
                return;
            }
            this.mTask.execute(new IHttpRequest[]{this.httpRequest});
        }
    }

    void run(HttpResult httpResult) {
        if (httpResult.isIsError() || TextUtils.isEmpty(httpResult.getResult())) {
            performOnError(httpResult.getError());
            return;
        }
        try {
            performOnSuccess(httpResult.getResult());
        } catch (Exception e) {
            performOnError(e.toString());
        }
    }
}
