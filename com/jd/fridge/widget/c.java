package com.jd.fridge.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.VideoView;

/* compiled from: TbsSdkJava */
public class c extends WebChromeClient implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private View a;
    private ViewGroup b;
    private View c;
    private VideoEnabledWebView d;
    private boolean e;
    private FrameLayout f;
    private CustomViewCallback g;
    private a h;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(boolean z);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.e = true;
            this.f = frameLayout;
            this.g = customViewCallback;
            this.a.setVisibility(4);
            this.b.addView(this.f, new LayoutParams(-1, -1));
            this.b.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            } else if (this.d != null && this.d.getSettings().getJavaScriptEnabled() && (focusedChild instanceof SurfaceView)) {
                this.d.loadUrl((((((((("javascript:" + "var _ytrp_html5_video_last;") + "var _ytrp_html5_video = document.getElementsByTagName('video')[0];") + "if (_ytrp_html5_video != undefined && _ytrp_html5_video != _ytrp_html5_video_last) {") + "_ytrp_html5_video_last = _ytrp_html5_video;") + "function _ytrp_html5_video_ended() {") + "_VideoEnabledWebView.notifyVideoEnd();") + "}") + "_ytrp_html5_video.addEventListener('ended', _ytrp_html5_video_ended);") + "}");
            }
            if (this.h != null) {
                this.h.a(true);
            }
        }
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    public void onHideCustomView() {
        if (this.e) {
            this.b.setVisibility(4);
            this.b.removeView(this.f);
            this.a.setVisibility(0);
            if (!(this.g == null || this.g.getClass().getName().contains(".chromium."))) {
                this.g.onCustomViewHidden();
            }
            this.e = false;
            this.f = null;
            this.g = null;
            if (this.h != null) {
                this.h.a(false);
            }
        }
    }

    public View getVideoLoadingProgressView() {
        if (this.c == null) {
            return super.getVideoLoadingProgressView();
        }
        this.c.setVisibility(0);
        return this.c;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.c != null) {
            this.c.setVisibility(8);
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }
}
