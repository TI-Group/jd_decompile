package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class VideoActivity extends Activity {
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ba.a(this).a(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            ba.a(super.getApplicationContext()).a(null, bundleExtra, null);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ba.a(this).a(this, 4);
    }

    protected void onPause() {
        super.onPause();
        ba.a(this).a(this, 3);
    }

    protected void onResume() {
        super.onResume();
        ba.a(this).a(this, 2);
    }

    protected void onStop() {
        super.onStop();
        ba.a(this).a(this, 1);
    }
}
