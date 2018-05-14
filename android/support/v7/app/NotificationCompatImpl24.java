package android.support.v7.app;

import android.app.Notification.DecoratedCustomViewStyle;
import android.app.Notification.DecoratedMediaCustomViewStyle;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;

/* compiled from: TbsSdkJava */
class NotificationCompatImpl24 {
    NotificationCompatImpl24() {
    }

    public static void addDecoratedCustomViewStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new DecoratedCustomViewStyle());
    }

    public static void addDecoratedMediaCustomViewStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        notificationBuilderWithBuilderAccessor.getBuilder().setStyle(new DecoratedMediaCustomViewStyle());
    }
}
