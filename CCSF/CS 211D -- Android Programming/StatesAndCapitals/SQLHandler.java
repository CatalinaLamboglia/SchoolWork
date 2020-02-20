/*
    Programmer : Catalina Lamboglia
    Course     : CS211D
    Assignment : #5
    This program takes a file and creates an
    SQLiteDatabase to be queried for
    StatesAndCapitols.java
    Case sensitive user input
 */

package com.work.statesandcapitols;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Known issues: Constantly creates duplicate entries
//Capitols is misspelled but should be left alone
public class SQLHandler extends SQLiteOpenHelper
{
    static final String DB_NAME = "StatesAndCapitols.db";
    public SQLHandler(Context context)
    {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sqlCmd = "create table if not exists StatesAndCapitols(id integer " +
                "primary key autoincrement, " +
                "state text not null, " +
                "capitol text not null)";
        db.execSQL(sqlCmd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("Drop table if exists StatesAndCapitols");
        onCreate(db);
    }

    public boolean insertData(String state, String capitol)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", state);
        contentValues.put("capitol", capitol);
        long result = db.insertWithOnConflict("StatesAndCapitols", null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getCapitalWhereStateIs(String state)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select state, capitol from StatesAndCapitols where state=" +"'"+state+"'", null);
        return  cursor;
    }
    public Cursor getStateWhereCapitolIs(String capitol)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select state, capitol from StatesAndCapitols where capitol=" +"'" +capitol+"'", null);
        return cursor;
    }
}
