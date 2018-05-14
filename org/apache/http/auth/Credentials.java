package org.apache.http.auth;

import java.security.Principal;

/* compiled from: TbsSdkJava */
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
