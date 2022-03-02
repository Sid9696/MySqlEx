package com.example.mysqlex;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelphar extends SQLiteOpenHelper {

    private static final String DBName="StudentData";
    private static final String TableName="Studentinfo";
    private static final String ColName="Studentname";
    private static final String CollRoll="Studoroll";
    private static final String Collcourse="Studocourse";
    private static final int DBVersion=1;


    public Dbhelphar(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Q1="CREATE TABLE "+TableName+"( "+
                ColName+" TEXT, "+
                CollRoll+" INTEGER, "+
                Collcourse+" TEXT ) ";
        sqLiteDatabase.execSQL(Q1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addStudent(String name1, String roll, String course) {

        SQLiteDatabase detabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ColName,name1);
        contentValues.put(CollRoll,roll);
        contentValues.put(Collcourse,course);

        long result=detabase.insert(TableName,null,contentValues);
        //detabase.close();
        if (result==-1) {
            return false;
        }
        else {
            return true;
        }

    }

    public boolean deleteStudent(String name1) {

        SQLiteDatabase database=this.getWritableDatabase();
        long reslt=database.delete(TableName,ColName+"=?",new String[]{ name1});

        if (reslt==-1) {
            return false;
        }
        else {
            return true;
        }
    }
}
