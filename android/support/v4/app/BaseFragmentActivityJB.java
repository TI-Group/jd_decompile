package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.annotation.Nullable;

/* compiled from: TbsSdkJava */
abstract class BaseFragmentActivityJB extends BaseFragmentActivityHoneycomb {
    boolean mStartedActivityFromFragment;

    BaseFragmentActivityJB() {
    }

    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            BaseFragmentActivityGingerbread.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, @Nullable Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        if (!(this.mStartedIntentSenderFromFragment || i == -1)) {
            BaseFragmentActivityGingerbread.checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
