package com.example.ejerciciorecu_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btnVamos;
    private LinearLayout layBot, laySpi;
    private Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnVamos = findViewById(R.id.btnVamos);
        layBot = findViewById(R.id.layBtns);
        laySpi = findViewById(R.id.laySpn);
        spn = findViewById(R.id.spinner);

        btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(MainActivity.this, pantalla1.class);
                    startActivity(i);

                }
        }
        );

        btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(MainActivity.this, pantalla2.class);
                        startActivity(i);

                    }
                }
        );

        btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(MainActivity.this, pantalla3.class);
                        startActivity(i);

                    }
                }
        );

        btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(MainActivity.this, pantalla4.class);
                        startActivity(i);

                    }
                }
        );

        btnVamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spn.getSelectedItem().equals("4 casillas")){
                    Intent i = new Intent(MainActivity.this, pantalla1.class);
                    startActivity(i);
                } else if (spn.getSelectedItem().equals("6 casillas")){
                    Intent i = new Intent(MainActivity.this, pantalla3.class);
                    startActivity(i);
                } else if (spn.getSelectedItem().equals("9 casillas")){
                    Intent i = new Intent(MainActivity.this, pantalla4.class);
                    startActivity(i);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuBot:
                Toast.makeText(this, "Acceso mediante botones", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.VISIBLE);
                laySpi.setVisibility(View.GONE);
                return true;
            case R.id.menuSpi:
                Toast.makeText(this, "Acceso mediante desplegable", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.GONE);
                laySpi.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}