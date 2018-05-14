package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: TbsSdkJava */
public final class VelocityTrackerCompat {
    static final VelocityTrackerVersionImpl IMPL;

    /* compiled from: TbsSdkJava */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i);

        float getYVelocity(VelocityTracker velocityTracker, int i);
    }

    /* compiled from: TbsSdkJava */
    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
        }

        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float getYVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    /* compiled from: TbsSdkJava */
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
        }

        public float getXVelocity(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(velocityTracker, i);
        }

        public float getYVelocity(VelocityTracker velocityTracker, int i) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }

    public static float getXVelocity(VelocityTracker velocityTracker, int i) {
        return IMPL.getXVelocity(velocityTracker, i);
    }

    public static float getYVelocity(VelocityTracker velocityTracker, int i) {
        return IMPL.getYVelocity(velocityTracker, i);
    }

    private VelocityTrackerCompat() {
    }
}
