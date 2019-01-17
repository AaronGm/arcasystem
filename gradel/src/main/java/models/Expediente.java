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
public class Expediente {
    private int expedienteId;
    private boolean cartaInicio;
    private boolean cronograma;
    private boolean asesorias;
    private boolean evaluacionSeguimiento;
    private boolean formatoEvaluacion;
    private boolean discos;
    private boolean cartaTermino;
    private boolean cartaLiberacion;
    private String observaciones;
    private String estatus;
    private String noControl;

    public static final String EXPEDIENTE_ID = "expediente_id";
    public static final String CARTA_INICIO = "carta_inicio";
    public static final String CRONOGRAMA = "cronograma";
    public static final String ASESORIAS = "asesorias";
    public static final String EVALUACION_SEGUIMIENTO = "evaluacion_seguimiento";
    public static final String FORMATO_EVALUACION = "formato_evaluacion";
    public static final String DISCOS = "discos";
    public static final String CARTA_TERMINO = "carta_termino";
    public static final String CARTA_LIBERACION = "carta_liberacion";
    public static final String OBSERVACIONES = "observaciones";
    public static final String ESTATUS = "estatus";
    public static final String FK_NO_CONTROL = "no_control";


    public Expediente( int expedienteId, boolean cartaInicio, boolean cronograma, boolean asesorias, boolean evaluacionSeguimiento, boolean formatoEvaluacion, boolean discos, boolean cartaTermino, boolean cartaLiberacion, String observaciones, String estatus, String noControl ) {
        this.expedienteId = expedienteId;
        this.cartaInicio = cartaInicio;
        this.cronograma = cronograma;
        this.asesorias = asesorias;
        this.evaluacionSeguimiento = evaluacionSeguimiento;
        this.formatoEvaluacion = formatoEvaluacion;
        this.discos = discos;
        this.cartaTermino = cartaTermino;
        this.cartaLiberacion = cartaLiberacion;
        this.observaciones = observaciones;
        this.estatus = estatus;
        this.noControl = noControl;
    }

    public int getExpedienteId() {
        return expedienteId;
    }

    public void setExpedienteId( int expedienteId ) {
        this.expedienteId = expedienteId;
    }

    public boolean isCartaInicio() {
        return cartaInicio;
    }

    public void setCartaInicio( boolean cartaInicio ) {
        this.cartaInicio = cartaInicio;
    }

    public boolean isCronograma() {
        return cronograma;
    }

    public void setCronograma( boolean cronograma ) {
        this.cronograma = cronograma;
    }

    public boolean isAsesorias() {
        return asesorias;
    }

    public void setAsesorias( boolean asesorias ) {
        this.asesorias = asesorias;
    }

    public boolean isEvaluacionSeguimiento() {
        return evaluacionSeguimiento;
    }

    public void setEvaluacionSeguimiento( boolean evaluacionSeguimiento ) {
        this.evaluacionSeguimiento = evaluacionSeguimiento;
    }

    public boolean isFormatoEvaluacion() {
        return formatoEvaluacion;
    }

    public void setFormatoEvaluacion( boolean formatoEvaluacion ) {
        this.formatoEvaluacion = formatoEvaluacion;
    }

    public boolean isDiscos() {
        return discos;
    }

    public void setDiscos( boolean discos ) {
        this.discos = discos;
    }

    public boolean isCartaTermino() {
        return cartaTermino;
    }

    public void setCartaTermino( boolean cartaTermino ) {
        this.cartaTermino = cartaTermino;
    }

    public boolean isCartaLiberacion() {
        return cartaLiberacion;
    }

    public void setCartaLiberacion( boolean cartaLiberacion ) {
        this.cartaLiberacion = cartaLiberacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones( String observaciones ) {
        this.observaciones = observaciones;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus( String estatus ) {
        this.estatus = estatus;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl( String noControl ) {
        this.noControl = noControl;
    }
    
}
