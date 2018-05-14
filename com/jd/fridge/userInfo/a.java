package com.jd.fridge.userInfo;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends ModifyNickActivity> implements Unbinder {
    protected T a;
    private View b;

    public a(final T t, Finder finder, Object obj) {
        this.a = t;
        t.user_nickname_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.user_nickname_edittext, "field 'user_nickname_edittext'", EditText.class);
        View findRequiredView = finder.findRequiredView(obj, R.id.clear_text_image_btn, "field 'clear_text_image_btn' and method 'clearEditText'");
        t.clear_text_image_btn = (ImageView) finder.castView(findRequiredView, R.id.clear_text_image_btn, "field 'clear_text_image_btn'", ImageView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.clearEditText();
            }
        });
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        ModifyNickActivity modifyNickActivity = this.a;
        if (modifyNickActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        modifyNickActivity.user_nickname_edittext = null;
        modifyNickActivity.clear_text_image_btn = null;
        modifyNickActivity.emptyLayout = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.a = null;
    }
}
