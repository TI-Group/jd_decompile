package com.jingdong.jdma.e;

import android.content.Context;
import com.jingdong.jdma.a.a;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.d.e;
import java.util.Vector;

/* compiled from: TbsSdkJava */
public class c implements Runnable {
    boolean[] a = new boolean[]{false, false};
    private final a b;
    private boolean c = false;
    private String[] d = new String[]{CommonUtil.STATISTIC_TABLE_NAME};
    private a e;

    c(a aVar, a aVar2, Context context) {
        this.b = aVar;
        this.e = aVar2;
    }

    public void run() {
        int i = 0;
        while (!this.c) {
            Vector a = this.e.a(0);
            if (a == null) {
                this.c = true;
                i = 0;
            } else {
                int size;
                synchronized (a) {
                    size = a.size();
                    if (size > 0) {
                        this.a[i] = false;
                        e eVar = (e) a.get(size - 1);
                        long c = this.e.c(i);
                        CommonUtil.commonUtilLog(CommonUtil.TAG, "[db] add record:" + eVar.a());
                        this.b.a(this.d[i], eVar, c);
                        this.e.b(i);
                        a.remove(size - 1);
                        this.e.d(i);
                    }
                }
                if (size <= 0) {
                    this.a[0] = true;
                    int i2 = 0;
                    while (i2 < 1) {
                        i = i2 + 1;
                        if (!this.a[i2]) {
                            break;
                        } else if (i >= 1) {
                            synchronized (this) {
                                try {
                                    b();
                                    wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            i2 = i;
                        } else {
                            i2 = i;
                        }
                    }
                }
                i = 0;
            }
        }
    }

    private void b() {
        for (int i = 0; i < this.a.length; i++) {
            this.a[i] = false;
        }
    }

    public void a() {
        this.c = true;
    }
}
