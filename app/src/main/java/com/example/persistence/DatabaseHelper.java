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


    public boolean addOne(EntryItem item){

        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ENTRY_NAME, item.getName());
        cv.put(COLUMN_ENTRY_LASTNAME, item.getLastName());
        cv.put(COLUMN_ENTRY_AGE, item.getAge());

        long insert = db.insert(ENTRY_TABLE, null, cv);
        if( insert == -1){
            return false;
        } else {
            return true;
        }

    }

    public List<EntryItem> getAll(){
        List<EntryItem> returnList = new ArrayList<>();

        String query =  "SELECT * FROM " + ENTRY_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){

            do {
                int ID = cursor.getInt(0);
                String name = cursor.getString(1);
                String lastName = cursor.getString(2);
                int age = cursor.getInt(3);

                EntryItem newEntry = new EntryItem(ID, name, lastName, age);
                returnList.add(newEntry);
            } while(cursor.moveToNext());

            //Log.i();
        } else {

        }
        cursor.close();
        db.close();
        return returnList;
    }


}
