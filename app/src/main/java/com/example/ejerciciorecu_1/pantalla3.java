package com.example.ejerciciorecu_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class pantalla3 extends AppCompatActivity {


    private LinearLayout lR2, lAm2, lAz2, lV2, lC2, lM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        lR2 = findViewById(R.id.layRojo2);
        lAz2 = findViewById(R.id.layAzul2);
        lAm2 = findViewById(R.id.layAmarillo2);
        lV2 = findViewById(R.id.layVerde2);
        lC2 = findViewById(R.id.layCeleste2);
        lM2 = findViewById(R.id.layMarron2);

        Intent i = getIntent();

        lR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla3.this, rojo.class);
                i.putExtra("flag","9");
                i.putExtra("color", "red");

                startActivity(i);
            }
        });

        lAz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla3.this, rojo.class);
                i.putExtra("flag","9");
                i.putExtra("color", "blue");

                startActivity(i);
            }
        });

        lAm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla3.this, rojo.class);
                i.putExtra("flag","9");
                i.putExtra("color", "yellow");

                startActivity(i);
            }
        });

        lV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla3.this, rojo.class);
                i.putExtra("flag","9");
                i.putExtra("color", "green");

                startActivity(i);
            }
        });

        lC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla3.this, rojo.class);
                i.putExtra("flag","9");
                i.putExtra("color", "celeste");

                startActivity(i);
            }
        });

        lM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla3.this, rojo.class);
                i.putExtra("flag","9");
                i.putExtra("color", "brown");

                startActivity(i);
            }
        });
    }
}