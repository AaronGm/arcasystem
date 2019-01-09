/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.postgres.ImplProfesor;
import java.util.Date;
import javax.swing.JFrame;
import models.Profesor;
import views.RegistrarProfesor;

/**
 *
 * @author aarongmx
 */
public class RegistrarProfesorController {
    private final RegistrarProfesor view;

    public RegistrarProfesorController(RegistrarProfesor view) {
        this.view = view;
    }

    public JFrame registrarProfesor() {
        ImplProfesor implProfesor = new ImplProfesor();
        view.getBtnRegistrar().addActionListener(l -> {
            String noContrato = view.getTxfNoContrato().getText();
            String nombre = view.getTxfNombre().getText();
            String apellidoPaterno = view.getTxfApellidoPaterno().getText();
            String apellidoMaterno = view.getTxfApellidoMaterno().getText();
            Date fechaIngreso = view.getJdtcFechaIngreso().getDate();
            String estatusProfesor = view.getCmbEstatusProfesor().getSelectedItem().toString();
            String gradoEstudios = view.getCmbGradoEstudio().getSelectedItem().toString();
            String areaEspecialidad = view.getTxfEspecialidad().getText();
            Profesor profesor = new Profesor(noContrato, fechaIngreso, gradoEstudios, estatusProfesor, areaEspecialidad, nombre, apellidoPaterno, apellidoMaterno);
            
            implProfesor.insertar(profesor);
        });
        
        return view;
    }
    
    
    
}
