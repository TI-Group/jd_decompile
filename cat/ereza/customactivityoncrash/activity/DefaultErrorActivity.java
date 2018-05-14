package cat.ereza.customactivityoncrash.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cat.ereza.customactivityoncrash.R;
import cat.ereza.customactivityoncrash.a;

/* compiled from: TbsSdkJava */
public final class DefaultErrorActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.customactivityoncrash_default_error_activity);
        Button button = (Button) findViewById(R.id.customactivityoncrash_error_activity_restart_button);
        final Class d = a.d(getIntent());
        final a.a e = a.e(getIntent());
        if (d != null) {
            button.setText(R.string.customactivityoncrash_error_activity_restart_app);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DefaultErrorActivity c;

                public void onClick(View view) {
                    a.a(this.c, new Intent(this.c, d), e);
                }
            });
        } else {
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DefaultErrorActivity b;

                public void onClick(View view) {
                    a.a(this.b, e);
                }
            });
        }
        button = (Button) findViewById(R.id.customactivityoncrash_error_activity_more_info_button);
        if (a.a(getIntent())) {
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DefaultErrorActivity a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    ((TextView) new Builder(this.a).setTitle(R.string.customactivityoncrash_error_activity_error_details_title).setMessage(a.a(this.a, this.a.getIntent())).setPositiveButton(R.string.customactivityoncrash_error_activity_error_details_close, null).setNeutralButton(R.string.customactivityoncrash_error_activity_error_details_copy, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 a;

                        {
                            this.a = r1;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            this.a.a.a();
                            Toast.makeText(this.a.a, R.string.customactivityoncrash_error_activity_error_details_copied, 0).show();
                        }
                    }).show().findViewById(16908299)).setTextSize(0, this.a.getResources().getDimension(R.dimen.customactivityoncrash_error_activity_error_details_text_size));
                }
            });
        } else {
            button.setVisibility(8);
        }
        int b = a.b(getIntent());
        ImageView imageView = (ImageView) findViewById(R.id.customactivityoncrash_error_activity_image);
        if (VERSION.SDK_INT >= 21) {
            imageView.setImageDrawable(getResources().getDrawable(b, getTheme()));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(b));
        }
    }

    private void a() {
        CharSequence a = a.a((Context) this, getIntent());
        if (VERSION.SDK_INT >= 11) {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getString(R.string.customactivityoncrash_error_activity_error_details_clipboard_label), a));
        } else {
            ((android.text.ClipboardManager) getSystemService("clipboard")).setText(a);
        }
    }
}
