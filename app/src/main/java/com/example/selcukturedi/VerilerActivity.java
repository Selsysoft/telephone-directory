package com.example.selcukturedi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class VerilerActivity extends AppCompatActivity {

    SearchView mySearchView;
    ListView lstKayitlar;
    VTislemleri vt;
    Button back;

    ArrayList<String> list;
    ArrayAdapter<String> adapterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veriler);


        lstKayitlar=findViewById(R.id.kayitlar);
        mySearchView=findViewById(R.id.mySearchView);



        back=findViewById(R.id.back);

        vt=new VTislemleri(this);
        vt.ac();
        ArrayList<HashMap<String,String>> rhbrListesi=vt.RehberOkuListe();


        ListAdapter adapter = new SimpleAdapter(VerilerActivity.this,rhbrListesi,R.layout.activity_liste,new String[]{"ad","soyad","telefon"},new int[]{R.id.add,R.id.soyadd,R.id.telefonn});
        lstKayitlar.setAdapter(adapter);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(VerilerActivity.this,RehberActivity.class);
                startActivity(i);
            }
        });
    }

}
