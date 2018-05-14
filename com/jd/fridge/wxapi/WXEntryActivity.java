package com.jd.fridge.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.b.a.b;
import com.jd.fridge.GlobalVariable;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.apache.commons.lang.StringUtils;

/* compiled from: TbsSdkJava */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = WXAPIFactory.createWXAPI(this, GlobalVariable.i, true);
        this.a.handleIntent(getIntent(), this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        CharSequence charSequence = null;
        switch (baseResp.errCode) {
            case -4:
                charSequence = "发送被拒绝";
                break;
            case -2:
                charSequence = "发送取消";
                break;
            case 0:
                if (baseResp.getType() != 1) {
                    if (baseResp.getType() == 2) {
                        charSequence = "分享成功";
                        b.a(this, "EVENT_SHARE_WX");
                        break;
                    }
                }
                ((GlobalVariable) getApplication()).a(((Resp) baseResp).code);
                charSequence = "";
                break;
                break;
            default:
                charSequence = "";
                break;
        }
        if (StringUtils.isNotBlank(charSequence)) {
            Toast.makeText(this, charSequence, 0).show();
        }
        this.a.unregisterApp();
        finish();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
