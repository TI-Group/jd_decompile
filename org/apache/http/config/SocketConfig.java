package org.apache.http.config;

import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class SocketConfig implements Cloneable {
    public static final SocketConfig DEFAULT = new Builder().build();
    private final boolean soKeepAlive;
    private final int soLinger;
    private final boolean soReuseAddress;
    private final int soTimeout;
    private final boolean tcpNoDelay;

    /* compiled from: TbsSdkJava */
    public static class Builder {
        private boolean soKeepAlive;
        private int soLinger = -1;
        private boolean soReuseAddress;
        private int soTimeout;
        private boolean tcpNoDelay = true;

        Builder() {
        }

        public Builder setSoTimeout(int i) {
            this.soTimeout = i;
            return this;
        }

        public Builder setSoReuseAddress(boolean z) {
            this.soReuseAddress = z;
            return this;
        }

        public Builder setSoLinger(int i) {
            this.soLinger = i;
            return this;
        }

        public Builder setSoKeepAlive(boolean z) {
            this.soKeepAlive = z;
            return this;
        }

        public Builder setTcpNoDelay(boolean z) {
            this.tcpNoDelay = z;
            return this;
        }

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay);
        }
    }

    SocketConfig(int i, boolean z, int i2, boolean z2, boolean z3) {
        this.soTimeout = i;
        this.soReuseAddress = z;
        this.soLinger = i2;
        this.soKeepAlive = z2;
        this.tcpNoDelay = z3;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    protected SocketConfig clone() throws CloneNotSupportedException {
        return (SocketConfig) super.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[soTimeout=").append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append("]");
        return stringBuilder.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(SocketConfig socketConfig) {
        Args.notNull(socketConfig, "Socket config");
        return new Builder().setSoTimeout(socketConfig.getSoTimeout()).setSoReuseAddress(socketConfig.isSoReuseAddress()).setSoLinger(socketConfig.getSoLinger()).setSoKeepAlive(socketConfig.isSoKeepAlive()).setTcpNoDelay(socketConfig.isTcpNoDelay());
    }
}
