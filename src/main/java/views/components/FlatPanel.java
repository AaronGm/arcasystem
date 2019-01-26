package views.components;

import enums.SpacingPoints;
import helpers.Helpers;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.LayoutManager;

public class FlatPanel extends JPanel {
    public FlatPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        initComponent();
    }

    public FlatPanel(LayoutManager layout) {
        super(layout);
        initComponent();
    }

    public FlatPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        initComponent();
    }

    public FlatPanel() {
        initComponent();
    }

    public FlatPanel(SpacingPoints size) {
        initComponent();
        setBorder(Helpers.padding(size, size));
    }

    public FlatPanel(SpacingPoints topBottom, SpacingPoints leftRight) {
        initComponent();
        setBorder(Helpers.padding(topBottom, leftRight));
    }

    private void initComponent() {
        setBackground(Color.white);
        setBorder(Helpers.padding(SpacingPoints.SP_NONE));
    }

    public void setPadding(SpacingPoints spacingPoints) {
        setBorder(Helpers.padding(spacingPoints));
    }

    public void setPadding(SpacingPoints topBottom, SpacingPoints leftRight) {
        setBorder(Helpers.padding(topBottom, leftRight));
    }
}
