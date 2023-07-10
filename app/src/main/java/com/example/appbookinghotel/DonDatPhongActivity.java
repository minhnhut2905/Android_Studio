package com.example.appbookinghotel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbookinghotel.Domain.DatPhongDomain;

import java.util.ArrayList;

public class DonDatPhongActivity extends AppCompatActivity {
    private ListView listView;
    private SQLiteDatabase db ;
    private ArrayAdapter<DatPhongDomain> adapter;
    private ArrayList<DatPhongDomain> datphongList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_dat_cho);
        listView = findViewById(R.id.listview_hotel);
        adapter = new ArrayAdapter<DatPhongDomain>(this,0,datphongList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.hotel_item,null);

                TextView txtId = convertView.findViewById(R.id.txtId);
                TextView txtHoten = convertView.findViewById(R.id.txtHoten);
                TextView txtThanhtien = convertView.findViewById(R.id.txtThanhtien);
                TextView txtTenkhachsan = convertView.findViewById(R.id.txtTenkhachsan);

                DatPhongDomain datPhongDomain= datphongList.get(position);
                txtId.setText(datPhongDomain.getiId());
                txtHoten.setText(datPhongDomain.getsHoten());
                txtThanhtien.setText(String.valueOf(datPhongDomain.getDthanhtien()));
                txtTenkhachsan.setText(datPhongDomain.getStenkhachsan());
                return convertView;
            }
        };

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                datphongList.remove(i);
                adapter.notifyDataSetChanged();
//                return false;
            }
        });

        loadData();
    }
    public void loadData(){
        datphongList.clear();
        String sql = "SELECT * FROM tbl_booking_hotel";
//        SQLiteDatabase db. getReadableDatabase;

//        Cursor cursor = db.rawQuery("SELECT * FROM tbl_booking_hotel",null);
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String hoten = cursor.getString(1);
            String tenkhachsan = cursor.getString(2);
            double thanhtien = cursor.getDouble(3);
//            Date ngaydat = cursor.get

            DatPhongDomain datPhongDomain = new DatPhongDomain();
            datPhongDomain.setiId(id);
            datPhongDomain.setsHoten(hoten);
            datPhongDomain.setStenkhachsan(tenkhachsan);
            datPhongDomain.setDthanhtien(thanhtien);

            datphongList.add(datPhongDomain);
            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();
    }
    private void delete(int position){
        int id = datphongList.get(position).getiId();
        String sql = "DELETE FROM tbl_booking_hotel WHERE _id = " + id;
        db.execSQL(sql);
    }

}
