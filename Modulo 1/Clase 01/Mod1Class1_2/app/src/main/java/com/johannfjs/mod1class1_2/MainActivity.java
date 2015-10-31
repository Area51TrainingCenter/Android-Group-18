package com.johannfjs.mod1class1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private Button procesar, mostrar, html;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.txtTexto);
        procesar = (Button) findViewById(R.id.btnEjecutar);
        resultado = (TextView) findViewById(R.id.lblResultado);
        mostrar = (Button) findViewById(R.id.btnMostrar);
        html = (Button) findViewById(R.id.btnHTML);
    }

    @Override
    protected void onResume() {
        super.onResume();
        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos el contenido del edittext
                String nombreTexto = nombre.getText().toString();
                //Ponemos el contenido en el textview
                resultado.setText(nombreTexto);
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getApplicationContext()
                //MainActivity.this
                //Obtenemos el contenido del edittext
                String nombreTexto = nombre.getText().toString();
                //Toast.makeText(getApplicationContext(), nombreTexto, Toast.LENGTH_SHORT).show();
                //Creamos el mensaje flotante
                Toast toast = Toast.makeText(getApplicationContext(), nombreTexto, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreTexto = nombre.getText().toString();
                resultado.setText(Html.fromHtml(nombreTexto));
            }
        });
    }
}
