/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatTextField;
import views.components.HeaderApp;
import views.components.MenuApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.HeadlessException;


/**
 *
 * @author aarongmx
 */
public class RegistrarResidente extends JFrame {

    private JPanel pnlForm;
    
    private FlatTextField nombre;
    private FlatTextField noControl;
    private FlatTextField domicilio;
    private FlatTextField email;
    private FlatTextField noSeguro;
    private FlatTextField ciudad;
    private FlatTextField telefono;
    
    private FlatComboBox carrera;
    
    private FlatButton btnRegistrar;

    public RegistrarResidente() throws HeadlessException {
        super("Registrar Residente | " + config.Configuration.APP_NAME);
        initView();
    }

    private void initView() {
        helpers.Helpers.minScreenSize(this);
        initComponents();
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.NORTH, new HeaderApp("Registrar Residente"));
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        nombre = new FlatTextField();
        noControl = new FlatTextField();
        domicilio = new FlatTextField();
        email = new FlatTextField();
        noSeguro = new FlatTextField();
        ciudad = new FlatTextField();
        telefono = new FlatTextField();
        
        carrera = new FlatComboBox();
        
        btnRegistrar = new FlatButton("Registrar");
    }
    
    private void initForm() {
        
    }
    
}
