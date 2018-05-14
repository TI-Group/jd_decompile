package uk.co.chrisjenx.calligraphy;

import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class CalligraphyConfig {
    private static final Map<Class<? extends TextView>, Integer> DEFAULT_STYLES = new HashMap();
    private static CalligraphyConfig sInstance;
    private final Set<Class<?>> hasTypefaceViews;
    private final int mAttrId;
    private final Map<Class<? extends TextView>, Integer> mClassStyleAttributeMap;
    private final boolean mCustomViewCreation;
    private final boolean mCustomViewTypefaceSupport;
    private final String mFontPath;
    private final boolean mIsFontSet;
    private final boolean mReflection;

    /* compiled from: TbsSdkJava */
    public static class Builder {
        public static final int INVALID_ATTR_ID = -1;
        private int attrId;
        private boolean customViewCreation;
        private boolean customViewTypefaceSupport;
        private String fontAssetPath;
        private boolean isFontSet;
        private Set<Class<?>> mHasTypefaceClasses;
        private Map<Class<? extends TextView>, Integer> mStyleClassMap;
        private boolean reflection;

        public Builder() {
            this.reflection = VERSION.SDK_INT >= 11;
            this.customViewCreation = true;
            this.customViewTypefaceSupport = false;
            this.attrId = R.attr.fontPath;
            this.isFontSet = false;
            this.fontAssetPath = null;
            this.mStyleClassMap = new HashMap();
            this.mHasTypefaceClasses = new HashSet();
        }

        public Builder setFontAttrId(int i) {
            if (i == -1) {
                i = -1;
            }
            this.attrId = i;
            return this;
        }

        public Builder setDefaultFontPath(String str) {
            this.isFontSet = !TextUtils.isEmpty(str);
            this.fontAssetPath = str;
            return this;
        }

        public Builder disablePrivateFactoryInjection() {
            this.reflection = false;
            return this;
        }

        public Builder disableCustomViewInflation() {
            this.customViewCreation = false;
            return this;
        }

        public Builder addCustomStyle(Class<? extends TextView> cls, int i) {
            if (!(cls == null || i == 0)) {
                this.mStyleClassMap.put(cls, Integer.valueOf(i));
            }
            return this;
        }

        public Builder addCustomViewWithSetTypeface(Class<?> cls) {
            this.customViewTypefaceSupport = true;
            this.mHasTypefaceClasses.add(cls);
            return this;
        }

        public CalligraphyConfig build() {
            this.isFontSet = !TextUtils.isEmpty(this.fontAssetPath);
            return new CalligraphyConfig(this);
        }
    }

    static {
        DEFAULT_STYLES.put(TextView.class, Integer.valueOf(16842884));
        DEFAULT_STYLES.put(Button.class, Integer.valueOf(16842824));
        DEFAULT_STYLES.put(EditText.class, Integer.valueOf(16842862));
        DEFAULT_STYLES.put(AutoCompleteTextView.class, Integer.valueOf(16842859));
        DEFAULT_STYLES.put(MultiAutoCompleteTextView.class, Integer.valueOf(16842859));
        DEFAULT_STYLES.put(CheckBox.class, Integer.valueOf(16842860));
        DEFAULT_STYLES.put(RadioButton.class, Integer.valueOf(16842878));
        DEFAULT_STYLES.put(ToggleButton.class, Integer.valueOf(16842827));
        if (CalligraphyUtils.canAddV7AppCompatViews()) {
            addAppCompatViews();
        }
    }

    private static void addAppCompatViews() {
        DEFAULT_STYLES.put(AppCompatTextView.class, Integer.valueOf(16842884));
        DEFAULT_STYLES.put(AppCompatButton.class, Integer.valueOf(16842824));
        DEFAULT_STYLES.put(AppCompatEditText.class, Integer.valueOf(16842862));
        DEFAULT_STYLES.put(AppCompatAutoCompleteTextView.class, Integer.valueOf(16842859));
        DEFAULT_STYLES.put(AppCompatMultiAutoCompleteTextView.class, Integer.valueOf(16842859));
        DEFAULT_STYLES.put(AppCompatCheckBox.class, Integer.valueOf(16842860));
        DEFAULT_STYLES.put(AppCompatRadioButton.class, Integer.valueOf(16842878));
        DEFAULT_STYLES.put(AppCompatCheckedTextView.class, Integer.valueOf(16843720));
    }

    public static void initDefault(CalligraphyConfig calligraphyConfig) {
        sInstance = calligraphyConfig;
    }

    public static CalligraphyConfig get() {
        if (sInstance == null) {
            sInstance = new CalligraphyConfig(new Builder());
        }
        return sInstance;
    }

    protected CalligraphyConfig(Builder builder) {
        this.mIsFontSet = builder.isFontSet;
        this.mFontPath = builder.fontAssetPath;
        this.mAttrId = builder.attrId;
        this.mReflection = builder.reflection;
        this.mCustomViewCreation = builder.customViewCreation;
        this.mCustomViewTypefaceSupport = builder.customViewTypefaceSupport;
        Map hashMap = new HashMap(DEFAULT_STYLES);
        hashMap.putAll(builder.mStyleClassMap);
        this.mClassStyleAttributeMap = Collections.unmodifiableMap(hashMap);
        this.hasTypefaceViews = Collections.unmodifiableSet(builder.mHasTypefaceClasses);
    }

    public String getFontPath() {
        return this.mFontPath;
    }

    boolean isFontSet() {
        return this.mIsFontSet;
    }

    public boolean isReflection() {
        return this.mReflection;
    }

    public boolean isCustomViewCreation() {
        return this.mCustomViewCreation;
    }

    public boolean isCustomViewTypefaceSupport() {
        return this.mCustomViewTypefaceSupport;
    }

    public boolean isCustomViewHasTypeface(View view) {
        return this.hasTypefaceViews.contains(view.getClass());
    }

    Map<Class<? extends TextView>, Integer> getClassStyles() {
        return this.mClassStyleAttributeMap;
    }

    public int getAttrId() {
        return this.mAttrId;
    }
}
