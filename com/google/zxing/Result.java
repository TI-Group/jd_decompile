package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class Result {
    private final BarcodeFormat format;
    private final byte[] rawBytes;
    private Map<ResultMetadataType, Object> resultMetadata;
    private ResultPoint[] resultPoints;
    private final String text;
    private final long timestamp;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, System.currentTimeMillis());
    }

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat, long j) {
        this.text = str;
        this.rawBytes = bArr;
        this.resultPoints = resultPointArr;
        this.format = barcodeFormat;
        this.resultMetadata = null;
        this.timestamp = j;
    }

    public String getText() {
        return this.text;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public BarcodeFormat getBarcodeFormat() {
        return this.format;
    }

    public Map<ResultMetadataType, Object> getResultMetadata() {
        return this.resultMetadata;
    }

    public void putMetadata(ResultMetadataType resultMetadataType, Object obj) {
        if (this.resultMetadata == null) {
            this.resultMetadata = new EnumMap(ResultMetadataType.class);
        }
        this.resultMetadata.put(resultMetadataType, obj);
    }

    public void putAllMetadata(Map<ResultMetadataType, Object> map) {
        if (map == null) {
            return;
        }
        if (this.resultMetadata == null) {
            this.resultMetadata = map;
        } else {
            this.resultMetadata.putAll(map);
        }
    }

    public void addResultPoints(ResultPoint[] resultPointArr) {
        Object obj = this.resultPoints;
        if (obj == null) {
            this.resultPoints = resultPointArr;
        } else if (resultPointArr != null && resultPointArr.length > 0) {
            Object obj2 = new ResultPoint[(obj.length + resultPointArr.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(resultPointArr, 0, obj2, obj.length, resultPointArr.length);
            this.resultPoints = obj2;
        }
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return this.text;
    }
}
