package com.example.ejerciciorecu_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class pantalla1 extends AppCompatActivity {

    private Button btnFin;
    private LinearLayout lR1, lAm1, lAz1, lV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        Intent i = getIntent();



        btnFin = findViewById(R.id.btnFin);
        lR1 = findViewById(R.id.layRojo1);
        lAz1 = findViewById(R.id.layAzul1);
        lAm1 = findViewById(R.id.layAmarillo1);
        lV1 = findViewById(R.id.layVerde1);


        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity(RESULT_OK);
                finish();
            }
        });


        lR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla1.this, rojo.class);
                i.putExtra("flag","4");
                i.putExtra("color", "red");

                startActivity(i);
            }
        });

        lAz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla1.this, rojo.class);
                i.putExtra("flag","4");
                i.putExtra("color", "blue");

                startActivity(i);
            }
        });

        lAm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla1.this, rojo.class);
                i.putExtra("flag","4");
                i.putExtra("color", "yellow");

                startActivity(i);
            }
        });

        lV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla1.this, rojo.class);
                i.putExtra("flag","4");
                i.putExtra("color", "green");

                startActivity(i);
            }
        });

    }
}