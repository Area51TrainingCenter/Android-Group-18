package com.johannfjs.mod1class4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by johannfjs on 21/11/2015.
 */
public class TerceroActivity extends AppCompatActivity {
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercero);
        lblTexto = (TextView) findViewById(R.id.lblTexto);

        int posicion = getIntent().getIntExtra("posicion", -1);
        lblTexto.setText("Posición->" + posicion);
    }
}
