package com.example.appbookinghotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbookinghotel.Adapter.HotelListAdapter;
import com.example.appbookinghotel.Domain.HotelDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {
private RecyclerView.Adapter hotelListAdapter;
private RecyclerView rcv_Hotel;
TextView datngay, khachsan;
ImageView picKSan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        datngay = findViewById(R.id.txtDatNgay);
        khachsan = findViewById(R.id.txtKhachSan);
        picKSan = findViewById(R.id.picKhachSan);
        datngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Danh sách khách sạn",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this, ListHotel_Activity.class));
            }
        });
        picKSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Danh sách khách sạn",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this, ListHotel_Activity.class));
            }
        });
        khachsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Danh sách khách sạn",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this, ListHotel_Activity.class));
            }
        });
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        startActivity(new Intent(Home_Activity.this,Home_Activity.class));
                        break;
                    case R.id.action_dondatcho:
                        startActivity(new Intent(Home_Activity.this,DonDatPhongActivity.class));
                }
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<HotelDomain> items = new ArrayList<>();
        items.add(new HotelDomain("Chung Cư Marina", "Nằm ở vị trí trung tâm tại Long Xuyên của Long Xuyên, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. Chỗ nghỉ 5 sao này được trang bị các tiện nghi ngay trong khuôn viên để nâng cao " +
                "chất lượng và niềm vui cho kỳ nghỉ của quý khách." +
                "1 giường đôi nhỏ\n" +
                "Hướng phòng: Ngoài trời\n" +
                "Diện tích phòng: 32 m²\n" +
                "Cho phép hút thuốc\n" +
                "1 phòng tắm\n" +
                "Vòi sen\n" +
                "Phòng tắm chung\n" +
                "Ban công/sân hiên\n" +
                "Bếp nhỏ", "marina_2g", 150000, 0, 3, 0, 0));
        items.add(new HotelDomain("The An hotel", "Nằm ở vị trí trung tâm tại Long Xuyên của Long Xuyên, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. " +
                "Chỗ nghỉ 5 sao này được trang bị các tiện nghi ngay trong khuôn viên để nâng cao chất lượng và niềm vui cho kỳ nghỉ của quý khách.", "bachahoangho", 150000, 0, 0, 3, 0));
        items.add(new HotelDomain("Khách Sạn Hòa Bình", "Số 130, đường Trần Hưng Đạo, phường Mỹ Bình, Long Xuyên, Long Xuyên, Việt Nam - TRÊN BẢN ĐỒ\n" +
                "Đỗ xe và Wi-Fi luôn miễn phí, vì vậy quý khách có thể giữ liên lạc, đến và đi tùy ý. " +
                "Nằm ở vị trí trung tâm tại Long Xuyên của Long Xuyên, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. " +
                "Được xếp hạng 4 sao, chỗ nghỉ chất lượng cao này cho phép khách nghỉ sử dụng mát-xa, xông khô và nhà hàng ngay trong khuôn viên.", "kshoabinh", 150000, 0, 0, 0, 0));
        items.add(new HotelDomain("Khách Sạn Châu Khương", "Khách sạn Châu Khương (Chau Khuong Hotel)\n" +
                "02 Ha Hoang Ho My Binh Long Xuyen An Giang, Long Xuyên, Long Xuyên, Việt Nam, 90000 - TRÊN BẢN ĐỒ\n" +
                "Nằm ở vị trí trung tâm tại Long Xuyên của Long Xuyên, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. " +
                "Như một lợi ích thêm, phòng tập có sẵn ngay trong khuôn viên nghỉ để phục vụ nhu cầu của quý khách một cách thuận tiện.", "kshoabinh", 150000, 0, 0, 3, 0));
        items.add(new HotelDomain("Mộc Homestay 5 star", "Căn hộ 59 m² 2 phòng ngủ, 1 phòng tắm riêng ở Long Xuyên (Mộc Homestay 5)\n" +
                "Long Xuyên, Long Xuyên, Việt Nam - TRÊN BẢN ĐỒ\n" +
                "Hãy để chuyến đi của quý khách có một khởi đầu tuyệt vời khi ở lại khách sạn này, nơi có bãi đỗ xe miễn phí. " +
                "Nằm ở vị trí trung tâm tại Long Xuyên của Long Xuyên, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. " +
                "Chỗ nghỉ 4 sao này có phòng tập giúp cho kỳ nghỉ của quý khách thêm thư thái và đáng nhớ.", "mochomestay", 150000, 0, 0, 4, 0));
        items.add(new HotelDomain("Mộc HomeStay 2 star", "Căn hộ 32 m² 1 phòng ngủ, 1 phòng tắm riêng ở Long Xuyên (Mộc Homestay2)\n" +
                "Long Xuyên, Long Xuyên, Việt Nam - TRÊN BẢN ĐỒ\n" +
                "Hãy để chuyến đi của quý khách có một khởi đầu tuyệt vời khi ở lại khách sạn này, nơi có bãi đỗ xe miễn phí. Nằm ở vị trí trung tâm tại Long Xuyên của Long Xuyên, chỗ nghỉ này đặt quý khách ở gần các điểm thu hút và tùy chọn ăn uống thú vị. " +
                "Chỗ nghỉ 5 sao này có phòng tập giúp cho kỳ nghỉ của quý khách thêm thư thái và đáng nhớ.", "mochomestay", 150000, 0, 0, 4, 0));
        rcv_Hotel = findViewById(R.id.rcv_hotel);
        hotelListAdapter = new HotelListAdapter(items);
        rcv_Hotel.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rcv_Hotel.setAdapter(hotelListAdapter);

    }
}