package com.nostra13.universalimageloader.core.assist;

/* compiled from: TbsSdkJava */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    /* compiled from: TbsSdkJava */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.type = failType;
        this.cause = th;
    }

    public FailType getType() {
        return this.type;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
