package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListOfOptions extends AppCompatActivity {

    ListView listView;

    //Data to be desplayed int a list
    String[] typesOfCalculation = {
            "CM/M", "CM/KM", "KM/M", "KM/CM"
    };

    public String optionString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_options);

        listView = findViewById(R.id.listView);

        //Array Adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                typesOfCalculation
        );

        listView.setAdapter(adapter);

        //Handlig click events in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListOfOptions.this, "Wybrano " + typesOfCalculation[position], Toast.LENGTH_SHORT).show();

                optionString = String.valueOf(position);
                Intent i = new Intent(getApplicationContext(), ActivityB.class);
                i.putExtra("optionNumber", optionString);
                //i.putExtra("optionName", optionString);
                startActivity(i);
            }
        });


    }
}