package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class ax implements a {
    final /* synthetic */ TbsLogReport a;

    ax(TbsLogReport tbsLogReport) {
        this.a = tbsLogReport;
    }

    public void a(int i) {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
    }
}
