package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.widget.ListView;

@RestrictTo({Scope.GROUP_ID})
/* compiled from: TbsSdkJava */
public interface ShowableListMenu {
    void dismiss();

    ListView getListView();

    boolean isShowing();

    void show();
}
