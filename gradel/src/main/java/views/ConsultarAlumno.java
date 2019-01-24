package views;

import dao.postgres.AlumnoDB;
import views.components.FlatPanel;
import views.components.FlatTable;
import views.components.table.FlatTableModel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class ConsultarAlumno extends View {

    private FlatPanel pnlMain;
    private FlatTable table;
    private FlatTableModel model;

    public ConsultarAlumno() {
        super("Consultar Alumnos");
    }

    @Override
    protected void initComponents() {
        pnlMain = new FlatPanel(new BorderLayout());
        model = new FlatTableModel(new String[] {
            "No. Control",
            "Nombres",
            "Apellido Paterno",
            "Apellido Materno",
            "Semestre",
            "Periodo",
            "Proyecto"
        }, 0);
        table = new FlatTable(model);
        initTable();
    }

    private void initTable() {
        JScrollPane scrollPane = new JScrollPane(table);
        loadData();
        pnlMain.add(scrollPane);
    }

    @Override
    protected void setComponents() {
        add(BorderLayout.CENTER, pnlMain);
    }

    public void loadData() {
        model.setRowCount(0);

        new AlumnoDB().list().forEach(el -> {
            model.addRow(new Object[]{
                el.getNoControl(),
                el.getNombres(),
                el.getApellidoPaterno(),
                el.getApellidoMaterno(),
                el.getSemestre(),
                el.getPeriodo()
            });
        });
        table.setModel(model);
    }
}
