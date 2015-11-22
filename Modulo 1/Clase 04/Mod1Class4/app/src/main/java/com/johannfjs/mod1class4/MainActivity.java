package com.johannfjs.mod1class4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.johannfjs.adapters.GrillaAdapter;
import com.johannfjs.models.DetalleImagen;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvGrilla;
    public static ArrayList<DetalleImagen> lista = new ArrayList<>();
    private GrillaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvGrilla = (GridView) findViewById(R.id.gvGrilla);

        for (int i = 100; i < 200; i++) {
            lista.add(new DetalleImagen(lista.size(),
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_" + i + ".jpg",
                    "Titulo " + i));
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
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);

                Bundle bundle=new Bundle();
                bundle.putInt("posicion",position);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
