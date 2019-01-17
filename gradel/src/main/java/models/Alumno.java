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
public class Alumno extends Persona {
    private String noControl;
    private int semestre;
    private String periodo;
    private String claveCarrera;

    public static final String NO_CONTROL = "no_control";
    public static final String SEMESTRE = "semestre";
    public static final String CLAVE_CARRERA = "clave_carrera";
    public static final String PERIODO = "periodo";

    public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno) {
        super(nombres, apellidoPaterno, apellidoMaterno);
    }

    public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno, String noControl, int semestre, String periodo, String claveCarrera) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.noControl = noControl;
        this.semestre = semestre;
        this.periodo = periodo;
        this.claveCarrera = claveCarrera;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera(String claveCarrera) {
        this.claveCarrera = claveCarrera;
    }

    @Override
    public String toString() {
        return "Alumno {\nNombre Completo: " + getNombreCompleto() + "\n" + "No. Control: " + noControl + "\n" +
                "Semestre: " + semestre + "\n" + "Periodo: " + periodo + "\n" + "Clave Carrera: " + claveCarrera +
                "\n}";
    }
}
