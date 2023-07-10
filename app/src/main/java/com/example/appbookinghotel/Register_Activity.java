package com.example.appbookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {
    EditText editUserName, editEmail, editPassword, editConfirmPassword;
    Button btnDangKy;
    TextView txtDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editUserName = findViewById(R.id.eRegisterUsername);
        editEmail = findViewById(R.id.eRegisterEmail);
        editPassword = findViewById(R.id.eRegisterPassword);
        editConfirmPassword = findViewById(R.id.eRegisterConfirmPassword);
        btnDangKy = findViewById(R.id.btnDangKy);
        txtDangNhap = findViewById(R.id.txtDangNhap);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUserName.getText().toString();
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                String confirmpassword = editConfirmPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"bookinghotel",null,1);
                if (email.length() == 0 || password.length() == 0 || username.length()
                        == 0 || confirmpassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập email hoặc mật khẩu!!!!", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmpassword) == 0) {
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register_Activity.this, Login_activity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Mật khẩu tối thiểu phải 8 kí tự, có ít nhất 1 chữ cái và kí tự đặc biệt!!!!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Mật khẩu và Mật khẩu xác nhận không khớp! Vui lòng thử lại!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register_Activity.this, Login_activity.class));
            }
        });
    }
    public static boolean isValid(String passwordhere) {
    int f1 =0,f2=0,f3 =0;
    if(passwordhere.length()<8){
        return false;
    }else {
        for (int p = 0; p < passwordhere.length(); p++) {
            if (Character.isLetter(passwordhere.charAt(p))) {
                f1 = 1;
            }
        }
        for (int r = 0; r < passwordhere.length(); r++) {
            if (Character.isDigit(passwordhere.charAt(r))) {
                f2 = 1;
            }
        }
        for (int s = 0; s < passwordhere.length(); s++) {
            char c = passwordhere.charAt(s);
            if (c >= 33 && c <= 46 || c == 64) {
                f3 = 1;
            }
        }
        if (f1 == 1 && f2 == 1 && f3 == 1)
            return true;
        return false;
    }
    }
}
