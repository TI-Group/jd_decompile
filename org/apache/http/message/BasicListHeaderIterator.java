package org.apache.http.message;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List<Header> allHeaders;
    protected int currentIndex = findNext(-1);
    protected String headerName;
    protected int lastIndex = -1;

    public BasicListHeaderIterator(List<Header> list, String str) {
        this.allHeaders = (List) Args.notNull(list, "Header list");
        this.headerName = str;
    }

    protected int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int size = this.allHeaders.size() - 1;
        boolean z = false;
        int i2 = i;
        while (!z && i2 < size) {
            i = i2 + 1;
            z = filterHeader(i);
            i2 = i;
        }
        if (!z) {
            i2 = -1;
        }
        return i2;
    }

    protected boolean filterHeader(int i) {
        if (this.headerName == null) {
            return true;
        }
        return this.headerName.equalsIgnoreCase(((Header) this.allHeaders.get(i)).getName());
    }

    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    public Header nextHeader() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i < 0) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.lastIndex = i;
        this.currentIndex = findNext(i);
        return (Header) this.allHeaders.get(i);
    }

    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    public void remove() throws UnsupportedOperationException {
        Asserts.check(this.lastIndex >= 0, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
    }
}
