package views.components.historial;

import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class DatosProyecto extends FlatPanel implements Component {

    private FlatLabel lbNombre;
    private FlatLabel lbSemanas;
    private FlatLabel lbPeriodo;
    private FlatLabel lbFechaInicio;
    private FlatLabel lbFechaTermino;
    private FlatLabel lbEstatus;

    private FlatPanel pnlMain;

    public DatosProyecto() {
        super();
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
        lbNombre = new FlatLabel(FontSize.P);
        lbSemanas = new FlatLabel(FontSize.P);
        lbPeriodo = new FlatLabel(FontSize.P);
        lbFechaInicio = new FlatLabel(FontSize.P);
        lbFechaTermino = new FlatLabel(FontSize.P);
        lbEstatus = new FlatLabel(FontSize.P);

        pnlMain = new FlatPanel();

        initMain();
    }

    private void initMain() {
        pnlMain.setLayout(new GridBagLayout());
        pnlMain.setPadding(SpacingPoints.SP24, SpacingPoints.SP36);

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP24, SpacingPoints.SP16, SpacingPoints.SP_NONE);
        c.gridwidth = 3;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre del proyecto", Color.gray), lbNombre), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Semanas", Color.gray), lbSemanas), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Estatus del proyecto", Color.gray), lbEstatus), c);

        c.gridy = 1;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Periodo", Color.gray), lbPeriodo), c);

        c.gridy = 2;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Fecha de inicio", Color.gray), lbFechaInicio), c);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Fecha de termino", Color.gray), lbFechaTermino), c);
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos del proyecto", FontSize.H2));
        add(BorderLayout.WEST, pnlMain);
    }

    public FlatLabel getLbNombre() {
        return lbNombre;
    }

    public FlatLabel getLbSemanas() {
        return lbSemanas;
    }

    public FlatLabel getLbPeriodo() {
        return lbPeriodo;
    }

    public FlatLabel getLbFechaInicio() {
        return lbFechaInicio;
    }

    public FlatLabel getLbFechaTermino() {
        return lbFechaTermino;
    }

    public FlatLabel getLbEstatus() {
        return lbEstatus;
    }
}
