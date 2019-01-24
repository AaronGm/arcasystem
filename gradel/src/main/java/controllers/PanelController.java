package controllers;

import views.PanelControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelController {


    public PanelControl show() {
        PanelControl panelControl = new PanelControl();
        panelControl.getCreateRecord().getBtnQueryRecord().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelControl.dispose();
            }
        });
        return panelControl;
    }

    public void consultarExpedientes() {
        HistorialAlumnoController historialAlumnoController = new HistorialAlumnoController();
        historialAlumnoController.show().setVisible(true);
    }



}
