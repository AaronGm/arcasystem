/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.postgres.ImplProfesor;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.components.FlatButton;
import views.components.FlatLabel;
import views.components.FlatScrollBar;
import views.components.FlatTable;
import views.components.FlatTextField;
import views.components.table.FlatTableModel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

/**
 *
 * @author aarongmx
 */
public class ConsultarProfesor extends View {

    private JPanel pnlBuscar;
    private JPanel pnlTabla;
    private JPanel pnlCenter;
    private JPanel pnlBotones;
    
    private FlatTextField txfBuscar;
    
    private FlatTable tabla;
    private FlatTableModel model;
 
    private FlatButton btnBuscar;
    private FlatButton btnEditar;
    private FlatButton btnEliminar;

    
    public ConsultarProfesor() throws HeadlessException {
        super("Consultar Profesor  | " + config.Configuration.APP_NAME, "Consultar Profesor");
    }

    @Override
    protected void initComponents() {
        IconFontSwing.register(FontAwesome.getIconFont());
        pnlCenter = new JPanel(new BorderLayout());
        pnlBuscar = new JPanel();
        pnlTabla = new JPanel();
        pnlBotones = new JPanel();
        
        txfBuscar = new FlatTextField();
        
        tabla = new FlatTable();

        btnBuscar = new FlatButton("Buscar", IconFontSwing.buildIcon(FontAwesome.SEARCH, 18, Color.white));
        
        btnEditar = new FlatButton("Actualizar", IconFontSwing.buildIcon(FontAwesome.PENCIL, 14, Color.white));
        btnEditar.setBackground(Colors.BLUE_MEDIUM);
        
        btnEliminar = new FlatButton("Eliminar", IconFontSwing.buildIcon(FontAwesome.TRASH, 14, Color.white));
        btnEliminar.setBackground(Colors.RED);
        
        initBarraBuscar();
        initTabla();
        initBotones();
        
        helpers.Helpers.setWhite(pnlBuscar, pnlTabla, pnlBotones);
        pnlCenter.add(BorderLayout.NORTH, pnlBuscar);
        pnlCenter.add(BorderLayout.CENTER, pnlTabla);
        pnlCenter.add(BorderLayout.SOUTH, pnlBotones);
    }

    @Override
    protected void setComponents() {
        getContentPane().add(BorderLayout.CENTER, pnlCenter);
    }

    private void initBarraBuscar() {
        pnlBuscar.add(new FlatLabel("Buscar profesor: "));
        pnlBuscar.add(txfBuscar);
        pnlBuscar.add(btnBuscar);
    }
    
    private void initTabla() {
        pnlTabla.setLayout(new BorderLayout());
        pnlTabla.setBorder(helpers.Helpers.padding(32, 16));
        model = new FlatTableModel(new String[] {
            "",
            "No. Trabajador", 
            "Nombre", 
            "Apellido Paterno", 
            "Apellido Materno", 
            "Fecha Ingreso", 
            "Grado de estudios", 
            "Estatus Contrato", 
            "Especialidad"
        }, 0);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBar(new FlatScrollBar());
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));

        btnEditar = new FlatButton("Actualizar", IconFontSwing.buildIcon(FontAwesome.PENCIL_SQUARE, 16, Color.white));

        btnEliminar = new FlatButton("Eliminar", IconFontSwing.buildIcon(FontAwesome.TRASH, 16, Color.white));
        btnEliminar.setBackground(Colors.RED);

        loadData();

        tabla.hiddeId();

        TableRowSorter sorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(sorter);
        
        btnBuscar.addActionListener((ActionEvent l) -> {
            String text = txfBuscar.getText();
            if (text.trim().length() == 0) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        });
       
        pnlTabla.add(BorderLayout.CENTER, scroll);
    }

    private void initBotones() {
        pnlBotones.setBorder(Helpers.padding(32, 16));
        pnlBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnlBotones.add(btnEditar);
        pnlBotones.add(btnEliminar);
    }

    public void loadData() {
        model.setRowCount(0);

        new ImplProfesor().list().forEach(el -> {
            model.addRow(new Object[]{
                el.getProfesorId(),
                el.getNoTrabajador(),
                el.getNombres(),
                el.getApellidoPaterno(),
                el.getApellidoMaterno(),
                el.getFechaIngreso(),
                el.getGradoEstudio(),
                el.getEstatusProfesor(),
                el.getAreaEspecialidad(),
            });
        });
        tabla.setModel(model);
    }

    public FlatButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(FlatButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public FlatButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(FlatButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public FlatTable getTabla() {
        return tabla;
    }

    public void setTabla(FlatTable tabla) {
        this.tabla = tabla;
    }

    public FlatTableModel getModel() {
        return model;
    }

    public void setModel(FlatTableModel model) {
        this.model = model;
    }
}
