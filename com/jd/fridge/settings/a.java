package com.jd.fridge.settings;

import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends FeedbackActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.feedback_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.feedback_edittext, "field 'feedback_edittext'", EditText.class);
        t.feedback_count_limit_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.feedback_count_limit_textview, "field 'feedback_count_limit_textview'", TextView.class);
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        FeedbackActivity feedbackActivity = this.a;
        if (feedbackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        feedbackActivity.feedback_edittext = null;
        feedbackActivity.feedback_count_limit_textview = null;
        feedbackActivity.emptyLayout = null;
        this.a = null;
    }
}
