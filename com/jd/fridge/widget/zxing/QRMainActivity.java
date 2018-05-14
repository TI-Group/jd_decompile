package com.jd.fridge.widget.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.widget.zxing.activity.QRCaptureActivity;
import java.util.Hashtable;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class QRMainActivity extends BaseActivity {
    private EditText a;
    private ImageView b;
    private Button c;
    private Button d;

    protected int a() {
        return R.layout.qr_activity_main;
    }

    protected void b() {
        this.a = (EditText) findViewById(R.id.et);
        this.c = (Button) findViewById(R.id.btn1);
        this.c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QRMainActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Object trim = this.a.a.getText().toString().trim();
                try {
                    if (TextUtils.isEmpty(trim)) {
                        Toast.makeText(this.a, "请输入要生成的字符串", 0).show();
                        return;
                    }
                    this.a.b.setImageBitmap(this.a.d(trim));
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
        this.d = (Button) findViewById(R.id.btn2);
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QRMainActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.startActivity(new Intent(this.a, QRCaptureActivity.class));
            }
        });
        this.b = (ImageView) findViewById(R.id.iv);
    }

    protected void c() {
    }

    protected void d() {
    }

    public Bitmap d(String str) throws WriterException {
        Map hashtable = new Hashtable();
        hashtable.put(EncodeHintType.CHARACTER_SET, HTTP.UTF_8);
        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 480, 480, hashtable);
        int width = encode.getWidth();
        int height = encode.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                if (encode.get(i2, i)) {
                    iArr[(i * width) + i2] = -16777216;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }
}
