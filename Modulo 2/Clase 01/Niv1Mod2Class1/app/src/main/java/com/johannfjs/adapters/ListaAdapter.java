package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.models.Persona;
import com.johannfjs.niv1mod2class1.R;

import java.util.ArrayList;

/**
 * Created by johannfjs on 28/11/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Persona> lista;

    public ListaAdapter(Context context, ArrayList<Persona> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    static class ViewHolder {
        TextView lblNombre, lblApellido, lblEstadoCivil;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellido = (TextView) convertView.findViewById(R.id.lblApellido);
            viewHolder.lblEstadoCivil = (TextView) convertView.findViewById(R.id.lblEstadoCivil);

            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Persona item = (Persona) getItem(position);

        viewHolder.lblNombre.setText(item.getNombre());
        viewHolder.lblApellido.setText(item.getApellido());
        viewHolder.lblEstadoCivil.setText(item.getEstadoCivil());
        return convertView;
    }
}
