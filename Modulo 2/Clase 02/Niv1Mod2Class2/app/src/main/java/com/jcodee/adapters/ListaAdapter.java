package com.jcodee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.models.Distritos;
import com.jcodee.niv1mod2class2.R;

import java.util.ArrayList;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Distritos> lista;

    public ListaAdapter(Context context, ArrayList<Distritos> lista) {
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
        return 0;
    }

    static class ViewHolder {
        TextView lblDistrito, lblDescripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblDistrito = (TextView) convertView.findViewById(R.id.lblDistrito);
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Distritos item = (Distritos) getItem(position);

        viewHolder.lblDistrito.setText(item.getDistrito());
        viewHolder.lblDescripcion.setText(item.getDescripcion());

        return convertView;
    }
}
