package com.acc.android.SqlLiteDemo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Created by Sagar Gopale on 12/27/2014.
 */
public class Show extends Activity {

    private ListView lv;
    DBcr d;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        lv=(ListView)findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, R.layout.display, R.id.listView);
        lv.setAdapter(adapter);

        String[] projection = {
                FeedReaderContract.CommonColumns.USERNAME,
                FeedReaderContract.CommonColumns.PASSWORD
        };

        Cursor cursor = getContentResolver().query(
                FeedReaderContract.CONTENT_URI,
                projection,
                null,
                null,
                null
        );






    }


}
