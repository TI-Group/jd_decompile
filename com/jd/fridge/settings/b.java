package com.jd.fridge.settings;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class b<T extends SettingsActivity> implements Unbinder {
    protected T a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;

    public b(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.check_update_layout, "field 'check_update_layout' and method 'checkUpdate'");
        t.check_update_layout = findRequiredView;
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.checkUpdate();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.clean_cache_layout, "field 'clean_cache_layout' and method 'cleanCache'");
        t.clean_cache_layout = findRequiredView;
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.cleanCache();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.feedback_layout, "field 'feedback_layout' and method 'forwardToFeedback'");
        t.feedback_layout = findRequiredView;
        this.d = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.forwardToFeedback();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.privacy_policy_layout, "field 'privacy_policy_layout' and method 'forwardToPrivacyPolicy'");
        t.privacy_policy_layout = findRequiredView;
        this.e = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.forwardToPrivacyPolicy();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.logout_layout, "field 'logout_layout' and method 'logout'");
        t.logout_layout = findRequiredView;
        this.f = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.logout();
            }
        });
        t.app_version_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.app_version_textview, "field 'app_version_textview'", TextView.class);
        t.wifi_download_checkbox = (CheckBox) finder.findRequiredViewAsType(obj, R.id.wifi_download_checkbox, "field 'wifi_download_checkbox'", CheckBox.class);
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        SettingsActivity settingsActivity = this.a;
        if (settingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        settingsActivity.check_update_layout = null;
        settingsActivity.clean_cache_layout = null;
        settingsActivity.feedback_layout = null;
        settingsActivity.privacy_policy_layout = null;
        settingsActivity.logout_layout = null;
        settingsActivity.app_version_textview = null;
        settingsActivity.wifi_download_checkbox = null;
        settingsActivity.emptyLayout = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.a = null;
    }
}
