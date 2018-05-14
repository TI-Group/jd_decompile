package org.apache.commons.lang.time;

/* compiled from: TbsSdkJava */
public class StopWatch {
    private long startTime = -1;
    private long stopTime = -1;

    public void start() {
        this.stopTime = -1;
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public void reset() {
        this.startTime = -1;
        this.stopTime = -1;
    }

    public void split() {
        this.stopTime = System.currentTimeMillis();
    }

    public void unsplit() {
        this.stopTime = -1;
    }

    public void suspend() {
        this.stopTime = System.currentTimeMillis();
    }

    public void resume() {
        this.startTime += System.currentTimeMillis() - this.stopTime;
        this.stopTime = -1;
    }

    public long getTime() {
        if (this.stopTime != -1) {
            return this.stopTime - this.startTime;
        }
        if (this.startTime == -1) {
            return 0;
        }
        return System.currentTimeMillis() - this.startTime;
    }

    public String toString() {
        return DurationFormatUtils.formatISO(getTime());
    }
}
