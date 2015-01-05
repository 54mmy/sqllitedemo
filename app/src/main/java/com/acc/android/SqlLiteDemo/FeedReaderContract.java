package com.acc.android.SqlLiteDemo;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Sagar Gopale on 12/27/2014.
 */
public class FeedReaderContract {
    public FeedReaderContract(){

    }
    public static final String AUTHORITY = "com.acc.android.SqlLiteDemo.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static class CommonColumns implements BaseColumns{
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
    }

    public static abstract class Employee extends CommonColumns {
        public static final String TABLE_NAME = "employee";
        public static final Uri CONTENT_URI= Uri.withAppendedPath(FeedReaderContract.CONTENT_URI, TABLE_NAME);
    }

    public static abstract class Student extends CommonColumns {
        public static final String TABLE_NAME = "student";
        public static final Uri CONTENT_URI= Uri.withAppendedPath(FeedReaderContract.CONTENT_URI, TABLE_NAME);
    }

    public static abstract class Vendor extends CommonColumns {
        public static final String TABLE_NAME = "vendor";
        public static final Uri CONTENT_URI= Uri.withAppendedPath(FeedReaderContract.CONTENT_URI, TABLE_NAME);
    }
}
