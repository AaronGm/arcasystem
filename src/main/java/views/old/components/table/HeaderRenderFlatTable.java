/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.old.components.table;

import helpers.Colors;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

/**
 *
 * @author aarongmx
 */
public class HeaderRenderFlatTable implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent header = null;
        
        if (value instanceof String) {
            header = new JLabel((String) value);
            ((JLabel) header).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) header).setSize(header.getWidth(), 36);
            ((JLabel) header).setPreferredSize(new Dimension(header.getWidth(), 32));
        }
        
        header.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new EmptyBorder(0, 0, 0, 0)));
        header.setBackground(Colors.BLUE_MEDIUM);
        header.setOpaque(true);
        header.setFont(helpers.Typography.componentsFont());
        header.setForeground(Color.white);
        
        return header;
    }
    
}
