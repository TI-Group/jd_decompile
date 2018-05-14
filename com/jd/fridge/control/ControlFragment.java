package com.jd.fridge.control;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.ControlCommand;
import com.jd.fridge.bean.ControlResultBean;
import com.jd.fridge.bean.FridgeStatusDataBean;
import com.jd.fridge.bean.requestBody.FridgeControlSendBean;
import com.jd.fridge.bean.requestBody.FridgeStatus;
import com.jd.fridge.util.l;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.t;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.ArcProgress;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.util.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class ControlFragment extends BaseFragment {
    private static final String g = ControlFragment.class.getSimpleName();
    private Timer A;
    private Handler B = new Handler(this) {
        final /* synthetic */ ControlFragment a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 800:
                    this.a.cold_operation_layout.setVisibility(0);
                    this.a.cold_change_layout.setVisibility(8);
                    return;
                case 801:
                    this.a.change_operation_layout.setVisibility(0);
                    this.a.change_change_layout.setVisibility(8);
                    return;
                case 802:
                    this.a.freeze_operation_layout.setVisibility(0);
                    this.a.freeze_change_layout.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    };
    @BindView(2131558826)
    RelativeLayout change_change_layout;
    @BindView(2131558822)
    ImageView change_change_temperature_switch;
    @BindView(2131558823)
    TextView change_change_temperature_switch_text;
    @BindView(2131558827)
    ImageView change_minus_btn;
    @BindView(2131558830)
    ImageView change_off_btn;
    @BindView(2131558819)
    LinearLayout change_operation_layout;
    @BindView(2131558829)
    ImageView change_plus_btn;
    @BindView(2131558813)
    TextView change_room_degree_cnt;
    @BindView(2131558828)
    SeekBar change_room_seekbar;
    @BindView(2131558816)
    TextView change_room_status;
    @BindView(2131558817)
    ImageView change_room_status_img;
    @BindView(2131558815)
    RelativeLayout change_room_status_off;
    @BindView(2131558811)
    RelativeLayout change_room_status_on;
    @BindView(2131558820)
    ImageView change_room_switch;
    @BindView(2131558821)
    TextView change_room_switch_text;
    @BindView(2131558812)
    TextView change_room_title;
    @BindView(2131558780)
    Chronometer chronometer;
    @BindView(2131558781)
    ImageView cleaning_imageview;
    @BindView(2131558784)
    TextView clear_progress_result;
    @BindView(2131558783)
    TextView clear_progress_title;
    @BindView(2131558804)
    RelativeLayout cold_change_layout;
    @BindView(2131558802)
    ImageView cold_change_temperature_switch;
    @BindView(2131558803)
    TextView cold_change_temperature_switch_text;
    @BindView(2131558800)
    ImageView cold_fast_cold_switch;
    @BindView(2131558801)
    TextView cold_fast_cold_switch_text;
    @BindView(2131558805)
    ImageView cold_minus_btn;
    @BindView(2131558808)
    ImageView cold_off_btn;
    @BindView(2131558797)
    LinearLayout cold_operation_layout;
    @BindView(2131558807)
    ImageView cold_plus_btn;
    @BindView(2131558791)
    TextView cold_room_degree_cnt;
    @BindView(2131558806)
    SeekBar cold_room_seekbar;
    @BindView(2131558794)
    TextView cold_room_status;
    @BindView(2131558795)
    ImageView cold_room_status_img;
    @BindView(2131558793)
    RelativeLayout cold_room_status_off;
    @BindView(2131558789)
    RelativeLayout cold_room_status_on;
    @BindView(2131558798)
    ImageView cold_room_switch;
    @BindView(2131558799)
    TextView cold_room_switch_text;
    @BindView(2131558790)
    TextView cold_room_title;
    @BindView(2131558761)
    ImageView control_ai_mode_img;
    @BindView(2131558762)
    TextView control_ai_mode_text;
    @BindView(2131558853)
    EmptyLayout control_empty_layout;
    @BindView(2131558759)
    ScrollView control_scroll_view;
    @BindView(2131558782)
    TextView control_start_clear_btn;
    @BindView(2131558772)
    TextView control_status_change_cnt;
    @BindView(2131558773)
    TextView control_status_change_degree;
    @BindView(2131558767)
    TextView control_status_cold_cnt;
    @BindView(2131558768)
    TextView control_status_cold_degree;
    @BindView(2131558777)
    TextView control_status_freeze_cnt;
    @BindView(2131558778)
    TextView control_status_freeze_degree;
    AnimatorSet d;
    ValueAnimator e;
    BroadcastReceiver f = new BroadcastReceiver(this) {
        final /* synthetic */ ControlFragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("get_snap_shot")) {
                String stringExtra = intent.getStringExtra("data");
                try {
                    JSONObject optJSONObject = new JSONObject(stringExtra).optJSONObject("body").optJSONObject("data");
                    if (optJSONObject.optInt("status") == 0) {
                        ControlResultBean controlResultBean = (ControlResultBean) this.a.w.fromJson(optJSONObject.optJSONObject("result").toString(), ControlResultBean.class);
                        Object digest = controlResultBean.getDigest();
                        if (!TextUtils.isEmpty(digest)) {
                            GlobalVariable.i(digest);
                        }
                        if (controlResultBean.getStreams() != null) {
                            for (ControlCommand controlCommand : controlResultBean.getStreams()) {
                                if (this.a.r.containsKey(controlCommand.getStream_id())) {
                                    this.a.r.remove(controlCommand.getStream_id());
                                }
                                this.a.r.put(controlCommand.getStream_id(), controlCommand.getCurrent_value());
                            }
                            this.a.a.sendEmptyMessage(803);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                p.a(ControlFragment.g, "广播收到数据：" + stringExtra);
            }
        }
    };
    @BindView(2131558848)
    RelativeLayout freeze_change_layout;
    @BindView(2131558846)
    ImageView freeze_change_temperature_switch;
    @BindView(2131558847)
    TextView freeze_change_temperature_switch_text;
    @BindView(2131558849)
    ImageView freeze_minus_btn;
    @BindView(2131558852)
    ImageView freeze_off_btn;
    @BindView(2131558841)
    LinearLayout freeze_operation_layout;
    @BindView(2131558851)
    ImageView freeze_plus_btn;
    @BindView(2131558844)
    ImageView freeze_room_day_cold_switch;
    @BindView(2131558845)
    TextView freeze_room_day_cold_text;
    @BindView(2131558835)
    TextView freeze_room_degree_cnt;
    @BindView(2131558850)
    SeekBar freeze_room_seekbar;
    @BindView(2131558842)
    ImageView freeze_room_six_cold_switch;
    @BindView(2131558843)
    TextView freeze_room_six_cold_text;
    @BindView(2131558838)
    TextView freeze_room_status;
    @BindView(2131558839)
    ImageView freeze_room_status_img;
    @BindView(2131558837)
    RelativeLayout freeze_room_status_off;
    @BindView(2131558833)
    RelativeLayout freeze_room_status_on;
    @BindView(2131558834)
    TextView freeze_room_title;
    @BindView(2131558779)
    ArcProgress fridge_clear_progress;
    @BindView(2131558786)
    CheckBox fridge_mode_checkbox;
    private final int h = 800;
    private final int i = 801;
    private final int j = 802;
    private final int k = 803;
    private long l = 0;
    private Typeface m;
    private com.jd.fridge.widget.b.a n;
    private com.jd.fridge.widget.b.a o;
    private boolean p = true;
    private a q = new a(this);
    private HashMap<String, String> r = new HashMap();
    private boolean s = false;
    @BindView(2131558763)
    View status_divider_line;
    private t t;
    @BindView(2131558771)
    ImageView top_change_room_status;
    @BindView(2131558766)
    ImageView top_cold_room_status;
    @BindView(2131558776)
    ImageView top_freeze_room_status;
    private boolean u = false;
    private List<ControlCommand> v;
    private Gson w;
    private boolean x = false;
    private Timer y;
    private Timer z;

    /* compiled from: TbsSdkJava */
    class a extends BroadcastReceiver {
        final /* synthetic */ ControlFragment a;

        a(ControlFragment controlFragment) {
            this.a = controlFragment;
        }

        public void onReceive(Context context, Intent intent) {
            this.a.r();
        }
    }

    /* compiled from: TbsSdkJava */
    private enum b {
        VARTEMP,
        FRETEMP,
        FRITEMP
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_control, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.w = new Gson();
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.t = new t(getActivity());
        this.v = new ArrayList();
        IntentFilter intentFilter = new IntentFilter("updateViewControl");
        this.q = new a(this);
        b().registerReceiver(this.q, intentFilter);
        s();
        this.m = l.a().a(com.jd.fridge.util.l.a.LED_REGULAR);
        this.cold_room_degree_cnt.setTypeface(this.m);
        this.change_room_degree_cnt.setTypeface(this.m);
        this.freeze_room_degree_cnt.setTypeface(this.m);
        l();
        m();
        n();
        o();
        p();
        q();
        e();
        this.fridge_clear_progress.setMax(1200);
        this.fridge_clear_progress.setProgress(1200);
        this.clear_progress_title.setText(getResources().getString(R.string.fragment_control_clear_progress_title1));
        this.clear_progress_result.setText(getResources().getString(R.string.fragment_control_clear_progress_result));
        r();
        this.u = true;
    }

    private void c() {
        if (this.d == null) {
            this.d = new AnimatorSet();
        }
        this.d.play(this.e);
        this.d.start();
    }

    private void d() {
        if (this.d != null) {
            this.d.removeAllListeners();
            this.d.end();
        }
    }

    private void e() {
        this.e = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.e.setDuration(2000);
        this.e.setRepeatCount(9999);
        this.e.setRepeatMode(1);
        this.e.setInterpolator(new LinearInterpolator());
        this.e.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.cleaning_imageview.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
    }

    private void f() {
        this.control_scroll_view.setVisibility(0);
        g();
    }

    private void g() {
        h();
        i();
        j();
        k();
    }

    private void h() {
        if (!"0".equals(this.r.get("fripower"))) {
            this.top_cold_room_status.setImageResource(R.drawable.top_guanbi);
            this.top_cold_room_status.setVisibility(0);
            this.control_status_cold_cnt.setVisibility(8);
            this.control_status_cold_degree.setVisibility(8);
        } else if ("1".equals(this.r.get("fastfrimode"))) {
            this.top_cold_room_status.setImageResource(R.drawable.top_suleng);
            this.top_cold_room_status.setVisibility(0);
            this.control_status_cold_cnt.setVisibility(8);
            this.control_status_cold_degree.setVisibility(8);
        } else if (!TextUtils.isEmpty((CharSequence) this.r.get("fritemp"))) {
            this.control_status_cold_cnt.setText((CharSequence) this.r.get("fritemp"));
            this.top_cold_room_status.setVisibility(8);
            this.control_status_cold_cnt.setVisibility(0);
            this.control_status_cold_degree.setVisibility(0);
        }
        if (!"0".equals(this.r.get("varpower"))) {
            this.top_change_room_status.setImageResource(R.drawable.top_guanbi);
            this.top_change_room_status.setVisibility(0);
            this.control_status_change_cnt.setVisibility(8);
            this.control_status_change_degree.setVisibility(8);
        } else if (!TextUtils.isEmpty((CharSequence) this.r.get("vartemp"))) {
            this.control_status_change_cnt.setText((CharSequence) this.r.get("vartemp"));
            this.top_change_room_status.setVisibility(8);
            this.control_status_change_cnt.setVisibility(0);
            this.control_status_change_degree.setVisibility(0);
        }
        if ("1".equals(this.r.get("fastfremode")) || "1".equals(this.r.get("fastfre48h"))) {
            this.top_freeze_room_status.setImageResource(R.drawable.top_sudong);
            this.top_freeze_room_status.setVisibility(0);
            this.control_status_freeze_cnt.setVisibility(8);
            this.control_status_freeze_degree.setVisibility(8);
        } else if (!TextUtils.isEmpty((CharSequence) this.r.get("fretemp"))) {
            this.control_status_freeze_cnt.setText((CharSequence) this.r.get("fretemp"));
            this.top_freeze_room_status.setVisibility(8);
            this.control_status_freeze_cnt.setVisibility(0);
            this.control_status_freeze_degree.setVisibility(0);
        }
        this.fridge_clear_progress.setMax(1200);
        if ("1".equals(this.r.get("sterilization_mode"))) {
            this.control_start_clear_btn.setEnabled(false);
            this.control_start_clear_btn.setText(getResources().getString(R.string.fragment_control_clearing));
            this.clear_progress_title.setVisibility(4);
            this.clear_progress_result.setVisibility(4);
            this.fridge_clear_progress.setVisibility(4);
            this.cleaning_imageview.setVisibility(0);
            c();
        } else {
            this.control_start_clear_btn.setEnabled(true);
            this.control_start_clear_btn.setText(getResources().getString(R.string.fragment_control_start_clear));
            this.fridge_clear_progress.setProgress(1200);
            this.clear_progress_title.setText(getResources().getString(R.string.fragment_control_clear_progress_title1));
            this.clear_progress_result.setText(getResources().getString(R.string.fragment_control_clear_progress_result));
            this.clear_progress_title.setVisibility(0);
            this.clear_progress_result.setVisibility(0);
            this.fridge_clear_progress.setVisibility(0);
            this.cleaning_imageview.setVisibility(8);
            d();
        }
        if ("1".equals(this.r.get("smartmode"))) {
            this.fridge_mode_checkbox.setChecked(true);
            this.control_ai_mode_text.setText(getResources().getString(R.string.fragment_control_smart_mode));
            return;
        }
        this.fridge_mode_checkbox.setChecked(false);
    }

    private void i() {
        if ("0".equals(this.r.get("fripower"))) {
            this.cold_room_status_on.setVisibility(8);
            this.cold_room_status_off.setVisibility(0);
            this.cold_room_degree_cnt.setTypeface(this.m);
            if (!TextUtils.isEmpty((CharSequence) this.r.get("fritemp"))) {
                this.cold_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("fritemp")));
            }
            this.cold_operation_layout.setVisibility(0);
            this.cold_change_layout.setVisibility(8);
            this.cold_room_switch.setImageResource(R.drawable.control_off_btn_selector);
            this.cold_room_switch_text.setText(getResources().getString(R.string.fragment_control_cold_room_off));
            if ("1".equals(this.r.get("fastfrimode"))) {
                this.cold_room_status_on.setVisibility(8);
                this.cold_room_status_off.setVisibility(0);
                this.cold_room_status.setText(getResources().getString(R.string.fragment_control_cold_room_fast_on));
                this.cold_room_status_img.setImageResource(R.drawable.control_fast_cold_status);
                this.cold_room_switch.setEnabled(false);
                this.cold_change_temperature_switch.setEnabled(false);
                this.cold_fast_cold_switch.setImageResource(R.drawable.control_fast_cold_off_selector);
                this.cold_fast_cold_switch.setEnabled(true);
                this.cold_fast_cold_switch_text.setText(getResources().getString(R.string.fragment_control_fast_cold_off));
            } else {
                this.cold_room_status_on.setVisibility(0);
                this.cold_room_status_off.setVisibility(8);
                this.cold_room_switch.setEnabled(true);
                this.cold_change_temperature_switch.setEnabled(true);
                this.cold_fast_cold_switch.setImageResource(R.drawable.control_fast_cold_on_selector);
                this.cold_fast_cold_switch.setEnabled(true);
                this.cold_fast_cold_switch_text.setText(getResources().getString(R.string.fragment_control_fast_cold_on));
            }
        } else {
            this.cold_room_status_on.setVisibility(8);
            this.cold_room_status_off.setVisibility(0);
            this.cold_room_status.setText(getResources().getString(R.string.fragment_control_cold_room_down));
            this.cold_room_status_img.setImageResource(R.drawable.control_off_status);
            this.cold_operation_layout.setVisibility(0);
            this.cold_change_layout.setVisibility(8);
            this.cold_room_switch.setImageResource(R.drawable.control_on_btn_selector);
            this.cold_room_switch_text.setText(getResources().getString(R.string.fragment_control_cold_room_on));
            this.cold_fast_cold_switch.setImageResource(R.drawable.control_fast_cold_on_selector);
            this.cold_fast_cold_switch.setEnabled(false);
            this.cold_fast_cold_switch_text.setText(getResources().getString(R.string.fragment_control_fast_cold_on));
            this.cold_change_temperature_switch.setEnabled(false);
        }
        this.cold_room_seekbar.setMax(6);
        this.cold_room_seekbar.setProgress(TextUtils.isEmpty((CharSequence) this.r.get("fritemp")) ? 0 : ((int) Float.parseFloat((String) this.r.get("fritemp"))) - 2);
        if (!TextUtils.isEmpty((CharSequence) this.r.get("fritemp"))) {
            int parseFloat = (int) Float.parseFloat((String) this.r.get("fritemp"));
            if (parseFloat - 2 == 0) {
                this.cold_minus_btn.setEnabled(false);
                this.cold_plus_btn.setEnabled(true);
            } else if (parseFloat - 2 == 6) {
                this.cold_minus_btn.setEnabled(true);
                this.cold_plus_btn.setEnabled(false);
            } else {
                this.cold_minus_btn.setEnabled(true);
                this.cold_plus_btn.setEnabled(true);
            }
        }
    }

    private void j() {
        if ("0".equals(this.r.get("varpower"))) {
            this.change_room_status_on.setVisibility(0);
            this.change_room_status_off.setVisibility(8);
            this.change_room_degree_cnt.setTypeface(this.m);
            if (!TextUtils.isEmpty((CharSequence) this.r.get("vartemp"))) {
                this.change_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("vartemp")));
            }
            this.change_operation_layout.setVisibility(0);
            this.change_change_layout.setVisibility(8);
            this.change_room_switch.setImageResource(R.drawable.control_off_btn_selector);
            this.change_room_switch_text.setText(getResources().getString(R.string.fragment_control_change_room_off));
            this.change_change_temperature_switch.setEnabled(true);
        } else {
            this.change_room_status_on.setVisibility(8);
            this.change_room_status_off.setVisibility(0);
            this.change_room_status.setText(getResources().getString(R.string.fragment_control_change_room_off_status));
            this.change_room_status_img.setImageResource(R.drawable.control_off_status);
            this.change_operation_layout.setVisibility(0);
            this.change_change_layout.setVisibility(8);
            this.change_room_switch.setImageResource(R.drawable.control_on_btn_selector);
            this.change_room_switch_text.setText(getResources().getString(R.string.fragment_control_change_room_on));
            this.change_change_temperature_switch.setEnabled(false);
        }
        this.change_room_seekbar.setMax(28);
        this.change_room_seekbar.setProgress(TextUtils.isEmpty((CharSequence) this.r.get("vartemp")) ? 0 : Integer.parseInt((String) this.r.get("vartemp")) + 18);
        if (!TextUtils.isEmpty((CharSequence) this.r.get("vartemp"))) {
            int parseInt = Integer.parseInt((String) this.r.get("vartemp"));
            if (parseInt + 18 == 0) {
                this.change_minus_btn.setEnabled(false);
                this.change_plus_btn.setEnabled(true);
            } else if (parseInt + 18 == 28) {
                this.change_minus_btn.setEnabled(true);
                this.change_plus_btn.setEnabled(false);
            } else {
                this.change_minus_btn.setEnabled(true);
                this.change_plus_btn.setEnabled(true);
            }
        }
    }

    private void k() {
        this.freeze_room_degree_cnt.setTypeface(this.m);
        if (!TextUtils.isEmpty((CharSequence) this.r.get("fretemp"))) {
            this.freeze_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("fretemp")));
        }
        this.freeze_operation_layout.setVisibility(0);
        this.freeze_change_layout.setVisibility(8);
        if ("1".equals(this.r.get("fastfremode"))) {
            this.freeze_room_status_on.setVisibility(8);
            this.freeze_room_status_off.setVisibility(0);
            this.freeze_room_six_cold_switch.setEnabled(true);
            this.freeze_room_six_cold_switch.setImageResource(R.drawable.control_fast_freeze_off_selector);
            this.freeze_room_six_cold_text.setText(getResources().getString(R.string.fragment_control_freeze_fast_freeze_off));
            this.freeze_room_day_cold_switch.setEnabled(false);
            this.freeze_room_day_cold_switch.setImageResource(R.drawable.control_fast_freeze_on_selector);
            this.freeze_room_day_cold_text.setText(getResources().getString(R.string.fragment_control_fast_freeze_day));
            this.freeze_change_temperature_switch.setEnabled(false);
        } else if ("1".equals(this.r.get("fastfre48h"))) {
            this.freeze_room_status_on.setVisibility(8);
            this.freeze_room_status_off.setVisibility(0);
            this.freeze_room_day_cold_switch.setEnabled(true);
            this.freeze_room_day_cold_switch.setImageResource(R.drawable.control_fast_freeze_off_selector);
            this.freeze_room_day_cold_text.setText(getResources().getString(R.string.fragment_control_freeze_fast_freeze_off));
            this.freeze_room_six_cold_switch.setEnabled(false);
            this.freeze_room_six_cold_switch.setImageResource(R.drawable.control_fast_freeze_on_selector);
            this.freeze_room_six_cold_text.setText(getResources().getString(R.string.fragment_control_fast_freeze_six));
            this.freeze_change_temperature_switch.setEnabled(false);
        } else {
            this.freeze_room_status_on.setVisibility(0);
            this.freeze_room_status_off.setVisibility(8);
            this.freeze_room_six_cold_switch.setEnabled(true);
            this.freeze_room_six_cold_switch.setImageResource(R.drawable.control_fast_freeze_on_selector);
            this.freeze_room_six_cold_text.setText(getResources().getString(R.string.fragment_control_fast_freeze_six));
            this.freeze_room_day_cold_switch.setEnabled(true);
            this.freeze_room_day_cold_switch.setImageResource(R.drawable.control_fast_freeze_on_selector);
            this.freeze_room_day_cold_text.setText(getResources().getString(R.string.fragment_control_fast_freeze_day));
            this.freeze_change_temperature_switch.setEnabled(true);
        }
        this.freeze_room_seekbar.setMax(8);
        this.freeze_room_seekbar.setProgress(TextUtils.isEmpty((CharSequence) this.r.get("fretemp")) ? 0 : ((int) Float.parseFloat((String) this.r.get("fretemp"))) + 24);
        if (!TextUtils.isEmpty((CharSequence) this.r.get("fretemp"))) {
            int parseFloat = (int) Float.parseFloat((String) this.r.get("fretemp"));
            if (parseFloat + 24 == 0) {
                this.freeze_minus_btn.setEnabled(false);
                this.freeze_plus_btn.setEnabled(true);
            } else if (parseFloat + 24 == 8) {
                this.freeze_minus_btn.setEnabled(true);
                this.freeze_plus_btn.setEnabled(false);
            } else {
                this.freeze_minus_btn.setEnabled(true);
                this.freeze_plus_btn.setEnabled(true);
            }
        }
    }

    private void l() {
        this.fridge_mode_checkbox.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && !y.c()) {
                    this.a.v.clear();
                    if (this.a.fridge_mode_checkbox.isChecked()) {
                        this.a.v.add(new ControlCommand("smartmode", "0"));
                    } else {
                        this.a.v.add(new ControlCommand("smartmode", "1"));
                        this.a.v.add(new ControlCommand("fripower", "0"));
                        this.a.v.add(new ControlCommand("fastfrimode", "0"));
                        this.a.v.add(new ControlCommand("fastfremode", "0"));
                        this.a.v.add(new ControlCommand("fastfre48h", "0"));
                    }
                    this.a.a("APP_控制_智能模式开关", "fridgeapp_201609146|9");
                    this.a.a(this.a.v);
                }
                return true;
            }
        });
        this.chronometer.setOnChronometerTickListener(new OnChronometerTickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onChronometerTick(Chronometer chronometer) {
                if (this.a.l - (SystemClock.elapsedRealtime() / 1000) > 0) {
                    this.a.control_start_clear_btn.setEnabled(false);
                    this.a.clear_progress_title.setText(this.a.getResources().getString(R.string.fragment_control_clear_progress_title2));
                    this.a.clear_progress_result.setText((((this.a.l - (SystemClock.elapsedRealtime() / 1000)) / 60) + 1) + "分钟");
                    this.a.fridge_clear_progress.setProgress(1200 - ((int) (this.a.l - (SystemClock.elapsedRealtime() / 1000))));
                    return;
                }
                chronometer.stop();
                this.a.fridge_clear_progress.setProgress(1200);
                this.a.control_start_clear_btn.setEnabled(true);
                this.a.control_start_clear_btn.setText(this.a.getResources().getString(R.string.fragment_control_start_clear));
                this.a.clear_progress_title.setText(this.a.getResources().getString(R.string.fragment_control_clear_progress_title1));
                this.a.clear_progress_result.setText(this.a.getResources().getString(R.string.fragment_control_clear_progress_result));
            }
        });
        this.control_start_clear_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_杀菌净化icon", "fridgeapp_201609146|8");
                    this.a.v.clear();
                    this.a.v.add(new ControlCommand("sterilization_mode", "1"));
                    this.a.a(this.a.v);
                }
            }
        });
    }

    private void m() {
        this.cold_room_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_关闭冷藏室icon", "fridgeapp_201609146|10");
                    if ("0".equals(this.a.r.get("fripower"))) {
                        this.a.n.show();
                        return;
                    }
                    this.a.v.clear();
                    this.a.v.add(new ControlCommand("fripower", "0"));
                    this.a.a(this.a.v);
                }
            }
        });
        this.cold_fast_cold_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_速冷icon", "fridgeapp_201609146|11");
                    if ("1".equals(this.a.r.get("fastfrimode"))) {
                        this.a.v.clear();
                        this.a.v.add(new ControlCommand("fastfrimode", "0"));
                        this.a.a(this.a.v);
                        return;
                    }
                    this.a.v.clear();
                    this.a.v.add(new ControlCommand("fastfrimode", "1"));
                    this.a.v.add(new ControlCommand("smartmode", "0"));
                    this.a.a(this.a.v);
                }
            }
        });
        this.cold_change_temperature_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_冷藏室调温icon", "fridgeapp_201609146|12");
                    this.a.cold_operation_layout.setVisibility(8);
                    this.a.cold_change_layout.setVisibility(0);
                    this.a.cold_room_seekbar.setProgress(TextUtils.isEmpty((CharSequence) this.a.r.get("fritemp")) ? 0 : ((int) Float.parseFloat((String) this.a.r.get("fritemp"))) - 2);
                    if (this.a.y != null) {
                        this.a.y.cancel();
                    }
                    this.a.y = new Timer();
                    this.a.y.schedule(new TimerTask(this) {
                        final /* synthetic */ AnonymousClass27 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.B.sendEmptyMessage(800);
                        }
                    }, 2000);
                }
            }
        });
        this.cold_room_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (!this.a.p) {
                    this.a.a("APP_控制_冷藏室调温工具条", "fridgeapp_201609146|13");
                    if (this.a.y != null) {
                        this.a.y.cancel();
                    }
                    int i2 = i + 2;
                    r.a("GP", "cold_room_cnt: " + i2);
                    r.a("GP", "progress: " + i);
                    if (i == 6) {
                        this.a.cold_plus_btn.setEnabled(false);
                    } else if (i == 0) {
                        this.a.cold_minus_btn.setEnabled(false);
                    } else {
                        this.a.cold_minus_btn.setEnabled(true);
                        this.a.cold_plus_btn.setEnabled(true);
                    }
                    this.a.a.removeMessages(5000);
                    this.a.cold_room_degree_cnt.setText(this.a.getString(R.string.fragment_control_degree_space, i2 + ""));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new ControlCommand("fritemp", i2 + ""));
                    arrayList.add(new ControlCommand("smartmode", "0"));
                    Message message = new Message();
                    message.what = 5000;
                    message.obj = arrayList;
                    message.arg1 = b.FRITEMP.ordinal();
                    this.a.a.sendMessageDelayed(message, 1500);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.cold_minus_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.cold_room_seekbar.getProgress() > 0) {
                    this.a.cold_room_seekbar.setProgress(this.a.cold_room_seekbar.getProgress() - 1);
                }
            }
        });
        this.cold_plus_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.cold_room_seekbar.getProgress() < 6) {
                    this.a.cold_room_seekbar.setProgress(this.a.cold_room_seekbar.getProgress() + 1);
                }
            }
        });
        this.cold_off_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.cold_operation_layout.setVisibility(0);
                this.a.cold_change_layout.setVisibility(8);
            }
        });
    }

    private void n() {
        this.change_room_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_关闭变温室icon", "fridgeapp_201609146|14");
                    if ("0".equals(this.a.r.get("varpower"))) {
                        this.a.o.show();
                        return;
                    }
                    this.a.v.clear();
                    this.a.v.add(new ControlCommand("varpower", "0"));
                    this.a.a(this.a.v);
                }
            }
        });
        this.change_change_temperature_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_变温室调温icon", "fridgeapp_201609146|15");
                    this.a.change_operation_layout.setVisibility(8);
                    this.a.change_change_layout.setVisibility(0);
                    this.a.change_room_seekbar.setProgress(TextUtils.isEmpty((CharSequence) this.a.r.get("vartemp")) ? 0 : ((int) Float.parseFloat((String) this.a.r.get("vartemp"))) + 18);
                    if (this.a.A != null) {
                        this.a.A.cancel();
                    }
                    this.a.A = new Timer();
                    this.a.A.schedule(new TimerTask(this) {
                        final /* synthetic */ AnonymousClass5 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.B.sendEmptyMessage(801);
                        }
                    }, 2000);
                }
            }
        });
        this.change_room_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (!this.a.p) {
                    this.a.a("APP_控制_变温室调温工具条", "fridgeapp_201609146|16");
                    if (this.a.A != null) {
                        this.a.A.cancel();
                    }
                    int i2 = i - 18;
                    r.a("GP", "change_room_cnt: " + i2);
                    r.a("GP", "progress: " + i);
                    if (i == 28) {
                        this.a.change_plus_btn.setEnabled(false);
                    } else if (i == 0) {
                        this.a.change_minus_btn.setEnabled(false);
                    } else {
                        this.a.change_minus_btn.setEnabled(true);
                        this.a.change_plus_btn.setEnabled(true);
                    }
                    this.a.a.removeMessages(5000);
                    this.a.change_room_degree_cnt.setText(this.a.getString(R.string.fragment_control_degree_space, i2 + ""));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new ControlCommand("vartemp", i2 + ""));
                    Message message = new Message();
                    message.what = 5000;
                    message.obj = arrayList;
                    message.arg1 = b.VARTEMP.ordinal();
                    this.a.a.sendMessageDelayed(message, 1500);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.change_minus_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.change_room_seekbar.getProgress() > 0) {
                    this.a.change_room_seekbar.setProgress(this.a.change_room_seekbar.getProgress() - 1);
                }
            }
        });
        this.change_plus_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.change_room_seekbar.getProgress() < 28) {
                    this.a.change_room_seekbar.setProgress(this.a.change_room_seekbar.getProgress() + 1);
                }
            }
        });
        this.change_off_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.change_operation_layout.setVisibility(0);
                this.a.change_change_layout.setVisibility(8);
            }
        });
    }

    private void o() {
        this.freeze_room_six_cold_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_速冻6小时icon", "fridgeapp_201609146|17");
                    if ("1".equals(this.a.r.get("fastfremode"))) {
                        this.a.v.clear();
                        this.a.v.add(new ControlCommand("fastfremode", "0"));
                        this.a.a(this.a.v);
                        return;
                    }
                    this.a.v.clear();
                    this.a.v.add(new ControlCommand("fastfremode", "1"));
                    this.a.v.add(new ControlCommand("smartmode", "0"));
                    this.a.a(this.a.v);
                }
            }
        });
        this.freeze_room_day_cold_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_速冻48小时icon", "fridgeapp_201609146|18");
                    if ("1".equals(this.a.r.get("fastfre48h"))) {
                        this.a.v.clear();
                        this.a.v.add(new ControlCommand("fastfre48h", "0"));
                        this.a.a(this.a.v);
                        return;
                    }
                    this.a.v.clear();
                    this.a.v.add(new ControlCommand("fastfre48h", "1"));
                    this.a.v.add(new ControlCommand("smartmode", "0"));
                    this.a.a(this.a.v);
                }
            }
        });
        this.freeze_change_temperature_switch.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_控制_速冻室调温icon", "fridgeapp_201609146|19");
                    this.a.freeze_operation_layout.setVisibility(8);
                    this.a.freeze_change_layout.setVisibility(0);
                    this.a.freeze_room_seekbar.setProgress(TextUtils.isEmpty((CharSequence) this.a.r.get("fretemp")) ? 0 : ((int) Float.parseFloat((String) this.a.r.get("fretemp"))) + 24);
                    if (this.a.z != null) {
                        this.a.z.cancel();
                    }
                    this.a.z = new Timer();
                    this.a.z.schedule(new TimerTask(this) {
                        final /* synthetic */ AnonymousClass13 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.B.sendEmptyMessage(802);
                        }
                    }, 2000);
                }
            }
        });
        this.freeze_room_seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (!this.a.p) {
                    this.a.a("APP_控制_速冻室调温工具条", "fridgeapp_201609146|20");
                    if (this.a.z != null) {
                        this.a.z.cancel();
                    }
                    int i2 = i - 24;
                    r.a("GP", "freeze_room_cnt: " + i2);
                    r.a("GP", "progress: " + i);
                    if (i == 8) {
                        this.a.freeze_plus_btn.setEnabled(false);
                    } else if (i == 0) {
                        this.a.freeze_minus_btn.setEnabled(false);
                    } else {
                        this.a.freeze_minus_btn.setEnabled(true);
                        this.a.freeze_plus_btn.setEnabled(true);
                    }
                    this.a.a.removeMessages(5000);
                    this.a.freeze_room_degree_cnt.setText(this.a.getString(R.string.fragment_control_degree_space, i2 + ""));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new ControlCommand("fretemp", i2 + ""));
                    arrayList.add(new ControlCommand("smartmode", "0"));
                    Message message = new Message();
                    message.what = 5000;
                    message.obj = arrayList;
                    message.arg1 = b.FRETEMP.ordinal();
                    this.a.a.sendMessageDelayed(message, 1500);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.freeze_minus_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.freeze_room_seekbar.getProgress() > 0) {
                    this.a.freeze_room_seekbar.setProgress(this.a.freeze_room_seekbar.getProgress() - 1);
                }
            }
        });
        this.freeze_plus_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.freeze_room_seekbar.getProgress() < 8) {
                    this.a.freeze_room_seekbar.setProgress(this.a.freeze_room_seekbar.getProgress() + 1);
                }
            }
        });
        this.freeze_off_btn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.freeze_operation_layout.setVisibility(0);
                this.a.freeze_change_layout.setVisibility(8);
            }
        });
    }

    private void p() {
        this.n = new com.jd.fridge.widget.b.a(getActivity()).a((int) R.string.fragment_control_close_cold_room_tips).a(com.jd.fridge.widget.b.a.b.DOUBLE_BTN).c((int) R.string.confirm2).b((int) R.string.cancel_exit).a(new com.jd.fridge.widget.b.a.a(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.v.clear();
                this.a.v.add(new ControlCommand("fripower", "1"));
                this.a.v.add(new ControlCommand("smartmode", "0"));
                this.a.a(this.a.v);
                this.a.n.dismiss();
            }

            public void b() {
                this.a.n.dismiss();
            }
        });
    }

    private void q() {
        this.o = new com.jd.fridge.widget.b.a(getActivity()).a((int) R.string.fragment_control_close_change_room_tips).a(com.jd.fridge.widget.b.a.b.DOUBLE_BTN).c((int) R.string.confirm2).b((int) R.string.cancel_exit).a(new com.jd.fridge.widget.b.a.a(this) {
            final /* synthetic */ ControlFragment a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.v.clear();
                this.a.v.add(new ControlCommand("varpower", "1"));
                this.a.a(this.a.v);
                this.a.o.dismiss();
            }

            public void b() {
                this.a.n.dismiss();
            }
        });
    }

    private void r() {
        if ("0".equals(GlobalVariable.C())) {
            this.a.sendEmptyMessage(6000);
        } else if (!y.d(getActivity())) {
            this.a.sendEmptyMessage(1111);
        } else if (!this.s) {
            this.s = true;
            this.control_empty_layout.setErrorType(2);
            com.jd.fridge.a.a().a(this.a, new FridgeStatus(Long.parseLong(GlobalVariable.C()), GlobalVariable.L()), null);
        }
    }

    private void a(List<ControlCommand> list) {
        if ("0".equals(GlobalVariable.C())) {
            if (y.d(getActivity())) {
                Toast.makeText(getContext(), R.string.error_view_nutrition_unavaliable, 0).show();
            } else {
                Toast.makeText(getContext(), R.string.error_view_network_error_toast, 0).show();
            }
        } else if (!y.d(getActivity())) {
            this.a.sendEmptyMessage(1111);
            Toast.makeText(getContext(), R.string.error_view_network_error_toast, 0).show();
        } else if (!this.s) {
            this.s = true;
            this.control_empty_layout.setErrorType(2);
            com.jd.fridge.a.a().a(this.a, new FridgeControlSendBean(Long.parseLong(GlobalVariable.C()), list));
        }
    }

    public boolean handleMessage(Message message) {
        Object digest;
        ControlResultBean controlResultBean;
        switch (message.what) {
            case 803:
                f();
                break;
            case 1111:
                this.control_empty_layout.setErrorType(11);
                if (TextUtils.isEmpty((CharSequence) this.r.get("fretemp"))) {
                    this.freeze_room_degree_cnt.setText("");
                } else {
                    this.freeze_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("fretemp")));
                }
                if (TextUtils.isEmpty((CharSequence) this.r.get("fritemp"))) {
                    this.cold_room_degree_cnt.setText("");
                } else {
                    this.cold_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("fritemp")));
                }
                if (TextUtils.isEmpty((CharSequence) this.r.get("vartemp"))) {
                    this.change_room_degree_cnt.setText("");
                } else {
                    this.change_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("vartemp")));
                }
                this.p = false;
                break;
            case 2000:
                this.s = false;
                this.p = true;
                this.control_empty_layout.setErrorType(4);
                FridgeStatusDataBean fridgeStatusDataBean = (FridgeStatusDataBean) this.w.fromJson(message.obj.toString(), FridgeStatusDataBean.class);
                if (fridgeStatusDataBean != null) {
                    digest = fridgeStatusDataBean.getDigest();
                    if (!TextUtils.isEmpty(digest)) {
                        GlobalVariable.i(digest);
                    }
                    if (fridgeStatusDataBean.getStreams() != null) {
                        for (ControlCommand controlCommand : fridgeStatusDataBean.getStreams()) {
                            if (this.r.containsKey(controlCommand.getStream_id())) {
                                this.r.remove(controlCommand.getStream_id());
                            }
                            this.r.put(controlCommand.getStream_id(), controlCommand.getCurrent_value());
                        }
                        f();
                    }
                }
                this.p = false;
                break;
            case 2001:
                this.s = false;
                if (this.p) {
                    this.control_empty_layout.setErrorType(4);
                    this.control_scroll_view.setVisibility(0);
                } else {
                    this.control_empty_layout.setErrorType(10);
                }
                this.p = false;
                break;
            case 4000:
                this.s = false;
                this.p = true;
                this.control_empty_layout.setErrorType(4);
                controlResultBean = (ControlResultBean) this.w.fromJson(message.obj.toString(), ControlResultBean.class);
                digest = controlResultBean.getDigest();
                if (!TextUtils.isEmpty(digest)) {
                    GlobalVariable.i(digest);
                }
                if (controlResultBean.getStreams() != null) {
                    for (ControlCommand controlCommand2 : controlResultBean.getStreams()) {
                        if (this.r.containsKey(controlCommand2.getStream_id())) {
                            this.r.remove(controlCommand2.getStream_id());
                        }
                        this.r.put(controlCommand2.getStream_id(), controlCommand2.getCurrent_value());
                    }
                    f();
                } else {
                    r();
                }
                this.p = false;
                break;
            case 4001:
            case 4002:
                this.control_empty_layout.setErrorType(4);
                this.s = false;
                controlResultBean = null;
                if (message.obj instanceof ControlResultBean) {
                    controlResultBean = (ControlResultBean) message.obj;
                }
                if (!(controlResultBean == null || message.what == 4002)) {
                    this.t.a(controlResultBean.getControl_ret());
                }
                if (message.what == 4002) {
                    this.control_empty_layout.setErrorType(4);
                    this.t.a(getString(R.string.error_view_pad_offline_error));
                } else {
                    this.t.a(message.obj.toString());
                }
                if (TextUtils.isEmpty((CharSequence) this.r.get("fretemp"))) {
                    this.freeze_room_degree_cnt.setText("");
                } else {
                    this.freeze_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("fretemp")));
                }
                if (TextUtils.isEmpty((CharSequence) this.r.get("fritemp"))) {
                    this.cold_room_degree_cnt.setText("");
                } else {
                    this.cold_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("fritemp")));
                }
                if (!TextUtils.isEmpty((CharSequence) this.r.get("vartemp"))) {
                    this.change_room_degree_cnt.setText(getString(R.string.fragment_control_degree_space, this.r.get("vartemp")));
                    break;
                }
                this.change_room_degree_cnt.setText("");
                break;
            case 5000:
                List list = (ArrayList) message.obj;
                if (list != null) {
                    b bVar = b.values()[message.arg1];
                    if (this.A != null) {
                        this.A.cancel();
                    }
                    if (this.y != null) {
                        this.y.cancel();
                    }
                    if (this.z != null) {
                        this.z.cancel();
                    }
                    switch (bVar) {
                        case FRITEMP:
                            this.cold_operation_layout.setVisibility(0);
                            this.cold_change_layout.setVisibility(8);
                            break;
                        case FRETEMP:
                            this.freeze_operation_layout.setVisibility(0);
                            this.freeze_change_layout.setVisibility(8);
                            break;
                        case VARTEMP:
                            this.change_operation_layout.setVisibility(0);
                            this.change_change_layout.setVisibility(8);
                            break;
                    }
                    a(list);
                    break;
                }
                break;
            case 6000:
                this.control_scroll_view.setVisibility(8);
                this.control_empty_layout.setErrorType(9);
                break;
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        if (this.q != null) {
            b().unregisterReceiver(this.q);
        }
        if (this.f != null) {
            b().unregisterReceiver(this.f);
        }
        super.onDestroy();
        if (this.z != null) {
            this.z.cancel();
            this.z = null;
        }
        if (this.y != null) {
            this.y.cancel();
            this.y = null;
        }
        if (this.A != null) {
            this.A.cancel();
            this.A = null;
        }
        if (this.e != null) {
            this.e.removeAllUpdateListeners();
            this.e = null;
        }
        if (this.d != null) {
            this.d.end();
            this.d = null;
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.u && z) {
            this.p = true;
            r();
            a("冰箱控制主页");
        }
    }

    private void s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("get_snap_shot");
        getActivity().registerReceiver(this.f, intentFilter);
    }
}
