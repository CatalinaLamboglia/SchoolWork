package com.example.polkadot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BlankSlate extends View
{
    Paint p = new Paint();
    int x, y, r, red, green, blue;
    static Canvas can;
    Bitmap savedCan;

    public BlankSlate(Context context, AttributeSet attr)
    {
        super(context, attr);
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (savedCan == null)
        {
            savedCan = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            can = new Canvas(savedCan);
        }
        super.onDraw(can);
        x =   rand(0, getWidth());
        y =   rand(0, getHeight());
        r =   rand(20,100);
        red = rand(0,255);
        green = rand(0,255);
        blue = rand(0,255);
        p.setColor(Color.rgb(red, green, blue));
        can.drawCircle(x,y,r,p);
        canvas.drawBitmap(savedCan, 0, 0, null);
        can = new Canvas(savedCan);
    }

    public Canvas getCanvas()
    {
        return can;
    }

    /******************************rand()*****************************/
    public int rand(int a, int b)
    {
        return((int)((b-a+1)*Math.random() + a));
    }

}