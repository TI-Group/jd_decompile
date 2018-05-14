package com.jd.fridge.picHistory;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.FridgePicture;
import com.jd.fridge.bean.FridgeSnapshot;
import com.jd.fridge.widget.CircularImageView;
import com.jd.fridge.widget.viewpageindicator.CirclePageIndicator;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: TbsSdkJava */
public class PictureHistoryListAdapter extends Adapter<ViewHolder> {
    private final Context a;
    private final List<FridgeSnapshot> b;
    private LayoutInflater c;
    private FragmentManager d;
    private boolean e = false;

    /* compiled from: TbsSdkJava */
    class a extends ViewHolder {
        final /* synthetic */ PictureHistoryListAdapter a;

        public a(PictureHistoryListAdapter pictureHistoryListAdapter, View view) {
            this.a = pictureHistoryListAdapter;
            super(view);
        }
    }

    /* compiled from: TbsSdkJava */
    class b extends ViewHolder {
        final ViewPager a;
        final CirclePageIndicator b;
        final CircularImageView c;
        final TextView d;
        final TextView e;
        final /* synthetic */ PictureHistoryListAdapter f;

        public b(PictureHistoryListAdapter pictureHistoryListAdapter, View view) {
            this.f = pictureHistoryListAdapter;
            super(view);
            this.a = (ViewPager) view.findViewById(R.id.picture_viewpager);
            this.b = (CirclePageIndicator) view.findViewById(R.id.viewpager_indicator);
            this.c = (CircularImageView) view.findViewById(R.id.user_avatar_image);
            this.d = (TextView) view.findViewById(R.id.user_nickname_textview);
            this.e = (TextView) view.findViewById(R.id.date_time_textview);
        }
    }

    public PictureHistoryListAdapter(Context context, FragmentManager fragmentManager, List<FridgeSnapshot> list) {
        this.a = context;
        this.c = LayoutInflater.from(this.a);
        this.b = list;
        this.d = fragmentManager;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new b(this, this.c.inflate(R.layout.fridge_snapshot_history_item, viewGroup, false));
        }
        return new a(this, this.c.inflate(R.layout.fridge_pic_history_footer, viewGroup, false));
    }

    public int getItemViewType(int i) {
        return i < this.b.size() ? 0 : 1;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                a(viewHolder, i);
                return;
            default:
                return;
        }
    }

    public void a(ViewHolder viewHolder, int i) {
        b bVar = (b) viewHolder;
        FridgeSnapshot fridgeSnapshot = (FridgeSnapshot) this.b.get(i);
        bVar.itemView.setTag(fridgeSnapshot);
        ImageLoader.getInstance().displayImage(GlobalVariable.K(), bVar.c);
        bVar.d.setText(GlobalVariable.J());
        String format = new SimpleDateFormat("MM-dd HH:mm").format(new Date(fridgeSnapshot.getTime()));
        bVar.e.setText(this.a.getString(R.string.activity_picture_history_shot_date_text, new Object[]{format}));
        List arrayList = new ArrayList();
        if (fridgeSnapshot.getDetails() == null || fridgeSnapshot.getDetails().size() <= 0) {
            View inflate = this.c.inflate(R.layout.no_fridge_picture_view, null);
            inflate.setVisibility(0);
            arrayList.add(inflate);
        } else {
            ImageView imageView = new ImageView(this.a);
            ImageLoader.getInstance().displayImage(((FridgePicture) fridgeSnapshot.getDetails().get(0)).getPicUrl(), imageView);
            arrayList.add(imageView);
            ImageView imageView2 = new ImageView(this.a);
            ImageLoader.getInstance().displayImage(((FridgePicture) fridgeSnapshot.getDetails().get(1)).getPicUrl(), imageView2);
            arrayList.add(imageView2);
        }
        bVar.a.setAdapter(new FridagePictureViewAdapter(arrayList));
        bVar.b.setViewPager(bVar.a);
    }

    public int getItemCount() {
        return this.e ? this.b.size() + 1 : this.b.size();
    }

    public void a(boolean z) {
        this.e = z;
    }
}
