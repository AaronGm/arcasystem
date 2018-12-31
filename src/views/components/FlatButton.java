/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author aarongmx
 */
public class FlatButton extends JButton {

    public FlatButton() {
        initComponent();
    }

    public FlatButton(Icon icon) {
        super(icon);
        initComponent();
    }

    public FlatButton(String text) {
        super(text.toUpperCase());
        initComponent();
    }

    public FlatButton(Action a) {
        super(a);
        initComponent();
    }

    public FlatButton(String text, Icon icon) {
        super(text.toUpperCase(), icon);
        initComponent();
    }

    private void initComponent() {
        IconFontSwing.register(FontAwesome.getIconFont());
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
    
    
}
