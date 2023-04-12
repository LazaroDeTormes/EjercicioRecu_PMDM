package com.example.ejerciciorecu_1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class pantalla4 extends AppCompatActivity {

    private static final int CODIGO = 1;

    private LinearLayout lR3, lAm3, lAz3, lV3, lC3, lM3, lL3, lN3, lB3;

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
        lN3 = findViewById(R.id.layNegro3);
        lB3 = findViewById(R.id.layBlanco3);

        Intent i = getIntent();

        lR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "red");

                startActivityForResult(i, CODIGO);
            }
        });

        lAz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "blue");

                startActivityForResult(i, CODIGO);
            }
        });

        lAm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "yellow");

                startActivityForResult(i, CODIGO);
            }
        });

        lV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "green");

                startActivityForResult(i, CODIGO);
            }
        });

        lC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "celeste");

                startActivityForResult(i, CODIGO);
            }
        });

        lM3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "brown");

                startActivityForResult(i, CODIGO);
            }
        });

        lL3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "lavander");

                startActivityForResult(i, CODIGO);
            }
        });

        lN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "black");

                startActivityForResult(i, CODIGO);
            }
        });

        lB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(pantalla4.this, eliminar.class);
                i.putExtra("color", "white");

                startActivityForResult(i, CODIGO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODIGO) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String color = data.getStringExtra("color");
                    ocultar(color);
                    Toast.makeText(this, "color eliminado", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    protected void ocultar(String color){

        switch (color) {
            case "red":
                lR3.setVisibility(View.INVISIBLE);
                break;
            case "blue":
                lAz3.setVisibility(View.INVISIBLE);
                break;
            case "yellow":
                lAm3.setVisibility(View.INVISIBLE);
                break;
            case "green":
                lV3.setVisibility(View.INVISIBLE);
                break;
            case "celeste":
                lC3.setVisibility(View.INVISIBLE);
                break;
            case "brown":
                lM3.setVisibility(View.INVISIBLE);
                break;
            case "lavander":
                lL3.setVisibility(View.INVISIBLE);
                break;
            case "black":
                lN3.setVisibility(View.INVISIBLE);
                break;
            case "white":
                lB3.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt("lR", lR3.getVisibility());
        outState.putInt("lAz", lAz3.getVisibility());
        outState.putInt("lAm", lAm3.getVisibility());
        outState.putInt("lV", lV3.getVisibility());
        outState.putInt("lC", lC3.getVisibility());
        outState.putInt("lM", lM3.getVisibility());
        outState.putInt("lL", lL3.getVisibility());
        outState.putInt("lN", lN3.getVisibility());
        outState.putInt("lB", lB3.getVisibility());



    }
}