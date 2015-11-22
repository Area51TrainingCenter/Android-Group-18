package com.johannfjs.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.mod1class4.R;
import com.johannfjs.models.DetalleImagen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 21/11/2015.
 */
public class GrillaAdapter extends ArrayAdapter<DetalleImagen> {
    private Context context;
    private ArrayList<DetalleImagen> lista;

    public GrillaAdapter(Context context, ArrayList<DetalleImagen> objects) {
        super(context, 0, objects);
        this.context = context;
        this.lista = objects;
    }

    //Cantidad de elementos a iterar
    @Override
    public int getCount() {
        return lista.size();
    }

    //Obtener los datos de un elemento en la lista
    @Override
    public DetalleImagen getItem(int position) {
        return lista.get(position);
    }

    //Obtener el id de un elemento en la lista
    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    static class ViewHolder {
        SimpleDraweeView ivImagen;
        TextView lblTitulo;
    }

    //Creación de la parte visual
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            //Como el setContentView en el activity
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivImagen = (SimpleDraweeView) convertView.findViewById(R.id.ivImagen);
            viewHolder.lblTitulo = (TextView) convertView.findViewById(R.id.lblTitulo);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        DetalleImagen item = getItem(position);

        viewHolder.lblTitulo.setText(item.getTitulo());
        viewHolder.ivImagen.setImageURI(Uri.parse(item.getRutaImagen()));

        return convertView;
    }
}
