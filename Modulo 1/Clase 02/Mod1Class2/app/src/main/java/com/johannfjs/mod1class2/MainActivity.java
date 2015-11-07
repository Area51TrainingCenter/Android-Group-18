package com.johannfjs.mod1class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtUsuario, txtContrasenia;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validamos que nuestros dos EditText esten cargados con datos
                if (txtUsuario.getText().toString().trim().length() > 0 &&
                        txtContrasenia.getText().toString().trim().length() > 0) {

                    Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                    intent.putExtra("usuario", txtUsuario.getText().toString());
                    startActivity(intent);

                } else {
                    //Si no se han ingresado todos los campos se mostrará un mensaje de validación
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensaje_validacion),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
