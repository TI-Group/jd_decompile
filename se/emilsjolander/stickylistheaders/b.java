package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

/* compiled from: TbsSdkJava */
class b extends WrapperView implements Checkable {
    public b(Context context) {
        super(context);
    }

    public boolean isChecked() {
        return ((Checkable) this.a).isChecked();
    }

    public void setChecked(boolean z) {
        ((Checkable) this.a).setChecked(z);
    }

    public void toggle() {
        setChecked(!isChecked());
    }
}
