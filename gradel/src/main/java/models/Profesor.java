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
    private String noTrabajador;
    private Date fechaIngreso;
    private String gradoEstudio;
    private String estatusProfesor;
    private String areaEspecialidad;
    
    /**
     * Columnas en la base de datos
     */
    public static final String PROFESOR_ID = "profesor_id";
    public static final String NO_TRABAJADOR = "no_trabajador";
    public static final String FECHA_INGRESO = "fecha_ingreso";
    public static final String GRADO_ESTUDIOS = "grado_estudios";
    public static final String ESTATUS_PROFESOR = "estatus_profesor";
    public static final String AREA_ESPECIALIDAD = "area_especialidad";

    public static final String TYPE_GRADOS_ESTUDIO[] = {"Licenciatura", "Ingeniería", "Maestría", "Doctorado"};

    public static final String TYPE_ESTATUS_PROFESOR[] = {"Tiempo Completo", "Clave 10", "Clave 20", "Clave 95", "Por Horario", "Por Asignatura"};

    public Profesor(String noTrabajador, Date fechaIngreso, String gradoEstudio, String estatusProfesor, String areaEspecialidad, String nombres, String apellidoPaterno, String apellidoMaterno) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.noTrabajador = noTrabajador;
        this.fechaIngreso = fechaIngreso;
        this.gradoEstudio = gradoEstudio;
        this.estatusProfesor = estatusProfesor;
        this.areaEspecialidad = areaEspecialidad;
    }
    
    
    
    public Profesor(int profesorId, String noTrabajador, Date fechaIngreso, String gradoEstudio, String estatusProfesor, String areaEspecialidad, String nombres, String apellidoPaterno, String apellidoMaterno) {
        super(nombres, apellidoPaterno, apellidoMaterno);
        this.profesorId = profesorId;
        this.noTrabajador = noTrabajador;
        this.fechaIngreso = fechaIngreso;
        this.gradoEstudio = gradoEstudio;
        this.estatusProfesor = estatusProfesor;
        this.areaEspecialidad = areaEspecialidad;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public String getNoTrabajador() {
        return noTrabajador;
    }

    public void setNoTrabajador(String noTrabajador) {
        this.noTrabajador = noTrabajador;
    }

    public Date getFechaIngreso() {
        return new java.sql.Date(fechaIngreso.getTime());
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getGradoEstudio() {
        return gradoEstudio;
    }

    public void setGradoEstudio(String gradoEstudio) {
        this.gradoEstudio = gradoEstudio;
    }

    public String getEstatusProfesor() {
        return estatusProfesor;
    }

    public void setEstatusProfesor(String estatusProfesor) {
        this.estatusProfesor = estatusProfesor;
    }

    public String getAreaEspecialidad() {
        return areaEspecialidad;
    }

    public void setAreaEspecialidad(String areaEspecialidad) {
        this.areaEspecialidad = areaEspecialidad;
    }

    @Override
    public String toString() {
        return "Nombres: " + this.getNombres() + "\nApellido Paterno: " + this.getApellidoPaterno() + "\nApellido Materno: " + this.getApellidoMaterno() + "\nID: " + this.profesorId + "\nNo. Contrato: " + this.noTrabajador + "\nFecha Ingreso: " + this.getFechaIngreso() + "\nEstatus Profesor: " + this.estatusProfesor + "\nGrado Estudios: " + this.gradoEstudio + "\nArea de Especialidad: "+ this.areaEspecialidad;
    }
    
    
        
}
