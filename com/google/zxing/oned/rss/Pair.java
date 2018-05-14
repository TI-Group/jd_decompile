package com.google.zxing.oned.rss;

/* compiled from: TbsSdkJava */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    int getCount() {
        return this.count;
    }

    void incrementCount() {
        this.count++;
    }
}
