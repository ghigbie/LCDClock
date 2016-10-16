package com.geogehigbie.lcdclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by geogehigbie on 9/13/16.
 */
public class Separator extends View {

    private int value;

    public int LCDColor = ContextCompat.getColor(getContext(), R.color.LCDBlue);
    public int LCDNegativeColor = ContextCompat.getColor(getContext(), R.color.LCDGrey);
    public int BackgroundColor = ContextCompat.getColor(getContext(), R.color.LCDBackground);


    public Separator(Context ctx, AttributeSet attrs) {

        super(ctx, attrs);
        this.setBackgroundColor(this.getResources().getColor(R.color.LCDBackground));

    }


    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(LCDColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(25);

        Paint grey = new Paint();
        grey.setColor(LCDNegativeColor);
        grey.setStyle(Paint.Style.STROKE);
        grey.setStrokeWidth(25);


        Rect rect = canvas.getClipBounds();

        float canvasWidth = rect.width();
        float canvasHeight = rect.height();
        float x = 0;
        float yTopBegin = 0;
        float yTopEnd = 50;
        float yBottomBegin = 90;
        float yBottomEnd = 140;

        switch(value){

            case 0:
            // vertical lines
            canvas.drawLine(x, yTopBegin, x, yTopEnd, paint); //top line
            canvas.drawLine(x, yBottomBegin, x, yBottomEnd, paint);  //middle line
            break;

            default:
            // vertical lines
            canvas.drawLine(x, yTopBegin, x, yTopEnd, grey); //top line
            canvas.drawLine(x, yBottomBegin, x, yBottomEnd, grey);  //middle line
            break;
        }

        Log.d("DigitView" , "Separator Size: ht: " + canvas.getClipBounds().height());
        Log.d("DigitView" , "Separator Size2: ht: " + canvas.getHeight());
        Log.d("DigitView" , "Separator Width" + canvas.getWidth());


    }

    public void display(int value){

        this.value = value;

        this.postInvalidate();

    }



}
