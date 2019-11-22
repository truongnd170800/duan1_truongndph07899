package com.example.duan1_truongndph07899;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class tacgia extends Activity {
    ImageView giupdo,menuchinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacgia);

        giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
        menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);

        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });
    }
}
