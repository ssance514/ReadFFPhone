package com.fwdllc.readffphone;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFFPhone extends AppCompatActivity {

    TextView fileRead;
    Button buttonR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_ffphone);

        fileRead = (TextView) findViewById(R.id.textView);
        buttonR = (Button) findViewById(R.id.buttonRead);
    }

    public void read_file (View view) {

        Toast.makeText(getApplicationContext(), getFileStreamPath("FTC_TeleData").toString(), Toast.LENGTH_LONG).show();
        fileRead.setText(getFileStreamPath("FTC_TeleData").toString());

        try {
            String message;
            FileInputStream fileInputStream = openFileInput("/data/data/com.fwdllc.wrtfiletophone/files/FTC_TeleData");
//            FileInputStream fileInputStream = openFileInput("FTC_TeleData");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            while ((message = bufferedReader.readLine()) != null) {
                stringBuffer.append(String.format("%s\n", message));
            }

            fileRead.setText(stringBuffer.toString());
            fileRead.setVisibility(View.VISIBLE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_read_ffphone, menu);
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
