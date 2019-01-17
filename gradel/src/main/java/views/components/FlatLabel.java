/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Color;

/**
 *
 * @author aarongmx
 */
public class FlatLabel extends JLabel {

    public FlatLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
        initComponent();
    }

    public FlatLabel(String text,String fontFamily, String fontSize, Color fontColor) {
        super(text);
        initComponent();
        setForeground(fontColor);
        setFont(helpers.Typography.addFont(fontFamily, fontSize));
    }
    
    public FlatLabel(String text,String fontFamily, String fontSize) {
        super(text);
        initComponent();
        setFont(helpers.Typography.addFont(fontFamily, fontSize));
    }

    public FlatLabel(String text, Color fontColor) {
        super(text);
        initComponent();
        setForeground(fontColor);
    }

    public FlatLabel(String text, String fontSize, Color fontColor) {
        super(text);
        initComponent();
        setForeground(fontColor);
        switch(fontSize) {
            case "h1":
            case "h2":
            case "h3":
                setFont(helpers.Typography.addFont("Raleway", fontSize));
                break;
            case "pr":
            case "sm":
            case "sl":
                setFont(helpers.Typography.addFont("Open Sans", fontSize));
                break;
        }
    }
    
    public FlatLabel(String text, String fontSize) {
        super(text);
        initComponent();
        switch(fontSize) {
            case "h1":
            case "h2":
            case "h3":
                setFont(helpers.Typography.addFont("Raleway", fontSize));
                break;
            case "pr":
            case "sm":
            case "sl":
                setFont(helpers.Typography.addFont("Open Sans", fontSize));
                break;
        }
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
        setFont(helpers.Typography.componentsFont());
        setForeground(Colors.BLACK_MEDIUM);
    }
    
}
