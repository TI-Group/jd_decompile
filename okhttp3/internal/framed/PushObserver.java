package okhttp3.internal.framed;

import b.e;
import java.io.IOException;
import java.util.List;

/* compiled from: TbsSdkJava */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onRequest(int i, List<Header> list) {
            return true;
        }

        public boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        public boolean onData(int i, e eVar, int i2, boolean z) throws IOException {
            eVar.h((long) i2);
            return true;
        }

        public void onReset(int i, ErrorCode errorCode) {
        }
    };

    boolean onData(int i, e eVar, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
