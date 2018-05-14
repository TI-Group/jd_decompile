package com.google.zxing.oned;

/* compiled from: TbsSdkJava */
public abstract class UPCEANWriter extends OneDimensionalCodeWriter {
    public int getDefaultMargin() {
        return UPCEANReader.START_END_PATTERN.length;
    }
}
