package views.components.historial;

import enums.FontSize;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;

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
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre del proyecto"), lbNombre));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Semanas"), lbSemanas));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Periodo"), lbPeriodo));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Fecha de inicio"), lbFechaInicio));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Fecha de termino"), lbFechaTermino));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Estatus del proyecto"), lbEstatus));
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos del proyecto", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }

    public FlatLabel getLbNombre() {
        return lbNombre;
    }

    public void setLbNombre(FlatLabel lbNombre) {
        this.lbNombre = lbNombre;
    }

    public FlatLabel getLbSemanas() {
        return lbSemanas;
    }

    public void setLbSemanas(FlatLabel lbSemanas) {
        this.lbSemanas = lbSemanas;
    }

    public FlatLabel getLbPeriodo() {
        return lbPeriodo;
    }

    public void setLbPeriodo(FlatLabel lbPeriodo) {
        this.lbPeriodo = lbPeriodo;
    }

    public FlatLabel getLbFechaInicio() {
        return lbFechaInicio;
    }

    public void setLbFechaInicio(FlatLabel lbFechaInicio) {
        this.lbFechaInicio = lbFechaInicio;
    }

    public FlatLabel getLbFechaTermino() {
        return lbFechaTermino;
    }

    public void setLbFechaTermino(FlatLabel lbFechaTermino) {
        this.lbFechaTermino = lbFechaTermino;
    }

    public FlatLabel getLbEstatus() {
        return lbEstatus;
    }

    public void setLbEstatus(FlatLabel lbEstatus) {
        this.lbEstatus = lbEstatus;
    }
}
