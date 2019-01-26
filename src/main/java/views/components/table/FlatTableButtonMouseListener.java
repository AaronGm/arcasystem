/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components.table;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author aarongmx
 */
public class FlatTableButtonMouseListener extends MouseAdapter {
    private final JTable table;

    public FlatTableButtonMouseListener(JTable table) {
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table.getRowHeight();
        System.out.println("Col :" + column + "row:" + row);

        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
            Object value = table.getValueAt(row, column);
            System.out.println("Value :" + value.getClass().getName());
            if (value instanceof JButton) {
                ((JButton) value).doClick();
            }

        }
        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}