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
    private final int semanasProyecto[] = { 16, 24 };
    private Date fechaInicio;
    private Date fechaTermino;
    private String estadoProyecto[] = { "----", "Aceptado", "Rechazado" };

    public Proyecto( int proyectoId, String nombre, Date fechaInicio, Date fechaTermino ) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId( int proyectoId ) {
        this.proyectoId = proyectoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio( Date fechaInicio ) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino( Date fechaTermino ) {
        this.fechaTermino = fechaTermino;
    }

    public String[] getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto( String[] estadoProyecto ) {
        this.estadoProyecto = estadoProyecto;
    }

}
