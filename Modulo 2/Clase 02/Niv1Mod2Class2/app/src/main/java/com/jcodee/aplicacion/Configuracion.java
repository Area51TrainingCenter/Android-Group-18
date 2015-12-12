package com.jcodee.aplicacion;

import android.app.Application;

import com.jcodee.sqlite.SentenciaSQL;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class Configuracion extends Application {
    public static SentenciaSQL sentenciaSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        sentenciaSQL = new SentenciaSQL(getApplicationContext());
    }
}
