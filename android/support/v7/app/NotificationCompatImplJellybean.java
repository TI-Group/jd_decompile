package android.support.v7.app;

import android.app.Notification.BigTextStyle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;

/* compiled from: TbsSdkJava */
class NotificationCompatImplJellybean {
    NotificationCompatImplJellybean() {
    }

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence) {
        new BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).bigText(charSequence);
    }
}
