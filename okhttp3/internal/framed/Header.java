package okhttp3.internal.framed;

import b.f;

/* compiled from: TbsSdkJava */
public final class Header {
    public static final f RESPONSE_STATUS = f.encodeUtf8(":status");
    public static final f TARGET_AUTHORITY = f.encodeUtf8(":authority");
    public static final f TARGET_HOST = f.encodeUtf8(":host");
    public static final f TARGET_METHOD = f.encodeUtf8(":method");
    public static final f TARGET_PATH = f.encodeUtf8(":path");
    public static final f TARGET_SCHEME = f.encodeUtf8(":scheme");
    public static final f VERSION = f.encodeUtf8(":version");
    final int hpackSize;
    public final f name;
    public final f value;

    public Header(String str, String str2) {
        this(f.encodeUtf8(str), f.encodeUtf8(str2));
    }

    public Header(f fVar, String str) {
        this(fVar, f.encodeUtf8(str));
    }

    public Header(f fVar, f fVar2) {
        this.name = fVar;
        this.value = fVar2;
        this.hpackSize = (fVar.size() + 32) + fVar2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (this.name.equals(header.name) && this.value.equals(header.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.name.hashCode() + 527) * 31) + this.value.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{this.name.utf8(), this.value.utf8()});
    }
}
