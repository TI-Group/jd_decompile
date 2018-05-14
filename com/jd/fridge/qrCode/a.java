package com.jd.fridge.qrCode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FriendInfo;
import com.jd.fridge.friends.d;
import com.jd.fridge.widget.CircularImageView;
import com.jd.fridge.widget.b.a.b;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;

/* compiled from: TbsSdkJava */
public class a extends BaseAdapter {
    private Context a;
    private List<FriendInfo> b;
    private d c;
    private NewDampingView d;

    /* compiled from: TbsSdkJava */
    private class a {
        final /* synthetic */ a a;
        private CircularImageView b;
        private TextView c;
        private Button d;

        private a(a aVar) {
            this.a = aVar;
        }
    }

    public a(Context context, List list, d dVar) {
        this.a = context;
        this.b = list;
        this.c = dVar;
    }

    public a(Context context, List list, d dVar, NewDampingView newDampingView) {
        this.a = context;
        this.b = list;
        this.c = dVar;
        this.d = newDampingView;
    }

    public int getCount() {
        return this.b.size();
    }

    public Object getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.a).inflate(R.layout.friends_item_layout, null);
            aVar.c = (TextView) view.findViewById(R.id.user_nickname_textview);
            aVar.b = (CircularImageView) view.findViewById(R.id.user_avatar);
            aVar.d = (Button) view.findViewById(R.id.action_btn);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        FriendInfo friendInfo = (FriendInfo) this.b.get(i);
        aVar.c.setText(friendInfo.getNickname());
        ImageLoader.getInstance().displayImage(friendInfo.getAvatarUrl(), aVar.b);
        if (this.d != null) {
            aVar.d.setVisibility(this.d.b() ? 4 : 0);
        }
        aVar.d.setText("删除");
        aVar.d.setTag(friendInfo);
        aVar.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                final FriendInfo friendInfo = (FriendInfo) view.getTag();
                new com.jd.fridge.widget.b.a(this.a.a).a((int) R.string.activity_friends_list_remove_friends).a(b.DOUBLE_BTN).b((int) R.string.activity_setting_no_btn).c((int) R.string.activity_setting_yes_btn).a(new com.jd.fridge.widget.b.a.a(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public void a() {
                        if (this.b.a.c != null) {
                            this.b.a.c.a(friendInfo);
                        }
                    }

                    public void b() {
                    }
                }).show();
            }
        });
        return view;
    }

    public void a(DampingView dampingView) {
    }
}
