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

        switch (col) {
            case "red":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case "blue":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case "yellow":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            case "green":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case "celeste":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.celeste));
                break;
            case "brown":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.brown));
                break;
            case "lavander":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.purple_200));
                break;
            case "black":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.black));
                break;
            case "white":
                layMuestra.setBackgroundColor(getResources().getColor(R.color.white));
                break;
        }


        btnEntendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbtSi.isChecked()){
                    finishActivity(RESULT_OK);
                    finish();
                    Toast.makeText(eliminar.this, "¡Me alegra que te guste!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    intent.putExtra("color", col);
                    setResult(RESULT_OK, intent);
                    finish();

                }
            }
        });


    }
}