package jd.wjlogin_sdk.util.ajax;

import android.os.AsyncTask;

/* compiled from: TbsSdkJava */
public class AjaxTask extends AsyncTask<IHttpRequest, int[], HttpResult> {
    private Ajax mAjax;

    public AjaxTask(Ajax ajax) {
        this.mAjax = ajax;
    }

    protected HttpResult doInBackground(IHttpRequest... iHttpRequestArr) {
        IHttpRequest iHttpRequest = iHttpRequestArr[0];
        iHttpRequest.Execut();
        return iHttpRequest.getHttpResult();
    }

    protected void onPostExecute(HttpResult httpResult) {
        if (this.mAjax != null) {
            this.mAjax.run(httpResult);
        }
    }
}
