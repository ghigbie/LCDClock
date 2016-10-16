package com.geogehigbie.lcdclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by geogehigbie on 9/17/16.
 */
public class ColorCircle extends View {


    private float xCoordinate;
    private float yCoordinate;
    private float size;
    private int colorChoice;

    public ColorCircle(Context ctx, AttributeSet attrs) {

        super(ctx, attrs);
        this.setBackgroundColor(this.getResources().getColor(R.color.LCDBackground));
    }

    @Override
    public void onDraw(Canvas canvas) {

        String [] colorsHex = new String[] {"#07F53E", "#FE0000", "#436EF3", "#359B5D"};
        int [] colorsArray = new int[colorsHex.length];
        String [] colorNames = new String[] {"Green", "Red", "Blue", "Dark Green"};

//        for(int i = 0; i < colorsHex.length; i++){
//            int a = Color.parseColor(colorsHex[i]);
//            colorsArray[i] = a;
//            Paint paint = new Paint();
//            paint.setColor(colorsArray[a]);
//            canvas.drawCircle();
//        }

        super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setColor(Color.GREEN);
        //    canvas.drawCircle(findViewById(R.id.circle1).getX(), findViewById(R.id.circle1).getY(), 125f, paint);

        }

    public void display(float xCoordinate, float yCoordinate, float size, int colorChoice){

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.size = size;
        this.colorChoice = colorChoice;

        this.postInvalidate();

    }
    }





