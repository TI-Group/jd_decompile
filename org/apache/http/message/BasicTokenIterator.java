package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos = findNext(-1);

    public BasicTokenIterator(HeaderIterator headerIterator) {
        this.headerIt = (HeaderIterator) Args.notNull(headerIterator, "Header iterator");
    }

    public boolean hasNext() {
        return this.currentToken != null;
    }

    public String nextToken() throws NoSuchElementException, ParseException {
        if (this.currentToken == null) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        String str = this.currentToken;
        this.searchPos = findNext(this.searchPos);
        return str;
    }

    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }

    protected int findNext(int i) throws ParseException {
        int findTokenSeparator;
        if (i >= 0) {
            findTokenSeparator = findTokenSeparator(i);
        } else if (!this.headerIt.hasNext()) {
            return -1;
        } else {
            this.currentHeader = this.headerIt.nextHeader().getValue();
            findTokenSeparator = 0;
        }
        int findTokenStart = findTokenStart(findTokenSeparator);
        if (findTokenStart < 0) {
            this.currentToken = null;
            return -1;
        }
        findTokenSeparator = findTokenEnd(findTokenStart);
        this.currentToken = createToken(this.currentHeader, findTokenStart, findTokenSeparator);
        return findTokenSeparator;
    }

    protected String createToken(String str, int i, int i2) {
        return str.substring(i, i2);
    }

    protected int findTokenStart(int i) {
        int notNegative = Args.notNegative(i, "Search position");
        Object obj = null;
        while (obj == null && this.currentHeader != null) {
            int length = this.currentHeader.length();
            Object obj2 = obj;
            int i2 = notNegative;
            Object obj3 = obj2;
            while (obj3 == null && i2 < length) {
                char charAt = this.currentHeader.charAt(i2);
                if (isTokenSeparator(charAt) || isWhitespace(charAt)) {
                    i2++;
                } else if (isTokenChar(this.currentHeader.charAt(i2))) {
                    obj3 = 1;
                } else {
                    throw new ParseException("Invalid character before token (pos " + i2 + "): " + this.currentHeader);
                }
            }
            if (obj3 == null) {
                if (this.headerIt.hasNext()) {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    i2 = 0;
                } else {
                    this.currentHeader = null;
                }
            }
            obj2 = obj3;
            notNegative = i2;
            obj = obj2;
        }
        return obj != null ? notNegative : -1;
    }

    protected int findTokenSeparator(int i) {
        int notNegative = Args.notNegative(i, "Search position");
        Object obj = null;
        int length = this.currentHeader.length();
        while (obj == null && notNegative < length) {
            char charAt = this.currentHeader.charAt(notNegative);
            if (isTokenSeparator(charAt)) {
                obj = 1;
            } else if (isWhitespace(charAt)) {
                notNegative++;
            } else if (isTokenChar(charAt)) {
                throw new ParseException("Tokens without separator (pos " + notNegative + "): " + this.currentHeader);
            } else {
                throw new ParseException("Invalid character after token (pos " + notNegative + "): " + this.currentHeader);
            }
        }
        return notNegative;
    }

    protected int findTokenEnd(int i) {
        Args.notNegative(i, "Search position");
        int length = this.currentHeader.length();
        int i2 = i + 1;
        while (i2 < length && isTokenChar(this.currentHeader.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    protected boolean isTokenSeparator(char c) {
        return c == ',';
    }

    protected boolean isWhitespace(char c) {
        return c == '\t' || Character.isSpaceChar(c);
    }

    protected boolean isTokenChar(char c) {
        if (Character.isLetterOrDigit(c)) {
            return true;
        }
        if (Character.isISOControl(c)) {
            return false;
        }
        if (isHttpSeparator(c)) {
            return false;
        }
        return true;
    }

    protected boolean isHttpSeparator(char c) {
        return HTTP_SEPARATORS.indexOf(c) >= 0;
    }
}
