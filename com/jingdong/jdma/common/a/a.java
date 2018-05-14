package com.jingdong.jdma.common.a;

import android.support.v4.media.TransportMediator;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public class a {
    static final /* synthetic */ boolean a;
    private static final byte[] b = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, ReplyCode.reply0x4f, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, ReplyCode.reply0x64, (byte) 101, (byte) 102, ReplyCode.reply0x67, (byte) 104, (byte) 105, ReplyCode.reply0x6a, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, ReplyCode.reply0x77, (byte) 120, (byte) 121, ReplyCode.reply0x7a, (byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 43, (byte) 47};
    private static final byte[] c = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) -9, (byte) 63, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, ReplyCode.reply0xb, ReplyCode.reply0xc, ReplyCode.reply0xd, ReplyCode.reply0xe, ReplyCode.reply0xf, ReplyCode.reply0x10, ReplyCode.reply0x11, ReplyCode.reply0x12, ReplyCode.reply0x13, ReplyCode.reply0x14, ReplyCode.reply0x15, ReplyCode.reply0x16, ReplyCode.reply0x17, ReplyCode.reply0x18, ReplyCode.reply0x19, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, ReplyCode.reply0x1a, ReplyCode.reply0x1b, ReplyCode.reply0x1c, ReplyCode.reply0x1d, ReplyCode.reply0x1e, ReplyCode.reply0x1f, ReplyCode.reply0x20, ReplyCode.reply0x21, ReplyCode.reply0x22, ReplyCode.reply0x23, ReplyCode.reply0x24, ReplyCode.reply0x25, ReplyCode.reply0x26, ReplyCode.reply0x27, ReplyCode.reply0x28, ReplyCode.reply0x29, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    private static final byte[] d = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, ReplyCode.reply0x4f, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, ReplyCode.reply0x64, (byte) 101, (byte) 102, ReplyCode.reply0x67, (byte) 104, (byte) 105, ReplyCode.reply0x6a, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, ReplyCode.reply0x77, (byte) 120, (byte) 121, ReplyCode.reply0x7a, (byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 45, (byte) 95};
    private static final byte[] e = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, ReplyCode.reply0xb, ReplyCode.reply0xc, ReplyCode.reply0xd, ReplyCode.reply0xe, ReplyCode.reply0xf, ReplyCode.reply0x10, ReplyCode.reply0x11, ReplyCode.reply0x12, ReplyCode.reply0x13, ReplyCode.reply0x14, ReplyCode.reply0x15, ReplyCode.reply0x16, ReplyCode.reply0x17, ReplyCode.reply0x18, ReplyCode.reply0x19, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) -9, ReplyCode.reply0x1a, ReplyCode.reply0x1b, ReplyCode.reply0x1c, ReplyCode.reply0x1d, ReplyCode.reply0x1e, ReplyCode.reply0x1f, ReplyCode.reply0x20, ReplyCode.reply0x21, ReplyCode.reply0x22, ReplyCode.reply0x23, ReplyCode.reply0x24, ReplyCode.reply0x25, ReplyCode.reply0x26, ReplyCode.reply0x27, ReplyCode.reply0x28, ReplyCode.reply0x29, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    private static final byte[] f = new byte[]{(byte) 45, (byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, ReplyCode.reply0x4f, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 95, (byte) 97, (byte) 98, (byte) 99, ReplyCode.reply0x64, (byte) 101, (byte) 102, ReplyCode.reply0x67, (byte) 104, (byte) 105, ReplyCode.reply0x6a, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, ReplyCode.reply0x77, (byte) 120, (byte) 121, ReplyCode.reply0x7a};
    private static final byte[] g = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) -9, (byte) -9, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, ReplyCode.reply0xb, ReplyCode.reply0xc, ReplyCode.reply0xd, ReplyCode.reply0xe, ReplyCode.reply0xf, ReplyCode.reply0x10, ReplyCode.reply0x11, ReplyCode.reply0x12, ReplyCode.reply0x13, ReplyCode.reply0x14, ReplyCode.reply0x15, ReplyCode.reply0x16, ReplyCode.reply0x17, ReplyCode.reply0x18, ReplyCode.reply0x19, ReplyCode.reply0x1a, ReplyCode.reply0x1b, ReplyCode.reply0x1c, ReplyCode.reply0x1d, ReplyCode.reply0x1e, ReplyCode.reply0x1f, ReplyCode.reply0x20, ReplyCode.reply0x21, ReplyCode.reply0x22, ReplyCode.reply0x23, ReplyCode.reply0x24, (byte) -9, (byte) -9, (byte) -9, (byte) -9, ReplyCode.reply0x25, (byte) -9, ReplyCode.reply0x26, ReplyCode.reply0x27, ReplyCode.reply0x28, ReplyCode.reply0x29, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, ReplyCode.reply0x32, (byte) 51, ReplyCode.reply0x34, ReplyCode.reply0x35, ReplyCode.reply0x36, ReplyCode.reply0x37, ReplyCode.reply0x38, ReplyCode.reply0x39, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) 62, (byte) 63, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9};

    /* compiled from: TbsSdkJava */
    public static class a extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public a(OutputStream outputStream, int i) {
            int i2;
            boolean z = true;
            super(outputStream);
            this.f = (i & 8) != 0;
            if ((i & 1) == 0) {
                z = false;
            }
            this.a = z;
            if (this.a) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            this.d = i2;
            this.c = new byte[this.d];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = a.c(i);
        }

        public void write(int i) throws IOException {
            if (this.h) {
                this.out.write(i);
            } else if (this.a) {
                r0 = this.c;
                r1 = this.b;
                this.b = r1 + 1;
                r0[r1] = (byte) i;
                if (this.b >= this.d) {
                    this.out.write(a.b(this.g, this.c, this.d, this.i));
                    this.e += 4;
                    if (this.f && this.e >= 76) {
                        this.out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                }
            } else if (this.j[i & TransportMediator.KEYCODE_MEDIA_PAUSE] > (byte) -5) {
                r0 = this.c;
                r1 = this.b;
                this.b = r1 + 1;
                r0[r1] = (byte) i;
                if (this.b >= this.d) {
                    this.out.write(this.g, 0, a.b(this.c, 0, this.g, 0, this.i));
                    this.b = 0;
                }
            } else if (this.j[i & TransportMediator.KEYCODE_MEDIA_PAUSE] != (byte) -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.h) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void a() throws IOException {
            if (this.b <= 0) {
                return;
            }
            if (this.a) {
                this.out.write(a.b(this.g, this.c, this.b, this.i));
                this.b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            this.out = null;
        }
    }

    static {
        boolean z;
        if (a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }

    private static final byte[] b(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    private static final byte[] c(int i) {
        if ((i & 16) == 16) {
            return e;
        }
        if ((i & 32) == 32) {
            return g;
        }
        return c;
    }

    private a() {
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        a(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = 0;
        byte[] b = b(i4);
        int i6 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        i5 |= i6;
        switch (i2) {
            case 1:
                bArr2[i3] = b[i5 >>> 18];
                bArr2[i3 + 1] = b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = (byte) 61;
                bArr2[i3 + 3] = (byte) 61;
                break;
            case 2:
                bArr2[i3] = b[i5 >>> 18];
                bArr2[i3 + 1] = b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = b[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = (byte) 61;
                break;
            case 3:
                bArr2[i3] = b[i5 >>> 18];
                bArr2[i3 + 1] = b[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = b[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = b[i5 & 63];
                break;
        }
        return bArr2;
    }

    public static String a(byte[] bArr) {
        String str = null;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
            if (!a) {
                throw new AssertionError(e.getMessage());
            }
        }
        if (a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] b = b(bArr, i, i2, i3);
        try {
            return new String(b, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return new String(b);
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) throws IOException {
        a aVar;
        IOException e;
        OutputStream outputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        } else if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        } else if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
        } else if ((i3 & 2) != 0) {
            try {
                GZIPOutputStream gZIPOutputStream2;
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    aVar = new a(byteArrayOutputStream2, i3 | 1);
                    try {
                        gZIPOutputStream2 = new GZIPOutputStream(aVar);
                    } catch (IOException e2) {
                        e = e2;
                        outputStream = byteArrayOutputStream2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = outputStream;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception e3) {
                        }
                        try {
                            aVar.close();
                        } catch (Exception e4) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e5) {
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    aVar = null;
                    outputStream = byteArrayOutputStream2;
                    throw e;
                } catch (Throwable th4) {
                    th = th4;
                    aVar = null;
                    gZIPOutputStream.close();
                    aVar.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
                try {
                    gZIPOutputStream2.write(bArr, i, i2);
                    gZIPOutputStream2.close();
                    try {
                        gZIPOutputStream2.close();
                    } catch (Exception e7) {
                    }
                    try {
                        aVar.close();
                    } catch (Exception e8) {
                    }
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception e9) {
                    }
                    return byteArrayOutputStream2.toByteArray();
                } catch (IOException e10) {
                    e = e10;
                    gZIPOutputStream = gZIPOutputStream2;
                    outputStream = byteArrayOutputStream2;
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream = gZIPOutputStream2;
                    gZIPOutputStream.close();
                    aVar.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                aVar = null;
                outputStream = null;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                aVar = null;
                byteArrayOutputStream = null;
                gZIPOutputStream.close();
                aVar.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            int i4;
            int i5 = (i3 & 8) != 0 ? 1 : 0;
            int i6 = (i2 / 3) * 4;
            if (i2 % 3 > 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            i4 += i6;
            if (i5 != 0) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i7 = i2 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i7) {
                a(bArr, i10 + i, 3, bArr2, i9, i3);
                i4 = i8 + 4;
                if (i5 != 0 && i4 >= 76) {
                    bArr2[i9 + 4] = (byte) 10;
                    i9++;
                    i4 = 0;
                }
                i9 += 4;
                i8 = i4;
                i10 += 3;
            }
            if (i10 < i2) {
                a(bArr, i10 + i, i2 - i10, bArr2, i9, i3);
                i9 += 4;
            }
            if (i9 > bArr2.length - 1) {
                return bArr2;
            }
            Object obj = new byte[i9];
            System.arraycopy(bArr2, 0, obj, 0, i9);
            return obj;
        }
    }

    private static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)}));
        } else if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i2)}));
        } else {
            byte[] c = c(i3);
            if (bArr[i + 2] == (byte) 61) {
                bArr2[i2] = (byte) ((((c[bArr[i]] & 255) << 18) | ((c[bArr[i + 1]] & 255) << 12)) >>> 16);
                return 1;
            } else if (bArr[i + 3] == (byte) 61) {
                r0 = (((c[bArr[i]] & 255) << 18) | ((c[bArr[i + 1]] & 255) << 12)) | ((c[bArr[i + 2]] & 255) << 6);
                bArr2[i2] = (byte) (r0 >>> 16);
                bArr2[i2 + 1] = (byte) (r0 >>> 8);
                return 2;
            } else {
                r0 = ((((c[bArr[i]] & 255) << 18) | ((c[bArr[i + 1]] & 255) << 12)) | ((c[bArr[i + 2]] & 255) << 6)) | (c[bArr[i + 3]] & 255);
                bArr2[i2] = (byte) (r0 >> 16);
                bArr2[i2 + 1] = (byte) (r0 >> 8);
                bArr2[i2 + 2] = (byte) r0;
                return 3;
            }
        }
    }
}
