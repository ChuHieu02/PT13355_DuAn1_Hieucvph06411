package com.poly.chuhieu.pt13355_duan1_hieucvph06411;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.widget.MaskEditText;

public class ThongKeActivity extends AppCompatActivity {

    EditText edtongthu,edtongchi;
    TextView tvloinhuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        edtongchi = findViewById(R.id.edtongchi);
        edtongthu = findViewById(R.id.edtongthu);
        tvloinhuan = findViewById(R.id.tvloinhuan);


    }

    public void tinhloinhuan(View view) {


            if (edtongchi.length()==0 || edtongthu.length()==0 ){
                edtongthu.setError("Điền Thông tin");
                edtongchi.setError("Điền Thông tin");
            }else {
            String tongthu = edtongthu.getText().toString();
            String tongchi = edtongchi.getText().toString();

            Double tongthudb = Double.parseDouble(tongthu);
            Double tongchidb = Double.parseDouble(tongchi);
            Double tongloinhuan = (tongthudb * 10/100) - tongchidb;
            tvloinhuan.setText(String.valueOf(tongloinhuan));
        }

    }
}
