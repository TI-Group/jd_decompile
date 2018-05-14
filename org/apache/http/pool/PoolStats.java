package org.apache.http.pool;

import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class PoolStats {
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int i, int i2, int i3, int i4) {
        this.leased = i;
        this.pending = i2;
        this.available = i3;
        this.max = i4;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getPending() {
        return this.pending;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getMax() {
        return this.max;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[leased: ");
        stringBuilder.append(this.leased);
        stringBuilder.append("; pending: ");
        stringBuilder.append(this.pending);
        stringBuilder.append("; available: ");
        stringBuilder.append(this.available);
        stringBuilder.append("; max: ");
        stringBuilder.append(this.max);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
