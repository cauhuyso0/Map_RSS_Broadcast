package com.example.ps10826_maixuanhuy_asm1.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ps10826_maixuanhuy_asm1.dao.KhoaHocDAO;

public class Helper extends SQLiteOpenHelper {
    public static final String DB_NAME = "ql_khoa_hoc";
    public static final int DB_VERSION = 11;


    public Helper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(KhoaHocDAO.CREATE_TABLE_KHOA_HOC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(KhoaHocDAO.DROP_TABLE_KHOA_HOC);
        db.execSQL(KhoaHocDAO.CREATE_TABLE_KHOA_HOC);
        db.execSQL(KhoaHocDAO.THEM1);
        db.execSQL(KhoaHocDAO.THEM2);
        db.execSQL(KhoaHocDAO.THEM3);
        db.execSQL(KhoaHocDAO.THEM4);
        db.execSQL(KhoaHocDAO.THEM5);


    }
}
