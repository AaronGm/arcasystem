package views.old.panels;

import enums.FontAwesome5;
import enums.SpacingPoints;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import views.old.components.Component;
import views.old.components.FlatButton;
import views.old.components.FlatComboBox;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.components.FlatTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class RegistrarProyecto extends FlatPanel implements Component {

    public static final String PANEL_NAME = "Registrar Proyecto";

    private FlatButton btnSave;
    private FlatButton btnLast;

    private FlatPanel pnlMain;
    private FlatTextField txfNombreProyecto;
    private FlatComboBox cmbSemanas;
    private FlatComboBox cmbPeriodo;
    private FlatTextField txfNoAlumnos;

    private FlatLabel lbErrNombreProyecto;
    private FlatLabel lbErrNoAlumnos;


    public RegistrarProyecto() {
        super(new BorderLayout());
        initComponent();
    }

    @Override
    public void initComponent() {
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        IconFontSwing.register(FontAwesome5.getIconFont());
        pnlMain = new FlatPanel();
        txfNombreProyecto = new FlatTextField();
        txfNoAlumnos = new FlatTextField();

        lbErrNombreProyecto = txfNombreProyecto.getLbError();
        lbErrNoAlumnos = txfNoAlumnos.getLbError();

        cmbPeriodo = new FlatComboBox(Helpers.getPeriodos().toArray());
        cmbSemanas = new FlatComboBox(new Object[]{ 16, 24 });


        cmbPeriodo.setSelectedItem(Helpers.currentPeriodo());
        btnSave = new FlatButton("Guardar Proyecto", IconFontSwing.buildIcon(FontAwesome5.FA_SAVE, 14, Color.white));
        btnLast = new FlatButton("Atrás");
        initMain();
    }

    private void initMain() {
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre del proyecto"), txfNombreProyecto, lbErrNombreProyecto));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Periodo"), cmbPeriodo, Helpers.noErrLabel()));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Semanas"), cmbSemanas, Helpers.noErrLabel()));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("No. de alumnos"), txfNoAlumnos, lbErrNoAlumnos));
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.CENTER, pnlMain);
        FlatPanel pnl = new FlatPanel(new FlowLayout(FlowLayout.RIGHT));
        pnl.setPadding(SpacingPoints.SP16);
        pnl.adds(btnLast, btnSave);
        add(BorderLayout.SOUTH, pnl);
    }

    public FlatButton getBtnSave() {
        return btnSave;
    }

    public FlatButton getBtnLast() {
        return btnLast;
    }
}
