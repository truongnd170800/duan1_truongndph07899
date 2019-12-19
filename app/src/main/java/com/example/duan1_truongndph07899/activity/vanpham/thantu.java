package com.example.duan1_truongndph07899.activity.vanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.duan1_truongndph07899.R;

public class thantu extends AppCompatActivity {
    Button btnquaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thantu);
        btnquaylai = findViewById(R.id.bthquailai);

        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent i=new Intent(getApplicationContext(), vanpham.class);
                i.putExtra("id", "1");
                startActivity(i);
            }
        });


    }
}
