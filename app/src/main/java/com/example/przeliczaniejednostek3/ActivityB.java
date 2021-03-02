package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    public TextView welcome2, nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        nameTextView = findViewById(R.id.nameTextView);
        Intent i = getIntent();
        String name = i.getStringExtra("name");

        nameTextView.setText("" + name);

    }
}