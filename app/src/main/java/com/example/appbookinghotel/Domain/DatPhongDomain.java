package com.example.appbookinghotel.Domain;

import java.util.Date;

public class DatPhongDomain {
    public DatPhongDomain(int iId) {
        this.iId = iId;
    }

    public DatPhongDomain() {

    }
    public DatPhongDomain(int iId, String stenkhachsan, String sHoten, int iSongay, int loaiphong, double dthanhtien) {
        this.iId = iId;
        this.stenkhachsan = stenkhachsan;
        this.sHoten = sHoten;
        this.iSongay = iSongay;
        this.loaiphong = loaiphong;
        this.dthanhtien = dthanhtien;
    }
    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    private int iId;
    private String stenkhachsan;
    private String sHoten;
    private Date dNgaydat;

    private int iSongay;

    public String getStenkhachsan() {
        return stenkhachsan;
    }

    public void setStenkhachsan(String stenkhachsan) {
        this.stenkhachsan = stenkhachsan;
    }

    public String getsHoten() {
        return sHoten;
    }

    public void setsHoten(String sHoten) {
        this.sHoten = sHoten;
    }

    public Date getdNgaydat() {
        return dNgaydat;
    }

    public void setdNgaydat(Date dNgaydat) {
        this.dNgaydat = dNgaydat;
    }


    public int getiSongay() {
        return iSongay;
    }

    public void setiSongay(int iSongay) {
        this.iSongay = iSongay;
    }

    public int getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(int loaiphong) {
        this.loaiphong = loaiphong;
    }

    public double getDthanhtien() {
        return dthanhtien;
    }

    public void setDthanhtien(double dthanhtien) {
        this.dthanhtien = dthanhtien;
    }

    private int loaiphong;

    private double dthanhtien;

    }
