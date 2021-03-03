package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListOfOptions extends AppCompatActivity {

    public ListView listView, lisetView2, listView3;
    public TextView nameTextView, header3;
    public String name, headerName;
    public String optionString;
    public String[] chosenType;

    //Data to be desplayed int a list
    String[] typesOfCalculationLength= {
            "CM/M", "CM/KM", "CM/CAL", "CM/STOPY", "CM/MILE",
            "M/CM", "M/KM", "M/CAL", "M/STOPY", "M/MILE",
            "KM/CM", "KM/M", "KM/CAL", "KM/STOPY", "KM/MILE",
            "MILE/KM", "MILE/CM", "MILE/STOPY", "MILE/CALE",
            "CAL/CM", "CAL/M", "CAL/KM", "CAL/STOPY", "CALE/MILE",
            "STOPA/CM", "STOPA/CAL", "STOPA/M", "STOPA/KM", "STOPA/MILE"
    };

    String[] typesOfCalculationSpeed = {
            "km/s na km/h",
            "km/s na m/s",
            "km/s na mile/h",
            "km/s na węzły",
            "km/s na machy",

            "km/h na km/s",
            "km/h na m/s",
            "km/h na mile/h",
            "km/h na węzły",
            "km/h na machy",

            "m/s na km/s",
            "m/s na km/h",
            "m/s na mile/h",
            "m/s na węzły",
            "m/s na machy",

            "mile/s na km/h",
            "mile/h na m/s",
            "mile/h na km/s",
            "mile/h na węzły",
            "mile/h na machy",

            "węzły na km/h",
            "węzły na m/s",
            "węzły na km/s",
            "węzły na mile/h",
            "węzły na machy",

            "machy na km/h",
            "machy na m/s",
            "machy na km/s",
            "machy na węzły",
            "machy na mile/h",


    };

    String[] typesOfCalculationWeight = {
            "SPEED","SPEED","SPEED","SPEED","SPEED"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_options);

        //taking a passed option
        nameTextView = findViewById(R.id.welcome2);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        nameTextView.setText("Witaj w UnitConverter " + name);
        header3 = findViewById(R.id.header3);

        headerName = i.getStringExtra("menuoptionNumber");
        header3.setText("" + headerName);

        //instance of listWithoptions
        listView = findViewById(R.id.listView);

        ///"DŁUGOŚCI", "PRĘDKOŚCI", "MASA" - ??
        if (headerName.equals("DŁUGOŚCI")) {
            chosenType = typesOfCalculationLength;
        }
        if (headerName.equals("PRĘDKOŚCI")) {
            chosenType = typesOfCalculationSpeed;
        }
        if (headerName.equals("MASA")) {
            chosenType = typesOfCalculationWeight;
        }

        //Array Adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                chosenType
        );

        listView.setAdapter(adapter);

        //Handlig click events in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListOfOptions.this, "Wybrano " + chosenType[position], Toast.LENGTH_SHORT).show();

                optionString = String.valueOf(chosenType[position]);
                Intent i = new Intent(getApplicationContext(), ActivityB.class);
                i.putExtra("optionNumber", optionString);
                //i.putExtra("optionName", optionString);
                startActivity(i);
            }
        });




    }
}