package com.example.ejerciciorecu_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1, btn2, btn3, btn4, btnVamos, btnAtrasListaPad, btnGuardarNombre;
    private LinearLayout layBot, laySpi, layIni, layLis, layNombre;
    private Spinner spn, spnPad;
    private AlertDialog.Builder ventana;
    private Class pantalla;
    private TextView bienvenido, jugamos;
    private final String[] SEISPANELES = {"Sin Padding", "Con Padding"};
    private ArrayList<PojoPantalla> pojoPantallas;
    private ListView listaPantallas, listaVariantes;
    private EditText etNombre;
    private CheckBox ckbGNom;

    private SharedPreferences sharedPreferences;

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
        btnAtrasListaPad = findViewById(R.id.btnAtrasListaPad);
        btnGuardarNombre = findViewById(R.id.btnGuardarNombre);
        layBot = findViewById(R.id.layBtns);
        laySpi = findViewById(R.id.laySpn);
        layIni = findViewById(R.id.layIni);
        layLis = findViewById(R.id.layLista);
        layNombre = findViewById(R.id.layNombreUsuario);
        spn = findViewById(R.id.spinner);
        spnPad = findViewById(R.id.spinnerPad);
        bienvenido = findViewById(R.id.txtBnv);
        jugamos = findViewById(R.id.txtJgm);
        listaPantallas = findViewById(R.id.listaPantallas);
        listaVariantes = findViewById(R.id.listaVariantes);
        etNombre = findViewById(R.id.etNombre);
        ckbGNom = findViewById(R.id.ckbGuardarNombre);


        pojoPantallas = new ArrayList<>();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnVamos.setOnClickListener(this);
        btnAtrasListaPad.setOnClickListener(this);
        btnGuardarNombre.setOnClickListener(this);

        pojoPantallas.add(new PojoPantalla("4 casillas", "Pantalla con cuatro paneles", "4"));
        pojoPantallas.add(new PojoPantalla("6 casillas", "Pantalla con seis paneles", "6"));
        pojoPantallas.add(new PojoPantalla("9 casillas", "Pantalla con nueve paneles", "9"));


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

        listaPantallas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int k = 0; k < pojoPantallas.size(); k++){
                    if (parent.getItemAtPosition(position).equals(pojoPantallas.get(k))){
                        if (pojoPantallas.get(k).getNum().equals("4")){
                            lanzarIntent(pantalla1.class);
                        } else if (pojoPantallas.get(k).getNum().equals("9")){
                            lanzarIntent(pantalla4.class);
                        } else {
                            listaPantallas.setVisibility(View.GONE);
                            listaVariantes.setVisibility(View.VISIBLE);
                            btnAtrasListaPad.setVisibility(View.VISIBLE);

                        }
                    }
                }

            }
        });

        listaVariantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < SEISPANELES.length; i++){
                    if (parent.getItemAtPosition(position).equals(SEISPANELES[i])){
                        if (SEISPANELES[i].equals("Sin Padding")){
                            lanzarIntent(pantalla2.class);
                        } else {
                            lanzarIntent(pantalla3.class);
                        }
                    }
                }
            }
        });

        registerForContextMenu(bienvenido);
        registerForContextMenu(jugamos);

        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, SEISPANELES);
        spnPad.setAdapter(adaptadorSpinner);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spn.getSelectedItem().equals("6 casillas")){
                    spnPad.setVisibility(View.VISIBLE);
                } else {
                    spnPad.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        AdaptadorPersonalizado adaptadorLista = new AdaptadorPersonalizado(this, R.layout.fila, pojoPantallas);
        listaPantallas.setAdapter(adaptadorLista);
        AdaptadorPersonalizadoPadding adaptadorLista2 = new AdaptadorPersonalizadoPadding(this, R.layout.filapadding, SEISPANELES);
        listaVariantes.setAdapter(adaptadorLista2);


        etNombre.setText(sharedPreferences.getString("nombre", ""));
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
                layLis.setVisibility(View.GONE);
                return true;
            case R.id.menuSpi:
                Toast.makeText(this, "Acceso mediante desplegable", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.GONE);
                laySpi.setVisibility(View.VISIBLE);
                layIni.setVisibility(View.GONE);
                layLis.setVisibility(View.GONE);
                return true;
            case R.id.menuInicio:
                Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.GONE);
                laySpi.setVisibility(View.GONE);
                layIni.setVisibility(View.VISIBLE);
                layLis.setVisibility(View.GONE);
                return true;
            case R.id.menuLista:
                Toast.makeText(this, "Acceso mediante lista", Toast.LENGTH_SHORT).show();
                layBot.setVisibility(View.GONE);
                laySpi.setVisibility(View.GONE);
                layIni.setVisibility(View.GONE);
                layLis.setVisibility(View.VISIBLE);

                listaPantallas.setVisibility(View.VISIBLE);
                listaVariantes.setVisibility(View.GONE);
                btnAtrasListaPad.setVisibility(View.GONE);
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
                    if (spnPad.getSelectedItem().equals("Sin Padding")){
                        pantalla = pantalla2.class;
                        lanzarIntent(pantalla);
                    } else {
                        pantalla = pantalla3.class;
                        lanzarIntent(pantalla);
                    }
                } else if (spn.getSelectedItem().equals("9 casillas")){
                    pantalla = pantalla4.class;
                    lanzarIntent(pantalla);
                }
            case R.id.btnAtrasListaPad:
                listaPantallas.setVisibility(View.VISIBLE);
                listaVariantes.setVisibility(View.GONE);
                btnAtrasListaPad.setVisibility(View.GONE);
                break;
            case R.id.btnGuardarNombre:
                if (!etNombre.getText().toString().equals("")){
                    layNombre.setVisibility(View.GONE);
                    layLis.setVisibility(View.VISIBLE);
                    if (ckbGNom.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nombre", etNombre.getText().toString());
                        editor.apply();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("nombre");
                        editor.apply();
                    }
                } else {
                    Toast.makeText(this, "Introduce un nombre", Toast.LENGTH_SHORT).show();
                }


        }
    }


}