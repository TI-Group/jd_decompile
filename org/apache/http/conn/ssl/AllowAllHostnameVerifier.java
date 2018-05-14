package org.apache.http.conn.ssl;

import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class AllowAllHostnameVerifier extends AbstractVerifier {
    public final void verify(String str, String[] strArr, String[] strArr2) {
    }

    public final String toString() {
        return "ALLOW_ALL";
    }
}
