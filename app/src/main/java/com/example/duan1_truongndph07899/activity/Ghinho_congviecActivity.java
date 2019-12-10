package com.example.duan1_truongndph07899.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.duan1_truongndph07899.Congviec;
import com.example.duan1_truongndph07899.Quanly_congviec;
import com.example.duan1_truongndph07899.R;

import java.util.ArrayList;
import java.util.List;

public class Ghinho_congviecActivity extends Activity {
    ListView listview;
    Button bt_them;
    ImageView giupdo,menuchinh;
    ArrayList<Congviec> danhsach_congviec= new ArrayList<Congviec>();

    static public int code_thaotac_them=999;
    static public int code_thaotac_sua=888;

    @SuppressWarnings("unused")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichep);
        // đi tìm
        listview =(ListView) findViewById(R.id.listView1);
        bt_them=(Button) findViewById(R.id.button1);
        giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
        menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);
        // thực hiện liệt kê các công việc
//        lietke_congviec();
        registerForContextMenu(listview);
        // cai dat su kien touch trên button Them
        bt_them.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i= new Intent(view.getContext(),Nhap_congviecActivity.class);
                startActivityForResult(i, code_thaotac_them);
            }
        });
        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==code_thaotac_them && resultCode==RESULT_OK)
        {
            String noidung_congviec= data.getStringExtra("noidung_congviec");
            String thoigian_thuchien=data.getStringExtra("thoigian_thuchien");
            String mucdo_quantrong=data.getStringExtra("mucdo_quantrong");
            Quanly_congviec db=new Quanly_congviec(this);
            db.them_congviec(new Congviec(noidung_congviec, thoigian_thuchien, mucdo_quantrong));
            db.close();
            lietke_congviec();
        }
        if (requestCode==code_thaotac_sua && resultCode==RESULT_OK)
        {
            int _id=Integer.parseInt(data.getStringExtra("_id").toString());
            String noidung_congviec= data.getStringExtra("noidung_congviec");
            String thoigian_thuchien=data.getStringExtra("thoigian_thuchien");
            String mucdo_quantrong=data.getStringExtra("mucdo_quantrong");
            Quanly_congviec db=new Quanly_congviec(this);

            db.sua_1_congviec(new Congviec(_id, noidung_congviec, thoigian_thuchien, mucdo_quantrong));
            db.close();
            lietke_congviec();
        }
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String[] menuItems={"Sửa công việc","Xóa công việc","Xóa hết công việc"};
        String menuItemName = menuItems[menuItemIndex];
        int current_row = info.position;  // lấy hàng hiện tại, khi touch lâu gọi ContextMenu

        if (menuItemName.equals("Sửa công việc"))
        {
            Intent i= new Intent(this,Sua_congviecActivity.class);
            Congviec congviec=danhsach_congviec.get(current_row);
            i.putExtra("_id", String.valueOf(congviec.get_id()));
            i.putExtra("noidung_congviec", congviec.getNoidung_congviec());
            i.putExtra("thoigian_thuchien", congviec.getThoigian_thuchien());
            i.putExtra("mucdo_quantrong", congviec.getMucdo_quantrong());
            startActivityForResult(i, code_thaotac_sua);
            lietke_congviec();
        }

        if (menuItemName.equals("Xóa công việc"))
        {
            int id_congviec_dangchon= danhsach_congviec.get(current_row).get_id();
            Quanly_congviec db= new Quanly_congviec(this);
            db.xoa_1_congviec(id_congviec_dangchon);
            lietke_congviec();
        }

        if (menuItemName.equals("Xóa hết công việc"))
        {
            Quanly_congviec db= new Quanly_congviec(this);
            db.xoatatca_congviec();
            lietke_congviec();
        }

        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.listView1){
            AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) menuInfo;
            Congviec congviec_dangchon = danhsach_congviec.get(info.position);
            menu.setHeaderTitle("Công việc"+congviec_dangchon.getNoidung_congviec());
            String[] menuItems={"Sửa công việc","Xóa công việc","Xóa hết công việc"};
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }


    public void lietke_congviec(){

        Quanly_congviec db= new Quanly_congviec(this);
//        db.xoatatca_congviec();
        // them 1 vai cong viec
//        db.them_congviec(new Congviec("Nop bao cao cho sep","29/04/2012","Đặc biệt"));
//        db.them_congviec(new Congviec("Di cau ca","30/04/2012","Bình thường"));
//        db.them_congviec(new Congviec("Di boi","01/05/2012","Không quan trọng"));
//        db.them_congviec(new Congviec("Thay nhot xe","05/05/2012","Bình thường"));
//        db.them_congviec(new Congviec("Hot toc","11/05/2012","Bình thường"));
        // xem
        List<Congviec> ds= db.getAllCongviec();
        if (ds!=null)
        {
            danhsach_congviec.clear();

            ArrayList<String> danhsach= new ArrayList<String>(); // nguon cho listview để show ra
            danhsach.clear();

            for (Congviec x:ds){
                danhsach_congviec.add(x);
                danhsach.add(x.getNoidung_congviec().toString()+"\n"+x.getThoigian_thuchien().toString());
            }
            if (danhsach_congviec!=null)
            {
                listview.setAdapter(new myAdapter(this, danhsach));
            }
        }

    }
    class myAdapter extends ArrayAdapter{ // lop Adapter tự định nghĩa cung cấp nguồn cho ListView
        Context context;
        ArrayList<String> danhsach;
        public myAdapter(Context context,ArrayList<String> danhsach) {
            super(context,R.layout.list_item,danhsach);
            this.context=context;
            this.danhsach=danhsach;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // dùng LayoutInFlatter lấy đọc cấu trúc và nội dung của từng hàng ListView
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item, parent, false);
            // đi tìm trong từng hàng ListView, cập nhật thông tin
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);

            textView.setTextSize(14);

            Congviec congviec_dong_hien_tai= danhsach_congviec.get(position);
            if (congviec_dong_hien_tai.getMucdo_quantrong().toString().equals("Đặc biệt"))
            {
                textView.setTextColor(Color.RED);
                textView.setText(""+danhsach.get(position));
                imageView.setImageResource(R.drawable.important);
            }
            else
            if (congviec_dong_hien_tai.getMucdo_quantrong().toString().equals("Bình thường"))
            {
                textView.setTextColor(Color.BLUE);
                textView.setText(""+danhsach.get(position));
                imageView.setImageResource(R.drawable.normal);
            }
            else
            {
                textView.setTextColor(Color.MAGENTA);
                textView.setText(""+danhsach.get(position));
                imageView.setImageResource(R.drawable.not_important);
            }



            return rowView;
        }


    }


}
