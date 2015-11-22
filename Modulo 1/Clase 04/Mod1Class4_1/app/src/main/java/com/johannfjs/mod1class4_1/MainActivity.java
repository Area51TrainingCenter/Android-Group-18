package com.johannfjs.mod1class4_1;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView lblTitulo, lblSubtitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblSubtitulo = (TextView) findViewById(R.id.lblSubtitulo);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        lblTitulo.setTypeface(typeface);
        lblSubtitulo.setTypeface(typeface);
    }
}
