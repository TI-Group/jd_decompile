package org.apache.http.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class ConnectionConfig implements Cloneable {
    public static final ConnectionConfig DEFAULT = new Builder().build();
    private final int bufferSize;
    private final Charset charset;
    private final int fragmentSizeHint;
    private final CodingErrorAction malformedInputAction;
    private final MessageConstraints messageConstraints;
    private final CodingErrorAction unmappableInputAction;

    /* compiled from: TbsSdkJava */
    public static class Builder {
        private int bufferSize;
        private Charset charset;
        private int fragmentSizeHint = -1;
        private CodingErrorAction malformedInputAction;
        private MessageConstraints messageConstraints;
        private CodingErrorAction unmappableInputAction;

        Builder() {
        }

        public Builder setBufferSize(int i) {
            this.bufferSize = i;
            return this;
        }

        public Builder setFragmentSizeHint(int i) {
            this.fragmentSizeHint = i;
            return this;
        }

        public Builder setCharset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction codingErrorAction) {
            this.malformedInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }

        public Builder setUnmappableInputAction(CodingErrorAction codingErrorAction) {
            this.unmappableInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }

        public Builder setMessageConstraints(MessageConstraints messageConstraints) {
            this.messageConstraints = messageConstraints;
            return this;
        }

        public ConnectionConfig build() {
            int i;
            Charset charset = this.charset;
            if (charset == null && !(this.malformedInputAction == null && this.unmappableInputAction == null)) {
                charset = Consts.ASCII;
            }
            int i2 = this.bufferSize > 0 ? this.bufferSize : 8192;
            if (this.fragmentSizeHint >= 0) {
                i = this.fragmentSizeHint;
            } else {
                i = i2;
            }
            return new ConnectionConfig(i2, i, charset, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
        }
    }

    ConnectionConfig(int i, int i2, Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2, MessageConstraints messageConstraints) {
        this.bufferSize = i;
        this.fragmentSizeHint = i2;
        this.charset = charset;
        this.malformedInputAction = codingErrorAction;
        this.unmappableInputAction = codingErrorAction2;
        this.messageConstraints = messageConstraints;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public int getFragmentSizeHint() {
        return this.fragmentSizeHint;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    public MessageConstraints getMessageConstraints() {
        return this.messageConstraints;
    }

    protected ConnectionConfig clone() throws CloneNotSupportedException {
        return (ConnectionConfig) super.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bufferSize=").append(this.bufferSize).append(", fragmentSizeHint=").append(this.fragmentSizeHint).append(", charset=").append(this.charset).append(", malformedInputAction=").append(this.malformedInputAction).append(", unmappableInputAction=").append(this.unmappableInputAction).append(", messageConstraints=").append(this.messageConstraints).append("]");
        return stringBuilder.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(ConnectionConfig connectionConfig) {
        Args.notNull(connectionConfig, "Connection config");
        return new Builder().setCharset(connectionConfig.getCharset()).setMalformedInputAction(connectionConfig.getMalformedInputAction()).setUnmappableInputAction(connectionConfig.getUnmappableInputAction()).setMessageConstraints(connectionConfig.getMessageConstraints());
    }
}
