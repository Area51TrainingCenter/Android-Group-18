package com.johannfjs.mod1class3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.utils.Constantes;

/**
 * Created by johannfjs on 14/11/2015.
 */
public class SegundoActivity extends AppCompatActivity {
    private ListView lvLista;
    private ListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Vinculamos nuestra clase java con el xml
        setContentView(R.layout.activity_segundo);

        lvLista = (ListView) findViewById(R.id.lvLista);

        adapter = new ListaAdapter(getApplicationContext(), Constantes.lista);
        lvLista.setAdapter(adapter);
    }
}
