/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import enums.FontAwesome5;
import helpers.Colors;
import jiconfont.swing.IconFontSwing;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;

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
        IconFontSwing.register(FontAwesome5.getIconFont());
        setIcon(IconFontSwing.buildIcon(FontAwesome5.FA_CIRCLE, 18, Colors.DEFAULT_COMPONENT));
        setSelectedIcon(IconFontSwing.buildIcon(FontAwesome5.FA_DOT_CIRCLE, 18, Colors.SELECTED_COMPONENT));
        setFont(helpers.Typography.componentsFont());
        setFocusPainted(false);
    }
    
}
