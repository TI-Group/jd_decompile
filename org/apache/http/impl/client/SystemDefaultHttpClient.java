package org.apache.http.impl.client;

import java.net.ProxySelector;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.HttpParams;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public class SystemDefaultHttpClient extends DefaultHttpClient {
    public SystemDefaultHttpClient(HttpParams httpParams) {
        super(null, httpParams);
    }

    public SystemDefaultHttpClient() {
        super(null, null);
    }

    protected ClientConnectionManager createClientConnectionManager() {
        ClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
            int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
            poolingClientConnectionManager.setDefaultMaxPerRoute(parseInt);
            poolingClientConnectionManager.setMaxTotal(parseInt * 2);
        }
        return poolingClientConnectionManager;
    }

    protected HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
            return new DefaultConnectionReuseStrategy();
        }
        return new NoConnectionReuseStrategy();
    }
}
