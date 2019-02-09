package controllers;

import enums.MensajesValidacion;
import models.Proyecto;
import views.old.RegistrarProyecto;
import views.View;

public class ProyectoController implements Controller<Proyecto> {


    @Override
    public View create() {
        RegistrarProyecto view = new RegistrarProyecto();
        view.getBtnNext().addActionListener(l -> {
            // Validaciones en la vista
            if (view.getTxfNombreProyecto().getText().isEmpty() ||  view.getTxfNombreProyecto().getText().equals(" "))
                view.getLbErrNombreProyecto().setText(MensajesValidacion.CAMPO_VACIO.getMensaje());
            else
                view.getLbErrNombreProyecto().setText(" ");

            if(view.getBtnG().getSelection() == null)
                view.getLbErrSeleccion().setText(MensajesValidacion.CAMPO_SIN_SELECCIONAR.getMensaje());
            else
                view.getLbErrSeleccion().setText(" ");

        });

        return view;
    }

    @Override
    public View update(Proyecto proyecto) {
        return null;
    }

    @Override
    public View show() {
        return null;
    }

    @Override
    public void destroy(Proyecto proyecto) {

    }
}
