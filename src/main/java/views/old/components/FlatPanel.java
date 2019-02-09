package views.old.components;

import enums.SpacingPoints;
import helpers.Helpers;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Arrays;

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

    public void setPadding(SpacingPoints top, SpacingPoints right, SpacingPoints bottom, SpacingPoints left) {
        setBorder(Helpers.padding(top, right, bottom, left));
    }

    public void setPaddingTop(SpacingPoints paddingTop) {
        setBorder(new EmptyBorder(paddingTop.getSize(), 0, 0, 0));
    }

    public void setPaddingBottom(SpacingPoints paddingBottom) {
        setBorder(new EmptyBorder(0, 0, paddingBottom.getSize(), 0));
    }

    public void setPaddingLeft(SpacingPoints paddingLeft) {
        setBorder(new EmptyBorder(0, paddingLeft.getSize(), 0, 0));
    }

    public void setPaddingRight(SpacingPoints paddingRight) {
        setBorder(new EmptyBorder( 0, 0, 0, paddingRight.getSize()));
    }

    public void adds(JComponent... jComponents) {
        Arrays.asList(jComponents).forEach(this::add);
    }

}
