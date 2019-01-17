package views.components;

import helpers.Helpers;

import javax.swing.JPanel;
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

    public FlatPanel(int topBottom, int leftRight) {
        setBorder(Helpers.padding(topBottom, leftRight));
    }

    private void initComponent() {
        setBorder(Helpers.padding(32, 16));
    }

    public void setPadding(int all) {
        setBorder(Helpers.padding(all));
    }

    public void setPadding(int topBottom, int leftRight) {
        setBorder(Helpers.padding(topBottom, leftRight));
    }
}
