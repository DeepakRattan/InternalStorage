package com.example.deepakrattan.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    private TextView txtName, txtPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //findViewByID
        txtName = (TextView) findViewById(R.id.txtName);
        txtPasswd = (TextView) findViewById(R.id.txtPasswd);
        StringBuffer buffer = new StringBuffer();
        try {
            FileInputStream fin = openFileInput("MyFile.txt");

            int read = -1;
            while ((read = fin.read()) != -1) {
                buffer.append((char) read); //Integer is converted into characters
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = buffer.substring(0, buffer.indexOf(" "));
        String password = buffer.substring(buffer.indexOf(" ") + 1);

        txtName.setText(name);
        txtPasswd.setText(password);
    }


}
