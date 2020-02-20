/*
    Programmer : Catalina Lamboglia
    Course     : CS211D
    Assignment : #5
    This program takes user input and finds capital/state
    corresponding to input.
    I.e. if user inputs a state the capital of that state
    will be found and displayed, and vice versa
    Queries database made in SQLHandler
    Case sensitive user input
 */

package com.work.statesandcapitols;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//Capitols is misspelled but should be left alone
//Capitols refers to "Capitals"
public class StatesAndCapitols extends Activity
{
    InputStream inputStream;
    SQLHandler handler;
    Boolean isInserted;
    EditText userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        handler = new SQLHandler(this);
        userInput = (EditText)findViewById(R.id.userInput);
    }

    public void makeDB(View v)
    {
        try {
            inputStream = getResources().openRawResource(R.raw.usstates);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] split = line.split("\\s" + "\\s+");
                if (split.length == 2)
                {
                   isInserted = handler.insertData(split[0], split[1]);
                  /* if (isInserted)
                   {
                       Toast.makeText(StatesAndCapitols.this, "Entry made", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       Toast.makeText(StatesAndCapitols.this, "Entry NOT made", Toast.LENGTH_SHORT).show();
                   }
                   //Toasts can be uncommented if preferred */
                }
            }
            reader.close();
        }catch(IOException e) {} // Nothing to report
    }

    public void queryInput(View v)
    {
        makeDB(v);
        String input = userInput.getText().toString();
        Boolean found = false;
        Boolean itsAState = false;
        Boolean itsACapital = false;
        String inputCounterpart = "";
        String parsedLine;
        TextView showOutput = (TextView)findViewById(R.id.resulting_string);

        Cursor findCapital = handler.getCapitalWhereStateIs(input);
        Cursor findState = handler.getStateWhereCapitolIs(input);
        findCapital.moveToFirst();
        findState.moveToFirst();

        if (findCapital.getCount() > 0)
        {
            itsAState = true;
            inputCounterpart = findCapital.getString(1); // change back to 1
        }
        else if (findState.getCount() > 0)
        {
            itsACapital = true;
            inputCounterpart = findState.getString(0);
        }

        if (itsAState)
        {
            parsedLine = "The Capital of " +input+" is " +inputCounterpart;
            showOutput.setText(parsedLine);
        }
        else if (itsACapital)
        {
            parsedLine = "The State " + input +" belongs to is " +inputCounterpart;
            showOutput.setText(parsedLine);
        }
        else
        {
            showOutput.setText("Invalid Input");
        }
    }

}
