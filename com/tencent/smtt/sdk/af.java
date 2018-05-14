package com.tencent.smtt.sdk;

class af implements Runnable {
    final /* synthetic */ ae a;

    af(ae aeVar) {
        this.a = aeVar;
    }

    public void run() {
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.a.b.getContext()) && TbsDownloader.needDownload(this.a.b.getContext(), false)) {
            TbsDownloader.startDownload(this.a.b.getContext());
        }
    }
}
