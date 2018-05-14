package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.d.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: TbsSdkJava */
public class SelectCountryActivity extends Activity implements com.sina.weibo.sdk.register.mobile.LetterIndexBar.a {
    String a = "";
    private LetterIndexBar b;
    private List<a>[] c;
    private List<a> d;
    private b e;
    private List<b> f = new ArrayList();
    private ListView g;
    private a h;
    private RelativeLayout i;
    private FrameLayout j;

    /* compiled from: TbsSdkJava */
    private class a extends BaseAdapter {
        final /* synthetic */ SelectCountryActivity a;

        private a(SelectCountryActivity selectCountryActivity) {
            this.a = selectCountryActivity;
        }

        public int getCount() {
            if (this.a.f != null) {
                return this.a.f.size();
            }
            return 0;
        }

        public Object getItem(int i) {
            if (this.a.f == null || this.a.f.isEmpty()) {
                return null;
            }
            if (i == this.a.f.size()) {
                return null;
            }
            b bVar = (b) this.a.f.get(i);
            if (bVar.b == -1) {
                return null;
            }
            return this.a.c[bVar.a].get(bVar.b);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar = (b) this.a.f.get(i);
            a aVar;
            if (view == null) {
                if (bVar.b == -1) {
                    return a(bVar.a);
                }
                aVar = (a) this.a.c[bVar.a].get(bVar.b);
                return new SelectCountryItemView(this.a, aVar.getName(), aVar.getCode());
            } else if (bVar.b != -1) {
                aVar = (a) this.a.c[bVar.a].get(bVar.b);
                if (view instanceof SelectCountryTitleView) {
                    return new SelectCountryItemView(this.a, aVar.getName(), aVar.getCode());
                }
                ((SelectCountryItemView) view).a(aVar.getName(), aVar.getCode());
                return view;
            } else if (!(view instanceof SelectCountryTitleView)) {
                return a(bVar.a);
            } else {
                if (bVar.a != 0) {
                    return a(bVar.a);
                }
                ((SelectCountryTitleView) view).a(g.a(this.a, "Common", "常用", "常用"));
                return view;
            }
        }

        private SelectCountryTitleView a(int i) {
            SelectCountryTitleView selectCountryTitleView = new SelectCountryTitleView(this.a.getApplicationContext());
            if (i == 0) {
                selectCountryTitleView.setTitle(g.a(this.a, "Common", "常用", "常用"));
            } else {
                selectCountryTitleView.setTitle(String.valueOf((char) ((i + 65) - 1)));
            }
            return selectCountryTitleView;
        }
    }

    /* compiled from: TbsSdkJava */
    private class b {
        int a;
        int b;
        final /* synthetic */ SelectCountryActivity c;

        b(SelectCountryActivity selectCountryActivity, int i, int i2) {
            this.c = selectCountryActivity;
            this.a = i;
            this.b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b) || this.b != -1) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b) {
                return true;
            }
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    private void a() {
        this.i = new RelativeLayout(this);
        this.i.setLayoutParams(new LayoutParams(-1, -1));
        View titleBar = new TitleBar(this);
        titleBar.setId(1);
        titleBar.setLeftBtnBg(g.a((Context) this, "weibosdk_navigationbar_back.png", "weibosdk_navigationbar_back_highlighted.png"));
        titleBar.setTitleBarText(g.a(this, "Region", "选择国家", "選擇國家"));
        titleBar.setTitleBarClickListener(new com.sina.weibo.sdk.component.view.TitleBar.a(this) {
            final /* synthetic */ SelectCountryActivity a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.setResult(0);
                this.a.finish();
            }
        });
        this.i.addView(titleBar);
        this.j = new FrameLayout(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(3, titleBar.getId());
        this.j.setLayoutParams(layoutParams);
        this.i.addView(this.j);
        this.g = new ListView(this);
        this.g.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.g.setFadingEdgeLength(0);
        this.g.setSelector(new ColorDrawable(0));
        this.g.setDividerHeight(g.a((Context) this, 1));
        this.g.setCacheColorHint(0);
        this.g.setDrawSelectorOnTop(false);
        this.g.setScrollingCacheEnabled(false);
        this.g.setScrollbarFadingEnabled(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectCountryActivity a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a aVar = (a) this.a.h.getItem(i);
                if (aVar != null) {
                    Intent intent = new Intent();
                    intent.putExtra("code", aVar.getCode());
                    intent.putExtra("name", aVar.getName());
                    this.a.setResult(-1, intent);
                    this.a.finish();
                }
            }
        });
        this.j.addView(this.g);
        this.h = new a();
        this.g.setAdapter(this.h);
        this.b = new LetterIndexBar(this);
        this.b.setIndexChangeListener(this);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 5;
        this.b.setLayoutParams(layoutParams2);
        this.j.addView(this.b);
        c.a((Context) this);
        Locale a = g.a();
        if (Locale.SIMPLIFIED_CHINESE.equals(a)) {
            this.a = g.c(this, "countryCode.txt");
        } else if (Locale.TRADITIONAL_CHINESE.equals(a)) {
            this.a = g.c(this, "countryCodeTw.txt");
        } else {
            this.a = g.c(this, "countryCodeEn.txt");
        }
        this.e = new b(this.a);
        this.d = this.e.countries;
        this.c = a(this.d);
        this.f = a(this.c);
        this.h.notifyDataSetChanged();
        setContentView(this.i);
    }

    protected void onPause() {
        super.onPause();
    }

    public void a(int i) {
        if (this.c != null && i < this.c.length && this.c[i] != null) {
            this.g.setSelection(this.f.indexOf(new b(this, i, -1)));
        }
    }

    private List<a>[] a(List<a> list) {
        List[] listArr = new ArrayList[27];
        a aVar = new a();
        aVar.setCode(a.CHINA_CODE);
        aVar.setName(g.a(this, "China", "中国", "中國"));
        listArr[0] = new ArrayList();
        listArr[0].add(aVar);
        for (int i = 0; i < list.size(); i++) {
            aVar = (a) list.get(i);
            if (aVar.getCode().equals("00852") || aVar.getCode().equals("00853") || aVar.getCode().equals("00886")) {
                listArr[0].add(aVar);
            } else {
                int charAt = (aVar.getPinyin().charAt(0) - 97) + 1;
                if (listArr[charAt] == null) {
                    listArr[charAt] = new ArrayList();
                }
                listArr[charAt].add(aVar);
            }
        }
        return listArr;
    }

    private List<b> a(List<a>[] listArr) {
        List<b> arrayList = new ArrayList();
        if (listArr != null) {
            for (int i = 0; i < listArr.length; i++) {
                List list = listArr[i];
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (i2 == 0) {
                            arrayList.add(new b(this, i, -1));
                        }
                        arrayList.add(new b(this, i, i2));
                    }
                }
            }
        }
        return arrayList;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
