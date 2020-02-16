/*
    Programmer : Catalina Lamboglia
    Course     : CS211D
    Assignment : #4
    This program draws circles on a canvas
    randomly every time the button is pressed.
    Canvas cleared when clear button is pressed.
 */

package com.example.polkadot;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Polkadot extends Activity
{
    BlankSlate blankSlate;
    Button drawACircle;
    Button clearScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        blankSlate = findViewById(R.id.drawScreen);

        drawACircle = (Button) findViewById(R.id.drawButton);
        drawACircle.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                blankSlate.invalidate();
            }
        });

        clearScreenButton = (Button) findViewById(R.id.clearButton);
        clearScreenButton.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (blankSlate.getCanvas() != null)
                    blankSlate.getCanvas().drawColor(Color.WHITE);
            }
        });
    }
}
