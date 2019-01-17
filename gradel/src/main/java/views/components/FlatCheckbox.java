/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import enums.FontAwesome5;
import helpers.Colors;
import helpers.Helpers;
import jiconfont.swing.IconFontSwing;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import java.awt.Color;

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
        IconFontSwing.register(FontAwesome5.getIconFont("solid"));
        setBackground(Color.white);
        setFont(helpers.Typography.componentsFont());
        setBorderPainted(false);
        setFocusPainted(false);
        setIcon(IconFontSwing.buildIcon(FontAwesome5.FA_SQUARE, Helpers.ICON_SIZE, Colors.DEFAULT_COMPONENT));
        setSelectedIcon(IconFontSwing.buildIcon(FontAwesome5.FA_CHECK_SQUARE, Helpers.ICON_SIZE, Colors.SELECTED_COMPONENT));
    }
    
}
