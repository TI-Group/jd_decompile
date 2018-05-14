package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.SetCookie2;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
    private static final long serialVersionUID = -7744598295706617057L;
    private String commentURL;
    private boolean discard;
    private int[] ports;

    public BasicClientCookie2(String str, String str2) {
        super(str, str2);
    }

    public int[] getPorts() {
        return this.ports;
    }

    public void setPorts(int[] iArr) {
        this.ports = iArr;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    public void setDiscard(boolean z) {
        this.discard = z;
    }

    public boolean isPersistent() {
        return !this.discard && super.isPersistent();
    }

    public boolean isExpired(Date date) {
        return this.discard || super.isExpired(date);
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie2 basicClientCookie2 = (BasicClientCookie2) super.clone();
        if (this.ports != null) {
            basicClientCookie2.ports = (int[]) this.ports.clone();
        }
        return basicClientCookie2;
    }
}
