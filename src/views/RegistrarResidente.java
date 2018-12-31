/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import views.components.FlatComboBox;
import views.components.FlatTextField;
import views.components.HeaderApp;
import views.components.MenuApp;

/**
 *
 * @author aarongmx
 */
public class RegistrarResidente extends JFrame {
    
    private FlatTextField nombre;
    private FlatTextField noControl;
    private FlatTextField domicilio;
    private FlatTextField email;
    private FlatTextField noSeguro;
    private FlatTextField ciudad;
    private FlatTextField telefono;
    
    private FlatComboBox carrera;

    public RegistrarResidente() throws HeadlessException {
        super("Registrar Residente | " + config.Configuration.APP_NAME);
        initView();
    }

    private void initView() {
        setJMenuBar(new MenuApp());
        setMinimumSize(helpers.Helpers.MINIMO_PANTALLA);
        initComponents();
        getContentPane().setBackground(Color.white);
        getContentPane().add(BorderLayout.NORTH, new HeaderApp("Registrar Residente"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
    }
    
    private void initForm() {
        
    }
    
}
