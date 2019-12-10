package com.example.duan1_truongndph07899.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.duan1_truongndph07899.R;

public class Nhap_congviecActivity extends Activity {
    Button bt;
    EditText et_noidung_congviec,et_thoigian_thuchien;
    Spinner spinner_mucdo_quantrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_congviec);
        // đi tìm
        et_noidung_congviec=(EditText) findViewById(R.id.editText1);
        et_thoigian_thuchien=(EditText) findViewById(R.id.editText2);
        spinner_mucdo_quantrong=(Spinner) findViewById(R.id.spinner1);


        bt=(Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i= new Intent();
                i.putExtra("noidung_congviec",et_noidung_congviec.getText().toString() );
                i.putExtra("thoigian_thuchien",et_thoigian_thuchien.getText().toString() );
                i.putExtra("mucdo_quantrong", spinner_mucdo_quantrong.getSelectedItem().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}
