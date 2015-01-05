package com.acc.android.SqlLiteDemo;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText e1, e2;
    DBcr d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.username);
        e2 = (EditText)findViewById(R.id.password);
        Button b1=(Button)findViewById(R.id.button);

        final ContentValues _user = new ContentValues();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                _user.put(FeedReaderContract.CommonColumns.USERNAME, username);
                _user.put(FeedReaderContract.CommonColumns.PASSWORD, password);

                if (username != null && username.length() > 0) {
                    getContentResolver().insert(FeedReaderContract.Employee.CONTENT_URI, _user);

                    Toast.makeText(getApplicationContext(),"Data Inserted Successfully", Toast.LENGTH_LONG).show();
                }           }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
