package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FruitAdapter extends BaseAdapter {
    String[] resultado;
    String[] precios;
    String[] lugares;
    int[] imgId;
    Context context;

    private static LayoutInflater inflater = null;

    public FruitAdapter(Context context, String[] nomfrutas, int[] imgfrutas, String[] preciosfrutas, String[] lugaresfrutas) {
        resultado = nomfrutas;
        imgId = imgfrutas;
        precios = preciosfrutas;
        lugares = lugaresfrutas;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return resultado.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        ImageView img;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View fila = inflater.inflate(R.layout.list_item_fruit, null);

        holder.tv1 = fila.findViewById(R.id.tvFruta);
        holder.tv2 = fila.findViewById(R.id.tvPrecio);
        holder.tv3 = fila.findViewById(R.id.tvLugar);
        holder.img = fila.findViewById(R.id.imgFruta);

        holder.tv1.setText("Fruta: " + resultado[i]);
        holder.tv2.setText("Precio: " + precios[i]);
        holder.tv3.setText("Lugar: " + lugares[i]);
        holder.img.setImageResource(imgId[i]);

        fila.setOnClickListener(view1 -> Toast.makeText(context, "Selección: " + resultado[i], Toast.LENGTH_LONG).show());

        return fila;
    }
}
