package com.johannfjs.utils;

/**
 * Created by johannfjs on 28/11/2015.
 */
public class Constantes {
    public static final String DB_NAME = "nivmod2class1.db";
    public static final int DB_VERSION = 2;

    public static final String TB_PERSONA = "tb_persona";

    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_APELLIDO = "apellido";
    public static final String C_ESTADO_CIVIL = "estadoCivil";

    public static final String CREAR_PERSONA = "create table " + TB_PERSONA + "(" +
            C_ID + " integer primary key autoincrement," + C_NOMBRE + " text," +
            C_APELLIDO + " text," + C_ESTADO_CIVIL + " text)";
    //create table tb_persona(id integer primary key autoincrement, nombre text, apellido text, estadoCivil text)

    public static final String TB_ESTADO = "tb_estado";

    public static final String C_DESCRIPCION = "descripcion";

    public static final String CREAR_ESTADO = "create table " + TB_ESTADO + "(" +
            C_ID + " integer primary key autoincrement," + C_DESCRIPCION + " text)";
}
