package com.kepler.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.jd.jdsdk.R;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class at extends LinearLayout {
    private ListView a;
    private Context b;
    private List<b> c = new ArrayList();
    private Map<String, b> d = new HashMap();
    private b e;
    private FaceCommonCallBack<b> f;
    private a g;
    private boolean h;

    /* compiled from: TbsSdkJava */
    class a extends BaseAdapter {
        final /* synthetic */ at a;
        private LayoutInflater b;

        public a(at atVar, Context context) {
            this.a = atVar;
            this.b = LayoutInflater.from(context);
        }

        public int getCount() {
            return this.a.c.size();
        }

        public Object getItem(int i) {
            return this.a.c.get(i);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            int i2 = R.layout.more_select_item;
            i2 = R.id.more_select_item_text;
            int i3 = R.id.more_select_item_image;
            if (view == null) {
                view = a.a().d("more_select_item");
                cVar = new c(this.a);
                cVar.a = (TextView) a.a().a(i2, view);
                cVar.b = (ImageView) a.a().a(i3, view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            b bVar = (b) this.a.c.get(i);
            cVar.a.setText(bVar.b);
            cVar.b.setImageResource(bVar.c);
            return view;
        }
    }

    /* compiled from: TbsSdkJava */
    public final class b {
        public String a;
        public String b;
        public int c;
        public int d;
        public boolean e;
        final /* synthetic */ at f;

        public b(at atVar, int i, String str, int i2, String str2) {
            this.f = atVar;
            this.b = str;
            this.d = i;
            this.c = i2;
            this.a = str2;
        }
    }

    /* compiled from: TbsSdkJava */
    public final class c {
        public TextView a;
        public ImageView b;
        final /* synthetic */ at c;

        public c(at atVar) {
            this.c = atVar;
        }
    }

    public void a(FaceCommonCallBack<b> faceCommonCallBack) {
        this.f = faceCommonCallBack;
    }

    public at(Context context) throws Exception {
        super(context);
        this.b = context;
        b();
        d();
    }

    private void b() throws Exception {
        String[] g = k.b().g();
        if (g == null) {
            throw new Exception("select more view no config items ");
        }
        c();
        for (Object obj : g) {
            if (this.d.containsKey(obj)) {
                b bVar = (b) this.d.get(obj);
                if (bVar != null) {
                    if (bVar != this.e || KeplerApiManager.getWebViewService().isKeplerLogined()) {
                        this.c.add(bVar);
                        bVar.e = true;
                    } else {
                        this.h = true;
                    }
                }
            }
        }
    }

    private void c() {
        int i = R.drawable.seclect_item_orderlist;
        int i2 = R.drawable.seclect_item_history;
        int i3 = R.drawable.seclect_item_serch;
        int i4 = R.drawable.seclect_item_no_has_message;
        int i5 = R.drawable.seclect_item_logout;
        this.d.put("1", new b(this, 1, a.a().b("order"), i, k.b().c()));
        this.d.put("2", new b(this, 2, a.a().b("history"), i2, k.b().i));
        this.d.put("3", new b(this, 3, a.a().b("search"), i3, k.b().h));
        this.d.put("4", new b(this, 4, a.a().b("message"), i4, k.b().j));
        this.e = new b(this, 5, a.a().b("loginout"), i5, null);
        this.d.put("5", this.e);
    }

    public void a(String str, boolean z) {
        if (this.h) {
            if (KeplerApiManager.getWebViewService().isKeplerLogined()) {
                if (!this.e.e) {
                    this.c.add(this.e);
                    this.e.e = true;
                }
            } else if (this.e.e) {
                this.c.remove(this.e);
                this.e.e = false;
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        if (this.g != null) {
            this.g.notifyDataSetChanged();
        }
    }

    private void d() {
        this.a = new ListView(this.b);
        this.g = new a(this, this.b);
        this.a.setAdapter(this.g);
        this.a.setCacheColorHint(0);
        this.a.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ at a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar = (b) this.a.c.get(i);
                if (this.a.f != null && bVar != null) {
                    this.a.f.callBack(bVar);
                }
            }
        });
        addView(this.a);
    }
}
