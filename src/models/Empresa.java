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
    private String nombre;
    private String encargado;
    private String domicilio;
    private String paginaWeb;

    public Empresa( int empresaId, String nombre, String encargado, String domicilio, String paginaWeb ) {
        this.empresaId = empresaId;
        this.nombre = nombre;
        this.encargado = encargado;
        this.domicilio = domicilio;
        this.paginaWeb = paginaWeb;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId( int empresaId ) {
        this.empresaId = empresaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado( String encargado ) {
        this.encargado = encargado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio( String domicilio ) {
        this.domicilio = domicilio;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb( String paginaWeb ) {
        this.paginaWeb = paginaWeb;
    }
        
}
