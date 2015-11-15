package com.johannfjs.mod1class3_1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

/**
 * Created by johannfjs on 14/11/2015.
 */
public class SegundoActivity extends AppCompatActivity {
    private SimpleDraweeView ivImagen;
    private TextView lblTitulo, lblSubtitulo, lblTextoUno, lblTextoDos, lblPrecioUno, lblPrecioDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        ivImagen = (SimpleDraweeView) findViewById(R.id.ivImagen);
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblSubtitulo = (TextView) findViewById(R.id.lblSubtitulo);
        lblTextoUno = (TextView) findViewById(R.id.lblTextoUno);
        lblTextoDos = (TextView) findViewById(R.id.lblTextoDos);
        lblPrecioUno = (TextView) findViewById(R.id.lblPrecioUno);
        lblPrecioDos = (TextView) findViewById(R.id.lblPrecioDos);

        if (getIntent().getExtras().containsKey("titulo")) {
            String titulo = getIntent().getExtras().getString("titulo");
            lblTitulo.setText(titulo);
        }
        if (getIntent().getExtras().containsKey("rutaImagen")) {
            String rutaImagen = getIntent().getExtras().getString("rutaImagen");
            ivImagen.setImageURI(Uri.parse(rutaImagen));
        }
    }
}
