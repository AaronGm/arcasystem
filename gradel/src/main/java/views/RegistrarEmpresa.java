/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import helpers.Helpers;
import views.components.FlatButton;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatTextField;
import views.components.HeaderApp;
import views.components.MenuApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

/**
 *
 * @author aarongmx
 */
public class RegistrarEmpresa extends JFrame {
    
    private JPanel pnlForm;
    private JScrollPane scrollPane;
    
    private FlatTextField txfNombre;
    private FlatTextField txfRFC;
    private FlatTextField txfDomicilio;
    private FlatTextField txfColonia;
    private FlatTextField txfCP;
    private FlatTextField txfFax;
    private FlatTextField txfCiudad;
    private FlatTextField txfTelCelular;
    private JTextArea txaMisionEmpresa;
    private FlatTextField txfTitularEmpresa;
    private FlatTextField txfPuestoTitular;
    private FlatTextField txfAsesorExterno;
    private FlatTextField txfPuestoAsesorExterno;
    private FlatTextField txfPersonaAcuerdoTrabajo;
    private FlatTextField txfPuestoPersonaAcuerdoTrabajo;
    
    private FlatComboBox cmbGiro;
    
    private FlatButton btnNext;
    
    

    public RegistrarEmpresa() throws HeadlessException {
        super("Registrar empresa | " + config.Configuration.APP_NAME);
        initView();
    }

    private void initView() {
        helpers.Helpers.minScreenSize(this);
        initComponents();
        initForm();
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.NORTH, new HeaderApp("Registrar Empresa"));
        getContentPane().add(BorderLayout.CENTER, scrollPane);
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        pnlForm = new JPanel();
        pnlForm.setLayout(new GridBagLayout());
        pnlForm.setBackground(Color.white);
        pnlForm.setBorder(Helpers.padding(16, 32));
        
        scrollPane = new JScrollPane(pnlForm);
        scrollPane.setBorder(null);
        scrollPane.getHorizontalScrollBar().setValue(20);
        
        
        cmbGiro = new FlatComboBox(new String[] { "Industrial", "Servicios", "Otro", "Público", "Privado" });
        
        txfNombre = new FlatTextField();
        txfRFC = new FlatTextField();
        txfDomicilio = new FlatTextField();
        txfColonia = new FlatTextField();
        txfCP = new FlatTextField();
        txfFax = new FlatTextField();
        txfCiudad = new FlatTextField();
        txfTelCelular = new FlatTextField();
        txaMisionEmpresa = new JTextArea(8, 20);
        txfTitularEmpresa = new FlatTextField();
        txfPuestoTitular = new FlatTextField();
        txfAsesorExterno = new FlatTextField();
        txfPuestoAsesorExterno = new FlatTextField();
        txfPersonaAcuerdoTrabajo = new FlatTextField();
        txfPuestoPersonaAcuerdoTrabajo = new FlatTextField();
        btnNext = new FlatButton("Siguiente");
    }
    
    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();
        
        txaMisionEmpresa.setLineWrap(true);
        txaMisionEmpresa.setWrapStyleWord(true);
        
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(4, 8, 4, 8);
        pnlForm.add(new FlatLabel("Nombre de la empresa"), c);
        pnlForm.add(new FlatLabel("Giro, Ramo o Sector"), c);

        c.gridy = 1;
        pnlForm.add(txfNombre, c);
        pnlForm.add(cmbGiro, c);
        
        c.gridy = 2;
        pnlForm.add(new FlatLabel("R.F.C"), c);
        pnlForm.add(new FlatLabel("Domicilio"), c);
        
        c.gridy = 3;
        pnlForm.add(txfRFC, c);
        pnlForm.add(txfDomicilio, c);
        
        c.gridy = 4;
        pnlForm.add(new FlatLabel("Colonia"), c);
        pnlForm.add(new FlatLabel("C.P"), c);
        
        c.gridy = 5;
        pnlForm.add(txfColonia, c);
        pnlForm.add(txfCP, c);
        
        c.gridy = 6;
        pnlForm.add(new FlatLabel("Fax"), c);
        pnlForm.add(new FlatLabel("Ciudad"), c);
        
        c.gridy = 7;
        pnlForm.add(txfFax, c);
        pnlForm.add(txfCiudad, c);
        
        c.gridy = 8;
        pnlForm.add(new FlatLabel("Teléfono"), c);
        pnlForm.add(new FlatLabel("Misión de la empresa"), c);
        
        c.gridy = 9;
        c.anchor = GridBagConstraints.NORTH;
        pnlForm.add(txfTelCelular, c);
        pnlForm.add(txaMisionEmpresa, c);
        
        c.gridy = 10;
        c.anchor = GridBagConstraints.WEST;
        pnlForm.add(new FlatLabel("Nombre del titular de la empresa"), c);
        pnlForm.add(new FlatLabel("Puesto del titular"), c);
        
        c.gridy = 11;
        pnlForm.add(txfTitularEmpresa, c);
        pnlForm.add(txfPuestoTitular, c);
        
        c.gridy = 12;
        pnlForm.add(new FlatLabel("Nombre del (la) Asesor(a) Externo(a)"), c);
        pnlForm.add(new FlatLabel("Puesto del (la) Asesor(a) Externo(a)"), c);
        
        c.gridy = 13;
        pnlForm.add(txfAsesorExterno, c);
        pnlForm.add(txfPuestoAsesorExterno, c);
        
        c.gridy = 14;
        pnlForm.add(new FlatLabel("Nombre de la persona que firmará el arcuerdo de trabajo"), c);
        pnlForm.add(new FlatLabel("Puesto de la persona que firmará el arcuerdo de trabajo"), c);
        
        c.gridy = 15;
        pnlForm.add(txfPersonaAcuerdoTrabajo, c);
        pnlForm.add(txfPuestoPersonaAcuerdoTrabajo, c);
        
        c.gridy = 16;
        c.gridwidth = 2;
        pnlForm.add(btnNext, c);
        
    }
    
    
   
}
