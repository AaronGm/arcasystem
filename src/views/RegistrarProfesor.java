/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.components.FlatComboBox;
import views.components.FlatLabel;
import views.components.FlatTextField;
import views.components.HeaderApp;
import views.components.MenuApp;

/**
 *
 * @author aarongmx
 */
public class RegistrarProfesor extends JFrame {
    
    private JPanel pnlForm;
    private FlatTextField txfNombre;
    private FlatTextField txfApellidoPaterno;
    private FlatTextField txfApellidoMaterno;
    
    private JDateChooser jdtcFechaIngreso;
    
    private FlatComboBox cmbGradoEstudio;
    private FlatComboBox cmbEstatusProfesor;
    
    
    public RegistrarProfesor() {
        initView();
    }

    private void initView() {
        helpers.Helpers.minScreenSize(this);
        initComponents();
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.NORTH, new HeaderApp("Registrar profesor"));
        getContentPane().add(BorderLayout.CENTER, pnlForm);
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        pnlForm = new JPanel();
        
        txfNombre = new FlatTextField();
        txfApellidoMaterno = new FlatTextField();
        txfApellidoPaterno = new FlatTextField();
        
        jdtcFechaIngreso = new JDateChooser();
        
        cmbGradoEstudio = new FlatComboBox();
        cmbEstatusProfesor = new FlatComboBox();
        
        helpers.Helpers.setWhite(pnlForm);
        
        initForm();
    }
    
    private void initForm() {
        jdtcFechaIngreso.setPreferredSize(new Dimension(160, 28));
        jdtcFechaIngreso.setFont(helpers.Typography.addFont("Open Sans", "pr"));
        pnlForm.add(new FlatLabel("Nombres"));
        pnlForm.add(txfNombre);
        pnlForm.add(new FlatLabel("Apellido Paterno"));
        pnlForm.add(txfApellidoPaterno);
        pnlForm.add(new FlatLabel("Apellido Materno"));
        pnlForm.add(txfApellidoMaterno);
        pnlForm.add(new FlatLabel("Fecha de Ingreso"));
        pnlForm.add(jdtcFechaIngreso);
        
    }
    
}
