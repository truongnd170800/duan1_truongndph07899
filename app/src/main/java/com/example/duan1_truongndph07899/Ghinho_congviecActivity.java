package com.example.duan1_truongndph07899;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Ghinho_congviecActivity extends Activity {
    ListView listview;
    Button bt_them;
    ImageView giupdo,menuchinh;
    ArrayList<Congviec> danhsach_congviec= new ArrayList<Congviec>();

    @SuppressWarnings("unused")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichep);
        listview =(ListView) findViewById(R.id.listView1);
        bt_them=(Button) findViewById(R.id.button1);
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

