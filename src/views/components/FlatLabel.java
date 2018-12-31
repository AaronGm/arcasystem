/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author aarongmx
 */
public class FlatLabel extends JLabel {

    public FlatLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        initComponent();
    }

    public FlatLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        initComponent();
    }

    public FlatLabel(String text) {
        super(text);
        initComponent();
    }

    public FlatLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
        initComponent();
    }

    public FlatLabel(Icon image) {
        super(image);
        initComponent();
    }

    public FlatLabel() {
        initComponent();
    }

    private void initComponent() {
//        setFont(helpers.Typography.addFont("Roboto", 17F));
        setFont(helpers.Typography.componentsFont());
        setForeground(Colors.BLACK_MEDIUM);
    }
    
    
    
}
