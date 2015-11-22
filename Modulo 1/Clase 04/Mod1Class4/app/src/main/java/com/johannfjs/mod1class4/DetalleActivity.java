package com.johannfjs.mod1class4;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.johannfjs.adapters.FragmentAdapter;
import com.johannfjs.animaciones.ZoomOutPageTransformer;

/**
 * Created by johannfjs on 21/11/2015.
 */
public class DetalleActivity extends FragmentActivity {
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = (ViewPager) findViewById(R.id.vpImagenes);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        int posicion = bundle.getInt("posicion");
        //Creamos nuestro adapter
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        //Cambiando la posición o el foco a el item que tenemos o hemos seleccionado
        viewPager.setCurrentItem(posicion);
    }
}
