package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* compiled from: TbsSdkJava */
class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    static void startActivities(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }
}
