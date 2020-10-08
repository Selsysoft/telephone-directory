package com.example.selcukturedi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class GuncelleActivity extends AppCompatActivity {
    ListView lstKayitlar;
    VTislemleri vt;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guncelle);

        back=findViewById(R.id.back);

        vt=new VTislemleri(this);
        vt.ac();
        ArrayList<HashMap<String,String>> rhbrListesi=vt.RehberOkuListe();

        lstKayitlar=findViewById(R.id.kayitlar);

        final ListAdapter adapter = new SimpleAdapter(GuncelleActivity.this,rhbrListesi,R.layout.activity_liste,new String[]{"ad","soyad","telefon"},new int[]{R.id.add,R.id.soyadd,R.id.telefonn});
        lstKayitlar.setAdapter(adapter);


        lstKayitlar.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lstKayitlar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final AlertDialog.Builder builder= new AlertDialog.Builder(GuncelleActivity.this);

                final EditText yenitelefon = new EditText(GuncelleActivity.this);

                yenitelefon.setHint("Phone Number");
                yenitelefon.setInputType(InputType.TYPE_CLASS_PHONE);
                builder.setView(yenitelefon);


                builder.setTitle("Update");
                builder.setMessage("Enter new phone number.");


                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        vt.RehberGuncelle(yenitelefon.getText().toString());

                        yenitelefon.setText("");
                        Toast.makeText(GuncelleActivity.this,"Updated... ",Toast.LENGTH_SHORT ).show();
                        Intent i =new Intent(GuncelleActivity.this,VerilerActivity.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                });
                builder.show();


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(GuncelleActivity.this,RehberActivity.class);
                startActivity(i);
            }
        });

    }



}
