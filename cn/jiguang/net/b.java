package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import cn.jiguang.net.HttpUtils.HttpListener;

final class b extends AsyncTask<String, Void, HttpResponse> {
    private HttpListener a;
    private Context b;

    public b(HttpListener httpListener, Context context) {
        this.a = httpListener;
        this.b = context;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        String[] strArr = (String[]) objArr;
        return (strArr == null || strArr.length == 0) ? null : HttpUtils.httpGet(this.b, strArr[0]);
    }

    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }

    protected final void onPreExecute() {
    }
}
