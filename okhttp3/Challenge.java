package okhttp3;

import okhttp3.internal.Util;

/* compiled from: TbsSdkJava */
public final class Challenge {
    private final String realm;
    private final String scheme;

    public Challenge(String str, String str2) {
        this.scheme = str;
        this.realm = str2;
    }

    public String scheme() {
        return this.scheme;
    }

    public String realm() {
        return this.realm;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Challenge) && Util.equal(this.scheme, ((Challenge) obj).scheme) && Util.equal(this.realm, ((Challenge) obj).realm);
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.realm != null) {
            hashCode = this.realm.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + 899) * 31;
        if (this.scheme != null) {
            i = this.scheme.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.scheme + " realm=\"" + this.realm + "\"";
    }
}
