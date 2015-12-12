package com.jcodee.aplicacion;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.jcodee.receiver.RedReceiver;

/**
 * Created by johannfjs on 12/12/2015.
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new RedReceiver(), intentFilter);
    }
}
