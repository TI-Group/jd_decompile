package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: TbsSdkJava */
class ContextCompatJellybean {
    ContextCompatJellybean() {
    }

    public static void startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
