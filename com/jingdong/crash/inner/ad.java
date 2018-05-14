package com.jingdong.crash.inner;

import android.os.Environment;
import android.os.StatFs;

class ad {
    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long j = -1;
        try {
            long blockCount = (long) statFs.getBlockCount();
            return ((((long) statFs.getAvailableBlocks()) * ((((long) statFs.getBlockSize()) * 2) / 1024)) / 2) / 1024;
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }
}
