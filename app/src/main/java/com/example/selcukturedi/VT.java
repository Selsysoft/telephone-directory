package com.example.selcukturedi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VT extends SQLiteOpenHelper {
    public VT(Context context){
        super(context,"rehberDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table rehberbilgileri(ad varchar(15),soyad varchar(15),telefon varchar(11));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists rehberbilgileri");
        onCreate(db);
    }
}
