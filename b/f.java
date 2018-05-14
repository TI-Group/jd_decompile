package b;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class f implements Serializable, Comparable<f> {
    public static final f EMPTY = of(new byte[0]);
    static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    f(byte[] bArr) {
        this.data = bArr;
    }

    public static f of(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f of(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        u.a((long) bArr.length, (long) i, (long) i2);
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new f(obj);
    }

    public static f encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.a));
        fVar.utf8 = str;
        return fVar;
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        str = new String(this.data, u.a);
        this.utf8 = str;
        return str;
    }

    public String base64() {
        return b.a(this.data);
    }

    public f md5() {
        return a("MD5");
    }

    public f sha256() {
        return a("SHA-256");
    }

    private f a(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String base64Url() {
        return b.b(this.data);
    }

    public static f decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a = b.a(str);
        return a != null ? new f(a) : null;
    }

    public String hex() {
        int i = 0;
        char[] cArr = new char[(this.data.length * 2)];
        byte[] bArr = this.data;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = HEX_DIGITS[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = HEX_DIGITS[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static f decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        } else {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((a(str.charAt(i * 2)) << 4) + a(str.charAt((i * 2) + 1)));
            }
            return of(bArr);
        }
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 65) + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static f read(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new f(bArr);
        }
    }

    public f toAsciiLowercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b = this.data[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new f(bArr);
            }
        }
        return this;
    }

    public f toAsciiUppercase() {
        int i = 0;
        while (i < this.data.length) {
            byte b = this.data[i];
            if (b < (byte) 97 || b > ReplyCode.reply0x7a) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.data.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b - 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 97 && b2 <= ReplyCode.reply0x7a) {
                        bArr[i] = (byte) (b2 - 32);
                    }
                }
                return new f(bArr);
            }
        }
        return this;
    }

    public f substring(int i) {
        return substring(i, this.data.length);
    }

    public f substring(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 > this.data.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.data.length) {
                return this;
            } else {
                Object obj = new byte[i3];
                System.arraycopy(this.data, i, obj, 0, i3);
                this(obj);
                return this;
            }
        }
    }

    public byte getByte(int i) {
        return this.data[i];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }

    void write(c cVar) {
        cVar.b(this.data, 0, this.data.length);
    }

    public boolean rangeEquals(int i, f fVar, int i2, int i3) {
        return fVar.rangeEquals(i2, this.data, i, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        return i <= this.data.length - i3 && i2 <= bArr.length - i3 && u.a(this.data, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof f) && ((f) obj).size() == this.data.length && ((f) obj).rangeEquals(0, this.data, 0, this.data.length);
        return z;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.data);
        this.hashCode = i;
        return i;
    }

    public int compareTo(f fVar) {
        int size = size();
        int size2 = fVar.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (i < min) {
            int i2 = getByte(i) & 255;
            int i3 = fVar.getByte(i) & 255;
            if (i2 == i3) {
                i++;
            } else if (i2 < i3) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size >= size2) {
            return 1;
        }
        return -1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.data.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.data.length), hex()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.data.length), md5().hex()});
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = f.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
