package com.example.przeliczaniejednostek3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText nameEdit;
    public Button buttonGo;
    public String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nameEdit);
        buttonGo = findViewById(R.id.buttonGo);
        

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameString = nameEdit.getText().toString();
                Intent i = new Intent(getApplicationContext(), ActivityB.class);
                i.putExtra("name", nameString);
                startActivity(i);
            }
        });
        
    }

    private void GoToActivityB() {

    }
}