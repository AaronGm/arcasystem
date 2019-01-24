package views.components.historial;

import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;

public class DatosAlumno extends FlatPanel implements Component {

    private FlatPanel pnlMain;

    private FlatLabel lbNoControl;
    private FlatLabel lbNombreCompleto;
    private FlatLabel lbCarrera;
    private FlatLabel lbPeriodo;
    private FlatLabel lbSemestre;

    public DatosAlumno() {
        initComponent();
    }

    @Override
    public void initComponent() {
        setLayout(new BorderLayout());
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pnlMain = new FlatPanel(SpacingPoints.SP_NONE);
        lbNoControl = new FlatLabel(FontSize.P);
        lbNombreCompleto = new FlatLabel(FontSize.P);
        lbCarrera = new FlatLabel(FontSize.P);
        lbPeriodo = new FlatLabel(FontSize.P);
        lbSemestre = new FlatLabel(FontSize.P);

        initMain();
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos del alumno", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }

    private void initMain() {
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Número de Control"), lbNoControl));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre Completo"), lbNombreCompleto));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Carrera"), lbCarrera));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Semestre"), lbSemestre));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Periodo"), lbPeriodo));
    }

    public FlatLabel getLbNoControl() {
        return lbNoControl;
    }

    public void setLbNoControl(FlatLabel lbNoControl) {
        this.lbNoControl = lbNoControl;
    }

    public FlatLabel getLbNombreCompleto() {
        return lbNombreCompleto;
    }

    public void setLbNombreCompleto(FlatLabel lbNombreCompleto) {
        this.lbNombreCompleto = lbNombreCompleto;
    }

    public FlatLabel getLbCarrera() {
        return lbCarrera;
    }

    public void setLbCarrera(FlatLabel lbCarrera) {
        this.lbCarrera = lbCarrera;
    }

    public FlatLabel getLbPeriodo() {
        return lbPeriodo;
    }

    public void setLbPeriodo(FlatLabel lbPeriodo) {
        this.lbPeriodo = lbPeriodo;
    }

    public FlatLabel getLbSemestre() {
        return lbSemestre;
    }

    public void setLbSemestre(FlatLabel lbSemestre) {
        this.lbSemestre = lbSemestre;
    }
}
