package com.example.appbookinghotel;

import android.content.Context;

import com.example.appbookinghotel.Domain.HotelDomain;

import java.util.ArrayList;

public class Cart {
    public Cart(Context context) {
        this.context = context;
        this.tinyDB = tinyDB;
    }

    private Context context;
    private TinyDB  tinyDB;

    public void insertHotel(HotelDomain item){
        ArrayList<HotelDomain> listhotel = getlistCard();
        boolean existAlready = false;
        int n = 0;
        for(int y=0; y<listhotel.size();y++){
            if(listhotel.get(y).getTitle().equals(item.getTitle())){
                existAlready = true;
                n = y;
                break;
            }
        }
        if(existAlready){
            listhotel.get(n).setNumberincart(item.getNumberincart());
        }else{
            listhotel.add(item);
        }
    }
    public ArrayList<HotelDomain> getlistCard(){
        return tinyDB.getListObject("CartList");
    }
}
