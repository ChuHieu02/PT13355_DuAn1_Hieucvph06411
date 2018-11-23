package com.poly.chuhieu.pt13355_duan1_hieucvph06411;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AutoCompleteTextView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DangNhap_Activity extends AppCompatActivity {
    private EditText edusername, edpassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        edusername = findViewById(R.id.edusername);
        edpassword = findViewById(R.id.edpassword);
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail = edusername.getText().toString();
                String mPass = edpassword.getText().toString();
                if (mEmail.equals("admin") && mPass.equals("admin")) {
                    startActivity(new Intent(DangNhap_Activity.this,Home.class));
                } else {
                    Toast.makeText(DangNhap_Activity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

