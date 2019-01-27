package views.panels;

import enums.SpacingPoints;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Arrays;

public class RegistrarEmpresa extends FlatPanel implements Component {

    public static final String PANEL_NAME = "Registrar Empresa";

    private FlatPanel pnlMain;
    private FlatComboBox cmbOpciones;
    private FlatButton btnNext;

    private TablaEmpresas tablaEmpresas;
    private FormularioEmpresa formularioEmpresa;

    public RegistrarEmpresa() {
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
        pnlMain = new FlatPanel(new BorderLayout());
        btnNext = new FlatButton("Siguiente");
        tablaEmpresas = new TablaEmpresas();
        formularioEmpresa = new FormularioEmpresa();

        cmbOpciones = new FlatComboBox(new String[] { "Seleccionar una empresa", "Registrar una nueva empresa" });
        cmbOpciones.setPreferredSize(new Dimension(250, 30));
        cmbOpciones.setSelectedIndex(0);

        initMain();
    }

    private void initMain() {
        pnlMain.add(BorderLayout.NORTH, Helpers.panelHidde(FlowLayout.LEFT, Helpers.groupElementsVertical(new FlatLabel("Opciones"), cmbOpciones)));
        pnlMain.add(BorderLayout.CENTER, tablaEmpresas);

        FlatPanel pnl = new FlatPanel(new FlowLayout(FlowLayout.RIGHT));
        pnl.setPadding(SpacingPoints.SP16);
        pnl.add(btnNext);
        pnlMain.add(BorderLayout.SOUTH, pnl);

        cmbOpciones.addActionListener(l -> {

            if (tablaEmpresas.getParent() == pnlMain) {
                pnlMain.remove(tablaEmpresas);
                pnlMain.invalidate();
                pnlMain.repaint();
            }

            if (formularioEmpresa.getParent() == pnlMain) {
                pnlMain.remove(formularioEmpresa);
                pnlMain.invalidate();
                pnlMain.repaint();
            }

            if (cmbOpciones.getSelectedIndex() == 0) {
                pnlMain.add(BorderLayout.CENTER, tablaEmpresas);
                pnlMain.validate();
                pnlMain.repaint();
            }

            if (cmbOpciones.getSelectedIndex() == 1) {
                pnlMain.add(BorderLayout.CENTER, formularioEmpresa);
                pnlMain.validate();
                pnlMain.repaint();
            }
        });
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.CENTER, pnlMain);
    }

    public FlatButton getBtnNext() {
        return btnNext;
    }
}
