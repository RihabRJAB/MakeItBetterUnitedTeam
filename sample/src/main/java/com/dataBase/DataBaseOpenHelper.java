package com.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 18/12/2015.
 */
public class DataBaseOpenHelper extends SQLiteOpenHelper{


    public DataBaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String query = "CREATE TABLE Activties(_id integer primary key AUTOINCREMENT," +
                    "dayOfMonth int," +
                    "monthOfYear int," +
                    "year int," +
                    "minute int," +
                    "hourOfDay int," +
                    "minuteEnd int," +
                    "HourOfDayEnd int," +
                    "yearEnd int," +
                    "dayOfMonthEnd  int," +
                    "monthOfYearEnd int," +
                    "activity varchar(60));";

            db.execSQL(query);

        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
