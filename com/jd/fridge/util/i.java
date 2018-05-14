package com.jd.fridge.util;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.jd.fridge.bean.UpdateDownloadData;

/* compiled from: TbsSdkJava */
public class i extends ContentObserver {
    private Handler a;
    private Context b;
    private int c;
    private DownloadManager d = ((DownloadManager) this.b.getSystemService("download"));
    private Query e;
    private Cursor f;
    private long g;
    private UpdateDownloadData h;

    @SuppressLint({"NewApi"})
    public i(Handler handler, Context context, long j) {
        super(handler);
        this.a = handler;
        this.b = context;
        this.e = new Query().setFilterById(new long[]{j});
        this.g = j;
        this.h = new UpdateDownloadData();
        this.h.setId(this.g);
    }

    @SuppressLint({"NewApi"})
    public void onChange(boolean z) {
        super.onChange(z);
        boolean z2 = true;
        this.f = this.d.query(this.e);
        if (this.f != null) {
            this.f.moveToFirst();
            this.c = (this.f.getInt(this.f.getColumnIndex("bytes_so_far")) * 100) / this.f.getInt(this.f.getColumnIndex("total_size"));
            if (VERSION.SDK_INT < 14) {
                this.f.close();
            }
            if (this.f.getInt(this.f.getColumnIndex("status")) == 8) {
                z2 = false;
            }
            r.b("infos", "downloadManager.STATUS==" + this.f.getInt(this.f.getColumnIndex("status")));
            this.h.setDownloading(z2);
            Message message = new Message();
            message.what = 99999;
            message.obj = this.h;
            message.arg1 = this.c;
            this.a.sendMessage(message);
            r.b("infos", "DownloadObserver.downloading===" + z2 + "==progress==" + this.c);
        }
    }
}
