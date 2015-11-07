package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod1class2_1.R;
import com.johannfjs.models.Objeto;

import java.util.ArrayList;

/**
 * Created by johannfjs on 07/11/2015.
 */
public class ListaAdapter extends BaseAdapter {
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

    //Se construye el item con la parte visual
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //LayoutInflater es como el setContentView del activity
            //Sirve para agregar la parte visual
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }
        //Declaramos nuestras variables y las vinculamos con los componentes de la parte visual
        TextView lblTextoUno = (TextView) convertView.findViewById(R.id.lblTextoUno);
        TextView lblTextoDos = (TextView) convertView.findViewById(R.id.lblTextoDos);
        TextView lblTextoTres = (TextView) convertView.findViewById(R.id.lblTextoTres);
        TextView lblTextoCuatro = (TextView) convertView.findViewById(R.id.lblTextoCuatro);

        //Obtenemos el item de nuestra lista según la posición
        Objeto item = (Objeto) getItem(position);
        //Seteamos los valores de nuestros componentes por los que hemos obtenido
        lblTextoUno.setText(item.getTextoUno());
        lblTextoDos.setText(item.getTextoDos());
        lblTextoTres.setText(item.getTextoTres());
        lblTextoCuatro.setText(item.getTextoCuatro());

        //Retornamos la parte visual
        return convertView;
    }
}
