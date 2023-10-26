package com.example.studata;

import static com.example.studata.ResponceCodefirIntent.ADDRESS;
import static com.example.studata.ResponceCodefirIntent.CLASS;
import static com.example.studata.ResponceCodefirIntent.FULLNAME;
import static com.example.studata.ResponceCodefirIntent.MOBILE;
import static com.example.studata.ResponceCodefirIntent.REGISTRATIONNO;
import static com.example.studata.ResponceCodefirIntent.TABLE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "Database";
    static final int DB_VERSION = 1;
    private static final String CREATE_TABLE = "create table "+ TABLE_NAME +"( "+ REGISTRATIONNO +" TEXT PRIMARY KEY, "+ FULLNAME +" TEXT , " + CLASS + " TEXT , " + ADDRESS + " TEXT , " + MOBILE + " TEXT );";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
