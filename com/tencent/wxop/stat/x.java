package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.event.b;
import com.tencent.wxop.stat.event.c;
import com.tencent.wxop.stat.event.e;

final class x implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ Context c;
    final /* synthetic */ StatSpecifyReportedInfo d;

    x(String str, c cVar, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.a = str;
        this.b = cVar;
        this.c = context;
        this.d = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.a(this.a)) {
                StatServiceImpl.q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) StatServiceImpl.e.remove(this.b);
            if (l != null) {
                e bVar = new b(this.c, StatServiceImpl.a(this.c, false, this.d), this.b.a, this.d);
                bVar.b().b = this.b.b;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                bVar.a(Long.valueOf(l.longValue() == 0 ? 1 : l.longValue()).longValue());
                new aq(bVar).a();
                return;
            }
            StatServiceImpl.q.error("No start time found for custom event: " + this.b.toString() + ", lost trackCustomBeginEvent()?");
        } catch (Throwable th) {
            StatServiceImpl.q.e(th);
            StatServiceImpl.a(this.c, th);
        }
    }
}
