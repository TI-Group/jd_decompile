package android.support.v7.app;

import android.support.annotation.Nullable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;

/* compiled from: TbsSdkJava */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode actionMode);

    void onSupportActionModeStarted(ActionMode actionMode);

    @Nullable
    ActionMode onWindowStartingSupportActionMode(Callback callback);
}
