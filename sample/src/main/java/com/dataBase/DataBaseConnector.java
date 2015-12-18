package com.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by asus on 18/12/2015.
 */
public class DataBaseConnector {

    Context context ;
    DataBaseOpenHelper  dataopenHelper;
    SQLiteDatabase db;


    public DataBaseConnector(Context context) {
        this.context = context;
        dataopenHelper=new DataBaseOpenHelper(context ,"notification.db",null ,1);

    }

    public void open(){

        db=dataopenHelper.getWritableDatabase();
    }
    public void close(){
        db.close();
    }
    public void  insertActivities(Activityy a){
        ContentValues contentValues =new ContentValues();
        contentValues.put("_id",a.getId());
        contentValues.put("minute",a.getMinute());
        contentValues.put("hourOfDay",a.getHourOfDay());
        contentValues.put("minuteEnd",a.getMinuteEnd());
        contentValues.put("hourOfDayEnd",a.getHourOfDayEnd());
        contentValues.put("year",a.getYear());
        contentValues.put("monthOfYear",a.getMonthOfYear());
        contentValues.put("dayOfMonth",a.getDayOfMonth());
        contentValues.put("yearEnd",a.getYearEnd());
        contentValues.put("monthOfYearEnd",a.getMonthOfYearEnd());
        contentValues.put("dayOfMonthEnd",a.getDayOfMonthEnd());
        contentValues.put("activity", a.getActivity());
        open();
        db.insert("notification" ,null,contentValues );
        close();
    }

    public void updateActivity(Activityy a){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",a.getId());
        contentValues.put("minute",a.getMinute());
        contentValues.put("hourOfDay",a.getHourOfDay());
        contentValues.put("minuteEnd",a.getMinuteEnd());
        contentValues.put("hourOfDayEnd",a.getHourOfDayEnd());
        contentValues.put("year",a.getYear());
        contentValues.put("monthOfYear",a.getMonthOfYear());
        contentValues.put("dayOfMonth",a.getDayOfMonth());
        contentValues.put("yearEnd",a.getYearEnd());
        contentValues.put("monthOfYearEnd",a.getMonthOfYearEnd());
        contentValues.put("dayOfMonthEnd",a.getDayOfMonthEnd());
        contentValues.put("activity", a.getActivity());

        open();
        db.update("notification", contentValues, "_id=" + a.getId(), null);
        close();

    }

    public Cursor getAllActivities()
    {


        open();
        String[] cols={"activity","hourOfDay","minute","dayOfMonth","monthOfYear","year"};
        return db.query("notification",cols,null,null,null,null,null,"_id");
    }
    public void deleteActivity(Activityy a){
        open();
        db.delete("notification", "_id=" + a.getId(), null);
    }





}
