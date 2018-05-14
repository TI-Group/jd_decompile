package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class ak extends Handler {
    ak(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case 100:
                boolean z2 = message.arg1 == 1;
                z = TbsDownloader.b(true, false);
                if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=" + z);
                    if (!z || z2) {
                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(z, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    }
                }
                if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && z) {
                    TbsDownloader.startDownload(TbsDownloader.c);
                    return;
                }
                return;
            case 101:
            case 108:
                FileLock fileLock = null;
                FileOutputStream b = k.b(TbsDownloader.c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                if (b != null) {
                    fileLock = k.a(TbsDownloader.c, b);
                    if (fileLock == null) {
                        TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                        TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-203);
                        return;
                    }
                } else if (k.a(TbsDownloader.c)) {
                    TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-204);
                    return;
                }
                boolean z3 = message.arg1 == 1;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.c);
                if (!TbsDownloader.c(false, z3, 108 == message.what)) {
                    QbSdk.j.onDownloadFinish(110);
                } else if (z3 && ao.a().a(TbsDownloader.c, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                    QbSdk.j.onDownloadFinish(ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR);
                    instance.setDownloadInterruptCode(-213);
                } else if (instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                    TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-215);
                    ah b2 = TbsDownloader.g;
                    if (108 != message.what) {
                        z = false;
                    }
                    b2.b(z3, z);
                } else {
                    QbSdk.j.onDownloadFinish(110);
                }
                TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                k.a(fileLock, b);
                return;
            case 102:
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                int a = TbsShareManager.isThirdPartyApp(TbsDownloader.c) ? TbsShareManager.a(TbsDownloader.c, false) : ao.a().g(TbsDownloader.c);
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + a);
                TbsDownloader.g.a(a);
                TbsLogReport.a(TbsDownloader.c).b();
                return;
            case 103:
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                if (message.arg1 == 0) {
                    ao.a().a((Context) message.obj, true);
                    return;
                } else {
                    ao.a().a((Context) message.obj, false);
                    return;
                }
            case 104:
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                TbsLogReport.a(TbsDownloader.c).c();
                return;
            default:
                return;
        }
    }
}
