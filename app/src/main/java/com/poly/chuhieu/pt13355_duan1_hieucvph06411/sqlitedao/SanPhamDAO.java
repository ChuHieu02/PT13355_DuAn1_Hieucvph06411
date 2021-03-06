package com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poly.chuhieu.pt13355_duan1_hieucvph06411.database.DatabaseHelper;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    public static final String TABLE_NAME = "NhanVien";
    public static final String SQL_TYPEBOOK = "CREATE TABLE NhanVien (idtypebook text primary key, typename text, location int,noti text);";
    public static final String TAG = "TypeBookDAO";

    public SanPhamDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    //insert
    public int insertTypeBook(SanPham typeBook) {
        ContentValues values = new ContentValues();
        values.put("idtypebook", typeBook.getIdTypeBook());
        values.put("typename", typeBook.getTypeName());
        values.put("location", typeBook.getLocation());
        values.put("noti", typeBook.getNoti());
        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<SanPham> getAllTypeBook() {
        List<SanPham> typeBookList = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            SanPham ee = new SanPham();
            ee.setIdTypeBook(c.getString(0));
            ee.setTypeName(c.getString(1));
            ee.setLocation(c.getInt(2));
            ee.setNoti(c.getString(3));
            typeBookList.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return typeBookList;
    }

    public SanPham getTypeBook(String idtypebook) {
        List<SanPham> typeBookList = new ArrayList<>();
        SanPham ee = new SanPham();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {

            ee.setIdTypeBook(c.getString(0));
            ee.setTypeName(c.getString(1));
            ee.setLocation(c.getInt(2));
            ee.setNoti(c.getString(3));
            typeBookList.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return ee;
    }

    public int updateTypeBook(String idTypeBook, String typeName, String Locatin, String Noti) {
        ContentValues values = new ContentValues();
        values.put("idtypebook", idTypeBook);
        values.put("typename",typeName );
        values.put("location",Locatin );
        values.put("noti", Noti);
        int result = db.update(TABLE_NAME, values, "idtypebook=?", new
                String[]{idTypeBook});
        if (result == 0) {
            return -1;
        }
        return 1;

    }



    //delete
    public int deleteTypeBookByID(String idtypebook) {
        int result = db.delete(TABLE_NAME,"idtypebook=?",new String[]{idtypebook});
        if (result == 0)
            return -1;
        return 1;
    }


}
