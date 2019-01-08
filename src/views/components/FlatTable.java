/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
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
    
}
