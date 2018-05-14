package org.greenrobot.eventbus.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import org.greenrobot.eventbus.c;

/* compiled from: TbsSdkJava */
public class ErrorDialogManager {
    public static b<?> a;

    /* compiled from: TbsSdkJava */
    public static class SupportManagerFragment extends Fragment {
        private c a;
        private boolean b;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.a = ErrorDialogManager.a.a.a();
            this.a.a((Object) this);
            this.b = true;
        }

        public void onResume() {
            super.onResume();
            if (this.b) {
                this.b = false;
                return;
            }
            this.a = ErrorDialogManager.a.a.a();
            this.a.a((Object) this);
        }

        public void onPause() {
            this.a.b(this);
            super.onPause();
        }
    }
}
