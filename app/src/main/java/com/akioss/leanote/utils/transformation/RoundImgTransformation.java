package com.akioss.leanote.utils.transformation;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.squareup.picasso.Transformation;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/1/14.
 * Package: com.ebuymi.app.util
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class RoundImgTransformation implements Transformation {

    private float radius = 0f;

    public RoundImgTransformation(){
        this(4);
    }

    public RoundImgTransformation(int dp) {
        this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        if (source == null) return null;
        Bitmap result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        if (result != source) {
            source.recycle();
        }
        return result;
    }

    @Override
    public String key() {
        return "RoundImage";
    }
}
