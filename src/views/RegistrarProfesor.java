/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.components.FlatButton;
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
    
    private FlatTextField txfNoContrato;
    private FlatTextField txfNombre;
    private FlatTextField txfApellidoPaterno;
    private FlatTextField txfApellidoMaterno;
    private FlatTextField txfEspecialidad;
    
    private JDateChooser jdtcFechaIngreso;
    
    private FlatComboBox cmbGradoEstudio;
    private FlatComboBox cmbEstatusProfesor;
    
    private FlatButton btnRegistrar;
    
    private String headerTitle;
        
    public RegistrarProfesor() {
        initView();
    }
    
    public RegistrarProfesor(String headerTitle) {
        this.headerTitle = headerTitle;
        initView();
    }

    private void initView() {
        helpers.Helpers.minScreenSize(this);
        initComponents();
        setJMenuBar(new MenuApp());
        getContentPane().add(BorderLayout.NORTH, new HeaderApp(headerTitle));
        getContentPane().add(BorderLayout.CENTER, pnlForm);
        helpers.Helpers.centerCloseScreen(this);
    }
    
    private void initComponents() {
        pnlForm = new JPanel(new GridBagLayout());
                
        txfNoContrato = new FlatTextField();
        txfNombre = new FlatTextField();
        txfApellidoMaterno = new FlatTextField();
        txfApellidoPaterno = new FlatTextField();
        txfEspecialidad = new FlatTextField();
        
        jdtcFechaIngreso = new JDateChooser();
        
        cmbGradoEstudio = new FlatComboBox(new String[]{"Licenciatura", "Ingeniería", "Maestria", "Doctorado"});
        cmbEstatusProfesor = new FlatComboBox(new String[]{"Tiempo Completo", "Clave 10", "Clave 20", "Clave 95", "Por Horario", "Por Asignatura"});
        
        btnRegistrar = new FlatButton("Registrar");
        
        helpers.Helpers.setWhite(pnlForm);
        
        initForm();
    }
    
    private void initForm() {
        GridBagConstraints c = new GridBagConstraints();
        Insets mt = new Insets(16, 8, 0, 0);
        
        jdtcFechaIngreso.setPreferredSize(new Dimension(180, 28));
        jdtcFechaIngreso.setFont(helpers.Typography.addFont("Open Sans", "pr"));
        txfEspecialidad.setFont(helpers.Typography.addFont("Open Sans", "pr"));
                
        c.insets = mt;
        c.anchor = GridBagConstraints.WEST;
        
        c.gridy = 0;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Número de trabajador"), c);
        c.gridx = 1;
        pnlForm.add(txfNoContrato, c);


        c.gridy = 1;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Estatus de Contrato"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(cmbEstatusProfesor, c);
        
        c.gridy = 2;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Nombres"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfNombre, c);
        
        c.gridy = 3;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Apellido Paterno"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfApellidoPaterno, c);
        
        c.gridy = 4;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Apellido Materno"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfApellidoMaterno, c);
        
        c.gridy = 5;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Fecha de Ingreso"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(jdtcFechaIngreso, c);
        
        c.gridy = 6;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Grado de estudios"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(cmbGradoEstudio, c);
        
        c.gridy = 7;
        c.gridx = 0;
        pnlForm.add(new FlatLabel("Áreas de especialidad"), c);
        c.gridx = GridBagConstraints.RELATIVE;
        pnlForm.add(txfEspecialidad, c);
        
        
        c.gridy = GridBagConstraints.RELATIVE;
        c.gridwidth = 2;
        c.gridx = 1;
        pnlForm.add(btnRegistrar, c);
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }
    
    public FlatTextField getTxfNoContrato() {
        return txfNoContrato;
    }

    public void setTxfNoContrato(FlatTextField txfNoContrato) {
        this.txfNoContrato = txfNoContrato;
    }

    public FlatTextField getTxfNombre() {
        return txfNombre;
    }

    public void setTxfNombre(FlatTextField txfNombre) {
        this.txfNombre = txfNombre;
    }

    public FlatTextField getTxfApellidoPaterno() {
        return txfApellidoPaterno;
    }

    public void setTxfApellidoPaterno(FlatTextField txfApellidoPaterno) {
        this.txfApellidoPaterno = txfApellidoPaterno;
    }

    public FlatTextField getTxfApellidoMaterno() {
        return txfApellidoMaterno;
    }

    public void setTxfApellidoMaterno(FlatTextField txfApellidoMaterno) {
        this.txfApellidoMaterno = txfApellidoMaterno;
    }

    public FlatTextField getTxfEspecialidad() {
        return txfEspecialidad;
    }

    public void setTxfEspecialidad(FlatTextField txfEspecialidad) {
        this.txfEspecialidad = txfEspecialidad;
    }
    
    public JDateChooser getJdtcFechaIngreso() {
        return jdtcFechaIngreso;
    }

    public void setJdtcFechaIngreso(JDateChooser jdtcFechaIngreso) {
        this.jdtcFechaIngreso = jdtcFechaIngreso;
    }

    public FlatComboBox getCmbGradoEstudio() {
        return cmbGradoEstudio;
    }

    public void setCmbGradoEstudio(FlatComboBox cmbGradoEstudio) {
        this.cmbGradoEstudio = cmbGradoEstudio;
    }

    public FlatComboBox getCmbEstatusProfesor() {
        return cmbEstatusProfesor;
    }

    public void setCmbEstatusProfesor(FlatComboBox cmbEstatusProfesor) {
        this.cmbEstatusProfesor = cmbEstatusProfesor;
    }

    public FlatButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(FlatButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }    
}
