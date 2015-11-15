package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod1class3.R;
import com.johannfjs.models.Direcciones;

import java.util.ArrayList;

/**
 * Created by johannfjs on 14/11/2015.
 */
public class ListaAdapter extends BaseAdapter {
    //Para obtener la pantalla donde se va realizar el listado
    Context context;
    //Colección de datos
    ArrayList<Direcciones> lista;

    public ListaAdapter(Context context, ArrayList<Direcciones> lista) {
        this.context = context;
        this.lista = lista;
    }

    //----------
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //----------
    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    static class ViewHolder {
        TextView lblDistrito, lblDireccion, lblNombre;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Para no cargar varias variables en memoria
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            //Inicializamos nuestras variables, vinculandolas a nuestro diseño
            viewHolder = new ViewHolder();
            viewHolder.lblDistrito = (TextView) convertView.findViewById(R.id.lblDistritos);
            viewHolder.lblDireccion = (TextView) convertView.findViewById(R.id.lblDireccion);
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        //Obtenemos el objeto de nuestra lista por la posición
        Direcciones item = (Direcciones) getItem(position);

        viewHolder.lblNombre.setTextSize(18);
        viewHolder.lblDireccion.setTextSize(17);
        viewHolder.lblDistrito.setTextSize(20);

        if (item.getNombre().toString().trim().length() > 0) {
            viewHolder.lblNombre.setText(item.getNombre() + " " + item.getId());
            viewHolder.lblNombre.setVisibility(View.VISIBLE);
        } else {
            //INVISIBLE ocupa un espacio en la pantalla
            //GONE no ocupa un espacio, es como si no existiera
            viewHolder.lblNombre.setVisibility(View.GONE);
        }
        if (item.getDistrito().toString().trim().length() > 0) {
            viewHolder.lblDistrito.setText(item.getDistrito());
            viewHolder.lblDistrito.setVisibility(View.VISIBLE);
        } else {
            viewHolder.lblDistrito.setVisibility(View.GONE);
        }
        if (item.getDireccion().toString().trim().length() > 0) {
            viewHolder.lblDireccion.setText(item.getDireccion());
            viewHolder.lblDireccion.setVisibility(View.VISIBLE);
        } else {
            viewHolder.lblDireccion.setVisibility(View.GONE);
        }

        return convertView;
    }
}
