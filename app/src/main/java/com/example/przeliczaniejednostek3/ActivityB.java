package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    public TextView welcome2, nameTextView;
    private double cale;
    public String optionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        nameTextView = findViewById(R.id.nameTextView);

        //taking a passed option
        Intent i = getIntent();
        optionNumber = i.getStringExtra("optionNumber");

        nameTextView.setText("" + optionNumber);

        TextView textViewGora = findViewById(R.id.textView2);
        textViewGora.setVisibility(View.INVISIBLE);

        TextView textViewDol = findViewById(R.id.textView3);
        textViewDol.setVisibility(View.INVISIBLE);

        if (savedInstanceState != null) {
            cale = savedInstanceState.getDouble("cale");
            textViewDol.setVisibility(View.VISIBLE);
            textViewDol.setText("" + cale);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("cale", cale);
        System.out.println("cale");
    }

    public void przelicz(View view) {
        EditText editText = findViewById(R.id.editTextNumber);
        int cm = Integer.parseInt(editText.getText().toString());
        TextView textViewGora = findViewById(R.id.textView2);
        textViewGora.setVisibility(View.VISIBLE);

        TextView textViewDol = findViewById(R.id.textView3);
        textViewDol.setVisibility(View.VISIBLE);

        if (optionNumber.equals("0") ) {
            cale = 0.39 * cm;
            textViewDol.setText("CM/M " + cale);
        }
        if (optionNumber.equals("1")) {
            cale = 0.5 * cm;
            textViewDol.setText("CM/K " + cale);
        }
    }

}