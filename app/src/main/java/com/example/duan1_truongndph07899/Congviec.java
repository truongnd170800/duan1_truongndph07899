package com.example.duan1_truongndph07899;

public class Congviec {
    private int _id=-1;
    private String noidung_congviec="";
    private String thoigian_thuchien="";
    private String mucdo_quantrong="";
    public String getMucdo_quantrong() {
        return mucdo_quantrong;
    }
    public void setMucdo_quantrong(String mucdo_quantrong) {
        this.mucdo_quantrong = mucdo_quantrong;
    }
    public Congviec(){

    }
    public Congviec( String noidung_congviec, String thoigian_thuchien,String mucdo_quantrong) {
        this.noidung_congviec = noidung_congviec;
        this.thoigian_thuchien = thoigian_thuchien;
        this.mucdo_quantrong = mucdo_quantrong;

    }
    public Congviec(int _id, String noidung_congviec, String thoigian_thuchien,String mucdo_quantrong) {
        this._id = _id;
        this.noidung_congviec = noidung_congviec;
        this.thoigian_thuchien = thoigian_thuchien;
        this.mucdo_quantrong= mucdo_quantrong;
    }
    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String getNoidung_congviec() {
        return noidung_congviec;
    }
    public void setNoidung_congviec(String noidung_congviec) {
        this.noidung_congviec = noidung_congviec;
    }
    public String getThoigian_thuchien() {
        return thoigian_thuchien;
    }
    public void setThoigian_thuchien(String thoigian_thuchien) {
        this.thoigian_thuchien = thoigian_thuchien;
    }
}
