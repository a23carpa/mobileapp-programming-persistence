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
    private List<Entry.FeedEntry> list;

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



    }









}
