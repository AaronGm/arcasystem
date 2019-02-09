package views.old.panels;

import dao.postgres.EmpresaDB;
import enums.FontAwesome5;
import enums.FontSize;
import enums.SpacingPoints;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;
import views.old.components.Component;
import views.old.components.FlatLabel;
import views.old.components.FlatPanel;
import views.old.components.FlatTable;
import views.old.components.FlatTextField;
import views.old.components.table.FlatTableModel;

import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TablaEmpresas extends FlatPanel implements Component {

    private FlatPanel pnlMain;
    private FlatTextField txfBuscar;

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
        txfBuscar = new FlatTextField();
        FlatTextField.styleMaterial(txfBuscar);
        model = new FlatTableModel(new String[] {
            "ID",
            "RFC",
            "Nombre",
            "Encargado",
            "Dirección"
        }, 0);
        tabla = new FlatTable(model);
        scrollPane = new JScrollPane(tabla);

        TableRowSorter sorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(sorter);

        txfBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String text = txfBuscar.getText();
                if (text.trim().length() == 0) sorter.setRowFilter(null);
                else sorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
            }
        });

        initMain();
    }

    private void initMain() {
        pnlMain.setPadding(SpacingPoints.SP16, SpacingPoints.SP_NONE, SpacingPoints.SP_NONE, SpacingPoints.SP_NONE);
        loadData();
        tabla.hiddeId();
        tabla.setFixedWidth(0, 120);
        tabla.setFixedWidth(1, 220);
        tabla.setFixedWidth(2, 210);

        pnlMain.add(BorderLayout.CENTER, scrollPane);
    }

    @Override
    public void setSubComponents() {

        add(BorderLayout.NORTH, Helpers.panelHidde(FlowLayout.LEFT, Helpers.groupElementsHorizontal(new FlatLabel("Buscar empresa", FontSize.H3), Helpers.groupElementsHorizontal(txfBuscar, Helpers.labelIcon(IconFontSwing.buildIcon(FontAwesome5.FA_SEARCH, 18, Colors.BLACK), new Dimension(18, 18))))));
        add(BorderLayout.CENTER, pnlMain);
    }


    private void loadData() {
        model.setRowCount(0);
        new EmpresaDB().list().forEach(el ->
            model.addRow(new Object[] {
                el.getEmpresaId(),
                el.getRfc(),
                el.getNombre(),
                el.getEncargado(),
                el.getDomicilioCompleto()
            }
        ));
        tabla.setModel(model);
    }

    public FlatTable getTabla() {
        return tabla;
    }
}
