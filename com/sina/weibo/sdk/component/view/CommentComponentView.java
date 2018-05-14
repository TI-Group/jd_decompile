package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.l;
import com.sina.weibo.sdk.d.g;

/* compiled from: TbsSdkJava */
public class CommentComponentView extends FrameLayout {
    private b a;
    private LinearLayout b;

    /* compiled from: TbsSdkJava */
    public enum a {
        MOVIE("1001"),
        TRAVEL("1002");
        
        private String mVal;

        private a(String str) {
            this.mVal = str;
        }

        public String getValue() {
            return this.mVal;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class b {
        private String a;
        private String b;
        private String c;
        private String d;
        private a e;
        private com.sina.weibo.sdk.a.b f;
    }

    public CommentComponentView(Context context) {
        super(context);
        a(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.b = new LinearLayout(context);
        this.b.setOrientation(0);
        this.b.setLayoutParams(new LayoutParams(-2, -2));
        View imageView = new ImageView(context);
        imageView.setImageDrawable(g.a(context, "sdk_weibo_logo.png"));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(g.a(getContext(), 20), g.a(getContext(), 20));
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        View textView = new TextView(context);
        textView.setText(g.a(context, "Comment", "微博热评", "微博熱評"));
        textView.setTextColor(-32256);
        textView.setTextSize(2, 15.0f);
        textView.setIncludeFontPadding(false);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = g.a(getContext(), 4);
        textView.setLayoutParams(layoutParams2);
        this.b.addView(imageView);
        this.b.addView(textView);
        addView(this.b);
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CommentComponentView a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a();
            }
        });
    }

    public void setCommentParam(b bVar) {
        this.a = bVar;
    }

    private void a() {
        com.sina.weibo.sdk.b.g.a(getContext(), this.a.a).a();
        l lVar = new l(getContext());
        lVar.a("http://widget.weibo.com/distribution/socail_comments_sdk.php");
        lVar.b(g.a(getContext(), "Comment", "微博热评", "微博熱評"));
        lVar.h(this.a.a);
        lVar.e(this.a.c);
        lVar.d(this.a.d);
        lVar.f(this.a.e.getValue());
        lVar.a(this.a.f);
        lVar.g(this.a.b);
        Bundle d = lVar.d();
        Intent intent = new Intent(getContext(), WeiboSdkBrowser.class);
        intent.putExtras(d);
        getContext().startActivity(intent);
    }
}
