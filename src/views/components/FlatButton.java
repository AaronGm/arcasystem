/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
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
    
    public FlatButton(Icon icon, ActionListener action) {
        super(icon);
        super.addActionListener(action);
        initComponent();
    }

    public FlatButton(String text, Icon icon) {
        super(text.toUpperCase(), icon);
        initComponent();
    }
    
    public FlatButton(String text, Icon icon, Action action) {
        super(text, icon);
        super.setAction(action);
        initComponent();
    }

    private void initComponent() {
        IconFontSwing.register(FontAwesome.getIconFont());
        setBackground(Colors.BLUE_LIGHT);
        setForeground(Color.white);
        setFont(helpers.Typography.componentsFont());
        setBorder(
            new CompoundBorder(helpers.Helpers.padding(0),
            helpers.Helpers.padding(8, 16))
        );
        setFocusPainted(false);
    }
    
    public void styleGhost() {
        setBackground(Color.white);
        setForeground(Colors.BLACK_MEDIUM);
    }
    
}
