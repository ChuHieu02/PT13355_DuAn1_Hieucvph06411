package com.poly.chuhieu.pt13355_duan1_hieucvph06411.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao.NhanVienDAO;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao.SanPhamDAO;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NamiStore";
    public DatabaseHelper(Context context) {
        super(context, "DATABASE_NAME", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SanPhamDAO.SQL_TYPEBOOK);
        db.execSQL(NhanVienDAO.SQL_TYPEBOOKK);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SanPhamDAO.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + NhanVienDAO.TABLE_NAME);

    }

}
