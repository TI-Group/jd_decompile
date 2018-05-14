package uk.co.chrisjenx.calligraphy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* compiled from: TbsSdkJava */
class CalligraphyFactory {
    private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
    private static final String ACTION_BAR_TITLE = "action_bar_title";
    private final int[] mAttributeId;

    /* compiled from: TbsSdkJava */
    private static class ToolbarLayoutListener implements OnGlobalLayoutListener {
        static String BLANK = " ";
        private final WeakReference<CalligraphyFactory> mCalligraphyFactory;
        private final WeakReference<Context> mContextRef;
        private final WeakReference<Toolbar> mToolbarReference;
        private final CharSequence originalSubTitle;

        private ToolbarLayoutListener(CalligraphyFactory calligraphyFactory, Context context, Toolbar toolbar) {
            this.mCalligraphyFactory = new WeakReference(calligraphyFactory);
            this.mContextRef = new WeakReference(context);
            this.mToolbarReference = new WeakReference(toolbar);
            this.originalSubTitle = toolbar.getSubtitle();
            toolbar.setSubtitle(BLANK);
        }

        @TargetApi(16)
        public void onGlobalLayout() {
            Toolbar toolbar = (Toolbar) this.mToolbarReference.get();
            Context context = (Context) this.mContextRef.get();
            CalligraphyFactory calligraphyFactory = (CalligraphyFactory) this.mCalligraphyFactory.get();
            if (toolbar != null) {
                if (calligraphyFactory == null || context == null) {
                    removeSelf(toolbar);
                    return;
                }
                int childCount = toolbar.getChildCount();
                if (childCount != 0) {
                    for (int i = 0; i < childCount; i++) {
                        calligraphyFactory.onViewCreated(toolbar.getChildAt(i), context, null);
                    }
                }
                removeSelf(toolbar);
                toolbar.setSubtitle(this.originalSubTitle);
            }
        }

        private void removeSelf(Toolbar toolbar) {
            if (VERSION.SDK_INT < 16) {
                toolbar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    protected static int[] getStyleForTextView(TextView textView) {
        int[] iArr = new int[]{-1, -1};
        if (isActionBarTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843512;
        } else if (isActionBarSubTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843513;
        }
        if (iArr[0] == -1) {
            iArr[0] = CalligraphyConfig.get().getClassStyles().containsKey(textView.getClass()) ? ((Integer) CalligraphyConfig.get().getClassStyles().get(textView.getClass())).intValue() : 16842804;
        }
        return iArr;
    }

    @SuppressLint({"NewApi"})
    protected static boolean isActionBarTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_TITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getTitle(), textView.getText());
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    protected static boolean isActionBarSubTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_SUBTITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getSubtitle(), textView.getText());
        }
        return false;
    }

    protected static boolean parentIsToolbarV7(View view) {
        return CalligraphyUtils.canCheckForV7Toolbar() && view.getParent() != null && (view.getParent() instanceof Toolbar);
    }

    protected static boolean matchesResourceIdName(View view, String str) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(str);
    }

    public CalligraphyFactory(int i) {
        this.mAttributeId = new int[]{i};
    }

    public View onViewCreated(View view, Context context, AttributeSet attributeSet) {
        if (!(view == null || view.getTag(R.id.calligraphy_tag_id) == Boolean.TRUE)) {
            onViewCreatedInternal(view, context, attributeSet);
            view.setTag(R.id.calligraphy_tag_id, Boolean.TRUE);
        }
        return view;
    }

    void onViewCreatedInternal(View view, Context context, AttributeSet attributeSet) {
        if (view instanceof TextView) {
            if (!TypefaceUtils.isLoaded(((TextView) view).getTypeface())) {
                String pullFontPathFromTheme;
                boolean z;
                CharSequence resolveFontPath = resolveFontPath(context, attributeSet);
                if (TextUtils.isEmpty(resolveFontPath)) {
                    int[] styleForTextView = getStyleForTextView((TextView) view);
                    if (styleForTextView[1] != -1) {
                        pullFontPathFromTheme = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], styleForTextView[1], this.mAttributeId);
                    } else {
                        pullFontPathFromTheme = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], this.mAttributeId);
                    }
                } else {
                    CharSequence charSequence = resolveFontPath;
                }
                if (matchesResourceIdName(view, ACTION_BAR_TITLE) || matchesResourceIdName(view, ACTION_BAR_SUBTITLE)) {
                    z = true;
                } else {
                    z = false;
                }
                CalligraphyUtils.applyFontToTextView(context, (TextView) view, CalligraphyConfig.get(), pullFontPathFromTheme, z);
            } else {
                return;
            }
        }
        if (CalligraphyUtils.canCheckForV7Toolbar() && (view instanceof Toolbar)) {
            Toolbar toolbar = (Toolbar) view;
            toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ToolbarLayoutListener(context, toolbar));
        }
        if (view instanceof HasTypeface) {
            Typeface defaultTypeface = getDefaultTypeface(context, resolveFontPath(context, attributeSet));
            if (defaultTypeface != null) {
                ((HasTypeface) view).setTypeface(defaultTypeface);
            }
        } else if (CalligraphyConfig.get().isCustomViewTypefaceSupport() && CalligraphyConfig.get().isCustomViewHasTypeface(view)) {
            Method method = ReflectionUtils.getMethod(view.getClass(), "setTypeface");
            Typeface defaultTypeface2 = getDefaultTypeface(context, resolveFontPath(context, attributeSet));
            if (method != null && defaultTypeface2 != null) {
                ReflectionUtils.invokeMethod(view, method, defaultTypeface2);
            }
        }
    }

    private Typeface getDefaultTypeface(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = CalligraphyConfig.get().getFontPath();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TypefaceUtils.load(context.getAssets(), str);
    }

    private String resolveFontPath(Context context, AttributeSet attributeSet) {
        String pullFontPathFromView = CalligraphyUtils.pullFontPathFromView(context, attributeSet, this.mAttributeId);
        if (TextUtils.isEmpty(pullFontPathFromView)) {
            pullFontPathFromView = CalligraphyUtils.pullFontPathFromStyle(context, attributeSet, this.mAttributeId);
        }
        if (TextUtils.isEmpty(pullFontPathFromView)) {
            return CalligraphyUtils.pullFontPathFromTextAppearance(context, attributeSet, this.mAttributeId);
        }
        return pullFontPathFromView;
    }
}
