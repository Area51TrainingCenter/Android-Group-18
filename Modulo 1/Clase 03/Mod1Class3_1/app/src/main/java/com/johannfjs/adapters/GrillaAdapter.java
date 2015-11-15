package com.johannfjs.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.mod1class3_1.R;
import com.johannfjs.models.Cupon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 14/11/2015.
 */
public class GrillaAdapter extends ArrayAdapter<Cupon> {
    private Context context;
    private ArrayList<Cupon> lista;

    public GrillaAdapter(Context context, ArrayList<Cupon> objects) {
        super(context, 0, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        SimpleDraweeView ivImagen;
        TextView lblTitulo, lblSubtitulo, lblTextoUno, lblTextoDos, lblPrecioUno, lblPrecioDos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblTitulo = (TextView) convertView.findViewById(R.id.lblTitulo);
            viewHolder.lblSubtitulo = (TextView) convertView.findViewById(R.id.lblSubtitulo);
            viewHolder.lblTextoUno = (TextView) convertView.findViewById(R.id.lblTextoUno);
            viewHolder.lblTextoDos = (TextView) convertView.findViewById(R.id.lblTextoDos);
            viewHolder.lblPrecioUno = (TextView) convertView.findViewById(R.id.lblPrecioUno);
            viewHolder.lblPrecioDos = (TextView) convertView.findViewById(R.id.lblPrecioDos);
            viewHolder.ivImagen = (SimpleDraweeView) convertView.findViewById(R.id.ivImagen);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        Cupon item = lista.get(position);

        viewHolder.lblTitulo.setText(item.getTitulo());
        viewHolder.lblSubtitulo.setText(item.getSubtitulo());
        viewHolder.lblTextoUno.setText(item.getTextoDos());
        viewHolder.lblPrecioUno.setText(item.getPrecioUno());
        viewHolder.lblPrecioDos.setText(item.getPrecioDos());

        viewHolder.ivImagen.setImageURI(Uri.parse(item.getRutaImagen()));

        return convertView;
    }
}
