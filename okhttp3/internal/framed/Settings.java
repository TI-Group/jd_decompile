package okhttp3.internal.framed;

import java.util.Arrays;

/* compiled from: TbsSdkJava */
public final class Settings {
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    Settings set(int i, int i2, int i3) {
        if (i < this.values.length) {
            int i4 = 1 << i;
            this.set |= i4;
            if ((i2 & 1) != 0) {
                this.persistValue |= i4;
            } else {
                this.persistValue &= i4 ^ -1;
            }
            if ((i2 & 2) != 0) {
                this.persisted = i4 | this.persisted;
            } else {
                this.persisted = (i4 ^ -1) & this.persisted;
            }
            this.values[i] = i3;
        }
        return this;
    }

    boolean isSet(int i) {
        if (((1 << i) & this.set) != 0) {
            return true;
        }
        return false;
    }

    int get(int i) {
        return this.values[i];
    }

    int flags(int i) {
        int i2 = 0;
        if (isPersisted(i)) {
            i2 = 2;
        }
        if (persistValue(i)) {
            return i2 | 1;
        }
        return i2;
    }

    int size() {
        return Integer.bitCount(this.set);
    }

    int getUploadBandwidth(int i) {
        return (2 & this.set) != 0 ? this.values[1] : i;
    }

    int getHeaderTableSize() {
        return (2 & this.set) != 0 ? this.values[1] : -1;
    }

    int getDownloadBandwidth(int i) {
        return (4 & this.set) != 0 ? this.values[2] : i;
    }

    boolean getEnablePush(boolean z) {
        int i;
        if ((4 & this.set) != 0) {
            i = this.values[2];
        } else if (z) {
            boolean z2 = true;
        } else {
            i = 0;
        }
        if (i == 1) {
            return true;
        }
        return false;
    }

    int getRoundTripTime(int i) {
        return (8 & this.set) != 0 ? this.values[3] : i;
    }

    int getMaxConcurrentStreams(int i) {
        return (16 & this.set) != 0 ? this.values[4] : i;
    }

    int getCurrentCwnd(int i) {
        return (32 & this.set) != 0 ? this.values[5] : i;
    }

    int getMaxFrameSize(int i) {
        return (32 & this.set) != 0 ? this.values[5] : i;
    }

    int getDownloadRetransRate(int i) {
        return (64 & this.set) != 0 ? this.values[6] : i;
    }

    int getMaxHeaderListSize(int i) {
        return (64 & this.set) != 0 ? this.values[6] : i;
    }

    int getInitialWindowSize(int i) {
        return (128 & this.set) != 0 ? this.values[7] : i;
    }

    int getClientCertificateVectorSize(int i) {
        return (256 & this.set) != 0 ? this.values[8] : i;
    }

    boolean isFlowControlDisabled() {
        int i;
        if ((1024 & this.set) != 0) {
            i = this.values[10];
        } else {
            i = 0;
        }
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    boolean persistValue(int i) {
        if (((1 << i) & this.persistValue) != 0) {
            return true;
        }
        return false;
    }

    boolean isPersisted(int i) {
        if (((1 << i) & this.persisted) != 0) {
            return true;
        }
        return false;
    }

    void merge(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.isSet(i)) {
                set(i, settings.flags(i), settings.get(i));
            }
        }
    }
}
