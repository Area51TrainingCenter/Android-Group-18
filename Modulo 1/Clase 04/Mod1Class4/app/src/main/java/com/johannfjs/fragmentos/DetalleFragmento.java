package com.johannfjs.fragmentos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.mod1class4.MainActivity;
import com.johannfjs.mod1class4.R;
import com.johannfjs.mod1class4.TerceroActivity;
import com.johannfjs.models.DetalleImagen;

/**
 * Created by johannfjs on 21/11/2015.
 */
public class DetalleFragmento extends Fragment {
    private SimpleDraweeView ivImagen;
    private TextView lblTitulo;
    private Button btnAbrir;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_detalle, container, false);

        ivImagen = (SimpleDraweeView) root.findViewById(R.id.ivImagen);
        lblTitulo = (TextView) root.findViewById(R.id.lblTitulo);
        btnAbrir = (Button) root.findViewById(R.id.btnAbrir);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle bundle = getArguments();
        final int posicion = bundle.getInt("posicion");

        DetalleImagen item = MainActivity.lista.get(posicion);

        ivImagen.setImageURI(Uri.parse(item.getRutaImagen()));
        lblTitulo.setText(item.getTitulo());

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TerceroActivity.class);
                intent.putExtra("posicion", posicion);
                startActivity(intent);
            }
        });
    }
}
