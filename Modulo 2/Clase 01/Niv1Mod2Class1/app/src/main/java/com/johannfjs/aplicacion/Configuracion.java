package com.johannfjs.aplicacion;

import android.app.Application;

import com.johannfjs.sqlite.SentenciaSQL;

/**
 * Created by johannfjs on 28/11/2015.
 */
public class Configuracion extends Application {
    public static SentenciaSQL sentenciaSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        sentenciaSQL = new SentenciaSQL(getApplicationContext());
    }
}
