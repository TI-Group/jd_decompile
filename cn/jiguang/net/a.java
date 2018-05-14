package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import cn.jiguang.net.HttpUtils.HttpListener;

final class a extends AsyncTask<HttpRequest, Void, HttpResponse> {
    private HttpListener a;
    private Context b;

    public a(Context context, HttpListener httpListener) {
        this.a = httpListener;
        this.b = context;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        HttpRequest[] httpRequestArr = (HttpRequest[]) objArr;
        return (httpRequestArr == null || httpRequestArr.length == 0) ? null : HttpUtils.httpGet(this.b, httpRequestArr[0]);
    }

    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }

    protected final void onPreExecute() {
    }
}
