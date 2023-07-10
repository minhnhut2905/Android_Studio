package com.example.appbookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Executable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatPhong_Activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    public EditText hoten, khachsan, ngaydat,ngayden,loaiphong, songay, thanhtien;
    private Button btnNgayden, btnNgaydat, btnDatPhong,  btnXemthu;


    EditText hoten1, khachsan1, ngaydat1, ngayden1, loaiphong1, songay1, thanhtien1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);

        hoten = findViewById(R.id.eHoten);
        khachsan = findViewById(R.id.eKhachsan);
        ngaydat = findViewById(R.id.dtpNgaydat);
        ngayden = findViewById(R.id.dtpNgayden);
        loaiphong = findViewById(R.id.cboLoaiphong);
        songay = findViewById(R.id.eSongay);
        thanhtien = findViewById(R.id.ethanhtien);
        btnNgayden = findViewById(R.id.btnChonngayden);
        btnNgaydat = findViewById(R.id.btnChonngaydat);
        btnDatPhong = findViewById(R.id.btnDangKy);
        btnXemthu = findViewById(R.id.btnXemthu);


        btnNgayden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Choose_DatetimePicker_Den();
            }
        });
        btnNgaydat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Choose_DatetimePicker();
            }
        });
        btnXemthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Khachsan1 = khachsan.getText().toString();
                String Hoten1 = hoten.getText().toString();
                Date NgayDat1 = null;
                try {
                    NgayDat1 = new SimpleDateFormat("yyyy/MM/dd").parse(ngaydat.getText().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Date NgayDen1 = null;
                try {
                    NgayDen1 = new SimpleDateFormat("yyyy/MM/dd").parse(ngayden.getText().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Integer SoNgay = Integer.parseInt(songay.getText().toString());
                Integer LoaiPhong = Integer.parseInt(loaiphong.getText().toString());
//                Double ThanhTien = Double.parseDouble(thanhtien.getText().toString());

                if (Khachsan1.length() == 0 || Hoten1.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    if (NgayDat1.getTime() <= NgayDen1.getTime()) {
                        if(1<=LoaiPhong && LoaiPhong <=2){
                            double kq = 0;
                            if(LoaiPhong == 1){
                                kq = SoNgay * 150000;
                                thanhtien.setText(String.valueOf(kq));
                            } else if(LoaiPhong == 2){
                                kq = SoNgay*280000;
                                thanhtien.setText(String.valueOf(kq));
                            }

                        }else{
                            thanhtien.setText(String.valueOf(""));
                            Toast.makeText(getApplicationContext(), "Có 2 loại phòng: 1 là phòng 1 giường, 2 là phòng 2 giường!!!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Ngày đặt phải nhỏ hơn hoặc bằng ngày ngày đến!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(DatPhong_Activity.this);
                View mview = getLayoutInflater().inflate(R.layout.activity_thongbao,null);

                Button btnSubmit, btn_Huy;
                btn_Huy = mview.findViewById(R.id.btnHuy);
                btnSubmit = mview.findViewById(R.id.btnDat);
                hoten1 = mview.findViewById(R.id.eHoten1);
                khachsan1 = mview.findViewById(R.id.eKhachsan1);
                ngaydat1 = mview.findViewById(R.id.dtpNgaydat1);
                ngayden1 = mview.findViewById(R.id.dtpNgayden1);
                loaiphong1 = mview.findViewById(R.id.cboLoaiphong1);
                songay1 = mview.findViewById(R.id.eSongay1);
                thanhtien1 = mview.findViewById(R.id.ethanhtien1);

                alert.setView(mview);
                hoten1.setText(hoten.getText().toString());
                khachsan1.setText(khachsan.getText().toString());
                ngaydat1.setText(ngaydat.getText().toString());
                ngayden1.setText(ngayden.getText().toString());
                loaiphong1.setText(loaiphong.getText().toString());
                songay1.setText(songay.getText().toString());
                thanhtien1.setText(thanhtien.getText().toString());
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);

                btn_Huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String Khachsan2 = khachsan1.getText().toString();
                        String Hoten2 = hoten1.getText().toString();
                        Date NgayDat2 = null;
                        try {
                            NgayDat2 = new SimpleDateFormat("yyyy/MM/dd").parse(ngaydat1.getText().toString());
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        Date NgayDen2 = null;
                        try {
                            NgayDen2 = new SimpleDateFormat("yyyy/MM/dd").parse(ngayden1.getText().toString());
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        Integer SoNgay2 = Integer.parseInt(songay1.getText().toString());
                        Integer LoaiPhong2 = Integer.parseInt(loaiphong1.getText().toString());
                        Double ThanhTien2 = Double.parseDouble(thanhtien1.getText().toString());
                        Database db = new Database(getApplicationContext(),"bookinghotel",null,1);
                        db.booking_hotel(Khachsan2,Hoten2,NgayDat2, NgayDen2, LoaiPhong2, SoNgay2, ThanhTien2);
                        Toast.makeText(getApplicationContext(), "Đặt phòng thành công!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(DatPhong_Activity.this, Home_Activity.class));
                    }
                });
                alertDialog.show();

            }


        });

    }
    public void btn_showDialog(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(DatPhong_Activity.this);
        View mview = getLayoutInflater().inflate(R.layout.activity_thongbao,null);

        Button btnSubmit, btn_Huy;
        btn_Huy = mview.findViewById(R.id.btnHuy);
        btnSubmit = mview.findViewById(R.id.btnDat);
        hoten1 = mview.findViewById(R.id.eHoten1);
        khachsan1 = mview.findViewById(R.id.eKhachsan1);
        ngaydat1 = mview.findViewById(R.id.dtpNgaydat1);
        ngayden1 = mview.findViewById(R.id.dtpNgayden1);
        loaiphong1 = mview.findViewById(R.id.cboLoaiphong1);
        songay1 = mview.findViewById(R.id.eSongay1);
        thanhtien1 = mview.findViewById(R.id.ethanhtien1);




        alert.setView(mview);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        btn_Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        alertDialog.show();
    }
    public void Choose_DatetimePicker(){
        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePicker.show();
    }
    public void Choose_DatetimePicker_Den(){
        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePicker.show();
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String date_dat = ""+i +"/" + i1 + "/" +i2;
//        String date_den = ""+i +"/" + i1 + "/" +i2;
        ngaydat.setText(date_dat);
//        ngayden.setText(date_den);
    }

    }

