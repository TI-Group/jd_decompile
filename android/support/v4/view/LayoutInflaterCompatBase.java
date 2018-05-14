package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* compiled from: TbsSdkJava */
class LayoutInflaterCompatBase {

    /* compiled from: TbsSdkJava */
    static class FactoryWrapper implements Factory {
        final LayoutInflaterFactory mDelegateFactory;

        FactoryWrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    LayoutInflaterCompatBase() {
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory(layoutInflaterFactory != null ? new FactoryWrapper(layoutInflaterFactory) : null);
    }

    static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof FactoryWrapper) {
            return ((FactoryWrapper) factory).mDelegateFactory;
        }
        return null;
    }
}
