package com.example.studata;
import static com.example.studata.ResponceCodefirIntent.REGISTRATIONNO;
import static com.example.studata.ResponceCodefirIntent.TABLE_NAME;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;
    public DBManager(Context c){
        context= c;
    }
    public DBManager open() throws SQLException{
    dbHelper=new DatabaseHelper(context);
    database=dbHelper.getWritableDatabase();
    return this;
    }
    public void insert(String registrationNumber,String fullname,String classname,String address,String mobile){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ResponceCodefirIntent.REGISTRATIONNO,registrationNumber);
        contentValues.put(ResponceCodefirIntent.FULLNAME,fullname);
        contentValues.put(ResponceCodefirIntent.CLASS,classname);
        contentValues.put(ResponceCodefirIntent.ADDRESS,address);
        contentValues.put(ResponceCodefirIntent.MOBILE,mobile);
        database.insert(TABLE_NAME,null,contentValues);
    }

    public Cursor fetch(){
        String[] columb=new String[]{ResponceCodefirIntent.REGISTRATIONNO,ResponceCodefirIntent.FULLNAME,ResponceCodefirIntent.CLASS,ResponceCodefirIntent.ADDRESS,ResponceCodefirIntent.MOBILE};
        Cursor cursor= database.query(TABLE_NAME,columb,null,null,null,null,null,null);

        return cursor;
    }
    public void deletedata(String registrationNumber){

        database.delete(TABLE_NAME,REGISTRATIONNO+" = ?", new String[]{registrationNumber});

    }
    public int update(String REGISTRATION_NO, String FULL_NAME,String _CLASS,String _ADDRESS,String _MOBILE) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ResponceCodefirIntent.FULLNAME, FULL_NAME);
        contentValues.put(ResponceCodefirIntent.CLASS, _CLASS);
        contentValues.put(ResponceCodefirIntent.ADDRESS, _ADDRESS);
        contentValues.put(ResponceCodefirIntent.MOBILE, _MOBILE);
        int i = database.update(TABLE_NAME, contentValues, ResponceCodefirIntent.REGISTRATIONNO + " = ?", new String[]{REGISTRATION_NO});
        return i;
    }



}
