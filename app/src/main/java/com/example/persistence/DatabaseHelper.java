package com.example.persistence;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String ENTRY_TABLE = "ENTRY_TABLE";
    public static final String COLUMN_ENTRY_NAME = "ENTRY_NAME";
    public static final String COLUMN_ENTRY_LASTNAME = "ENTRY_LASTNAME";
    public static final String COLUMN_ENTRY_AGE = "ENTRY_AGE";
    public static final String COLUMN_ID = "ID";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EntryDataBase.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + ENTRY_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ENTRY_NAME + " TEXT,  " +  COLUMN_ENTRY_LASTNAME + " TEXT, " +  COLUMN_ENTRY_AGE + " TEXT )";
        sqLiteDatabase.execSQL(createTable) ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }





}
