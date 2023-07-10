package com.example.appbookinghotel;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class ThongBao_Activity extends DialogFragment {
    private  static  final String TAG = "Thông Báo Đặt Phòng";
    Button btnSubmit, btn_Huy;
    EditText hoten1, khachsan1, ngaydat1, ngayden1, loaiphong1, songay1, thanhtien1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_thongbao, container, false);

        btn_Huy = view.findViewById(R.id.btnHuy);
        btnSubmit = view.findViewById(R.id.btnDat);
        hoten1 = view.findViewById(R.id.eHoten1);
        khachsan1 = view.findViewById(R.id.eKhachsan1);
        ngaydat1 = view.findViewById(R.id.dtpNgaydat1);
        ngayden1 = view.findViewById(R.id.dtpNgayden1);
        loaiphong1 = view.findViewById(R.id.cboLoaiphong1);
        songay1 = view.findViewById(R.id.eSongay1);
        thanhtien1 = view.findViewById(R.id.ethanhtien1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btn_Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: closing dialog");
                getDialog().dismiss();
            }
        });
        return view;
    }

}

