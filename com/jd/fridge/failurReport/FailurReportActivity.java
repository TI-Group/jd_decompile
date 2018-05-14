package com.jd.fridge.failurReport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FaultType;
import com.jd.fridge.bean.GetFaultTypeDataBean;
import com.jd.fridge.bean.GetLocationListBean;
import com.jd.fridge.bean.LocationInfo;
import com.jd.fridge.bean.ResponseDataBaseBean;
import com.jd.fridge.bean.SelectedLocation;
import com.jd.fridge.bean.requestBody.FaultReport;
import com.jd.fridge.bean.requestBody.Location;
import com.jd.fridge.util.f;
import com.jd.fridge.util.r;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.a.a;
import com.jd.fridge.widget.b.a.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FailurReportActivity extends BaseActivity {
    List<FaultType> a = new ArrayList();
    a b;
    List<LocationInfo> c = new ArrayList();
    @BindView(2131558562)
    TextView call_service_textview;
    @BindView(2131558725)
    ImageView close_fault_type_selector;
    @BindView(2131559051)
    ImageView close_location_selector;
    private FaultType d;
    @BindView(2131558571)
    EditText details_address_edittext;
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    @BindView(2131558566)
    TextView failur_des_count_limit_textview;
    @BindView(2131558565)
    EditText failur_description_edittext;
    @BindView(2131558563)
    View failur_type_layout;
    @BindView(2131558561)
    LinearLayout fault_root_layout;
    @BindView(2131558726)
    ListView fault_type_listview;
    @BindView(2131558574)
    View fault_type_selector;
    private boolean i = true;
    private List<LocationInfo> j = new ArrayList();
    private SelectedLocation k = new SelectedLocation();
    private String l;
    @BindView(2131559053)
    TextView location_classify_city;
    @BindView(2131559054)
    TextView location_classify_district;
    @BindView(2131559052)
    TextView location_classify_province;
    @BindView(2131559055)
    TextView location_classify_street;
    @BindView(2131559057)
    ListView location_listview;
    @BindView(2131558575)
    View location_selector;
    @BindView(2131558570)
    TextView location_textview;
    private String m;
    @BindView(2131558573)
    View mask_view;
    private String n;
    private String o;
    @BindView(2131558568)
    EditText phone_number_edittext;
    @BindView(2131559056)
    View select_classify_layout;
    @BindView(2131558564)
    TextView selected_fault_type_textview;
    @BindView(2131558572)
    TextView submit_failur_report_btn;
    @BindView(2131558567)
    EditText user_name_edittext;

    protected int a() {
        return R.layout.activity_failur_report;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_failur_report_title_text);
        this.emptyLayout.setErrorType(4);
        g();
        this.failur_description_edittext.setFocusableInTouchMode(true);
        this.failur_description_edittext.clearFocus();
        this.failur_description_edittext.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ FailurReportActivity a;

            {
                this.a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                int length = this.a.failur_description_edittext.getEditableText().length();
                this.a.failur_des_count_limit_textview.setText(this.a.getString(R.string.activity_failur_report_input_limit_text, new Object[]{length + ""}));
            }
        });
        this.user_name_edittext.setFocusableInTouchMode(true);
        this.user_name_edittext.clearFocus();
        this.phone_number_edittext.setFocusableInTouchMode(true);
        this.phone_number_edittext.clearFocus();
        this.details_address_edittext.setFocusableInTouchMode(true);
        this.details_address_edittext.clearFocus();
        a("故障申报页面");
    }

    protected void c() {
    }

    protected void d() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ((GlobalVariable) getApplication()).a(displayMetrics.density);
        ((GlobalVariable) getApplication()).a(displayMetrics.widthPixels);
        ((GlobalVariable) getApplication()).b(displayMetrics.heightPixels);
    }

    private void e() {
        this.location_selector.setVisibility(8);
        this.fault_type_selector.setVisibility(8);
        this.mask_view.setVisibility(8);
    }

    @OnClick({2131558563})
    void getFaultType() {
        if (this.a.size() == 0) {
            f();
        } else {
            this.fault_type_selector.setVisibility(0);
            this.mask_view.setVisibility(0);
        }
        this.fault_root_layout.requestFocus();
    }

    private void f() {
        if (y.d((Context) this)) {
            com.jd.fridge.a.a().a(this.e);
        } else {
            this.emptyLayout.setErrorType(11);
        }
    }

    @OnClick({2131558569})
    void showLocationSelector() {
        r.b("infos", "locationList.size==" + this.c);
        if (this.c.size() == 0 || this.location_textview.getText().toString().equals(getResources().getString(R.string.activity_failur_select_location_hint_text))) {
            a("1", "");
            this.location_classify_province.setText("");
            this.location_classify_city.setVisibility(8);
            this.location_classify_district.setVisibility(8);
            this.location_classify_street.setVisibility(8);
            this.select_classify_layout.setVisibility(0);
        }
        this.location_selector.setVisibility(0);
        this.mask_view.setVisibility(0);
        this.location_listview.setVisibility(0);
        this.fault_root_layout.requestFocus();
    }

    void a(String str, String str2) {
        if (y.d((Context) this)) {
            com.jd.fridge.a.a().a(this.e, new Location(str, str2));
            return;
        }
        this.emptyLayout.setErrorType(11);
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2008:
                this.emptyLayout.setErrorType(4);
                GetFaultTypeDataBean getFaultTypeDataBean = (GetFaultTypeDataBean) message.obj;
                if (this.a != null && this.a.size() == 0 && getFaultTypeDataBean.getStatus() == 0) {
                    this.a.addAll(getFaultTypeDataBean.getResult());
                    a(this.a);
                    this.fault_type_selector.setVisibility(0);
                    this.mask_view.setVisibility(0);
                    break;
                }
            case 2009:
                this.emptyLayout.setErrorType(10);
                break;
            case 2010:
                if (this.location_selector.getVisibility() != 8) {
                    this.emptyLayout.setErrorType(4);
                    GetLocationListBean getLocationListBean = (GetLocationListBean) message.obj;
                    if (getLocationListBean.getStatus() == 0) {
                        Collection result = getLocationListBean.getResult();
                        if (result == null || result.size() <= 0) {
                            this.k.setSelectedFinish(true);
                            if (TextUtils.isEmpty(this.k.getLocationNoDistrict())) {
                                r.b("infos", "address==" + i());
                                this.location_textview.setText(R.string.activity_failur_select_location_hint_text);
                            } else {
                                this.location_textview.setText(this.k.getLocationNoDistrict());
                            }
                            e();
                        } else {
                            LocationInfo locationInfo = (LocationInfo) result.get(0);
                            if (locationInfo.getClassifyCode().equals("1")) {
                                this.j.clear();
                                this.j.addAll(result);
                            }
                            r.b("infos", "code==" + locationInfo.getClassifyCode() + "==provice==" + this.location_classify_province.getText().toString());
                            if (locationInfo.getClassifyCode().equals("1") || !TextUtils.isEmpty(this.location_classify_province.getText().toString())) {
                                this.c.clear();
                                this.c.addAll(result);
                                this.b.notifyDataSetChanged();
                                this.location_listview.setSelection(0);
                                this.location_listview.setVisibility(0);
                            }
                            r.b("infos", "========clear11111111111================");
                        }
                    }
                    this.i = true;
                    break;
                }
                r.b("infos", "location_selector===gone");
                this.i = true;
                break;
                break;
            case 2011:
                this.emptyLayout.setErrorType(10);
                this.i = true;
                r.b("infos", "FAILED_GET_LOCATION_INFO_DATA");
                break;
            case 2012:
                this.emptyLayout.setErrorType(4);
                if (((ResponseDataBaseBean) message.obj).getStatus() == 0) {
                    new com.jd.fridge.widget.b.a(this).a((int) R.string.activity_failur_report_success_content).a(b.SINGLE_BTN).d(R.string.activity_failur_report_success_btn).a(new com.jd.fridge.widget.b.a.a(this) {
                        final /* synthetic */ FailurReportActivity a;

                        {
                            this.a = r1;
                        }

                        public void a() {
                            this.a.finish();
                        }

                        public void b() {
                        }
                    }).show();
                    break;
                }
                break;
            case 2013:
                this.emptyLayout.setErrorType(4);
                break;
        }
        return super.a(message);
    }

    private void a(List<FaultType> list) {
        this.fault_type_listview.setAdapter(new a<FaultType>(this, this, list, R.layout.fault_type_item_layout) {
            final /* synthetic */ FailurReportActivity a;

            public void a(com.jd.fridge.widget.a.b bVar, FaultType faultType) {
                bVar.a((int) R.id.selected_fault_type_textview, faultType.getDesc());
            }
        });
        this.fault_type_listview.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FailurReportActivity a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!y.c()) {
                    this.a.d = (FaultType) this.a.a.get(i);
                    this.a.selected_fault_type_textview.setText(this.a.d.getDesc());
                    this.a.e();
                }
            }
        });
    }

    private void g() {
        this.b = new a<LocationInfo>(this, this, this.c, R.layout.fault_type_item_layout) {
            final /* synthetic */ FailurReportActivity a;

            public void a(com.jd.fridge.widget.a.b bVar, LocationInfo locationInfo) {
                bVar.a((int) R.id.selected_fault_type_textview, locationInfo.getRegionName());
            }
        };
        this.location_listview.setAdapter(this.b);
        this.location_listview.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FailurReportActivity a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!y.c()) {
                    this.a.location_listview.setVisibility(8);
                    LocationInfo locationInfo = (LocationInfo) this.a.c.get(i);
                    int intValue = Integer.valueOf(locationInfo.getClassifyCode()).intValue();
                    this.a.a(intValue, locationInfo);
                    if (intValue < 4) {
                        intValue++;
                        this.a.i = false;
                        this.a.a(String.valueOf(intValue), locationInfo.getRegionId());
                    }
                }
            }
        });
    }

    @OnClick({2131558562})
    void callService() {
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + getString(R.string.activity_failur_report_service_tel_number))));
    }

    @OnClick({2131559052})
    void selectProvince() {
        if (this.i) {
            this.i = false;
            a(0, null);
            this.k.resetSelectedLocation(0);
            this.c.clear();
            this.c.addAll(this.j);
            this.b.notifyDataSetChanged();
            this.location_listview.setVisibility(0);
            r.b("infos", "========clear2222222================");
        }
    }

    @OnClick({2131559053})
    void selectCity() {
        if (this.i) {
            this.i = false;
            this.location_listview.setVisibility(8);
            this.location_classify_province.setVisibility(0);
            this.location_classify_city.setVisibility(8);
            this.location_classify_district.setVisibility(8);
            this.location_classify_street.setVisibility(8);
            this.select_classify_layout.setVisibility(0);
            this.k.resetSelectedLocation(2);
            this.k.resetSelectedLocation(3);
            this.k.resetSelectedLocation(4);
            if (this.k.getProvince() != null) {
                a("2", this.k.getProvince().getRegionId());
            }
        }
    }

    @OnClick({2131559054})
    void selectDistrict() {
        if (this.i) {
            this.i = false;
            this.location_listview.setVisibility(8);
            this.location_classify_province.setVisibility(0);
            this.location_classify_city.setVisibility(0);
            this.location_classify_district.setVisibility(8);
            this.location_classify_street.setVisibility(8);
            this.select_classify_layout.setVisibility(0);
            this.k.resetSelectedLocation(3);
            this.k.resetSelectedLocation(4);
            if (this.k.getCity() != null) {
                a("3", this.k.getCity().getRegionId());
            }
        }
    }

    @OnClick({2131559051})
    void OnCloseLocationSelector() {
        if (!this.k.isSelectedFinish()) {
            this.location_textview.setText(R.string.activity_failur_select_location_hint_text);
            this.k.resetSelectedLocation(0);
            this.c.clear();
            a(0, null);
            this.b.notifyDataSetChanged();
            r.b("infos", "========clear333333333================");
        }
        e();
    }

    @OnClick({2131558725})
    void OnCloseFaultTypeSelector() {
        e();
    }

    @OnClick({2131558573})
    void OnCloseSelectors() {
        if (this.fault_type_selector.getVisibility() == 0) {
            e();
        } else if (this.location_selector.getVisibility() == 0) {
            if (!this.k.isAllClassifySelected()) {
                this.location_textview.setText(R.string.activity_failur_select_location_hint_text);
                this.k.resetSelectedLocation(0);
                this.c.clear();
                a(0, null);
                this.b.notifyDataSetChanged();
                r.b("infos", "========clear44444444================");
            }
            e();
            this.i = true;
        }
    }

    private void a(int i, LocationInfo locationInfo) {
        CharSequence regionName = locationInfo == null ? "" : locationInfo.getRegionName();
        r.b("infos", "classify=" + i + "===location==" + locationInfo + "==regionName==" + regionName);
        switch (i) {
            case 1:
                this.location_classify_province.setVisibility(0);
                this.location_classify_city.setVisibility(8);
                this.location_classify_district.setVisibility(8);
                this.location_classify_street.setVisibility(8);
                this.select_classify_layout.setVisibility(0);
                this.location_classify_province.setText(regionName);
                this.k.setProvince(locationInfo);
                return;
            case 2:
                this.location_classify_province.setVisibility(0);
                this.location_classify_city.setVisibility(0);
                this.location_classify_district.setVisibility(8);
                this.location_classify_street.setVisibility(8);
                this.select_classify_layout.setVisibility(0);
                this.location_classify_city.setText(regionName);
                this.k.setCity(locationInfo);
                return;
            case 3:
                this.location_classify_province.setVisibility(0);
                this.location_classify_city.setVisibility(0);
                this.location_classify_district.setVisibility(0);
                this.location_classify_street.setVisibility(8);
                this.select_classify_layout.setVisibility(0);
                this.location_classify_district.setText(regionName);
                this.k.setDistrict(locationInfo);
                return;
            case 4:
                this.location_classify_province.setVisibility(0);
                this.location_classify_city.setVisibility(0);
                this.location_classify_district.setVisibility(0);
                this.location_classify_street.setVisibility(0);
                this.select_classify_layout.setVisibility(8);
                this.location_classify_street.setText(regionName);
                this.k.setStreet(locationInfo);
                this.k.setSelectedFinish(true);
                r.b("infos", "locaiton_content==" + this.k.getLocationContent());
                if (TextUtils.isEmpty(this.k.getLocationContent())) {
                    r.b("infos", "address==" + i());
                    this.location_textview.setText(R.string.activity_failur_select_location_hint_text);
                } else {
                    this.location_textview.setText(this.k.getLocationContent());
                }
                e();
                return;
            default:
                this.location_classify_province.setVisibility(8);
                this.location_classify_city.setVisibility(8);
                this.location_classify_district.setVisibility(8);
                this.location_classify_street.setVisibility(8);
                this.select_classify_layout.setVisibility(0);
                this.k.resetSelectedLocation(0);
                this.location_listview.setVisibility(8);
                this.i = true;
                return;
        }
    }

    @OnClick({2131558572})
    void submitFaultReport() {
        b("APP_我的_故障申报页_提交按钮", "fridgeapp_201609146|37");
        if (this.d == null) {
            a((int) R.string.activity_failur_no_fault_type_toast);
            return;
        }
        this.l = this.failur_description_edittext.getText().toString();
        this.l = this.l.trim();
        if (TextUtils.isEmpty(this.l)) {
            a((int) R.string.activity_failur_no_description_toast);
        } else if (f.a(this.l)) {
            a((int) R.string.message_contains_emoji_toast);
        } else {
            this.m = this.user_name_edittext.getText().toString();
            this.m = this.m.trim();
            if (TextUtils.isEmpty(this.m)) {
                a((int) R.string.activity_failur_no_name_toast);
            } else if (f.a(this.m)) {
                a((int) R.string.message_contains_emoji_toast);
            } else {
                this.n = this.phone_number_edittext.getText().toString();
                this.n = this.n.trim();
                if (TextUtils.isEmpty(this.n)) {
                    a((int) R.string.activity_failur_no_phone_number_toast);
                } else if (this.n.length() < 11) {
                    a((int) R.string.activity_failur_phone_number_invalid_toast);
                } else if (this.k.isAllClassifySelected()) {
                    this.o = this.details_address_edittext.getText().toString();
                    this.o = this.o.trim();
                    if (TextUtils.isEmpty(this.o)) {
                        a((int) R.string.activity_failur_no_address_toast);
                    } else if (f.a(this.o)) {
                        a((int) R.string.message_contains_emoji_toast);
                    } else {
                        h();
                    }
                } else {
                    a((int) R.string.activity_failur_no_location_toast);
                }
            }
        }
    }

    private void h() {
        if (y.d((Context) this)) {
            this.emptyLayout.setErrorType(2);
            com.jd.fridge.a.a().a(this.e, new FaultReport(GlobalVariable.D(), this.d.getCode(), this.l, this.m, this.n, this.k.getStreet().getRegionId(), this.o, this.k.getStreet().getAreaNum()));
            return;
        }
        this.emptyLayout.setErrorType(11);
        Toast.makeText(getBaseContext(), R.string.activity_failur_report_network_error_toast, 0).show();
    }

    private void a(int i) {
        new com.jd.fridge.widget.b.a(this).a(i).a(b.SINGLE_BTN).d(R.string.activity_failur_report_toast_btn).show();
    }

    private String i() {
        if (TextUtils.isEmpty(this.location_classify_province.getText().toString()) || TextUtils.isEmpty(this.location_classify_city.getText().toString()) || TextUtils.isEmpty(this.location_classify_district.getText().toString()) || TextUtils.isEmpty(this.location_classify_street.getText().toString())) {
            return "";
        }
        return this.location_classify_province.getText().toString() + this.location_classify_city.getText().toString() + this.location_classify_district.getText().toString() + this.location_classify_street.getText().toString();
    }
}
