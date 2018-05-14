package com.jd.fridge.notice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.jd.fridge.R;
import com.jd.fridge.bean.NotMoveGoodsPositionsBean;
import com.jd.fridge.util.p;
import java.text.DecimalFormat;
import java.util.List;

/* compiled from: TbsSdkJava */
public class CanvasImageView extends ImageView {
    private static final String a = CanvasImageView.class.getSimpleName();
    private List<NotMoveGoodsPositionsBean> b;
    private Bitmap c;

    public CanvasImageView(Context context) {
        super(context);
        a();
    }

    public CanvasImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public void setPositions(List<NotMoveGoodsPositionsBean> list) {
        this.b = list;
        invalidate();
    }

    private void a() {
        this.c = BitmapFactory.decodeResource(getResources(), R.drawable.ic_recognition_box);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b != null && this.b.size() > 0) {
            Paint paint = new Paint();
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            for (NotMoveGoodsPositionsBean notMoveGoodsPositionsBean : this.b) {
                String format = decimalFormat.format((double) (((float) (notMoveGoodsPositionsBean.getXb() - notMoveGoodsPositionsBean.getXt())) / ((float) this.c.getWidth())));
                String format2 = decimalFormat.format((double) (((float) (notMoveGoodsPositionsBean.getYb() - notMoveGoodsPositionsBean.getYt())) / ((float) this.c.getHeight())));
                p.a(a, notMoveGoodsPositionsBean.getXt() + "  " + notMoveGoodsPositionsBean.getYt() + "  " + notMoveGoodsPositionsBean.getXb() + "   " + notMoveGoodsPositionsBean.getYb());
                p.a(a, Float.valueOf(format) + "  " + Float.valueOf(format2));
                p.a(a, "aa " + this.c.getWidth() + "  " + this.c.getHeight());
                Matrix matrix = new Matrix();
                matrix.postScale(Float.valueOf(format).floatValue(), Float.valueOf(format2).floatValue());
                matrix.postTranslate((float) notMoveGoodsPositionsBean.getXt(), (float) notMoveGoodsPositionsBean.getYt());
                canvas.drawBitmap(this.c, matrix, paint);
            }
        }
    }
}
