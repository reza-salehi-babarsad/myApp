package com.retro.booklibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME ="Book_Library";
    private static final int  DATABASE_VERSION =1;

    private static final String TABLE_NAME ="MyLibrary";
    private static final String COLUMN_ID ="Book_Id";
    private static final String COLUMN_Title ="Book_Title";
    private static final String COLUMN_Author ="Book_Author";
    private static final String COLUMN_Pages ="Book_Pages";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =" CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT , "
                + COLUMN_Title + " TEXT," + COLUMN_Author + " TEXT," + COLUMN_Pages + " INTEGER);";
        db.execSQL(query);
        Toast.makeText(context, "TABLE CREATED ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }
    void AddBook(String title , String auther ,int pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_Title,title);
        cv.put(COLUMN_Author,auther);
        cv.put(COLUMN_Pages,pages);
        long result = db.insert(TABLE_NAME,null,cv);

        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Book Added Successfully", Toast.LENGTH_SHORT).show();
        }


    }
    Cursor ReadAllBook(){
        String query = "select * from " + TABLE_NAME ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if((db != null)){
            cursor=db.rawQuery(query,null);

        }
        return cursor;



    }
}
