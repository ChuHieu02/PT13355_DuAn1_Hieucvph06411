package com.poly.chuhieu.pt13355_duan1_hieucvph06411.model;

public class SanPham {
    private String idTypeBook;
    private String typeName;
    private int location;
    private String noti;

    public SanPham() {

    }

    public SanPham(String idTypeBook, String typeName, int location, String noti) {
        this.idTypeBook = idTypeBook;
        this.typeName = typeName;
        this.location = location;
        this.noti = noti;
    }

    public String getIdTypeBook() {
        return idTypeBook;
    }

    public void setIdTypeBook(String idTypeBook) {
        this.idTypeBook = idTypeBook;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getNoti() {
        return noti;
    }

    public void setNoti(String noti) {
        this.noti = noti;
    }

    @Override
    public String toString() {
        return  getIdTypeBook()+" | "+getTypeName();
    }
}

