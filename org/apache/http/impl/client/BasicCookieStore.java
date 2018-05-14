package org.apache.http.impl.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class BasicCookieStore implements Serializable, CookieStore {
    private static final long serialVersionUID = -7581093305228232025L;
    @GuardedBy("this")
    private final TreeSet<Cookie> cookies = new TreeSet(new CookieIdentityComparator());

    public synchronized void addCookie(Cookie cookie) {
        if (cookie != null) {
            this.cookies.remove(cookie);
            if (!cookie.isExpired(new Date())) {
                this.cookies.add(cookie);
            }
        }
    }

    public synchronized void addCookies(Cookie[] cookieArr) {
        if (cookieArr != null) {
            for (Cookie addCookie : cookieArr) {
                addCookie(addCookie);
            }
        }
    }

    public synchronized List<Cookie> getCookies() {
        return new ArrayList(this.cookies);
    }

    public synchronized boolean clearExpired(Date date) {
        boolean z = false;
        synchronized (this) {
            if (date != null) {
                Iterator it = this.cookies.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    if (((Cookie) it.next()).isExpired(date)) {
                        it.remove();
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public synchronized void clear() {
        this.cookies.clear();
    }

    public synchronized String toString() {
        return this.cookies.toString();
    }
}
