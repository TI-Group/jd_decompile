package com.google.zxing;

/* compiled from: TbsSdkJava */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2);
        this.dataWidth = i;
        this.dataHeight = i2;
        this.left = 0;
        this.top = 0;
        this.luminances = new byte[(i * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * i;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = iArr[i4 + i5];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                i6 &= 255;
                if (i7 == i8 && i8 == i6) {
                    this.luminances[i4 + i5] = (byte) i7;
                } else {
                    this.luminances[i4 + i5] = (byte) ((i6 + (i7 + (i8 * 2))) / 4);
                }
            }
        }
    }

    private RGBLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.luminances = bArr;
        this.dataWidth = i;
        this.dataHeight = i2;
        this.left = i3;
        this.top = i4;
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, ((this.top + i) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    public byte[] getMatrix() {
        int i = 0;
        int width = getWidth();
        int height = getHeight();
        if (width == this.dataWidth && height == this.dataHeight) {
            return this.luminances;
        }
        int i2 = width * height;
        byte[] bArr = new byte[i2];
        int i3 = (this.top * this.dataWidth) + this.left;
        if (width == this.dataWidth) {
            System.arraycopy(this.luminances, i3, bArr, 0, i2);
            return bArr;
        }
        Object obj = this.luminances;
        while (i < height) {
            System.arraycopy(obj, i3, bArr, i * width, width);
            i3 += this.dataWidth;
            i++;
        }
        return bArr;
    }

    public boolean isCropSupported() {
        return true;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i, this.top + i2, i3, i4);
    }
}
