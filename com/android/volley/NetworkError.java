package com.android.volley;

/* compiled from: TbsSdkJava */
public class NetworkError extends VolleyError {
    public NetworkError(Throwable th) {
        super(th);
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }
}
