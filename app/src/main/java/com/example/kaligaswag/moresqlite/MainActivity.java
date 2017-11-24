package com.example.kaligaswag.moresqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.kaligaswag.moresqlite.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    DBHelper mydb;
    EditText name, surname, marks;
    Button addData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);

        name = (EditText) findViewById(R.id.nameEditText);
        surname = (EditText) findViewById(R.id.surnameEditText);
        marks = (EditText) findViewById(R.id.marksEditText);


    }
}
