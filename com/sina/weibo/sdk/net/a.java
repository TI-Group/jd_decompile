package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.b.g;

/* compiled from: TbsSdkJava */
public class a {
    private Context a;

    /* compiled from: TbsSdkJava */
    private static class a<T> {
        private T a;
        private com.sina.weibo.sdk.c.b b;

        public T a() {
            return this.a;
        }

        public com.sina.weibo.sdk.c.b b() {
            return this.b;
        }

        public a(T t) {
            this.a = t;
        }

        public a(com.sina.weibo.sdk.c.b bVar) {
            this.b = bVar;
        }
    }

    /* compiled from: TbsSdkJava */
    static class b extends AsyncTask<Void, Void, a<String>> {
        private final Context a;
        private final String b;
        private final f c;
        private final String d;
        private final d e;

        protected /* synthetic */ Object doInBackground(Object... objArr) {
            return a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((a) obj);
        }

        public b(Context context, String str, f fVar, String str2, d dVar) {
            this.a = context;
            this.b = str;
            this.c = fVar;
            this.d = str2;
            this.e = dVar;
        }

        protected a<String> a(Void... voidArr) {
            try {
                return new a(HttpManager.a(this.a, this.b, this.d, this.c));
            } catch (com.sina.weibo.sdk.c.b e) {
                return new a(e);
            }
        }

        protected void onPreExecute() {
        }

        protected void a(a<String> aVar) {
            com.sina.weibo.sdk.c.b b = aVar.b();
            if (b != null) {
                this.e.a(b);
            } else {
                this.e.a((String) aVar.a());
            }
        }
    }

    public a(Context context) {
        this.a = context;
    }

    public void a(String str, f fVar, String str2, d dVar) {
        g.a(this.a, fVar.a()).a();
        new b(this.a, str, fVar, str2, dVar).execute(new Void[1]);
    }
}
