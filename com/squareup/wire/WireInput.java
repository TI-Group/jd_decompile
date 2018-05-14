package com.squareup.wire;

import android.support.v4.media.TransportMediator;
import b.c;
import b.e;
import b.f;
import b.m;
import b.s;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
final class WireInput {
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    private static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    private int currentLimit = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int lastTag;
    private int pos = 0;
    public int recursionDepth;
    private final e source;

    public static WireInput newInstance(byte[] bArr) {
        return new WireInput(new c().b(bArr));
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        return new WireInput(new c().b(bArr, i, i2));
    }

    public static WireInput newInstance(InputStream inputStream) {
        return new WireInput(m.a(m.a(inputStream)));
    }

    public static WireInput newInstance(s sVar) {
        return new WireInput(m.a(sVar));
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readVarint32();
        if (this.lastTag != 0) {
            return this.lastTag;
        }
        throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    public void checkLastTagWas(int i) throws IOException {
        if (this.lastTag != i) {
            throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
        }
    }

    public String readString() throws IOException {
        int readVarint32 = readVarint32();
        this.pos += readVarint32;
        return this.source.a((long) readVarint32, UTF_8);
    }

    public f readBytes() throws IOException {
        return readBytes(readVarint32());
    }

    public f readBytes(int i) throws IOException {
        this.pos += i;
        this.source.a((long) i);
        return this.source.d((long) i);
    }

    public int readVarint32() throws IOException {
        this.pos++;
        byte h = this.source.h();
        if (h >= (byte) 0) {
            return h;
        }
        int i = h & TransportMediator.KEYCODE_MEDIA_PAUSE;
        this.pos++;
        byte h2 = this.source.h();
        if (h2 >= (byte) 0) {
            return i | (h2 << 7);
        }
        i |= (h2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        this.pos++;
        h2 = this.source.h();
        if (h2 >= (byte) 0) {
            return i | (h2 << 14);
        }
        i |= (h2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        this.pos++;
        h2 = this.source.h();
        if (h2 >= (byte) 0) {
            return i | (h2 << 21);
        }
        i |= (h2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        this.pos++;
        h2 = this.source.h();
        i |= h2 << 28;
        if (h2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.pos++;
            if (this.source.h() >= (byte) 0) {
                return i;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public long readVarint64() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            this.pos++;
            byte h = this.source.h();
            j |= ((long) (h & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((h & 128) == 0) {
                return j;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public int readFixed32() throws IOException {
        this.pos += 4;
        return this.source.m();
    }

    public long readFixed64() throws IOException {
        this.pos += 8;
        return this.source.n();
    }

    public static int decodeZigZag32(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private WireInput(e eVar) {
        this.source = eVar;
    }

    public int pushLimit(int i) throws IOException {
        if (i < 0) {
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        int i2 = this.pos + i;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        this.currentLimit = i2;
        return i3;
    }

    public void popLimit(int i) {
        this.currentLimit = i;
    }

    private boolean isAtEnd() throws IOException {
        if (getPosition() == ((long) this.currentLimit)) {
            return true;
        }
        return this.source.e();
    }

    public long getPosition() {
        return (long) this.pos;
    }

    public void skipGroup() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (!skipField(readTag));
    }

    private boolean skipField(int i) throws IOException {
        switch (WireType.valueOf(i)) {
            case VARINT:
                readVarint64();
                return false;
            case FIXED32:
                readFixed32();
                return false;
            case FIXED64:
                readFixed64();
                return false;
            case LENGTH_DELIMITED:
                skip((long) readVarint32());
                return false;
            case START_GROUP:
                skipGroup();
                checkLastTagWas((i & -8) | WireType.END_GROUP.value());
                return false;
            case END_GROUP:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void skip(long j) throws IOException {
        this.pos = (int) (((long) this.pos) + j);
        this.source.h(j);
    }
}
