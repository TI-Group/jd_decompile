package com.tencent.smtt.sdk;

final class l implements TbsListener {
    l() {
    }

    public void onDownloadFinish(int i) {
        if (QbSdk.y != null) {
            QbSdk.y.onDownloadFinish(i);
        }
        if (QbSdk.z != null) {
            QbSdk.z.onDownloadFinish(i);
        }
        if (TbsDownloader.startDecoupleCoreIfNeeded()) {
            TbsDownloader.a = true;
        } else {
            TbsDownloader.a = false;
        }
    }

    public void onDownloadProgress(int i) {
        if (QbSdk.z != null) {
            QbSdk.z.onDownloadProgress(i);
        }
        if (QbSdk.y != null) {
            QbSdk.y.onDownloadProgress(i);
        }
    }

    public void onInstallFinish(int i) {
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.a = false;
        if (QbSdk.y != null) {
            QbSdk.y.onInstallFinish(i);
        }
        if (QbSdk.z != null) {
            QbSdk.z.onInstallFinish(i);
        }
    }
}
