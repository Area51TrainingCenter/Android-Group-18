package com.johannfjs.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 21/11/2015.
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Inicializamos la libreria FrescoLib
        Fresco.initialize(getApplicationContext());
    }
}
