package com.jd.fridge.widget.zxing.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.jd.fridge.util.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class b {
    private final Context a;
    private Point b;
    private Point c;

    public b(Context context) {
        this.a = context;
    }

    public void a(Camera camera) {
        Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        this.b = a(defaultDisplay);
        r.c("CameraConfiguration", "Screen resolution: " + this.b);
        Point point2 = new Point();
        point2.x = this.b.x;
        point2.y = this.b.y;
        if (this.b.x < this.b.y) {
            point2.x = this.b.y;
            point2.y = this.b.x;
        }
        this.c = a(parameters, point2);
        r.c("CameraConfiguration", "Camera resolution x: " + this.c.x);
        r.c("CameraConfiguration", "Camera resolution y: " + this.c.y);
    }

    @SuppressLint({"NewApi"})
    private Point a(Display display) {
        Point point = new Point();
        try {
            display.getSize(point);
        } catch (NoSuchMethodError e) {
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        return point;
    }

    public void a(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        if (parameters == null) {
            r.d("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        r.c("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            r.d("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        parameters.setPreviewSize(this.c.x, this.c.y);
        camera.setParameters(parameters);
        Size previewSize = camera.getParameters().getPreviewSize();
        if (!(previewSize == null || (this.c.x == previewSize.width && this.c.y == previewSize.height))) {
            r.d("CameraConfiguration", "Camera said it supported preview size " + this.c.x + 'x' + this.c.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.c.x = previewSize.width;
            this.c.y = previewSize.height;
        }
        camera.setDisplayOrientation(90);
    }

    public Point a() {
        return this.c;
    }

    boolean b(Camera camera) {
        if (camera == null || camera.getParameters() == null) {
            return false;
        }
        String flashMode = camera.getParameters().getFlashMode();
        if (flashMode == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    void b(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        a(parameters, z, false);
        camera.setParameters(parameters);
    }

    private void a(Parameters parameters, boolean z, boolean z2) {
        String a;
        if (z) {
            a = a(parameters.getSupportedFlashModes(), "torch", "on");
        } else {
            a = a(parameters.getSupportedFlashModes(), "off");
        }
        if (a != null) {
            parameters.setFlashMode(a);
        }
    }

    private static String a(Collection<String> collection, String... strArr) {
        r.c("CameraConfiguration", "Supported values: " + collection);
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    break;
                }
            }
        }
        String str2 = null;
        r.c("CameraConfiguration", "Settable value: " + str2);
        return str2;
    }

    private Point a(Parameters parameters, Point point) {
        Collection supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            r.d("CameraConfiguration", "Device returned no supported preview sizes; using default");
            Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        List<Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Size>(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((Size) obj, (Size) obj2);
            }

            public int a(Size size, Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                if (i2 > i) {
                    return 1;
                }
                return 0;
            }
        });
        if (Log.isLoggable("CameraConfiguration", 4)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Size size : arrayList) {
                Size size2;
                stringBuilder.append(size2.width).append('x').append(size2.height).append(' ');
            }
            r.c("CameraConfiguration", "Supported preview sizes: " + stringBuilder);
        }
        double d = ((double) point.x) / ((double) point.y);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            size2 = (Size) it.next();
            int i = size2.width;
            int i2 = size2.height;
            if (i * i2 < 153600) {
                it.remove();
            } else {
                int i3;
                int i4;
                Object obj = i < i2 ? 1 : null;
                if (obj != null) {
                    i3 = i2;
                } else {
                    i3 = i;
                }
                if (obj != null) {
                    i4 = i;
                } else {
                    i4 = i2;
                }
                if (Math.abs((((double) i3) / ((double) i4)) - d) > 0.15d) {
                    it.remove();
                } else if (i3 == point.x && i4 == point.y) {
                    Point point2 = new Point(i, i2);
                    r.c("CameraConfiguration", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
            }
        }
        if (arrayList.isEmpty()) {
            previewSize = parameters.getPreviewSize();
            point2 = new Point(previewSize.width, previewSize.height);
            r.c("CameraConfiguration", "No suitable preview sizes, using default: " + point2);
            return point2;
        }
        size2 = (Size) arrayList.get(0);
        Point point3 = new Point(size2.width, size2.height);
        r.c("CameraConfiguration", "Using largest suitable preview size: " + point3);
        return point3;
    }
}
