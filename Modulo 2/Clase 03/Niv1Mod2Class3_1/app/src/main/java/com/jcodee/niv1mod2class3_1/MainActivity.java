package com.jcodee.niv1mod2class3_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtApellido, txtCargo;
    private Button btnGuardar, btnObtener, btnEliminar, btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtCargo = (EditText) findViewById(R.id.txtCargo);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);

        if (getIntent() != null) {
            if (getIntent().hasExtra("nombre")) {
                String nombre = getIntent().getStringExtra("nombre");
                txtNombre.setText(nombre);
            }
            if (getIntent().hasExtra("apellido")) {
                String apellido = getIntent().getStringExtra("apellido");
                txtApellido.setText(apellido);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor share = getSharedPreferences("niv1mod2class3_1", MODE_PRIVATE).edit();
                share.putString("nombre", txtNombre.getText().toString());
                share.putString("apellido", txtApellido.getText().toString());
                share.putString("cargo", txtCargo.getText().toString());
                share.commit();
                Toast.makeText(getApplicationContext(), "Se guardo correctamente", Toast.LENGTH_SHORT).show();
            }
        });
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("niv1mod2class3_1", MODE_PRIVATE);
                Toast.makeText(getApplicationContext(),
                        sharedPreferences.getString("nombre", "") + " " +
                                sharedPreferences.getString("apellido", "") + " " +
                                sharedPreferences.getString("cargo", ""),
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor share = getSharedPreferences("niv1mod2class3_1", MODE_PRIVATE).edit();
                //share.clear();
                //share.commit();

                share.remove("nombre");
                share.commit();
                Toast.makeText(getApplicationContext(), "Se borro", Toast.LENGTH_SHORT).show();
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor share = getSharedPreferences("niv1mod2class3_1", MODE_PRIVATE).edit();
                share.putString("apellido", txtApellido.getText().toString());
                share.commit();
                Toast.makeText(getApplicationContext(), "Se modifico", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
