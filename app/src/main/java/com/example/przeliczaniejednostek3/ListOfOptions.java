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
    public TextView nameTextView;
    public String name;
    public String optionString;
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
            "CM/M", "CM/KM", "CM/CAL", "CM/STOPY", "CM/MILE",
            "M/CM", "M/KM", "M/CAL", "M/STOPY", "M/MILE",
            "KM/CM", "KM/M", "KM/CAL", "KM/STOPY", "KM/MILE",
            "MILE/KM", "MILE/CM", "MILE/STOPY", "MILE/CALE",
            "CAL/CM", "CAL/M", "CAL/KM", "CAL/STOPY", "CALE/MILE",
            "STOPA/CM", "STOPA/CAL", "STOPA/M", "STOPA/KM", "STOPA/MILE"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_options);

        listView = findViewById(R.id.listView);

        //Array Adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                typesOfCalculationLength
        );

        listView.setAdapter(adapter);

        //Handlig click events in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListOfOptions.this, "Wybrano " + typesOfCalculationLength[position], Toast.LENGTH_SHORT).show();

                optionString = String.valueOf(typesOfCalculationLength[position]);
                Intent i = new Intent(getApplicationContext(), ActivityB.class);
                i.putExtra("optionNumber", optionString);
                //i.putExtra("optionName", optionString);
                startActivity(i);
            }
        });

        //taking a passed option
        nameTextView = findViewById(R.id.welcome2);
        Intent i = getIntent();
        name = i.getStringExtra("name");
        nameTextView.setText("Witaj w UnitConverter " + name);
    }
}