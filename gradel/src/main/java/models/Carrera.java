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
    private String planEstudios;

    public static final String CLAVE_CARRERA = "clave_carrera";
    public static final String NOMBRE = "nombre";
    public static final String PLAN_ESTUDIOS = "plan_estudios";

    public Carrera() {

    }

    public Carrera( String claveCarrera, String nombre, String planEstudios) {
        this.claveCarrera = claveCarrera;
        this.nombre = nombre;
        this.planEstudios = planEstudios;
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

    public String getPlanEstudios() {
        return planEstudios;
    }

    public void setPlanEstudios(String planEstudios) {
        this.planEstudios = planEstudios;
    }

    @Override
    public String toString() {
        return "Carrera{" + "claveCarrera='" + claveCarrera + '\'' + ", nombre='" + nombre + '\'' + ", planEstudios='" + planEstudios + '\'' + '}';
    }
}
