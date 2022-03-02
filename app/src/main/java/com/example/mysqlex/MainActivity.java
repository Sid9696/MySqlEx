package com.example.mysqlex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText rolln;
    EditText studcou;
    Dbhelphar dbhelphar;

    Button saveinfo;
    Button deletedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        rolln=findViewById(R.id.rolln);
        studcou=findViewById(R.id.studcou);
        dbhelphar=new Dbhelphar(MainActivity.this);

        saveinfo=findViewById(R.id.saveinfo);
        deletedata=findViewById(R.id.deletedata);

        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1= name.getText().toString();
                String roll= rolln.getText().toString();
                String course= studcou.getText().toString();
                boolean re;

                if (name1 == " " && roll == " " && course == " ") {
                    Toast.makeText(MainActivity.this, "Entering null values", Toast.LENGTH_SHORT).show();

                }
                else {

                    re = dbhelphar.addStudent(name1, roll, course);

                    if (re) {
                        //Toast.makeText(MainActivity.this, "Record Added Susefully", Toast.LENGTH_SHORT).show();

                    } else {
                        //Toast.makeText(MainActivity.this, "Record added unsesfully", Toast.LENGTH_SHORT).show();


                    }
                }


            }
        });

        deletedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1=name.getText().toString();
                dbhelphar.deleteStudent(name1);


            }
        });


    }
}