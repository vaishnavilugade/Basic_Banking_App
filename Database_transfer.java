package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class Database_transfer extends SQLiteOpenHelper {
    private static final String vaishnavi = "userinfo.db";

    public Database_transfer(@Nullable Context context) {

        super(context, vaishnavi, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q = "create table transaction_done(id integer primary key autoincrement,amount text,name text)";
        sqLiteDatabase.execSQL(q);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists transaction_done");
        onCreate(sqLiteDatabase);


    }

    public boolean insert_data(String amount, String name) {
        SQLiteDatabase db = this.getWritableDatabase();//for insertion
        ContentValues c = new ContentValues();
        //c.put("name",name);
        c.put("amount", amount);
        c.put("name", name);
        long r = db.insert("transaction_done", "null", c);
        if (r == -1) return false;
        else
            return true;
    }

   public Cursor getinfo(){
       SQLiteDatabase db = this.getWritableDatabase();//for insertion
       Cursor cursor=db.rawQuery("select * from transaction_done",null);
       return cursor;

   }


}
