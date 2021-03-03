package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    public TextView optionNametextView, optionNametextView2, wynik;
    public EditText editText;
    private double score;
    public String optionNumber;
    public Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);


        //taking a passed option
        optionNametextView = findViewById(R.id.optionName);
        Intent i = getIntent();
        optionNumber = i.getStringExtra("optionNumber");
        //setting a header with choosen option
        optionNametextView.setText("" + optionNumber);

        //setting a header2 name with choosen option
        optionNametextView2 = findViewById(R.id.optionName2);
        optionNametextView2.setVisibility(View.INVISIBLE);
        optionNametextView2.setText("" + optionNumber);

        //setting a score invisible
        wynik = findViewById(R.id.wynik);
        wynik.setVisibility(View.INVISIBLE);


        //taking a data after screen was rotated, holding a data from past.
        if (savedInstanceState != null) {
            score = savedInstanceState.getDouble("cale");
            wynik.setVisibility(View.VISIBLE);
            wynik.setText("" + score);
        }


    }

    //saving instance of score to hold a data when a screen will be rotated
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("cale", score);
    }


    //fucntion resposible for a all calculations
    public void countIt(View view) {
        //taking a value of edittext field
        editText = findViewById(R.id.editTextNumber);
        int value = Integer.parseInt(editText.getText().toString());

        //making visable a score and second optioname
        optionNametextView2.setVisibility(View.VISIBLE);
        wynik.setVisibility(View.VISIBLE);

        //LENGTH's
        // functions to calculate a scores
        //CM -- //        "CM/M", "CM/KM", "CM/CAL", "CM/STOPY", "CM/MILE",
        if (optionNumber.equals("CM/M")) {
            score = 0.01000 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CM/KM")) {
            score = 0.00001 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CM/CAL")) {
            score = 0.39370 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CM/STOPY")) {
            score = 0.03281 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CM/MILE")) {
            score = 0.0000062 * value;
            wynik.setText("" + score);
        }
        ////        "M/CM", "M/KM", "M/CAL", "M/STOPY", "M/MILE",
        if (optionNumber.equals("M/CM")) {
            score = 0.01000 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("M/KM")) {
            score = 100.0 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("M/CAL")) {
            score = 39.37008 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("M/STOPY")) {
            score = 3.28084 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("M/MILE")) {
            score = 0.00062 * value;
            wynik.setText("" + score);
        }


//        "KM/CM", "KM/M", "KM/CAL", "KM/STOPY", "KM/MILE",
        if (optionNumber.equals("KM/CM")) {
            score = 100000.0 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("KM/M")) {
            score = 1000.0 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("KM/CAL")) {
            score = 39370.07874 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("KM/STOPY")) {
            score = 3280.83990 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("KM/MILE")) {
            score = 0.62137 * value;
            wynik.setText("" + score);
        }

//        "MILE/KM", "MILE/CM", "MILE/STOPY", "MILE/CALE",
        if (optionNumber.equals("MILE/KM")) {
            score = 1.60934 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("MILE/CM")) {
            score = 160934.40 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("MILE/STOPY")) {
            score = 5280.0 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("MILE/CALE")) {
            score = 63360.0 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("MILE/M")) {
            score = 1609.344 * value;
            wynik.setText("" + score);
        }
//        "CAL/CM", "CAL/M", "CAL/KM", "CAL/STOPY", "CALE/MILE",
        if (optionNumber.equals("CAL/CM")) {
            score = 2.54000 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CAL/M")) {
            score = 0.02540 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CAL/KM")) {
            score = 0.00003 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CAL/STOPY")) {
            score = 0.08333 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("CALE/MILE")) {
            score = 0.00002 * value;
            wynik.setText("" + score);
        }
//        "STOPA/CM", "STOPA/CAL", "STOPA/M", "STOPA/KM", "STOPA/MILE"
        if (optionNumber.equals("STOPA/CM")) {
            score = 30.48 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("STOPA/CAL")) {
            score = 12.0 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("STOPA/M")) {
            score = 0.30480 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("STOPA/KM")) {
            score = 0.00030 * value;
            wynik.setText("" + score);
        }
        if (optionNumber.equals("STOPA/MILE")) {
            score = 0.00019 * value;
            wynik.setText("" + score);
        }

    }
}