package com.example.ejerciciorecu_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Objects;

public class rojo extends AppCompatActivity {

    private LinearLayout layPrin;
    private Button btnAC, btnIC, btnSC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojo);

        layPrin = findViewById(R.id.layPrincipal);
        btnAC = findViewById(R.id.btnAtrasColor);
        btnIC = findViewById(R.id.btnInicioColor);
        btnSC = findViewById(R.id.btnSalirColor);

        Intent i = getIntent();

        String flag = i.getStringExtra("flag");

        if (flag.equals("4")){
            btnIC.setVisibility(View.GONE);
            btnSC.setVisibility(View.GONE);
        }
        if (flag.equals("6")){
            btnIC.setVisibility(View.VISIBLE);
            btnSC.setVisibility(View.GONE);
        }
        if (flag.equals("9")){
            btnIC.setVisibility(View.VISIBLE);
            btnSC.setVisibility(View.VISIBLE);
        }

        String col = i.getStringExtra("color");



        if (col.equals("red")){
           layPrin.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (col.equals("blue")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.blue));
        }else if (col.equals("yellow")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.yellow));
        }else if (col.equals("green")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.green));
        }else if (col.equals("celeste")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.celeste));
        }else if (col.equals("brown")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.brown));
        }else if (col.equals("lavander")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }else if (col.equals("black")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.black));
        }else if (col.equals("white")){
            layPrin.setBackgroundColor(getResources().getColor(R.color.white));
        }

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity(RESULT_OK);
                finish();
            }
        });

        btnIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity(RESULT_OK);
                finish();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        finishActivity(RESULT_OK);
        finish();
    }
}