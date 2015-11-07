package com.johannfjs.models;

/**
 * Created by johannfjs on 07/11/2015.
 */
public class Objeto {
    private String textoUno;
    private String textoDos;
    private String textoTres;
    private String textoCuatro;

    public Objeto(String textoUno, String textoDos, String textoTres, String textoCuatro) {
        this.textoUno = textoUno;
        this.textoDos = textoDos;
        this.textoTres = textoTres;
        this.textoCuatro = textoCuatro;
    }

    public String getTextoUno() {
        return textoUno;
    }

    public void setTextoUno(String textoUno) {
        this.textoUno = textoUno;
    }

    public String getTextoDos() {
        return textoDos;
    }

    public void setTextoDos(String textoDos) {
        this.textoDos = textoDos;
    }

    public String getTextoTres() {
        return textoTres;
    }

    public void setTextoTres(String textoTres) {
        this.textoTres = textoTres;
    }

    public String getTextoCuatro() {
        return textoCuatro;
    }

    public void setTextoCuatro(String textoCuatro) {
        this.textoCuatro = textoCuatro;
    }
}
