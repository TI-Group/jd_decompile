package com.jd.fridge.failurReport;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends FailurReportActivity> implements Unbinder {
    protected T a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;

    public a(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.fault_type_layout, "field 'failur_type_layout' and method 'getFaultType'");
        t.failur_type_layout = findRequiredView;
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.getFaultType();
            }
        });
        t.selected_fault_type_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.selected_fault_type_textview, "field 'selected_fault_type_textview'", TextView.class);
        t.fault_type_selector = finder.findRequiredView(obj, R.id.fault_type_selector, "field 'fault_type_selector'");
        View findRequiredView2 = finder.findRequiredView(obj, R.id.close_fault_type_selector, "field 'close_fault_type_selector' and method 'OnCloseFaultTypeSelector'");
        t.close_fault_type_selector = (ImageView) finder.castView(findRequiredView2, R.id.close_fault_type_selector, "field 'close_fault_type_selector'", ImageView.class);
        this.c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.OnCloseFaultTypeSelector();
            }
        });
        t.fault_type_listview = (ListView) finder.findRequiredViewAsType(obj, R.id.fault_type_listview, "field 'fault_type_listview'", ListView.class);
        t.location_selector = finder.findRequiredView(obj, R.id.location_selector, "field 'location_selector'");
        t.location_listview = (ListView) finder.findRequiredViewAsType(obj, R.id.location_listview, "field 'location_listview'", ListView.class);
        t.failur_des_count_limit_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.failur_des_count_limit_textview, "field 'failur_des_count_limit_textview'", TextView.class);
        t.failur_description_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.failur_description_edittext, "field 'failur_description_edittext'", EditText.class);
        t.user_name_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.user_name_edittext, "field 'user_name_edittext'", EditText.class);
        t.phone_number_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.phone_number_edittext, "field 'phone_number_edittext'", EditText.class);
        t.details_address_edittext = (EditText) finder.findRequiredViewAsType(obj, R.id.details_address_edittext, "field 'details_address_edittext'", EditText.class);
        findRequiredView2 = finder.findRequiredView(obj, R.id.submit_failur_report_btn, "field 'submit_failur_report_btn' and method 'submitFaultReport'");
        t.submit_failur_report_btn = (TextView) finder.castView(findRequiredView2, R.id.submit_failur_report_btn, "field 'submit_failur_report_btn'", TextView.class);
        this.d = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.submitFaultReport();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.mask_view, "field 'mask_view' and method 'OnCloseSelectors'");
        t.mask_view = findRequiredView;
        this.e = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.OnCloseSelectors();
            }
        });
        t.location_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.location_textview, "field 'location_textview'", TextView.class);
        findRequiredView2 = finder.findRequiredView(obj, R.id.close_location_selector, "field 'close_location_selector' and method 'OnCloseLocationSelector'");
        t.close_location_selector = (ImageView) finder.castView(findRequiredView2, R.id.close_location_selector, "field 'close_location_selector'", ImageView.class);
        this.f = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.OnCloseLocationSelector();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.location_classify_province, "field 'location_classify_province' and method 'selectProvince'");
        t.location_classify_province = (TextView) finder.castView(findRequiredView2, R.id.location_classify_province, "field 'location_classify_province'", TextView.class);
        this.g = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.selectProvince();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.location_classify_city, "field 'location_classify_city' and method 'selectCity'");
        t.location_classify_city = (TextView) finder.castView(findRequiredView2, R.id.location_classify_city, "field 'location_classify_city'", TextView.class);
        this.h = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.selectCity();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.location_classify_district, "field 'location_classify_district' and method 'selectDistrict'");
        t.location_classify_district = (TextView) finder.castView(findRequiredView2, R.id.location_classify_district, "field 'location_classify_district'", TextView.class);
        this.i = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.selectDistrict();
            }
        });
        t.location_classify_street = (TextView) finder.findRequiredViewAsType(obj, R.id.location_classify_street, "field 'location_classify_street'", TextView.class);
        t.select_classify_layout = finder.findRequiredView(obj, R.id.select_classify_layout, "field 'select_classify_layout'");
        findRequiredView2 = finder.findRequiredView(obj, R.id.call_service_textview, "field 'call_service_textview' and method 'callService'");
        t.call_service_textview = (TextView) finder.castView(findRequiredView2, R.id.call_service_textview, "field 'call_service_textview'", TextView.class);
        this.j = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.callService();
            }
        });
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
        t.fault_root_layout = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.fault_root_layout, "field 'fault_root_layout'", LinearLayout.class);
        findRequiredView = finder.findRequiredView(obj, R.id.location_layout, "method 'showLocationSelector'");
        this.k = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.showLocationSelector();
            }
        });
    }

    public void unbind() {
        FailurReportActivity failurReportActivity = this.a;
        if (failurReportActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        failurReportActivity.failur_type_layout = null;
        failurReportActivity.selected_fault_type_textview = null;
        failurReportActivity.fault_type_selector = null;
        failurReportActivity.close_fault_type_selector = null;
        failurReportActivity.fault_type_listview = null;
        failurReportActivity.location_selector = null;
        failurReportActivity.location_listview = null;
        failurReportActivity.failur_des_count_limit_textview = null;
        failurReportActivity.failur_description_edittext = null;
        failurReportActivity.user_name_edittext = null;
        failurReportActivity.phone_number_edittext = null;
        failurReportActivity.details_address_edittext = null;
        failurReportActivity.submit_failur_report_btn = null;
        failurReportActivity.mask_view = null;
        failurReportActivity.location_textview = null;
        failurReportActivity.close_location_selector = null;
        failurReportActivity.location_classify_province = null;
        failurReportActivity.location_classify_city = null;
        failurReportActivity.location_classify_district = null;
        failurReportActivity.location_classify_street = null;
        failurReportActivity.select_classify_layout = null;
        failurReportActivity.call_service_textview = null;
        failurReportActivity.emptyLayout = null;
        failurReportActivity.fault_root_layout = null;
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
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.a = null;
    }
}
