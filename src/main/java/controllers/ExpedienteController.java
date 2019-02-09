package controllers;

import models.Alumno;
import views.old.CrearExpediente;

public class ExpedienteController {

    private CrearExpediente view;
    private Alumno alumno;

    public ExpedienteController(CrearExpediente view, Alumno alumno) {
        this.view = view;
        this.alumno = alumno;
    }



    public CrearExpediente getView() {
        return view;
    }
}
