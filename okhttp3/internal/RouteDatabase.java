package okhttp3.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* compiled from: TbsSdkJava */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public synchronized void failed(Route route) {
        this.failedRoutes.add(route);
    }

    public synchronized void connected(Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.failedRoutes.contains(route);
    }

    public synchronized int failedRoutesCount() {
        return this.failedRoutes.size();
    }
}
