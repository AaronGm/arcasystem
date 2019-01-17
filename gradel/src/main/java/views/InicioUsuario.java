/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.Helpers;
import views.components.MenuApp;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
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
