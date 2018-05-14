package org.apache.http.util;

import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public final class ByteArrayBuffer implements Serializable {
    private static final long serialVersionUID = 4359112959524048036L;
    private byte[] buffer;
    private int len;

    public ByteArrayBuffer(int i) {
        Args.notNegative(i, "Buffer capacity");
        this.buffer = new byte[i];
    }

    private void expand(int i) {
        Object obj = new byte[Math.max(this.buffer.length << 1, i)];
        System.arraycopy(this.buffer, 0, obj, 0, this.len);
        this.buffer = obj;
    }

    public void append(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
            } else if (i2 != 0) {
                int i3 = this.len + i2;
                if (i3 > this.buffer.length) {
                    expand(i3);
                }
                System.arraycopy(bArr, i, this.buffer, this.len, i2);
                this.len = i3;
            }
        }
    }

    public void append(int i) {
        int i2 = this.len + 1;
        if (i2 > this.buffer.length) {
            expand(i2);
        }
        this.buffer[this.len] = (byte) i;
        this.len = i2;
    }

    public void append(char[] cArr, int i, int i2) {
        if (cArr != null) {
            if (i < 0 || i > cArr.length || i2 < 0 || i + i2 < 0 || i + i2 > cArr.length) {
                throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + cArr.length);
            } else if (i2 != 0) {
                int i3 = this.len;
                int i4 = i3 + i2;
                if (i4 > this.buffer.length) {
                    expand(i4);
                }
                while (i3 < i4) {
                    this.buffer[i3] = (byte) cArr[i];
                    i++;
                    i3++;
                }
                this.len = i4;
            }
        }
    }

    public void append(CharArrayBuffer charArrayBuffer, int i, int i2) {
        if (charArrayBuffer != null) {
            append(charArrayBuffer.buffer(), i, i2);
        }
    }

    public void clear() {
        this.len = 0;
    }

    public byte[] toByteArray() {
        Object obj = new byte[this.len];
        if (this.len > 0) {
            System.arraycopy(this.buffer, 0, obj, 0, this.len);
        }
        return obj;
    }

    public int byteAt(int i) {
        return this.buffer[i];
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

    public byte[] buffer() {
        return this.buffer;
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

    public int indexOf(byte b, int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (i2 > this.len) {
            i2 = this.len;
        }
        if (i > i2) {
            return -1;
        }
        for (int i3 = i; i3 < i2; i3++) {
            if (this.buffer[i3] == b) {
                return i3;
            }
        }
        return -1;
    }

    public int indexOf(byte b) {
        return indexOf(b, 0, this.len);
    }
}
