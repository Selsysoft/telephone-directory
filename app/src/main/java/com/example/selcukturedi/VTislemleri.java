package com.example.selcukturedi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.selcukturedi.*;

import java.util.ArrayList;
import java.util.HashMap;

public class VTislemleri {
    public  VTislemleri(Context c){
        benimDB=new VT(c);
    }
    VT benimDB;
    SQLiteDatabase db;

    public void ac(){
        db=benimDB.getWritableDatabase();
    }
    public void kapat(){
        benimDB.close();
    }

    public void rehbereekle(String ad,String soyad,String telefon){
        ContentValues kayit=new ContentValues();
        kayit.put("ad",ad);
        kayit.put("soyad",soyad);
        kayit.put("telefon",telefon);
        this.ac();
        db.insert("rehberbilgileri",null,kayit);
        kapat();
    }

    public String RehberOku(){
        this.ac();
        String[] alanlar=new String[]{"ad","soyad","telefon"};
        Cursor cr = db.query("rehberbilgileri",alanlar,null,null,null,null,null);
        String sonuc="";

        int Ad=cr.getColumnIndex("ad");
        int Soyad=cr.getColumnIndex("soyad");
        int Telefon=cr.getColumnIndex("telefon");

        cr.moveToFirst();
        while (!cr.isAfterLast()){

            sonuc+=cr.getString(Ad)+" "+cr.getString(Soyad)+" "+cr.getString(Telefon)+"\n";
            cr.moveToNext();
        }
        cr.close();
        return sonuc.toString();
    }

    public ArrayList<HashMap<String,String>> RehberOkuListe(){
        SQLiteDatabase db=benimDB.getWritableDatabase();
        ArrayList<HashMap<String,String>> rhbrListesi=new ArrayList<>();
        String query ="SELECT ad,soyad,telefon FROM rehberbilgileri ORDER BY ad";
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> rehber = new HashMap<>();
            rehber.put("ad",cursor.getString(cursor.getColumnIndex("ad")));
            rehber.put("soyad",cursor.getString(cursor.getColumnIndex("soyad")));
            rehber.put("telefon",cursor.getString(cursor.getColumnIndex("telefon")));

            rhbrListesi.add(rehber);

        }
        return rhbrListesi;
    }

    public void RehberSil(String ad){
        this.ac();
        db.delete("rehberbilgileri","ad=?",new String[]{ad});
        this.kapat();
    }
    public void RehberTumunuSil(){
        this.ac();
        db.delete("rehberbilgileri",null,new String[]{});
        this.kapat();
    }



    public void RehberGuncelle(String telefon){
        ContentValues kayit= new ContentValues();

        kayit.put("telefon",telefon);
        this.ac();

        db.update("rehberbilgileri",kayit,"telefon",null);
        this.kapat();
    }
}
