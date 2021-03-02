package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOfOptions extends AppCompatActivity {

    ListView listView;

    //Data to be desplayed int a list
    String[] typesOfCalculation = {
            "CM/M", "CM/KM", "KM/M", "KM/CM"
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
                typesOfCalculation
        );

        listView.setAdapter(adapter);

        


    }
}