package com.example.ps10826_maixuanhuy_asm1.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ps10826_maixuanhuy_asm1.model.KhoaHoc;

import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO {

    SQLiteDatabase db;

    public static final String TABLE_NAME = "khoa_hoc";
    public static final String COLUMN_NAME_MA_KH = "ma_kh";
    public static final String COLUMN_NAME_TEN_KH = "ten_kh";
    public static final String COLUMN_NAME_LICH_TRINH = "lich_trinh";
    public static final String COLUMN_NAME_LOP = "lop";

    public static final String CREATE_TABLE_KHOA_HOC = "CREATE TABLE " + TABLE_NAME +" (" +
            COLUMN_NAME_MA_KH + " VARCHAR , " +
            COLUMN_NAME_TEN_KH + " VARCHAR NOT NULL, " +
            COLUMN_NAME_LICH_TRINH + " VARCHAR NOT NULL, " +
            COLUMN_NAME_LOP + " VARCHAR NOT NULL " +
            " );";

    public static final String THEM1 = "INSERT INTO " + TABLE_NAME + " VALUES ('KH01','Khoa hoc lap trinh','23/4/2020 - 23/7/2020','LT15101');";
    public static final String THEM2 = "INSERT INTO " + TABLE_NAME + " VALUES ('KH02','Khoa hoc lap trinh','09/05/2020 - 29/12/2020','KN15101');";
    public static final String THEM3 = "INSERT INTO " + TABLE_NAME + " VALUES ('KH03','Khoa hoc tieng anh','16/05/2020 - 26/09/2020','EN15101');";
    public static final String THEM4 = "INSERT INTO " + TABLE_NAME + " VALUES ('KH04','Khoa hoc quan ly nhan su','14/02/2020 - 14/7/2020','QL15101');";
    public static final String THEM5 = "INSERT INTO " + TABLE_NAME + " VALUES ('KH05','Khoa hoc makerting','04/03/2020 - 23/08/2020','MK15101');";


    public static final String DROP_TABLE_KHOA_HOC = " DROP TABLE IF EXISTS " + TABLE_NAME;

    public KhoaHocDAO(SQLiteDatabase db){
        this.db = db;
    }


    public List readAll(){
        List khoaHocs = new ArrayList();
        String[] columns = {COLUMN_NAME_MA_KH, COLUMN_NAME_TEN_KH, COLUMN_NAME_LICH_TRINH, COLUMN_NAME_LOP};

        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);

        while (cursor.moveToNext()){
            khoaHocs.add(new KhoaHoc(cursor.getString(cursor.getColumnIndex(COLUMN_NAME_MA_KH)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME_TEN_KH)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME_LICH_TRINH)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME_LOP))));
        }
        return khoaHocs;
    }
}
