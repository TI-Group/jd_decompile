package com.jd.fridge.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.PrivacyPolicyActivity;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.UpdateDataBean;
import com.jd.fridge.bean.UpdateDownloadData;
import com.jd.fridge.bean.requestBody.CancelRegisterAudienceByUser;
import com.jd.fridge.bean.requestBody.UpdateSendBean;
import com.jd.fridge.login.LoginActivity;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.f;
import com.jd.fridge.util.i;
import com.jd.fridge.util.r;
import com.jd.fridge.util.s;
import com.jd.fridge.util.socket.LongSocketService;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.b.a.b;
import com.jd.fridge.widget.b.c;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.kepler.jd.login.KeplerApiManager;
import java.io.File;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.model.FailResult;

/* compiled from: TbsSdkJava */
public class SettingsActivity extends BaseActivity {
    private final String a = "http://static.360buyimg.com/nsng/common/fridge/html/agreement/agreement.html";
    @BindView(2131559187)
    TextView app_version_textview;
    private UpdateDataBean b;
    private i c;
    @BindView(2131558657)
    View check_update_layout;
    @BindView(2131558660)
    View clean_cache_layout;
    private ProgressDialog d;
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    @BindView(2131558661)
    View feedback_layout;
    private boolean i = true;
    private WJLoginHelper j;
    @BindView(2131558663)
    View logout_layout;
    @BindView(2131558662)
    View privacy_policy_layout;
    @BindView(2131558659)
    CheckBox wifi_download_checkbox;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002b in list [B:5:0x0028]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r1 = 0;
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0.<init>();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r2 = "chmod ";	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r2 = " ";	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r5);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r2.exec(r0);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r0.destroy();
    L_0x002b:
        return;
    L_0x002c:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        if (r1 == 0) goto L_0x002b;
    L_0x0032:
        r1.destroy();
        goto L_0x002b;
    L_0x0036:
        r0 = move-exception;
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.destroy();
    L_0x003c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.fridge.settings.SettingsActivity.a(java.lang.String, java.lang.String):void");
    }

    protected int a() {
        return R.layout.activity_settings;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        this.j = a.b();
        this.emptyLayout.setErrorType(4);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ SettingsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.h();
            }
        });
        c(getString(R.string.activity_setting_title_text));
        this.wifi_download_checkbox.setChecked(((GlobalVariable) getApplication()).x());
        this.wifi_download_checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ SettingsActivity a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    ((GlobalVariable) this.a.getApplication()).c(true);
                } else {
                    ((GlobalVariable) this.a.getApplication()).c(false);
                }
            }
        });
        f();
        a(this.check_update_layout, (int) R.string.activity_setting_check_update_text);
        a(this.clean_cache_layout, (int) R.string.activity_setting_clean_cache_text);
        a(this.feedback_layout, (int) R.string.activity_setting_feedback_text);
        a(this.privacy_policy_layout, (int) R.string.privacy_policy);
        a("系统设置页面");
    }

    protected void c() {
        g();
        e();
    }

    protected void d() {
    }

    private void e() {
        TextView textView = (TextView) this.clean_cache_layout.findViewById(R.id.setting_item_badge_textview);
        long a = a(GlobalVariable.B().s());
        if (a != 0) {
            textView.setText(a(a));
            textView.setVisibility(0);
            return;
        }
        textView.setText("0.00M");
    }

    private void f() {
        String a = f.a(getApplicationContext());
        this.app_version_textview.setText(getString(R.string.activity_setting_version_text, new Object[]{a}));
    }

    private void a(View view, int i) {
        ((TextView) view.findViewById(R.id.setting_item_name_textview)).setText(i);
    }

    private void g() {
        this.check_update_layout.findViewById(R.id.notice_red_point_view).setVisibility(((GlobalVariable) getApplication()).y() ? 0 : 8);
    }

    @OnClick({2131558657})
    public void checkUpdate() {
        if (!y.c()) {
            h();
        }
    }

    private void h() {
        if (y.d((Context) this)) {
            r.b("infos", "Setting.versionName==" + GlobalVariable.B().l() + "===code==" + GlobalVariable.B().m() + "==bean==" + this.b);
            this.emptyLayout.setErrorType(2);
            com.jd.fridge.a.a().a(this.e, new UpdateSendBean(((GlobalVariable) getApplication()).l()));
            q();
            return;
        }
        this.emptyLayout.setErrorType(11);
    }

    @OnClick({2131558660})
    public void cleanCache() {
        if (!y.c()) {
            new com.jd.fridge.widget.b.a(this).a((int) R.string.activity_setting_clean_cache_hint).a(b.DOUBLE_BTN).b((int) R.string.activity_setting_no_btn).c((int) R.string.activity_setting_yes_btn).a(new com.jd.fridge.widget.b.a.a(this) {
                final /* synthetic */ SettingsActivity a;

                {
                    this.a = r1;
                }

                public void a() {
                    this.a.a(GlobalVariable.B().s().getPath(), false);
                    this.a.e();
                    Toast.makeText(this.a, R.string.activity_setting_clean_cache_success_toast, 0).show();
                }

                public void b() {
                }
            }).show();
        }
    }

    @OnClick({2131558661})
    public void forwardToFeedback() {
        if (!y.c()) {
            startActivity(new Intent(this, FeedbackActivity.class));
        }
    }

    @OnClick({2131558662})
    public void forwardToPrivacyPolicy() {
        if (!y.c()) {
            Intent intent = new Intent(this, PrivacyPolicyActivity.class);
            intent.putExtra("url", "http://static.360buyimg.com/nsng/common/fridge/html/agreement/agreement.html");
            intent.putExtra("title", getString(R.string.privacy_policy));
            intent.putExtra("style", 0);
            startActivity(intent);
        }
    }

    @OnClick({2131558663})
    public void logout() {
        if (!y.c()) {
            new com.jd.fridge.widget.b.a(this).a((int) R.string.activity_setting_logout_hint).a(b.DOUBLE_BTN).b((int) R.string.activity_setting_no_btn).c((int) R.string.activity_setting_yes_btn).a(new com.jd.fridge.widget.b.a.a(this) {
                final /* synthetic */ SettingsActivity a;

                {
                    this.a = r1;
                }

                public void a() {
                    if (!com.jd.fridge.util.e.b.a().e()) {
                        this.a.i();
                    } else if (y.d(this.a)) {
                        com.jd.fridge.a.a().a(this.a.e, new CancelRegisterAudienceByUser(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), JPushInterface.getRegistrationID(this.a)));
                    } else {
                        Toast.makeText(this.a, this.a.getString(R.string.error_view_network_error_toast), 0).show();
                    }
                }

                public void b() {
                }
            }).show();
        }
    }

    private void i() {
        this.j.exitLogin(new OnCommonCallback(this) {
            final /* synthetic */ SettingsActivity a;

            {
                this.a = r1;
            }

            public void onSuccess() {
                this.a.p();
            }

            public void onError(String str) {
                this.a.p();
            }

            public void onFail(FailResult failResult) {
                this.a.p();
            }
        });
    }

    private void p() {
        com.jd.fridge.util.e.b.a().h();
        GlobalVariable.a().k();
        com.jd.fridge.util.e.b.a().a(false);
        GlobalVariable.c("");
        GlobalVariable.d("");
        GlobalVariable.d(-1);
        GlobalVariable.e("");
        GlobalVariable.f(0);
        GlobalVariable.e(0);
        com.jd.fridge.util.e.b.a().c("");
        KeplerApiManager.getWebViewService().cancelAuth(getApplicationContext());
        JPushInterface.stopPush(getApplicationContext());
        LongSocketService.a((Activity) this);
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
        finish();
    }

    public long a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        j += a(listFiles[i]);
                    } else {
                        j += listFiles[i].length();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    private String a(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        long j2 = 1024;
        long j3 = 1024;
        int i = 0;
        while (j / j2 != 0) {
            i++;
            long j4 = j2;
            j2 = 1024 * j2;
            j3 = j4;
        }
        String str = "";
        String format = decimalFormat.format((double) (((float) j) / ((float) j3)));
        switch (i) {
            case 0:
                return format + "B";
            case 1:
                return format + "K";
            case 2:
                return format + "M";
            case 3:
                return format + "G";
            default:
                return str;
        }
    }

    private void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File absolutePath : listFiles) {
                            a(absolutePath.getAbsolutePath(), true);
                        }
                    }
                }
                if (!z) {
                    return;
                }
                if (!file.isDirectory()) {
                    file.delete();
                } else if (file.listFiles() != null && file.listFiles().length == 0) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void q() {
        this.d = new ProgressDialog(this);
        this.d.setMax(100);
        this.d.setCancelable(false);
        this.d.setProgressStyle(1);
        this.d.setProgressDrawable(getResources().getDrawable(R.drawable.progress_style_2));
    }

    private void a(boolean z, String str, String str2) {
        if (z) {
            new c(this).a(false).a((int) R.string.update_dialog_title).a(str2).b(str).a(c.b.SINGLE_BTN).e(R.string.update_dialog_right_download).a(new c.a(this) {
                final /* synthetic */ SettingsActivity a;

                {
                    this.a = r1;
                }

                public void a() {
                    this.a.e.removeMessages(1111);
                    this.a.e.sendEmptyMessageDelayed(1111, 2000);
                    this.a.d.show();
                }

                public void b() {
                }
            }).show();
        } else {
            new c(this).a(false).a((int) R.string.update_dialog_title).a(str2).b(str).a(c.b.DOUBLE_BTN).d(R.string.update_dialog_right_download).c(R.string.update_dialog_left_btn).a(new c.a(this) {
                final /* synthetic */ SettingsActivity a;

                {
                    this.a = r1;
                }

                public void a() {
                    this.a.e.removeMessages(1111);
                    this.a.e.sendEmptyMessageDelayed(1111, 2000);
                    this.a.d.show();
                }

                public void b() {
                    ((GlobalVariable) this.a.getApplication()).b(true);
                }
            }).show();
        }
    }

    private void b(boolean z, String str, String str2) {
        try {
            final String decode = URLDecoder.decode(str2, CommonUtil.UTF8);
            if (z) {
                new c(this).a(false).a((int) R.string.update_dialog_title).b((int) R.string.update_dialog_title_tip).b(str).a(c.b.SINGLE_BTN).e(R.string.update_dialog_right_btn).a(new c.a(this) {
                    final /* synthetic */ SettingsActivity b;

                    public void a() {
                        this.b.d(decode);
                        System.exit(0);
                    }

                    public void b() {
                    }
                }).show();
            } else {
                new c(this).a(false).a((int) R.string.update_dialog_title).b((int) R.string.update_dialog_title_tip).b(str).a(c.b.DOUBLE_BTN).d(R.string.update_dialog_right_btn).c(R.string.update_dialog_left_btn).a(new c.a(this) {
                    final /* synthetic */ SettingsActivity b;

                    public void a() {
                        this.b.d(decode);
                        System.exit(0);
                    }

                    public void b() {
                        ((GlobalVariable) this.b.getApplication()).b(true);
                    }
                }).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d(String str) {
        a("777", str);
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (VERSION.SDK_INT < 23) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.parse("file://" + file.toString()), "application/vnd.android.package-archive");
            startActivity(intent);
            return;
        }
        a(file, (Context) this);
    }

    public void a(File file, Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), b(file));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String b(File file) {
        String str = "";
        str = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase());
    }

    protected boolean a(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1111:
                r.b("infos", "updateBean.url==" + this.b.getUrl());
                ((GlobalVariable) getApplication()).b(this.b.getUrl());
                this.c = new i(this.e, this, ((GlobalVariable) getApplication()).t());
                getContentResolver().registerContentObserver(Uri.parse("content://downloads/"), true, this.c);
                break;
            case 6000:
                i();
                break;
            case 6001:
                i();
                break;
            case 8001:
                i();
                break;
            case 9000:
                this.emptyLayout.setErrorType(4);
                this.b = (UpdateDataBean) message.obj;
                r.b("infos", "Setting.versionName==" + GlobalVariable.B().l() + "===code==" + GlobalVariable.B().m() + "==bean==" + this.b);
                if (this.b != null && !TextUtils.isEmpty(this.b.getUrl())) {
                    String str = GlobalVariable.f + this.b.getUrl().substring(this.b.getUrl().lastIndexOf(47) + 1);
                    r.b("infos", "settingFileMD5==" + s.b(str) + "==md5==" + this.b.getMd5() + "==has_new==" + this.b.getHas_new());
                    if (this.b.getHas_new() != 1) {
                        ((GlobalVariable) getApplication()).d(false);
                        b(getString(R.string.already_new_version));
                        break;
                    }
                    ((GlobalVariable) getApplication()).d(true);
                    if (y.c(str) && s.b(str).equals(this.b.getMd5())) {
                        if (this.b.getIs_forced_upgrade() == 1) {
                            b(true, this.b.getDesc(), str);
                            break;
                        }
                        b(false, this.b.getDesc(), str);
                        break;
                    }
                    String string;
                    if (y.e((Context) this)) {
                        string = getString(R.string.wifi_net_tips);
                    } else {
                        string = getString(R.string.not_wifi_net_tips);
                    }
                    if (y.d(getApplicationContext())) {
                        if (!y.c(str)) {
                            this.i = true;
                            if (this.b.getIs_forced_upgrade() == 1) {
                                z = true;
                            }
                            a(z, this.b.getDesc(), string);
                            break;
                        }
                        x.a((Context) this, getString(R.string.downloading_please_wait));
                        break;
                    }
                    x.a((Context) this, (int) R.string.downloading_please_wait);
                    break;
                }
                ((GlobalVariable) getApplication()).d(false);
                b(getString(R.string.already_new_version));
                break;
                break;
            case 9001:
                this.emptyLayout.setErrorType(10);
                break;
            case 99999:
                UpdateDownloadData updateDownloadData = (UpdateDownloadData) message.obj;
                if (updateDownloadData != null && updateDownloadData.getId() == GlobalVariable.B().t()) {
                    int i = message.arg1;
                    r.b("infos", "Setting.downloading===" + updateDownloadData.isDownloading() + "==progress==" + i + "==id===" + updateDownloadData.getId());
                    if (!updateDownloadData.isDownloading()) {
                        this.d.dismiss();
                        if (this.i) {
                            d(GlobalVariable.f + this.b.getUrl().substring(this.b.getUrl().lastIndexOf(47) + 1));
                            this.i = false;
                            break;
                        }
                    }
                    this.d.setProgress(i);
                    break;
                }
                break;
        }
        return super.a(message);
    }
}
