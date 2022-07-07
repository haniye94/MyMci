package com.hani.mymci;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.Map;


public final class Util {
    private static Util util = new Util();
    private Context context = null;
    private ApplicationInfo applicationInfo = new ApplicationInfo();

    private Util() {
    }

    public static Util getInstance(Context context) {
        if (util.context == null) {
            util.context = context;
        }
        return util;
    }

    public void getConnectionRequest(ConnectionManager.IConnectionManager iConnectionManager, int requestCode, String url, Map<String, String> headers) {
        ConnectionManager connectionManager = new ConnectionManager(iConnectionManager, requestCode);
        connectionManager.getConnectionRequest(url, headers);
    }
}
