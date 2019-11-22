package com.example.duan1_truongndph07899;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends   AppCompatActivity  {
private ImageView btIntro;
protected static Configuration cfg;
        MediaPlayer nhacnen;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        nhacnen=MediaPlayer.create(MainActivity.this, R.raw.moichonok);
        nhacnen.start();


        btIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,gioithieu.class);
                startActivity(intent);
            }
        });
        }

    private void initView() {
    btIntro=findViewById(R.id.view1);
    }

    protected void onPause(){
        super.onPause();
        nhacnen.release();
        finish();
        }

    public void btnhocnghe(View view) {
    Intent i = new Intent(this,hocnghe.class);
    startActivity(i);
    }

    public void btnhocquavideo(View view) {
        Intent i = new Intent(this,playvideo.class);
        startActivity(i);
    }


//        if(pos==1)
//        {
//            Intent i=new Intent(getApplication(),hocnghe.class);
//            startActivity(i);
//
//        }
//
//        if(pos==2)
//        {
//            Intent i=new Intent(getApplication(),xemvideo.class);
//            startActivity(i);
//
//        }
//
//        if(pos==3)
//        {
//            Intent i=new Intent(getApplication(),Ghinho_congviecActivity.class);
//            startActivity(i);
//
//        }
//
//        if(pos==4)
//        {
//            Intent i=new Intent(getApplication(),vanpham.class);
//            startActivity(i);
//
//        }
//
//        if(pos==5)
//        {
//            Intent i=new Intent(getApplication(),tudien.class);
//            startActivity(i);
//
//        }
//
//        if(pos==6)
//        {
//            Intent i=new Intent(getApplication(),elearning.class);
//            startActivity(i);
//
//        }
//
//        if(pos==7)
//        {
//            Intent i=new Intent(getApplication(),tacgia.class);
//            startActivity(i);
//
//        }
//
//        if(pos==8)
//        {
//            nhacnen=MediaPlayer.create(MainActivity.this, R.raw.camonthoat);
//            nhacnen.start();
//
//            Thread bamgio=new Thread(){
//                public void run(){
//                    try{
//                        sleep(4000);
//
//
//                    } catch (Exception e){
//
//                    } finally{
//
//                        System.exit(0);
//                        finish();
//                        //Intent activitymoi=
//                        //new Intent(getApplicationContext(),MainActivity.class);
//                        //startActivity(activitymoi);
//                    }
//                }
//            };
//            bamgio.start();


        }
//

   // }

