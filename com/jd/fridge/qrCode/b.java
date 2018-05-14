package com.jd.fridge.qrCode;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.CircularImageView;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class b<T extends QrCodeActivity> implements Unbinder {
    protected T a;
    private View b;
    private View c;

    public b(final T t, Finder finder, Object obj) {
        this.a = t;
        t.user_avatar = (CircularImageView) finder.findRequiredViewAsType(obj, R.id.user_avatar, "field 'user_avatar'", CircularImageView.class);
        t.user_name = (TextView) finder.findRequiredViewAsType(obj, R.id.user_name, "field 'user_name'", TextView.class);
        t.qr_imageview = (ImageView) finder.findRequiredViewAsType(obj, R.id.qr_imageview, "field 'qr_imageview'", ImageView.class);
        t.qr_shared_imageview = (ImageView) finder.findRequiredViewAsType(obj, R.id.qr_shared_imageview, "field 'qr_shared_imageview'", ImageView.class);
        View findRequiredView = finder.findRequiredView(obj, R.id.share_qr_btn, "field 'share_qr_btn' and method 'shareQr'");
        t.share_qr_btn = (ImageView) finder.castView(findRequiredView, R.id.share_qr_btn, "field 'share_qr_btn'", ImageView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.shareQr();
            }
        });
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
        t.qr_code_view = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.qr_code_view, "field 'qr_code_view'", LinearLayout.class);
        t.qr_visible_view = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.qr_visible_view, "field 'qr_visible_view'", LinearLayout.class);
        findRequiredView = finder.findRequiredView(obj, R.id.save_qr_btn, "field 'save_qr_btn' and method 'saveQrClick'");
        t.save_qr_btn = (ImageView) finder.castView(findRequiredView, R.id.save_qr_btn, "field 'save_qr_btn'", ImageView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.saveQrClick();
            }
        });
        t.lv_followme = (ListView) finder.findRequiredViewAsType(obj, R.id.lv_followme, "field 'lv_followme'", ListView.class);
    }

    public void unbind() {
        QrCodeActivity qrCodeActivity = this.a;
        if (qrCodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        qrCodeActivity.user_avatar = null;
        qrCodeActivity.user_name = null;
        qrCodeActivity.qr_imageview = null;
        qrCodeActivity.qr_shared_imageview = null;
        qrCodeActivity.share_qr_btn = null;
        qrCodeActivity.emptyLayout = null;
        qrCodeActivity.qr_code_view = null;
        qrCodeActivity.qr_visible_view = null;
        qrCodeActivity.save_qr_btn = null;
        qrCodeActivity.lv_followme = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.a = null;
    }
}
