package com.example.selcukturedi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SilActivity extends AppCompatActivity {

    Button sil,iptal,tumunusil;
    EditText isim;
    VTislemleri vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sil);

        vt=new VTislemleri(this);
        vt.ac();

        sil=findViewById(R.id.sil);
        iptal=findViewById(R.id.iptal);
        tumunusil=findViewById(R.id.tumunusil);
        isim=findViewById(R.id.isim);


        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vt.RehberSil(isim.getText().toString());
                Toast.makeText(getApplicationContext(),"Deleted...",Toast.LENGTH_SHORT).show();
                isim.setText("");
                Intent i =new Intent(SilActivity.this,VerilerActivity.class);
                startActivity(i);

            }
        });

        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(SilActivity.this,RehberActivity.class);
                startActivity(i);
            }
        });

        tumunusil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(SilActivity.this);

                builder.setTitle("Are you sure?");
                builder.setMessage("Are you sure all data will be deleted?");

                builder.setPositiveButton("Delete All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        vt.RehberTumunuSil();
                        Toast.makeText(getApplicationContext(),"All Data Deleted ...",Toast.LENGTH_SHORT).show();
                        isim.setText("");
                        Intent i =new Intent(SilActivity.this,VerilerActivity.class);
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
    }
}
