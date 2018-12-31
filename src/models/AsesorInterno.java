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
public class AsesorInterno {
    private int asesorInternoId;
    private int profesorId;

    public AsesorInterno( int asesorInternoId, int profesorId ) {
        this.asesorInternoId = asesorInternoId;
        this.profesorId = profesorId;
    }

    public int getAsesorInternoId() {
        return asesorInternoId;
    }

    public void setAsesorInternoId( int asesorInternoId ) {
        this.asesorInternoId = asesorInternoId;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId( int profesorId ) {
        this.profesorId = profesorId;
    }
    
}
