package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class NTCredentials implements Serializable, Credentials {
    private static final long serialVersionUID = -7385699315228907265L;
    private final String password;
    private final NTUserPrincipal principal;
    private final String workstation;

    public NTCredentials(String str) {
        Args.notNull(str, "Username:password string");
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            this.password = str.substring(indexOf + 1);
            str = substring;
        } else {
            this.password = null;
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 >= 0) {
            this.principal = new NTUserPrincipal(str.substring(0, indexOf2).toUpperCase(Locale.ENGLISH), str.substring(indexOf2 + 1));
        } else {
            this.principal = new NTUserPrincipal(null, str.substring(indexOf2 + 1));
        }
        this.workstation = null;
    }

    public NTCredentials(String str, String str2, String str3, String str4) {
        Args.notNull(str, "User name");
        this.principal = new NTUserPrincipal(str4, str);
        this.password = str2;
        if (str3 != null) {
            this.workstation = str3.toUpperCase(Locale.ENGLISH);
        } else {
            this.workstation = null;
        }
    }

    public Principal getUserPrincipal() {
        return this.principal;
    }

    public String getUserName() {
        return this.principal.getUsername();
    }

    public String getPassword() {
        return this.password;
    }

    public String getDomain() {
        return this.principal.getDomain();
    }

    public String getWorkstation() {
        return this.workstation;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.principal), this.workstation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NTCredentials) {
            NTCredentials nTCredentials = (NTCredentials) obj;
            if (LangUtils.equals(this.principal, nTCredentials.principal) && LangUtils.equals(this.workstation, nTCredentials.workstation)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[principal: ");
        stringBuilder.append(this.principal);
        stringBuilder.append("][workstation: ");
        stringBuilder.append(this.workstation);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
