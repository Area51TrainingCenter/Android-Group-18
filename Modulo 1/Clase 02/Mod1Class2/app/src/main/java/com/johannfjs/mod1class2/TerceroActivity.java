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
public class TerceroActivity extends AppCompatActivity {
    private TextView lblTexto;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercero);

        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("usuario")) {
                String usuario = getIntent().getExtras().getString("usuario");
                lblTexto.setText(usuario);
            }
        }

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerceroActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
