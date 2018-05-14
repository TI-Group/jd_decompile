package okhttp3;

import java.net.Socket;

/* compiled from: TbsSdkJava */
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
