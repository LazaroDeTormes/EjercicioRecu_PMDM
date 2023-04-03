package com.example.ejerciciorecu_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class eliminar extends AppCompatActivity {

    private LinearLayout layMuestra;
    private RadioButton rbtSi, rbtNo;
    private Button btnEntendido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        layMuestra = findViewById(R.id.layMuestra);

        btnEntendido = findViewById(R.id.btnEntendido);

        rbtNo = findViewById(R.id.rbtNo);

        rbtSi = findViewById(R.id.rbtSi);

        Intent i = getIntent();

        String col = i.getStringExtra("color");

        if (col.equals("red")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.red));
        } else if (col.equals("blue")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.blue));
        }else if (col.equals("yellow")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.yellow));
        }else if (col.equals("green")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.green));
        }else if (col.equals("celeste")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.celeste));
        }else if (col.equals("brown")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.brown));
        }else if (col.equals("lavander")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }else if (col.equals("black")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.black));
        }else if (col.equals("white")){
            layMuestra.setBackgroundColor(getResources().getColor(R.color.white));
        }

        btnEntendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtSi.isChecked()){
                    finishActivity(RESULT_OK);
                    finish();
                    Toast.makeText(eliminar.this, "¡Me alegra que te guste!", Toast.LENGTH_SHORT).show();
                } else {
                    finishActivity(RESULT_OK);
                    finish();

                }
            }
        });


    }
}