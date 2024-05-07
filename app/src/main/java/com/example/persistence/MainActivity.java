package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button write;
    private Button read;
    private EditText editName;
    private EditText editLastName;
    private EditText editAge;
    private TextView textBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        write = findViewById(R.id.buttonWrite);
        read = findViewById(R.id.buttonRead);
        editName = findViewById(R.id.editName);
        editLastName = findViewById(R.id.editLast);
        editAge = findViewById(R.id.editAge);
        textBox = findViewById(R.id.textBox);


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EntryItem entryItem;
                try{
                    entryItem = new EntryItem(-1 , editName.getText().toString(), editLastName.getText().toString(), Integer.parseInt(editAge.getText().toString()));
                    Log.i(":)", entryItem.toString());
                }
                catch (Exception e){
                    Log.i(":)", "Error creating entry");
                    entryItem = new EntryItem(-1 , "error", "Error", 0);
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean succes = databaseHelper.addOne(entryItem);

                Log.i(":)", "Success " + succes);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                List<EntryItem> all = databaseHelper.getAll();

                StringBuilder string = new StringBuilder("");
                for(EntryItem item : all){
                    string.append("Name: " + item.getName() + " ");
                    string.append(item.getLastName() + "\n");
                    string.append("Age: " + item.getAge() + "\n" + "\n");
                }
                textBox.setText(string);
            }
        });
    }









}
