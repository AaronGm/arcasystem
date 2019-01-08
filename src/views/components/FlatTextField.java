/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
import java.awt.Dimension;
import java.text.Format;
import javax.swing.JFormattedTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author aarongmx
 */
public class FlatTextField extends JFormattedTextField {

    public FlatTextField() {
        initComponent();
    }

    public FlatTextField(Object value) {
        super(value);
        initComponent();
    }

    public FlatTextField(Format format) {
        super(format);
        initComponent();
    }

    public FlatTextField(AbstractFormatter formatter) {
        super(formatter);
        initComponent();
    }

    public FlatTextField(AbstractFormatterFactory factory) {
        super(factory);
        initComponent();
    }

    public FlatTextField(AbstractFormatterFactory factory, Object currentValue) {
        super(factory, currentValue);
        initComponent();
    }
    
    private void initComponent() {
        setPreferredSize(new Dimension(330, 30));
        setFont(helpers.Typography.addFont("Open Sans", "pr"));
        setForeground(Colors.BLACK);
        setSelectionColor(Colors.BLUE_LIGHT);
        setSelectedTextColor(Color.white);
        setBorder(
            new CompoundBorder(
                new MatteBorder(1, 1, 1, 1, Colors.GHOST_MEDIUM), 
                helpers.Helpers.padding(0, 8)
            )
        );
    }
    
}
