package com.jcodee.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jcodee.adapters.ListaAdapter;
import com.jcodee.aplicacion.Configuracion;
import com.jcodee.niv1mod2class2.MainActivity;
import com.jcodee.niv1mod2class2.R;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class DosFragment extends Fragment {
    private ListView lvLista;
    private ImageView ivMenu;
    private TextView lblTitulo;
    private ListaAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dos, container, false);

        lvLista = (ListView) root.findViewById(R.id.lvLista);
        ivMenu = (ImageView) root.findViewById(R.id.ivMenu);
        lblTitulo = (TextView) root.findViewById(R.id.lblTitulo);

        lblTitulo.setText("Pantalla Dos");

        adapter = new ListaAdapter(getActivity(), Configuracion.sentenciaSQL.listarDistritos());
        lvLista.setAdapter(adapter);

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
    }
}
