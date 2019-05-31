package com.developer.rifky.mabooks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Rifky on 07-Jan-18.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String nama_db = "mabooks.db";
    private static final Integer versi_db = 1;

    public DataHelper(Context context) {
        super(context, nama_db, null, versi_db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE dafbuku (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "judul TEXT," +
                "peminjam TEXT," +
                "nohp TEXT," +
                "dipinjam TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS dafbuku");
        onCreate(sqLiteDatabase);
    }
}