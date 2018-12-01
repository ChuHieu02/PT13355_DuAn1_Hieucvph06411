package com.poly.chuhieu.pt13355_duan1_hieucvph06411.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.poly.chuhieu.pt13355_duan1_hieucvph06411.Home;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.R;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.adapter.NhanVienAdapter;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.model.NhanVien;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao.NhanVienDAO;

import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends AppCompatActivity {
    Toolbar tbTypeBook;

    ListView lvTypeBook;

    public static List<NhanVien> arrTypeBook = new ArrayList<>();
    NhanVienAdapter adapter = null;
    NhanVienDAO typeBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);

        tbTypeBook = findViewById(R.id.toolbar);
        lvTypeBook = findViewById(R.id.lvType);
//        registerForContextMenu(lvTypeBook);
        setSupportActionBar(tbTypeBook);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        typeBookDAO = new NhanVienDAO(this);
        arrTypeBook = typeBookDAO.getAllTypeBook();
        adapter = new NhanVienAdapter(this, arrTypeBook);
        lvTypeBook.setAdapter(adapter);
        lvTypeBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NhanVienActivity.this, SuaNVActivity.class);
                Bundle b = new Bundle();
                b.putString("ID", arrTypeBook.get(position).getIdTypeBook());
                b.putString("NAME", arrTypeBook.get(position).getTypeName());
                b.putString("LOCATION", String.valueOf(arrTypeBook.get(position).getLocation()));
                b.putString("NOTI", arrTypeBook.get(position).getNoti());
                intent.putExtras(b);
                startActivity(intent);
            }
        });


        tbTypeBook.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
//
    @Override
    protected void onResume() {
        arrTypeBook.clear();
        arrTypeBook = typeBookDAO.getAllTypeBook();
        adapter.changeDataset(arrTypeBook);
        super.onResume();
    }

    public void addType(View view) {
        startActivity(new Intent(NhanVienActivity.this,AddNVActivity.class));

    }

    public void back(View view) {
        Intent intent = new Intent(NhanVienActivity.this, Home.class);
        startActivity(intent);
    }
}
