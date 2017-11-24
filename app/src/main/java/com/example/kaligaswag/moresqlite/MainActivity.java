package com.example.kaligaswag.moresqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kaligaswag.moresqlite.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    DBHelper mydb;
    EditText name, surname, marks;
    Button addData, lihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHelper(this);

        name = (EditText) findViewById(R.id.nameEditText);
        surname = (EditText) findViewById(R.id.surnameEditText);
        marks = (EditText) findViewById(R.id.marksEditText);
        addData = (Button) findViewById(R.id.buttonAdd);
        lihat = (Button) findViewById(R.id.buttonLihat);
        insert();
        lihat();
    }

    private void lihat() {
        lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LihatActivity.class);
                startActivity(i);
            }
        });
    }

    public void insert(){
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nam = name.getText().toString();
                String sur = surname.getText().toString();
                String mar = marks.getText().toString();

                if (nam.isEmpty() || sur.isEmpty() || mar.isEmpty()){
                    Toast.makeText(MainActivity.this, "Silahkan lengkapi form terlebih dahulu",
                            Toast.LENGTH_SHORT).show();
                } else {

                    boolean isInserted = mydb.insertData(nam, sur, Integer.parseInt(mar));
                    if (isInserted == true) {
                        name.setText("");
                        surname.setText("");
                        marks.setText("");
                        Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "oops! data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
