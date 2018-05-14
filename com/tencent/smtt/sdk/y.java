package com.tencent.smtt.sdk;

class y implements Runnable {
    final /* synthetic */ x a;

    y(x xVar) {
        this.a = xVar;
    }

    public void run() {
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.a.b.getContext()) && TbsDownloader.needDownload(this.a.b.getContext(), false)) {
            TbsDownloader.startDownload(this.a.b.getContext());
        }
    }
}
