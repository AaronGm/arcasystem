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
public class Carrera {
    private String claveCarrera;
    private String nombre;
    private String planCarrera;

    public Carrera( String claveCarrera, String nombre, String planCarrera ) {
        this.claveCarrera = claveCarrera;
        this.nombre = nombre;
        this.planCarrera = planCarrera;
    }

    public String getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera( String claveCarrera ) {
        this.claveCarrera = claveCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getPlanCarrera() {
        return planCarrera;
    }

    public void setPlanCarrera( String planCarrera ) {
        this.planCarrera = planCarrera;
    }
}
