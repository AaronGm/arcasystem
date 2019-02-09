package views.old;

import helpers.Helpers;
import views.View;
import views.old.components.FlatButton;
import views.old.components.FlatComboBox;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.components.FlatTextField;

import java.awt.BorderLayout;

public class CrearExpediente extends View {

    private FlatPanel pnlMain;
    private FlatTextField txfNoControl;
    private FlatTextField txfNombreAlumno;
    private FlatTextField txfApellidoPaterno;
    private FlatTextField txfApellidoMaterno;
    private FlatComboBox cmbCarrera;
    private FlatButton btnRegistrar;



    public CrearExpediente() {
        super("Crear expediente");
    }

    @Override
    protected void initComponents() {
        pnlMain = new FlatPanel();
        txfNoControl = new FlatTextField();
        txfNombreAlumno = new FlatTextField();
        txfApellidoPaterno = new FlatTextField();
        txfApellidoMaterno = new FlatTextField();

        initMain();
    }

    private void initMain() {
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Número de  Control")), txfNoControl);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre")), txfNombreAlumno);
    }

    @Override
    protected void setComponents() {
        add(BorderLayout.CENTER, pnlMain);
    }
}
