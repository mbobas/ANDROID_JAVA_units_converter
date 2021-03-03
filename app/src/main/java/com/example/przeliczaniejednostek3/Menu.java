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

public class Menu extends AppCompatActivity {

    public ListView chooseOptionMenu;
    public TextView nameTextView;
    public String name;
    public String menuOptionString;

    //Data to be desplayed int a list
    String[] menuOptions= {
            "DŁUGOŚCI", "PRĘDKOŚCI", "MASA"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        chooseOptionMenu = findViewById(R.id.chooseOptionMenu);

        //Array Adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                menuOptions
        );

        chooseOptionMenu.setAdapter(adapter);

        //Handlig click events in ListView
        chooseOptionMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Menu.this, "Wybrano " + menuOptions[position], Toast.LENGTH_SHORT).show();

                //sending a value of option in menu
                menuOptionString = String.valueOf(menuOptions[position]);
                Intent i = new Intent(getApplicationContext(), ListOfOptions.class);
                i.putExtra("menuoptionNumber", menuOptionString);
                i.putExtra("name", name);
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