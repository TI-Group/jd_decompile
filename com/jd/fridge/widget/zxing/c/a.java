package com.jd.fridge.widget.zxing.c;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.jd.fridge.util.r;

/* compiled from: TbsSdkJava */
public class a {
    private static final String a = a.class.getName();

    public static Camera a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            r.d(a, "No cameras!");
            return null;
        }
        int i2 = i >= 0 ? 1 : 0;
        if (i2 == 0) {
            i = 0;
            while (i < numberOfCameras) {
                CameraInfo cameraInfo = new CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            r.c(a, "Opening camera #" + i);
            return Camera.open(i);
        } else if (i2 != 0) {
            r.d(a, "Requested camera does not exist: " + i);
            return null;
        } else {
            r.c(a, "No camera facing back; returning camera #0");
            return Camera.open(0);
        }
    }

    public static Camera a() {
        return a(-1);
    }
}
