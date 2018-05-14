package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.l;
import com.sina.weibo.sdk.d.g;
import com.sina.weibo.sdk.d.j;
import com.sina.weibo.sdk.net.c;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.f;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class AttentionComponentView extends FrameLayout {
    private static final String a = AttentionComponentView.class.getName();
    private a b;
    private volatile boolean c = false;
    private FrameLayout d;
    private TextView e;
    private ProgressBar f;

    /* compiled from: TbsSdkJava */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private b e;

        private boolean a() {
            if (TextUtils.isEmpty(this.b)) {
                return false;
            }
            return true;
        }
    }

    public AttentionComponentView(Context context) {
        super(context);
        a(context);
    }

    public AttentionComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public AttentionComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        Drawable a = g.a(context, "common_button_white.9.png", "common_button_white_highlighted.9.png");
        this.d = new FrameLayout(context);
        this.d.setBackgroundDrawable(a);
        this.d.setPadding(0, g.a(getContext(), 6), g.a(getContext(), 2), g.a(getContext(), 6));
        this.d.setLayoutParams(new LayoutParams(g.a(getContext(), 66), -2));
        addView(this.d);
        this.e = new TextView(getContext());
        this.e.setIncludeFontPadding(false);
        this.e.setSingleLine(true);
        this.e.setTextSize(2, 13.0f);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.d.addView(this.e);
        this.f = new ProgressBar(getContext(), null, 16842873);
        this.f.setVisibility(8);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f.setLayoutParams(layoutParams);
        this.d.addView(this.f);
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AttentionComponentView a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.d();
            }
        });
        a(false);
    }

    public void setAttentionParam(a aVar) {
        this.b = aVar;
        if (aVar.a()) {
            a(aVar);
        }
    }

    private void b() {
        this.d.setEnabled(false);
        this.e.setVisibility(8);
        this.f.setVisibility(0);
    }

    private void c() {
        this.d.setEnabled(true);
        this.e.setVisibility(0);
        this.f.setVisibility(8);
    }

    private void a(boolean z) {
        c();
        if (z) {
            this.e.setText(g.a(getContext(), "Following", "已关注", "已關注"));
            this.e.setTextColor(-13421773);
            this.e.setCompoundDrawablesWithIntrinsicBounds(g.a(getContext(), "timeline_relationship_icon_attention.png"), null, null, null);
            this.d.setEnabled(false);
            return;
        }
        this.e.setText(g.a(getContext(), "Follow", "关注", "關注"));
        this.e.setTextColor(-32256);
        this.e.setCompoundDrawablesWithIntrinsicBounds(g.a(getContext(), "timeline_relationship_icon_addattention.png"), null, null, null);
        this.d.setEnabled(true);
    }

    private void a(a aVar) {
        if (!this.c) {
            com.sina.weibo.sdk.b.g.a(getContext(), aVar.a).a();
            this.c = true;
            b();
            f fVar = new f(aVar.a);
            fVar.a(Constants.PARAM_ACCESS_TOKEN, aVar.b);
            fVar.a("target_id", aVar.c);
            fVar.a("target_screen_name", aVar.d);
            c.a(getContext(), "https://api.weibo.com/2/friendships/show.json", fVar, "GET", new d(this) {
                final /* synthetic */ AttentionComponentView a;

                {
                    this.a = r1;
                }

                public void a(com.sina.weibo.sdk.c.b bVar) {
                    com.sina.weibo.sdk.d.d.a(AttentionComponentView.a, "error : " + bVar.getMessage());
                    this.a.c = false;
                }

                public void a(String str) {
                    com.sina.weibo.sdk.d.d.a(AttentionComponentView.a, "json : " + str);
                    try {
                        final JSONObject optJSONObject = new JSONObject(str).optJSONObject("target");
                        this.a.getHandler().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 a;

                            public void run() {
                                if (optJSONObject != null) {
                                    this.a.a.a(optJSONObject.optBoolean("followed_by", false));
                                }
                                this.a.a.c = false;
                            }
                        });
                    } catch (JSONException e) {
                    }
                }
            });
        }
    }

    private void d() {
        l lVar = new l(getContext());
        lVar.a("http://widget.weibo.com/relationship/followsdk.php");
        lVar.b(g.a(getContext(), "Follow", "关注", "關注"));
        lVar.h(this.b.a);
        lVar.c(this.b.c);
        lVar.a(this.b.e);
        lVar.g(this.b.b);
        lVar.a(new com.sina.weibo.sdk.component.l.a(this) {
            final /* synthetic */ AttentionComponentView a;

            {
                this.a = r1;
            }

            public void a(String str) {
                Object string = j.b(str).getString("result");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        long parseInt = (long) Integer.parseInt(string);
                        if (parseInt == 1) {
                            this.a.a(true);
                        } else if (parseInt == 0) {
                            this.a.a(false);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        });
        Bundle d = lVar.d();
        Intent intent = new Intent(getContext(), WeiboSdkBrowser.class);
        intent.putExtras(d);
        getContext().startActivity(intent);
    }
}
