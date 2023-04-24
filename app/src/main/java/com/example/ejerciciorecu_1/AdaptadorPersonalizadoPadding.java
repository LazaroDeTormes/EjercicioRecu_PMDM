package com.example.ejerciciorecu_1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorPersonalizadoPadding extends ArrayAdapter {

    private Activity contexto;
    private String[] opciones;

    public AdaptadorPersonalizadoPadding(Activity contexto, int layout, String[] opciones) {
        super(contexto, layout, opciones);
        this.contexto = contexto;
        this.opciones = opciones;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;

        AdaptadorPersonalizadoPadding.ViewHolder vh;

        if (fila == null){

            LayoutInflater inflador = contexto.getLayoutInflater();
            fila = inflador.inflate(R.layout.filapadding, null);
            vh = new AdaptadorPersonalizadoPadding.ViewHolder();

            vh.icono = fila.findViewById(R.id.iconoFilaPad);

            vh.pad = fila.findViewById(R.id.padding);

            fila.setTag(vh);

        } else {
            vh = (AdaptadorPersonalizadoPadding.ViewHolder) fila.getTag();
        }

        ImageView icono = fila.findViewById(R.id.iconoFilaPad);
        TextView pad = fila.findViewById(R.id.padding);

        icono.setImageResource(R.drawable.fondo2);
        pad.setText(opciones[position]);



        return fila;

    }


    public class ViewHolder{
        private ImageView icono;
        private TextView pad;
    }

}
