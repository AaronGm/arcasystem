/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.postgres.ImplProfesor;
import helpers.Colors;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import views.components.FlatButton;
import views.components.FlatLabel;
import views.components.FlatScrollBar;
import views.components.FlatTable;
import views.components.FlatTextField;
import views.components.HeaderApp;
import views.components.MenuApp;
import views.components.table.FlatTableModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

/**
 *
 * @author aarongmx
 */
public class ConsultarProfesor extends JFrame {

    private JPanel pnlBuscar;
    private JPanel pnlTabla;
    private JPanel pnlCenter;
    private JPanel pnlBotones;
    
    private FlatTextField txfBuscar;
    
    private FlatTable tabla;
    private FlatTableModel model;
    private TableRowSorter<DefaultTableModel> sorter; 
    
 
    private FlatButton btnBuscar;
    private FlatButton btnEditar;
    private FlatButton btnEliminar;

    
    public ConsultarProfesor() throws HeadlessException {
        super("Consultar Profesor  | " + config.Configuration.APP_NAME);
        initView();
    }

    private void initView() {
        helpers.Helpers.minScreenSize(this);
        setJMenuBar(new MenuApp());
        initComponents();
        getContentPane().add(BorderLayout.NORTH, new HeaderApp("Consultar Profesores"));
        getContentPane().add(BorderLayout.CENTER, pnlCenter);
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        IconFontSwing.register(FontAwesome.getIconFont());
        pnlCenter = new JPanel(new BorderLayout());
        pnlBuscar = new JPanel();
        pnlTabla = new JPanel();
        pnlBotones = new JPanel();
        
        txfBuscar = new FlatTextField();
        
        tabla = new FlatTable();
        sorter = new TableRowSorter();
        
        btnBuscar = new FlatButton("Buscar", IconFontSwing.buildIcon(FontAwesome.SEARCH, 18, Color.white));
        
        btnEditar = new FlatButton("Actualizar", IconFontSwing.buildIcon(FontAwesome.PENCIL, 14, Color.white));
        btnEditar.setBackground(Colors.BLUE_MEDIUM);
        
        btnEliminar = new FlatButton("Eliminar", IconFontSwing.buildIcon(FontAwesome.TRASH, 14, Color.white));
        btnEliminar.setBackground(Colors.RED);
        
        initBarraBuscar();
        initTabla();
        
        helpers.Helpers.setWhite(pnlBuscar, pnlTabla, pnlBotones);
        pnlCenter.add(BorderLayout.NORTH, pnlBuscar);
        pnlCenter.add(BorderLayout.CENTER, pnlTabla);
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
            "Especialidad", 
            "",
            ""
        }, 0);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBar(new FlatScrollBar());
        
        ImplProfesor implProf = new ImplProfesor();
        
        btnEditar = new FlatButton(IconFontSwing.buildIcon(FontAwesome.PENCIL_SQUARE, 16, Color.white));
        btnEditar.setName("update");
        
        btnEliminar = new FlatButton(IconFontSwing.buildIcon(FontAwesome.TRASH, 16, Color.white));
        btnEliminar.setName("delete");
        btnEliminar.setBackground(Colors.RED);
        
        implProf.listar().forEach(el -> {
            model.addRow(new Object[]{
                el.getProfesorId(),
                el.getNoContrato(),
                el.getNombres(),
                el.getApellidoPaterno(),
                el.getApellidoMaterno(),
                el.getFechaIngreso(),
                el.getGradoEstudio(),
                el.getEstatusProfesor(),
                el.getAreaEspecialidad(),
                btnEditar,
                btnEliminar,
            });
        });
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
        tabla.setModel(model);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.hiddeId();
        
        tabla.getColumnModel().getColumn(8).setPreferredWidth(10);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(10);
        
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlatTable.clickButtons(tabla, evt);
            }
        });
        
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
    
    private void filter() {
        String text = txfBuscar.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
    
}
