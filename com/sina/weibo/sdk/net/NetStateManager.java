package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import jd.wjlogin_sdk.util.NetworkType;
import org.apache.http.HttpHost;

/* compiled from: TbsSdkJava */
public class NetStateManager {
    public static a a = a.Mobile;
    private static Context b;

    /* compiled from: TbsSdkJava */
    public class NetStateReceive extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            NetStateManager.b = context;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkType.WIFI_STRING);
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (!wifiManager.isWifiEnabled() || -1 == connectionInfo.getNetworkId()) {
                    NetStateManager.a = a.Mobile;
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    public enum a {
        Mobile,
        WIFI,
        NOWAY
    }

    public static HttpHost a() {
        Cursor query;
        HttpHost httpHost = null;
        Uri parse = Uri.parse("content://telephony/carriers/preferapn");
        if (b != null) {
            query = b.getContentResolver().query(parse, null, null, null, null);
        } else {
            query = null;
        }
        if (query != null && query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("proxy"));
            if (string != null && string.trim().length() > 0) {
                httpHost = new HttpHost(string, 80);
            }
            query.close();
        }
        return httpHost;
    }
}
