/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import enums.SpacingPoints;
import helpers.Colors;

import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

/**
 *
 * @author aarongmx
 */
public class FlatScrollBar extends JScrollBar {

    public FlatScrollBar(int orientation, int value, int extent, int min, int max) {
        super(orientation, value, extent, min, max);
        initComponent();
    }

    public FlatScrollBar(int orientation) {
        super(orientation);
        initComponent();
    }

    public FlatScrollBar() {
        initComponent();
    }
    
    private void initComponent() {
        setOpaque(false);
        setPreferredSize(new Dimension(12, 120));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(Colors.GHOST);
        setUnitIncrement(SpacingPoints.SP24.getSize());
    }
    
    
}
