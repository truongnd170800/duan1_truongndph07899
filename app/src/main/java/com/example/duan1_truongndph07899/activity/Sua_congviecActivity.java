package com.example.duan1_truongndph07899.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.duan1_truongndph07899.R;

public class Sua_congviecActivity extends Activity {
    Button bt;
    EditText et_noidung_congviec,et_thoigian_thuchien;
    Spinner spinner_mucdo_quantrong;

    String idStr="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_congviec_layout);
        // đi tìm
        et_noidung_congviec=(EditText) findViewById(R.id.editText1);
        et_thoigian_thuchien=(EditText) findViewById(R.id.editText2);
        spinner_mucdo_quantrong=(Spinner) findViewById(R.id.spinner1);

        Intent i= getIntent();
        idStr=i.getStringExtra("_id");
        // đưa thông tin cũ vào các Widget để người dùng sửa
        et_noidung_congviec.setText(i.getStringExtra("noidung_congviec"));
        et_thoigian_thuchien.setText(i.getStringExtra("thoigian_thuchien"));

        ArrayAdapter temp_adapter=(ArrayAdapter) spinner_mucdo_quantrong.getAdapter(); // lay adapter cua spinner
        int k=temp_adapter.getPosition(i.getStringExtra("mucdo_quantrong")); // dò tìm vị trí k
        spinner_mucdo_quantrong.setSelection(k); // set mục chọn

        bt=(Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent i= new Intent();
                i.putExtra("_id", idStr);
                i.putExtra("noidung_congviec",et_noidung_congviec.getText().toString() );
                i.putExtra("thoigian_thuchien",et_thoigian_thuchien.getText().toString() );
                i.putExtra("mucdo_quantrong", spinner_mucdo_quantrong.getSelectedItem().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}
