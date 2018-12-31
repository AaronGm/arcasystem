/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.components.FlatCheckbox;
import views.components.FlatLabel;
import views.components.HeaderApp;

/**
 *
 * @author aarongmx
 */
public class RegistrarExpediente extends JFrame {
    
    private JPanel pnlForm;
    
    private FlatCheckbox cartaInicio;
    private FlatCheckbox asesorias;
    private FlatCheckbox cronograma;
    private FlatCheckbox formato008;
    private FlatCheckbox formato009;
    private FlatCheckbox cartaTermino;
    private FlatCheckbox discos;
    private FlatCheckbox cartaLiberacion;
    private FlatLabel estatus;

    public RegistrarExpediente() throws HeadlessException {
        initView();
    }

    private void initView() {
        setMinimumSize(helpers.Helpers.MINIMO_PANTALLA);
        getContentPane().setBackground(Color.white);
        initComponents();
        add(BorderLayout.NORTH, new HeaderApp("Registrar Expediente"));
        add(BorderLayout.CENTER, pnlForm);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        pnlForm = new JPanel(new GridBagLayout());
        pnlForm.setBackground(Color.white);
        
        cartaInicio = new FlatCheckbox("Carta de Inicio");
        asesorias = new FlatCheckbox();
        cronograma = new FlatCheckbox();
        formato008 = new FlatCheckbox();
        formato009 = new FlatCheckbox();
        cartaTermino = new FlatCheckbox();
        discos = new FlatCheckbox();
        cartaLiberacion = new FlatCheckbox();
        estatus = new FlatLabel();
        
        initForm();
    }
    
    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();
        
        pnlForm.add(cartaInicio, c);
    }
    
    
}
