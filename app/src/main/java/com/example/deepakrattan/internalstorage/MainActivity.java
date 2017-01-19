package com.example.deepakrattan.internalstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText edtName, edtPasswd;
    private Button btnNext,btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewByID
        edtName = (EditText) findViewById(R.id.edtName);
        edtPasswd = (EditText) findViewById(R.id.edtPasswd);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString();
                String name1 = name + " "; //Adding spaces after name
                String passwd = edtPasswd.getText().toString();
                FileOutputStream fout = null;
                try {
                    fout = openFileOutput("MyFile.txt", MODE_PRIVATE);
                    fout.write(name1.getBytes()); //Converting string to bytes,then write to output stream
                    fout.write(passwd.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                Toast.makeText(MainActivity.this, "Data Written to " + getFilesDir() + "/MyFile.txt", Toast.LENGTH_LONG).show();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });


    }
}
