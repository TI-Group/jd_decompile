package org.apache.commons.lang.math;

import java.util.Random;

/* compiled from: TbsSdkJava */
public final class JVMRandom extends Random {
    private boolean constructed;

    public JVMRandom() {
        this.constructed = false;
        this.constructed = true;
    }

    public synchronized void setSeed(long j) {
        if (this.constructed) {
            throw new UnsupportedOperationException();
        }
    }

    public synchronized double nextGaussian() {
        throw new UnsupportedOperationException();
    }

    public void nextBytes(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public int nextInt() {
        return nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int nextInt(int i) {
        if (i > 0) {
            return (int) (Math.random() * ((double) i));
        }
        throw new IllegalArgumentException("Upper bound for nextInt must be positive");
    }

    public long nextLong() {
        return nextLong(Long.MAX_VALUE);
    }

    public static long nextLong(long j) {
        if (j > 0) {
            return (long) (Math.random() * ((double) j));
        }
        throw new IllegalArgumentException("Upper bound for nextInt must be positive");
    }

    public boolean nextBoolean() {
        return Math.random() > 0.5d;
    }

    public float nextFloat() {
        return (float) Math.random();
    }

    public double nextDouble() {
        return Math.random();
    }
}
