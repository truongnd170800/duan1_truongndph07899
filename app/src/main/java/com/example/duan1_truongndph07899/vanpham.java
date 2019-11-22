package com.example.duan1_truongndph07899;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class vanpham extends Activity {
    ImageView giupdo, menuchinh;
    TextView maotu, tinhtu, sosanh, gioitu, lientu, thantu, menhde;
    private DataBaseHelper myDbHelper;
    private ArrayList<String> arraywork;
    private ArrayAdapter<String> arrayadapter;
    private ListView list;
    private String TAG = "mysqllite";
    static public int maotugui = 1;
    static public int code_thaotac_sua = 888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vanpham);

        giupdo = (ImageView) findViewById(R.id.hinhgiupdo);
        menuchinh = (ImageView) findViewById(R.id.hinhbackmenu);


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