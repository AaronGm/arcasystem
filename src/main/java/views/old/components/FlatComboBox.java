/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.old.components;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

/**
 *
 * @author aarongmx
 */
public class FlatComboBox extends JComboBox<Object> {
    
    public FlatComboBox(ComboBoxModel<Object> aModel) {
        super(aModel);
        initComponent();
    }

    public FlatComboBox(Object[] items) {
        super(items);
        initComponent();
    }

    public FlatComboBox(Vector<Object> items) {
        super(items);
        initComponent();
    }

    public FlatComboBox() {
        initComponent();
    }

    private void initComponent() {
        setFont(helpers.Typography.componentsFont());
        setPreferredSize(new Dimension(180, 30));
        setBackground(Color.white);
    }
    
    
    
}
