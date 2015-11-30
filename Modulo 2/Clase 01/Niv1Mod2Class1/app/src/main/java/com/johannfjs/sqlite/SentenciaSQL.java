package com.johannfjs.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.models.Persona;
import com.johannfjs.utils.Constantes;

import java.util.ArrayList;

/**
 * Created by johannfjs on 28/11/2015.
 */
public class SentenciaSQL {
    private ManageOpenHelper conexion;

    public SentenciaSQL(Context context) {
        conexion = new ManageOpenHelper(context);
    }

    public void insertarPersona(Persona persona) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        //insert into tb_persona(nombre,apellido,estadoCivil)
        //values('nombre','apellido','estadoCivil')

        db.beginTransaction();
        try {
            db.execSQL(
                    "insert into " + Constantes.TB_PERSONA + "(" +
                            Constantes.C_NOMBRE + "," + Constantes.C_APELLIDO +
                            "," + Constantes.C_ESTADO_CIVIL + ") values('" +
                            persona.getNombre() + "','" + persona.getApellido() +
                            "','" + persona.getEstadoCivil() + "')"
            );

            db.setTransactionSuccessful();
        }catch (Exception e){

        }finally {
            db.endTransaction();
        }
    }

    public void insertaPersona(Persona persona) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.C_NOMBRE, persona.getNombre());
        contentValues.put(Constantes.C_APELLIDO, persona.getApellido());
        contentValues.put(Constantes.C_ESTADO_CIVIL, persona.getEstadoCivil());

        db.insert(Constantes.TB_PERSONA, null, contentValues);
    }

    public ArrayList<Persona> listarTodo() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from " + Constantes.TB_PERSONA,
                null
        );

        ArrayList<Persona> lista = new ArrayList<>();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Persona persona = new Persona();
                    persona.setId(cursor.getInt(cursor.getColumnIndex(Constantes.C_ID)));
                    persona.setNombre(cursor.getString(cursor.getColumnIndex(Constantes.C_NOMBRE)));
                    persona.setApellido(cursor.getString(cursor.getColumnIndex(Constantes.C_APELLIDO)));
                    persona.setEstadoCivil(cursor.getString(cursor.getColumnIndex(Constantes.C_ESTADO_CIVIL)));

                    lista.add(persona);
                } while (cursor.moveToNext());
            }
        }
        return lista;
    }

    public void actualizarPersona(Persona persona) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        //update tb_persona set nombre='nombre', apellido='apellido', estadoCivil='estadoCivil'
        //where id=id
        db.execSQL(
                "update " + Constantes.TB_PERSONA + " set " + Constantes.C_NOMBRE + "='" + persona.getNombre() +
                        "'," + Constantes.C_APELLIDO + "='" + persona.getApellido() + "'," + Constantes.C_ESTADO_CIVIL +
                        "='" + persona.getEstadoCivil() + "' where " + Constantes.C_ID + "=" + persona.getId()
        );
    }

    public void actualizaPersona(Persona persona) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.C_NOMBRE, persona.getNombre());
        contentValues.put(Constantes.C_APELLIDO, persona.getApellido());
        contentValues.put(Constantes.C_ESTADO_CIVIL, persona.getEstadoCivil());

        db.update(Constantes.TB_PERSONA, contentValues, Constantes.C_ID + "=?", new String[]{Integer.toString(persona.getId())});
    }

    public void eliminarPersona(int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();
        //delete from tb_persona where id=id
        db.execSQL(
                "delete from " + Constantes.TB_PERSONA + " where " + Constantes.C_ID + "=" + id
        );
    }

    public void eliminaPersona(int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        db.delete(Constantes.TB_PERSONA, Constantes.C_ID + "=?", new String[]{Integer.toString(id)});
    }

    public ArrayList<String> listarEstados() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from " + Constantes.TB_ESTADO,
                null
        );
        ArrayList<String> lista = new ArrayList<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    lista.add(cursor.getString(cursor.getColumnIndex(Constantes.C_DESCRIPCION)));
                } while (cursor.moveToNext());
            }
        }
        return lista;
    }
}
