/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import helpers.Helpers;
import java.awt.BorderLayout;
import views.components.MenuApp;
/**
 *
 * @author aarongmx
 */
public class InicioUsuario extends JFrame {

    public InicioUsuario() throws HeadlessException {
        super("Inicio | " + config.Configuration.APP_NAME);
        initView();
    }

    private void initView() {
        Helpers.minScreenSize(this);
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.CENTER, helpers.Helpers.logoItiz(400));
        Helpers.centerCloseScreen(this);
    }
    
    
    
}
