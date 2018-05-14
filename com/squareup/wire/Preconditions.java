package com.squareup.wire;

/* compiled from: TbsSdkJava */
final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str + " == null");
        }
    }

    static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
