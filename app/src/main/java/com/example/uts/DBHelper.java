package com.example.uts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Vector;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "inazuma.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table user (userId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT, " +
                "email TEXT, " +
                "password TEXT,  " +
                "phone TEXT)");

        DB.execSQL("create table transactions " +
                "(transactionId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "userId Integer," +
                "matchId Integer," +
                "matchDate TEXT," +
                "namaTimKiri TEXT," +
                "namaTimKanan TEXT," +
                "transactionDate TEXT," +
                "ticketQty TEXT," +
                "FOREIGN KEY (userId) REFERENCES user(userId) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop table if exists user");
        DB.execSQL("drop table if exists transactions");
    }


    public Boolean insertUserData(String name, String email, String password, String phone){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Email", email);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        long check = DB.insert("user", null, contentValues);

        if (check == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean insertTransactionData(Integer userId, Integer matchId, String matchDate,
                                         String namaTimKiri, String namaTimKanan, String transactionDate, String ticketQty){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", userId);
        contentValues.put("matchId", matchId);
        contentValues.put("matchDate", matchDate);
        contentValues.put("namaTimKiri", namaTimKiri);
        contentValues.put("namaTimKanan", namaTimKanan);
        contentValues.put("transactionDate", transactionDate);
        contentValues.put("ticketQty", ticketQty);
        long check = DB.insert("transactions", null, contentValues);

        if (check == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where email = ?", new String[]{email});

        if(cursor.getCount() > 0){
            return false;
        }
        else {
            return true;
        }
    }

    public Integer checkEmailPass(String email, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where email = ? and password = ?", new String[]{email, password});


        if(cursor.getCount() > 0){
            cursor.moveToNext();
            return cursor.getInt(0);
        }
        else {
            return 0;
        }
    }

    public Cursor  getData(String userId){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("select * from  transactions where userId = ?", new String[]{userId});
        return  cursor;
    }

}
