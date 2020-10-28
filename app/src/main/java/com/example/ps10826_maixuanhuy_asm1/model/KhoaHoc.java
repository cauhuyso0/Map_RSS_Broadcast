package com.example.ps10826_maixuanhuy_asm1.model;

public class KhoaHoc {
    String maKH;
    String tenKH;
    String lichTrinh;
    String lop;

    public KhoaHoc(String maKH, String tenKH, String lichTrinh, String lop) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.lichTrinh = lichTrinh;
        this.lop = lop;
    }
    public KhoaHoc(String tenKH, String lichTrinh, String lop) {
        this.tenKH = tenKH;
        this.lichTrinh = lichTrinh;
        this.lop = lop;
    }
    public KhoaHoc(String tenKH, String lichTrinh){
        this.tenKH = tenKH;
        this.lichTrinh = lichTrinh;
    }

    public KhoaHoc(){

    }

    @Override
    public String toString() {
        return "KhoaHoc{" +
                "maKH=" + maKH +
                ", tenKH='" + tenKH + '\'' +
                ", lichTrinh='" + lichTrinh + '\'' +
                ", lop='" + lop + '\'' +
                '}';
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getLichTrinh() {
        return lichTrinh;
    }

    public void setLichTrinh(String lichTrinh) {
        this.lichTrinh = lichTrinh;
    }
}
