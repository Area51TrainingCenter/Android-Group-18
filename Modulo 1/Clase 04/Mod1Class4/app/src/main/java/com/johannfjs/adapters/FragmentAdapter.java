package com.johannfjs.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.johannfjs.fragmentos.DetalleFragmento;
import com.johannfjs.mod1class4.MainActivity;

/**
 * Created by johannfjs on 21/11/2015.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    //Constructor donde nos solicita el fragmentmanager de la versión de soporte v4
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    //Donde creamos la vista
    @Override
    public Fragment getItem(int position) {
        //Crear un fragmento
        DetalleFragmento fragmento = new DetalleFragmento();
        //Creano un bundle
        Bundle bundle = new Bundle();
        //Cargando los datos que llegaran al fragmento
        bundle.putInt("posicion", position);
        //Añadimos los datos al fragmento
        fragmento.setArguments(bundle);
        //Retornamos el fragmento
        return fragmento;
    }

    //
    @Override
    public int getCount() {
        return MainActivity.lista.size();
    }
}
