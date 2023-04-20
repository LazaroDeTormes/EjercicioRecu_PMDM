package com.example.ejerciciorecu_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends ArrayAdapter {

    private Activity contexto;
    private ArrayList<PojoPantalla> pojoPantallas;

    public AdaptadorPersonalizado(@NonNull Activity contexto,
                                  int layoutPersonalizado,
                                  @NonNull ArrayList<PojoPantalla> pojoPantallas){
        super(contexto, layoutPersonalizado, pojoPantallas);
        this.contexto = contexto;
        this.pojoPantallas = pojoPantallas;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;

        ViewHolder vh;

        if (fila != null){

            LayoutInflater inflador = contexto.getLayoutInflater();
            fila = inflador.inflate(R.layout.fila, null);
            vh = new ViewHolder();

            vh.icono = fila.findViewById(R.id.iconoFila);
            vh.cuantas = fila.findViewById(R.id.cuantasCasillas);
            vh.desc = fila.findViewById(R.id.descripcion);
            vh.num = fila.findViewById(R.id.numero);

            fila.setTag(vh);

        } else {
            vh = (ViewHolder) fila.getTag();
        }

        ImageView icono = fila.findViewById(R.id.iconoFila);
        TextView cuantas = fila.findViewById(R.id.cuantasCasillas);
        TextView desc = fila.findViewById(R.id.descripcion);
        TextView num = fila.findViewById(R.id.numero);

        cuantas.setText(pojoPantallas.get(position).getCuantas());
        desc.setText(pojoPantallas.get(position).getDesc());
        num.setText(pojoPantallas.get(position).getNum());


        if (num.getText().toString().equals("4")){
            icono.setImageResource(R.drawable.fondo1);
        } else if (num.getText().toString().equals("6")){
            icono.setImageResource(R.drawable.fondo2);
        } else {
            icono.setImageResource(R.drawable.fondo3);
        }

        return fila;

    }


    public class ViewHolder{
        private ImageView icono;
        private TextView cuantas, desc, num;
    }
}
