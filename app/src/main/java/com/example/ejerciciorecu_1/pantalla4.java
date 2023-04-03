package com.example.ejerciciorecu_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class pantalla4 extends AppCompatActivity {

    private LinearLayout lR3, lAm3, lAz3, lV3, lC3, lM3, lL3, lB3, lW3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4);

        lR3 = findViewById(R.id.layRojo3);
        lAz3 = findViewById(R.id.layAzul3);
        lAm3 = findViewById(R.id.layAmarillo3);
        lV3 = findViewById(R.id.layVerde3);
        lC3 = findViewById(R.id.layCeleste3);
        lM3 = findViewById(R.id.layMarron3);
        lL3 = findViewById(R.id.layLavanda3);
        lB3 = findViewById(R.id.layNegro3);
        lW3 = findViewById(R.id.layBlanco3);

        Intent i = getIntent();

        lR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "red");

                startActivity(i);
            }
        });

        lAz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "blue");

                startActivity(i);
            }
        });

        lAm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "yellow");

                startActivity(i);
            }
        });

        lV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "green");

                startActivity(i);
            }
        });

        lC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "celeste");

                startActivity(i);
            }
        });

        lM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "brown");

                startActivity(i);
            }
        });

        lL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "lavander");

                startActivity(i);
            }
        });

        lB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "black");

                startActivity(i);
            }
        });

        lW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "white");

                startActivity(i);
            }
        });
    }
}