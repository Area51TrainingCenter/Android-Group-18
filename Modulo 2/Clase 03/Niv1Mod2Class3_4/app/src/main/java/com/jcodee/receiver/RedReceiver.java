package com.jcodee.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by johannfjs on 12/12/2015.
 */
public class RedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (verificarInternet(context)) {
            Toast.makeText(context, "Internet habilitado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Intenet apagado", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verificarInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            if (networkInfo.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }
}
