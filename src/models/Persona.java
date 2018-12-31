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
public class Persona {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    
    public Persona( String nombres, String apellidoPaterno, String apellidoMaterno ) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres( String nombres ) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno( String apellidoPaterno ) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno( String apellidoMaterno ) {
        this.apellidoMaterno = apellidoMaterno;
    }
        
}
