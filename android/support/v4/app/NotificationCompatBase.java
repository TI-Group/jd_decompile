package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.app.RemoteInputCompatBase.RemoteInput;

@RestrictTo({Scope.GROUP_ID})
/* compiled from: TbsSdkJava */
public class NotificationCompatBase {

    /* compiled from: TbsSdkJava */
    public static abstract class Action {

        /* compiled from: TbsSdkJava */
        public interface Factory {
            Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z);

            Action[] newArray(int i);
        }

        public abstract PendingIntent getActionIntent();

        public abstract boolean getAllowGeneratedReplies();

        public abstract Bundle getExtras();

        public abstract int getIcon();

        public abstract RemoteInput[] getRemoteInputs();

        public abstract CharSequence getTitle();
    }

    /* compiled from: TbsSdkJava */
    public static abstract class UnreadConversation {

        /* compiled from: TbsSdkJava */
        public interface Factory {
            UnreadConversation build(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j);
        }

        abstract long getLatestTimestamp();

        abstract String[] getMessages();

        abstract String getParticipant();

        abstract String[] getParticipants();

        abstract PendingIntent getReadPendingIntent();

        abstract RemoteInput getRemoteInput();

        abstract PendingIntent getReplyPendingIntent();
    }

    public static Notification add(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification.fullScreenIntent = pendingIntent2;
        return notification;
    }
}
