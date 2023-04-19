package com.example.ejerciciorecu_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1, btn2, btn3, btn4, btnVamos;
    private LinearLayout layBot, laySpi, layIni;
    private Spinner spn;
    private AlertDialog.Builder ventana;
    private Class pantalla;
    private TextView bienvenido, jugamos;

    private static final int DIALOGO_DESCRIPCION_1 = 1;
    private static final int DIALOGO_DESCRIPCION_2 = 2;
    private static final int DIALOGO_SALIR = 3;

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
        layIni = findViewById(R.id.layIni);
        spn = findViewById(R.id.spinner);
        bienvenido = findViewById(R.id.txtBnv);
        jugamos = findViewById(R.id.txtJgm);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnVamos.setOnClickListener(this);

        btn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDialog(DIALOGO_DESCRIPCION_1);
                return false;
            }
        });

        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDialog(DIALOGO_DESCRIPCION_2);
                return false;
            }
        });

        registerForContextMenu(bienvenido);
        registerForContextMenu(jugamos);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflador = getMenuInflater();

        switch (v.getId()){
            case R.id.txtBnv:
                inflador.inflate(R.menu.menu_contexto_bnv, menu);
                break;
            case R.id.txtJgm:
                inflador.inflate(R.menu.menu_contexto_jgm, menu);
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        switch(item.getItemId()){
            case R.id.fondo1:
                layIni.setBackground(getDrawable(R.drawable.fondo1));
                break;
            case R.id.fondo2:
                layIni.setBackground(getDrawable(R.drawable.fondo2));
                break;
            case R.id.fondo3:
                layIni.setBackground(getDrawable(R.drawable.fondo3));
                break;
            case R.id.fondoBlanco:
                layIni.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case R.id.fondoNegro:
                layIni.setBackgroundColor(getResources().getColor(R.color.black));
                break;
        }

        return true;
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
                layIni.setVisibility(View.GONE);
                return true;
            case R.id.menuSpi:
                Toast.makeText(this, "Acceso mediante desplegable", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.GONE);
                laySpi.setVisibility(View.VISIBLE);
                layIni.setVisibility(View.GONE);
                return true;
            case R.id.menuInicio:
                Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.GONE);
                laySpi.setVisibility(View.GONE);
                layIni.setVisibility(View.VISIBLE);
                return true;
            case R.id.menuFin:
                showDialog(DIALOGO_SALIR);
                return false;
            case R.id.menuP1:
                pantalla = pantalla1.class;
                lanzarIntent(pantalla);
                return true;
            case R.id.menuP2:
                pantalla = pantalla2.class;
                lanzarIntent(pantalla);
                return true;
            case R.id.menuP3:
                pantalla = pantalla3.class;
                lanzarIntent(pantalla);
                return true;
            case R.id.menuP4:
                pantalla = pantalla4.class;
                lanzarIntent(pantalla);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected Dialog onCreateDialog(int id){
        switch (id){
            case DIALOGO_DESCRIPCION_1:
                ventana = new AlertDialog.Builder(this);
                ventana.setTitle("Pantalla 1")
                        .setIcon(R.drawable.icon)
                        .setMessage(R.string.p1);
                break;
            case DIALOGO_DESCRIPCION_2:
                ventana = new AlertDialog.Builder(this);
                ventana.setTitle("Pantalla 2")
                        .setIcon(R.drawable.icon)
                        .setMessage(R.string.p2);
                break;
            case DIALOGO_SALIR:
                ventana = new AlertDialog.Builder(this);
                ventana.setTitle("Saliendo...")
                        .setIcon(R.drawable.icon)
                        .setMessage(R.string.s1)
                        .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("salir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                finishAffinity();
                            }
                        });

        }
        return ventana.create();
    }

    public void lanzarIntent(Class clase){
        Intent i = new Intent(MainActivity.this, clase);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                pantalla = pantalla1.class;
                lanzarIntent(pantalla);
                break;
            case R.id.btn2:
                pantalla = pantalla2.class;
                lanzarIntent(pantalla);
                break;
            case R.id.btn3:
                pantalla = pantalla3.class;
                lanzarIntent(pantalla);
                break;
            case R.id.btn4:
                pantalla = pantalla4.class;
                lanzarIntent(pantalla);
                break;
            case R.id.btnVamos:
                if (spn.getSelectedItem().equals("4 casillas")){
                    pantalla = pantalla1.class;
                    lanzarIntent(pantalla);
                } else if (spn.getSelectedItem().equals("6 casillas")){
                    pantalla = pantalla3.class;
                    lanzarIntent(pantalla);
                } else if (spn.getSelectedItem().equals("9 casillas")){
                    pantalla = pantalla4.class;
                    lanzarIntent(pantalla);
                }

        }
    }
}