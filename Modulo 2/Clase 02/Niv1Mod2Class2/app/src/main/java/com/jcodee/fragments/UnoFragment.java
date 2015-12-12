package com.jcodee.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodee.aplicacion.Configuracion;
import com.jcodee.niv1mod2class2.MainActivity;
import com.jcodee.niv1mod2class2.R;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class UnoFragment extends Fragment {
    private ImageView ivMenu;
    private EditText txtDistrito, txtDescripcion;
    private Button btnGuardar;
    private TextView lblTitulo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_uno, container, false);
        ivMenu = (ImageView) root.findViewById(R.id.ivMenu);
        txtDistrito = (EditText) root.findViewById(R.id.txtDistrito);
        txtDescripcion = (EditText) root.findViewById(R.id.txtDescripcion);
        btnGuardar = (Button) root.findViewById(R.id.btnGuardar);
        lblTitulo = (TextView) root.findViewById(R.id.lblTitulo);

        lblTitulo.setText("Pantalla Uno");
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).toggle();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuracion.sentenciaSQL.insertarDistrito(
                        txtDistrito.getText().toString(),
                        txtDescripcion.getText().toString()
                );
                txtDistrito.setText("");
                txtDescripcion.setText("");
                txtDistrito.requestFocus();
            }
        });
    }
}
