package com.example.duan1_truongndph07899;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Quanly_congviec extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ghinho_congviec2";
    private static final String ten_table = "ds_congviec";

    // danh sách các field của table ds_congviec
    private static final String KEY_ID = "_id";
    private static final String KEY_NOIDUNG_CONGVIEC = "noidung_congviec";
    private static final String KEY_THOIGIAN_THUCHIEN = "thoigian_thuchien";
    private static final String KEY_MUCDO_QUANTRONG = "mucdo_quantrong";

    public Quanly_congviec(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tạo table
        String SQL_String = "CREATE TABLE " + ten_table + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOIDUNG_CONGVIEC + " TEXT,"
                + KEY_THOIGIAN_THUCHIEN + " TEXT, "
                + KEY_MUCDO_QUANTRONG + " TEXT" + ")";
        db.execSQL(SQL_String);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + ten_table);

        // Create tables again
        onCreate(db);
    }

    // xem het cong viec
    public List<Congviec> getAllCongviec() {
        List<Congviec> CongviecList = new ArrayList<Congviec>();
        String[] ds_dieukien_loc=null;

        String selectQuery = "SELECT  * FROM " + ten_table;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, ds_dieukien_loc);


        if (cursor.moveToFirst()) {
            do {
                Congviec Congviec = new Congviec();
                Congviec.set_id(Integer.parseInt(cursor.getString(0)));
                Congviec.setNoidung_congviec(cursor.getString(1));
                Congviec.setThoigian_thuchien(cursor.getString(2));
                Congviec.setMucdo_quantrong(cursor.getString(3));
                // Them  Congviec vào list
                CongviecList.add(Congviec);
            } while (cursor.moveToNext());
        }
        db.close();
        return CongviecList;
    }

    // them 1 cong viec moi
    public void them_congviec(Congviec congviec) {
        SQLiteDatabase db = this.getWritableDatabase();
        String nullColumnHack=null; // chấp nhận field có giá trị null
        ContentValues values = new ContentValues();
        if (congviec.get_id()!=-1) values.put(KEY_ID,congviec.get_id());
        values.put(KEY_NOIDUNG_CONGVIEC, congviec.getNoidung_congviec());
        values.put(KEY_THOIGIAN_THUCHIEN, congviec.getThoigian_thuchien());
        values.put(KEY_MUCDO_QUANTRONG, congviec.getMucdo_quantrong());
        db.insert(ten_table, nullColumnHack, values);
        db.close();
    }

    // xoa tat ca cong viec
    public void xoatatca_congviec() {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause="";
        String[] whereArgs=null;
        db.delete(ten_table, whereClause, whereArgs);
        db.close();
    }

    public void xoa_1_congviec(int id){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("delete from  " + ten_table + " where _id="+id);
        db.close();
    }

    public int sua_1_congviec(Congviec congviec) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOIDUNG_CONGVIEC, congviec.getNoidung_congviec());
        values.put(KEY_THOIGIAN_THUCHIEN, congviec.getThoigian_thuchien());
        values.put(KEY_MUCDO_QUANTRONG, congviec.getMucdo_quantrong());

        String whereClause=KEY_ID + "=?";
        String[] whereArgs={String.valueOf(congviec.get_id())};
        return db.update(ten_table, values, whereClause, whereArgs);
    }
}

