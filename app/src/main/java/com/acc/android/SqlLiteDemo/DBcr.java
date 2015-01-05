package com.acc.android.SqlLiteDemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sagar Gopale on 12/27/2014.
 */
public class DBcr extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1 ;
    private static final String DATABASE_NAME = "login.db";
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ", ";
    private static final String CREATE_CMD = "CREATE TABLE ";
    private static final String END_CMD = ");";
    public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS";

/*
    public static final String CREATE_EMP = String.format(CREATE_CMD, FeedReaderContract.Employee.TABLE_NAME)+
            String.format(FeedReaderContract.Employee.USERNAME, COMMA_SEP)+
            String.format(FeedReaderContract.Employee.PASSWORD)+
            END_CMD;

    public static final String CREATE_STUDENT = String.format(CREATE_CMD, FeedReaderContract.Student.TABLE_NAME)+
            String.format(FeedReaderContract.Student.USERNAME, COMMA_SEP)+
            String.format(FeedReaderContract.Student.PASSWORD)+
            END_CMD;

    public static final String CREATE_VENDOR = String.format(CREATE_CMD, FeedReaderContract.Vendor.TABLE_NAME)+
            String.format(TEXT_TYPE, FeedReaderContract.Vendor.USERNAME, COMMA_SEP)+
            String.format(TEXT_TYPE, FeedReaderContract.Vendor.PASSWORD )+
            END_CMD; */

    public static final String CREATE_EMP = CREATE_CMD + FeedReaderContract.Employee.TABLE_NAME + "(" + FeedReaderContract.CommonColumns.USERNAME + " TEXT " + COMMA_SEP + FeedReaderContract.CommonColumns.PASSWORD + " TEXT " + END_CMD ;
    public static final String CREATE_STUDENT = CREATE_CMD + FeedReaderContract.Student.TABLE_NAME + "(" + FeedReaderContract.CommonColumns.USERNAME + " TEXT " + COMMA_SEP + FeedReaderContract.CommonColumns.PASSWORD + " TEXT " + END_CMD ;
    public static final String CREATE_VENDOR = CREATE_CMD + FeedReaderContract.Vendor.TABLE_NAME + "(" + FeedReaderContract.CommonColumns.USERNAME + " TEXT " + COMMA_SEP + FeedReaderContract.CommonColumns.PASSWORD + " TEXT " + END_CMD ;

    public DBcr(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMP);
        db.execSQL(CREATE_STUDENT);
        db.execSQL(CREATE_VENDOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format(DROP_TABLE_SQL,FeedReaderContract.Employee.TABLE_NAME));
        db.execSQL(String.format(DROP_TABLE_SQL,FeedReaderContract.Student.TABLE_NAME));
        db.execSQL(String.format(DROP_TABLE_SQL,FeedReaderContract.Vendor.TABLE_NAME));
        onCreate(db);
    }
}

