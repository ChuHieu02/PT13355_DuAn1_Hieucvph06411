package com.poly.chuhieu.pt13355_duan1_hieucvph06411.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.poly.chuhieu.pt13355_duan1_hieucvph06411.R;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.adapter.SanPhamAdapter;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.model.SanPham;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao.SanPhamDAO;

import java.util.ArrayList;
import java.util.List;

public class SanPhamActivity extends AppCompatActivity {
    Toolbar tbTypeBook;

    ListView lvTypeBook;

    public static List<SanPham> arrTypeBook = new ArrayList<>();
    SanPhamAdapter adapter = null;
    SanPhamDAO typeBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        tbTypeBook = findViewById(R.id.toolbar);
        lvTypeBook = findViewById(R.id.lvType);
//        registerForContextMenu(lvTypeBook);
        setSupportActionBar(tbTypeBook);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        typeBookDAO = new SanPhamDAO(this);
        arrTypeBook = typeBookDAO.getAllTypeBook();
        adapter = new SanPhamAdapter(this, arrTypeBook);
        lvTypeBook.setAdapter(adapter);
        lvTypeBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SanPhamActivity.this, SuaSPActivity.class);
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
        startActivity(new Intent(SanPhamActivity.this, AddSPActivity.class));

    }
}
