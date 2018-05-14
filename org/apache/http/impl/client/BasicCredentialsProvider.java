package org.apache.http.impl.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.util.Args;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class BasicCredentialsProvider implements CredentialsProvider {
    private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap();

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        Args.notNull(authScope, "Authentication scope");
        this.credMap.put(authScope, credentials);
    }

    private static Credentials matchCredentials(Map<AuthScope, Credentials> map, AuthScope authScope) {
        Credentials credentials = (Credentials) map.get(authScope);
        if (credentials != null) {
            return credentials;
        }
        int i = -1;
        AuthScope authScope2 = null;
        for (AuthScope authScope3 : map.keySet()) {
            AuthScope authScope32;
            int i2;
            int match = authScope.match(authScope32);
            if (match > i) {
                i2 = match;
            } else {
                authScope32 = authScope2;
                i2 = i;
            }
            i = i2;
            authScope2 = authScope32;
        }
        if (authScope2 != null) {
            return (Credentials) map.get(authScope2);
        }
        return credentials;
    }

    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Authentication scope");
        return matchCredentials(this.credMap, authScope);
    }

    public void clear() {
        this.credMap.clear();
    }

    public String toString() {
        return this.credMap.toString();
    }
}
