/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author aarongmx
 */
public class Empresa {
    private int empresaId;
    private String rfc;
    private String nombre;
    private String encargado;
    private String domicilio;
    private String colonia;
    private String codigoPostal;
    private String alcaldiaMunicipio;
    private String paginaWeb;

    public static final String EMPRESA_ID = "empresa_id";
    public static final String RFC = "rfc";
    public static final String NOMBRE = "nombre";
    public static final String ENCARGADO = "encargado";
    public static final String DOMICILIO = "domicilio";
    public static final String COLONIA = "colonia";
    public static final String CODIGO_POSTAL = "codigo_postal";
    public static final String ALCALDIA_MUNICIPIO = "alcaldia_municipio";
    public static final String PAGINA_WEB = "pagina_web";

    public Empresa(int empresaId, String rfc, String nombre, String encargado, String domicilio, String colonia, String codigoPostal, String alcaldiaMunicipio, String paginaWeb) {
        this.empresaId = empresaId;
        this.rfc = rfc;
        this.nombre = nombre;
        this.encargado = encargado;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.alcaldiaMunicipio = alcaldiaMunicipio;
        this.paginaWeb = paginaWeb;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getAlcaldiaMunicipio() {
        return alcaldiaMunicipio;
    }

    public void setAlcaldiaMunicipio(String alcaldiaMunicipio) {
        this.alcaldiaMunicipio = alcaldiaMunicipio;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
