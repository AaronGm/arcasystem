/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import helpers.Colors;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.Document;

/**
 *
 * @author aarongmx
 */
public class FlatTextField extends JTextField {

    public FlatTextField() {
        initComponent();
    }

    public FlatTextField(String text) {
        super(text);
        initComponent();
    }

    public FlatTextField(int columns) {
        super(columns);
        initComponent();
    }

    public FlatTextField(String text, int columns) {
        super(text, columns);
        initComponent();
    }

    public FlatTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
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
                new MatteBorder(1, 1, 1, 1, Colors.BLACK_MEDIUM), 
                helpers.Helpers.padding(4, 8)
            )
        );
    }
    
    
    
}
