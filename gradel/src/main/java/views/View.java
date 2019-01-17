package views;

import helpers.Helpers;
import views.components.HeaderApp;
import views.components.MenuApp;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;
import java.util.Arrays;

public abstract class View extends JFrame {

    private String titleBar;

    public View(String title, String titleBar) {
        super(title);
        this.titleBar = titleBar;
        initView();
    }

    public View(String title) {
        super(title);
        this.titleBar = title;
        initView();
    }

    private void initView() {
        Helpers.minScreenSize(this);
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.NORTH, new HeaderApp(titleBar));
        initComponents();
        setComponents();
        Helpers.centerCloseScreen(this);
    }

    /**
     * Función para inicializar todos los componentes
     */
    protected abstract void initComponents();

    protected abstract void setComponents();

    public void clearFields(JTextComponent... components) {
        Arrays.asList(components).forEach(x -> {
            x.setText("");
        });
    }

    public void clearCombos(JComboBox... comboBox) {
        Arrays.asList(comboBox).forEach(x -> {
            x.setSelectedIndex(0);
        });
    }

    public String getTitleBar() {
        return titleBar;
    }

    public void setTitleBar(String titleBar) {
        this.titleBar = titleBar;
    }
}
