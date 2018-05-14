package com.jd.fridge.messageBoard;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.bean.FridgeMessage;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;

/* compiled from: TbsSdkJava */
public class MessageBoardListAdapter extends Adapter<ViewHolder> {
    private final Context a;
    private final List<FridgeMessage> b;
    private LayoutInflater c = LayoutInflater.from(this.a);

    /* compiled from: TbsSdkJava */
    class a extends ViewHolder {
        final /* synthetic */ MessageBoardListAdapter a;

        public a(MessageBoardListAdapter messageBoardListAdapter, View view) {
            this.a = messageBoardListAdapter;
            super(view);
        }
    }

    /* compiled from: TbsSdkJava */
    class b extends ViewHolder {
        final /* synthetic */ MessageBoardListAdapter a;

        public b(MessageBoardListAdapter messageBoardListAdapter, View view) {
            this.a = messageBoardListAdapter;
            super(view);
        }
    }

    /* compiled from: TbsSdkJava */
    class c extends ViewHolder {
        final TextView a;
        final TextView b;
        final TextView c;
        final ImageView d;
        final /* synthetic */ MessageBoardListAdapter e;

        public c(MessageBoardListAdapter messageBoardListAdapter, View view) {
            this.e = messageBoardListAdapter;
            super(view);
            this.a = (TextView) view.findViewById(R.id.message_textview);
            this.b = (TextView) view.findViewById(R.id.signature_textview);
            this.c = (TextView) view.findViewById(R.id.message_date_textview);
            this.d = (ImageView) view.findViewById(R.id.message_imageview);
        }
    }

    public MessageBoardListAdapter(Context context, List<FridgeMessage> list) {
        this.a = context;
        this.b = list;
    }

    public int getItemViewType(int i) {
        if (this.b.size() == 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        return 2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new a(this, this.c.inflate(R.layout.message_board_empty_item, viewGroup, false));
        }
        if (i == 1) {
            return new b(this, this.c.inflate(R.layout.message_board_header_item, viewGroup, false));
        }
        return new c(this, this.c.inflate(R.layout.message_board_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 2:
                a(viewHolder, i - 1);
                return;
            default:
                return;
        }
    }

    public void a(ViewHolder viewHolder, int i) {
        FridgeMessage fridgeMessage = (FridgeMessage) this.b.get(i);
        c cVar = (c) viewHolder;
        cVar.itemView.setTag(fridgeMessage);
        if (fridgeMessage.getSourceType() == 0) {
            ImageLoader.getInstance().displayImage(fridgeMessage.getPicUrl(), cVar.d);
            cVar.d.setVisibility(0);
            cVar.a.setVisibility(8);
        } else {
            cVar.a.setText(fridgeMessage.getText());
            cVar.a.setVisibility(0);
            cVar.d.setVisibility(8);
        }
        cVar.c.setText(fridgeMessage.getDateTime());
    }

    public int getItemCount() {
        return this.b.size() + 1;
    }
}
