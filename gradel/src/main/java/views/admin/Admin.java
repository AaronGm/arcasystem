/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.admin;

import config.Configuration;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author aarongmx
 */
public class Admin extends JFrame {
    private JDesktopPane desktop;
    private JInternalFrame frame;
    private Dimension screen;

    public Admin() {
        super(Configuration.APP_NAME + " | Panel de control");
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        initFrame();
    }
    
    private void initFrame() {
        desktop = new JDesktopPane();
        this.setSize(screen);
        this.getContentPane().add(desktop);
        crearUsuarios();
        desktop.add(frame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    
    private void crearUsuarios() {
        frame = new JInternalFrame("Crear usuarios", true, true, true);
        frame.setSize(screen.width / 2, screen.height / 2);
        frame.show();
    }
    
}
