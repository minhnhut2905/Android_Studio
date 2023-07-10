package com.example.appbookinghotel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_activity extends AppCompatActivity {
    EditText eUserName, ePassword;
    Button btnDangNhap;
    TextView txtDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUserName = findViewById(R.id.eUserName);
        ePassword = findViewById(R.id.ePassword);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        txtDangKy = findViewById(R.id.txtDangKy);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = eUserName.getText().toString();
                String password = ePassword.getText().toString();
                Database db = new Database(getApplicationContext(),"bookinghotel",null,1);
                if(username.length() == 0 || password.length() ==0){
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập tên đăng nhập hoặc mật khẩu!!!!",Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(username, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(Login_activity.this,Home_Activity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Email hoặc mật khẩu không chính xác.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_activity.this,Register_Activity.class));
            }
        });
    }
}
