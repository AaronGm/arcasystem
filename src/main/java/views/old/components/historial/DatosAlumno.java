package views.old.components.historial;

import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import views.old.components.Component;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class DatosAlumno extends FlatPanel implements Component {

    private FlatPanel pnlMain;

    private FlatLabel lbNoControl;
    private FlatLabel lbNombres;
    private FlatLabel lbApellidoPat;
    private FlatLabel lbApellidoMat;
    private FlatLabel lbCarrera;
    private FlatLabel lbPeriodo;
    private FlatLabel lbSemestre;

    public DatosAlumno() {
        initComponent();
    }

    @Override
    public void initComponent() {
        setLayout(new BorderLayout());
        setPadding(SpacingPoints.SP24, SpacingPoints.SP36);
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pnlMain = new FlatPanel(SpacingPoints.SP_NONE);
        lbNoControl = new FlatLabel(FontSize.P);
        lbNombres = new FlatLabel(FontSize.P);
        lbApellidoPat = new FlatLabel(FontSize.P);
        lbApellidoMat = new FlatLabel(FontSize.P);
        lbCarrera = new FlatLabel(FontSize.P);
        lbPeriodo = new FlatLabel(FontSize.P);
        lbSemestre = new FlatLabel(FontSize.P);

        initMain();
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos del alumno", FontSize.H2));
        add(BorderLayout.WEST, pnlMain);
    }

    private void initMain() {
        pnlMain.setLayout(new GridBagLayout());
        pnlMain.setPadding(SpacingPoints.SP24, SpacingPoints.SP36);
        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP24, SpacingPoints.SP16, SpacingPoints.SP_NONE);

        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Número de Control", Color.gray), lbNoControl), c);

        c.gridy = 1;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre(s)", Color.gray), lbNombres), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Apellido Paterno", Color.gray), lbApellidoPat), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Apellido Materno", Color.gray), lbApellidoMat), c);

        c.gridy = 2;
        c.gridwidth = 3;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Carrera", Color.gray), lbCarrera), c);

        c.gridy = 3;
        c.gridwidth = 1;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Semestre", Color.gray), lbSemestre), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Periodo", Color.gray), lbPeriodo), c);
    }

    public FlatLabel getLbNoControl() {
        return lbNoControl;
    }

    public FlatLabel getLbNombres() {
        return lbNombres;
    }

    public FlatLabel getLbApellidoPat() {
        return lbApellidoPat;
    }

    public FlatLabel getLbApellidoMat() {
        return lbApellidoMat;
    }

    public FlatLabel getLbCarrera() {
        return lbCarrera;
    }

    public FlatLabel getLbPeriodo() {
        return lbPeriodo;
    }

    public FlatLabel getLbSemestre() {
        return lbSemestre;
    }
}
