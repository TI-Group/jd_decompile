package com.jd.fridge.widget.zxing.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.jd.fridge.util.r;
import com.jd.fridge.widget.zxing.c.a;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public class c {
    private static final String a = c.class.getSimpleName();
    private final Context b;
    private final b c;
    private Camera d;
    private a e;
    private boolean f;
    private boolean g;
    private int h = -1;
    private final d i;

    public c(Context context) {
        this.b = context;
        this.c = new b(context);
        this.i = new d(this.c);
    }

    public synchronized void a(SurfaceHolder surfaceHolder) throws IOException {
        Camera camera = this.d;
        if (camera == null) {
            if (this.h >= 0) {
                camera = a.a(this.h);
            } else {
                camera = a.a();
            }
            if (camera == null) {
                throw new IOException();
            }
            this.d = camera;
        }
        Camera camera2 = camera;
        camera2.setPreviewDisplay(surfaceHolder);
        if (!this.f) {
            this.f = true;
            this.c.a(camera2);
        }
        Parameters parameters = camera2.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.c.a(camera2, false);
        } catch (RuntimeException e) {
            r.d(a, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            r.c(a, "Resetting to saved camera params: " + flatten);
            if (flatten != null) {
                Parameters parameters2 = camera2.getParameters();
                parameters2.unflatten(flatten);
                try {
                    camera2.setParameters(parameters2);
                    this.c.a(camera2, true);
                } catch (RuntimeException e2) {
                    r.d(a, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized boolean a() {
        return this.d != null;
    }

    public synchronized void b() {
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
    }

    public synchronized void c() {
        Camera camera = this.d;
        if (!(camera == null || this.g)) {
            camera.startPreview();
            this.g = true;
            this.e = new a(this.b, this.d);
        }
    }

    public synchronized void d() {
        if (this.e != null) {
            this.e.b();
            this.e = null;
        }
        if (this.d != null && this.g) {
            this.d.stopPreview();
            this.i.a(null, 0);
            this.g = false;
        }
    }

    public synchronized void a(boolean z) {
        if (!(z == this.c.b(this.d) || this.d == null)) {
            if (this.e != null) {
                this.e.b();
            }
            this.c.b(this.d, z);
            if (this.e != null) {
                this.e.a();
            }
        }
    }

    public synchronized void a(Handler handler, int i) {
        Camera camera = this.d;
        if (camera != null && this.g) {
            this.i.a(handler, i);
            camera.setOneShotPreviewCallback(this.i);
        }
    }

    public Point e() {
        return this.c.a();
    }

    public Size f() {
        if (this.d != null) {
            return this.d.getParameters().getPreviewSize();
        }
        return null;
    }
}
