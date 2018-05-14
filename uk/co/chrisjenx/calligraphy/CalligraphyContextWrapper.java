package uk.co.chrisjenx.calligraphy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: TbsSdkJava */
public class CalligraphyContextWrapper extends ContextWrapper {
    private final int mAttributeId;
    private CalligraphyLayoutInflater mInflater;

    public static ContextWrapper wrap(Context context) {
        return new CalligraphyContextWrapper(context);
    }

    public static View onActivityCreateView(Activity activity, View view, View view2, String str, Context context, AttributeSet attributeSet) {
        return get(activity).onActivityCreateView(view, view2, str, context, attributeSet);
    }

    static CalligraphyActivityFactory get(Activity activity) {
        if (activity.getLayoutInflater() instanceof CalligraphyLayoutInflater) {
            return (CalligraphyActivityFactory) activity.getLayoutInflater();
        }
        throw new RuntimeException("This activity does not wrap the Base Context! See CalligraphyContextWrapper.wrap(Context)");
    }

    CalligraphyContextWrapper(Context context) {
        super(context);
        this.mAttributeId = CalligraphyConfig.get().getAttrId();
    }

    @Deprecated
    public CalligraphyContextWrapper(Context context, int i) {
        super(context);
        this.mAttributeId = i;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = new CalligraphyLayoutInflater(LayoutInflater.from(getBaseContext()), this, this.mAttributeId, false);
        }
        return this.mInflater;
    }
}
