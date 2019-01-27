package views.panels;

import enums.SpacingPoints;
import views.components.Component;
import views.components.FlatPanel;
import views.components.FlatScrollBar;
import views.components.FlatTable;
import views.components.table.FlatTableModel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class TablaEmpresas extends FlatPanel implements Component {

    private FlatPanel pnlMain;

    private FlatTable tabla;
    private JScrollPane scrollPane;
    private FlatTableModel model;

    public TablaEmpresas() {
        super(new BorderLayout());
        initComponent();
    }

    @Override
    public void initComponent() {
        setPadding(SpacingPoints.SP24, SpacingPoints.SP_NONE);
        initSubComponents();
        setSubComponents();
    }

    @Override
    public void initSubComponents() {
        pnlMain = new FlatPanel(new BorderLayout());
        model = new FlatTableModel(new String[] { "RFC", "Nombre de la empresa", "Dirección", "Colonia", "Alcaldía/Municipio", "Código Postal", "Teléfonos", "Correo" }, 0);
        tabla = new FlatTable(model);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setVerticalScrollBar(new FlatScrollBar());
        scrollPane.setBorder(null);
        initMain();
    }

    private void initMain() {
        pnlMain.add(BorderLayout.CENTER, scrollPane);
    }

    @Override
    public void setSubComponents() {
        add(BorderLayout.CENTER, pnlMain);
    }

    public FlatTable getTabla() {
        return tabla;
    }

    public FlatTableModel getModel() {
        return model;
    }
}
