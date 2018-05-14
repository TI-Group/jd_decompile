package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: TbsSdkJava */
class TaskStackBuilderJellybean {
    TaskStackBuilderJellybean() {
    }

    public static PendingIntent getActivitiesPendingIntent(Context context, int i, Intent[] intentArr, int i2, Bundle bundle) {
        return PendingIntent.getActivities(context, i, intentArr, i2, bundle);
    }
}
