package com.jd.fridge.widget.zxing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;

/* compiled from: TbsSdkJava */
public class QRResultActivity extends BaseActivity {
    private ImageView a;
    private TextView b;

    protected int a() {
        return R.layout.qr_activity_result;
    }

    protected void b() {
        Bundle extras = getIntent().getExtras();
        this.a = (ImageView) findViewById(R.id.result_image);
        this.b = (TextView) findViewById(R.id.result_text);
        if (extras != null) {
            Bitmap copy;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(extras.getInt("width"), extras.getInt("height"));
            layoutParams.topMargin = (int) TypedValue.applyDimension(1, 30.0f, getResources().getDisplayMetrics());
            layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
            layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
            this.a.setLayoutParams(layoutParams);
            this.b.setText(extras.getString("result"));
            byte[] byteArray = extras.getByteArray("barcode_bitmap");
            if (byteArray != null) {
                copy = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Config.RGB_565, true);
            } else {
                copy = null;
            }
            this.a.setImageBitmap(copy);
        }
    }

    protected void c() {
    }

    protected void d() {
    }
}
