package com.johannfjs.mod1class1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaramos las variables
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Vinculamos las variables con la parte de diseño
        texto = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Cambiamos el texto de nuestro componente
        texto.setText(getResources().getString(R.string.mensaje));
        texto.setTextColor(getResources().getColor(R.color.blanco));
        texto.setBackgroundColor(getResources().getColor(R.color.negro));
        texto.setTextSize(getResources().getDimension(R.dimen.tamanio_dos));

    }
}
