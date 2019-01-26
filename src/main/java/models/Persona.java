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
    
    /**
     * Columnas en la base de datos
     */
    public static final String NOMBRES = "nombres";
    public static final String APELLIDO_PATERNO = "apellido_paterno";
    public static final String APELLIDO_MATERNO = "apellido_materno";
    
    
    
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

    public String getNombreCompleto() {
        return this.nombres + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
        
}
