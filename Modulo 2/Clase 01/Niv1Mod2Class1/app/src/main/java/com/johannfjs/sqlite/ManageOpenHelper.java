package com.johannfjs.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.johannfjs.utils.Constantes;

/**
 * Created by johannfjs on 28/11/2015.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREAR_PERSONA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {
            case 2:
                //Sentencias de cambios en la base de datos al actualizar de versión
                db.execSQL(Constantes.CREAR_ESTADO);
                db.execSQL("insert into " + Constantes.TB_ESTADO + "(" + Constantes.C_DESCRIPCION +
                        ") values('Soltero')");
                db.execSQL("insert into " + Constantes.TB_ESTADO + "(" + Constantes.C_DESCRIPCION +
                        ") values('Casado')");
                db.execSQL("insert into " + Constantes.TB_ESTADO + "(" + Constantes.C_DESCRIPCION +
                        ") values('Viudo')");
                db.execSQL("insert into " + Constantes.TB_ESTADO + "(" + Constantes.C_DESCRIPCION +
                        ") values('Divorciado')");
                break;

        }
    }
}
