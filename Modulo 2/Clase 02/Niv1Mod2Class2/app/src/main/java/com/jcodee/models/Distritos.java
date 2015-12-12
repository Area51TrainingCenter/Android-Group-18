package com.jcodee.models;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class Distritos {
    private String distrito;
    private String descripcion;

    public Distritos(String distrito, String descripcion) {
        this.distrito = distrito;
        this.descripcion = descripcion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
