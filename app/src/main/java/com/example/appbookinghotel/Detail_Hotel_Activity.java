package com.example.appbookinghotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appbookinghotel.Adapter.HotelListAdapter;
import com.example.appbookinghotel.Domain.HotelDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Detail_Hotel_Activity extends AppCompatActivity {
private Button btnDatNgay, btnThemGioHang;
private  TextView title, price, score, time, description, energy,numberordertxt, minusbtn, plusbtn;
private ImageView picAnh;
private HotelDomain object;
private int numberOrder = 1;
private Cart cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_hotel_activity);

        cart = new Cart(Detail_Hotel_Activity.this);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(Detail_Hotel_Activity.this, Detail_Hotel_Activity.class));
                        break;
                    case R.id.action_dondatcho:
                        startActivity(new Intent(Detail_Hotel_Activity.this,DonDatPhongActivity.class));
                }
            }
        });


        btnDatNgay =findViewById(R.id.btnDatPhong);
        btnThemGioHang = findViewById(R.id.btnThemGioHang);
        title = findViewById(R.id.txtTilte);
        price = findViewById(R.id.txtPrice);
        description = findViewById(R.id.txtDescription);
        score = findViewById(R.id.txtScore);
        energy = findViewById(R.id.txtenergy);
        time = findViewById(R.id.txtTime);
        picAnh = findViewById(R.id.picHotel);
        numberordertxt = findViewById(R.id.quantititxt);
        plusbtn = findViewById(R.id.Plustxt);
        minusbtn = findViewById(R.id.Minustxt);
        getBundle();
    }

    private void initRView() {
        btnDatNgay =findViewById(R.id.btnDatPhong);
        btnThemGioHang = findViewById(R.id.btnThemGioHang);
        title = findViewById(R.id.txtTilte);
        price = findViewById(R.id.txtPrice);
        description = findViewById(R.id.txtDescription);
        score = findViewById(R.id.txtScore);
        energy = findViewById(R.id.txtenergy);
        time = findViewById(R.id.txtTime);
        picAnh = findViewById(R.id.picHotel);
        numberordertxt = findViewById(R.id.quantititxt);
        plusbtn = findViewById(R.id.Plustxt);
        minusbtn = findViewById(R.id.Minustxt);
    }

    private void getBundle() {

        object=(HotelDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId= this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picAnh);
        title.setText(object.getTitle());
        price.setText(object.getPrice()+"vnđ");
        description.setText(object.getDescription());
        score.setText(object.getScore()+"sao");
        energy.setText(object.getEnergy()+"cal");
        time.setText(object.getTime()+"phút");
        numberordertxt.setText((object.getNumberincart())+"");
        plusbtn.setOnClickListener(view -> {
            numberOrder = numberOrder + 1;
            numberordertxt.setText(""+numberOrder);
        });
        minusbtn.setOnClickListener(view -> {
            numberOrder = numberOrder - 1;
            numberordertxt.setText(""+numberOrder);
        });
        btnThemGioHang.setOnClickListener(view -> {
            object.setNumberincart(numberOrder);
            cart.insertHotel(object);
        });
        btnDatNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Detail_Hotel_Activity.this, DatPhong_Activity.class));
            }
        });
    }
}