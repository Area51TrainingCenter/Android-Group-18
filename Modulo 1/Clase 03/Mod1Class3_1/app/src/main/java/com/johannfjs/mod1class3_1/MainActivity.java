package com.johannfjs.mod1class3_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.johannfjs.adapters.GrillaAdapter;
import com.johannfjs.models.Cupon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvGrilla;
    private GrillaAdapter adapter;
    private ArrayList<Cupon> lista = new ArrayList<Cupon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvGrilla = (GridView) findViewById(R.id.gvGrilla);

        for (int i = 1; i < 50; i++) {
            Cupon item = new Cupon();
            item.setTitulo("Titulo " + i);
            item.setSubtitulo("Subtitulo " + i);
            item.setTextoUno("Texto Uno " + i);
            item.setTextoDos("Texto Dos " + i);
            item.setPrecioUno("Precio Uno " + i);
            item.setPrecioDos("Precio Dos " + i);
            item.setRutaImagen(
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_0" +
                            (String.valueOf(i).length() == 2 ? i : "0" + i) +
                            ".jpg");
            lista.add(item);
        }

        adapter = new GrillaAdapter(getApplicationContext(), lista);
        gvGrilla.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SegundoActivity.class);

                Bundle bundle = new Bundle();
                Cupon item = lista.get(position);

                bundle.putString("titulo", item.getTitulo());
                bundle.putString("subtitulo", item.getSubtitulo());
                bundle.putString("textoUno", item.getTextoUno());
                bundle.putString("textoDos", item.getTextoDos());
                bundle.putString("precioUno", item.getPrecioUno());
                bundle.putString("precioDos", item.getPrecioDos());
                bundle.putString("rutaImagen", item.getRutaImagen());

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
