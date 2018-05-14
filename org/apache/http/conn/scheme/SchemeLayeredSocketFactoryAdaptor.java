package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.params.HttpParams;

@Deprecated
/* compiled from: TbsSdkJava */
class SchemeLayeredSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor implements SchemeLayeredSocketFactory {
    private final LayeredSocketFactory factory;

    SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory layeredSocketFactory) {
        super(layeredSocketFactory);
        this.factory = layeredSocketFactory;
    }

    public Socket createLayeredSocket(Socket socket, String str, int i, HttpParams httpParams) throws IOException, UnknownHostException {
        return this.factory.createSocket(socket, str, i, true);
    }
}
