package com.jd.fridge.userInfo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jiguang.net.HttpUtils;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FridgeUserInfo;
import com.jd.fridge.bean.ModifyAvatarDataBean;
import com.jd.fridge.bean.requestBody.Avatar;
import com.jd.fridge.util.c;
import com.jd.fridge.util.d.a;
import com.jd.fridge.util.d.b;
import com.jd.fridge.util.n;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.u;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.cropavatar.ClipImageActivity;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import jd.wjlogin_sdk.util.Config;

/* compiled from: TbsSdkJava */
public class UserInfoActivity extends BaseActivity {
    private static final String b = UserInfoActivity.class.getSimpleName();
    OnClickListener a = new OnClickListener(this) {
        final /* synthetic */ UserInfoActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.camera_select_item:
                    this.a.e();
                    return;
                case R.id.gallary_select_item:
                    this.a.f();
                    return;
                case R.id.cancel_select_item:
                    this.a.g();
                    return;
                default:
                    return;
            }
        }
    };
    private FridgeUserInfo c;
    private Gson d = new Gson();
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    private Uri i;
    private Uri j;
    private RelativeLayout k;
    private PopupWindow l;
    private final BroadcastReceiver m = new BroadcastReceiver(this) {
        final /* synthetic */ UserInfoActivity a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case -1470352658:
                    if (action.equals("ACTION_MODIFY_NICKNAME_SUCCESS")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    CharSequence stringExtra = intent.getStringExtra("nickname");
                    this.a.c.setNickname(stringExtra);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.a.user_nickname_textview.setText(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    @BindView(2131558671)
    TextView user_account_caption_textview;
    @BindView(2131558672)
    TextView user_account_textview;
    @BindView(2131558621)
    ImageView user_avatar;
    @BindView(2131558667)
    TextView user_avatar_caption_textview;
    @BindView(2131558669)
    TextView user_nickname_caption_textview;
    @BindView(2131558670)
    TextView user_nickname_textview;

    protected int a() {
        return R.layout.activity_user_info;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_user_info_title_text);
        this.emptyLayout.setErrorType(4);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ UserInfoActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b(this.a.j);
            }
        });
        this.c = (FridgeUserInfo) this.d.fromJson(getIntent().getStringExtra(Config.USERINFO_LOCALNAME), FridgeUserInfo.class);
        ImageLoader.getInstance().displayImage(this.c.getPhotoUrl(), this.user_avatar);
        this.user_nickname_textview.setText(this.c.getNickname());
        this.user_account_textview.setText(GlobalVariable.I());
        h();
    }

    protected void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MODIFY_NICKNAME_SUCCESS");
        registerReceiver(this.m, intentFilter);
    }

    protected void d() {
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.m);
    }

    private void h() {
        this.k = (RelativeLayout) getLayoutInflater().inflate(R.layout.avatar_select_popup, null);
        this.k.findViewById(R.id.camera_select_item).setOnClickListener(this.a);
        this.k.findViewById(R.id.gallary_select_item).setOnClickListener(this.a);
        this.k.findViewById(R.id.cancel_select_item).setOnClickListener(this.a);
        this.l = new PopupWindow(this.k, -1, -2);
        this.l.setFocusable(true);
        this.l.setOutsideTouchable(true);
        this.l.setTouchable(true);
        this.l.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ UserInfoActivity a;

            {
                this.a = r1;
            }

            public void onDismiss() {
                this.a.a(1.0f);
            }
        });
        this.l.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_window_bg_drawable));
    }

    public void e() {
        p();
        this.l.dismiss();
    }

    public void f() {
        q();
        this.l.dismiss();
    }

    public void g() {
        this.l.dismiss();
    }

    private void a(float f) {
        LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    private void i() {
        a(0.4f);
        this.l.showAtLocation(findViewById(R.id.user_info_layout), 81, 0, u.e(this));
    }

    @OnClick({2131558666})
    public void modifyUserAvatar() {
        i();
    }

    @OnClick({2131558668})
    public void modifyUserNick() {
        Intent intent = new Intent(this, ModifyNickActivity.class);
        intent.putExtra("UserNickname", this.c.getNickname());
        startActivity(intent);
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                this.emptyLayout.setErrorType(4);
                ModifyAvatarDataBean modifyAvatarDataBean = (ModifyAvatarDataBean) message.obj;
                if (modifyAvatarDataBean.getStatus() == 0 && modifyAvatarDataBean.getResult().isSuccess()) {
                    Toast.makeText(getBaseContext(), R.string.modify_avatar_success_note, 1).show();
                }
                String photoUrl = modifyAvatarDataBean.getResult().getPhotoUrl();
                if (!photoUrl.startsWith(CommonUtil.URL_HEADER)) {
                    photoUrl = CommonUtil.URL_HEADER + photoUrl;
                }
                ImageLoader.getInstance().displayImage(photoUrl, this.user_avatar);
                this.c.setPhotoUrl(photoUrl);
                photoUrl = this.d.toJson(this.c);
                Intent intent = new Intent("ACTION_MODIFY_AVATAR_SUCCESS");
                intent.putExtra("user_info", photoUrl);
                sendBroadcast(intent);
                break;
        }
        return super.a(message);
    }

    private void p() {
        b.a(getBaseContext(), com.jd.fridge.b.e, new a(this) {
            final /* synthetic */ UserInfoActivity a;

            {
                this.a = r1;
            }

            public void a() {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                File s = ((GlobalVariable) this.a.getApplicationContext()).s();
                if (!s.exists()) {
                    s.mkdirs();
                }
                this.a.i = Uri.fromFile(new File(s, "avatar_temp_photo.jpg"));
                if (intent.resolveActivity(this.a.getPackageManager()) != null) {
                    intent.putExtra("output", this.a.i);
                    this.a.startActivityForResult(intent, 1);
                }
            }
        });
    }

    private void q() {
        b.a(getBaseContext(), "android.permission.WRITE_EXTERNAL_STORAGE", new a(this) {
            final /* synthetic */ UserInfoActivity a;

            {
                this.a = r1;
            }

            public void a() {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                if (intent.resolveActivity(this.a.getPackageManager()) != null) {
                    this.a.startActivityForResult(intent, 2);
                }
            }
        });
    }

    private void b(Uri uri) {
        if (!y.d((Context) this)) {
            this.emptyLayout.setErrorType(11);
        } else if (this.j != null) {
            Avatar avatar = new Avatar(Base64.encodeToString(c.a(getBaseContext(), c.a(getBaseContext(), uri)), 0));
            this.emptyLayout.setErrorType(2);
            com.jd.fridge.a.a().a(this.e, avatar);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        r.b("infos", "=====resultCode=====" + i2 + "==requestCode==" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (this.i != null) {
                        d(this.i.getPath());
                        return;
                    }
                    return;
                case 2:
                    if (intent == null) {
                        x.a((Context) this, getResources().getString(R.string.no_result_image));
                        return;
                    }
                    this.i = a(intent);
                    p.a(b, "URI: " + this.i);
                    if (this.i != null) {
                        Object a = a(this.i);
                        if (TextUtils.isEmpty(a)) {
                            x.a((Context) this, getResources().getString(R.string.no_result_image));
                            return;
                        } else {
                            d(a);
                            return;
                        }
                    }
                    x.a((Context) this, getResources().getString(R.string.please_reselect_image));
                    return;
                case 3:
                    this.j = Uri.fromFile(n.a(getApplicationContext(), intent.getStringExtra("crop_image")));
                    b(this.j);
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            x.a((Context) this, getResources().getString(R.string.please_reselect_image));
        }
    }

    private void d(String str) {
        ClipImageActivity.a(this, str, 3);
    }

    public String a(Uri uri) {
        Cursor query = getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return null;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndexOrThrow("_data"));
        query.close();
        return string;
    }

    public Uri a(Intent intent) {
        Uri data = intent.getData();
        Object type = intent.getType();
        if (!(data == null || TextUtils.isEmpty(data.getScheme()) || !data.getScheme().equals("file") || TextUtils.isEmpty(type) || !type.contains("image/"))) {
            String encodedPath = data.getEncodedPath();
            if (encodedPath != null) {
                int i;
                Uri uri;
                String decode = Uri.decode(encodedPath);
                ContentResolver contentResolver = getContentResolver();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("(").append("_data").append(HttpUtils.EQUAL_SIGN).append("'" + decode + "'").append(")");
                Cursor query = contentResolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, stringBuffer.toString(), null, null);
                if (query != null) {
                    query.moveToFirst();
                    i = 0;
                    while (!query.isAfterLast()) {
                        i = query.getInt(query.getColumnIndex("_id"));
                        query.moveToNext();
                    }
                } else {
                    i = 0;
                }
                if (i == 0) {
                    uri = data;
                } else {
                    uri = Uri.parse("content://media/external/images/media/" + i);
                    if (uri == null) {
                        uri = data;
                    }
                }
                if (query == null) {
                    return uri;
                }
                query.close();
                return uri;
            }
        }
        return data;
    }
}
