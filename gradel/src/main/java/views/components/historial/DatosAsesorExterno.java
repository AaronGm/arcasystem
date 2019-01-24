package views.components.historial;

import enums.FontSize;
import helpers.Helpers;
import views.components.Component;
import views.components.FlatLabel;
import views.components.FlatPanel;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class DatosAsesorExterno extends FlatPanel implements Component {

    private FlatPanel pnlMain;
    private FlatLabel lbNombreCompleto;
    private FlatLabel lbCargo;
    private ArrayList<FlatLabel> lbsTelefonos;
    private ArrayList<FlatLabel> lbsCorreos;

    public DatosAsesorExterno() {
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
        pnlMain = new FlatPanel();
        lbNombreCompleto = new FlatLabel(FontSize.P);
        lbCargo = new FlatLabel(FontSize.P);
        lbsTelefonos = new ArrayList<>();
        lbsCorreos = new ArrayList<>();
        initMain();
    }

    private void initMain() {
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre Completo"), lbNombreCompleto));
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Cargo en la empresa"), lbCargo));
//        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Telefonos"), (JComponent) lbsTelefonos));
//        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel(""), lb));
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos del asesor externo", FontSize.H2));
        add(BorderLayout.CENTER, pnlMain);
    }

    public FlatLabel getLbNombreCompleto() {
        return lbNombreCompleto;
    }

    public FlatLabel getLbCargo() {
        return lbCargo;
    }

    public ArrayList<FlatLabel> getLbsTelefonos() {
        return lbsTelefonos;
    }

    public ArrayList<FlatLabel> getLbsCorreos() {
        return lbsCorreos;
    }
}
