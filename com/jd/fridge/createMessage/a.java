package com.jd.fridge.createMessage;

import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class a<T extends CreateFridgeMessageActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.fridge_message_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.fridge_message_edittext, "field 'fridge_message_edittext'", EditText.class);
        t.input_limit_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.input_limit_textview, "field 'input_limit_textview'", TextView.class);
    }

    public void unbind() {
        CreateFridgeMessageActivity createFridgeMessageActivity = this.a;
        if (createFridgeMessageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        createFridgeMessageActivity.fridge_message_edittext = null;
        createFridgeMessageActivity.input_limit_textview = null;
        this.a = null;
    }
}
