package views;

import config.Configuration;
import enums.MensajesValidacion;
import helpers.Helpers;
import views.components.HeaderApp;
import views.components.MenuApp;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public abstract class View extends JFrame {

    private String titleBar;

    public View(String title) {
        super(title + " | " + Configuration.APP_NAME);
        this.titleBar = title;
        initView();
    }

    public View(String title, String titleBar) {
        super(title + " | " + Configuration.APP_NAME);
        this.titleBar = titleBar;
        initView();
    }

    private void initView() {
        Helpers.minScreenSize(this);
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.NORTH, new HeaderApp(titleBar));
        initComponents();
        setComponents();
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, MensajesValidacion.CERRAR_APLICACION.getMensaje(), "Cerrar Aplicación", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                else if (result == JOptionPane.NO_OPTION)
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

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
