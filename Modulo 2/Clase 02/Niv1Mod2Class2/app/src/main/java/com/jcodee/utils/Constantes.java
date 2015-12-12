package com.jcodee.utils;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class Constantes {
    public static int DB_VERSION = 1;
    public static String DB_NAME = "niv1mod2class2.db";

    public static String TB_DISTRITOS = "tb_distritos";
    public static String C_DESCRIPCION = "descripcion";
    public static String C_DISTRITO = "distrito";
    public static String C_ID = "id";

    public static String CREAR_DISTRITOS = "CREATE TABLE " + TB_DISTRITOS + "(" +
            C_ID + " integer primary key," +
            C_DESCRIPCION + " text," +
            C_DISTRITO + " text)";
}
