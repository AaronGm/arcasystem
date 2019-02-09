package views.old.components.historial;

import enums.FontSize;
import enums.SpacingPoints;
import helpers.Helpers;
import views.old.components.Component;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

public class DatosAsesorExterno extends FlatPanel implements Component {

    private FlatPanel pnlMain;
    private FlatLabel lbNombreCompleto;
    private FlatLabel lbCargo;
    private ArrayList<String> lbsTelefonos;
    private ArrayList<String> lbsCorreos;

    public DatosAsesorExterno() {
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
        pnlMain = new FlatPanel();
        lbNombreCompleto = new FlatLabel(FontSize.P);
        lbCargo = new FlatLabel(FontSize.P);
        lbsTelefonos = new ArrayList<>();
        lbsCorreos = new ArrayList<>();
        initMain();
    }

    private void initMain() {
        pnlMain.setLayout(new GridBagLayout());
        pnlMain.setPadding(SpacingPoints.SP24, SpacingPoints.SP36);
        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = Helpers.paddingInset(SpacingPoints.SP_NONE, SpacingPoints.SP24, SpacingPoints.SP16, SpacingPoints.SP_NONE);
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Nombre Completo"), lbNombreCompleto), c);
        c.gridy = 1;
        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Cargo en la empresa"), lbCargo), c);
//        lbsTelefonos.forEach(tel -> pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Teléfono"), new FlatLabel(tel)), c));


//        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel("Telefonos"), (JComponent) lbsTelefonos));
//        pnlMain.add(Helpers.groupElementsVertical(new FlatLabel(""), lb));
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.NORTH, new FlatLabel("Datos del asesor externo", FontSize.H2));
        add(BorderLayout.WEST, pnlMain);
    }

    public FlatLabel getLbNombreCompleto() {
        return lbNombreCompleto;
    }

    public FlatLabel getLbCargo() {
        return lbCargo;
    }

    public void setLbsTelefonos(ArrayList<String> lbsTelefonos) {
        this.lbsTelefonos = lbsTelefonos;
    }

    public void setLbsCorreos(ArrayList<String> lbsCorreos) {
        this.lbsCorreos = lbsCorreos;
    }
}
