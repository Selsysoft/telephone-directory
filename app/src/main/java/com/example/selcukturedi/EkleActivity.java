package com.example.selcukturedi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EkleActivity extends AppCompatActivity{

    Button kaydet,iptal;
    EditText ad,soyad,telefon;

    VTislemleri vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        vt=new VTislemleri(this);
        vt.ac();

        kaydet=findViewById(R.id.kaydet);
        iptal=findViewById(R.id.iptal);

        ad=findViewById(R.id.ad);
        soyad=findViewById(R.id.soyad);
        telefon=findViewById(R.id.telefon);


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Was recorded...",Toast.LENGTH_SHORT).show();

                vt.rehbereekle(ad.getText().toString(),soyad.getText().toString(),telefon.getText().toString());
                ad.setText("");
                soyad.setText("");
                telefon.setText("");
                Intent i =new Intent(EkleActivity.this,VerilerActivity.class);
                startActivity(i);
            }
        });


        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(EkleActivity.this,RehberActivity.class);
                startActivity(i);
            }
        });

    }


    protected void onResume(){
        vt.ac();
        super.onResume();
    }

    protected void onPause(){
        vt.ac();
        super.onPause();
    }
}
