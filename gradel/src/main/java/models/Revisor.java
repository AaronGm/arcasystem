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
public class Revisor {
    private int revisorId;
    private int profesorId;
    private String noControl;

    public static final String REVISOR_ID = "revisor_id";
    public static final String FK_PROFESOR_ID = "profesor_id";
    public static final String FK_NO_CONTROL = "no_control";

    public Revisor( int revisorId, int profesorId, String noControl ) {
        this.revisorId = revisorId;
        this.profesorId = profesorId;
        this.noControl = noControl;
    }

    public int getRevisorId() {
        return revisorId;
    }

    public void setRevisorId( int revisorId ) {
        this.revisorId = revisorId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId( int profesorId ) {
        this.profesorId = profesorId;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl( String noControl ) {
        this.noControl = noControl;
    }
    
}
