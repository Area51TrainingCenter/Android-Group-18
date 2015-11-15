package com.johannfjs.mod1class3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.johannfjs.models.Direcciones;
import com.johannfjs.utils.Constantes;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtDireccion;
    private Spinner spDistritos;
    private Button btnGrabar, btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDireccion = (EditText) findViewById(R.id.txtDireccion);
        spDistritos = (Spinner) findViewById(R.id.spDistrito);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        btnSiguiente = (Button) findViewById(R.id.btnListado);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                startActivity(intent);
            }
        });
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Direcciones item = new Direcciones();
                item.setId(Constantes.lista.size() + 1);
                item.setNombre(txtNombre.getText().toString());
                item.setDireccion(txtDireccion.getText().toString());
                item.setDistrito(spDistritos.getSelectedItem().toString());
                Constantes.lista.add(item);
            }
        });
    }
}
