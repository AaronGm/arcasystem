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
    private String clave_carrera;
    private int proyectoId;
    private int empresaId;
    private int asesorExternoId;
    private int asesorInternoId;

    public Alumno( String noControl, int semestre, String periodo, String clave_carrera, int proyectoId, int empresaId, int asesorExternoId, int asesorInternoId, String nombres, String apellidoPaterno, String apellidoMaterno ) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.noControl = noControl;
        this.semestre = semestre;
        this.periodo = periodo;
        this.clave_carrera = clave_carrera;
        this.proyectoId = proyectoId;
        this.empresaId = empresaId;
        this.asesorExternoId = asesorExternoId;
        this.asesorInternoId = asesorInternoId;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl( String noControl ) {
        this.noControl = noControl;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre( int semestre ) {
        this.semestre = semestre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo( String periodo ) {
        this.periodo = periodo;
    }

    public String getClave_carrera() {
        return clave_carrera;
    }

    public void setClave_carrera( String clave_carrera ) {
        this.clave_carrera = clave_carrera;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId( int proyectoId ) {
        this.proyectoId = proyectoId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId( int empresaId ) {
        this.empresaId = empresaId;
    }

    public int getAsesorExternoId() {
        return asesorExternoId;
    }

    public void setAsesorExternoId( int asesorExternoId ) {
        this.asesorExternoId = asesorExternoId;
    }

    public int getAsesorInternoId() {
        return asesorInternoId;
    }

    public void setAsesorInternoId( int asesorInternoId ) {
        this.asesorInternoId = asesorInternoId;
    }
        
}
