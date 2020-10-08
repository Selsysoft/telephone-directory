package com.example.selcukturedi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class RehberActivity extends AppCompatActivity {

    Button yenikisiekle,kisiler,kisiyisil,kisiyiguncelle;
    View view1,view2,view3,view4,view5;
    Animation mytranslation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehber);


        yenikisiekle=findViewById(R.id.yenikisiekle);
        kisiler=findViewById(R.id.kisiler);
        kisiyisil=findViewById(R.id.kisiyisil);
        kisiyiguncelle=findViewById(R.id.kisiyiguncelle);

        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        view3=findViewById(R.id.view3);
        view4=findViewById(R.id.view4);
        view5=findViewById(R.id.view5);

        mytranslation= AnimationUtils.loadAnimation(this,R.anim.mytranslation);

        yenikisiekle.setAnimation(mytranslation);
        kisiler.setAnimation(mytranslation);
        kisiyisil.setAnimation(mytranslation);
        kisiyiguncelle.setAnimation(mytranslation);
        view1.setAnimation(mytranslation);
        view2.setAnimation(mytranslation);
        view3.setAnimation(mytranslation);
        view4.setAnimation(mytranslation);
        view5.setAnimation(mytranslation);



        yenikisiekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RehberActivity.this, EkleActivity.class);
                startActivity(intent);
            }
        });

        kisiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(RehberActivity.this,VerilerActivity.class);
                startActivity(i);
            }
        });

        kisiyisil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(RehberActivity.this,SilActivity.class);
                startActivity(i);
            }
        });

        kisiyiguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(RehberActivity.this,GuncelleActivity.class);
                startActivity(i);
            }
        });
    }
}
