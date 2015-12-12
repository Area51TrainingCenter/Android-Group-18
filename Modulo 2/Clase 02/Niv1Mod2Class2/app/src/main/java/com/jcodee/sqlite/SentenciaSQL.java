package com.jcodee.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jcodee.models.Distritos;
import com.jcodee.utils.Constantes;

import java.util.ArrayList;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class SentenciaSQL {
    private ManageOpenHelper dbConexion;

    public SentenciaSQL(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void insertarDistrito(String distrito, String descripcion) {
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        db.execSQL(
                "insert into " + Constantes.TB_DISTRITOS + "(" +
                        Constantes.C_DISTRITO + "," +
                        Constantes.C_DESCRIPCION + ") values('" +
                        distrito + "','" + descripcion + "')"
        );
    }

    public ArrayList<Distritos> listarDistritos() {
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from " + Constantes.TB_DISTRITOS,
                null
        );
        ArrayList<Distritos> lista = new ArrayList<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    lista.add(new Distritos(
                            cursor.getString(cursor.getColumnIndex(Constantes.C_DISTRITO)),
                            cursor.getString(cursor.getColumnIndex(Constantes.C_DESCRIPCION))
                    ));
                } while (cursor.moveToNext());
            }
        }
        return lista;
    }
}
