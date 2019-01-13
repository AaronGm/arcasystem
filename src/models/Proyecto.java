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
public class Proyecto {
    private int proyectoId;
    private String nombre;
    private int semanas;
    private String periodo;
    private Date fechaInicio;
    private Date fechaTermino;
    private String estatus;

    public static final String PROYECTO_ID = "proyecto_id";
    public static final String NOMBRE = "nombre";
    public static final String SEMANAS_PROYECTO = "semanas_proyecto";
    public static final String PERIODO = "periodo";
    public static final String FECHA_INICIO = "fecha_inicio";
    public static final String FECHA_TERMINO = "fecha_termino";
    public static final String ESTATUS = "estatus";

    public static final String TYPE_ESTATUS_PROYECTO[] = {"----", "Aceptado", "Rechazado"};

    public Proyecto(int proyectoId, String nombre, int semanas, String periodo, Date fechaInicio, Date fechaTermino, String estatus) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.semanas = semanas;
        this.periodo = periodo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.estatus = estatus;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechaInicio() {
        return new java.sql.Date(fechaInicio.getTime());
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return new java.sql.Date(fechaTermino.getTime());
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
