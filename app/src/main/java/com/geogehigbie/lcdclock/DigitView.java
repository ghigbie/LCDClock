package com.geogehigbie.lcdclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;




/**
 * Created by geogehigbie on 9/12/16.
 */

public class DigitView extends View {


    private int value;

    public int LCDColor = ContextCompat.getColor(getContext(), R.color.LCDBlue);
    public int LCDNegativeColor = ContextCompat.getColor(getContext(), R.color.LCDGrey);
    public int BackgroundColor = ContextCompat.getColor(getContext(), R.color.LCDBackground);

    public DigitView(Context ctx, AttributeSet attrs) {

        super(ctx, attrs);
        this.setBackgroundColor(BackgroundColor);
    }


    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(LCDColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(21);

        Paint grey = new Paint();
        grey.setColor(LCDNegativeColor);
        grey.setStyle(Paint.Style.STROKE);
        grey.setStrokeWidth(21);

        Rect rect = canvas.getClipBounds();

        float canvasWidth = rect.width();
        float canvasHeight = rect.height();
        float xBegin = 21;
        float xEnd = canvasWidth - 21;
        float yTop = 21;
        float yEnd = canvasHeight - 21;
        float midEnd = (canvasHeight / 2) - 21;
        float midBegin = (canvasHeight / 2) - 4;


        //draws lines for 12 hour time setting
        switch (value) {

            case 1:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, grey); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, grey);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, grey);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, grey);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 2:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, paint);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, grey);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, paint); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, grey); //bottom line
                break;

            case 3:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, paint);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, grey);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 4:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, grey); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, grey);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, paint);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line

                break;

            case 5:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, paint);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, paint);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, grey); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 6:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, paint);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, paint);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, paint); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, grey); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 7:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, grey);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, grey);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, grey);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 8:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, paint);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, paint);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, paint); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 9:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, paint);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, grey);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, paint);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            case 0:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, paint); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, grey);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, paint);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, paint);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, paint); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, paint); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, paint); //bottom line
                break;

            default:
                // horizontal lines
                canvas.drawLine(xBegin, 10, xEnd - 10, 10, grey); //top line
                canvas.drawLine(xBegin, yEnd / 2, xEnd - 10, yEnd / 2, grey);  //middle line
                canvas.drawLine(xBegin, yEnd, xEnd - 10, yEnd, grey);  //bottom line

                // left lines
                canvas.drawLine(10, yTop, 10, midEnd, grey);   //top left line
                canvas.drawLine(10, midBegin, 10, yEnd - 10, grey); //bottom left line

                //right lines
                canvas.drawLine(xEnd, yTop, xEnd, midEnd, grey); //top line
                canvas.drawLine(xEnd, midBegin, xEnd, yEnd - 10, grey); //bottom line
                break;
        }


    }


    public void display(int value) {

        this.value = value;
        this.postInvalidate();

    }
}

