package com.example.ejerciciorecu_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class pantalla2 extends AppCompatActivity {

    private LinearLayout lR22, lAm22, lAz22, lV22, lC22, lM22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        lR22 = findViewById(R.id.roj);
        lAz22 = findViewById(R.id.azu);
        lAm22 = findViewById(R.id.ama);
        lV22 = findViewById(R.id.ver);
        lC22 = findViewById(R.id.cel);
        lM22 = findViewById(R.id.mar);

        Intent i = getIntent();

        lR22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, rojo.class);
                i.putExtra("flag","6");
                i.putExtra("color", "red");

                startActivity(i);
            }
        });

        lAz22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, rojo.class);
                i.putExtra("flag","6");
                i.putExtra("color", "blue");

                startActivity(i);
            }
        });

        lAm22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, rojo.class);
                i.putExtra("flag","6");
                i.putExtra("color", "yellow");

                startActivity(i);
            }
        });

        lV22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, rojo.class);
                i.putExtra("flag","6");
                i.putExtra("color", "green");

                startActivity(i);
            }
        });

        lC22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, rojo.class);
                i.putExtra("flag","6");
                i.putExtra("color", "celeste");

                startActivity(i);
            }
        });

        lM22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla2.this, rojo.class);
                i.putExtra("flag","6");
                i.putExtra("color", "brown");

                startActivity(i);
            }
        });
    }

}