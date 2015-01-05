package com.acc.android.SqlLiteDemo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * Created by Sagar Gopale on 12/28/2014.
 */
public class DataProvider extends ContentProvider {

    private static final int emp = 1;
    private static final int student = 2;
    private static final int vendor = 3;

    DBcr d;

    private static final UriMatcher URI_MATCHER ;
    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(FeedReaderContract.AUTHORITY, "employee", emp);
        URI_MATCHER.addURI(FeedReaderContract.AUTHORITY, "student", student);
        URI_MATCHER.addURI(FeedReaderContract.AUTHORITY, "vendor", vendor);
    }

    @Override
    public boolean onCreate() {
        d = new DBcr(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        switch (URI_MATCHER.match(uri)) {
            case emp:
                qb.appendWhere(FeedReaderContract.Employee._ID + "=" + uri.getLastPathSegment());
                qb.setTables(FeedReaderContract.Employee.TABLE_NAME);
                break;

            case student:
                qb.appendWhere(FeedReaderContract.Student._ID + "=" + uri.getLastPathSegment());
                qb.setTables(FeedReaderContract.Student.TABLE_NAME);
                break;

            case vendor:
                qb.appendWhere(FeedReaderContract.Vendor._ID + "=" +uri.getLastPathSegment());
                qb.setTables(FeedReaderContract.Vendor.TABLE_NAME);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI :" + uri);

        }
        SQLiteDatabase db= d.getReadableDatabase();
        Cursor c = qb.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri _uri = null;
        long _id = 0;
         final SQLiteDatabase db= d.getWritableDatabase();

        switch (URI_MATCHER.match(uri))
        {
            case emp:
                _id = db.insert(FeedReaderContract.Employee.TABLE_NAME, null, values);
                if ( _id > 0)
                {
                    _uri = ContentUris.withAppendedId(FeedReaderContract.CONTENT_URI, _id);
                    getContext().getContentResolver().notifyChange(_uri,null);
                }

                break;

            case student:
                _id = db.insert(FeedReaderContract.Student.TABLE_NAME, null , values);
                if(_id > 0)
                {
                    _uri = ContentUris.withAppendedId(FeedReaderContract.CONTENT_URI, _id);
                    getContext().getContentResolver().notifyChange(_uri,null);
                }
                break;

            case vendor:
                _id = db.insert(FeedReaderContract.Vendor.TABLE_NAME, null, values);
                   if ( _id > 0)
                   {
                       _uri = ContentUris.withAppendedId(FeedReaderContract.CONTENT_URI, _id);
                       getContext().getContentResolver().notifyChange(_uri, null);
                   }
                break;

            default:
                throw  new IllegalArgumentException("Unknown URI : " + uri);

        }
        return _uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
