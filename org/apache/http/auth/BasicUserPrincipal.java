package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
/* compiled from: TbsSdkJava */
public final class BasicUserPrincipal implements Serializable, Principal {
    private static final long serialVersionUID = -2266305184969850467L;
    private final String username;

    public BasicUserPrincipal(String str) {
        Args.notNull(str, "User name");
        this.username = str;
    }

    public String getName() {
        return this.username;
    }

    public int hashCode() {
        return LangUtils.hashCode(17, this.username);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BasicUserPrincipal) {
            if (LangUtils.equals(this.username, ((BasicUserPrincipal) obj).username)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[principal: ");
        stringBuilder.append(this.username);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
