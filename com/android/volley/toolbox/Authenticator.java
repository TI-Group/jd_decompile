package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;

/* compiled from: TbsSdkJava */
public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}
