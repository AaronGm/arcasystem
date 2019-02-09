package models;

import java.sql.Array;

public class Direcciones {
    private int id;
    private String codigoPostal;
    private String colonia;
    private String asentamiento;
    private String municipio;
    private String estado;
    private String ciudad;

    public Direcciones(int id, String codigoPostal, String colonia, String asentamiento, String municipio, String estado, String ciudad) {
        this.id = id;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.asentamiento = asentamiento;
        this.municipio = municipio;
        this.estado = estado;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public String getAsentamiento() {
        return asentamiento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

    public String getCiudad() {
        return ciudad;
    }
}
