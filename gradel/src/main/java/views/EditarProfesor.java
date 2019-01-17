/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Profesor;

/**
 *
 * @author aarongmx
 */
public class EditarProfesor extends RegistrarProfesor {

    private Profesor profesor;

    public EditarProfesor() {
        super("Actualizar Profesor");
    }

    public EditarProfesor(Profesor profesor) {
        super("Actualizar Profesor");
        this.profesor = profesor;
        initView();
    }
    
    private void initView() {
        getTxfNoContrato().setText(profesor.getNoTrabajador());
        getTxfNombre().setText(profesor.getNombres());
        getTxfApellidoPaterno().setText(profesor.getApellidoPaterno());
        getTxfApellidoMaterno().setText(profesor.getApellidoMaterno());
        getCmbEstatusProfesor().setSelectedItem(profesor.getEstatusProfesor());
        getCmbGradoEstudio().setSelectedItem(profesor.getGradoEstudio());
        getTxfEspecialidad().setText(profesor.getAreaEspecialidad());
        
        getJdtcFechaIngreso().setDate(profesor.getFechaIngreso());
        
        getButton().setText("Actualizar");
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
        initView();
    }
}
