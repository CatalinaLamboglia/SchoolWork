/*
    Programmer : Catalina Lamboglia
    Course     : CS211D
    Assignment : #6
    Iterates and displays images in drawable
    folder

    Known issue: includes
    ic_launcher_background.xml
    and ic_launcher_foreground.xml
    in this display which are all ui elements
 */

package com.work.photoalbum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class PhotoAlbum extends Activity
{
    int currentIndex;
    ImageView iv = null;
    int length;
    ArrayList<Integer> al;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.showImage);

        al = new ArrayList<>();
        Field f[] = com.work.photoalbum.R.drawable.class.getFields();

        for (Field field: f)
        {
            try {
                Integer imgId = field.getInt(null);
                al.add(imgId);
            } catch (IllegalAccessException e) {e.printStackTrace();}
        }
        length = al.size();
        currentIndex = 0;
        iv.setImageResource(al.get(currentIndex));
    }

    public void nextImage(View v)
    {
        currentIndex++;
        if(currentIndex >= length)
            currentIndex = 0; // roll over
        iv.setImageResource(al.get(currentIndex));
    }

    public void prevImage(View v)
    {
        currentIndex--;
        if(currentIndex < 0) // roll rover
            currentIndex = length - 1;
        iv.setImageResource(al.get(currentIndex));
    }

}
