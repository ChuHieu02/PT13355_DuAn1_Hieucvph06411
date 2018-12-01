package com.poly.chuhieu.pt13355_duan1_hieucvph06411.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.poly.chuhieu.pt13355_duan1_hieucvph06411.R;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.model.NhanVien;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao.NhanVienDAO;


public class AddNVActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    EditText edtIDType;
    EditText edtNameType;
    EditText edtLocationType;
    EditText edtInfoTypebook;
    NhanVienDAO typeBookDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_nhanvien);
        edtIDType = (EditText) findViewById(R.id.edtIDType);
        edtNameType = (EditText) findViewById(R.id.edtNameType);
        edtLocationType = (EditText) findViewById(R.id.edtLocationType);
        edtInfoTypebook = (EditText) findViewById(R.id.edtInfoTypebook);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void addtypebook(View view) {
        if (edtIDType.getText().length() == 0 ||
                edtNameType.getText().length() == 0 ||
                edtLocationType.getText().length() == 0 ||
                edtInfoTypebook.getText().length() == 0) {
            Toast.makeText(this, "Bạn phải nhập đủ thông tin ", Toast.LENGTH_SHORT).show();

        } else {
            typeBookDAO = new NhanVienDAO(this);
            NhanVien typeBook = new NhanVien(edtIDType.getText().toString(),
                    edtNameType.getText().toString(),
                    Integer.parseInt(edtLocationType.getText().toString()), edtInfoTypebook.getText().toString());
            try {
                if (validateForm() > 0) {
                    if (typeBookDAO.insertTypeBook(typeBook) > 0) {
                        Toast.makeText(getApplicationContext(), "Thêm thành công",
                                Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Thêm thất bại",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception ex) {
                Log.e("Error", ex.toString());
            }
        }

    }

    public int validateForm() {
        int check = 1;
        if (edtIDType.getText().length() == 0 ||
                edtNameType.getText().length() == 0 ||
                edtLocationType.getText().length() == 0 ||
                edtLocationType.getText().length() == 0) {
            Toast.makeText(this, "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
