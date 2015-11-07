package com.johannfjs.mod1class2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by johannfjs on 07/11/2015.
 */
public class SegundoActivity extends AppCompatActivity {
    private TextView lblTexto;
    private Button btnAtras, btnSiguiente;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().hasExtra("usuario")) {
            usuario = getIntent().getStringExtra("usuario");
            lblTexto.setText(usuario);
        }

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundoActivity.this, TerceroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("usuario", usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
