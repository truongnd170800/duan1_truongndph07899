package com.example.duan1_truongndph07899.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.duan1_truongndph07899.R;
import com.example.duan1_truongndph07899.database.DataBaseHelper;

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


        int ma=1;


        maotu=(TextView)findViewById(R.id.maotu);
        tinhtu=(TextView)findViewById(R.id.tinhtu);
        sosanh=(TextView)findViewById(R.id.sosanh);
        gioitu=(TextView)findViewById(R.id.gioitu);
        lientu=(TextView)findViewById(R.id.lientu);
        thantu=(TextView)findViewById(R.id.thantu);
        menhde=(TextView)findViewById(R.id.menhde);

        maotu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(), infovanpham.class);
                i.putExtra("id", "1");
                startActivity(i);

            }
        });
        tinhtu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),infovanpham.class);
                i.putExtra("id", "2");
                startActivity(i);

            }
        });

        sosanh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),infovanpham.class);
                i.putExtra("id", "3");
                startActivity(i);

            }
        });
        gioitu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),infovanpham.class);
                i.putExtra("id", "4");
                startActivity(i);

            }
        });

        lientu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),infovanpham.class);
                i.putExtra("id", "5");
                startActivity(i);

            }
        });

        thantu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),infovanpham.class);
                i.putExtra("id", "6");
                startActivity(i);

            }
        });

        menhde.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),infovanpham.class);
                i.putExtra("id", "7");
                startActivity(i);

            }
        });

        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }
}