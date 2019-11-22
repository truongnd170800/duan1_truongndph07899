package com.example.duan1_truongndph07899;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {
    MediaPlayer nhacnen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        nhacnen=MediaPlayer.create(SplashScreenActivity.this, R.raw.chaomungok);
        nhacnen.start();

        Thread bamgio=new Thread(){
            public void run(){
                try{
                    sleep(100);


                } catch (Exception e){

                } finally{
                    Intent activitymoi=
                            new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(activitymoi);
                }
            }
        };
        bamgio.start();

    }

    protected void onPause(){
        super.onPause();
        nhacnen.release();
        finish();
    }


}
