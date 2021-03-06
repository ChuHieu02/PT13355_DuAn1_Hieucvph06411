package com.poly.chuhieu.pt13355_duan1_hieucvph06411.sqlitedao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poly.chuhieu.pt13355_duan1_hieucvph06411.database.DatabaseHelper;
import com.poly.chuhieu.pt13355_duan1_hieucvph06411.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    private SQLiteDatabase dbb;
    private DatabaseHelper dbHelperr;
    public static final String TABLE_NAME = " NhanVien2";
    public static final String SQL_TYPEBOOKK = "CREATE TABLE NhanVien2 ( idtypebook text primary key, typename text, location int,noti text);";
    public static final String TAG = "TypeBookDAO";

    public NhanVienDAO(Context context) {
        dbHelperr = new DatabaseHelper(context);
        dbb = dbHelperr.getWritableDatabase();
    }


    //insert
    public int insertTypeBook(NhanVien typeBook) {
        ContentValues values = new ContentValues();
        values.put("idtypebook", typeBook.getIdTypeBook());
        values.put("typename", typeBook.getTypeName());
        values.put("location", typeBook.getLocation());
        values.put("noti", typeBook.getNoti());
        try {
            if (dbb.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public List<NhanVien> getAllTypeBook() {
        List<NhanVien> typeBookList = new ArrayList<>();
        Cursor c = dbb.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NhanVien ee = new NhanVien();
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

    public NhanVien getTypeBook(String idtypebook) {
        List<NhanVien> typeBookList = new ArrayList<>();
        NhanVien ee = new NhanVien();
        Cursor c = dbb.query(TABLE_NAME, null, null, null, null, null, null);
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
        int result = dbb.update(TABLE_NAME, values, "idtypebook=?", new
                String[]{idTypeBook});
        if (result == 0) {
            return -1;
        }
        return 1;

    }



    //delete
    public int deleteTypeBookByID(String idtypebook) {
        int result = dbb.delete(TABLE_NAME,"idtypebook=?",new String[]{idtypebook});
        if (result == 0)
            return -1;
        return 1;
    }


}
