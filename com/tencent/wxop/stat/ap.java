package com.tencent.wxop.stat;

import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.wxop.stat.event.e;
import com.tencent.wxop.stat.event.i;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class ap implements Runnable {
    private Context a = null;
    private Map<String, Integer> b = null;
    private StatSpecifyReportedInfo c = null;

    public ap(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.a = context;
        this.c = statSpecifyReportedInfo;
        if (map != null) {
            this.b = map;
        }
    }

    private NetworkMonitor a(String str, int i) {
        Throwable th;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            networkMonitor.setDomain(str);
            networkMonitor.setPort(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, CommonUtil.POST_TIMEOUT);
            networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
            networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                StatServiceImpl.q.e(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            StatServiceImpl.q.e(th2);
            socket.close();
        } catch (Throwable th22) {
            StatServiceImpl.q.e(th22);
        }
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
    }

    private Map<String, Integer> a() {
        Map<String, Integer> hashMap = new HashMap();
        String a = StatConfig.a("__MTA_TEST_SPEED__", null);
        if (!(a == null || a.trim().length() == 0)) {
            for (String a2 : a2.split(";")) {
                String[] split = a2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            StatServiceImpl.q.e(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || this.b.size() == 0) {
                StatServiceImpl.q.i("empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    StatServiceImpl.q.w("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    StatServiceImpl.q.w("port is null for " + str);
                } else {
                    jSONArray.put(a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                }
            }
            if (jSONArray.length() != 0) {
                e iVar = new i(this.a, StatServiceImpl.a(this.a, false, this.c), this.c);
                iVar.a(jSONArray.toString());
                new aq(iVar).a();
            }
        } catch (Throwable th) {
            StatServiceImpl.q.e(th);
        }
    }
}
