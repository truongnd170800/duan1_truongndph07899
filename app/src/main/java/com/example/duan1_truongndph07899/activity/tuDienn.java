package com.example.duan1_truongndph07899.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.duan1_truongndph07899.R;

public class tuDienn extends Activity {
    ImageView giupdo, menuchinh;
    Button tracuu;
    EditText formtracuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_dienn);

        tracuu = (Button) findViewById(R.id.buttontracuu);
        formtracuu = (EditText) findViewById(R.id.formtracuu);
        giupdo = (ImageView) findViewById(R.id.hinhgiupdo);
        menuchinh = (ImageView) findViewById(R.id.hinhbackmenu);

        tracuu.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                String tukhoa = formtracuu.getText().toString();

                finish();
                Intent i = new Intent(getApplicationContext(), infotracuu.class);
                i.putExtra("tukhoa", tukhoa);
                startActivity(i);
            }
        });
        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }
}

