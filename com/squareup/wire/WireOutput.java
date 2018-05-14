package com.squareup.wire;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public final class WireOutput {
    private final byte[] buffer;
    private final int limit;
    private int position;

    public static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }

    public static int int64Size(long j) {
        if (j >= 0) {
            return varint64Size(j);
        }
        return 10;
    }

    public static int tagSize(int i, WireType wireType) {
        return int32Size(makeTag(i, wireType));
    }

    public static int messageSize(int i, int i2) {
        return (tagSize(i, WireType.LENGTH_DELIMITED) + int32Size(i2)) + i2;
    }

    public static int writeTag(int i, WireType wireType, byte[] bArr, int i2) {
        return writeVarint((long) makeTag(i, wireType), bArr, i2);
    }

    public static int writeVarint(long j, byte[] bArr, int i) {
        int i2;
        int i3 = i;
        while ((-128 & j) != 0) {
            i2 = i3 + 1;
            bArr[i3] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i3 = i2;
        }
        i2 = i3 + 1;
        bArr[i3] = (byte) ((int) j);
        return i2 - i;
    }

    public static int messageHeaderSize(int i, int i2) {
        return tagSize(i, WireType.LENGTH_DELIMITED) + int32Size(i2);
    }

    public static int writeMessageHeader(int i, byte[] bArr, int i2, int i3) {
        int writeTag = writeTag(i, WireType.LENGTH_DELIMITED, bArr, i2) + i2;
        return (writeTag + writeVarint((long) i3, bArr, writeTag)) - i2;
    }

    public static int makeTag(int i, WireType wireType) {
        return (i << 3) | wireType.value();
    }

    private WireOutput(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
    }

    static WireOutput newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    static WireOutput newInstance(byte[] bArr, int i, int i2) {
        return new WireOutput(bArr, i, i2);
    }

    static int varintTagSize(int i) {
        return varint32Size(makeTag(i, WireType.VARINT));
    }

    static int varint32Size(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    static int varint64Size(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    void writeRawByte(byte b) throws IOException {
        if (this.position == this.limit) {
            throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    void writeRawByte(int i) throws IOException {
        writeRawByte((byte) i);
    }

    void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        if (this.limit - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
    }

    void writeTag(int i, WireType wireType) throws IOException {
        writeVarint32(makeTag(i, wireType));
    }

    void writeSignedVarint32(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64((long) i);
        }
    }

    void writeVarint32(int i) throws IOException {
        while ((i & -128) != 0) {
            writeRawByte((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    void writeVarint64(long j) throws IOException {
        while ((-128 & j) != 0) {
            writeRawByte((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    void writeFixed32(int i) throws IOException {
        writeRawByte(i & 255);
        writeRawByte((i >> 8) & 255);
        writeRawByte((i >> 16) & 255);
        writeRawByte((i >> 24) & 255);
    }

    void writeFixed64(long j) throws IOException {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }

    static int zigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    static long zigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }
}
