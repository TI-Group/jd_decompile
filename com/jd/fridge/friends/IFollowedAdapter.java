package com.jd.fridge.friends;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FriendInfo;
import com.jd.fridge.widget.CircularImageView;
import com.jd.fridge.widget.b.a.b;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;

/* compiled from: TbsSdkJava */
public class IFollowedAdapter extends Adapter<ViewHolder> {
    private final Context a;
    private final List<FriendInfo> b;
    private LayoutInflater c = LayoutInflater.from(this.a);
    private d d;

    /* compiled from: TbsSdkJava */
    class a extends ViewHolder {
        final /* synthetic */ IFollowedAdapter a;
        private final View b;
        private final CircularImageView c;
        private final TextView d;
        private final Button e;

        public a(IFollowedAdapter iFollowedAdapter, View view) {
            this.a = iFollowedAdapter;
            super(view);
            this.b = view;
            this.c = (CircularImageView) view.findViewById(R.id.user_avatar);
            this.d = (TextView) view.findViewById(R.id.user_nickname_textview);
            this.e = (Button) view.findViewById(R.id.action_btn);
        }
    }

    public IFollowedAdapter(Context context, List<FriendInfo> list) {
        this.a = context;
        this.b = list;
    }

    public void setOnNotifyDataSetChangeListener(d dVar) {
        this.d = dVar;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this, this.c.inflate(R.layout.friends_item_layout, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        FriendInfo friendInfo = (FriendInfo) this.b.get(i);
        aVar.d.setText(friendInfo.getNickname());
        ImageLoader.getInstance().displayImage(friendInfo.getAvatarUrl(), aVar.c);
        aVar.e.setText(R.string.activity_friends_list_stop_following);
        aVar.e.setTag(friendInfo);
        aVar.e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IFollowedAdapter a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                final FriendInfo friendInfo = (FriendInfo) view.getTag();
                new com.jd.fridge.widget.b.a(this.a.a).a(this.a.a(friendInfo.getNickname(), R.string.activity_friends_list_stop_following_toast, R.dimen.confirm_dialog_nickname_biger_textsize)).a(b.DOUBLE_BTN).b((int) R.string.activity_setting_no_btn).c((int) R.string.activity_setting_yes_btn).a(new com.jd.fridge.widget.b.a.a(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public void a() {
                        if (this.b.a.d != null) {
                            this.b.a.d.a(friendInfo);
                        }
                    }

                    public void b() {
                    }
                }).show();
            }
        });
    }

    public int getItemCount() {
        return this.b == null ? 0 : this.b.size();
    }

    private Spannable a(String str, int i, int i2) {
        Object string = this.a.getString(i, new Object[]{str});
        Spannable spannableString = new SpannableString(string);
        int indexOf = string.indexOf(str);
        spannableString.setSpan(new AbsoluteSizeSpan(this.a.getResources().getDimensionPixelSize(i2)), indexOf, str.length() + indexOf, 33);
        return spannableString;
    }
}
