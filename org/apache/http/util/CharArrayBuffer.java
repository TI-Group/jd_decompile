package org.apache.http.util;

import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.protocol.HTTP;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public final class CharArrayBuffer implements Serializable {
    private static final long serialVersionUID = -6208952725094867135L;
    private char[] buffer;
    private int len;

    public CharArrayBuffer(int i) {
        Args.notNegative(i, "Buffer capacity");
        this.buffer = new char[i];
    }

    private void expand(int i) {
        Object obj = new char[Math.max(this.buffer.length << 1, i)];
        System.arraycopy(this.buffer, 0, obj, 0, this.len);
        this.buffer = obj;
    }

    public void append(char[] cArr, int i, int i2) {
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || i + i2 < 0 || i + i2 > cArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
            } else if (i2 != 0) {
                int i3 = this.len + i2;
                if (i3 > this.buffer.length) {
                    expand(i3);
                }
                System.arraycopy(cArr, i, this.buffer, this.len, i2);
                this.len = i3;
            }
        }
    }

    public void append(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.len + length;
        if (i > this.buffer.length) {
            expand(i);
        }
        str.getChars(0, length, this.buffer, this.len);
        this.len = i;
    }

    public void append(CharArrayBuffer charArrayBuffer, int i, int i2) {
        if (charArrayBuffer != null) {
            append(charArrayBuffer.buffer, i, i2);
        }
    }

    public void append(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer != null) {
            append(charArrayBuffer.buffer, 0, charArrayBuffer.len);
        }
    }

    public void append(char c) {
        int i = this.len + 1;
        if (i > this.buffer.length) {
            expand(i);
        }
        this.buffer[this.len] = c;
        this.len = i;
    }

    public void append(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
            } else if (i2 != 0) {
                int i3 = this.len;
                int i4 = i3 + i2;
                if (i4 > this.buffer.length) {
                    expand(i4);
                }
                while (i3 < i4) {
                    this.buffer[i3] = (char) (bArr[i] & 255);
                    i++;
                    i3++;
                }
                this.len = i4;
            }
        }
    }

    public void append(ByteArrayBuffer byteArrayBuffer, int i, int i2) {
        if (byteArrayBuffer != null) {
            append(byteArrayBuffer.buffer(), i, i2);
        }
    }

    public void append(Object obj) {
        append(String.valueOf(obj));
    }

    public void clear() {
        this.len = 0;
    }

    public char[] toCharArray() {
        Object obj = new char[this.len];
        if (this.len > 0) {
            System.arraycopy(this.buffer, 0, obj, 0, this.len);
        }
        return obj;
    }

    public char charAt(int i) {
        return this.buffer[i];
    }

    public char[] buffer() {
        return this.buffer;
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.len;
    }

    public void ensureCapacity(int i) {
        if (i > 0 && i > this.buffer.length - this.len) {
            expand(this.len + i);
        }
    }

    public void setLength(int i) {
        if (i < 0 || i > this.buffer.length) {
            throw new IndexOutOfBoundsException("len: " + i + " < 0 or > buffer len: " + this.buffer.length);
        }
        this.len = i;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public boolean isFull() {
        return this.len == this.buffer.length;
    }

    public int indexOf(int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 > this.len) {
            i3 = this.len;
        }
        if (i2 > i3) {
            return -1;
        }
        for (int i4 = i2; i4 < i3; i4++) {
            if (this.buffer[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public int indexOf(int i) {
        return indexOf(i, 0, this.len);
    }

    public String substring(int i, int i2) {
        return new String(this.buffer, i, i2 - i);
    }

    public String substringTrimmed(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Negative beginIndex: " + i);
        } else if (i2 > this.len) {
            throw new IndexOutOfBoundsException("endIndex: " + i2 + " > length: " + this.len);
        } else if (i > i2) {
            throw new IndexOutOfBoundsException("beginIndex: " + i + " > endIndex: " + i2);
        } else {
            while (i < i2 && HTTP.isWhitespace(this.buffer[i])) {
                i++;
            }
            while (i2 > i && HTTP.isWhitespace(this.buffer[i2 - 1])) {
                i2--;
            }
            return new String(this.buffer, i, i2 - i);
        }
    }

    public String toString() {
        return new String(this.buffer, 0, this.len);
    }
}
