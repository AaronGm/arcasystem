package views.components;

import helpers.Typography;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenuItem;

public class FlatMenuItem extends JMenuItem {
    public FlatMenuItem() {
        initComponent();
    }

    public FlatMenuItem(Icon icon) {
        super(icon);
        initComponent();
    }

    public FlatMenuItem(String text) {
        super(text);
        initComponent();
    }

    public FlatMenuItem(Action a) {
        super(a);
        initComponent();
    }

    public FlatMenuItem(String text, Icon icon) {
        super(text, icon);
        initComponent();
    }

    public FlatMenuItem(String text, int mnemonic) {
        super(text, mnemonic);
        initComponent();
    }

    private void initComponent() {
        setFont(Typography.componentsFont());
    }
}
