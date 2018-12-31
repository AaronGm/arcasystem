/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author aarongmx
 */
public class FlatRadioButton extends JRadioButton {

    public FlatRadioButton() {
        initComponent();
    }

    public FlatRadioButton(Icon icon) {
        super(icon);
        initComponent();
    }

    public FlatRadioButton(Action a) {
        super(a);
        initComponent();
    }

    public FlatRadioButton(Icon icon, boolean selected) {
        super(icon, selected);
        initComponent();
    }

    public FlatRadioButton(String text) {
        super(text);
        initComponent();
    }

    public FlatRadioButton(String text, boolean selected) {
        super(text, selected);
        initComponent();
    }

    public FlatRadioButton(String text, Icon icon) {
        super(text, icon);
        initComponent();
    }

    public FlatRadioButton(String text, Icon icon, boolean selected) {
        super(text, icon, selected);
        initComponent();
    }

    private void initComponent() {
        IconFontSwing.register(FontAwesome.getIconFont());
        setIcon(IconFontSwing.buildIcon(FontAwesome.CIRCLE_O, 18, Colors.GHOST_MEDIUM));
        setSelectedIcon(IconFontSwing.buildIcon(FontAwesome.DOT_CIRCLE_O, 18, Colors.BLUE_LIGHT));
        setFont(helpers.Typography.componentsFont());
        setFocusPainted(false);
    }
    
}
