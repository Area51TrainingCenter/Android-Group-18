package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class2_1.R;
import com.johannfjs.models.Objeto;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by johannfjs on 07/11/2015.
 */
public class ListaAdapter extends BaseAdapter {
    ImageLoader imageLoader = ImageLoader.getInstance();
    private Context context;
    private ArrayList<Objeto> lista;

    public ListaAdapter(Context context, ArrayList<Objeto> lista) {
        this.context = context;
        this.lista = lista;
    }

    //Cantidad de elementos que tiene nuestra lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Obtenemos el objeto de la lista por la posición
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //Obtenemos el id de la lista por la posición
    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        TextView lblTextoUno, lblTextoDos, lblTextoTres, lblTextoCuatro;
        ImageView ivImagen;
    }

    //Se construye el item con la parte visual
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblTextoUno = (TextView) convertView.findViewById(R.id.lblTextoUno);
            viewHolder.lblTextoDos = (TextView) convertView.findViewById(R.id.lblTextoDos);
            viewHolder.lblTextoTres = (TextView) convertView.findViewById(R.id.lblTextoTres);
            viewHolder.lblTextoCuatro = (TextView) convertView.findViewById(R.id.lblTextoCuatro);
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Objeto item = (Objeto) getItem(position);
        viewHolder.lblTextoUno.setText(item.getTextoUno());
        viewHolder.lblTextoDos.setText(item.getTextoDos());
        viewHolder.lblTextoTres.setText(item.getTextoTres());
        viewHolder.lblTextoCuatro.setText(item.getTextoCuatro());

        imageLoader.displayImage(item.getRutaImagen(), viewHolder.ivImagen);

        //Retornamos la parte visual
        return convertView;
    }
}
