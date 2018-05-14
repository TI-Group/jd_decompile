package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.methods.HttpHead;

@Immutable
/* compiled from: TbsSdkJava */
public class LaxRedirectStrategy extends DefaultRedirectStrategy {
    private static final String[] REDIRECT_METHODS = new String[]{"GET", "POST", HttpHead.METHOD_NAME};

    protected boolean isRedirectable(String str) {
        for (String equalsIgnoreCase : REDIRECT_METHODS) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
