package com.johannfjs.mod1class2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.models.Objeto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvLista;
    private ArrayList<Objeto> lista = new ArrayList<Objeto>();
    private ListaAdapter adapter;
    private EditText txtTextoUno, txtTextoDos, txtTextoTres, txtTextoCuatro;
    private Button btnGrabar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = (ListView) findViewById(R.id.lvLista);
        txtTextoUno = (EditText) findViewById(R.id.txtTextoUno);
        txtTextoDos = (EditText) findViewById(R.id.txtTextoDos);
        txtTextoTres = (EditText) findViewById(R.id.txtTextoTres);
        txtTextoCuatro = (EditText) findViewById(R.id.txtTextoCuatro);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);

        /*
        lista.add(new Objeto("Hola", "a", "todos", ":)"));
        lista.add(new Objeto("Texto", "a", "todos", ":("));
        lista.add(new Objeto("Atención", "a", "todos", ":D"));
        lista.add(new Objeto("Probando", "a", "todos", ":'("));
        lista.add(new Objeto("Leyendo", "a", "todos", "x)"));
        lista.add(new Objeto("Escribiendo", "a", "todos", "xD"));
        lista.add(new Objeto("Redactando", "a", "todos", "=)"));
        lista.add(new Objeto("Saludando", "a", "todos", "=D"));
*/

        //Inicializamos nuestro adapter
        adapter = new ListaAdapter(getApplicationContext(), lista);
        //Cambiamos el adapter de nuestra lista
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Evento de la lista para seleccionar un elemento
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Obtenemos el objeto de la lista por la posición
                Objeto item = lista.get(position);
                //Mostramos los datos que contiene la lista
                Toast.makeText(getApplicationContext(),
                        item.getTextoUno() + " " + item.getTextoDos() + " " + item.getTextoTres(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validamos que los campos esten cargados
                if (txtTextoUno.getText().toString().trim().length() > 0 &&
                        txtTextoDos.getText().toString().trim().length() > 0 &&
                        txtTextoTres.getText().toString().trim().length() > 0 &&
                        txtTextoCuatro.getText().toString().trim().length() > 0) {
                    lista.add(new Objeto(
                            txtTextoUno.getText().toString(),
                            txtTextoDos.getText().toString(),
                            txtTextoTres.getText().toString(),
                            txtTextoCuatro.getText().toString()
                    ));
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.validacion),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
