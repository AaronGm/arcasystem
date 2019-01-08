/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import views.components.table.FlatButtonRenderTable;
import views.components.table.HeaderRenderFlatTable;

/**
 *
 * @author aarongmx
 */
public class FlatTable extends JTable {

    public FlatTable() {
        initView();
    }

    public FlatTable(TableModel dm) {
        super(dm);
        initView();
    }

    public FlatTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
        initView();
    }

    public FlatTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
        initView();
    }

    public FlatTable(int numRows, int numColumns) {
        super(numRows, numColumns);
        initView();
    }

    public FlatTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
        initView();
    }
    
    private void initView() {
        setFont(helpers.Typography.addFont("Open Sans", "pr"));
        setGridColor(Colors.BLACK_LIGHT);
        setRowHeight(24);
        setShowGrid(false);
        setDefaultRenderer(Object.class, new FlatButtonRenderTable());
        getTableHeader().setDefaultRenderer(new HeaderRenderFlatTable());
        setFillsViewportHeight(true);
        setSelectionBackground(Color.lightGray);
    }
    
    public static void clickButtons(JTable table, MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table.getRowHeight();
        
        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
            Object value = table.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                if (btn.getName() == "update") {
                    System.out.println("Actuualizar");
                    System.out.println(table.getModel().getValueAt(row, 0));
                }
                
                if (btn.getName() == "delete") {
                    System.out.println("Eliminar");
                }
            }
        }
    }
}
