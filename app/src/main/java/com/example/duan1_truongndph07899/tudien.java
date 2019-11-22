package com.example.duan1_truongndph07899;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class tudien extends Activity {

    ImageView giupdo, menuchinh;
    Button tracuu;
    EditText formtracuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudien);


        tracuu = (Button) findViewById(R.id.buttontracuu);
        formtracuu = (EditText) findViewById(R.id.formtracuu);

        giupdo = (ImageView) findViewById(R.id.hinhgiupdo);
        menuchinh = (ImageView) findViewById(R.id.hinhbackmenu);
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
