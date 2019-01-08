/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components.table;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aarongmx
 */
public class FlatTableModel extends DefaultTableModel {

    public FlatTableModel() {
    }

    public FlatTableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public FlatTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    public FlatTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
