package com.johannfjs.mod1class1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spData;
    private EditText txtPrecio;
    private Button btnProcesar;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spData = (Spinner) findViewById(R.id.spDatos);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        btnProcesar = (Button) findViewById(R.id.btnProcesar);
        lblResultado = (TextView) findViewById(R.id.lblResultado);

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.data));
        spData.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        spData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String data = spData.getSelectedItem().toString();
                    lblResultado.setText(data);
                } else {
                    lblResultado.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = spData.getSelectedItem().toString();
                String precio = txtPrecio.getText().toString();
                lblResultado.setText(data + " con precio " + precio);
            }
        });
    }
}
