package com.example.duan1_truongndph07899.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.duan1_truongndph07899.R;
import com.example.duan1_truongndph07899.activity.vanpham;
import com.example.duan1_truongndph07899.database.DataBaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;

public class infovanpham extends AppCompatActivity {
    private DataBaseHelper myDbHelper;
    private ArrayList<String> arraywork;
    private ArrayAdapter<String> arrayadapter;
    private ListView list;
    private String TAG="mysqllite";
    TextView tv1;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infovanpham);

        back=(Button)findViewById(R.id.buttonquaylai);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i=new Intent(getApplicationContext(), vanpham.class);
                startActivity(i);
            }
        });
        tv1=(TextView)findViewById(R.id.noidunginfo);

        Intent i = getIntent();
        String soid = i.getStringExtra("id");
        //tv1.setText(soid);

        arraywork=new ArrayList<String>();
        arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arraywork);


        myDbHelper = new DataBaseHelper(this);
        //mo csdl
        try{
            myDbHelper.checkAndCopyDatabase();
            myDbHelper.openDataBase();
        }catch(SQLException sqle){
            Log.d(TAG, "database error!");
        }

        try {
            Cursor c = myDbHelper.QueryData("select noidung from vanpham where id="+ soid +" ");
            if(c!=null){
                if  (c.moveToFirst()) {

                    String str = c.getString(c.getColumnIndex("noidung"));

                    tv1.setText(str);

                }
                arrayadapter.notifyDataSetChanged();
            }
        } catch (SQLException e) {
            Log.d(TAG, "Query error!");
        }

    }

}

