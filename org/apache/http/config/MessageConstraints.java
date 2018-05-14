package org.apache.http.config;

import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public class MessageConstraints implements Cloneable {
    public static final MessageConstraints DEFAULT = new Builder().build();
    private final int maxHeaderCount;
    private final int maxLineLength;

    /* compiled from: TbsSdkJava */
    public static class Builder {
        private int maxHeaderCount = -1;
        private int maxLineLength = -1;

        Builder() {
        }

        public Builder setMaxLineLength(int i) {
            this.maxLineLength = i;
            return this;
        }

        public Builder setMaxHeaderCount(int i) {
            this.maxHeaderCount = i;
            return this;
        }

        public MessageConstraints build() {
            return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
        }
    }

    MessageConstraints(int i, int i2) {
        this.maxLineLength = i;
        this.maxHeaderCount = i2;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    protected MessageConstraints clone() throws CloneNotSupportedException {
        return (MessageConstraints) super.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[maxLineLength=").append(this.maxLineLength).append(", maxHeaderCount=").append(this.maxHeaderCount).append("]");
        return stringBuilder.toString();
    }

    public static MessageConstraints lineLen(int i) {
        return new MessageConstraints(Args.notNegative(i, "Max line length"), -1);
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(MessageConstraints messageConstraints) {
        Args.notNull(messageConstraints, "Message constraints");
        return new Builder().setMaxHeaderCount(messageConstraints.getMaxHeaderCount()).setMaxLineLength(messageConstraints.getMaxLineLength());
    }
}
