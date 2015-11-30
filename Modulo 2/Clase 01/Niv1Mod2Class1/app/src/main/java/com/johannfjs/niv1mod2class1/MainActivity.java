package com.johannfjs.niv1mod2class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.models.Persona;
import com.johannfjs.sqlite.SentenciaSQL;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtApellido;
    private Spinner spEstadoCivil;
    private Button btnGuardar, btnActualizar, btnEliminar;

    private ListView lvLista;
    private ListaAdapter adapter;
    ArrayList<Persona> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        spEstadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        lvLista = (ListView) findViewById(R.id.lvLista);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        listar();

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                Configuracion.sentenciaSQL.listarEstados());

        spEstadoCivil.setAdapter(arrayAdapter);
    }

    private void listar() {

        lista = Configuracion.sentenciaSQL.listarTodo();

        adapter = new ListaAdapter(getApplicationContext(), lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().length() == 0) {
                    txtNombre.setError("Campo nombre requerido");
                } else if (txtApellido.getText().toString().length() == 0) {
                    txtApellido.setError("Campo apellido requerido");
                } else {
                    Persona persona = new Persona();
                    persona.setNombre(txtNombre.getText().toString());
                    persona.setApellido(txtApellido.getText().toString());
                    persona.setEstadoCivil(spEstadoCivil.getSelectedItem().toString());
                    Configuracion.sentenciaSQL.insertarPersona(persona);

                    txtNombre.setText("");
                    txtApellido.setText("");
                    spEstadoCivil.setSelection(0);
                    Toast.makeText(getApplicationContext(), "Se guardo", Toast.LENGTH_SHORT).show();
                    listar();
                }
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btnGuardar.setVisibility(View.INVISIBLE);
                btnActualizar.setVisibility(View.VISIBLE);
                btnEliminar.setVisibility(View.VISIBLE);

                Persona persona = lista.get(position);
                btnActualizar.setTag(persona.getId());

                txtNombre.setText(persona.getNombre());
                txtApellido.setText(persona.getApellido());

                String[] estadoCivil = getResources().getStringArray(R.array.estadoCivil);
                for (int i = 0; i < estadoCivil.length; i++) {
                    if (persona.getEstadoCivil().equals(estadoCivil[i])) {
                        spEstadoCivil.setSelection(i);
                        break;
                    }
                }
            }
        });
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer) btnActualizar.getTag();
                Persona persona = new Persona();
                persona.setNombre(txtNombre.getText().toString());
                persona.setApellido(txtApellido.getText().toString());
                persona.setEstadoCivil(spEstadoCivil.getSelectedItem().toString());
                persona.setId(id);

                Configuracion.sentenciaSQL.actualizaPersona(persona);

                txtNombre.setText("");
                txtApellido.setText("");
                spEstadoCivil.setSelection(0);
                btnActualizar.setVisibility(View.INVISIBLE);
                btnEliminar.setVisibility(View.INVISIBLE);
                btnGuardar.setVisibility(View.VISIBLE);
                listar();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer) btnActualizar.getTag();

                Configuracion.sentenciaSQL.eliminaPersona(id);
                txtNombre.setText("");
                txtApellido.setText("");
                spEstadoCivil.setSelection(0);
                btnActualizar.setVisibility(View.INVISIBLE);
                btnEliminar.setVisibility(View.INVISIBLE);
                btnGuardar.setVisibility(View.VISIBLE);
                listar();
            }
        });
    }
}
