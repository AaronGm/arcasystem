/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author aarongmx
 */
public class FlatCheckbox extends JCheckBox {

    public FlatCheckbox() {
        initComponent();
    }

    public FlatCheckbox(Icon icon) {
        super(icon);
        initComponent();
    }

    public FlatCheckbox(Icon icon, boolean selected) {
        super(icon, selected);
        initComponent();
    }

    public FlatCheckbox(String text) {
        super(text);
        initComponent();
    }

    public FlatCheckbox(Action a) {
        super(a);
        initComponent();
    }

    public FlatCheckbox(String text, boolean selected) {
        super(text, selected);
        initComponent();
    }

    public FlatCheckbox(String text, Icon icon) {
        super(text, icon);
        initComponent();
    }

    public FlatCheckbox(String text, Icon icon, boolean selected) {
        super(text, icon, selected);
        initComponent();
    }

    private void initComponent() {
        IconFontSwing.register(FontAwesome.getIconFont());
        setBackground(Color.white);
        setFont(helpers.Typography.componentsFont());
        setBorderPainted(false);
        setIcon(IconFontSwing.buildIcon(FontAwesome.SQUARE, 18, Colors.GHOST_MEDIUM));
        setSelectedIcon(IconFontSwing.buildIcon(FontAwesome.CHECK_SQUARE, 18, Colors.BLUE_LIGHT));
    }
    
}
