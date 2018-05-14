package com.jingdong.crash.inner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class ak implements HostnameVerifier {
    final /* synthetic */ aj a;

    ak(aj ajVar) {
        this.a = ajVar;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
