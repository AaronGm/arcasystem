/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import helpers.Helpers;

import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.Format;

/**
 *
 * @author aarongmx
 */
public class FlatTextField extends JFormattedTextField {

    private boolean existsError;

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
        existsError = false;
        Border defaultBorder = new CompoundBorder(
                new MatteBorder(Helpers.paddingInset(1), Colors.GHOST_MEDIUM),
                helpers.Helpers.padding(0, 8)
        );
        setPreferredSize(new Dimension(330, 30));
        setFont(helpers.Typography.paragraphFont());
        setForeground(Colors.BLACK);
        setSelectionColor(Colors.BLUE_LIGHT);
        setSelectedTextColor(Color.white);
        setBorder(defaultBorder);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                    setBorder(new CompoundBorder(
                        new MatteBorder(Helpers.paddingInset(2), Colors.BLUE_LIGHT),
                        helpers.Helpers.padding(0, 8)
                    ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(defaultBorder);
            }
        });
    }

    public boolean isExistsError() {
        return existsError;
    }

    public void setExistsError(boolean existsError) {
        this.existsError = existsError;
    }
}
