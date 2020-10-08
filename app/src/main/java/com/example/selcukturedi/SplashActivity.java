package com.example.selcukturedi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView splash;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash=findViewById(R.id.splash);
        Animation seltechanim= AnimationUtils.loadAnimation(this,R.anim.mytranslation);


        splash.startAnimation(seltechanim);

        final Intent i = new Intent(this,RehberActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }

}
