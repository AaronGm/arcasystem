/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author aarongmx
 */
public class Profesor extends Persona {
    private int profesorId;
    private Date fechaIngreso;
    private final String gradoEstudio[] = { "Licenciatura", "Ingeniería", "Maestría", "Doctorado" };
    private final String estatusProfesor[] = { "Tiempo Completo", "Clave 10", "Clave 20", "Clave 95", "Por Horario", "Por asignaturas" };
    private String areaEspecialidad;

    public Profesor( int profesorId, Date fechaIngreso, String areaEspecialidad, String nombres, String apellidoPaterno, String apellidoMaterno ) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.profesorId = profesorId;
        this.fechaIngreso = fechaIngreso;
        this.areaEspecialidad = areaEspecialidad;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId( int profesorId ) {
        this.profesorId = profesorId;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso( Date fechaIngreso ) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAreaEspecialidad() {
        return areaEspecialidad;
    }

    public void setAreaEspecialidad( String areaEspecialidad ) {
        this.areaEspecialidad = areaEspecialidad;
    }
    
}
