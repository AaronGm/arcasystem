package views.old.components;

import helpers.Colors;

import javax.swing.Icon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class FlatBigButton extends FlatPanel {

    private Color bgColor;

    private FlatLabel lbText;
    private FlatLabel lbIcon;

    public FlatBigButton(Color bgColor, Icon icon, String text, Color color) {
        lbText = new FlatLabel(text.toUpperCase(), color);
        lbIcon = new FlatLabel(icon);
        initComponent();
        setBackground(bgColor);
    }


    public FlatBigButton(Icon icon, String text, Color color) {
        lbText = new FlatLabel(text.toUpperCase(), color);
        lbIcon = new FlatLabel(icon);
        initComponent();
    }

    private void initComponent() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(160, 160));
        setBackground(Colors.SELECTED_COMPONENT);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setComponents();
    }

    private void setComponents() {
        GridBagConstraints c = new GridBagConstraints();
        add(lbIcon, c);
        c.gridy = 1;
        add(lbText, c);
    }
}
