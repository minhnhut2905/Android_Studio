package com.example.appbookinghotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(usersname text, email text, password text)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 = "CREATE TABLE tbl_booking_hotel(_id integer primary key autoincrement, tenkhachsan text, hoten text, ngaydat date, ngayden date, songaydat integer, loaiphong integer, thanhtien integer)";
        sqLiteDatabase.execSQL(qry2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put("usersname",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login (String username,String password){
        int result =0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c= db.rawQuery("SELECT * FROM users WHERE usersname=? AND password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }
    public void booking_hotel(String tenkhachsan, String hoten, Date ngaydat, Date ngayden, int songaydat, int loaiphong, double thanhtien){
        ContentValues cv = new ContentValues();
        cv.put("tenkhachsan",tenkhachsan);
        cv.put("hoten",tenkhachsan);
        cv.put("ngaydat", new Date().getTime());
        cv.put("ngayden", new Date().getTime());
        cv.put("songaydat",songaydat);
        cv.put("loaiphong",loaiphong);
        cv.put("thanhtien",thanhtien);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("tbl_booking_hotel",null,cv);
        db.close();
    }

}
