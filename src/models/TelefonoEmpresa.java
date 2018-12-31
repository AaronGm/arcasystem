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
public class TelefonoEmpresa {
    private int telefonoId;
    private String telefono;
    private int empresaId;

    public TelefonoEmpresa( int telefonoId, String telefono, int empresaId ) {
        this.telefonoId = telefonoId;
        this.telefono = telefono;
        this.empresaId = empresaId;
    }

    public int getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId( int telefonoId ) {
        this.telefonoId = telefonoId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono( String telefono ) {
        this.telefono = telefono;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId( int empresaId ) {
        this.empresaId = empresaId;
    }
    
}
