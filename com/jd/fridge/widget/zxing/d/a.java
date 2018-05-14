package com.jd.fridge.widget.zxing.d;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import com.jd.fridge.R;
import com.jd.fridge.util.r;
import java.io.Closeable;

/* compiled from: TbsSdkJava */
public class a implements OnCompletionListener, OnErrorListener, Closeable {
    private static final String a = a.class.getSimpleName();
    private final Activity b;
    private MediaPlayer c = null;
    private boolean d;
    private boolean e;

    public a(Activity activity) {
        this.b = activity;
        b();
    }

    private synchronized void b() {
        this.d = a(PreferenceManager.getDefaultSharedPreferences(this.b), this.b);
        this.e = true;
        if (this.d && this.c == null) {
            this.b.setVolumeControlStream(3);
            this.c = a(this.b);
        }
    }

    public synchronized void a() {
        if (this.d && this.c != null) {
            this.c.start();
        }
        if (this.e) {
            ((Vibrator) this.b.getSystemService("vibrator")).vibrate(200);
        }
    }

    private static boolean a(SharedPreferences sharedPreferences, Context context) {
        if (((AudioManager) context.getSystemService("audio")).getRingerMode() != 2) {
            return false;
        }
        return true;
    }

    private MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        AssetFileDescriptor openRawResourceFd;
        try {
            openRawResourceFd = context.getResources().openRawResourceFd(R.raw.beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            return mediaPlayer;
        } catch (Throwable e) {
            r.a(a, e);
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }

    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.b.finish();
        } else {
            mediaPlayer.release();
            this.c = null;
            b();
        }
        return true;
    }

    public synchronized void close() {
        if (this.c != null) {
            this.c.release();
            this.c = null;
        }
    }
}
